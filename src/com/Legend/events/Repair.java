package com.Legend.events;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class Repair implements Listener {

	@EventHandler(priority = EventPriority.HIGHEST)
	public void onEntityDamage(EntityDamageEvent e) {
		if (e.getEntity() instanceof Player) {
			Player p = (Player) e.getEntity();
			if (p.getInventory().getChestplate() != null)
				p.getInventory().getChestplate().setDurability((short) 0);
			if (p.getInventory().getBoots() != null)
				p.getInventory().getBoots().setDurability((short) 0);
			if (p.getInventory().getLeggings() != null)
				p.getInventory().getLeggings().setDurability((short) 0);
			if (p.getInventory().getHelmet() != null)
				p.getInventory().getHelmet().setDurability((short) 0);
			if (p.getItemInHand() != null)
				p.getItemInHand().setDurability((short) 0);
			if (p.getItemInHand().getType() != Material.AIR)
				p.getItemInHand().setDurability((short) 0);

		}
	}
	
}
