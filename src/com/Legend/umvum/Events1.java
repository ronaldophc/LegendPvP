package com.Legend.umvum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.scheduler.BukkitRunnable;

import com.Legend.Main;
import com.Legend.Comandos.Admin;
import com.Legend.KD.API;
import com.Legend.guis.Title;
import com.Legend.kits.manager.Base;
import com.Legend.warps.Spawn;

public class Events1 extends API1 implements Listener {

	@EventHandler
	public void inte(PlayerInteractEntityEvent e) {
		if (e.getRightClicked() instanceof Player) {
			Player t = (Player) e.getRightClicked();
			Player p = e.getPlayer();
			if (Base.qualKit(p) == "1v1" && Base.qualKit(t) == "1v1") {
				if (!(em1v1.contains(p)) && !(em1v1.contains(t))) {
					if (p.getItemInHand().hasItemMeta() && p.getItemInHand().getItemMeta().hasDisplayName()) {
						if (p.getItemInHand().getItemMeta().getDisplayName().equals("§b§l1v1")) {
							API1.chamar(p, t);
						}
					}
				}
			}
		}
	}

	@EventHandler
	public static void interagirInv(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		if (Base.qualKit(p) == "1v1") {
			if (p.getItemInHand().hasItemMeta() && p.getItemInHand().getItemMeta().hasDisplayName()) {
				if (p.getItemInHand().getItemMeta().getDisplayName().equals("§b§l1V1 §6§lSpeed")) {
					API1.fila(p);
				}
			}
		}
	}

	public static List<Player> a = new ArrayList<>();

	@EventHandler
	public void sair(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		if (Base.qualKit(p) == "1v1") {
			if (!(em1v1.contains(p))) {
				if (p.getItemInHand().hasItemMeta() && p.getItemInHand().getItemMeta().hasDisplayName()) {
					if (p.getItemInHand().getItemMeta().getDisplayName().equals("§b§lInfos §6§l1v1")) {
						Inventory inv = Bukkit.createInventory(p, 54, "§b§lInfos 1v1");

						for (Player on : Bukkit.getOnlinePlayers()) {
							if (Base.qualKit(on) == "1v1") {
								ItemStack item = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
								ItemMeta meta = (SkullMeta) item.getItemMeta();
								meta.setDisplayName("§a§l" + on.getName());
								meta.setLore(Arrays.asList(new String[] { " ", "§7§lKills: " + API1.getkills(on),
										"§7§lMortes: " + API1.getmortes(on), " " }));
								item.setItemMeta(meta);

								ItemStack item2 = item;
								SkullMeta meta2 = (SkullMeta) item.getItemMeta();
								meta2.setOwner(on.getName());
								item2.setItemMeta(meta2);

								inv.addItem(item2);
							}
						}

						inv.setItem(49, API.Item(Material.BOOK_AND_QUILL, "§c1v1", 1, (byte) 0,
								Arrays.asList(new String[] { " ", "§fKills: §b" + API1.getkills(p),
										"§fMortes: §b" + API1.getmortes(p), " " })));
						p.openInventory(inv);
					}
					if (p.getItemInHand().getItemMeta().getDisplayName().equals("§b§lSair")) {
						Title.sendActionBar(p, "§6Você saiu da 1v1.");
						batalhando.remove(p);
						for (PotionEffect effect : p.getActivePotionEffects())
							p.removePotionEffect(effect.getType());
						em1v1.remove(p);
						convidado.remove(p);
						fila.remove(p);
						new BukkitRunnable() {

							@Override
							public void run() {
								Spawn.tpinstaSpawn(p);
								Admin.Atma(p);
							}
						}.runTaskLater(Main.plugin, 10);
					}
				}
			}
		}
	}

	@EventHandler
	public void bater(EntityDamageByEntityEvent e) {
		if ((e.getEntity() instanceof Player) && (e.getDamager() instanceof Player)) {
			Player k = (Player) e.getDamager();
			Player p = (Player) e.getEntity();
			if (Base.qualKit(p) == "1v1") {
				if (!(API1.batalhando.containsKey(p)) && !(API1.batalhando.containsValue(p))) {
					e.setCancelled(true);
				}
				if (!(API1.batalhando.containsKey(k)) && !(API1.batalhando.containsValue(k))) {
					e.setCancelled(true);
				}
			}
		}
	}

	@EventHandler
	public void Comandox1(PlayerCommandPreprocessEvent e) {
		if (batalhando.containsKey(e.getPlayer())) {
			if (!(e.getPlayer().isOp())) {
				e.setCancelled(true);
				e.getPlayer().sendMessage("§cVocê não pode executar comandos durante uma batalha 1v1.");
			}
		}
	}

	@EventHandler
	public void clickInv(InventoryClickEvent e) {
		if (e.getInventory().getName().equalsIgnoreCase("§b§lInfos 1v1")) {
			if (e.getCurrentItem() == null)
				return;
			e.setCancelled(true);
		}
	}
}
