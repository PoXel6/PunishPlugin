package me.poxel.punishplugin.menu;

import me.poxel.punishplugin.api.menu.BaseMenu;
import me.poxel.punishplugin.config.Configuration;
import net.kyori.adventure.text.Component;


public class MuteMenu extends BaseMenu {


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

	}

	@Override
	public void setAction() {

	}
}
