package me.poxel.punishplugin.commandsOld;

import io.papermc.paper.command.brigadier.CommandSourceStack;
import lombok.Getter;
import lombok.RequiredArgsConstructor;


@SuppressWarnings("UnstableApiUsage")
@Getter
@RequiredArgsConstructor
public enum Permission {

	PUNISH("punish.punish"),
	RELOAD("punish.reload"),
	GUI_RELOAD("punish.reload.gui"),
	CONFIG_RELOAD("punish.reload.config"),
	GLOBAL("punish");

	@Getter private final String instance;

	public static boolean hasReloadPermission(CommandSourceStack sender) {
		return sender.getSender().hasPermission(RELOAD.getInstance());
	}

	public static boolean hasGuiReloadPermission(CommandSourceStack sender) {
		return sender.getSender().hasPermission(GUI_RELOAD.getInstance());
	}

	public static boolean hasConfigReloadPermission(CommandSourceStack sender) {
		return sender.getSender().hasPermission(CONFIG_RELOAD.getInstance());
	}

	public static boolean hasPunishPermission(CommandSourceStack sender) {
		return sender.getSender().hasPermission(PUNISH.getInstance());
	}

	public static boolean hasGlobalPermission(CommandSourceStack sender) {
		return sender.getSender().hasPermission(GLOBAL.getInstance());
	}

	public static String getReloadPermission() {
		return RELOAD.getInstance();
	}

	public static String getGuiReloadPermission() {
		return GUI_RELOAD.getInstance();
	}

	public static String getConfigReloadPermission() {
		return CONFIG_RELOAD.getInstance();
	}

	public static String getPunishPermission() {
		return PUNISH.getInstance();
	}

	public static String getGlobalPermission() {
		return GLOBAL.getInstance();
	}

	@Override
	public String toString() {
		return this.instance;
	}
}