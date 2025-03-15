package me.poxel.punishplugin.builder;

import org.bukkit.ChatColor;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;


public class ItemBuilder {
	private ItemStack itemStack;
	private ItemMeta  itemMeta;

	public ItemBuilder setName(String name) {
		this.itemMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', name));
		return this;
	}

	public ItemBuilder setLore(List<String> lore) {
		this.itemMeta.setLore(lore);
		return this;
	}

	public ItemStack build() {
		this.itemStack.setItemMeta(itemMeta);
		return itemStack;
	}
}
