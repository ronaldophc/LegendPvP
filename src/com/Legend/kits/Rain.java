package com.Legend.kits;

import org.bukkit.Material;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.scheduler.BukkitRunnable;

import com.Legend.Main;
import com.Legend.kits.manager.Base;
import com.Legend.kits.manager.CooldownAPI;

public class Rain implements Listener {
	@EventHandler
	public void Colocar(PlayerInteractEntityEvent e) {
		Player p = e.getPlayer();
		if (e.getRightClicked() instanceof Player) {
			if (Base.qualKit(p) == "Arrow") {
				if (e.getPlayer().getItemInHand().getType() == Material.ARROW) {
					if(p.getLocation().getY() >= 63) {
						if (!Gladiator.lutando.containsKey(p) && !Gladiator.lutando.containsValue(p)) {
							return;
						}
					}
					e.setCancelled(true);
					Player t = (Player) e.getRightClicked();
					if (!(Base.qualKit(p) == "Nenhum")) {
						if (!(CooldownAPI.SemCooldown(p))) {
							return;
						}
						CooldownAPI.addCooldown(p, 10);
						CooldownAPI.mCooldown(p, "Rain");
						new BukkitRunnable() {
							int delay = 0;

							public void run() {
								delay++;
								Arrow f = (Arrow) t.getWorld().spawnEntity(t.getLocation().add(0, 4, 0),
										EntityType.ARROW);
								new BukkitRunnable() {
									public void run() {
										f.setVelocity(f.getVelocity().multiply(8));
									}
								}.runTaskLater(Main.plugin, 2);
								if (delay >= 20) {
									cancel();
								}
							}
						}.runTaskTimer(Main.plugin, 0, 5);
					}
				}
			}
		}
	}
}
