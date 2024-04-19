package com.Legend.kits;

import org.bukkit.Material;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;

import com.Legend.kits.manager.Base;
import com.Legend.kits.manager.CooldownAPI;

public class Pyro implements Listener {

	@EventHandler
	public void onInteract(PlayerInteractEvent e) {
		if (e.getAction() == Action.RIGHT_CLICK_AIR && e.getItem() != null && e.getItem().getType() == Material.FIREBALL
				&& Base.qualKit(e.getPlayer()) == "Pyro") {
			e.setCancelled(true);
			Player p = e.getPlayer();
			if (p.getLocation().getY() >= 63) {
				if (!Gladiator.lutando.containsKey(p) && !Gladiator.lutando.containsValue(p)) {
					return;
				}
			}
			if (!(CooldownAPI.SemCooldown(p))) {
				return;
			}
			Fireball ball = e.getPlayer().launchProjectile(Fireball.class);
			ball.setIsIncendiary(false);
			ball.setYield(3.0F);
			CooldownAPI.addCooldown(p, 10);
			CooldownAPI.mCooldown(p, "Pyro");
		}
	}

	@EventHandler
	public void FireBall(EntityDamageByEntityEvent e) {
		if (e.getDamager() instanceof Fireball && e.getEntity() instanceof Player) {
			Fireball a = (Fireball)e.getDamager();
			if (Base.qualKit((Player)a.getShooter()) == "Pyro") {
				e.setDamage(8.0D);
			}
		}
	}

}
