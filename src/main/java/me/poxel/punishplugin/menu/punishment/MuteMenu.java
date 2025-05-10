package me.poxel.punishplugin.menu.punishment;

import me.poxel.punishplugin.config.Configuration;
import me.poxel.punishplugin.menu.DisplayItems;
import me.poxel.punishplugin.menu.SimpleMenu;
import net.kyori.adventure.text.Component;


public final class MuteMenu extends SimpleMenu {


	@Override
	public int getRows() {
		return 6;
	}

	@Override
	public Component getTitle() {
		return Configuration.getMuteMenuName();
	}

	@Override
	public void setMenuItem() {
		DisplayItems.punishments(Configuration.getMutePunishments()).forEach(item -> getInventory().addItem(item));
	}

	@Override
	public void setAction() {

	}
}
