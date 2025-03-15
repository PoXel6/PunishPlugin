package me.poxel.punishplugin.commandsOld;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.builder.RequiredArgumentBuilder;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import io.papermc.paper.command.brigadier.CommandSourceStack;
import io.papermc.paper.command.brigadier.Commands;
import io.papermc.paper.command.brigadier.argument.ArgumentTypes;
import io.papermc.paper.command.brigadier.argument.resolvers.selector.PlayerSelectorArgumentResolver;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import me.poxel.punishplugin.menu.PunishMenu;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.Nullable;


@SuppressWarnings("UnstableApiUsage")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PunishCommand extends BaseCommand {


	private static final PunishCommand instance = new PunishCommand();
	@Setter
	@Getter
	private static Player target;
	private CommandContext<CommandSourceStack> ctx;

	public static RequiredArgumentBuilder<CommandSourceStack, PlayerSelectorArgumentResolver> register() {
		var punish = Commands.argument("target", ArgumentTypes.player());
		punish.executes(instance::execute);
		punish.requires(Permission::hasPunishPermission);
		return punish;
	}

	@Override
	public int execute(CommandContext<CommandSourceStack> ctx) {
		this.ctx = ctx;
		var sender = getSender();
		if (isPlayer(sender)) {
			setTarget(resolveTarget());
			openPunishMenu((Player) sender);
			return Command.SINGLE_SUCCESS;
		}
		return ERROR;
	}

	@Override
	public CommandSender getSender() {
		return ctx.getSource().getSender();
	}

	/**
	 * @return the {@link Player} that is passed as <br> an argument to the {@link PunishCommand}. <br> Null if the
	 * player is not available.
	 */
	private @Nullable Player resolveTarget() {
		try {
			var playerResolver = ctx.getArgument("target", PlayerSelectorArgumentResolver.class);
			return playerResolver.resolve(ctx.getSource()).getFirst();
		} catch (CommandSyntaxException e) {
			getSender().sendMessage("Invalid syntax, Try again!");
		}
		return null;
	}

	private void openPunishMenu(final Player sender) {
		new PunishMenu().open(sender);
	}
}