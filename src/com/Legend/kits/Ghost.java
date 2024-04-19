package com.Legend.kits;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import com.Legend.Main;
import com.Legend.kits.manager.Base;
import com.Legend.kits.manager.CooldownAPI;

public class Ghost implements Listener {


	@EventHandler
	public void Interact(PlayerInteractEvent e) {
		Player p = (Player) e.getPlayer();
		ItemStack item = p.getItemInHand();
		if (e.getAction().name().contains("RIGHT")) {
			if (item.hasItemMeta() && item.getItemMeta().hasDisplayName()) {
				if (item.getItemMeta().getDisplayName().equals("§bGhost")) {
					if (Base.qualKit(p) == "Ghost") {
						e.setCancelled(true);
						if(p.getLocation().getY() >= 63) {
							if (!Gladiator.lutando.containsKey(p) && !Gladiator.lutando.containsValue(p)) {
								return;
							}
						}
						if (!(CooldownAPI.SemCooldown(p))) {
							return;
						}
						CooldownAPI.addCooldown(p, 10);
						CooldownAPI.mCooldown(p, "Ghost");
						for (Player b : Bukkit.getOnlinePlayers()) {
							b.hidePlayer(p);
						}
						p.sendMessage(Base.prefix + "§fVocê está invisivel por 3 segundos.");
						new BukkitRunnable() {
							public void run() {
								for (Player b : Bukkit.getOnlinePlayers()) {
									b.showPlayer(p);
								}
								p.sendMessage(Base.prefix + "§cSua invisibilidade foi desativada.");
							}
						}.runTaskLater(Main.getPlugin(), 50);
					}
				}
			}
		}
	}
}
