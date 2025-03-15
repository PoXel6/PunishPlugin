package me.poxel.punishplugin.builder;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;


public class PunishMessageBuilder {

	private Player executor;
	private String mode;
	private String target;
	private String duration;
	private String reason;

	public PunishMessageBuilder setMode(String mode) {
		if(mode == null) {
			executor.sendMessage("The Mod for the punishment cannot be Null!");
			return this;
		}
		this.mode = ChatColor.translateAlternateColorCodes('&', mode);
		return this;
	}

	public PunishMessageBuilder setExecutor(Player executor) {
		if(executor == null) {
			System.out.println("Executor is Null");
			return this;
		}
		this.executor = executor;
		return this;
	}

	public PunishMessageBuilder setTarget(String target) {
		if(target == null) {
			executor.sendMessage("Target Player Does not exist!");
			return this;
		}
		this.target = ChatColor.translateAlternateColorCodes('&', target);
		return this;
	}

	public PunishMessageBuilder setDuration(String duration) {
		if(duration == null) {
			executor.sendMessage("The Duration cannot be Null!");
			return this;
		}
		this.duration = ChatColor.translateAlternateColorCodes('&', duration);
		return this;
	}

	public PunishMessageBuilder setReason(String reason) {
		if(reason == null) {
			executor.sendMessage("The Reason cannot be Null!");
		}
		this.reason = ChatColor.translateAlternateColorCodes('&', reason);
		return this;
	}

	public String build() {
		String line         = ChatColor.STRIKETHROUGH + "                                         ";
		String modeLine     = ChatColor.translateAlternateColorCodes('&', "&2&lMode: " + mode);
		String targetLine   = ChatColor.translateAlternateColorCodes('&', "&2&lTarget: " + target);
		String durationLine = ChatColor.translateAlternateColorCodes(
				'&', "&2&lDuration: " + duration);
		String reasonLine   = ChatColor.translateAlternateColorCodes('&', "&2&lReason: " + reason);
		String executorLine =
				ChatColor.translateAlternateColorCodes(
						'&', "&2&lExecutor: " + executor.getDisplayName());
		return line
		       + "\n"
		       + modeLine
		       + "\n"
		       + executorLine
		       + "\n"
		       + targetLine
		       + "\n"
		       + durationLine
		       + "\n"
		       + reasonLine
		       + "\n"
		       + line;
	}
}
