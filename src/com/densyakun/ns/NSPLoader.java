package com.densyakun.ns;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class NSPLoader extends JavaPlugin implements Listener {

	//読み込み動作
	public void onLoad() {
		getLogger().info("[N28thSSPl]プラグインを読み込み中です。");

		//Load Other Classes
		//This Event
		getServer().getPluginManager().registerEvents(this, this);

		//Vehicle Control
		getServer().getPluginManager().registerEvents(new VehicleControl(), this);
	}

	//読み込み動作完了後の動作
	public void onEnable() {
		//LogMessage
		getLogger().info("[N28thSSPl]有効になりました");
	}

	//サーバ終了後の動作
	public void onDisable() {
		getLogger().info("[N28thSSPl]プラグインが無効になりました。");
	}

}
