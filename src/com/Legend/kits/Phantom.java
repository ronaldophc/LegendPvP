package com.Legend.kits;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import com.Legend.Main;
import com.Legend.kits.manager.Base;
import com.Legend.kits.manager.CdAPI;
import com.Legend.kits.manager.CooldownAPI;

public class Phantom implements Listener {
	
	@EventHandler
	public void Interact(PlayerInteractEvent e) {
		Player p = (Player)e.getPlayer();
		ItemStack item = p.getItemInHand();
		if (e.getAction().name().contains("RIGHT")) {
			if (item.hasItemMeta() && item.getItemMeta().hasDisplayName()) {
				if (item.getItemMeta().getDisplayName().equals("§bPhantom")) {
					if (Base.qualKit(p) == "Phantom") {
						e.setCancelled(true);
						if(p.getLocation().getY() >= 63) {
							if (!Gladiator.lutando.containsKey(p) && !Gladiator.lutando.containsValue(p)) {
								return;
							}
						}
						if (!(CooldownAPI.SemCooldown(p))) {
							return;
						}
						if (!(CdAPI.SemCooldown(p))) {
							return;
						}
						CooldownAPI.addCooldown(p, 11);
						CooldownAPI.mCooldown(p, "Phantom");
						p.setAllowFlight(true);
						p.sendMessage(Base.prefix + "§fVocê pode voar por 4 segundos.");
						new BukkitRunnable() {
							public void run() {
								p.setAllowFlight(false);
								p.setFlying(false);
								p.sendMessage(Base.prefix + "§cSeu poder de voar foi desativado.");
							}
						}.runTaskLater(Main.getPlugin(), 20 * 4);
					}
				}
			}
		}
	}
}
