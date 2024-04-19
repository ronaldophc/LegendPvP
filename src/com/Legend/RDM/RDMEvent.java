package com.Legend.RDM;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import com.Legend.kits.manager.Base;

public class RDMEvent extends RDMApi implements Listener {

	@EventHandler
	public void CMD(PlayerCommandPreprocessEvent e) {
		Player p = e.getPlayer();
		if (RDMApi.inRDM.contains(p)) {
			if (!(p.isOp())) {
				if (e.getMessage().startsWith("/rdm")) {
					e.setCancelled(false);
				} else {
					p.sendMessage(Base.prefix + "§7Você só pode executar o comando §c/RDM §7durante o Evento.");
					e.setCancelled(true);
				}
			}
		}
	}

	@EventHandler
	public void sebater(EntityDamageByEntityEvent e) {
		if ((e.getEntity() instanceof Player) & (e.getDamager() instanceof Player)) {
			Player b = (Player) e.getDamager();
			Player p = (Player) e.getEntity();
			if ((RDMApi.inRDM.contains(b)) && (RDMApi.inRDM.contains(p))) {
				if ((RDMApi.inDuelo.contains(p)) || (RDMApi.inDuelo.contains(b))) {
					e.setCancelled(false);
				} else {
					e.setCancelled(true);
				}
			}
			if (RDMApi.inSpec.contains(p) || RDMApi.inSpec.contains(b)) {
				e.setCancelled(true);
			}
		}
	}

	@EventHandler(priority = EventPriority.HIGH)
	public void onMove(PlayerMoveEvent e) {
		Player p = e.getPlayer();
		if (RDMApi.inFreeze.contains(p)) {
			Location from = e.getFrom();
			if (from.getZ() != e.getTo().getZ() && from.getX() != e.getTo().getX()) {
				p.teleport(e.getFrom());
			}
		}
	}

	@EventHandler
	public void ThorUse(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		if (e.getAction().name().contains("RIGHT")) {
			if ((p.getItemInHand().hasItemMeta() && p.getItemInHand().getItemMeta().hasDisplayName())
					&& (e.getPlayer().getItemInHand().getType() == Material.MAGMA_CREAM)) {
				if (inSpec.contains(p)) {
					p.chat("/rdm sair");
					return;
				}
				if (inRDM.contains(p)) {
					if (!(inDuelo.contains(p))) {
						p.chat("/rdm sair");
					}
				}
			}
			if (inRDM.contains(p) || inSpec.contains(p)) {
				if ((p.getItemInHand().hasItemMeta() && p.getItemInHand().getItemMeta().hasDisplayName())
						&& (e.getPlayer().getItemInHand().getType() == Material.SKULL_ITEM)) {
					if (emduel == true) {
						gui(p);
					} else {
						p.sendMessage(Base.prefix + "Espere o Evento iniciar");
					}
				}
			}
		}
	}

	public void gui(Player p) {
		Inventory inv = Bukkit.createInventory(p, 54, "§4Players na §cRDM");
		for (Player on : Bukkit.getOnlinePlayers()) {
			if (Base.qualKit(on) == "RDM") {
				ItemStack item = new ItemStack(Material.SKULL_ITEM, 1, (byte) 3);
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName("§a" + on.getName());
				meta.setLore(Arrays.asList(new String[] { "§fKills: §b" + RDMStatus.getkills(on),
						"§fDerrotas: §b" + RDMStatus.getperdeu(on), "§fWins: §b" + RDMStatus.getwins(on) }));
				item.setItemMeta(meta);

				ItemStack item2 = item;
				SkullMeta meta2 = (SkullMeta) item.getItemMeta();
				meta2.setOwner(on.getName());
				item2.setItemMeta(meta2);

				inv.addItem(item2);
			}
		}
		p.openInventory(inv);
	}

	@EventHandler
	public void Click(InventoryClickEvent e) {
		if (e.getInventory().getTitle().equalsIgnoreCase("§4Players na §cRDM")) {
			ItemStack item = e.getCurrentItem();
			if (e.getCurrentItem() == null)
				return;
			if (item != null && !item.getType().equals(Material.AIR)) {
				e.setCancelled(true);
			}
		}
	}

	@EventHandler
	public void event(EntityDamageEvent e) {
		if ((e.getEntity() instanceof Player) && !(e.getEntity().getLastDamageCause() instanceof Player)) {
			Player p = (Player) e.getEntity();
			if ((RDMApi.inRDM.contains(p))) {
				if ((RDMApi.inDuelo.contains(p))) {
					e.setCancelled(false);
				} else {
					e.setCancelled(true);
				}
			}
			if (RDMApi.inSpec.contains(p)) {
				e.setCancelled(true);
			}
		}
	}
}
