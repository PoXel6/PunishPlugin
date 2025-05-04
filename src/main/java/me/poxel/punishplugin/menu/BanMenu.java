package me.poxel.punishplugin.menu;

import me.poxel.punishplugin.api.menu.BaseMenu;
import me.poxel.punishplugin.config.Configuration;
import net.kyori.adventure.text.Component;


public class BanMenu extends BaseMenu {

	//		for (List<String> list : Configuration.getPunishments()) {
	//		logPunishmentDetails(list);
	//		final var lore = (Component) List.of(
	//				Component.text("Reason: " + list.get(2)),
	//				Component.text("Duration: " + list.get(3)));
	//		getInventory().addItem(ItemBuilder.from(Material.getMaterial(list.get(0)))
	//		                                  .name(Component.text(list.get(1)))
	//		                                  .lore(lore)
	//		                                  .asGuiItem());
	//	}

	//	private void logPunishmentDetails(List<String> list) {
	//		final var logger = PunishPlugin.getInstance().getSLF4JLogger();
	//		logger.debug("Display Item: {}", list.get(0));
	//		logger.debug("Name: {}", list.get(1));
	//		logger.debug("Reason: {}", list.get(2));
	//		logger.debug("Duration: {}", list.get(3));
	//	}
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
	}

	@Override
	public void setAction() {
	}
}
