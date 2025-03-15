package me.poxel.punishplugin.punishment;

import lombok.Getter;
import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.joda.time.Duration;


@Getter
public class PunishmentBuilder {
	private Duration duration;
	private Component reason;
	private Material displayItem;
	private PunishmentType mode;

	public PunishmentBuilder setDuration(final Duration duration) {
		this.duration = duration;
		return this;
	}

	public PunishmentBuilder setReason(final Component reason) {
		this.reason = reason;
		return this;
	}

	public PunishmentBuilder setDisplayItem(final Material displayItem) {
		this.displayItem = displayItem;
		return this;
	}

	public PunishmentBuilder setMode(final PunishmentType mode) {
		this.mode = mode;
		return this;
	}

	public Punishment build() {
		return null;
	}
}
