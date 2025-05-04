package me.poxel.punishplugin.listener;

import io.papermc.paper.event.player.AsyncChatEvent;
import me.poxel.punishplugin.punishment.Mute;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;


public class MuteListener implements Listener {


	@EventHandler
	public void onAsyncChat(AsyncChatEvent event) {
		final var player = event.getPlayer();
		final var messageSignature = event.signedMessage().signature();
		var isMute = Mute.muteList.contains(player);
		if (isMute) {
			event.setCancelled(true);
			if (messageSignature == null)
				return;
			player.deleteMessage(messageSignature);
		}
	}


}
