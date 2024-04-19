package com.Legend.LegendArena;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.Legend.KD.API;
import com.Legend.events.Combatlog;
import com.Legend.guis.Title;
import com.Legend.kits.manager.Base;
import com.Legend.warps.WarpAPI;

public class ComandosL implements CommandExecutor {

	public static boolean iniciou;

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if (!(sender instanceof Player)) {
			return true;
		}
		if (cmd.getName().equalsIgnoreCase("la")) {
			Player p = (Player) sender;
			if (Combatlog.inCombat(p)) {
				p.sendMessage(Base.prefix + "§cEm combate nao!");
				return true;
			}
			if (args.length == 0) {
				if (iniciou == false) {
					Base.setarKit(p, "Legend Arena");
					Base.setaraKit(p, "Legend Arena");
					p.teleport(WarpAPI.getLocation("la"));
					return true;
				} else {
					p.sendMessage(Base.prefix + "§cEventou ja iniciou!");
				}
			}
			if (args.length == 1) {
				if (p.hasPermission("legend.la")) {
					if(args[0].equalsIgnoreCase("spec")) {
						if (Base.temKit(p) == false || Base.qualKit(p) == "Nenhum") {
							p.teleport(WarpAPI.getLocation("laspec"));
							p.sendMessage(Base.prefix + "§7Você está spectando o Evento §cLegend Arena§7!");
							Base.setarKit(p, "LA Spec");
							Base.setaraKit(p, "LA Spec");
						} else {
							p.sendMessage(Base.prefix + "§bVocê não pode entrar assistir um Evento com §cKit§7!");
							return true;
						}
					}
					if (p.hasPermission("legend.laset")) {
						if (args[0].equalsIgnoreCase("setar")) {
							WarpAPI.setLocation(p.getLocation(), "la");
							p.sendMessage(Base.prefix + "§bVocê setou o Evento LegendArena.");
						} else if (args[0].equalsIgnoreCase("setarspec")) {
							WarpAPI.setLocation(p.getLocation(), "laspec");
							p.sendMessage(Base.prefix + "§bVocê setou o Evento LegendArena Spec.");
						} else if (args[0].equalsIgnoreCase("iniciar")) {
							for (Player s : Bukkit.getOnlinePlayers()) {
								if (Base.qualKit(s) == "Legend Arena") {
									s.teleport(p);
									darItens(s);
								}
								s.sendMessage(Base.prefix + "§c§lEvento Legend Arena começou!");
								Title.sendActionBar(s, "§c§lEvento iniciooouuu!!");
								iniciou = true;
							}
						}
					}
				}
			}
		}

		return false;
	}

	public void darItens(Player p) {
		p.getInventory().clear();
		p.getInventory().setArmorContents(null);
		p.setHealth(20);
		p.setGameMode(GameMode.SURVIVAL);
		ItemStack sopa = new ItemStack(Material.MUSHROOM_SOUP);
		ItemMeta sopa2 = sopa.getItemMeta();
		sopa2.setDisplayName("Sopa");
		sopa.setItemMeta(sopa2);
		p.getInventory().setHelmet(new ItemStack(Material.IRON_HELMET));
		p.getInventory().setBoots(new ItemStack(Material.IRON_BOOTS));
		p.getInventory().setChestplate(new ItemStack(Material.IRON_CHESTPLATE));
		p.getInventory().setLeggings(new ItemStack(Material.IRON_LEGGINGS));
		ItemStack espada = new ItemStack(Material.DIAMOND_SWORD);
		ItemMeta espada2 = espada.getItemMeta();
		espada2.setDisplayName("§bEspada");
		espada2.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
		espada.setItemMeta(espada2);
		p.getInventory().setItem(0, espada);
		for (int i = 1; i < 36; i++) {
			p.getInventory().setItem(i, sopa);
		}
		p.getInventory().setItem(9, new ItemStack(Material.IRON_HELMET));
		p.getInventory().setItem(10, new ItemStack(Material.IRON_BOOTS));
		p.getInventory().setItem(11, new ItemStack(Material.IRON_CHESTPLATE));
		p.getInventory().setItem(12, new ItemStack(Material.IRON_LEGGINGS));
		p.getInventory().setItem(13, API.Item(Material.RED_MUSHROOM, "§cCogu Red", 64, (byte) 0));
		p.getInventory().setItem(15, API.Item(Material.BROWN_MUSHROOM, "§cCogu Brown", 64, (byte) 0));
		p.getInventory().setItem(14, API.Item(Material.BOWL, "§cPotinhos", 64, (byte) 0));
		p.getInventory().setItem(35, API.Item(Material.RED_MUSHROOM, "§cCogu Red", 64, (byte) 0));
		p.getInventory().setItem(17, API.Item(Material.BROWN_MUSHROOM, "§cCogu Brown", 64, (byte) 0));
		p.getInventory().setItem(26, API.Item(Material.BOWL, "§cPotinhos", 64, (byte) 0));
	}
}
