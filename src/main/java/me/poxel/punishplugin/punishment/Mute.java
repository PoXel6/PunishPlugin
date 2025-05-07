package me.poxel.punishplugin.punishment;

import lombok.Getter;
import org.bukkit.entity.Player;

import java.util.LinkedList;
import java.util.List;


public final class Mute implements Punishable {


	@Getter private static final List<Player> muteList = new LinkedList<>();

	@Override
	public void punish() {

	}
}
