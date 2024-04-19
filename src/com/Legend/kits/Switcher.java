package com.Legend.kits;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.Legend.kits.manager.Base;
import com.Legend.kits.manager.CooldownAPI;

public class Switcher implements Listener {

	@EventHandler
	public void event(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		if (Base.qualKit(p) == "Switcher") {
			if (e.getAction().name().contains("RIGHT")) {
				if ((p.getItemInHand().hasItemMeta() && p.getItemInHand().getItemMeta().hasDisplayName())
						&& (e.getPlayer().getItemInHand().getType() == Material.SNOW_BALL)) {
					ItemStack item = new ItemStack(Material.SNOW_BALL);
					ItemMeta item2 = item.getItemMeta();
					item2.setDisplayName("§aSwitcher");
					item.setItemMeta(item2);
					p.getInventory().addItem(item);
				}
			}
		}
	}

	@EventHandler
	public void onDamage(EntityDamageByEntityEvent e) {
		if (e.getEntity() instanceof Player && e.getDamager() instanceof Snowball) {
			Snowball snowball = (Snowball) e.getDamager();
			if (snowball.getShooter() instanceof Player) {
				Player p = (Player) snowball.getShooter();
				if (Base.qualKit(p) == "Switcher") {
					if (!(CooldownAPI.SemCooldown(p))) {
						e.setCancelled(true);
						return;
					}
					if((Player)e.getEntity() == p || p.getName().equalsIgnoreCase(e.getEntity().getName())) {
						e.setCancelled(true);
						return;
					}
					if(e.getEntity().getLocation().getY() >= 63) {
						if (!Gladiator.lutando.containsKey(p) && !Gladiator.lutando.containsValue(p)) {
							return;
						}
					}
					Location loc1 = e.getEntity().getLocation().setDirection(p.getLocation().getDirection());
					Location loc2 = p.getLocation().setDirection(e.getEntity().getLocation().getDirection());
					p.teleport(loc1);
					e.getEntity().teleport(loc2);
					CooldownAPI.addCooldown(p, 5);
					CooldownAPI.mCooldown(p, "Switcher");
				}
			}
		}
	}
}
