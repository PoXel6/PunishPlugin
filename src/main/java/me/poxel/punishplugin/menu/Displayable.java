package me.poxel.punishplugin.menu;

import dev.triumphteam.gui.builder.item.ItemBuilder;
import dev.triumphteam.gui.guis.GuiItem;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.Style;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public interface Displayable {


	default List<GuiItem> punishmentsAsItem(ConfigurationSection section) {
		final var listItem = new ArrayList<GuiItem>();
		for (final String key : section.getKeys(true)) {
			final var list = section.getStringList(key);
			final var item = ItemBuilder
					.from(Optional.ofNullable(Material.getMaterial(list.get(0))).orElse(Material.STONE))
					.name(Component.text(list.get(1)).style(Style.style(TextDecoration.BOLD)))
					.lore(Component.text("Reason: " + list.get(2)))
					.lore(Component.text("Duration: " + list.get(3))).asGuiItem();
			listItem.add(item);
		}
		return listItem;
	}


}
