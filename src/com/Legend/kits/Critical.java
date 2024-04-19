package com.Legend.kits;

import java.util.Random;

import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import com.Legend.kits.manager.Base;

public class Critical implements Listener {

	// NO DAMAGE MANAGER
	public void critical(EntityDamageByEntityEvent e) {
		if (e.getEntity() instanceof Player && e.getDamager() instanceof Player) {
			Player p = (Player) e.getEntity();
			Player d = (Player) e.getDamager();
			if (Base.qualKit(d) == "Critical") {
				if (p.getLocation().getY() >= 63) {
					if (!Gladiator.lutando.containsKey(p) && !Gladiator.lutando.containsValue(p)) {
						return;
					}
				}
				Random r = new Random();
				int c = r.nextInt(100);
				if (c <= 30) {
					e.setDamage(e.getDamage() + 1.0);
					p.getWorld().playEffect(p.getLocation(), Effect.STEP_SOUND, Material.REDSTONE_BLOCK, 10);
				}
			}
		}
	}

}