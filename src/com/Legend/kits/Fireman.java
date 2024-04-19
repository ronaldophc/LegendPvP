package com.Legend.kits;

import java.util.Random;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerMoveEvent;

import com.Legend.kits.manager.Base;

public class Fireman implements Listener {

	@EventHandler
	public void damage(EntityDamageEvent e) {
		if (e.getEntity() instanceof Player) {
			Player p = (Player) e.getEntity();
			if ((Base.temKit(p) && Base.qualKit(p) == "Fireman") && (e.getCause() == EntityDamageEvent.DamageCause.LAVA
					|| e.getCause() == EntityDamageEvent.DamageCause.FIRE
					|| e.getCause() == EntityDamageEvent.DamageCause.FIRE_TICK)) {
				e.setCancelled(true);
			}
		}
	}

	@EventHandler
	public void veneno(EntityDamageByEntityEvent e) {
		if (e.getDamager() instanceof Player) {
			Player p = (Player) e.getDamager();
			if (Base.temKit(p) && Base.qualKit(p) == "Fireman") {
				if (p.getLocation().getY() >= 63) {
					return;
				}
				Player pl = (Player) e.getEntity();
				if (new Random().nextInt(100) <= 25)
					pl.setFireTicks(100);
			}
		}
	}

	@EventHandler
	public void event(PlayerMoveEvent e) {
		Player p = e.getPlayer();
		if (Base.temKit(p) && Base.qualKit(p) == "Fireman") {
			if ((e.getPlayer().getLocation().getBlock().getType().name().contains("WATER")
					|| e.getPlayer().getEyeLocation().getBlock().getType().name().contains("WATER"))
					&& ((e.getFrom().getBlockX() != e.getTo().getBlockX())
							|| (e.getFrom().getBlockY() != e.getTo().getBlockY())
							|| (e.getFrom().getBlockZ() != e.getTo().getBlockZ()))) {

				p.damage(1D);
			}
		}
	}
}