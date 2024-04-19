package com.Legend.kits;

import java.util.HashMap;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.Legend.kits.manager.Base;

public class TankUp implements Listener {

	public static HashMap<Player, String> lvl = new HashMap<>();

	@EventHandler
	public void TankUp1(PlayerDeathEvent e) {
		if (e.getEntity() instanceof Player) {
			Player p = (Player) e.getEntity();
			if (Base.qualKit(p) == "Tankup") {
				lvl.remove(p);
			}
			if (e.getEntity().getKiller() instanceof Player) {
				Player k = e.getEntity().getKiller();
				if (Base.qualKit(k) == "TankUp") {
					if (!(lvl.containsKey(k))) {
						lvl.put(k, "1");
					}
					if (lvl.get(k) == "1") {
						lvl.remove(k);
						lvl.put(k, "2");
					} else if (lvl.get(k) == "2") {
						k.getInventory().setChestplate(new ItemStack(Material.IRON_CHESTPLATE));
						lvl.remove(k);
						lvl.put(k, "3");
					} else if (lvl.get(k) == "3") {
						lvl.remove(k);
						lvl.put(k, "4");
					} else if (lvl.get(k) == "4") {
						lvl.remove(k);
						lvl.put(k, "5");
					} else if (lvl.get(k) == "5") {
						lvl.remove(k);
						lvl.put(k, "6");
						ItemStack peito = new ItemStack(Material.LEATHER_LEGGINGS);
						ItemMeta peito2 = peito.getItemMeta();
						peito2.setDisplayName("§bCalça");
						peito.setItemMeta(peito2);
						k.getInventory().setLeggings(peito);
					}
				}
			}
		}
	}
}
