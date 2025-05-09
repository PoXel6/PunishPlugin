package me.poxel.punishplugin.menu.punishment;

import dev.triumphteam.gui.guis.Gui;
import me.poxel.punishplugin.PunishPlugin;
import me.poxel.punishplugin.config.Configuration;
import me.poxel.punishplugin.menu.BaseMenu;
import me.poxel.punishplugin.menu.DisplayItems;
import me.poxel.punishplugin.menu.Menu;
import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.entity.Player;

import java.util.Optional;


public final class PunishMenu extends BaseMenu {


	public static void update() {
		var menu = new PunishMenu().getInventory();
		Optional<Gui> optMenu = Optional.of(menu);
		optMenu.ifPresentOrElse(
				Gui::update,
				() -> PunishPlugin.getInstance()
				                  .getLogger().warning("Inventory cannot be null!"));

	}

	@Override
	public int getRows() {
		return 1;
	}

	@Override
	public Component getTitle() {
		return Configuration.getPunishMenuName();
	}

	@Override
	public void setMenuItem() {
		final var banMenuItem = DisplayItems.punishmentMenu(Material.WOODEN_AXE, Configuration.getBanMenuName());
		final var muteMenuItem = DisplayItems.punishmentMenu(Material.NOTE_BLOCK, Configuration.getMuteMenuName());
		getInventory().addItem(banMenuItem);
		getInventory().addItem(muteMenuItem);
	}

	@Override
	public void setAction() {
		super.setAction();
		final int banMenuSlot = 1;
		final int muteMenuSlot = 7;
		setSlotActions(new BanMenu(), banMenuSlot);
		setSlotActions(new MuteMenu(), muteMenuSlot);
	}

	private void setSlotActions(final Menu menu, final int slot) {
		getInventory().addSlotAction(slot, event -> menu.open((Player) event.getWhoClicked()));
	}
}

