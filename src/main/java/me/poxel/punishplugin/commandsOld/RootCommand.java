package me.poxel.punishplugin.commandsOld;

import com.mojang.brigadier.tree.LiteralCommandNode;
import io.papermc.paper.command.brigadier.CommandSourceStack;
import io.papermc.paper.command.brigadier.Commands;


@SuppressWarnings("UnstableApiUsage")
public class RootCommand {


	public LiteralCommandNode<CommandSourceStack> execute() {
		final var root = Commands.literal("punish");
		root.then(ReloadCommand.register());
		root.then(PunishCommand.register());
		root.requires(sender -> sender.getSender().hasPermission("punish"));
		return root.build();
	}
}