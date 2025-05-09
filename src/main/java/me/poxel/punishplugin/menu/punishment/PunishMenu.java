package me.poxel.punishplugin.menu.punishment;

import dev.triumphteam.gui.builder.item.ItemBuilder;
import dev.triumphteam.gui.guis.Gui;
import dev.triumphteam.gui.guis.GuiItem;
import me.poxel.punishplugin.PunishPlugin;
import me.poxel.punishplugin.config.Configuration;
import me.poxel.punishplugin.menu.BaseMenu;
import me.poxel.punishplugin.punishment.PunishmentType;
import net.kyori.adventure.text.Component;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Optional;


public final class PunishMenu extends BaseMenu {


	public static void update() {
		var menu = new PunishMenu().getInventory();
		Optional<Gui> optMenu = Optional.of(menu);
		optMenu.ifPresentOrElse(
				Gui::update, () -> PunishPlugin.getInstance().getLogger()
				                               .warning("Inventory cannot be null!"));

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
		final var itemList = new ArrayList<GuiItem>();
		itemList.add(buildMenuButton(PunishmentType.BAN));
		itemList.add(buildMenuButton(PunishmentType.MUTE));
		itemList.forEach(item -> getInventory().addItem(item));
	}

	private GuiItem buildMenuButton(PunishmentType punish) {
		final var lore = String.format("click here to open the %s", punish.getMenu().getTitle());
		return ItemBuilder.from(punish.getItem())
		                  .name(punish.getMenu().getTitle())
		                  .lore(Component.text(lore))
		                  .asGuiItem(event -> {
			                  punish.getMenu().open((Player) event.getWhoClicked());
		                  });
	}
}

