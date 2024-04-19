package com.Legend.guis;

import java.util.ArrayList;
import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.Legend.KD.API;
import com.Legend.RDM.RDMApi;
import com.Legend.umvum.API1;

public class Warps implements Listener {

	public static void seletorWarps(Player p) {
		Inventory tps = Bukkit.createInventory(p, 27, "§bTeleports");

		ItemStack loja = new ItemStack(Material.VINE);
		ItemMeta loja2 = loja.getItemMeta();
		loja2.setDisplayName("§bTeleports");
		loja.setItemMeta(loja2);

		ItemStack tocha = new ItemStack(Material.REDSTONE_TORCH_ON);
		ItemMeta tocha2 = tocha.getItemMeta();
		tocha2.setDisplayName("§b§lWarps §fe §b§lEventos");
		tocha.setItemMeta(tocha2);

		ItemStack fps = new ItemStack(Material.STAINED_GLASS_PANE);
		ItemMeta fps2 = fps.getItemMeta();
		fps2.setDisplayName("§b§lWarp §6§lFPS");
		ArrayList<String> a = new ArrayList<>();
		a.add("");
		a.add("§7§lWarp para jogar sem §cLag§7!");
		a.add("§e§lPessoas na Warp: §7" + API1.getP("Fps"));
		a.add("");
		fps2.setLore(a);
		fps.setItemMeta(fps2);

		ItemStack x1 = new ItemStack(Material.BLAZE_ROD);
		ItemMeta x12 = x1.getItemMeta();
		x12.setDisplayName("§b§lWarp §6§l1V1");
		ArrayList<String> a23 = new ArrayList<>();
		a23.add("");
		a23.add("§7§lWarp para jogar §c1v1§7!");
		a23.add("§e§lPessoas na Warp: §7" + API1.getP("1v1"));
		a23.add("");
		x12.setLore(a23);
		x1.setItemMeta(x12);

		ItemStack rdme = new ItemStack(Material.CAKE);
		ItemMeta rdme2 = rdme.getItemMeta();
		rdme2.setDisplayName("§b§lEvento §6§lRDM §cENTRAR");
		ArrayList<String> a1 = new ArrayList<>();
		a1.add("");
		a1.add("§f------§6§lStatus§f------");
		if (RDMApi.emduel == true) {
			a1.add("");
			a1.add("§2§lEstá acontecendo.");
		} else if (RDMApi.iniciado == true) {
			a1.add("");
			a1.add("§9§lEstá iniciando.");
		} else {
			a1.add("");
			a1.add("§c§lNão está acontecendo.");
		}
		a1.add("");
		a1.add("§7§lEntrar no Evento §cRDM§7!");
		rdme2.setLore(a1);
		rdme.setItemMeta(rdme2);

		ItemStack rdms = new ItemStack(Material.APPLE);
		ItemMeta rdms2 = rdms.getItemMeta();
		rdms2.setDisplayName("§b§lEvento §6§lRDM §cASSISTIR");
		ArrayList<String> b = new ArrayList<>();
		b.add("");
		b.add("§7§lEntrar assistir o Evento §cRDM§7!");
		b.add("");
		rdms2.setLore(b);
		rdms.setItemMeta(rdms2);

		for (int i = 0; i < 27; i++)
			tps.setItem(i, loja);

		tps.setItem(4, tocha);
		tps.setItem(10, fps);
		tps.setItem(12, x1);
		tps.setItem(14, API.Item(Material.LAVA_BUCKET, "§b§lWarp §6§lLava Challenge", 1, (byte)0, Arrays.asList(new String[] {"§7§lWarp para se desafiar§7!"})));
		tps.setItem(16, rdme);
		tps.setItem(25, rdms);
		p.openInventory(tps);

	}

	@EventHandler
	public void clickInv(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		if (e.getInventory().getName().equalsIgnoreCase("§bTeleports")) {
			if (e.getCurrentItem() == null) return;
			if (e.getCurrentItem().getItemMeta() == null)
				return;
			if (e.getCurrentItem().getType() == null)
				return;
			if (e.getCurrentItem() != null && !e.getCurrentItem().getType().equals(Material.AIR)) {
				e.setCancelled(true);
			}
			e.setCancelled(true);
			if (e.getCurrentItem().getType() == Material.STAINED_GLASS_PANE) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/fps");
			} else if (e.getCurrentItem().getType() == Material.CAKE) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/rdm entrar");
			} else if (e.getCurrentItem().getType() == Material.APPLE) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/rdm spec");
			} else if (e.getCurrentItem().getType() == Material.BLAZE_ROD) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/1v1");
			} else if (e.getCurrentItem().getType() == Material.LAVA_BUCKET) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/lava");
			}
		}
	}
}
