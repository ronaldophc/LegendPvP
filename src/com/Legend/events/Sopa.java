package com.Legend.events;

import org.bukkit.Material;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import com.Legend.KD.API;
import com.Legend.kits.manager.Base;

public class Sopa implements Listener {
	@EventHandler
	public void PlayerInteractMushroomSoup(PlayerInteractEvent e) {
		Player player = e.getPlayer();
		ItemStack item = player.getItemInHand();

		if (item.getType() == Material.MUSHROOM_SOUP) {
			if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK
					|| e.getAction().name().contains("RIGHT")) {
				e.setCancelled(true);
				Damageable health = player;
				if (health.getHealth() < 20) {
					if (health.getHealth() + 7.0 <= 20) {
						health.setHealth(health.getHealth() + 7.0);
					} else {
						health.setHealth(health.getMaxHealth());
					}
					if (Base.qualKit(player) == "QuickDroper") {
						player.setItemInHand(new ItemStack(Material.AIR));
					} else {
						player.setItemInHand(API.Item(Material.BOWL, "§cPotinhos", 1, (byte) 0));
					}
				}
				player.updateInventory();
			}
		}
	}
}
