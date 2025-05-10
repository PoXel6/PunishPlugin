package me.poxel.punishplugin.menu;

import dev.triumphteam.gui.guis.Gui;
import org.bukkit.entity.Player;


public abstract class SimpleMenu implements Menu {


	private Gui inventory;

	@Override
	public void open(final Player player) {
		inventory = Gui.gui().title(getTitle()).rows(getRows()).create();
		setMenuItem();
		inventory.open(player);
		setAction();
	}

	@Override
	public void setAction() {
		getInventory().setDefaultClickAction(event -> {
			if (event.getCurrentItem() == null)
				return;
			event.setCancelled(true);
		});
	}

	@Override
	public Gui getInventory() {
		return inventory;
	}
}