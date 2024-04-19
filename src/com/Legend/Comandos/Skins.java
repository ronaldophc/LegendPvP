package com.Legend.Comandos;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import com.Legend.KD.API;
import com.Legend.events.Combatlog;
import com.Legend.kits.manager.Base;

public class Skins implements Listener, CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if (!(sender instanceof Player)) {
			return true;
		}
		if (cmd.getName().equalsIgnoreCase("tskins")) {
			Player p = (Player) sender;
			if (Combatlog.inCombat(p)) {
				p.sendMessage(Base.prefix + "§cEm combate nao!");
				return true;
			}
			Inventory skins = Bukkit.createInventory(p, 27, "§bEscolha a §6Skin");

			ItemStack item = new ItemStack(Material.SKULL_ITEM, 1, (byte) 3);
			ItemMeta meta = item.getItemMeta();
			meta.setDisplayName("§cRonaldoPHC");
			item.setItemMeta(meta);
			SkullMeta meta2 = (SkullMeta) item.getItemMeta();
			meta2.setOwner("RonaldoPHC");
			item.setItemMeta(meta2);
			skins.setItem(10, item);

			ItemStack item2 = new ItemStack(Material.SKULL_ITEM, 1, (byte) 3);
			ItemMeta meta3 = item.getItemMeta();
			meta3.setDisplayName("§cSKnockT");
			item2.setItemMeta(meta3);
			SkullMeta meta4 = (SkullMeta) item2.getItemMeta();
			meta4.setOwner("SKnockT");
			item2.setItemMeta(meta4);
			skins.setItem(11, item2);

			ItemStack item3 = new ItemStack(Material.SKULL_ITEM, 1, (byte) 3);
			ItemMeta meta5 = item.getItemMeta();
			meta5.setDisplayName("§cDeusMeLivre");
			item3.setItemMeta(meta5);
			SkullMeta meta6 = (SkullMeta) item3.getItemMeta();
			meta6.setOwner("DeusMeLivre");
			item3.setItemMeta(meta6);
			skins.setItem(12, item3);

			ItemStack item4 = new ItemStack(Material.SKULL_ITEM, 1, (byte) 3);
			ItemMeta meta7 = item.getItemMeta();
			meta7.setDisplayName("§cFeromonas");
			item4.setItemMeta(meta7);
			SkullMeta meta8 = (SkullMeta) item4.getItemMeta();
			meta8.setOwner("Feromonas");
			item4.setItemMeta(meta8);
			skins.setItem(13, item4);

			ItemStack item5 = new ItemStack(Material.SKULL_ITEM, 1, (byte) 3);
			ItemMeta meta9 = item.getItemMeta();
			meta9.setDisplayName("§cVenom_Extreme");
			item5.setItemMeta(meta9);
			SkullMeta meta10 = (SkullMeta) item5.getItemMeta();
			meta10.setOwner("Venom_Extreme");
			item5.setItemMeta(meta10);
			skins.setItem(14, item5);

			ItemStack item6 = new ItemStack(Material.SKULL_ITEM, 1, (byte) 3);
			ItemMeta meta11 = item.getItemMeta();
			meta11.setDisplayName("§cMonark");
			item6.setItemMeta(meta11);
			SkullMeta meta12 = (SkullMeta) item6.getItemMeta();
			meta12.setOwner("Monark");
			item6.setItemMeta(meta12);
			skins.setItem(15, item6);

			ItemStack item7 = new ItemStack(Material.SKULL_ITEM, 1, (byte) 3);
			ItemMeta meta13 = item.getItemMeta();
			meta13.setDisplayName("§cBudokkan");
			item7.setItemMeta(meta13);
			SkullMeta meta14 = (SkullMeta) item7.getItemMeta();
			meta14.setOwner("Budokkan");
			item7.setItemMeta(meta14);
			skins.setItem(16, item7);

			skins.setItem(4, API.Item(Material.SNOW_BALL, "§c§lResete sua Skin", 1, (byte)0));
			p.openInventory(skins);
		}
		return false;
	}

	@EventHandler
	public void clickInv(InventoryClickEvent e) {
		if (e.getInventory().getName().startsWith("§bEscolha a §6Skin")) {
			if (e.getWhoClicked() instanceof Player) {
				e.setCancelled(true);
				if (e.getWhoClicked() instanceof Player) {
					Player p = (Player) e.getWhoClicked();
					e.setCancelled(true);
					if (e.getCurrentItem() == null)
						return;
					if (!(e.getCurrentItem().hasItemMeta())) {
						return;
					}
					if (e.getCurrentItem().getType() == null) {
						return;
					}
					if (e.getCurrentItem() != null && !e.getCurrentItem().getType().equals(Material.AIR)) {
						e.setCancelled(true);
					}
					if (e.getCurrentItem().getType() == Material.SNOW_BALL) {
						Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "skin clear " + p.getName().toLowerCase());
					}
					if (e.getCurrentItem().getType() == Material.SKULL_ITEM) {
						p.sendMessage(Base.prefix + "§bVoce mudou sua skin para a do §c§l"
								+ e.getCurrentItem().getItemMeta().getDisplayName() + "§b.");
						if (e.getSlot() == 10) {
							Bukkit.dispatchCommand(Bukkit.getConsoleSender(),
									"skin set " + p.getName().toLowerCase() + " RonaldoPHC");
						} else if (e.getSlot() == 11) {
							Bukkit.dispatchCommand(Bukkit.getConsoleSender(),
									"skin set " + p.getName().toLowerCase() + " SKnockT");
						} else if (e.getSlot() == 12) {
							Bukkit.dispatchCommand(Bukkit.getConsoleSender(),
									"skin set " + p.getName().toLowerCase() + " DeusMeLivre");
						} else if (e.getSlot() == 13) {
							Bukkit.dispatchCommand(Bukkit.getConsoleSender(),
									"skin set " + p.getName().toLowerCase() + " Feromonas");
						} else if (e.getSlot() == 14) {
							Bukkit.dispatchCommand(Bukkit.getConsoleSender(),
									"skin set " + p.getName().toLowerCase() + " Venom_Extreme");
						} else if (e.getSlot() == 15) {
							Bukkit.dispatchCommand(Bukkit.getConsoleSender(),
									"skin set " + p.getName().toLowerCase() + " Monark");
						} else if (e.getSlot() == 16) {
							Bukkit.dispatchCommand(Bukkit.getConsoleSender(),
									"skin set " + p.getName().toLowerCase() + " Budokkan");
						}
						p.updateInventory();
					}
				}
			}
		}
	}
}
