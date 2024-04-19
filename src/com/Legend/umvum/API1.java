package com.Legend.umvum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.SkullType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;

import com.Legend.Main;
import com.Legend.Comandos.Admin;
import com.Legend.KD.API;
import com.Legend.kits.manager.Base;
import com.Legend.warps.WarpAPI;

public class API1 {

	public static List<Player> em1v1 = new ArrayList<>();
	public static List<Player> fila = new ArrayList<>();
	public static HashMap<Player, Player> batalhando = new HashMap<>();
	public static HashMap<Player, Player> convidado = new HashMap<Player, Player>();

	public static void setarItens(Player p) {
		p.getInventory().clear();
		API.clearPlayer(p);
		ItemStack speed = new ItemStack(Material.INK_SACK, 1, (short) 8);
		ItemMeta speed2 = speed.getItemMeta();
		speed2.setDisplayName("§b§l1V1 §6§lSpeed");
		speed.setItemMeta(speed2);
		p.getInventory().setItem(1, speed);

		ItemStack click = new ItemStack(Material.BLAZE_ROD);
		ItemMeta click2 = click.getItemMeta();
		click2.setDisplayName("§b§l1v1");
		click.setItemMeta(click2);
		p.getInventory().setItem(0, click);

		ItemStack sair = new ItemStack(Material.EMERALD);
		ItemMeta sair2 = sair.getItemMeta();
		sair2.setDisplayName("§b§lSair");
		sair.setItemMeta(sair2);
		p.getInventory().setItem(8, sair);

		p.getInventory().setItem(4,
				API.Item(Material.SKULL_ITEM, "§b§lInfos §6§l1v1", 1, (byte) SkullType.PLAYER.ordinal()));
	}

	public static void chamar(Player p, Player t) {
		if (Base.qualKit(p) == "1v1" && Base.qualKit(t) == "1v1") {
			if (!(em1v1.contains(p)) && !(em1v1.contains(t))) {
				if (!batalhando.containsKey(t) && !batalhando.containsKey(p)) {
					if (convidado.containsKey(t) && convidado.containsKey(p)) {
						if (convidado.get(t) == p && convidado.get(p) == t) {
							convidado.remove(t);
							convidado.remove(p);
							batalhar(p, t);
							p.sendMessage("§aVocê e " + t.getName() + " irão batalhar. Que vença o melhor.");
							t.sendMessage("§aVocê e " + p.getName() + " irão batalhar. Que vença o melhor.");
						} else {
							convidado.put(p, t);
							p.sendMessage("§eVocê desafiou " + t.getName() + " para uma batalha.");
							t.sendMessage("§e" + p.getName() + " te desafiou para uma batalha.");
							new BukkitRunnable() {
								public void run() {
									convidado.remove(t);
									convidado.remove(p);
								}
							}.runTaskLater(Main.plugin, 100);
						}
					} else {
						convidado.put(p, t);
						p.sendMessage("§eVocê desafiou " + t.getName() + " para uma batalha.");
						t.sendMessage("§e" + p.getName() + " te desafiou para uma batalha.");
						new BukkitRunnable() {
							public void run() {
								convidado.remove(t);
								convidado.remove(p);
							}
						}.runTaskLater(Main.plugin, 100);
					}
				} else {
					p.sendMessage(Base.prefix + "§cAlgum dos dois jogadores já está batalhando.");
				}
			} else {
				p.sendMessage(Base.prefix + "§cVocê só pode desafiar jogadores na warp 1v1.");
			}
		}
	}

	public static void resetX1(Player p) {
		API.clearPlayer(p);
		batalhando.remove(p);
		p.teleport(WarpAPI.getLocation("1v1.lobby"));
		setarItens(p);
		em1v1.remove(p);
		convidado.remove(p);
		Base.setarKit(p, "1v1");
		Admin.Atma(p);
	}

	public static void fila(Player p) {
		if (!(batalhando.containsKey(p)) && !(batalhando.containsValue(p))) {
			if (!(fila.contains(p))) {
				if (fila.size() == 0) {
					fila.add(p);
					p.setItemInHand(API.Item(Material.INK_SACK, "§b§l1V1 §6§lSpeed", 1, (byte) 10));
					p.sendMessage(Base.prefix + "§dVocê entrou na Fila do §51v1§d, aguarde outro jogador entrar.");
				} else if (fila.size() == 1) {
					Player t = fila.get(0);
					p.sendMessage(Base.prefix + "§dVocê irá batalhar contra: §c" + t.getName());
					t.sendMessage(Base.prefix + "§dVocê irá batalhar contra: §c" + p.getName());
					batalhar(p, t);
				}
			} else if (fila.contains(p)) {
				fila.remove(p);
				p.sendMessage(Base.prefix + "§dVocê saiu da fila §51v1§d.");
				ItemStack speed = new ItemStack(Material.INK_SACK, 1, (short) 8);
				ItemMeta speed2 = speed.getItemMeta();
				speed2.setDisplayName("§b§l1V1 §6§lSpeed");
				speed.setItemMeta(speed2);
				p.setItemInHand(speed);
			}
		} else {
			fila.remove(p);
		}
	}

	public static void batalhar(Player p, Player t) {
		batalhando.put(p, t);
		batalhando.put(t, p);
		em1v1.add(t);
		em1v1.add(p);
		fila.remove(p);
		fila.remove(t);
		Location l1 = WarpAPI.getLocation("1v1.pos1");
		Location l2 = WarpAPI.getLocation("1v1.pos2");
		API.clearPlayer(p);
		API.clearPlayer(t);
		p.getInventory().clear();
		t.getInventory().clear();
		ItemStack espada = new ItemStack(Material.STONE_SWORD);
		ItemMeta espada2 = espada.getItemMeta();
		espada2.setDisplayName("§bEspada");
		espada.setItemMeta(espada2);
		p.getInventory().setItem(0, espada);
		t.getInventory().setItem(0, espada);
		for (int i = 1; i < 9; i++) {
			p.getInventory().addItem(new ItemStack(Material.MUSHROOM_SOUP));
			t.getInventory().addItem(new ItemStack(Material.MUSHROOM_SOUP));
		}
		p.teleport(l1);
		t.teleport(l2);
		for (Player on : Bukkit.getOnlinePlayers()) {
			if (!on.equals(p) && !on.equals(t)) {
				p.hidePlayer(on);
				t.hidePlayer(on);
			}
		}
	}

	public static int getP(String kit) {
		int b = 0;
		for (Player a : Bukkit.getOnlinePlayers()) {
			if (Base.qualKit(a) == kit) {
				b += 1;
			}
		}
		return b;
	}

	public static int getkills(Player p) {
		return Main.x1.getConfig().getInt(String.valueOf(p.getName()) + ".Kills");
	}
	
	public static int getkills(String p) {
		return Main.x1.getConfig().getInt(String.valueOf(p) + ".Kills");
	}

	public static void setkills(Player p) {
		Main.x1.getConfig().set(String.valueOf(p.getName()) + ".Kills", Integer.valueOf(getkills(p) + 1));
		Main.x1.save();
	}

	public static int getmortes(Player p) {
		return Main.x1.getConfig().getInt(String.valueOf(p.getName()) + ".Mortes");
	}
	public static int getmortes(String p) {
		return Main.x1.getConfig().getInt(String.valueOf(p) + ".Mortes");
	}

	public static void setmortes(Player p) {
		Main.x1.getConfig().set(String.valueOf(p.getName()) + ".Mortes", Integer.valueOf(getmortes(p) + 1));
		Main.x1.save();
	}
	
	public static HashMap<Player, Integer> ks = new HashMap<>();
	
	public static void addKs(Player p) {
		if (!ks.containsKey(p)) {
			ks.put(p, 1);
		} else {
			ks.put(p, ks.get(p) + 1);
		}
		if (ks.get(p) % 5 == 0) {
			Bukkit.broadcastMessage(
					Base.prefix + "§bJogador §c" + p.getName() + " §bestá com um WinStreak de §c" + ks.get(p) + "§b, na 1v1!");
		}
		if (getKs(p) > Main.x1.getConfig().getInt(String.valueOf(p.getName()) + ".TopKS")) {
			Main.x1.getConfig().set(String.valueOf(p.getName()) + ".TopKS", Integer.valueOf(getKs(p)));
			Main.x1.save();
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
}
