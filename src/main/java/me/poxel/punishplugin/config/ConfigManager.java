package me.poxel.punishplugin.config;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import me.poxel.punishplugin.PunishPlugin;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;


@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ConfigManager {

	public static void reload(PunishPlugin plugin) {
		plugin.reloadConfig();
		Configuration.loadConfig(plugin.getConfig());
	}

	public static Component deserialize(String miniMessage) {
		return MiniMessage.miniMessage().deserialize(miniMessage);
	}
}
