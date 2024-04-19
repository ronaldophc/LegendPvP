package com.Legend.kits;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.inventory.ItemStack;

import com.Legend.kits.manager.Base;
import com.Legend.kits.manager.CooldownAPI;

public class C4 implements Listener {

	public Map<Item, Boolean> tnt_chao = new HashMap<>();
	public Map<Player, Item> bomba = new HashMap<>();

	@EventHandler
	public void Interact(PlayerInteractEvent e) {
		Player p = (Player) e.getPlayer();
		ItemStack item = p.getItemInHand();
		if (e.getAction().name().contains("RIGHT")) {
			if (item.hasItemMeta() && item.getItemMeta().hasDisplayName()) {
				if (item.getItemMeta().getDisplayName().equals("§bC4")) {
					if (p.getLocation().getY() >= 63) {
						if (!Gladiator.lutando.containsKey(p) && !Gladiator.lutando.containsValue(p)) {
							return;
						}
					}
					e.setCancelled(true);
					if (!(CooldownAPI.SemCooldown(p))) {
						return;
					}
					if (!bomba.containsKey(p)) {
						item.setType(Material.STONE_BUTTON);
						Item t = p.getWorld().dropItem(p.getLocation().add(0, 2, 0), new ItemStack(Material.TNT));
						bomba.put(p, t);
						t.setVelocity(p.getEyeLocation().getDirection());
						tnt_chao.put(t, true);
						p.sendMessage(Base.prefix + "§7§lBomba armada!");
					} else if (bomba.containsKey(p)) {
						item.setType(Material.TNT);
						Item t = bomba.get(p);
						t.getWorld().createExplosion(t.getLocation(), 2);
						t.remove();
						p.sendMessage(Base.prefix + "§7§lBomba explodida!");
						tnt_chao.remove(t);
						bomba.remove(p);
						CooldownAPI.addCooldown(p, 10);
						CooldownAPI.mCooldown(p, "C4");
					}
				}
			}
		}
	}

	@EventHandler
	public void pegar(PlayerPickupItemEvent e) {
		if (tnt_chao.containsKey(e.getItem())) {
			e.setCancelled(true);
		}
	}
}
