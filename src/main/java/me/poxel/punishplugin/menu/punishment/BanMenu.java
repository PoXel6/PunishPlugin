package me.poxel.punishplugin.menu.punishment;

import me.poxel.punishplugin.config.Configuration;
import me.poxel.punishplugin.menu.BaseMenu;
import me.poxel.punishplugin.menu.DisplayItems;
import net.kyori.adventure.text.Component;


public final class BanMenu extends BaseMenu {


	@Override
	public int getRows() {
		return 6;
	}

	@Override
	public Component getTitle() {
		return Configuration.getBanMenuName();
	}

	@Override
	public void setMenuItem() {
		DisplayItems.punishments(Configuration.getBanPunishments()).forEach(item -> getInventory().addItem(item));
	}

	@Override
	public void setAction() {
	}
}
