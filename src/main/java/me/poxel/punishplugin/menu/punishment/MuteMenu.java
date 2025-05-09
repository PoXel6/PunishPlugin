package me.poxel.punishplugin.menu.punishment;

import me.poxel.punishplugin.config.Configuration;
import me.poxel.punishplugin.menu.BaseMenu;
import me.poxel.punishplugin.menu.Displayable;
import net.kyori.adventure.text.Component;


public final class MuteMenu extends BaseMenu implements Displayable {


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
		punishmentsAsItem(Configuration.getMutePunishments()).forEach(item -> getInventory().addItem(item));
	}

	@Override
	public void setAction() {

	}
}
