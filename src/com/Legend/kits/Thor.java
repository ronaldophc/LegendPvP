package com.Legend.kits;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.util.BlockIterator;

import com.Legend.kits.manager.Base;
import com.Legend.kits.manager.CooldownAPI;

public class Thor implements Listener {

	@EventHandler
	public void ThorUse(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		if (Base.qualKit(p) == "Thor") {
			if (e.getAction().name().contains("RIGHT")) {
				if ((p.getItemInHand().hasItemMeta() && p.getItemInHand().getItemMeta().hasDisplayName())
						&& (e.getPlayer().getItemInHand().getType() == Material.GOLD_AXE)) {
					if(p.getLocation().getY() >= 63) {
						if (!Gladiator.lutando.containsKey(p) && !Gladiator.lutando.containsValue(p)) {
							return;
						}
					}
					if (!(CooldownAPI.SemCooldown(p))) {
						return;
					}
					CooldownAPI.addCooldown(p, 5);
					CooldownAPI.mCooldown(p, "Thor");
					BlockIterator iter = new BlockIterator(p, 10);
					Block lastBlock = iter.next();
					while (iter.hasNext()) {
						lastBlock = iter.next();
						if (lastBlock.getType() == Material.AIR) {
							continue;
						}
						break;
					}
					Location loc = lastBlock.getLocation();
					p.getWorld().strikeLightning(loc);
				}
			}
		}
	}
}
