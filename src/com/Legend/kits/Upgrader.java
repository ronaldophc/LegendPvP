package com.Legend.kits;

import java.util.HashMap;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import com.Legend.KD.API;
import com.Legend.kits.manager.Base;

public class Upgrader implements Listener {
	
	public static HashMap<Player, String> upgrade = new HashMap<Player, String>();

	@EventHandler
	public void Upgrader1(PlayerDeathEvent e) {
		if (e.getEntity() instanceof Player) {
			Player p = (Player) e.getEntity();
			if (Base.qualKit(p) == "Upgrader") {
				upgrade.remove(p);
			}
			if (e.getEntity().getKiller() instanceof Player) {
				Player k = e.getEntity().getKiller();
				if (Base.qualKit(k) == "Upgrader") {
					if (!(upgrade.containsKey(k))) {
						upgrade.put(k, "1");
					}
					if (upgrade.get(k) == "1") {
						upgrade.remove(k);
						k.getInventory().setItem(0,
								API.Item(Material.WOOD_SWORD, "§bLvL 1 ", 1, (byte) 0, Enchantment.DAMAGE_ALL, 1));
						upgrade.put(k, "2");
					} else if (upgrade.get(k) == "2") {
						upgrade.remove(k);
						upgrade.put(k, "3");
					} else if (upgrade.get(k) == "3") {
						upgrade.remove(k);
						upgrade.put(k, "4");
					} else if (upgrade.get(k) == "4") {
						upgrade.remove(k);
						upgrade.put(k, "5");
						k.getInventory().setItem(0,
								API.Item(Material.WOOD_SWORD, "§bLvL 2 ", 1, (byte) 0, Enchantment.DAMAGE_ALL, 2));
					} else if (upgrade.get(k) == "5") {
						upgrade.remove(k);
						upgrade.put(k, "6");
					} else if (upgrade.get(k) == "6") {
						upgrade.remove(k);
						upgrade.put(k, "7");
					} else if (upgrade.get(k) == "7") {
						upgrade.remove(k);
						upgrade.put(k, "8");
					} else if (upgrade.get(k) == "8") {
						k.getInventory().setItem(0,
								API.Item(Material.STONE_SWORD, "§bLvL 1 ", 1, (byte) 0, Enchantment.DAMAGE_ALL, 1));
					}
				}
			}
		}
	}

}
