package me.poxel.punishplugin.punishment;

import lombok.Builder;
import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.joda.time.Duration;


@Builder(setterPrefix = "set")
public class PunishmentBuilder {


	private Duration duration;
	private Component reason;
	private Material displayItem;
	private PunishmentType mode;

	@Override
	public String toString() {
		return String.format("Mode: %s\nDuration: %s\nReason: %s", mode, duration, reason);
	}

	public Punishment build() {
		return null;
	}
}
