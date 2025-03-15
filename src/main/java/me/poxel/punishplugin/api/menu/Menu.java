package me.poxel.punishplugin.api.menu;

import dev.triumphteam.gui.guis.Gui;
import net.kyori.adventure.text.Component;
import org.bukkit.entity.Player;


public interface Menu {


	int getRows();

	Component getTitle();

	void setMenuItem();

	void open(Player player);

	void setAction();

	Gui getInventory();

}

