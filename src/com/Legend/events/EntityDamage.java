package com.Legend.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

import com.Legend.kits.manager.Base;

public class EntityDamage implements Listener {

	@EventHandler
	public void normal(EntityDamageEvent e) {
		if(e.getEntity() instanceof Player) {
			Player p = (Player)e.getEntity();
			if(Base.temKit(p) == false) {
				e.setCancelled(true);
			}
		}
	}
}
