package com.Legend.kits.manager;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.Legend.Comandos.Builder;
import com.Legend.Comandos.Itens;
import com.Legend.KD.API;
import com.Legend.kits.TankUp;
import com.Legend.kits.Upgrader;
import com.Legend.kits.Viper;
import com.Legend.warps.Arena;

public class Base {

	public static Base instance;

	public static String prefix = "§f[§b§lLegendPvP§f] >> ";
	public static HashMap<Player, String> Kit = new HashMap<Player, String>();
	public static HashMap<Player, String> aKit = new HashMap<Player, String>();
	public static ItemStack sopa;

	public static boolean temKit(Player p) {
		if ((Base.qualKit(p) == "Nenhum") || (Base.qualKit(p) == null)) {
			return false;
		} else {
			return true;
		}
	}

	public static String qualKit(Player p) {
		return Kit.get(p);
	}

	public static void setarKit(Player p, String kit) {
		Kit.remove(p);
		Kit.put(p, kit);
		Builder.pode.remove(p.getName());
	}

	public static boolean temaKit(Player p) {
		if ((Base.qualaKit(p) == "Nenhum") || (Base.qualaKit(p) == null)) {
			return false;
		} else {
			return true;
		}
	}

	public static String qualaKit(Player p) {
		return aKit.get(p);
	}

	public static void setaraKit(Player p, String kit) {
		aKit.put(p, kit);
	}

	public static void tirarKit(Player p) {
		if (temKit(p)) {
			Kit.put(p, "Nenhum");
			TankUp.lvl.remove(p);
			Upgrader.upgrade.remove(p);
			CooldownAPI.tirarCooldown(p);
			CdAPI.tirarCooldown(p);
			Comando.remove(p);
			Viper.a.remove(p);
			Viper.b.remove(p);
		}
	}
	public static void tirarKita(Player p) {
		if (temKit(p)) {
			aKit.put(p, "Nenhum");
			TankUp.lvl.remove(p);
			Upgrader.upgrade.remove(p);
			CooldownAPI.tirarCooldown(p);
			CdAPI.tirarCooldown(p);
			Comando.remove(p);
			Viper.a.remove(p);
			Viper.b.remove(p);
		}
	}


	public static void dItens(Player p) {
		for (Player on : Bukkit.getOnlinePlayers()) {
			on.showPlayer(p);
		}
		API.clearPlayer(p);
		sopa = new ItemStack(Material.MUSHROOM_SOUP);
		ItemMeta sopa2 = sopa.getItemMeta();
		sopa2.setDisplayName("Sopa");
		sopa.setItemMeta(sopa2);
		if (Base.qualKit(p) == "Sharpness") {
			ItemStack espada = new ItemStack(Material.STONE_SWORD);
			ItemMeta espada2 = espada.getItemMeta();
			espada2.setDisplayName("§bEspada");
			espada.setItemMeta(espada2);
			p.getInventory().setItem(0, espada);
		} else if (Base.qualKit(p) == "Viking") {
			ItemStack espada = new ItemStack(Material.IRON_AXE);
			ItemMeta espada2 = espada.getItemMeta();
			espada2.setDisplayName("§bMachadao");
			espada.setItemMeta(espada2);
			p.getInventory().setItem(0, espada);
		} else {
			ItemStack espada = new ItemStack(Material.STONE_SWORD);
			ItemMeta espada2 = espada.getItemMeta();
			espada2.setDisplayName("§bEspada");
			espada.setItemMeta(espada2);
			p.getInventory().setItem(0, espada);
		}
		for (int i = 1; i < 36; i++) {
			p.getInventory().setItem(i, sopa);
		}
		if (!(Base.qualKit(p) == "Fps") && !(Base.qualKit(p) == "RDM")) {
			Comando.add(p);
			p.getInventory().setItem(8, API.Item(Material.COMPASS, "§7Bússola", 1, (byte) 0));
		}
		if (Itens.temItens(p.getName())) {
			if (Itens.getativoItens(p.getName())) {
				p.getInventory().setItem(6, API.Item(Material.GOLDEN_APPLE, "§6Maçazinha boa", 3, (byte) 0));
				p.getInventory().addItem(API.Item(Material.RED_MUSHROOM, "§cCogu Red", 20, (byte) 0));
				p.getInventory().addItem(API.Item(Material.BROWN_MUSHROOM, "§cCogu Brown", 20, (byte) 0));
				p.getInventory().addItem(API.Item(Material.BOWL, "§cPotinhos", 20, (byte) 0));
				p.getInventory().setItem(7, API.Item(Material.WOOD_AXE, "§cMachadao", 1, (byte) 0));
				Itens.usouItens(p.getName());
				p.sendMessage(Base.prefix + "§bVocê ainda tem §c" + Itens.getItens(p.getName())
						+ " §bitens extras para usar!");
			}
		}
		if (Base.qualaKit(p) == "Goku") {
			ItemStack item = new ItemStack(Material.LAPIS_BLOCK);
			ItemMeta item2 = item.getItemMeta();
			item2.setDisplayName("§bKamehameha!");
			item.setItemMeta(item2);
			p.getInventory().setItem(1, item);
		} else if (Base.qualaKit(p) == "Phantom") {
			ItemStack item = new ItemStack(Material.FEATHER);
			ItemMeta item2 = item.getItemMeta();
			item2.setDisplayName("§bPhantom");
			item.setItemMeta(item2);
			p.getInventory().setItem(1, item);
		} else if (Base.qualaKit(p) == "Ghost") {
			ItemStack item = new ItemStack(Material.GLASS_BOTTLE);
			ItemMeta item2 = item.getItemMeta();
			item2.setDisplayName("§bGhost");
			item.setItemMeta(item2);
			p.getInventory().setItem(1, item);
		} else if (Base.qualaKit(p) == "C4") {
			ItemStack item = new ItemStack(Material.TNT);
			ItemMeta item2 = item.getItemMeta();
			item2.setDisplayName("§bC4");
			item.setItemMeta(item2);
			p.getInventory().setItem(1, item);
		} else if (Base.qualaKit(p) == "Reaper") {
			ItemStack item = new ItemStack(Material.WOOD_HOE);
			ItemMeta item2 = item.getItemMeta();
			item2.setDisplayName("§bReaper");
			item.setItemMeta(item2);
			p.getInventory().setItem(1, item);
		} else if (Base.qualaKit(p) == "LifeStealer") {
			ItemStack item = new ItemStack(Material.GHAST_TEAR);
			ItemMeta item2 = item.getItemMeta();
			item2.setDisplayName("§bLife Stealer");
			item.setItemMeta(item2);
			p.getInventory().setItem(1, item);
		} else if (Base.qualaKit(p) == "Checkpoint") {
			ItemStack item = new ItemStack(Material.NETHER_FENCE);
			ItemMeta item2 = item.getItemMeta();
			item2.setDisplayName("§bCheckPoint");
			item.setItemMeta(item2);
			p.getInventory().setItem(1, item);
		} else if (Base.qualaKit(p) == "Pyro") {
			ItemStack item = new ItemStack(Material.FIREBALL);
			ItemMeta item2 = item.getItemMeta();
			item2.setDisplayName("§bBola de fogo");
			item.setItemMeta(item2);
			p.getInventory().setItem(1, item);
		} else if (Base.qualaKit(p) == "Naruto") {
			ItemStack item = new ItemStack(Material.NETHER_STAR);
			ItemMeta item2 = item.getItemMeta();
			item2.setDisplayName("§bNaruto");
			item.setItemMeta(item2);
			p.getInventory().setItem(1, item);
		} else if (Base.qualaKit(p) == "Archer") {
			ItemStack arco = new ItemStack(Material.BOW);
			ItemMeta arco2 = arco.getItemMeta();
			arco2.setDisplayName("§bArco");
			arco2.addEnchant(Enchantment.ARROW_INFINITE, 1, true);
			arco.setItemMeta(arco2);
			p.getInventory().setItem(1, arco);
			p.getInventory().setItem(9, new ItemStack(Material.ARROW));
		} else if (Base.qualaKit(p) == "Kangaroo") {
			ItemStack item = new ItemStack(Material.FIREWORK);
			ItemMeta item2 = item.getItemMeta();
			item2.setDisplayName("§bKangaroo");
			item.setItemMeta(item2);
			p.getInventory().setItem(1, item);
		} else if (Base.qualaKit(p) == "Fisherman") {
			ItemStack item = new ItemStack(Material.FISHING_ROD);
			ItemMeta item2 = item.getItemMeta();
			item2.setDisplayName("§bVara");
			item.setItemMeta(item2);
			p.getInventory().setItem(1, item);
		} else if (Base.qualaKit(p) == "Tank") {
			p.getInventory().setChestplate(new ItemStack(Material.LEATHER_CHESTPLATE));
		} else if (Base.qualaKit(p) == "Gladiator") {
			ItemStack item = new ItemStack(Material.IRON_FENCE);
			ItemMeta item2 = item.getItemMeta();
			item2.setDisplayName("§bGladiator");
			item.setItemMeta(item2);
			p.getInventory().setItem(1, item);
		} else if (Base.qualaKit(p) == "Upgrader") {
			ItemStack item = new ItemStack(Material.WOOD_SWORD);
			ItemMeta item2 = item.getItemMeta();
			item2.setDisplayName("§bUpgrader!");
			item.setItemMeta(item2);
			p.getInventory().setItem(0, item);
		} else if (Base.qualaKit(p) == "Thor") {
			ItemStack item = new ItemStack(Material.GOLD_AXE);
			ItemMeta item2 = item.getItemMeta();
			item2.setDisplayName("§bMjölnir!");
			item.setItemMeta(item2);
			p.getInventory().setItem(1, item);
		} else if (Base.qualaKit(p) == "Grandpa") {
			ItemStack item = new ItemStack(Material.STICK);
			ItemMeta item2 = item.getItemMeta();
			item2.setDisplayName("§bGrandpa!");
			item2.addEnchant(Enchantment.KNOCKBACK, 2, true);
			item.setItemMeta(item2);
			p.getInventory().setItem(1, item);
		} else if (Base.qualaKit(p) == "Avatar") {
			ItemStack item = new ItemStack(Material.BEACON);
			ItemMeta item2 = item.getItemMeta();
			item2.setDisplayName("§aAvatar");
			item.setItemMeta(item2);
			p.getInventory().setItem(1, item);
		} else if (Base.qualaKit(p) == "Frozen") {
			ItemStack item = new ItemStack(Material.PACKED_ICE);
			ItemMeta item2 = item.getItemMeta();
			item2.setDisplayName("§bFrozen");
			item.setItemMeta(item2);
			p.getInventory().setItem(1, item);
		} else if (Base.qualaKit(p) == "Endermage") {
			ItemStack item = new ItemStack(Material.ENDER_PORTAL_FRAME);
			ItemMeta item2 = item.getItemMeta();
			item2.setDisplayName("§bEndermage");
			item.setItemMeta(item2);
			p.getInventory().setItem(1, item);
		} else if (Base.qualaKit(p) == "Vampiro") {
			ItemStack item = new ItemStack(Material.FLINT);
			ItemMeta item2 = item.getItemMeta();
			item2.setDisplayName("§bVampiro!");
			item.setItemMeta(item2);
			p.getInventory().setItem(1, item);
		} else if (Base.qualaKit(p) == "Deshfire") {
			ItemStack item = new ItemStack(Material.REDSTONE_BLOCK);
			ItemMeta item2 = item.getItemMeta();
			item2.setDisplayName("§bDeshfire!");
			item.setItemMeta(item2);
			p.getInventory().setItem(1, item);
		} else if (Base.qualaKit(p) == "Monk") {
			ItemStack item = new ItemStack(Material.BLAZE_ROD);
			ItemMeta item2 = item.getItemMeta();
			item2.setDisplayName("§bMonk!");
			item.setItemMeta(item2);
			p.getInventory().setItem(1, item);
		} else if (Base.qualaKit(p) == "Arrow") {
			ItemStack item = new ItemStack(Material.ARROW);
			ItemMeta item2 = item.getItemMeta();
			item2.setDisplayName("§bArrow!");
			item.setItemMeta(item2);
			p.getInventory().setItem(1, item);
		} else if (Base.qualaKit(p) == "Avatar") {
			ItemStack item = new ItemStack(Material.BEACON);
			ItemMeta item2 = item.getItemMeta();
			item2.setDisplayName("§aAvatar");
			item.setItemMeta(item2);
			p.getInventory().setItem(1, item);
		} else if (Base.qualaKit(p) == "Switcher") {
			ItemStack item = new ItemStack(Material.SNOW_BALL);
			ItemMeta item2 = item.getItemMeta();
			item2.setDisplayName("§aSwitcher");
			item.setItemMeta(item2);
			p.getInventory().setItem(1, item);
		} else if (Base.qualaKit(p) == "Scout") {
			ItemStack item = new ItemStack(Material.POTION, 1, (byte) 16386);
			ItemMeta item2 = item.getItemMeta();
			item2.setDisplayName("§aScout");
			item.setItemMeta(item2);
			p.getInventory().setItem(1, item);
		}
	}

	public static void darItens(Player p) {
		if (Arena.getArena(p) == true) {
			if (Base.qualaKit(p) == null || Base.qualaKit(p) == "Nenhum") {
				Base.setaraKit(p, "PvP");
			}
			Base.setarKit(p, Base.qualaKit(p));
			Arena.randomArena(p);
			dItens(p);
		} else {
			if (p.getLocation().getY() <= 68) {
				dItens(p);
			}
		}
	}

	public static ArrayList<Player> getPlayersAroundLocation(int r, World w, double x, double y, double z) {
		int o = r * 2;
		ArrayList<Player> p = new ArrayList<>();
		Location loc = new Location(w, x, y, z);
		for (Entity ent : w.getEntities()) {
			if (ent instanceof Player && ent.getLocation().distanceSquared(loc) <= o)
				p.add((Player) ent);
		}
		return p;
	}
}
