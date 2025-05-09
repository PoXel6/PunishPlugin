package me.poxel.punishplugin;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.PaperCommandManager;
import lombok.Getter;
import me.poxel.punishplugin.command.PunishCommand;
import me.poxel.punishplugin.config.ConfigManager;
import me.poxel.punishplugin.config.Configuration;
import me.poxel.punishplugin.listener.MuteListener;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;


public final class PunishPlugin extends JavaPlugin {


	@Getter private static PunishPlugin instance;

	@Getter private PaperCommandManager manager;

	@Override
	public void onEnable() {
		this.getLogger().info("Loading PunishPlugin...");
		instance = this;
		manager = new PaperCommandManager(this);
		manager.enableUnstableAPI("help");
		loadConfig();
		registerCommands(new PunishCommand());
		registerListeners(new MuteListener());
	}

	private void registerListeners(@NotNull Listener... listeners) {
		this.getLogger().info("Loading Listeners...");
		Arrays.stream(listeners).forEach(listener -> {
			getServer().getPluginManager().registerEvents(listener, this);
		});
	}

	private void registerCommands(@NotNull BaseCommand... commands) {
		this.getLogger().info("Loading Commands...");
		Arrays.stream(commands).forEach(command -> manager.registerCommand(command));
	}

	private void loadConfig() {
		this.getLogger().info("Loading config...");
		saveDefaultConfig();
		Configuration.loadConfig(this.getConfig());
		ConfigManager.reload(this);
	}
}
