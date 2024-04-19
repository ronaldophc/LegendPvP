package com.Legend.warps;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.Legend.Main;
import com.Legend.KD.API;
import com.Legend.events.Combatlog;
import com.Legend.guis.Title;
import com.Legend.kits.manager.Base;

public class FPS implements Listener, CommandExecutor {
	public static Main plugin;

	public FPS(Main main) {
		plugin = main;
	}

	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if (cmd.getName().equalsIgnoreCase("fps")) {
			final Player p = (Player) sender;
			if (Combatlog.inCombat(p)) {
				p.sendMessage(Base.prefix + "§cEm combate nao!");
			} else {
				Title.sendActionBar(p, "§6Você sera teleportado em 3 segundos");
				plugin.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
					public void run() {
						if (!Combatlog.inCombat(p)) {
							Base.tirarKit(p);
							Base.setarKit(p, "Fps");
							darItens(p);
							p.teleport(WarpAPI.getLocation("FPS"));
							p.sendMessage(Base.prefix + "§bVocê foi teleportado para a §cWarp FPS§b!");
						} else {
							p.sendMessage(Base.prefix + "§cTP para o Spawn cancelado, você entrou em combate.");
						}
						return;
					}
				}, 3 * 20);
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
		p.getInventory().setItem(13, API.Item(Material.RED_MUSHROOM, "§cCogu Red", 64, (byte) 0));
		p.getInventory().setItem(15, API.Item(Material.BROWN_MUSHROOM, "§cCogu Brown", 64, (byte) 0));
		p.getInventory().setItem(14, API.Item(Material.BOWL, "§cPotinhos", 64, (byte) 0));
	}
}