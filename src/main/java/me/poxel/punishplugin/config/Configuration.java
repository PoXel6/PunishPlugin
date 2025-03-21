package me.poxel.punishplugin.config;

import lombok.Getter;
import me.poxel.punishplugin.PunishPlugin;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.serializer.gson.GsonComponentSerializer;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.slf4j.Logger;

import java.util.ArrayList;
import java.util.List;


public final class Configuration {
	private final static GsonComponentSerializer gson = GsonComponentSerializer.gson();
	private static final Logger logger = PunishPlugin.getInstance().getSLF4JLogger();
	@Getter private static List<List<String>> punishments;
	@Getter private static Component punishMenuName;
	@Getter private static Component BanMenuName;
	@Getter private static Component MuteMenuName;

	public static void loadConfig(FileConfiguration config) {
		punishments = fetchPunishments(config);
		punishMenuName = ConfigManager.deserialize(config.getString("Menus.Punish", "Punish Menu"));
		BanMenuName = ConfigManager.deserialize(config.getString("Menus.Ban", "Ban Menu"));
		MuteMenuName = ConfigManager.deserialize(config.getString("Menus.Mute", "Mute Menu"));
	}

	private static List<List<String>> fetchPunishments(FileConfiguration config) {
		final List<List<String>> punishments = new ArrayList<>();
		final ConfigurationSection punishSection = config.getConfigurationSection("Punishments");
		final var keys = punishSection.getKeys(true);
		keys.forEach(key -> punishments.add(punishSection.getStringList(key)));
		return punishments;
	}
}
