package me.poxel.punishplugin.punishment;

import org.bukkit.entity.Player;


public final class Ban extends PunishmentBuilder implements Punishment {

	@Override
	public void setReason() {

	}

	@Override
	public Player getTarget() {
		return null;
	}

	@Override
	public void setTarget() {

	}

	@Override
	public void setDuration() {

	}

	@Override
	public void setMode() {
		setMode(PunishmentType.BAN);
	}
}