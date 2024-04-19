package com.Legend.guis;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;

import com.Legend.Main;
import com.Legend.Comandos.Admin;
import com.Legend.Comandos.Itens;
import com.Legend.KD.API;
import com.Legend.kits.manager.Base;
import com.Legend.warps.Arena;

public class Configs2 implements Listener {

	@EventHandler
	public void clickInv(InventoryClickEvent e) {
		if (e.getInventory().getName().equalsIgnoreCase("§bConfigs")) {
			if (e.getCurrentItem() == null)
				return;
			if (e.getCurrentItem().getItemMeta() == null)
				return;
			Player p = (Player) e.getWhoClicked();
			if (!p.getItemInHand().getItemMeta().hasDisplayName())
				return;
			if (e.getCurrentItem() != null && !e.getCurrentItem().getType().equals(Material.AIR)) {
				e.setCancelled(true);
			}
			if (e.getCurrentItem().hasItemMeta() && p.getItemInHand().getItemMeta().hasDisplayName()) {
				if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§aItens Extras!")) {
					Itens.ativoItens(p.getName(), false);
					p.sendMessage(Base.prefix + "§cVocê desativou seus Itens extras!");
					e.getInventory().setItem(2, API.Item(Material.INK_SACK, "§cItens Extras!", 1, (byte) 8,
							Arrays.asList(new String[] { " ",
									"§fVocê ainda tem §c" + Itens.getItens(p.getName()) + " §fitens extras para usar!",
									"§aCompre mais itens no Site!" })));
				} else if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§cItens Extras!")) {
					Itens.ativoItens(p.getName(), true);
					p.sendMessage(Base.prefix + "§cVocê ativou seus Itens extras!");
					e.getInventory().setItem(2, API.Item(Material.INK_SACK, "§aItens Extras!", 1, (byte) 10,
							Arrays.asList(new String[] { " ",
									"§fVocê ainda tem §c" + Itens.getItens(p.getName()) + " §fitens extras para usar!",
									"§aCompre mais itens no Site!" })));
				} else if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§aTP Ativo")) {
					e.getInventory().setItem(4,
							API.Item(Material.WOOD_SWORD, "§cTP Off", 1, (byte) 0, Arrays.asList(new String[] { " ",
									"§fAtive ou desative o Teleporte", "§fpara a arena após pegar o Kit " })));
					Arena.setArena(p, false);
					p.sendMessage(Base.prefix + "§cVocê desativou o Teleport para a Arena!");
				} else if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§cTP Off")) {
					e.getInventory().setItem(4,
							API.Item(Material.STONE_SWORD, "§aTP Ativo", 1, (byte) 0, Arrays.asList(new String[] { " ",
									"§fAtive ou desative o Teleporte", "§fpara a arena após pegar o Kit " })));
					Arena.setArena(p, true);
					p.sendMessage(Base.prefix + "§cVocê ativou o Teleport para a Arena!");
				}
			}
			if (e.getCurrentItem().hasItemMeta() && p.getItemInHand().getItemMeta().hasDisplayName()) {
				if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§cSkins")) {
					p.chat("/tskins");
				}
			}
			e.setCancelled(true);
		}
	}

	public static void guiconfigs(Player p) {
		Inventory shop = Bukkit.createInventory(p, 9, "§bConfigs");
		if (Itens.getativoItens(p.getName())) {
			shop.setItem(1,
					API.Item(Material.INK_SACK, "§aItens Extras!", 1, (byte) 10,
							Arrays.asList(new String[] { " ",
									"§fVocê ainda tem §c" + Itens.getItens(p.getName()) + " §fitens extras para usar!",
									"§aCompre mais itens no Site!" })));
		} else {
			shop.setItem(1,
					API.Item(Material.INK_SACK, "§cItens Extras!", 1, (byte) 8,
							Arrays.asList(new String[] { " ",
									"§fVocê ainda tem §c" + Itens.getItens(p.getName()) + " §fitens extras para usar!",
									"§aCompre mais itens no Site!" })));

		}
		if (Arena.getArena(p)) {
			shop.setItem(3, API.Item(Material.STONE_SWORD, "§aTP Ativo", 1, (byte) 0, Arrays.asList(
					new String[] { " ", "§fAtive ou desative o Teleporte", "§fpara a arena após pegar o Kit " })));
		} else {
			shop.setItem(3, API.Item(Material.WOOD_SWORD, "§cTP Off", 1, (byte) 0, Arrays.asList(
					new String[] { " ", "§fAtive ou desative o Teleporte", "§fpara a arena após pegar o Kit " })));
		}

		shop.setItem(5,
				API.Item(Material.BOOK_AND_QUILL, "§cArena", 1, (byte) 0,
						Arrays.asList(new String[] { "", "§fKills: §b" + (API.getkills(p)),
								"§fMortes: §b" + API.getmortes(p), "§fDinheiro: §b" + API.getdinheiro(p),
								"§fRank: §b" + API.getRank(p) + " §f- §b" + API.getpontos(p) + " §fpontos.",
								"§fTop KS: §b" + Main.file.getConfig().getInt(String.valueOf(p) + ".TopKS") })));

		shop.setItem(7, API.Item(Material.NAME_TAG, "§cSkins", 1, (byte) 0,
				Arrays.asList(new String[] { "§fEscolhe uma §6skin §fpara você!" })));

		p.openInventory(shop);
	}

	@EventHandler
	public static void interagirInv(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		if (Base.temKit(p) == false) {
			if ((e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.LEFT_CLICK_AIR
					|| e.getAction() == Action.LEFT_CLICK_BLOCK || e.getAction() == Action.RIGHT_CLICK_BLOCK)
					&& (p.getItemInHand().getType() == Material.PAPER) && !(Admin.inadmin.contains(p))) {
				guiconfigs(p);
			}
		}
	}
}
