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

	public static void loadConfig(FileConfiguration config) {
		loadMenuNames(config);
		loadPunishments(config);
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

}
