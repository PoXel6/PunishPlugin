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
		punishMenuName = ConfigManager.deserialize(config.getString("Menus.Punish", "Punish Menu"));
		BanMenuName = ConfigManager.deserialize(config.getString("Menus.Ban", "Ban Menu"));
		MuteMenuName = ConfigManager.deserialize(config.getString("Menus.Mute", "Mute Menu"));
	}

	private static void loadPunishments(FileConfiguration config) {
		mutePunishments = config.getConfigurationSection("Punishments.mute");
		banPunishments = config.getConfigurationSection("Punishments.ban");
	}

}
