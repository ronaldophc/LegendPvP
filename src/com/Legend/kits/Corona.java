package com.Legend.kits;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.scheduler.BukkitRunnable;

import com.Legend.Main;
import com.Legend.kits.manager.Base;
import com.Legend.kits.manager.CdAPI;
import com.Legend.kits.manager.CooldownAPI;

public class Corona implements Listener {

	@EventHandler(priority = EventPriority.HIGH)
	public void onPlayerMove(PlayerMoveEvent e) {
		if (Base.qualKit(e.getPlayer()) == "Corona") {
			Player p = e.getPlayer();
			if(p.getLocation().getY() >= 63) {
				return;
			}
			for (Entity ent : p.getNearbyEntities(2.0D, 2.0D, 2.0D)) {
				if ((ent instanceof Player)) {
					Player n = (Player) ent; 
					Main.getPlugin().getServer().getScheduler().scheduleSyncDelayedTask(Main.getPlugin(),
							new Runnable() {
								public void run() {
									if (Base.temKit(n) && (Base.qualKit(n) != "AntiCorona")) {
										if ((CooldownAPI.SemCooldown(p))) {
											if (n.isSneaking()) {
												CdAPI.addCooldown(p, 2);
												n.damage(0.5D);
												new BukkitRunnable() {

													@Override
													public void run() {
														CdAPI.tirarCooldown(p);
													}
												}.runTaskLater(Main.getPlugin(), 40);
											} else if (!(n.isSneaking())) {
												n.damage(1.5D);
												CdAPI.addCooldown(p, 2);
												new BukkitRunnable() {

													@Override
													public void run() {
														CdAPI.tirarCooldown(p);
													}
												}.runTaskLater(Main.getPlugin(), 40);
											}
										}
									}
								}
							}, 20);
				}
			}
		}
	}
}
