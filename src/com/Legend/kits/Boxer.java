package com.Legend.kits;

import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import com.Legend.kits.manager.Base;

public class Boxer implements Listener {

	//DAMAGE MANAGER
	public void onEntityDamagebyEntity(EntityDamageByEntityEvent e) {
		if (!(e.getDamager() instanceof Player))
			return;

		if (Base.qualKit((Player) e.getDamager()) == "Boxer") {
			e.setDamage(e.getDamage() + 0.5D);
		}
		if (e.getEntity() instanceof Player && (Base.qualKit((Player) e.getEntity()) == "Boxer")) {
			e.setDamage(e.getDamage() - 0.5D);
		}
	}
}
