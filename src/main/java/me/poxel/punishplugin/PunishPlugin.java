package me.poxel.punishplugin;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.PaperCommandManager;
import lombok.Getter;
import me.poxel.punishplugin.command.RootCommand;
import me.poxel.punishplugin.config.ConfigManager;
import me.poxel.punishplugin.config.Configuration;
import org.bukkit.plugin.java.JavaPlugin;


public final class PunishPlugin extends JavaPlugin {


	@Getter private static PunishPlugin instance;

	@Getter private final PaperCommandManager manager = new PaperCommandManager(this);

	@Override
	public void onEnable() {
		this.getLogger().info("Loading PunishPlugin...");
		instance = this;
		loadConfig();
		registerCommands(new RootCommand());
	}

	private void registerCommands(final BaseCommand command) {
		this.getLogger().info("Registering command: " + command.getName());
		this.manager.registerCommand(command);
	}

	@SuppressWarnings("UnstableApiUsage")
	//	private void registerCommand(final LiteralCommandNode<CommandSourceStack> command) {
	//		this.getLifecycleManager().registerEventHandler(LifecycleEvents.COMMANDS, commands -> {
	//			commands.registrar().register(command);
	//		});
	//	}

	private void loadConfig() {
		this.getLogger().info("Loading config...");
		saveDefaultConfig();
		Configuration.loadConfig(this.getConfig());
		ConfigManager.reload(this);
	}
}
