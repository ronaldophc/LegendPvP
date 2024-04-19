package com.Legend.kits;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;

import com.Legend.kits.manager.Base;

public class Resouper implements Listener{

	@EventHandler
	public void aomatar(final PlayerDeathEvent e) {
		if (e.getEntity().getKiller() instanceof Player) {
			final Player p = e.getEntity().getKiller();
			if (Base.qualKit(p) == "Resouper") {
				for (int i = 0; i < 15; ++i) {
					p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.MUSHROOM_SOUP) });
					p.updateInventory();
				}

			}
		}
	}
}
