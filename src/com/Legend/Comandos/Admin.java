package com.Legend.Comandos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.SkullType;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.scheduler.BukkitRunnable;

import com.Legend.Main;
import com.Legend.KD.API;
import com.Legend.guis.Inventario;
import com.Legend.guis.Title;
import com.Legend.kits.manager.Base;
import com.Legend.screenshare.ScreenShareAPI;

public class Admin implements CommandExecutor, Listener {

	public static List<Player> inadmin = new ArrayList<Player>();

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if (!(sender instanceof Player)) {
			return true;
		}
		if (cmd.getName().equalsIgnoreCase("admin")) {
			Player p = (Player) sender;
			if (p.hasPermission("legend.admin")) {
				if (!(inadmin.contains(p))) {
					API.clearPlayer(p);
					makeVanish(p);
					updateVanished(p);
					p.sendMessage(Base.prefix + "§bVocê entrou no §cModo Admin§b.");
					for (Player on1 : Bukkit.getOnlinePlayers()) {
						if (on1.isOp()) {
							if (on1 == p) {

							} else {
								on1.sendMessage(Base.prefix + "§c§l" + p.getName() + " ENTROU NO MODO ADMIN");
							}
						}
					}
					Base.tirarKit(p);
					p.getInventory().clear();
					ItemAdmin(p);
					p.setGameMode(GameMode.CREATIVE);
					inadmin.add(p);
				} else if (inadmin.contains(p)) {
					p.sendMessage(Base.prefix + "§bVocê saiu do §cModo Admin§b.");
					desmakeVanish(p);
					for (Player on1 : Bukkit.getOnlinePlayers()) {
						if (on1.isOp()) {
							if (on1 == p) {

							} else {
								on1.sendMessage(Base.prefix + "§c§l" + p.getName() + " SAIU DO MODO ADMIN");
							}
						}
					}
					API.clearPlayer(p);
					Base.tirarKit(p);
					p.setGameMode(GameMode.CREATIVE);
					p.getInventory().clear();
					Inventario.setarInv(p);
					inadmin.remove(p);
				}
			}
		}

		return false;
	}

	public void ItemAdmin(Player p) {

		ItemStack bus = new ItemStack(Material.COMPASS);
		ItemMeta bus2 = bus.getItemMeta();
		bus2.setDisplayName("§cJogadores");
		bus.setItemMeta(bus2);

		ItemStack sti = new ItemStack(Material.STICK);
		ItemMeta sti2 = sti.getItemMeta();
		sti2.setDisplayName("§cTestar Knockback");
		sti2.addEnchant(Enchantment.KNOCKBACK, 50, true);
		sti.setItemMeta(sti2);

		ItemStack sop = new ItemStack(Material.MUSHROOM_SOUP);
		ItemMeta sop2 = sop.getItemMeta();
		sop2.setDisplayName("§cTestar Autosoup");
		sop.setItemMeta(sop2);

		ItemStack ss = new ItemStack(Material.IRON_FENCE);
		ItemMeta ss2 = ss.getItemMeta();
		ss2.setDisplayName("§cScreenShare");
		ss.setItemMeta(ss2);

		ItemStack kaf = new ItemStack(Material.SLIME_BALL);
		ItemMeta kaf2 = kaf.getItemMeta();
		kaf2.setDisplayName("§cTestar KillAura/FF");
		kaf.setItemMeta(kaf2);

		ItemStack cps = new ItemStack(Material.IRON_INGOT);
		ItemMeta cps2 = cps.getItemMeta();
		cps2.setDisplayName("§cChecar CPS");
		cps.setItemMeta(cps2);

		p.getInventory().setItem(0, bus);
		p.getInventory().setItem(1, API.Item(Material.GOLD_NUGGET, "§cRenovar Inv", 1, (byte) 0));
		p.getInventory().setItem(3, sti);
		p.getInventory().setItem(4, sop);
		p.getInventory().setItem(5, ss);
		p.getInventory().setItem(6, kaf);
		p.getInventory().setItem(7, cps);
		p.getInventory().setItem(8, API.Item(Material.NAME_TAG, "§cVer Kit", 1, (byte) 0));
	}

	@EventHandler(priority = EventPriority.HIGH)
	public static void interagirInv(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		if (inadmin.contains(p)) {
			if (p.getItemInHand().getType() == Material.GOLD_NUGGET) {
				makeVanish(p);
				updateVanished(p);
				p.sendMessage(Base.prefix + "§cVocê renovou sua Invisibilidade.");
			}
			if (p.getItemInHand().getType() == Material.COMPASS) {
				e.setCancelled(true);
				Inventory inv = Bukkit.createInventory(p, 54, "§4Players online:");
				for (Player on : Bukkit.getOnlinePlayers()) {

					ItemStack item = new ItemStack(Material.SKULL_ITEM, 1, (byte) SkullType.PLAYER.ordinal());
					ItemMeta meta = item.getItemMeta();
					meta.setDisplayName("§a" + on.getName());
					meta.setLore(Arrays.asList(new String[] { " ", "§aClique para teleportar" }));
					item.setItemMeta(meta);

					ItemStack item2 = item;
					SkullMeta meta2 = (SkullMeta) item.getItemMeta();
					meta2.setOwner(p.getName());
					item2.setItemMeta(meta2);

					inv.addItem(item2);
				}
				p.openInventory(inv);
			}
		}
	}

	@EventHandler
	public void Click(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		if (e.getInventory().getTitle().equalsIgnoreCase("§4Players online:")) {
			ItemStack item = e.getCurrentItem();
			if (item != null && !item.getType().equals(Material.AIR)) {
				e.setCancelled(true);
				Player t = Bukkit.getPlayer(ChatColor.stripColor(item.getItemMeta().getDisplayName()));
				p.closeInventory();
				p.teleport(t);
			}
		}
	}

	public static HashMap<Player, Player> ff = new HashMap<Player, Player>();
	public static HashMap<Player, Integer> hits = new HashMap<>();
	public HashMap<Player, Integer> cps = new HashMap<>();
	public HashMap<Player, Player> macro = new HashMap<>();
	public HashMap<Player, Integer> clicks = new HashMap<>();

	@EventHandler
	public void SeeInv(PlayerInteractEntityEvent e) {
		if (e.getRightClicked() instanceof Player) {
			Player p = e.getPlayer();
			Player t = (Player) e.getRightClicked();
			if (inadmin.contains(p)) {
				if (p.getItemInHand().getType().equals(Material.AIR)) {
					p.openInventory(t.getInventory());
				}
				if (!p.getItemInHand().getType().equals(Material.AIR) && p.getItemInHand().hasItemMeta()
						&& p.getItemInHand().getItemMeta().hasDisplayName()) {
					String name = p.getItemInHand().getItemMeta().getDisplayName();
					if (name.equals("§cScreenShare")) {
						ScreenShareAPI ss = new ScreenShareAPI(p, t);
						ss.sendSS();
					}
					if (name.equals("§cVer Kit")) {
						e.setCancelled(true);
						p.sendMessage(
								Base.prefix + "§cJogador: §f" + t.getName() + "§c. Kit: §f" + Base.qualKit(t) + "§c.");
					}
					if (name.equals("§cTestar Autosoup")) {
						e.setCancelled(true);
						if (checkingAS(t)) {
							p.sendMessage(
									"§cEste jogador já esta sendo checado por " + ((Player) as.get(t)).getName() + ".");
							return;
						}
						if (checkingAS(p)) {
							p.sendMessage("§cVocê já está checando um jogador.");
							return;
						}
						checkAS(p, t);
					}
					if (name.equals("§cTestar KillAura/FF")) {
						if (ff.containsKey(t)) {
							p.sendMessage(
									"§cEste jogador já está sendo checado por " + ((Player) ff.get(t)).getName() + ".");
							return;
						}
						e.setCancelled(true);
						ff.put(t, p);
						t.showPlayer(p);
						p.sendMessage("§7Checagem iniciada.");
						p.setGameMode(GameMode.ADVENTURE);
						new BukkitRunnable() {
							public void run() {
								if (!t.hasPermission("pvp.admin")) {
									t.hidePlayer(p);
								}
								ff.remove(t);
								p.setGameMode(GameMode.CREATIVE);
								p.sendMessage("§aChecagem completa.");
								p.sendMessage(" ");
								p.sendMessage("§6§lCHECAGEM KILL-AURA/FF");
								p.sendMessage("§fJogador: §e" + t.getName());
								if (hits.containsKey(t)) {
									p.sendMessage("§fHitou você: §aSim");
									p.sendMessage("§fNúmero de hits: §e" + hits.get(t));
								} else {
									p.sendMessage("§fHitou você: §cNão");
								}
								p.sendMessage(" ");
								hits.remove(t);
							}
						}.runTaskLater(Main.plugin, 100);
					}
					if (name.equals("§cChecar CPS")) {
						if (macro.containsKey(p)) {
							p.sendMessage("§cVocê já está checando CPS de outro jogador.");
							return;
						}
						if (cps.containsKey(t) && macro.containsKey(t)) {
							p.sendMessage(
									"§cEste jogador já está sendo checado por " + ((Player) macro.get(t)).getName());
							return;
						}
						cps.put(t, 0);
						macro.put(t, p);
						clicks.put(t, 0);
						p.sendMessage("§7Checando CPS:");

						new BukkitRunnable() {
							int valor1 = 0;
							int valor2 = 0;
							int valor3 = 0;
							int valor4 = 0;
							int valor5 = 0;
							int valor6 = 0;
							int valor7 = 0;
							int valor8 = 0;
							int valor9 = 0;
							int valor10 = 0;
							int tick = 0;

							public void run() {
								if (cps.containsKey(t)) {
									tick++;
									Title.sendActionBar(p, "§eCPS de " + t.getName() + ": §f" + cps.get(t));
									if (tick == 1 * 20) {
										valor1 = cps.get(t);
										cps.put(t, 0);
									} else if (tick == 2 * 20) {
										valor2 = cps.get(t);
										cps.put(t, 0);
									}
									if (tick == 3 * 20) {
										valor3 = cps.get(t);
										cps.put(t, 0);
									}
									if (tick == 4 * 20) {
										valor4 = cps.get(t);
										cps.put(t, 0);
									}
									if (tick == 5 * 20) {
										valor5 = cps.get(t);
										cps.put(t, 0);
									}
									if (tick == 6 * 20) {
										valor6 = cps.get(t);
										cps.put(t, 0);
									}
									if (tick == 7 * 20) {
										valor7 = cps.get(t);
										cps.put(t, 0);
									}
									if (tick == 8 * 20) {
										valor8 = cps.get(t);
										cps.put(t, 0);
									}
									if (tick == 9 * 20) {
										valor9 = cps.get(t);
										cps.put(t, 0);
									}
									if (tick == 10 * 20) {
										valor10 = cps.get(t);
										cps.put(t, 0);
										p.sendMessage(" ");
										p.sendMessage("§6§lCHECAGEM CPS");
										p.sendMessage("§fJogador: §e" + t.getName());
										int media = (valor1 + valor2 + valor3 + valor4 + valor5 + valor6 + valor7
												+ valor8 + valor9 + valor10) / 10;
										p.sendMessage("§fMédia de CPS: §e" + media);
										p.sendMessage("§fClicks no total: §e" + clicks.get(t));
										cps.remove(t);
										macro.remove(t);
										clicks.remove(t);
										Title.sendActionBar(p, "§aChecagem completa.");
										cancel();
									}
								}
							}
						}.runTaskTimer(Main.plugin, 0, 1);
						e.setCancelled(true);
					}
				}
			}
		}
	}

	public static HashMap<Player, Player> as = new HashMap<Player, Player>();
	public HashMap<Player, ItemStack[]> inv = new HashMap<Player, ItemStack[]>();

	public void checkAS(Player p, Player t) {
		as.put(p, t);
		as.put(t, p);
		inv.put(t, t.getInventory().getContents());
		p.openInventory(t.getInventory());
		t.getInventory().clear();
		t.setHealth(20);
		t.damage(18.0D);
		for (int i = 13; i < 16; i++) {
			ItemStack sop = new ItemStack(Material.MUSHROOM_SOUP);
			ItemMeta sop2 = sop.getItemMeta();
			sop2.setDisplayName("§cTestar Autosoup");
			sop.setItemMeta(sop2);
			t.getInventory().setItem(i, sop);
		}
		new BukkitRunnable() {
			public void run() {
				int tomadas = 0;
				for (ItemStack item : t.getInventory().getContents()) {
					if (item != null && item.getType().equals(Material.BOWL) && item.getAmount() > 0) {
						tomadas += item.getAmount();
					}
				}
				t.getInventory().clear();
				t.getInventory().setContents(inv.get(t));
				inv.remove(t);
				t.setHealth(20);
				p.closeInventory();
				p.sendMessage(" ");
				p.sendMessage("§6§lCHECAGEM AUTO-SOUP");
				p.sendMessage("§fJogador: §e" + t.getName());
				p.sendMessage("§fSopas tomadas: §e" + tomadas);
				if (tomadas > 0) {
					if (tomadas == 1) {
						p.sendMessage("§fAcusação: §eSuspeito");
					}
					if (tomadas == 2) {
						p.sendMessage("§fAcusação: §6Possívelmente");
					}
					if (tomadas == 3) {
						p.sendMessage("§fAcusação: §cUsando");
					}
				} else {
					p.sendMessage("§fAcusação: §aLivre");
				}
				p.sendMessage(" ");
				as.remove(t);
				as.remove(p);
			}
		}.runTaskLater(Main.plugin, 60);
	}

	public boolean checkingAS(Player p) {
		return as.containsKey(p);
	}

	@EventHandler
	public void CheckCPS(PlayerInteractEvent e) {
		if (e.getAction().name().contains("LEFT")) {
			Player p = e.getPlayer();
			if (cps.containsKey(p)) {
				cps.put(p, cps.get(p) + 1);
				clicks.put(p, clicks.get(p) + 1);
			}
		}
	}

	@EventHandler
	public void CheckKillAura(EntityDamageByEntityEvent e) {
		if (e.getEntity() instanceof Player && e.getDamager() instanceof Player) {
			Player t = (Player) e.getDamager();
			if (as.containsKey(t)) {
				e.setCancelled(true);
			}
			if (cps.containsKey(t)) {
				cps.put(t, cps.get(t) + 1);
				clicks.put(t, clicks.get(t) + 1);
			}
			if (ff.containsKey(t)) {
				Player p = ff.get(t);
				if (e.getEntity().equals(p)) {
					if (!hits.containsKey(t)) {
						hits.put(t, 1);
					} else {
						hits.put(t, hits.get(t) + 1);
					}
				}
			}
		}
	}

	public static void updateVanished(Player p) {
		for (Player player : Bukkit.getOnlinePlayers()) {
			if (!player.getName().equals(p.getName())) {
				if (player.hasPermission("legend.admin")) {
					player.showPlayer(p);
				} else {
					if (player.canSee(p)) {
						player.hidePlayer(p);
					}
				}
			}
		}
	}

	public static void makeVanish(Player p) {
		for (Player player : Bukkit.getOnlinePlayers()) {
			if (!player.getName().equals(p.getName())) {
				if (player.hasPermission("legend.admin")) {
					player.showPlayer(p);
				} else {
					if (player.canSee(p)) {
						player.hidePlayer(p);
					}
				}
			}
		}
	}

	public static void desmakeVanish(Player p) {

		for (Player player : Bukkit.getOnlinePlayers()) {
			if (!player.getName().equals(p.getName())) {
				player.showPlayer(p);
			}
		}
	}

	public static void Atma(Player p) {
		for (Player player : Bukkit.getOnlinePlayers()) {
			if (!player.getName().equals(p.getName())) {
				if (!(inadmin.contains(player)))
					p.showPlayer(player);
			}
		}
	}
}
