package me.poxel.punishplugin.commandsOld;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.context.CommandContext;
import io.papermc.paper.command.brigadier.CommandSourceStack;
import io.papermc.paper.command.brigadier.Commands;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import me.poxel.punishplugin.PunishPlugin;
import me.poxel.punishplugin.config.ConfigManager;
import me.poxel.punishplugin.menu.PunishMenu;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;


@NoArgsConstructor(access = AccessLevel.PRIVATE)
@SuppressWarnings("UnstableApiUsage")
public class ReloadCommand {


	private static final int ERROR = 0;

	public static LiteralArgumentBuilder<CommandSourceStack> register() {
		var cmd = new ReloadCommand();

		final var reload = Commands.literal("reload");

		reload.executes(cmd::reloadAll);
		reload.requires(Permission::hasReloadPermission);

		final var reloadConfig = Commands.literal("config").executes(cmd::reloadConfig);
		reloadConfig.requires(Permission::hasConfigReloadPermission);

		final var reloadGui = Commands.literal("gui").executes(cmd::reloadGui);
		reloadGui.requires(Permission::hasGuiReloadPermission);

		reload.then(reloadConfig);
		reload.then(reloadGui);
		return reload;
	}

	private int reloadAll(final CommandContext<CommandSourceStack> ctx) {
		final var success = Command.SINGLE_SUCCESS;
		final var sender = ctx.getSource().getSender();
		return ((reloadConfig(ctx) == success) && (reloadGui(ctx) == success)) ? success : ERROR;
	}

	private int reloadConfig(final CommandContext<CommandSourceStack> ctx) {
		final var sender = ctx.getSource().getSender();
		ConfigManager.reload(PunishPlugin.getInstance());
		sender.sendMessage(Component.text("Config has been reloaded!").color(NamedTextColor.GREEN));
		return Command.SINGLE_SUCCESS;
	}

	private int reloadGui(final CommandContext<CommandSourceStack> ctx) {
		final var sender = ctx.getSource().getSender();
		PunishMenu.update();
		sender.sendMessage(Component.text("Gui has been reloaded!").color(NamedTextColor.GREEN));
		return Command.SINGLE_SUCCESS;
	}
}