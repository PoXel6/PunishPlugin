package me.poxel.punishplugin.command;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.*;
import com.mojang.brigadier.Command;
import me.poxel.punishplugin.PunishPlugin;
import me.poxel.punishplugin.config.ConfigManager;
import me.poxel.punishplugin.menu.PunishMenu;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


@SuppressWarnings("unused")
@CommandAlias("p")
@CommandPermission("punish")
public class RootCommand extends BaseCommand {


	private final int SUCCESS = Command.SINGLE_SUCCESS;
	private final int ERROR = 0;

	@SuppressWarnings("deprecation")
	public RootCommand() {
		super("punish");
	}

	@Default
	@CommandAlias("h")
	@HelpCommand
	@CommandPermission("punish")
	public void onCommand(CommandSender sender) {

	}

	@CommandCompletion("@players")
	@CommandPermission("punish.punish")
	public void onPunish(CommandSender executor, Player target) {
		if (executor instanceof Player player) {
			var message = Component.text("Targeted Player: " + target.displayName()).color(NamedTextColor.RED);
			player.sendMessage(message);
			new PunishMenu().open(player);
		}
	}

	@CommandPermission("punish.reload")
	@CommandAlias("rl")
	@Subcommand("reload")
	@Syntax("")
	@Description("")
	public int onReload(CommandSender sender) {
		return (onReloadConfig(sender) == SUCCESS) && (onReloadGui(sender) == SUCCESS) ? SUCCESS : ERROR;
	}

	@CommandPermission("punish.reload.config")
	@CommandAlias("rl cfg")
	@Subcommand("reload config")
	@Syntax("")
	@Description("")
	public int onReloadConfig(CommandSender sender) {
		ConfigManager.reload(PunishPlugin.getInstance());
		sender.sendMessage(Component.text("Config has been reloaded!").color(NamedTextColor.GREEN));
		return SUCCESS;
	}

	@CommandPermission("punish.reload.gui")
	@CommandAlias("rl gui")
	@Subcommand("reload gui")
	@Syntax("")
	@Description("")
	public int onReloadGui(CommandSender sender) {
		PunishMenu.update();
		sender.sendMessage(Component.text("Gui has been reloaded!").color(NamedTextColor.GREEN));
		return SUCCESS;
	}
}
