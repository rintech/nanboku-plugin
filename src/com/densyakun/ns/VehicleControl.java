package com.densyakun.ns;

import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Minecart;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.vehicle.VehicleEnterEvent;
import org.bukkit.util.Vector;

public class VehicleControl implements Listener {

	// トロッコ乗車時処理
	@EventHandler
	public void onEnterVehicle(VehicleEnterEvent ve) {
		if (ve.getVehicle().getType() == EntityType.MINECART && ve.getEntered() instanceof Player) {
			Player player = (Player) ve.getEntered();
			player.sendMessage(ChatColor.GOLD + "手動運転の方法");
			player.sendMessage("左クリック：ブレーキ(押しっぱなし)");
			player.sendMessage("右クリック：加速(押しっぱなしかつ移動中のみ)");
			player.sendMessage(ChatColor.GREEN + "TrainCarts適用区間及び自動運転区間ではこの限りではありません。");
		}
	}

	//トロッコ乗車中のブロック設置を無効にする
	@EventHandler
	public void onBlockPlaceWhenRiding(BlockPlaceEvent pe) {
		if(pe.getPlayer() != null) {
			if(pe.getPlayer().getVehicle() instanceof Minecart) {
				pe.setCancelled(true);
			}
		} else {
			pe.setCancelled(true);
		}
	}

	//トロッコ乗車中のブロック破壊を無効にする
	@EventHandler
	public void onBlockPlaceWhenRiding(BlockBreakEvent be) {
		if(be.getPlayer() != null) {
			if(be.getPlayer().getVehicle() instanceof Minecart) {
				be.setCancelled(true);
			}
		} else {
			be.setCancelled(true);
		}
	}

	// トロッコ（手動運転）
	@EventHandler
	public void onClickBlock(PlayerInteractEvent ie) {
		if(ie.getPlayer().getVehicle() != null && ie.getPlayer().getVehicle() instanceof Minecart) {
			Vector vector = ie.getPlayer().getVehicle().getVelocity();
			switch (ie.getAction()) {
			//トロッコ乗車中に左クリック（ブレーキ）
			case LEFT_CLICK_AIR:
			case LEFT_CLICK_BLOCK:
				double lx = vector.getX();
				if(lx < 0) {
					vector.setX(lx + 0.050);
				} else if(0 < lx) {
					vector.setX(lx - 0.050);
				}

				double ly = vector.getY();
				if(ly < 0) {
					vector.setY(ly + 0.050);
				} else if(0 < ly) {
					vector.setY(ly - 0.050);
				}

				double lz = vector.getZ();
				if(lz < 0) {
					vector.setZ(lz + 0.050);
				} else if(0 < lz) {
					vector.setZ(lz - 0.050);
				}

				ie.getPlayer().getVehicle().getWorld().playSound(ie.getPlayer().getVehicle().getLocation(), Sound.IRONGOLEM_HIT, 1, 0);
				break;

			// トロッコ乗車中に右クリック（加速）
			case RIGHT_CLICK_AIR:
			case RIGHT_CLICK_BLOCK:
				double rx = vector.getX();
				if(rx < 0) {
					vector.setX(rx - 0.030);
				} else if(0 < rx) {
					vector.setX(rx + 0.030);
				}

				double ry = vector.getY();
				if(ry < 0) {
					vector.setY(ry - 0.030);
				} else if(0 < ry) {
					vector.setY(ry + 0.030);
				}

				double rz = vector.getZ();
				if(rz < 0) {
					vector.setZ(rz - 0.030);
				} else if(0 < rz) {
					vector.setZ(rz + 0.030);
				}

				ie.getPlayer().getVehicle().getWorld().playSound(ie.getPlayer().getVehicle().getLocation(), Sound.IRONGOLEM_HIT, 1, 0);
				break;

			default:
				break;
			}
			ie.getPlayer().getVehicle().setVelocity(vector);
			vector = null;
		}
	}
}
