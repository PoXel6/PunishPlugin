package me.poxel.punishplugin.punishment;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import me.poxel.punishplugin.menu.SimpleMenu;
import me.poxel.punishplugin.menu.punishment.BanMenu;
import me.poxel.punishplugin.menu.punishment.MuteMenu;
import org.bukkit.Material;


@Getter
@RequiredArgsConstructor
public enum PunishmentType {
	BAN(new BanMenu(), Material.WOODEN_AXE),
	MUTE(new MuteMenu(), Material.NOTE_BLOCK);
	//	TEMP_BAN(),
	//	TEMP_MUTE(),
	//	SHADOW_MUTE(),
	//	TEMP_SHADOW_MUTE(),
	//	KICK(),
	//	WARN(),
	//	IP_BAN(),
	//	IP_MUTE();
	private final SimpleMenu menu;
	private final Material item;
}
