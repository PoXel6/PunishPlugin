package me.poxel.punishplugin.punishment;

import net.kyori.adventure.text.Component;
import org.bukkit.entity.Player;
import org.joda.time.Duration;


public interface Punishment {
	void setReason();

	Component getReason();

	Player getTarget();

	void setTarget();

	Duration getDuration();

	void setDuration();

	void setMode();

	PunishmentType getMode();
}
