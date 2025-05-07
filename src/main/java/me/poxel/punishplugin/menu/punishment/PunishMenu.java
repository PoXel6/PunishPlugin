package me.poxel.punishplugin.menu.punishment;

import dev.triumphteam.gui.builder.item.ItemBuilder;
import dev.triumphteam.gui.guis.Gui;
import dev.triumphteam.gui.guis.GuiItem;
import me.poxel.punishplugin.PunishPlugin;
import me.poxel.punishplugin.config.Configuration;
import me.poxel.punishplugin.menu.BaseMenu;
import me.poxel.punishplugin.menu.Menu;
import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.entity.Player;

import java.util.List;
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
		getInventory().addItem(createMenuItem(Material.WOODEN_AXE, Configuration.getBanMenuName()));
		getInventory().addItem(createMenuItem(Material.NOTE_BLOCK, Configuration.getMuteMenuName()));
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

	private GuiItem createMenuItem(final Material displayItem, final Component name) {
		final var lore = (Component) List.of(Component.text(String.format("click here to open the %s.", name)));
		return ItemBuilder
				.from(displayItem)
				.name(name)
				.lore(lore)
				.glow(true)
				.asGuiItem();
	}

}

