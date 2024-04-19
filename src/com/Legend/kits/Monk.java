package com.Legend.kits;

import java.util.Random;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;

import com.Legend.kits.manager.Base;
import com.Legend.kits.manager.CooldownAPI;

public class Monk implements Listener {

	@EventHandler
	public void event(PlayerInteractEntityEvent e) {
		if (e.getRightClicked() instanceof Player) {
			Player p = e.getPlayer();
			Player d = (Player) e.getRightClicked();
			if (Base.qualKit(p) == "Monk") {
				if ((p.getItemInHand().hasItemMeta() && p.getItemInHand().getItemMeta().hasDisplayName())
						&& (e.getPlayer().getItemInHand().getType() == Material.BLAZE_ROD)) {
					if(p.getLocation().getY() >= 63) {
						if (!Gladiator.lutando.containsKey(p) && !Gladiator.lutando.containsValue(p)) {
							return;
						}
					}
					if (!(CooldownAPI.SemCooldown(p))) {
						return;
					}
					CooldownAPI.addCooldown(p, 10);
					CooldownAPI.mCooldown(p, "Monk");
					Random r = new Random();
					int a = r.nextInt(31);
					if (a <= 0) {
						a = r.nextInt(31);
					}
					d.getInventory().setItem(a,
							d.getItemInHand());
					d.getInventory().setItemInHand(null);
				}
			}
		}
	}
}