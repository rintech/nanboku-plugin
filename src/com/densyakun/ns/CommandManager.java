package com.densyakun.ns;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;

public class CommandManager implements Listener {

	/**
	 * @param sender
	 * @param command
	 * @param label
	 * @param args
	 * @return
	 */
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(label.equalsIgnoreCase("nsp")) {
			if (args.length == 0) {
				sender.sendMessage(ChatColor.GREEN + "/nsp (map|kit|join|stats)");
			} else if (args[0].equalsIgnoreCase("admin")) {
				if (sender.isOp()) {
					if (args.length == 1) {
						sender.sendMessage(ChatColor.GREEN + "/dsp admin (load|save|hide|show|mode|whitemode|white|player)");
					} else if(args[1].equalsIgnoreCase("load")) {
						load();
						sender.sendMessage(ChatColor.AQUA + "ロードしました。");
					} else if(args[1].equalsIgnoreCase("save")) {
						save();
						sender.sendMessage(ChatColor.AQUA + "保存しました。");
					} else if(args[1].equalsIgnoreCase("hide")) {
						if (sender instanceof Player) {
							//隠れる機能
						} else {
							
						}
					}
				}
			}
		}
	}
}
