package com.Legend.kits;

import java.util.ArrayList;

import org.bukkit.Effect;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.player.PlayerInteractEvent;

import com.Legend.kits.manager.Base;
import com.Legend.kits.manager.CooldownAPI;

public class Deshfire implements Listener {

	ArrayList<Player> fall = new ArrayList<>();
	@EventHandler
	public void Usar(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		if (Base.qualKit(p) == "Deshfire") {
			if (e.getAction().name().contains("RIGHT")) {
				if (p.getItemInHand().hasItemMeta() && p.getItemInHand().getItemMeta().hasDisplayName()) {
					if (p.getItemInHand().getItemMeta().getDisplayName().equals("§bDeshfire!")) {
						e.setCancelled(true);
						if(p.getLocation().getY() >= 63) {
							if (!Gladiator.lutando.containsKey(p) && !Gladiator.lutando.containsValue(p)) {
								return;
							}
						}
						if (!(CooldownAPI.SemCooldown(p))) {
							return;
						}
						CooldownAPI.addCooldown(p, 9);
						CooldownAPI.mCooldown(p, "Deshfire");
						fall.add(p);
						p.setVelocity(p.getEyeLocation().getDirection().multiply(3));
						p.getPlayer().getWorld().playEffect(p.getPlayer().getLocation(), Effect.SMOKE, 10, 0);
						for (Entity pertos : p.getNearbyEntities(6.0, 6.0, 6.0)) {
							if (pertos instanceof Player) {
								Player t = (Player) pertos;
								if (!(Base.temKit(t))) {
									t.setFireTicks(20 * 5);
									t.damage(8.0D);
								}
							}
						}
					}
				}
			}
		}
	}

	@EventHandler
	public void DanoQueda(EntityDamageEvent e) {
		if (e.getEntity() instanceof Player) {
			Player p = (Player) e.getEntity();
			if (Base.qualKit(p) == "Deshfire") {
				if (e.getCause().equals(DamageCause.FALL)) {
					if (fall.contains(p)) {
						e.setDamage(6.0);
						fall.remove(p);
					}
				}
			}
		}
	}
}
