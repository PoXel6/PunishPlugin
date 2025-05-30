package me.poxel.punishplugin.listener;

import io.papermc.paper.event.player.AsyncChatEvent;
import me.poxel.punishplugin.punishment.Mute;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;


public final class MuteListener implements Listener {


	@EventHandler
	public void onAsyncChat(AsyncChatEvent event) {
		final var player = event.getPlayer();
		final var isMute = Mute.getMuteList().contains(player);
		if (!isMute) {
			return;
		}
		event.setCancelled(true);
		final var messageSignature = event.signedMessage().signature();
		if (messageSignature == null) {
			return;
		}
		player.deleteMessage(messageSignature);
	}


}
