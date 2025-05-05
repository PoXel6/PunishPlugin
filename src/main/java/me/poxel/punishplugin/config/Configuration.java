package me.poxel.punishplugin.config;

import lombok.Getter;
import net.kyori.adventure.text.Component;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;


public final class Configuration {


	@Getter private static List<List<String>> punishments;
	@Getter private static Component punishMenuName;
	@Getter private static Component BanMenuName;
	@Getter private static Component MuteMenuName;
	@Getter private static ConfigurationSection mutePunishments;
	private static ConfigurationSection banPunishments;

	public static void loadConfig(FileConfiguration config) {
		punishMenuName = ConfigManager.deserialize(config.getString("Menus.Punish", "Punish Menu"));
		BanMenuName = ConfigManager.deserialize(config.getString("Menus.Ban", "Ban Menu"));
		MuteMenuName = ConfigManager.deserialize(config.getString("Menus.Mute", "Mute Menu"));
		loadPunishments(config);
	}

	private static List<List<String>> fetchPunishments(FileConfiguration config) {
		final var punishments = new ArrayList<List<String>>();
		final var punishSection = config.getConfigurationSection("Punishments");
		final var keys = punishSection != null
		                 ? punishSection.getKeys(true)
		                 : new HashSet<String>();
		keys.forEach(key -> punishments.add(punishSection != null
		                                    ? punishSection.getStringList(key)
		                                    : new ArrayList<>()));
		return punishments;
	}

	private static void loadPunishments(FileConfiguration config) {
		mutePunishments = config.getConfigurationSection("Punishments.mute");
		banPunishments = config.getConfigurationSection("Punishments.ban");
	}

}
