package me.poxel.punishplugin;

import co.aikar.commands.PaperCommandManager;
import lombok.Getter;
import me.poxel.punishplugin.command.PunishCommand;
import me.poxel.punishplugin.config.ConfigManager;
import me.poxel.punishplugin.config.Configuration;
import me.poxel.punishplugin.listener.MuteListener;
import org.bukkit.plugin.java.JavaPlugin;


public final class PunishPlugin extends JavaPlugin {


	@Getter private static PunishPlugin instance;

	@Getter private PaperCommandManager manager;

	@Override
	public void onEnable() {
		this.getLogger().info("Loading PunishPlugin...");
		instance = this;
		loadConfig();
		manager = new PaperCommandManager(this);
		manager.registerCommand(new PunishCommand());
		manager.enableUnstableAPI("help");
		getServer().getPluginManager().registerEvents(new MuteListener(),this);
	}

	private void loadConfig() {
		this.getLogger().info("Loading config...");
		saveDefaultConfig();
		Configuration.loadConfig(this.getConfig());
		ConfigManager.reload(this);
	}
}
