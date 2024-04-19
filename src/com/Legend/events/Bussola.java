package com.Legend.events;


import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import com.Legend.guis.Title;
import com.Legend.kits.manager.Comando;

public class Bussola implements Listener {
	@EventHandler
	public void Interact(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		if ((p.getItemInHand().getType() == Material.COMPASS) && ((e.getAction() == Action.LEFT_CLICK_AIR)
				|| (e.getAction() == Action.LEFT_CLICK_BLOCK) || (e.getAction() == Action.RIGHT_CLICK_BLOCK)
				|| (e.getAction() == Action.RIGHT_CLICK_AIR)) && (Comando.Arena.contains(p))) {
			Boolean found = Boolean.valueOf(false);
			for (int i = 0; i < 500; i++) {
				for (Player e1 : Comando.Arena) {
					if (p.getLocation().distance(e1.getLocation()) > 9.0D) {
						if (Comando.Arena.contains(e1)) {
							p.setCompassTarget(e1.getLocation());
							Title.sendActionBar(p, "§fBussola - §c" + (e1.getName()));
							found = Boolean.valueOf(true);
							break;
						}
					}
				}
				if (found.booleanValue()) {
					break;
				}
			}
			if (!found.booleanValue()) {
				p.sendMessage("§cNenhum jogador encontrado.");
				Title.sendActionBar(p, "§cNenhum jogador encontrado.");
				p.setCompassTarget(new Location(p.getWorld(), 841.0D, 23.0D, -1248.0D));
				e.setCancelled(true);
			}
		}
	}
}
