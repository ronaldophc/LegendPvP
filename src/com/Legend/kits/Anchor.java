package com.Legend.kits;

import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import com.Legend.Main;
import com.Legend.kits.manager.Base;

public class Anchor implements Listener {

	@EventHandler
	public void onEntityDamageByEntity(EntityDamageByEntityEvent e) {
		if ((e.getEntity() instanceof Player)) {
			if (!(e.getDamager() instanceof Player)) {
				return;
			}
			Player p = (Player) e.getEntity();
			Player d = (Player) e.getDamager();
			if (Base.qualKit(d) == "Anchor" && (e.getEntity() instanceof LivingEntity)) {
				e.getEntity().setVelocity(new Vector(0, e.getEntity().getVelocity().getY(), 0));
				new BukkitRunnable() {
					public void run() {
						e.getEntity().setVelocity(new Vector(0, e.getEntity().getVelocity().getY(), 0));
					}
				}.runTaskLater(Main.plugin, 1L);
			} else if ((Base.qualKit(p) == "Anchor") && (e.getEntity() instanceof LivingEntity)) {
				e.getEntity().setVelocity(new Vector(0, e.getEntity().getVelocity().getY(), 0));
				new BukkitRunnable() {
					public void run() {
						e.getEntity().setVelocity(new Vector(0, e.getEntity().getVelocity().getY(), 0));
					}
				}.runTaskLater(Main.plugin, 1L);
			}
		}
	}
}
