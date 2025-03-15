package me.poxel.punishplugin.punishment;

import lombok.Getter;
import lombok.RequiredArgsConstructor;


@Getter
@RequiredArgsConstructor
public enum PunishmentType {
	BAN("BAN"),
	MUTE("MUTE"),
	TEMP_BAN("TEMP_BAN"),
	TEMP_MUTE("TEMP_MUTE"),
	SHADOW_MUTE("SHADOW_MUTE"),
	TEMP_SHADOW_MUTE("TEMP_SHADOW_MUTE"),
	KICK("KICK"),
	WARN("WARN"),
	IP_BAN("IP_BAN"),
	IP_MUTE("IP_MUTE");
	private final String mode;
}
