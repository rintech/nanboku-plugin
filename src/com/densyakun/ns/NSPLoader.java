package com.densyakun.ns;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class NSPLoader extends JavaPlugin implements Listener {

	//初期動作
	public void onEnable() {
		//This Event
		getServer().getPluginManager().registerEvents(this, this);

		//Vehicle Control
		getServer().getPluginManager().registerEvents(new VehicleControl(), this);
		getLogger().info("有効になりました");
	}

	public void onDisable() {

	}

	/*
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent je) {
		Server server = getServer();
		Player player = je.getPlayer();
		je.getPlayer().sendMessage(ChatColor.AQUA + "ようこそ" + player.getDisplayName() + "さん！");
		server.broadcastMessage(ChatColor.GOLD + player.getDisplayName() + ChatColor.AQUA + "さんがオンラインになりました。");
		server.broadcastMessage(ChatColor.GOLD + "みなさんで歓迎しましょう！");
	}*/
}
