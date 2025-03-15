package me.poxel.punishplugin.commandsOld;

import com.mojang.brigadier.context.CommandContext;
import io.papermc.paper.command.brigadier.CommandSourceStack;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;


@SuppressWarnings("UnstableApiUsage")
public interface Command {


	int SUCCESS = com.mojang.brigadier.Command.SINGLE_SUCCESS;

	int ERROR = 0;

	/**
	 * @param sender
	 * 		the sender that is executing the command.
	 *
	 * @return true if the sender is a {@link Player}.
	 */
	boolean isPlayer(CommandSender sender);

	/**
	 * @param sender
	 * 		the sender that is executing the command
	 *
	 * @return true if the sender is a {@link ConsoleCommandSender}.
	 */
	boolean isConsole(CommandSender sender);

	int execute(CommandContext<CommandSourceStack> context);

	/**
	 * @return the {@link CommandSender} that is executing the command.
	 */
	CommandSender getSender();
}
