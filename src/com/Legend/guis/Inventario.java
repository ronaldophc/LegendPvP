package com.Legend.guis;

import java.util.ArrayList;
import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.Legend.Main;
import com.Legend.Comandos.Admin;
import com.Legend.KD.API;
import com.Legend.kits.manager.Base;

public class Inventario implements Listener {

	public static void setarInv(Player p) {

		ItemStack kits = new ItemStack(Material.CHEST);
		ItemMeta kits2 = kits.getItemMeta();
		kits2.setDisplayName("§bKits");
		kits.setItemMeta(kits2);

		ItemStack tp = new ItemStack(Material.BOOK);
		ItemMeta tp2 = tp.getItemMeta();
		tp2.setDisplayName("§bTeleports");
		tp.setItemMeta(tp2);

		ItemStack loja = new ItemStack(Material.DIAMOND);
		ItemMeta loja2 = loja.getItemMeta();
		loja2.setDisplayName("§bLoja");
		loja.setItemMeta(loja2);

		p.getInventory().setItem(0, kits);
		p.getInventory().setItem(3, API.Item(Material.PAPER, "§bConfigs", 1, (byte) 0));
		p.getInventory().setItem(5, loja);
		p.getInventory().setItem(8, tp);
	}

	@EventHandler
	public static void interagirInv(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		ItemStack item = p.getItemInHand();
		if (((Base.temKit(p) == false) || Base.qualKit(p) == "Nenhum") && !(Admin.inadmin.contains(p))) {
			if (e.getAction().name().contains("RIGHT")) {
				if (item.hasItemMeta() && item.getItemMeta().hasDisplayName()) {
					String name = item.getItemMeta().getDisplayName();
					if (name.equals("§bKits")) {
						e.setCancelled(true);
						seletorKits(p);
					} else if (name.equals("§bTeleports")) {
						Warps.seletorWarps(p);
					} else if (name.equals("§bLoja")) {
						guiloja(p);
					}
				}
			}
		}
	}

	@EventHandler
	public void clickInv(InventoryClickEvent e) {
		if (e.getInventory().getName().startsWith("§bStatus")) {
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
			e.setCancelled(true);

		}
		if (e.getInventory().getName().equalsIgnoreCase("§bKits §6Free")) {
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
			e.setCancelled(true);
			if (e.getCurrentItem().getType() == Material.STONE_SWORD) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit pvp");
			} else if (e.getCurrentItem().getType() == Material.SPIDER_EYE) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit viper");
			} else if (e.getCurrentItem().getType() == Material.SEEDS) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit critical");
			} else if (e.getCurrentItem().getType() == Material.FIREWORK) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit kangaroo");
			} else if (e.getCurrentItem().getType() == Material.NETHER_FENCE) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit checkpoint");
			} else if (e.getCurrentItem().getType() == Material.WOOD_SWORD) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit achilles");
			} else if (e.getCurrentItem().getType() == Material.FISHING_ROD) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit fisherman");
			} else if (e.getCurrentItem().getType() == Material.STAINED_GLASS_PANE) {
				e.setCancelled(true);
			} else if (e.getCurrentItem().getType() == Material.WEB) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit snail");
			} else if (e.getCurrentItem().getType() == Material.LAVA_BUCKET) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit fireman");
			} else if (e.getCurrentItem().getType() == Material.SAND) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit camel");
			} else if (e.getCurrentItem().getType() == Material.BOW) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit archer");
			} else if (e.getCurrentItem().getType() == Material.IRON_AXE) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit viking");
			} else if (e.getCurrentItem().getType() == Material.LEATHER_CHESTPLATE) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit tank");
			} else if (e.getCurrentItem().getType() == Material.IRON_HELMET) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit ironhead");
			} else if (e.getCurrentItem().getType() == Material.DIAMOND) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit upgrader");
			} else if (e.getCurrentItem().getType() == Material.WOOD_HOE) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit reaper");
			} else if (e.getCurrentItem().getType() == Material.STAINED_CLAY) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit boxer");
			} else if (e.getCurrentItem().getType() == Material.CARPET) {
				e.setCancelled(true);
				Inv2.seletorKits2(p);
			} else if (e.getCurrentItem().getType() == Material.GLASS_BOTTLE) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit anticorona");
			} else if (e.getCurrentItem().getType() == Material.NETHER_STAR) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit naruto");
			} else if (e.getCurrentItem().getType() == Material.STICK) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit grandpa");
			} else if (e.getCurrentItem().getType() == Material.BLAZE_ROD) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit monk");
			} else if (e.getCurrentItem().getType() == Material.POTION) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit scout");
			} else if (e.getCurrentItem().getType() == Material.SNOW_BALL) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit switcher");
			}

		}
		if (e.getInventory().getName().equalsIgnoreCase("§bLoja")) {
			Player p = (Player) e.getWhoClicked();
			if (e.getCurrentItem() == null)
				return;
			if (e.getCurrentItem().getType() == null) {
				return;
			}
			if (e.getCurrentItem() != null && !e.getCurrentItem().getType().equals(Material.AIR)) {
				e.setCancelled(true);
			}
			e.setCancelled(true);
			if (e.getCurrentItem().getType() == Material.GOLD_AXE) {
				e.setCancelled(true);
				p.closeInventory();
				if ((p.hasPermission("legend.kit.thor")) || p.isOp() || p.hasPermission("legend.kit.*")) {
					p.sendMessage(Base.prefix + "§bVocê já tem esse Kit.");
					return;
				}
				if (API.getdinheiro(p) >= 5000) {
					API.removerDinheiro(p, 5000);
					Main.file.save();
					// Score2.createScoreboard(p);
					Bukkit.dispatchCommand(Bukkit.getConsoleSender(),
							"lp user " + p.getName() + " permission set legend.kit.thor");
					p.sendMessage(Base.prefix + "§aVocê comprou o §fKit §bThor§a.");
				} else {
					p.sendMessage(Base.prefix + "§cVocê não tem dinheiro suficiente.");
				}
			} else if (e.getCurrentItem().getType() == Material.FLINT) {
				e.setCancelled(true);
				p.closeInventory();
				if ((p.hasPermission("legend.kit.vampiro")) || p.isOp() || p.hasPermission("legend.kit.*")) {
					p.sendMessage(Base.prefix + "§bVocê já tem esse Kit.");
					return;
				}
				if (API.getdinheiro(p) >= 5000) {
					API.removerDinheiro(p, 5000);
					Main.file.save();
					Bukkit.dispatchCommand(Bukkit.getConsoleSender(),
							"lp user " + p.getName() + " permission set legend.kit.vampiro");
					p.sendMessage(Base.prefix + "§aVocê comprou o §fKit §bVampiro§a.");
				} else {
					p.sendMessage(Base.prefix + "§cVocê não tem dinheiro suficiente.");
				}
			} else if (e.getCurrentItem().getType() == Material.COAL_BLOCK) {
				e.setCancelled(true);
				p.closeInventory();
				if ((p.hasPermission("legend.kit.ninja")) || p.isOp() || p.hasPermission("legend.kit.*")) {
					p.sendMessage(Base.prefix + "§bVocê já tem esse Kit.");
					return;
				}
				if (API.getdinheiro(p) >= 5000) {
					API.removerDinheiro(p, 5000);
					Main.file.save();
					Bukkit.dispatchCommand(Bukkit.getConsoleSender(),
							"lp user " + p.getName() + " permission set legend.kit.ninja");
					p.sendMessage(Base.prefix + "§aVocê comprou o §fKit §bNinja§a.");
				} else {
					p.sendMessage(Base.prefix + "§cVocê não tem dinheiro suficiente.");
				}
			} else if (e.getCurrentItem().getType() == Material.ARROW) {
				e.setCancelled(true);
				p.closeInventory();
				if ((p.hasPermission("legend.kit.arrow")) || p.isOp() || p.hasPermission("legend.kit.*")) {
					p.sendMessage(Base.prefix + "§bVocê já tem esse Kit.");
					return;
				}
				if (API.getdinheiro(p) >= 5000) {
					API.removerDinheiro(p, 5000);
					Main.file.save();
					Bukkit.dispatchCommand(Bukkit.getConsoleSender(),
							"lp user " + p.getName() + " permission set legend.kit.arrow");
					p.sendMessage(Base.prefix + "§aVocê comprou o §fKit §bArrow§a.");
				} else {
					p.sendMessage(Base.prefix + "§cVocê não tem dinheiro suficiente.");
				}
			} else if (e.getCurrentItem().getType() == Material.STRING) {
				e.setCancelled(true);
				p.closeInventory();
				if (p.isOp() || p.hasPermission("legend.color")) {
					p.sendMessage(Base.prefix + "§bVocê já tem essa Permissão.");
					return;
				}
				if (API.getdinheiro(p) >= 5000) {
					API.removerDinheiro(p, 5000);
					Main.file.save();
					Bukkit.dispatchCommand(Bukkit.getConsoleSender(),
							"lp user " + p.getName() + " permission set legend.color");
					p.sendMessage(Base.prefix + "§aVocê comprou a Permissao de falar §fcolorido no §bChat§a.");
				} else {
					p.sendMessage(Base.prefix + "§cVocê não tem dinheiro suficiente.");
				}
			}
		}
	}

	public static void guiloja(Player p) {
		Inventory shop = Bukkit.createInventory(p, 54, "§bLoja");

		ItemStack loja = new ItemStack(Material.VINE);
		ItemMeta loja2 = loja.getItemMeta();
		loja2.setDisplayName("§2§l-=-");
		loja.setItemMeta(loja2);

		ItemStack iron = new ItemStack(Material.STAINED_GLASS_PANE);
		ItemMeta iron2 = iron.getItemMeta();
		iron2.setDisplayName("§b§l-=-");
		iron.setItemMeta(iron2);

		ItemStack tocha = new ItemStack(Material.REDSTONE_TORCH_ON);
		ItemMeta tocha2 = tocha.getItemMeta();
		tocha2.setDisplayName("§b§lKits §6§lLoja");
		tocha.setItemMeta(tocha2);

		ItemStack ironh = new ItemStack(Material.ARROW);
		ItemMeta ironh2 = ironh.getItemMeta();
		ironh2.setDisplayName("§b§lKit §6§lArrow");
		ArrayList<String> lore3 = new ArrayList<>();
		lore3.add("§7§lCompre este Kit por §a§lR$ §7§l5.000§7§l.");
		lore3.add("");
		if (p.hasPermission("legend.kit.arrow")) {
			lore3.add("§a§lVocê já possui esse kit");
		} else {
			lore3.add("§c§lVocê não possui esse kit");
			lore3.add("");
			lore3.add("§e§lClique para comprar");
		}
		ironh2.setLore(lore3);
		ironh.setItemMeta(ironh2);

		ItemStack thor = new ItemStack(Material.GOLD_AXE);
		ItemMeta thor2 = thor.getItemMeta();
		thor2.setDisplayName("§b§lKit §6§lThor");
		ArrayList<String> lore1 = new ArrayList<>();
		lore1.add("§7§lCompre este Kit por §a§lR$ §7§l5.000§7§l.");
		lore1.add("");
		if (p.hasPermission("legend.kit.thor")) {
			lore1.add("§a§lVocê já possui esse kit");
		} else {
			lore1.add("§c§lVocê não possui esse kit");
			lore1.add("");
			lore1.add("§e§lClique para comprar");
		}
		thor2.setLore(lore1);
		thor.setItemMeta(thor2);

		ItemStack ninja = new ItemStack(Material.COAL_BLOCK);
		ItemMeta ninja2 = ninja.getItemMeta();
		ninja2.setDisplayName("§b§lKit §6§lNinja");
		ArrayList<String> a2 = new ArrayList<>();
		a2.add("§7§lCompre este Kit por §a§lR$ §7§l5.000§7§l.");
		a2.add("");
		if (p.hasPermission("legend.kit.ninja")) {
			a2.add("§a§lVocê já possui esse kit");
		} else {
			a2.add("§c§lVocê não possui esse kit");
			a2.add("");
			a2.add("§e§lClique para comprar");
		}
		ninja2.setLore(a2);
		ninja.setItemMeta(ninja2);

		ItemStack vampiro = new ItemStack(Material.FLINT);
		ItemMeta vampiro2 = vampiro.getItemMeta();
		vampiro2.setDisplayName("§b§lKit §6§lVampiro");
		ArrayList<String> k1 = new ArrayList<>();
		k1.add("§7§lCompre este Kit por §a§lR$ §7§l5.000§7§l.");
		k1.add("");
		if (p.hasPermission("legend.kit.vampiro")) {
			k1.add("§a§lVocê já possui esse kit");
		} else {
			k1.add("§c§lVocê não possui esse kit");
			k1.add("");
			k1.add("§e§lClique para comprar");
		}
		vampiro2.setLore(k1);
		vampiro.setItemMeta(vampiro2);
		
		ItemStack color = new ItemStack(Material.STRING);
		ItemMeta color2 = color.getItemMeta();
		color2.setDisplayName("§b§lFalar §6§lColorido");
		ArrayList<String> k12 = new ArrayList<>();
		k12.add("§7§lCompre esta Permissão por §a§lR$ §7§l5.000§7§l.");
		k12.add("");
		if (p.hasPermission("legend.color")) {
			k12.add("§a§lVocê já possui essa permissão");
		} else {
			k12.add("§c§lVocê não possui essa permissão");
			k12.add("");
			k12.add("§e§lClique para comprar");
		}
		color2.setLore(k12);
		color.setItemMeta(color2);

		ItemStack coin = new ItemStack(Material.DIAMOND);
		ItemMeta coin2 = coin.getItemMeta();
		coin2.setDisplayName("§a§lDinheiro");
		ArrayList<String> c = new ArrayList<>();
		c.add("");
		c.add("§7§lVocê tem: §a§lR$ §7§l" + API.getdinheiro(p));
		coin2.setLore(c);
		coin.setItemMeta(coin2);

		for (int i = 0; i < 54; i++)
			shop.setItem(i, loja);

		shop.setItem(4, tocha);
		for (int i = 10; i <= 16; i++)
			shop.setItem(i, iron);

		shop.setItem(19, iron);
		shop.setItem(20, ninja);
		shop.setItem(21, vampiro);
		shop.setItem(22, thor);
		shop.setItem(23, iron);
		shop.setItem(24, color);
		shop.setItem(25, iron);
		shop.setItem(28, iron);
		shop.setItem(29, ironh);
		// shop.setItem(31, vampiro);
		// shop.setItem(32, thor);
		shop.setItem(32, iron);
		shop.setItem(34, iron);
		shop.setItem(49, coin);
		for (int i = 37; i <= 43; i++)
			shop.setItem(i, iron);

		p.openInventory(shop);
	}

	public static void seletorKits(Player p) {
		Inventory kits = Bukkit.createInventory(p, 54, "§bKits §6Free");

		ItemStack loja = new ItemStack(Material.VINE);
		ItemMeta loja2 = loja.getItemMeta();
		loja2.setDisplayName("§2§l-=-");
		loja.setItemMeta(loja2);

		ItemStack iron = new ItemStack(Material.STAINED_GLASS_PANE);
		ItemMeta iron2 = iron.getItemMeta();
		iron2.setDisplayName("§b§lSlot para §f§lKit §b§lfuturo");
		iron.setItemMeta(iron2);

		ItemStack tocha = new ItemStack(Material.REDSTONE_TORCH_ON);
		ItemMeta tocha2 = tocha.getItemMeta();
		tocha2.setDisplayName("§b§lKits §6§lFree");
		tocha.setItemMeta(tocha2);

		ItemStack ironh = new ItemStack(Material.IRON_HELMET);
		ItemMeta ironh2 = ironh.getItemMeta();
		ironh2.setDisplayName("§b§lKit §6§lIronHead");
		ArrayList<String> lore3 = new ArrayList<>();
		lore3.add("§7§lSeja imune a §c§lStompers§7§l!");
		lore3.add("");
		if (p.hasPermission("legend.kit.ironhead")) {
			lore3.add("§a§lVocê possui esse kit");
		} else {
			lore3.add("§c§lVocê não possui esse kit");
		}
		lore3.add("");
		lore3.add("§e§lClique para pegar");
		ironh2.setLore(lore3);
		ironh.setItemMeta(ironh2);

		ItemStack sharp = new ItemStack(Material.STONE_SWORD);
		ItemMeta sharp2 = sharp.getItemMeta();
		sharp2.setDisplayName("§b§lKit §6§lPvP");
		ArrayList<String> lore = new ArrayList<>();
		lore.add("§7§lKit sem §c§lHabilidade 1§7§l.");
		lore.add("");
		if (p.hasPermission("legend.kit.sharpness")) {
			lore.add("§a§lVocê possui esse kit");
		} else {
			lore.add("§c§lVocê não possui esse kit");
		}
		lore.add("");
		lore.add("§e§lClique para pegar");
		sharp2.setLore(lore);
		sharp.setItemMeta(sharp2);

		ItemStack viper = new ItemStack(Material.SPIDER_EYE);
		ItemMeta viper2 = viper.getItemMeta();
		viper2.setDisplayName("§b§lKit §6§lViper");
		ArrayList<String> lore1 = new ArrayList<>();
		lore1.add("§c§lEnvenene §7§lseus adversarios.");
		lore1.add("");
		if (p.hasPermission("legend.kit.viper")) {
			lore1.add("§a§lVocê possui esse kit");
		} else {
			lore1.add("§c§lVocê não possui esse kit");
		}
		lore1.add("");
		lore1.add("§e§lClique para pegar");
		viper2.setLore(lore1);
		viper.setItemMeta(viper2);

		ItemStack kangaroo = new ItemStack(Material.FIREWORK);
		ItemMeta kangaroo2 = kangaroo.getItemMeta();
		kangaroo2.setDisplayName("§b§lKit §6§lKangaroo");
		ArrayList<String> a2 = new ArrayList<>();
		a2.add("§7§lPule como um §c§lcanguru§7§l!");
		a2.add("");
		if (p.hasPermission("legend.kit.kangaroo")) {
			a2.add("§a§lVocê possui esse kit");
		} else {
			a2.add("§c§lVocê não possui esse kit");
		}
		a2.add("");
		a2.add("§e§lClique para pegar");
		kangaroo2.setLore(a2);
		kangaroo.setItemMeta(kangaroo2);

		ItemStack fisherman = new ItemStack(Material.FISHING_ROD);
		ItemMeta fisherman2 = fisherman.getItemMeta();
		fisherman2.setDisplayName("§b§lKit §6§lFisherman");
		ArrayList<String> a = new ArrayList<>();
		a.add("§c§lPuxe §7§lseus adversarios!");
		a.add("");
		if (p.hasPermission("legend.kit.fisherman")) {
			a.add("§a§lVocê possui esse kit");
		} else {
			a.add("§c§lVocê não possui esse kit");
		}
		a.add("");
		a.add("§e§lClique para pegar");
		fisherman2.setLore(a);
		fisherman.setItemMeta(fisherman2);

		ItemStack boxer = new ItemStack(Material.STAINED_CLAY);
		ItemMeta boxer2 = boxer.getItemMeta();
		boxer2.setDisplayName("§b§lKit §6§lBoxer");
		ArrayList<String> b = new ArrayList<>();
		b.add("§7§lDe mais dano em seus §c§lgolpes§7§l!");
		b.add("");
		if (p.hasPermission("legend.kit.boxer")) {
			b.add("§a§lVocê possui esse kit");
		} else {
			b.add("§c§lVocê não possui esse kit");
		}
		b.add("");
		b.add("§e§lClique para pegar");
		boxer2.setLore(b);
		boxer.setItemMeta(boxer2);

		ItemStack snail = new ItemStack(Material.WEB);
		ItemMeta snail2 = snail.getItemMeta();
		snail2.setDisplayName("§b§lKit §6§lSnail");
		ArrayList<String> c = new ArrayList<>();
		c.add("§7§lDeixe seus adversarios§c§l lentos§7§l!");
		c.add("");
		if (p.hasPermission("legend.kit.snail")) {
			c.add("§a§lVocê possui esse kit");
		} else {
			c.add("§c§lVocê não possui esse kit");
		}
		c.add("");
		c.add("§e§lClique para pegar");
		snail2.setLore(c);
		snail.setItemMeta(snail2);

		ItemStack fireman = new ItemStack(Material.LAVA_BUCKET);
		ItemMeta fireman2 = fireman.getItemMeta();
		fireman2.setDisplayName("§b§lKit §6§lFireman");
		ArrayList<String> d = new ArrayList<>();
		d.add("§7§lDeixe seus adversários pegando §c§lfogo§7§l!");
		d.add("");
		if (p.hasPermission("legend.kit.fireman")) {
			d.add("§a§lVocê possui esse kit");
		} else {
			d.add("§c§lVocê não possui esse kit");
		}
		d.add("");
		d.add("§e§lClique para pegar");
		fireman2.setLore(d);
		fireman.setItemMeta(fireman2);

		ItemStack Camel = new ItemStack(Material.SAND);
		ItemMeta Camel2 = Camel.getItemMeta();
		Camel2.setDisplayName("§b§lKit §6§lCamel");
		ArrayList<String> e = new ArrayList<>();
		e.add("§7§lGanhe §c§ldefesa §7§lao andar na §c§lareia§7§l.");
		e.add("");
		if (p.hasPermission("legend.kit.camel")) {
			e.add("§a§lVocê possui esse kit");
		} else {
			e.add("§c§lVocê não possui esse kit");
		}
		e.add("");
		e.add("§e§lClique para pegar");
		Camel2.setLore(e);
		Camel.setItemMeta(Camel2);

		ItemStack archer = new ItemStack(Material.BOW);
		ItemMeta archer2 = archer.getItemMeta();
		archer2.setDisplayName("§b§lKit §6§lArcher");
		ArrayList<String> f = new ArrayList<>();
		f.add("§7§lGanhe um §c§larco §7§le uma §c§lflecha§7§l.");
		f.add("");
		if (p.hasPermission("legend.kit.archer")) {
			f.add("§a§lVocê possui esse kit");
		} else {
			f.add("§c§lVocê não possui esse kit");
		}
		f.add("");
		f.add("§e§lClique para pegar");
		archer2.setLore(f);
		archer.setItemMeta(archer2);

		ItemStack viking = new ItemStack(Material.IRON_AXE);
		ItemMeta viking2 = viking.getItemMeta();
		viking2.setDisplayName("§b§lKit §6§lViking");
		ArrayList<String> g = new ArrayList<>();
		g.add("§7§lSeja um §c§lViking§7§l!");
		g.add("");
		if (p.hasPermission("legend.kit.viking")) {
			g.add("§a§lVocê possui esse kit");
		} else {
			g.add("§c§lVocê não possui esse kit");
		}
		g.add("");
		g.add("§e§lClique para pegar");
		viking2.setLore(g);
		viking.setItemMeta(viking2);

		ItemStack tank = new ItemStack(Material.LEATHER_CHESTPLATE);
		ItemMeta tank2 = tank.getItemMeta();
		tank2.setDisplayName("§b§lKit §6§lTank");
		ArrayList<String> h = new ArrayList<>();
		h.add("§7§lMais §c§ldefesa §7§le menos §c§lataque§7§l!");
		h.add("");
		if (p.hasPermission("legend.kit.tank")) {
			h.add("§a§lVocê possui esse kit");
		} else {
			h.add("§c§lVocê não possui esse kit");
		}
		h.add("");
		h.add("§e§lClique para pegar");
		tank2.setLore(h);
		tank.setItemMeta(tank2);

		ItemStack crit = new ItemStack(Material.SEEDS);
		ItemMeta crit2 = crit.getItemMeta();
		crit2.setDisplayName("§b§lKit §6§lCritical");
		ArrayList<String> h1 = new ArrayList<>();
		h1.add("§7§lTenha chance de dar §c§lgolpes criticos§7§l!");
		h1.add("");
		if (p.hasPermission("legend.kit.critical")) {
			h1.add("§a§lVocê possui esse kit");
		} else {
			h1.add("§c§lVocê não possui esse kit");
		}
		h1.add("");
		h1.add("§e§lClique para pegar");
		crit2.setLore(h1);
		crit.setItemMeta(crit2);

		ItemStack string = new ItemStack(Material.STRING);
		ItemMeta string2 = string.getItemMeta();
		string2.setDisplayName("§b§lKits §6§lLegendPvP");
		string.setItemMeta(string2);

		ItemStack upgrader = new ItemStack(Material.DIAMOND);
		ItemMeta upgrader2 = upgrader.getItemMeta();
		upgrader2.setDisplayName("§b§lKit §6§lUpgrader");
		ArrayList<String> k = new ArrayList<>();
		k.add("§7§lSua espada melhora a §c§lcada Kill§7§l.");
		k.add("");
		if (p.hasPermission("legend.kit.upgrader")) {
			k.add("§a§lVocê possui esse kit");
		} else {
			k.add("§c§lVocê não possui esse kit");
		}
		k.add("");
		k.add("§e§lClique para pegar");
		upgrader2.setLore(k);
		upgrader.setItemMeta(upgrader2);

		ItemStack reaper = new ItemStack(Material.WOOD_HOE);
		ItemMeta reaper2 = reaper.getItemMeta();
		reaper2.setDisplayName("§b§lKit §6§lReaper");
		ArrayList<String> k4 = new ArrayList<>();
		k4.add("§7§lDe efeito de §c§lWither §7§lcom sua §c§lfoice§7§l.");
		k4.add("");
		if (p.hasPermission("legend.kit.reaper")) {
			k4.add("§a§lVocê possui esse kit");
		} else {
			k4.add("§c§lVocê não possui esse kit");
		}
		k4.add("");
		k4.add("§e§lClique para pegar");
		reaper2.setLore(k4);
		reaper.setItemMeta(reaper2);

		ItemStack ac = new ItemStack(Material.GLASS_BOTTLE);
		ItemMeta ac2 = ac.getItemMeta();
		ac2.setDisplayName("§b§lKit §6§lAnti Corona");
		ArrayList<String> k44 = new ArrayList<>();
		k44.add("§7§lUse mascara e seja imune ao §c§lCorona§7§l!");
		k44.add("");
		if (p.hasPermission("legend.kit.anticorona")) {
			k44.add("§a§lVocê possui esse kit");
		} else {
			k44.add("§c§lVocê não possui esse kit");
		}
		k44.add("");
		k44.add("§e§lClique para pegar");
		ac2.setLore(k44);
		ac.setItemMeta(ac2);

		ItemStack naruto = new ItemStack(Material.NETHER_STAR);
		ItemMeta naruto2 = naruto.getItemMeta();
		naruto2.setDisplayName("§b§lKit §6§lNaruto");
		ArrayList<String> k445 = new ArrayList<>();
		k445.add("§7§lTenha os poderes do §c§lNaruto§7§l!");
		k445.add("");
		if (p.hasPermission("legend.kit.naruto")) {
			k445.add("§a§lVocê possui esse kit");
		} else {
			k445.add("§c§lVocê não possui esse kit");
		}
		k445.add("");
		k445.add("§e§lClique para pegar");
		naruto2.setLore(k445);
		naruto.setItemMeta(naruto2);

		ItemStack grandpa = new ItemStack(Material.STICK);
		ItemMeta grandpa2 = grandpa.getItemMeta();
		grandpa2.setDisplayName("§b§lKit §6§lGrandpa");
		grandpa2.addEnchant(Enchantment.KNOCKBACK, 2, true);
		ArrayList<String> gp = new ArrayList<>();
		gp.add("§7§lCrie estrategias com muito §c§lKnockback!");
		gp.add("");
		if (p.hasPermission("legend.kit.grandpa")) {
			gp.add("§a§lVocê possui esse kit");
		} else {
			gp.add("§c§lVocê não possui esse kit");
		}
		gp.add("");
		gp.add("§e§lClique para pegar");
		grandpa2.setLore(gp);
		grandpa.setItemMeta(grandpa2);

		ItemStack kitsv = new ItemStack(Material.CARPET);
		ItemMeta kitsv2 = kitsv.getItemMeta();
		kitsv2.setDisplayName("§bPagina de Kits §6Vips");
		kitsv.setItemMeta(kitsv2);

		kits.setItem(0, loja);
		kits.setItem(1, loja);
		kits.setItem(2, loja);
		kits.setItem(3, loja);
		kits.setItem(5, loja);
		kits.setItem(6, loja);
		kits.setItem(7, loja);
		kits.setItem(9, loja);
		kits.setItem(17, loja);
		kits.setItem(18, loja);
		kits.setItem(26, loja);
		kits.setItem(27, loja);
		kits.setItem(35, loja);
		kits.setItem(36, loja);
		kits.setItem(44, loja);
		kits.setItem(45, loja);
		kits.setItem(46, loja);
		kits.setItem(47, loja);
		kits.setItem(48, loja);
		kits.setItem(50, loja);
		kits.setItem(51, loja);
		kits.setItem(52, loja);
		kits.setItem(53, loja);

		kits.setItem(4, tocha);
		kits.setItem(8, kitsv);
		kits.setItem(49, string);
		kits.addItem(sharp);
		kits.addItem(archer);
		kits.addItem(tank);
		kits.addItem(boxer);
		kits.addItem(Camel);
		kits.addItem(viper);
		kits.addItem(snail);
		kits.addItem(naruto);
		kits.addItem(fireman);
		kits.addItem(kangaroo);
		kits.addItem(reaper);
		kits.addItem(fisherman);
		kits.addItem(viking);
		kits.addItem(upgrader);
		kits.addItem(crit);
		kits.addItem(ac);
		kits.addItem(ironh);
		kits.addItem(grandpa);
		if (p.hasPermission("legend.kit.achilles")) {
			kits.addItem(API.Item(Material.WOOD_SWORD, "§b§lKit §6§lAchilles", 1, (byte) 0,
					Arrays.asList("§7§lUse seu kit achilles para", "§7§lreceber mais dano",
							"§7§lpela espada de §c§lmadeira", "§7§le menos dano pelas outras", "§7§lespadas!", "",
							"§a§lVocê possui esse kit", "", "§e§lClique para pegar")));
		} else {
			kits.addItem(API.Item(Material.WOOD_SWORD, "§b§lKit §6§lAchilles", 1, (byte) 0,
					Arrays.asList("§7§lUse seu kit achilles para", "§7§lreceber mais dano",
							"§7§lpela espada de §c§lmadeira", "§7§le menos dano pelas outras", "§7§lespadas!", "",
							"§c§lVocê não possui esse kit", "", "§e§lClique para pegar")));
		}
		if (p.hasPermission("legend.kit.monk")) {
			kits.addItem(API.Item(Material.BLAZE_ROD, "§b§lKit §6§lMonk", 1, (byte) 0,
					Arrays.asList(new String[] { "§7§lMova o item do adversario para o §c§lInvetario!", "",
							"§a§lVocê possui esse kit", "", "§e§lClique para pegar" })));
		} else {
			kits.addItem(API.Item(Material.BLAZE_ROD, "§b§lKit §6§lMonk", 1, (byte) 0,
					Arrays.asList(new String[] { "§7§lMova o item do adversario para o §c§lInvetario!", "",
							"§c§lVocê não possui esse kit", "", "§e§lClique para pegar" })));
		}
		if (p.hasPermission("legend.kit.scout")) {
			kits.addItem(API.Item(Material.POTION, "§b§lKit §6§lScout", 1, (byte) 34,
					Arrays.asList(new String[] { "§7§lUse seu §c§lscout§7§l para", "§7§lpara ficar com mais",
							"§7§lveloz!", "", "§a§lVocê possui esse kit", "", "§e§lClique para pegar" })));
		} else {
			kits.addItem(API.Item(Material.POTION, "§b§lKit §6§lScout", 1, (byte) 34,
					Arrays.asList(new String[] { "§7§lUse seu §c§lscout §7§lpara", "§7§lpara ficar com mais",
							"§7§lveloz!", "", "§c§lVocê não possui esse kit", "", "§e§lClique para pegar" })));
		}
		if (p.hasPermission("legend.kit.switcher")) {
			kits.addItem(API.Item(Material.SNOW_BALL, "§b§lKit §6§lSwitcher", 1, (byte) 0,
					Arrays.asList(new String[] { "§7§lTroque de lugar", "§7§lusando seu §c§lSwitcher", "",
							"§a§lVocê possui esse kit", "", "§e§lClique para pegar" })));
		} else {
			kits.addItem(API.Item(Material.SNOW_BALL, "§b§lKit §6§lSwitcher", 1, (byte) 0,
					Arrays.asList(new String[] { "§7§lTroque de lugar", "§7§lusando seu §c§lSwitcher", "",
							"§c§lVocê não possui esse kit", "", "§e§lClique para pegar" })));
		}
		if (p.hasPermission("legend.kit.checkpoint")) {
			kits.addItem(API.Item(Material.NETHER_FENCE, "§b§lKit §6§lCheckPoint", 1, (byte) 0,
					Arrays.asList(new String[] { "§7§lUse seu checkpoint para", "§7§lsalvar e se §c§lteletransportar",
							"§7§lpara uma localização!", "", "§a§lVocê possui esse kit", "",
							"§e§lClique para pegar" })));
		} else {
			kits.addItem(API.Item(Material.NETHER_FENCE, "§b§lKit §6§lCheckPoint", 1, (byte) 0,
					Arrays.asList(new String[] { "§7§lUse seu checkpoint para", "§7§lsalvar e se §c§lteletransportar",
							"§7§lpara uma localização!", "", "§c§lVocê não possui esse kit", "",
							"§e§lClique para pegar" })));
		}
		for (int i = 39; i < 44; i++) {
			kits.setItem(i, iron);
		}

		p.openInventory(kits);
	}

}
