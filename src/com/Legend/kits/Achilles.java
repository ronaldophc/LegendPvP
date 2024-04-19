package com.Legend.kits;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;

import com.Legend.guis.Title;
import com.Legend.kits.manager.Base;

public class Achilles implements Listener {
	
	//DAMAGE MANAGER
	public void onDamage(EntityDamageByEntityEvent e) {
		if (!(e.getEntity() instanceof Player) || !(e.getDamager() instanceof Player)) {
			return;
		}
		Player p = (Player) e.getEntity();
		Player d = (Player) e.getDamager();

		if (Base.qualKit(p) == "Achilles") {
			ItemStack i = d.getItemInHand();
			if (i != null && i.getType().name().contains("WOOD_")) {
				double damage = e.getDamage() + 4.0D;
				boolean hasHelmet = (p.getInventory().getHelmet() != null && p.getInventory().getHelmet().getType() != Material.AIR);
				boolean hasChestplate = (p.getInventory().getChestplate() != null && p.getInventory().getChestplate().getType() != Material.AIR);
				boolean hasLeggings = (p.getInventory().getLeggings() != null && p.getInventory().getLeggings().getType() != Material.AIR);
				boolean hasBoots = (p.getInventory().getBoots() != null && p.getInventory().getBoots().getType() != Material.AIR);
				if (hasHelmet) {
					damage = damage + 1.0D;
				}
				if (hasChestplate) {
					damage = damage + 1.5D;
				}
				if (hasLeggings) {
					damage = damage + 1.5D;
				}
				if (hasBoots) {
					damage = damage + 1.0D;
				}
				e.setDamage(damage);
				Title.sendActionBar(d, "O jogador hitado é um §aAchilles§f!");
			} else if (i != null && !i.getType().name().contains("WOOD_")) {
				if(d.getItemInHand().getType() == Material.AIR) {
					e.setDamage(2.0D);
					return;
				}
				e.setDamage(e.getDamage() - 3.0D);
			}
		}
	}
}
