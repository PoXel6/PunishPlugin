package me.poxel.punishplugin.commandsOld;

import com.mojang.brigadier.context.CommandContext;
import io.papermc.paper.command.brigadier.CommandSourceStack;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.Contract;


@SuppressWarnings("UnstableApiUsage")
public abstract class BaseCommand implements Command {


	private static CommandContext<CommandSourceStack> ctx;

	@Override
	public boolean isPlayer(CommandSender sender) {
		return !isSenderNull(sender) && (sender instanceof Player);
	}

	@Override
	public boolean isConsole(CommandSender sender) {
		return !isSenderNull(sender) && (sender instanceof ConsoleCommandSender);
	}

	/**
	 * @param sender
	 * 		the sender that is executing the command
	 *
	 * @return true if the sender is null
	 */
	@Contract(value = "null -> true; !null -> false", pure = true)
	private boolean isSenderNull(CommandSender sender) {
		return sender == null;
	}
}
