package com.Legend.kits;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;

import com.Legend.kits.manager.Base;
import com.Legend.kits.manager.CooldownAPI;

public class Lifestealer implements Listener {
	@EventHandler
	public void sugar(PlayerInteractEntityEvent e) {
		if (Base.qualKit(e.getPlayer()) == "LifeStealer") {
			Player p = (Player) e.getRightClicked();
			Player d = (Player) e.getPlayer();
			if (d.getItemInHand().getType() == Material.GHAST_TEAR) {
				if(d.getLocation().getY() >= 63) {
					if (!Gladiator.lutando.containsKey(d) && !Gladiator.lutando.containsValue(d)) {
						return;
					}
				}
				if (!(CooldownAPI.SemCooldown(d))) {
					return; 
				}
				p.damage(8);
				if (d.getHealth() > d.getMaxHealth() - 7.0D) {
					d.setHealth(d.getMaxHealth());
				} else {
					d.setHealth(d.getHealth() + 7.0D);
				}
				p.sendMessage(Base.prefix + "§c" + d.getName() + " §7roubou§4 3,5 corações §7seu!");
				d.sendMessage(Base.prefix + "§7Você roubou§4 3,5 corações §7do §c" + p.getName() + "§7.");
				CooldownAPI.addCooldown(d, 5);
				CooldownAPI.mCooldown(p, "Life Stealer");
			}
		}
	}
	@EventHandler
	public void sugar(EntityDamageByEntityEvent e) {
		if (e.getEntity() instanceof Player && e.getDamager() instanceof Player) {
			Player p = (Player) e.getEntity();
			Player d = (Player) e.getDamager();
			if (Base.qualKit(d) == "LifeStealer") {
				if (d.getItemInHand().getType() == Material.GHAST_TEAR) {
					if (p.getLocation().getY() >= 63) {
						return;
					}
					if (!(CooldownAPI.SemCooldown(d))) {
						return;
					}
					p.damage(8);
					if (d.getHealth() > d.getMaxHealth() - 7.0D) {
						d.setHealth(d.getMaxHealth());
					} else {
						d.setHealth(d.getHealth() + 7.0D);
					}
					p.sendMessage(Base.prefix + "§c" + d.getName() + " §7roubou§4 3,5 corações §7seu!");
					d.sendMessage(Base.prefix + "§7Você roubou§4 3,5 corações §7do §c" + p.getName() + "§7.");
					CooldownAPI.addCooldown(d, 5);
					CooldownAPI.mCooldown(p, "Life Stealer");
				}
			}
		}
	}
}
