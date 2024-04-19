package com.Legend.kits;

import java.util.Random;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.Legend.kits.manager.Base;

public class Snail implements Listener {

	@EventHandler
	public void veneno(EntityDamageByEntityEvent e) {
		if (e.getDamager() instanceof Player && e.getEntity() instanceof Player) {
			Player p = (Player) e.getDamager();
			if (Base.temKit(p) && Base.qualKit(p) == "Snail") {
				if(p.getLocation().getY() >= 63) {
					if (!Gladiator.lutando.containsKey(p) && !Gladiator.lutando.containsValue(p)) {
						return;
					}
				}
				Player pl = (Player) e.getEntity();
				if (new Random().nextInt(100) <= 35)
					
					pl.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 5 * 20, 0));
			}
		}
	}
} 