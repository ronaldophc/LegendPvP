package com.Legend.kits;

import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import com.Legend.kits.manager.Base;

public class Neo implements Listener {

	@EventHandler
	public void dano(EntityDamageByEntityEvent e) {
		if (e.getEntity() instanceof Player) {
			Player p = (Player) e.getEntity();
			if (Base.qualKit(p) == "Neo") {
				if(p.getLocation().getY() >= 63) {
					if (!Gladiator.lutando.containsKey(p) && !Gladiator.lutando.containsValue(p)) {
						return;
					}
				}
				if (e.getDamager() instanceof Projectile) {
					e.setDamage(0);
					e.setCancelled(true);
				}
			}
		}
	}
}
