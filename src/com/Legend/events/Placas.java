package com.Legend.events;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;

import com.Legend.KD.API;

public class Placas implements Listener {
	@EventHandler
	public void SopaSign(SignChangeEvent e) {
		if (e.getLine(0).equalsIgnoreCase("[Recraft]")) {
			e.setLine(0, "§b§lLegendPvP");
			e.setLine(1, "§f§l>> §c§lRecraft §f§l<<");
			e.setLine(2, "§f§l>>  §c§lGratis  §f§l<<");
		} else if (e.getLine(0).equalsIgnoreCase("[Sopas]")) {
			e.setLine(0, "§b§lLegendPvP");
			e.setLine(1, "§f§l>>  §c§lSopas  §f§l<<");
			e.setLine(2, "§f§l>>  §c§lGratis  §f§l<<");
		} else {
			e.setLine(0, e.getLine(0).replace("&", "§"));
			e.setLine(1, e.getLine(1).replace("&", "§"));
			e.setLine(2, e.getLine(2).replace("&", "§"));
			e.setLine(3, e.getLine(3).replace("&", "§"));
		}
	}

	@EventHandler
	public void Sopa(PlayerInteractEvent e) {
		if (e.getAction() == Action.RIGHT_CLICK_BLOCK && e.getClickedBlock().getState() instanceof Sign) {
			Sign s = (Sign) e.getClickedBlock().getState();
			if (s.getLine(0).equalsIgnoreCase("§b§lLegendPvP")
					&& s.getLine(1).equalsIgnoreCase("§f§l>> §c§lRecraft §f§l<<")
					&& s.getLine(2).equalsIgnoreCase("§f§l>>  §c§lGratis  §f§l<<")) {
				e.setCancelled(true);
				Player p = e.getPlayer();
				Inventory soup = Bukkit.getServer().createInventory((InventoryHolder) p, 36, "§b§lLegendPvP");
				
				soup.setItem(1, API.Item(Material.RED_MUSHROOM, "§cCogu Red", 64, (byte) 0));
				soup.setItem(3, API.Item(Material.BROWN_MUSHROOM, "§cCogu Brown", 64, (byte) 0));
				soup.setItem(2, API.Item(Material.BOWL, "§cPotinhos", 64, (byte) 0));
				soup.setItem(10, API.Item(Material.RED_MUSHROOM, "§cCogu Red", 64, (byte) 0));
				soup.setItem(12, API.Item(Material.BROWN_MUSHROOM, "§cCogu Brown", 64, (byte) 0));
				soup.setItem(11, API.Item(Material.BOWL, "§cPotinhos", 64, (byte) 0));
				soup.setItem(19, API.Item(Material.RED_MUSHROOM, "§cCogu Red", 64, (byte) 0));
				soup.setItem(21, API.Item(Material.BROWN_MUSHROOM, "§cCogu Brown", 64, (byte) 0));
				soup.setItem(20, API.Item(Material.BOWL, "§cPotinhos", 64, (byte) 0));
				soup.setItem(28, API.Item(Material.RED_MUSHROOM, "§cCogu Red", 64, (byte) 0));
				soup.setItem(30, API.Item(Material.BROWN_MUSHROOM, "§cCogu Brown", 64, (byte) 0));
				soup.setItem(29, API.Item(Material.BOWL, "§cPotinhos", 64, (byte) 0));
				
				soup.setItem(5, API.Item(Material.INK_SACK, "§cPotinhos", 64, (byte) 3));
				soup.setItem(6, API.Item(Material.BOWL, "§cPotinhos", 64, (byte) 0));
				soup.setItem(7, API.Item(Material.INK_SACK, "§cPotinhos", 64, (byte) 3));
				soup.setItem(14, API.Item(Material.INK_SACK, "§cPotinhos", 64, (byte) 3));
				soup.setItem(15, API.Item(Material.BOWL, "§cPotinhos", 64, (byte) 0));
				soup.setItem(16, API.Item(Material.INK_SACK, "§cPotinhos", 64, (byte) 3));
				soup.setItem(23, API.Item(Material.INK_SACK, "§cPotinhos", 64, (byte) 3));
				soup.setItem(24, API.Item(Material.BOWL, "§cPotinhos", 64, (byte) 0));
				soup.setItem(25, API.Item(Material.INK_SACK, "§cPotinhos", 64, (byte) 3));
				soup.setItem(32, API.Item(Material.INK_SACK, "§cPotinhos", 64, (byte) 3));
				soup.setItem(33, API.Item(Material.BOWL, "§cPotinhos", 64, (byte) 0));
				soup.setItem(34, API.Item(Material.INK_SACK, "§cPotinhos", 64, (byte) 3));
				p.openInventory(soup);
				return;
			}
			if (s.getLine(0).equalsIgnoreCase("§b§lLegendPvP")
					&& s.getLine(1).equalsIgnoreCase("§f§l>>  §c§lSopas  §f§l<<")
					&& s.getLine(2).equalsIgnoreCase("§f§l>>  §c§lGratis  §f§l<<")) {
				e.setCancelled(true);
				Player p = e.getPlayer();
				Inventory soup = Bukkit.getServer().createInventory((InventoryHolder) p, 36, "§b§lLegendPvP");
				for (int i = 0; i < soup.getSize(); i++) {
					ItemStack stew = new ItemStack(Material.MUSHROOM_SOUP);
					soup.addItem(new ItemStack[] { stew });
				}
				p.openInventory(soup);
				return;
			}
		}
	}
}
