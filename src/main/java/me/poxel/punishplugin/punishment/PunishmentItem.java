package me.poxel.punishplugin.punishment;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.bukkit.Material;


@Getter
@RequiredArgsConstructor
public enum PunishmentItem {
	BAN(Material.WOODEN_AXE),
	MUTE(Material.NOTE_BLOCK);

	private final Material item;

}
