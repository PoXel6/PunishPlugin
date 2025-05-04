package me.poxel.punishplugin.punishment;

import org.bukkit.entity.Player;

import java.util.LinkedList;
import java.util.List;


public abstract class Mute implements Punishable {


	public static final List<Player> muteList = new LinkedList<>();
}
