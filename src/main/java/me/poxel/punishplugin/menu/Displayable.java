package me.poxel.punishplugin.menu;

import dev.triumphteam.gui.builder.item.ItemBuilder;
import dev.triumphteam.gui.guis.GuiItem;
import me.poxel.punishplugin.punishment.PunishFields;
import net.kyori.adventure.text.Component;
import org.bukkit.Material;

import java.util.List;
import java.util.Optional;


public interface Displayable {


	default List<GuiItem> createPunishItem(List<List<String>> punish) {
		return punish.stream().map(ban -> {
			final var item = Material.getMaterial(ban.get(PunishFields.ITEM.ordinal()));
			final var name = Component.text(ban.get(PunishFields.NAME.ordinal()));
			final var reason = Component.text("Reason: " + ban.get(PunishFields.REASON.ordinal()));
			final var duration = Component.text("Duration: " + ban.get(PunishFields.DURATION.ordinal()));

			return ItemBuilder.from(Optional.ofNullable(item).orElse(Material.STONE))
			                  .name(Optional.of(name).orElse(Component.text("Name is null")))
			                  .lore(Optional.of(reason).orElse(Component.text("Reason is null")))
			                  .lore(Optional.of(duration).orElse(Component.text("Duration is null")))
			                  .asGuiItem();
		}).toList();
	}


}
