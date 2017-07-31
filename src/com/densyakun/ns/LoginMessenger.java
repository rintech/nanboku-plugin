package com.densyakun.ns;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Server;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class LoginMessenger implements Listener {
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent je) {
		Server server = Bukkit.getServer();
		Player player = je.getPlayer();
		je.getPlayer().sendMessage(ChatColor.AQUA + "ようこそ" + player.getDisplayName() + "さん！");
		server.broadcastMessage(ChatColor.GOLD + player.getDisplayName() + ChatColor.AQUA + "さんがオンラインになりました。");
		server.broadcastMessage(ChatColor.GOLD + "みなさんで歓迎しましょう！");
	}
}