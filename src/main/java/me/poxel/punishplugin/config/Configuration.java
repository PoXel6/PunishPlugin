package me.poxel.punishplugin.config;

import lombok.Getter;
import net.kyori.adventure.text.Component;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;


public final class Configuration {


	@Getter private static Component punishMenuName;
	@Getter private static Component BanMenuName;
	@Getter private static Component MuteMenuName;
	@Getter private static ConfigurationSection mutePunishments;
	@Getter private static ConfigurationSection banPunishments;
	@Getter private static String globalPermission;
	@Getter private static String punishPermission;
	@Getter private static String reloadPermission;
	@Getter private static String reloadConfigPermission;
	@Getter private static String reloadGuiPermission;

	public static void loadConfig(FileConfiguration config) {
		loadMenuNames(config);
		loadPunishments(config);
		loadPermissions(config);
	}

	private static void loadMenuNames(FileConfiguration config) {
		punishMenuName = ConfigManager.deserialize(config.getString("MENU.punish", "Punish Menu"));
		BanMenuName = ConfigManager.deserialize(config.getString("MENU.ban", "Ban Menu"));
		MuteMenuName = ConfigManager.deserialize(config.getString("MENU.mute", "Mute Menu"));
	}

	private static void loadPunishments(FileConfiguration config) {
		mutePunishments = config.getConfigurationSection("PUNISHMENT.mute");
		banPunishments = config.getConfigurationSection("PUNISHMENT.ban");
	}

	private static void loadPermissions(FileConfiguration config) {
		globalPermission = config.getString("punish");
		punishPermission = config.getString("punish.punish");
		reloadPermission = config.getString("punish.reload");
		reloadConfigPermission = config.getString("punish.reload.config");
		reloadGuiPermission = config.getString("punish.reload.gui");
	}

}
