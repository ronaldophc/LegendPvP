package com.Legend.kits;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.scheduler.BukkitRunnable;

import com.Legend.Main;
import com.Legend.Comandos.Admin;
import com.Legend.kits.manager.Base;
import com.Legend.kits.manager.CooldownAPI;

public class Frozen implements Listener {
	public static List<Player> congelado = new ArrayList<>();

	@EventHandler
	public void interact(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		if (Base.qualKit(p) == "Frozen") {
			if (e.getAction().name().contains("RIGHT")) {
				if ((p.getItemInHand().hasItemMeta() && p.getItemInHand().getItemMeta().hasDisplayName())
						&& (e.getPlayer().getItemInHand().getType() == Material.PACKED_ICE)) {
					if (p.getLocation().getY() >= 63) {
						if (!Gladiator.lutando.containsKey(p) && !Gladiator.lutando.containsValue(p)) {
							return;
						}
					}
					if (!(CooldownAPI.SemCooldown(p))) {
						return;
					}
					CooldownAPI.addCooldown(p, 10);
					for (Entity ent : p.getNearbyEntities(3.0D, 3.0D, 3.0D)) {
						if ((ent instanceof Player)) {
							Player n = (Player) ent;
							if (!Admin.inadmin.contains(n)) {
								congelado.add(n);
							}
							n.sendMessage(Base.prefix + "§c§lVOCE FOI CONGELADO PELA FROZEN.");
							new BukkitRunnable() {

								@Override
								public void run() {
									congelado.remove(n);

								}
							}.runTaskLater(Main.getPlugin(), 50);
						}
					}
					CooldownAPI.mCooldown(p, "Frozen");
				}
			}
		}
	}

	@EventHandler
	public void movera(PlayerMoveEvent e) {
		if (congelado.contains(e.getPlayer())) {
			e.setCancelled(true);
		}
	}
}
