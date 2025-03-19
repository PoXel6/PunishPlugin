package me.poxel.punishplugin.menu;

import dev.triumphteam.gui.builder.item.ItemBuilder;
import dev.triumphteam.gui.guis.Gui;
import me.poxel.punishplugin.PunishPlugin;
import me.poxel.punishplugin.api.menu.BaseMenu;
import me.poxel.punishplugin.api.menu.Menu;
import me.poxel.punishplugin.config.Configuration;
import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.entity.Player;

import java.util.ArrayList;
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
		for (List<String> list : Configuration.getPunishments()) {
			logPunishmentDetails(list);
			var lore = getLore(list);
			getInventory().addItem(ItemBuilder.from(Material.getMaterial(list.get(0)))
			                                  .name(Component.text(list.get(1)))
			                                  .lore(lore)
			                                  .asGuiItem());
		}
	}

	@Override
	public void setAction() {
		super.setAction();
		final int banMenuSlot = 1;
		final int muteMenuSlot = 7;
		setSlotActions(new BanMenu(), banMenuSlot);
		setSlotActions(new MuteMenu(), muteMenuSlot);
	}

	private ArrayList<Component> getLore(final List<String> list) {
		var lore = new ArrayList<Component>();
		lore.add(Component.text("Reason: " + list.get(2)));
		lore.add(Component.text("Duration: " + list.get(3)));
		return lore;
	}

	private void setSlotActions(final Menu menu, final int slot) {
		getInventory().addSlotAction(slot, event -> menu.open((Player) event.getWhoClicked()));
	}

	private void logPunishmentDetails(List<String> list) {
		final var logger = PunishPlugin.getInstance().getSLF4JLogger();
		logger.debug("Display Item: {}", list.get(0));
		logger.debug("Name: {}", list.get(1));
		logger.debug("Reason: {}", list.get(2));
		logger.debug("Duration: {}", list.get(3));
	}
}

