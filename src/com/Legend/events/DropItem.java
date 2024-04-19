package com.Legend.events;

import org.bukkit.Effect;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ItemSpawnEvent;
import org.bukkit.scheduler.BukkitRunnable;

import com.Legend.Main;

public class DropItem implements Listener {
	public static Main plugin;

	public DropItem(Main main) {
		plugin = main;
	}

	@EventHandler
	public void onItemDrop(final ItemSpawnEvent e) {
		new BukkitRunnable() {
			
			@Override
			public void run() {
				e.getEntity().remove();
				e.getLocation().getWorld().playEffect(e.getEntity().getLocation(), Effect.ENDER_SIGNAL, 7);				
			}
		}.runTaskLater(Main.getPlugin(), 0);
	}
	
}
