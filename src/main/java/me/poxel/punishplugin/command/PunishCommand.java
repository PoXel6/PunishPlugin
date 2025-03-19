package me.poxel.punishplugin.command;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.CommandHelp;
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
public final class PunishCommand extends BaseCommand {


	private final int SUCCESS = Command.SINGLE_SUCCESS;
	private final int ERROR = 0;

	@SuppressWarnings("deprecation")
	public PunishCommand() {
		super("punish");
	}

	@Default
	@HelpCommand
	@CommandAlias("h")
	@CommandPermission("punish")
	@Description("Displays the help menu.")
	public void onCommand(CommandSender sender, CommandHelp help) {
		help.showHelp();
	}

	@Syntax("<player>")
	@CommandCompletion("@players")
	@CommandPermission("punish.punish")
	@Description("Punishes the player provided as an argument.")
	public void onPunish(CommandSender executor, Player target) {
		if (executor instanceof Player player) {
			var message = Component.text("Targeted Player: " + target.displayName()).color(NamedTextColor.RED);
			player.sendMessage(message);
			new PunishMenu().open(player);
		}
	}

	@CommandAlias("rl")
	@Subcommand("reload")
	@CommandPermission("punish.reload")
	@Description("reloads gui and config.")
	public int onReload(CommandSender sender) {
		return (onReloadConfig(sender) == SUCCESS) && (onReloadGui(sender) == SUCCESS) ? SUCCESS : ERROR;
	}

	@CommandAlias("rl cfg")
	@Subcommand("reload config")
	@Description("reloads config.")
	@CommandPermission("punish.reload.config")
	public int onReloadConfig(CommandSender sender) {
		ConfigManager.reload(PunishPlugin.getInstance());
		sender.sendMessage(Component.text("Config has been reloaded!").color(NamedTextColor.GREEN));
		return SUCCESS;
	}

	@CommandAlias("rl gui")
	@Subcommand("reload gui")
	@Description("reloads gui.")
	@CommandPermission("punish.reload.gui")
	public int onReloadGui(CommandSender sender) {
		PunishMenu.update();
		sender.sendMessage(Component.text("Gui has been reloaded!").color(NamedTextColor.GREEN));
		return SUCCESS;
	}
}
