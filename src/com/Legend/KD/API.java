package com.Legend.KD;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;

import com.Legend.Main;
import com.Legend.kits.manager.Base;

public class API {

	public static HashMap<Player, Integer> ks = new HashMap<>();
	public static ArrayList<Player> anuncio = new ArrayList<>();

	public static void clearPlayer(Player p) {
		p.getInventory().setArmorContents(null);
		for (PotionEffect pe : p.getActivePotionEffects()) {
			p.removePotionEffect(pe.getType());
		}
		p.setHealth(20);
		p.setFoodLevel(20);
		p.setExhaustion(0);
		p.setGameMode(GameMode.SURVIVAL);
		p.setLevel(0);
		p.setFireTicks(0);
		p.setAllowFlight(false);
		p.setFlying(false);
	}

	public static void addKs(Player p) {
		if (!ks.containsKey(p)) {
			ks.put(p, 1);
		} else {
			ks.put(p, ks.get(p) + 1);
		}
		if (ks.get(p) % 5 == 0) {
			Bukkit.broadcastMessage(
					Base.prefix + "§bJogador §c" + p.getName() + " §bestá com um KillStreak de §c" + ks.get(p) + "§b.");
		}
		if (getKs(p) > Main.file.getConfig().getInt(String.valueOf(p.getName()) + ".TopKS")) {
			Main.file.getConfig().set(String.valueOf(p.getName()) + ".TopKS", Integer.valueOf(getKs(p)));
			Main.file.save();
		}
	}

	public static int getKs(Player p) {
		if (ks.containsKey(p)) {
			return ks.get(p);
		}
		return 0;
	}

	public static void resetKs(Player p) {
		ks.put(p, 0);
	}

	public static int getmortes(Player p) {
		return Main.file.getConfig().getInt(String.valueOf(p.getName()) + ".Mortes");
	}

	public static int getmortes(String p) {
		return Main.file.getConfig().getInt(String.valueOf(p) + ".Mortes");
	}

	public static int getkills(Player p) {
		return Main.file.getConfig().getInt(String.valueOf(p.getName()) + ".Kills");
	}

	public static int getkills(OfflinePlayer p) {
		return Main.file.getConfig().getInt(String.valueOf(p.getName()) + ".Kills");
	}

	public static int getkills(String p) {
		return Main.file.getConfig().getInt(String.valueOf(p) + ".Kills");
	}

	public static int getdinheiro(Player p) {
		return Main.file.getConfig().getInt(String.valueOf(p.getName()) + ".Dinheiro");
	}

	public static int getdinheiro(String p) {
		return Main.file.getConfig().getInt(String.valueOf(p) + ".Dinheiro");
	}

	public static int getdinheiro(OfflinePlayer p) {
		return Main.file.getConfig().getInt(String.valueOf(p.getName()) + ".Dinheiro");
	}

	public static void setkills(Player p) {
		Main.file.getConfig().set(String.valueOf(p.getName()) + ".Kills", Integer.valueOf(API.getkills(p) + 1));
	}

	public static void setmortes(Player p) {
		Main.file.getConfig().set(String.valueOf(p.getName()) + ".Mortes", Integer.valueOf(API.getmortes(p) + 1));
	}

	public static void setDinheiro(Player p, int quantia) {
		Main.file.getConfig().set(String.valueOf(p.getName()) + ".Dinheiro",
				Integer.valueOf(API.getdinheiro(p) + quantia));
	}

	public static void addDinheiro(Player p, int quantia) {
		Main.file.getConfig().set(String.valueOf(p.getName()) + ".Dinheiro", Integer.valueOf(quantia));
	}

	public static void removerDinheiro(Player p, int quantia) {
		if (getdinheiro(p) <= 0) {
			return;
		}
		Main.file.getConfig().set(String.valueOf(p.getName()) + ".Dinheiro",
				Integer.valueOf(API.getdinheiro(p) - quantia));
	}

	public static String getRank(Player p) {
		if (getpontos(p) < 100) {
			return "§eεⅠ §eBronze I";
		} else if (getpontos(p) < 200 && getpontos(p) >= 100) {
			return "§eεⅡ §eBronze II";
		} else if (getpontos(p) < 300 && getpontos(p) >= 200) {
			return "§8ρⅠ §8Prata I";
		} else if (getpontos(p) < 400 && getpontos(p) >= 300) {
			return "§8ρⅡ §8Prata II";
		} else if (getpontos(p) < 500 && getpontos(p) >= 400) {
			return "§6ϑⅠ Gold I";
		} else if (getpontos(p) < 600 && getpontos(p) >= 500) {
			return "§6ϑⅡ §6Gold II";
		} else if (getpontos(p) < 700 && getpontos(p) >= 600) {
			return "§9ξⅠ §9Platina I";
		} else if (getpontos(p) < 800 && getpontos(p) >= 700) {
			return "§9ξⅡ §9Platina II";
		} else if (getpontos(p) < 900 && getpontos(p) >= 800) {
			return "§bζⅠ §bDiamante I";
		} else if (getpontos(p) < 1000 && getpontos(p) >= 900) {
			return "§bζⅡ §bDiamante II";
		} else if (getpontos(p) >= 1000) {
			return "§4Φ §4Duelista";
		}
		return "§7Unranked";
	}

	public static String getRank(String p) {
		if (getpontos(p) < 100) {
			return "§eεⅠ §eBronze I";
		} else if (getpontos(p) < 200 && getpontos(p) >= 100) {
			return "§eεⅡ §eBronze II";
		} else if (getpontos(p) < 300 && getpontos(p) >= 200) {
			return "§8ρⅠ §8Prata I";
		} else if (getpontos(p) < 400 && getpontos(p) >= 300) {
			return "§8ρⅡ §8Prata II";
		} else if (getpontos(p) < 500 && getpontos(p) >= 400) {
			return "§6ϑⅠ Gold I";
		} else if (getpontos(p) < 600 && getpontos(p) >= 500) {
			return "§6ϑⅡ §6Gold II";
		} else if (getpontos(p) < 700 && getpontos(p) >= 600) {
			return "§9ξⅠ §9Platina I";
		} else if (getpontos(p) < 800 && getpontos(p) >= 700) {
			return "§9ξⅡ §9Platina II";
		} else if (getpontos(p) < 900 && getpontos(p) >= 800) {
			return "§bζⅠ §bDiamante I";
		} else if (getpontos(p) < 1000 && getpontos(p) >= 900) {
			return "§bζⅡ §bDiamante II";
		} else if (getpontos(p) >= 1000) {
			return "§4Φ §4Duelista";
		}
		return "§7Unranked";
	}

	public static String getRankn(int a) {
		if (a < 100) {
			return "§e§lεⅠ §e§lBronze I";
		} else if (a < 200 && a >= 100) {
			return "§e§lεⅡ §e§lBronze II";
		} else if (a < 300 && a >= 200) {
			return "§8§lρⅠ §8§lPrata I";
		} else if (a < 400 && a >= 300) {
			return "§8§lρⅡ §8§lPrata II";
		} else if (a < 500 && a >= 400) {
			return "§6§lϑⅠ §lGold I";
		} else if (a < 600 && a >= 500) {
			return "§6§lϑⅡ §6§lGold II";
		} else if (a < 700 && a >= 600) {
			return "§9§lξⅠ §9§lPlatina I";
		} else if (a < 800 && a >= 700) {
			return "§9§lξⅡ §9§lPlatina II";
		} else if (a < 900 && a >= 800) {
			return "§b§lζⅠ §b§lDiamante I";
		} else if (a < 1000 && a >= 900) {
			return "§b§lζⅡ §b§lDiamante II";
		} else if (a >= 1000) {
			return "§4§lΦ §4§lDuelista";
		}
		return "§7Unranked";
	}

	public static String getRankSymbol(Player p) {
		if (getpontos(p) < 100) {
			return "§e§lεⅠ";
		} else if (getpontos(p) < 200 && getpontos(p) >= 100) {
			return "§e§lεⅡ";
		} else if (getpontos(p) < 300 && getpontos(p) >= 200) {
			return "§8§lρⅠ";
		} else if (getpontos(p) < 400 && getpontos(p) >= 300) {
			return "§8§lρⅡ";
		} else if (getpontos(p) < 500 && getpontos(p) >= 400) {
			return "§6§lϑⅠ";
		} else if (getpontos(p) < 600 && getpontos(p) >= 500) {
			return "§6§lϑⅡ";
		} else if (getpontos(p) < 700 && getpontos(p) >= 600) {
			return "§9§lξⅠ";
		} else if (getpontos(p) < 800 && getpontos(p) >= 700) {
			return "§9§lξⅡ";
		} else if (getpontos(p) < 900 && getpontos(p) >= 800) {
			return "§b§lζⅠ";
		} else if (getpontos(p) < 1000 && getpontos(p) >= 900) {
			return "§b§lζⅡ";
		} else if (getpontos(p) >= 1000) {
			return "§4§lΦ";
		}
		return "§7";
	}

	public static int getpontos(Player p) {
		return Main.file.getConfig().getInt(String.valueOf(p.getName()) + ".Pontos");
	}

	public static int getpontos(OfflinePlayer p) {
		return Main.file.getConfig().getInt(String.valueOf(p.getName()) + ".Pontos");
	}

	public static int getpontos(String p) {
		return Main.file.getConfig().getInt(String.valueOf(p) + ".Pontos");
	}
	
	public static String getip(Player p) {
		return Main.file.getConfig().getString(String.valueOf(p.getName()) + ".IP");
	}

	public static String getip(OfflinePlayer p) {
		return Main.file.getConfig().getString(String.valueOf(p.getName()) + ".IP");
	}

	public static String getip(String p) {
		return Main.file.getConfig().getString(String.valueOf(p) + ".IP");
	}
	
	public static void setpontos(Player p, int quantia) {
		Main.file.getConfig().set(String.valueOf(p.getName()) + ".Pontos", Integer.valueOf(API.getpontos(p) + quantia));
	}

	public static void removerpontos(Player p, int quantia) {
		if (getpontos(p) <= 0) {
			return;
		}
		if (getpontos(p) - quantia <= 0) {
			Main.file.getConfig().set(String.valueOf(p.getName()) + ".Pontos", Integer.valueOf(0));
		} else {
			Main.file.getConfig().set(String.valueOf(p.getName()) + ".Pontos",
					Integer.valueOf(API.getpontos(p) - quantia));
		}
	}

	public static HashMap<String, Integer> kills = new HashMap<>();
	public static HashMap<String, Integer> dinheiros = new HashMap<>();
	public static HashMap<String, Integer> pontos = new HashMap<>();
	public static HashMap<String, Integer> ksk = new HashMap<>();
	public static List<Entry<String, Integer>> valoresks;
	public static List<Entry<String, Integer>> valoresp;
	public static List<Entry<String, Integer>> valoresk;
	public static List<Entry<String, Integer>> valoresd;

	public static void atualizadork() {
		for (OfflinePlayer off : Bukkit.getOfflinePlayers()) {
			int kill = getkills(off);
			kills.put(off.getName(), kill);
			int dinheiro = getdinheiro(off);
			dinheiros.put(off.getName(), dinheiro);
			int ponto = getpontos(off);
			pontos.put(off.getName(), ponto);
			int ks = Main.file.getConfig().getInt(String.valueOf(off.getName()) + ".TopKS");
			ksk.put(off.getName(), ks);
		}

		Stream<Entry<String, Integer>> streamOrdenadaks = ksk.entrySet().stream()
				.sorted((x, y) -> y.getValue().compareTo(x.getValue()));

		valoresks = streamOrdenadaks.collect(Collectors.toList());

		Stream<Entry<String, Integer>> streamOrdenadad = dinheiros.entrySet().stream()
				.sorted((x, y) -> y.getValue().compareTo(x.getValue()));

		valoresd = streamOrdenadad.collect(Collectors.toList());

		Stream<Entry<String, Integer>> streamOrdenadap = pontos.entrySet().stream()
				.sorted((x, y) -> y.getValue().compareTo(x.getValue()));

		valoresp = streamOrdenadap.collect(Collectors.toList());

		Stream<Entry<String, Integer>> streamOrdenadak = kills.entrySet().stream()
				.sorted((x, y) -> y.getValue().compareTo(x.getValue()));

		valoresk = streamOrdenadak.collect(Collectors.toList());
	}

	public static void topk(Player p) {
		int id = 1;
		p.sendMessage("    §bTop 10 §aKills ");
		for (Entry<String, Integer> entrada : valoresk) {
			String jogador = entrada.getKey();
			int valor = entrada.getValue();

			p.sendMessage("§6   " + id + "º §c" + jogador + " §f: §a" + valor);
			id++;
			if (id > 10) {
				break;
			}
		}
	}

	public static void topks(Player p) {
		int id = 1;
		p.sendMessage("    §bTop 10 §aKillStreak ");
		for (Entry<String, Integer> entrada : valoresks) {
			String jogador = entrada.getKey();
			int valor = entrada.getValue();

			p.sendMessage("§6   " + id + "º §c" + jogador + " §f: §a" + valor);
			id++;
			if (id > 10) {
				break;
			}
		}
	}

	public static void topp(Player p) {
		int id = 1;
		p.sendMessage("    §bTop 10 §aRank ");
		for (Entry<String, Integer> entrada : valoresp) {
			String jogador = entrada.getKey();
			int valor = entrada.getValue();

			p.sendMessage("§6   " + id + "º §c" + jogador + " §f: §a" + getRankn(valor));
			id++;
			if (id > 10) {
				break;
			}
		}
	}

	public static void topd(Player p) {
		int id = 1;
		p.sendMessage("      §bTop 10 Dinheiro");
		for (Entry<String, Integer> entrada : valoresd) {
			String jogador = entrada.getKey();
			int valor = entrada.getValue();

			p.sendMessage("§6   " + id + "º §c" + jogador + " §f: §a" + valor);
			id++;
			if (id > 10) {
				break;
			}
		}
	}

	public static ItemStack Item(Material mat, String nome, int amount, byte data, List<String> lore) {
		ItemStack item = new ItemStack(mat, amount, data);
		ItemMeta meta = item.getItemMeta();
		meta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
		meta.setDisplayName(nome);
		meta.setLore(lore);
		item.setItemMeta(meta);
		return item;
	}

	public static ItemStack Item(Material mat, String nome, int amount, byte data) {
		ItemStack item = new ItemStack(mat, amount, data);
		ItemMeta meta = item.getItemMeta();
		meta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
		meta.setDisplayName(nome);
		item.setItemMeta(meta);
		return item;
	}

	public static ItemStack ItemData(Material mat, String nome, int amount, int data, List<String> lore) {
		ItemStack item = new ItemStack(mat, amount, (byte) data);
		ItemMeta meta = item.getItemMeta();
		meta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
		meta.setDisplayName(nome);
		meta.setLore(lore);
		item.setItemMeta(meta);
		return item;
	}

	public static ItemStack Item(Material mat, String nome, int amount, byte data, Enchantment enchant, int level,
			List<String> lore) {
		ItemStack item = new ItemStack(mat, amount, data);
		ItemMeta meta = item.getItemMeta();
		meta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
		meta.setDisplayName(nome);
		meta.setLore(lore);
		meta.addEnchant(enchant, level, true);
		item.setItemMeta(meta);
		return item;
	}

	public static ItemStack Item(Material mat, String nome, int amount, byte data, Enchantment enchant, int level) {
		ItemStack item = new ItemStack(mat, amount, data);
		ItemMeta meta = item.getItemMeta();
		meta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
		meta.setDisplayName(nome);
		meta.addEnchant(enchant, level, true);
		item.setItemMeta(meta);
		return item;
	}
}
