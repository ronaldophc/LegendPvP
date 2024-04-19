package com.Legend.kits;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.Legend.kits.manager.Base;

public class Reaper implements Listener {

	@EventHandler
	public void bater(EntityDamageByEntityEvent e) {
		if (e.getDamager() instanceof Player) {
			if (Base.qualKit((Player) e.getDamager()) == "Reaper") {
				Player p = (Player) e.getDamager();
				if (p.getItemInHand().getType() == Material.WOOD_HOE) {
					if(p.getLocation().getY() >= 63) {
						if (!Gladiator.lutando.containsKey(p) && !Gladiator.lutando.containsValue(p)) {
							return;
						}
					}
					Player b = (Player) e.getEntity();
					b.addPotionEffect(new PotionEffect(PotionEffectType.WITHER, 8 * 20, 1));
				}
			}
		}
	}
}
