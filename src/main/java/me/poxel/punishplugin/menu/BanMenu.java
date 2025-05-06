package me.poxel.punishplugin.menu;

import me.poxel.punishplugin.config.Configuration;
import net.kyori.adventure.text.Component;


public class BanMenu extends BaseMenu implements Displayable {


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
		punishmentsAsItem(Configuration.getBanPunishments()).forEach(item -> getInventory().addItem(item));
	}

	@Override
	public void setAction() {
	}
}
