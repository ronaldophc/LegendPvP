package com.Legend.kits;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.Legend.kits.manager.Base;

public class Berserker implements Listener {

	@EventHandler
	public void Berserke1r(PlayerDeathEvent e) {
		if (e.getEntity() instanceof Player) {
			// Player p = (Player) e.getEntity();
			if (e.getEntity().getKiller() instanceof Player) {
				Player k = e.getEntity().getKiller();
				if (Base.qualKit(k) == "Berserker") {
					k.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 120, 0));
				}
			}
		}
	}
}
