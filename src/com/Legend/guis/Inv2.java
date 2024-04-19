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

public class Inv2 implements Listener {

	@EventHandler
	public void clickInv(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		if (e.getInventory().getName().equalsIgnoreCase("§bKits §6Vips §f1/2")) {
			e.setCancelled(true);
			if (e.getCurrentItem() == null) return;
			if (e.getCurrentItem().getItemMeta() == null)
				return;
			if(e.getCurrentItem().getType() == null) {
				return;
			}
			if (e.getCurrentItem() != null && !e.getCurrentItem().getType().equals(Material.AIR)) {
				e.setCancelled(true);
			}
			if (e.getCurrentItem().getType() == Material.IRON_BOOTS) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit stomper");
			} else if (e.getCurrentItem().getType() == Material.GOLD_AXE) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit thor");
			} else if (e.getCurrentItem().getType() == Material.COAL_BLOCK) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit ninja");
			} else if (e.getCurrentItem().getType() == Material.COAL) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit ajnin");
			} else if (e.getCurrentItem().getType() == Material.SLIME_BLOCK) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit hulk");
			} else if (e.getCurrentItem().getType() == Material.CHAINMAIL_CHESTPLATE) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit tankup");
			} else if (e.getCurrentItem().getType() == Material.REDSTONE) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit berserker");
			} else if (e.getCurrentItem().getType() == Material.ANVIL) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit anchor");
			} else if (e.getCurrentItem().getType() == Material.FIREBALL) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit pyro");
			}  else if (e.getCurrentItem().getType() == Material.IRON_FENCE) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit gladiator");
			} else if (e.getCurrentItem().getType() == Material.ARROW) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit arrow");
			} else if (e.getCurrentItem().getType() == Material.MUSHROOM_SOUP) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit resouper");
			} else if (e.getCurrentItem().getType() == Material.REDSTONE_BLOCK) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit deshfire");
			} else if (e.getCurrentItem().getType() == Material.DROPPER) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit neo");
			} else if (e.getCurrentItem().getType() == Material.CARPET && e.getSlot() == 0) {
				e.setCancelled(true);
				Inventario.seletorKits(p);
			} else if (e.getCurrentItem().getType() == Material.CARPET && e.getSlot() == 8) {
				e.setCancelled(true);
				Inv3.seletorKits3(p);
			} else if (e.getCurrentItem().getType() == Material.STAINED_GLASS_PANE) {
				e.setCancelled(true);
			} else if (e.getCurrentItem().getType() == Material.FLINT) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit vampiro");
			} else if (e.getCurrentItem().getType() == Material.SKULL_ITEM) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit corona");
			} else if (e.getCurrentItem().getType() == Material.BOWL) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit quickdroper");
			} else if (e.getCurrentItem().getType() == Material.GHAST_TEAR) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit lifestealer");
			} else if (e.getCurrentItem().getType() == Material.TNT) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit c4");
			} else if (e.getCurrentItem().getType() == Material.LAPIS_BLOCK) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit goku");
			} else if (e.getCurrentItem().getType() == Material.FEATHER) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit phantom");
			} else if (e.getCurrentItem().getType() == Material.GLASS_BOTTLE) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit ghost");
			} else if (e.getCurrentItem().getType() == Material.BEACON) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit avatar");
			} else if (e.getCurrentItem().getType() == Material.PACKED_ICE) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit frozen");
			} else if (e.getCurrentItem().getType() == Material.ENDER_PORTAL_FRAME) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit endermage");
			}
		}

	}

	public static void seletorKits2(Player p) {
		Inventory kits2 = Bukkit.createInventory(p, 54, "§bKits §6Vips §f1/2");
		
		ItemStack loja = new ItemStack(Material.VINE);
		ItemMeta loja2 = loja.getItemMeta();
		loja2.setDisplayName("§2§l-=-");
		loja.setItemMeta(loja2);

		ItemStack iron = new ItemStack(Material.STAINED_GLASS_PANE);
		ItemMeta iron2 = iron.getItemMeta();
		iron2.setDisplayName("§bSlot para §fKit §bfuturo");
		iron.setItemMeta(iron2);

		ItemStack tocha = new ItemStack(Material.REDSTONE_TORCH_ON);
		ItemMeta tocha2 = tocha.getItemMeta();
		tocha2.setDisplayName("§bPagina de §bKits §6Vips 1/2");
		tocha.setItemMeta(tocha2);

		ItemStack stomper = new ItemStack(Material.IRON_BOOTS);
		ItemMeta stomper2 = stomper.getItemMeta();
		stomper2.setDisplayName("§b§lKit §6§lStomper");
		ArrayList<String> lore = new ArrayList<>();
		lore.add("§c§lStompe §7§lseus inimigos!");
		lore.add("");
		if (p.hasPermission("legend.kit.stomper")) {
			lore.add("§a§lVocê possui esse kit");
		} else {
			lore.add("§c§lVocê não possui esse kit");
		}
		lore.add("");
		lore.add("§e§lClique para pegar");
		stomper2.setLore(lore);
		stomper.setItemMeta(stomper2);
		
		ItemStack ender = new ItemStack(Material.ENDER_PORTAL_FRAME);
		ItemMeta ender2 = ender.getItemMeta();
		ender2.setDisplayName("§b§lKit §6§lEndermage");
		ArrayList<String> lore12 = new ArrayList<>();
		lore12.add("§c§lPuxe §7§lseus inimigos!");
		lore12.add("");
		if (p.hasPermission("legend.kit.endermage")) {
			lore12.add("§a§lVocê possui esse kit");
		} else {
			lore12.add("§c§lVocê não possui esse kit");
		}
		lore12.add("");
		lore12.add("§e§lClique para pegar");
		ender2.setLore(lore12);
		ender.setItemMeta(ender2);

		ItemStack phantom = new ItemStack(Material.FEATHER);
		ItemMeta phantom2 = phantom.getItemMeta();
		phantom2.setDisplayName("§b§lKit §6§lPhantom");
		ArrayList<String> a11 = new ArrayList<>();
		a11.add("§c§lVoe §7§lpor 5 segundos!");
		a11.add("");
		if (p.hasPermission("legend.kit.phantom")) {
			a11.add("§a§lVocê possui esse kit");
		} else {
			a11.add("§c§lVocê não possui esse kit");
		}
		a11.add("");
		a11.add("§e§lClique para pegar");
		phantom2.setLore(a11);
		phantom.setItemMeta(phantom2);

		ItemStack qd = new ItemStack(Material.BOWL);
		ItemMeta qd2 = qd.getItemMeta();
		qd2.setDisplayName("§b§lKit §6§lQuick Droper");
		ArrayList<String> lore31 = new ArrayList<>();
		lore31.add("§c§lDropa §7§lautomaticamente seu pote!");
		lore31.add("");
		if (p.hasPermission("legend.kit.quickdroper")) {
			lore31.add("§a§lVocê possui esse kit");
		} else {
			lore31.add("§c§lVocê não possui esse kit");
		}
		lore31.add("");
		lore31.add("§e§lClique para pegar");
		qd2.setLore(lore31);
		qd.setItemMeta(qd2);

		ItemStack desh = new ItemStack(Material.REDSTONE_BLOCK);
		ItemMeta desh2 = desh.getItemMeta();
		desh2.setDisplayName("§b§lKit §6§lDeshfire");
		ArrayList<String> lore2 = new ArrayList<>();
		lore2.add("§7§lDe dano com seu §c§lDesh§7§l!");
		lore2.add("");
		if (p.hasPermission("legend.kit.deshfire")) {
			lore2.add("§a§lVocê possui esse kit");
		} else {
			lore2.add("§c§lVocê não possui esse kit");
		}
		lore2.add("");
		lore2.add("§e§lClique para pegar");
		desh2.setLore(lore2);
		desh.setItemMeta(desh2);

		ItemStack thor = new ItemStack(Material.GOLD_AXE);
		ItemMeta thor2 = thor.getItemMeta();
		thor2.setDisplayName("§b§lKit §6§lThor");
		ArrayList<String> lore1 = new ArrayList<>();
		lore1.add("§7§lSolte raios como o §c§lThor§7§l.");
		lore1.add("");
		if (p.hasPermission("legend.kit.thor")) {
			lore1.add("§a§lVocê possui esse kit");
		} else {
			lore1.add("§c§lVocê não possui esse kit");
		}
		lore1.add("");
		lore1.add("§e§lClique para pegar");
		thor2.setLore(lore1);
		thor.setItemMeta(thor2);

		ItemStack corona = new ItemStack(Material.SKULL_ITEM, 1, (byte) 1);
		ItemMeta corona2 = corona.getItemMeta();
		corona2.setDisplayName("§b§lKit §6§lCorona");
		ArrayList<String> j = new ArrayList<>();
		j.add("§7§lInfecte seus adversarios com §c§lCoronga§7§l!");
		j.add("");
		if (p.hasPermission("legend.kit.corona")) {
			j.add("§a§lVocê possui esse kit");
		} else {
			j.add("§c§lVocê não possui esse kit");
		}
		j.add("");
		j.add("§e§lClique para pegar");
		corona2.setLore(j);
		corona.setItemMeta(corona2);

		ItemStack ninja = new ItemStack(Material.COAL_BLOCK);
		ItemMeta ninja2 = ninja.getItemMeta();
		ninja2.setDisplayName("§b§lKit §6§lNinja");
		ArrayList<String> a2 = new ArrayList<>();
		a2.add("§c§lTeleporte §7§lat§ os inimigos!");
		a2.add("");
		if (p.hasPermission("legend.kit.ninja")) {
			a2.add("§a§lVocê possui esse kit");
		} else {
			a2.add("§c§lVocê não possui esse kit");
		}
		a2.add("");
		a2.add("§e§lClique para pegar");
		ninja2.setLore(a2);
		ninja.setItemMeta(ninja2);

		ItemStack Ajnin = new ItemStack(Material.COAL);
		ItemMeta Ajnin2 = Ajnin.getItemMeta();
		Ajnin2.setDisplayName("§b§lKit §6§lAjnin");
		ArrayList<String> a = new ArrayList<>();
		a.add("§c§lTeleporte §7§lseus adversarios até você!");
		a.add("");
		if (p.hasPermission("legend.kit.ajnin")) {
			a.add("§a§lVocê possui esse kit");
		} else {
			a.add("§c§lVocê não possui esse kit");
		}
		a.add("");
		a.add("§e§lClique para pegar");
		Ajnin2.setLore(a);
		Ajnin.setItemMeta(Ajnin2);

		ItemStack gladiator = new ItemStack(Material.IRON_FENCE);
		ItemMeta gladiator2 = gladiator.getItemMeta();
		gladiator2.setDisplayName("§b§lKit §6§lGladiator");
		ArrayList<String> a1 = new ArrayList<>();
		a1.add("§7§lTire §c§l1x1 §7§lem uma arena!");
		a1.add("");
		if (p.hasPermission("legend.kit.gladiator")) {
			a1.add("§a§lVocê possui esse kit");
		} else {
			a1.add("§c§lVocê não possui esse kit");
		}
		a1.add("");
		a1.add("§e§lClique para pegar");
		gladiator2.setLore(a1);
		gladiator.setItemMeta(gladiator2);

		ItemStack hulk = new ItemStack(Material.SLIME_BLOCK);
		ItemMeta hulk2 = hulk.getItemMeta();
		hulk2.setDisplayName("§b§lKit §6§lHulk");
		ArrayList<String> b = new ArrayList<>();
		b.add("§c§lArremesse §7§lseus inimigos!");
		b.add("");
		if (p.hasPermission("legend.kit.hulk")) {
			b.add("§a§lVocê possui esse kit");
		} else {
			b.add("§c§lVocê não possui esse kit");
		}
		b.add("");
		b.add("§e§lClique para pegar");
		hulk2.setLore(b);
		hulk.setItemMeta(hulk2);

		ItemStack tankup = new ItemStack(Material.CHAINMAIL_CHESTPLATE);
		ItemMeta tankup2 = tankup.getItemMeta();
		tankup2.setDisplayName("§b§lKit §6§lTankUp");
		ArrayList<String> c = new ArrayList<>();
		c.add("§7§lDeixe seus adversarios §c§llentos§7§l!");
		c.add("");
		if (p.hasPermission("legend.kit.tankup")) {
			c.add("§a§lVocê possui esse kit");
		} else {
			c.add("§c§lVocê não possui esse kit");
		}
		c.add("");
		c.add("§e§lClique para pegar");
		tankup2.setLore(c);
		tankup.setItemMeta(tankup2);

		ItemStack berserker = new ItemStack(Material.REDSTONE);
		ItemMeta berserker2 = berserker.getItemMeta();
		berserker2.setDisplayName("§b§lKit §6§lBerserker");
		ArrayList<String> d = new ArrayList<>();
		d.add("§7§lGanhe força após §c§leliminar §7§loutro jogador!");
		d.add("");
		if (p.hasPermission("legend.kit.berserker")) {
			d.add("§a§lVocê possui esse kit");
		} else {
			d.add("§c§lVocê não possui esse kit");
		}
		d.add("");
		d.add("§e§lClique para pegar");
		berserker2.setLore(d);
		berserker.setItemMeta(berserker2);

		ItemStack anchor = new ItemStack(Material.ANVIL);
		ItemMeta anchor2 = anchor.getItemMeta();
		anchor2.setDisplayName("§b§lKit §6§lAnchor");
		ArrayList<String> e = new ArrayList<>();
		e.add("§7§lNão leve §c§lKnockback§7§l.");
		e.add("");
		if (p.hasPermission("legend.kit.anchor")) {
			e.add("§a§lVocê possui esse kit");
		} else {
			e.add("§c§lVocê não possui esse kit");
		}
		e.add("");
		e.add("§e§lClique para pegar");
		anchor2.setLore(e);
		anchor.setItemMeta(anchor2);

		ItemStack arrow = new ItemStack(Material.ARROW);
		ItemMeta arrow2 = arrow.getItemMeta();
		arrow2.setDisplayName("§b§lKit §6§lArrow");
		ArrayList<String> j2 = new ArrayList<>();
		j2.add("§7§lFaça §c§lchover flechas §7§lno seu adversario!");
		j2.add("");
		if (p.hasPermission("legend.kit.arrow")) {
			j2.add("§a§lVocê possui esse kit");
		} else {
			j2.add("§c§lVocê não possui esse kit");
		}
		j2.add("");
		j2.add("§e§lClique para pegar");
		arrow2.setLore(j2);
		arrow.setItemMeta(arrow2);

		ItemStack string = new ItemStack(Material.STRING);
		ItemMeta string2 = string.getItemMeta();
		string2.setDisplayName("§b§lKits §6§lLegendPvP");
		string.setItemMeta(string2);

		ItemStack vampiro = new ItemStack(Material.FLINT);
		ItemMeta vampiro2 = vampiro.getItemMeta();
		vampiro2.setDisplayName("§b§lKit §6§lVampiro");
		ArrayList<String> k1 = new ArrayList<>();
		k1.add("§7§lSe transforme em um §c§lMorcego§7§l!");
		k1.add("");
		if (p.hasPermission("legend.kit.vampiro")) {
			k1.add("§a§lVocê possui esse kit");
		} else {
			k1.add("§c§lVocê não possui esse kit");
		}
		k1.add("");
		k1.add("§e§lClique para pegar");
		vampiro2.setLore(k1);
		vampiro.setItemMeta(vampiro2);

		ItemStack neo = new ItemStack(Material.DROPPER);
		ItemMeta neo2 = neo.getItemMeta();
		neo2.setDisplayName("§b§lKit §6§lNeo");
		ArrayList<String> k12 = new ArrayList<>();
		k12.add("§7§lSeja imune a §c§lprojéteis§7§l!");
		k12.add("");
		if (p.hasPermission("legend.kit.neo")) {
			k12.add("§a§lVocê possui esse kit");
		} else {
			k12.add("§c§lVocê não possui esse kit");
		}
		k12.add("");
		k12.add("§e§lClique para pegar");
		neo2.setLore(k12);
		neo.setItemMeta(neo2);

		ItemStack ls = new ItemStack(Material.GHAST_TEAR);
		ItemMeta ls2 = ls.getItemMeta();
		ls2.setDisplayName("§b§lKit §6§lLife Stealer");
		ArrayList<String> k123 = new ArrayList<>();
		k123.add("§c§lRoube §7§la vida dos inimigos!");
		k123.add("");
		if (p.hasPermission("legend.kit.lifestealer")) {
			k123.add("§a§lVocê possui esse kit");
		} else {
			k123.add("§c§lVocê não possui esse kit");
		}
		k123.add("");
		k123.add("§e§lClique para pegar");
		ls2.setLore(k123);
		ls.setItemMeta(ls2);

		ItemStack goku = new ItemStack(Material.LAPIS_BLOCK);
		ItemMeta goku2 = goku.getItemMeta();
		goku2.setDisplayName("§b§lKit §6§lGoku");
		ArrayList<String> g1 = new ArrayList<>();
		g1.add("§7§lSolte um §9§lKamehameha§7§l!");
		g1.add("");
		if (p.hasPermission("legend.kit.goku")) {
			g1.add("§a§lVocê possui esse kit");
		} else {
			g1.add("§c§lVocê não possui esse kit");
		}
		g1.add("");
		g1.add("§e§lClique para pegar");
		goku2.setLore(g1);
		goku.setItemMeta(goku2);

		ItemStack C4 = new ItemStack(Material.TNT);
		ItemMeta C42 = C4.getItemMeta();
		C42.setDisplayName("§b§lKit §6§lC4");
		ArrayList<String> g2 = new ArrayList<>();
		g2.add("§c§lExploda §7§seus inimigos!");
		g2.add("");
		if (p.hasPermission("legend.kit.c4")) {
			g2.add("§a§lVocê possui esse kit");
		} else {
			g2.add("§c§lVocê não possui esse kit");
		}
		g2.add("");
		g2.add("§e§lClique para pegar");
		C42.setLore(g2);
		C4.setItemMeta(C42);

		ItemStack ghost = new ItemStack(Material.GLASS_BOTTLE);
		ItemMeta ghost2 = ghost.getItemMeta();
		ghost2.setDisplayName("§b§lKit §6§lGhost");
		ArrayList<String> b1 = new ArrayList<>();
		b1.add("§7§lSe transforme em um fantasma e fique §c§linvisivel!");
		b1.add("");
		if (p.hasPermission("legend.kit.ghost")) {
			b1.add("§a§lVocê possui esse kit");
		} else {
			b1.add("§c§lVocê não possui esse kit");
		}
		b1.add("");
		b1.add("§e§lClique para pegar");
		ghost2.setLore(b1);
		ghost.setItemMeta(ghost2);

		ItemStack spe = new ItemStack(Material.BEACON);
		ItemMeta spe2 = spe.getItemMeta();
		spe2.setDisplayName("§b§lKit §6§lAvatar");
		ArrayList<String> gp = new ArrayList<>();
		gp.addAll(Arrays.asList("§7§lUse seu §c§lavatar §7§lpara", "§7§lpara controlar todos os", "§7§lelementos ar, terra, agua e fogo."));
		gp.add("");
		if (p.hasPermission("legend.kit.avatar")) {
			gp.add("§a§lVocê possui esse kit");
		} else {
			gp.add("§c§lVocê não possui esse kit");
		}
		gp.add("");
		gp.add("§e§lClique para pegar");
		spe2.setLore(gp);
		spe.setItemMeta(spe2);

		ItemStack frozen = new ItemStack(Material.PACKED_ICE);
		ItemMeta frozen2 = frozen.getItemMeta();
		frozen2.setDisplayName("§b§lKit §6§lFrozen");
		ArrayList<String> gp2 = new ArrayList<>();
		gp2.add("§c§lCongele§7§l seus inimigos ao redor!");
		gp2.add("");
		if (p.hasPermission("legend.kit.frozen")) {
			gp2.add("§a§lVocê possui esse kit");
		} else {
			gp2.add("§c§lVocê não possui esse kit");
		}
		gp2.add("");
		gp2.add("§e§lClique para pegar");
		frozen2.setLore(gp2);
		frozen.setItemMeta(frozen2);

		ItemStack kits1 = new ItemStack(Material.CARPET);
		ItemMeta kits12 = kits1.getItemMeta();
		kits12.setDisplayName("§b§lVoltar página");
		kits1.setItemMeta(kits12);

		ItemStack kits3 = new ItemStack(Material.CARPET);
		ItemMeta kits32 = kits3.getItemMeta();
		kits32.setDisplayName("§b§lPróxima página");
		kits3.setItemMeta(kits32);

		kits2.setItem(0, loja);
		kits2.setItem(1, loja);
		kits2.setItem(2, loja);
		kits2.setItem(3, loja);
		kits2.setItem(5, loja);
		kits2.setItem(6, loja);
		kits2.setItem(7, loja);
		kits2.setItem(8, loja);
		kits2.setItem(9, loja);
		kits2.setItem(17, loja);
		kits2.setItem(18, loja);
		kits2.setItem(26, loja);
		kits2.setItem(27, loja);
		kits2.setItem(35, loja);
		kits2.setItem(36, loja);
		kits2.setItem(44, loja);
		kits2.setItem(45, loja);
		kits2.setItem(46, loja);
		kits2.setItem(47, loja);
		kits2.setItem(48, loja);
		kits2.setItem(50, loja);
		kits2.setItem(51, loja);
		kits2.setItem(52, loja);
		kits2.setItem(53, loja);

		kits2.setItem(4, tocha);
		kits2.setItem(0, kits1);
		kits2.setItem(49, string);
		// kits2.setItem(8, kits3);
		kits2.addItem(stomper);
		kits2.addItem(tankup);
		kits2.addItem(thor);
		kits2.addItem(berserker);
		kits2.addItem(vampiro);
		kits2.addItem(arrow);
		kits2.addItem(qd);
		kits2.addItem(ls);
		kits2.addItem(ninja);
		kits2.addItem(hulk);
		kits2.addItem(desh);
		kits2.addItem(neo);
		kits2.addItem(C4);
		kits2.addItem(goku);
		kits2.addItem(Ajnin);
		kits2.addItem(gladiator);
		kits2.addItem(corona);
		kits2.addItem(anchor);
		kits2.addItem(phantom);
		kits2.addItem(ghost);
		kits2.addItem(spe);
		kits2.addItem(frozen);
		kits2.addItem(ender);
		if (p.hasPermission("legend.kit.pyro")) {
			kits2.addItem(API.Item(Material.FIREBALL, "§b§lKit §6§lPyro", 1, (byte) 0,
					Arrays.asList(new String[] { "§7§lUse seu pyro para", "§7§llançar §c§lbolas de fogo§7§l.", "",
							"§a§lVocê possui esse kit", "", "§e§lClique para pegar" })));
		} else {
			kits2.addItem(API.Item(Material.FIREBALL, "§b§lKit §6§lPyro", 1, (byte) 0,
					Arrays.asList(new String[] { "§7§lUse seu pyro para", "§7§llançar §c§lbolas de fogo§7§l.", "",
							"§c§lVocê não possui esse kit", "", "§e§lClique para pegar" })));
		}
		if (p.hasPermission("legend.kit.pyro")) {
			kits2.addItem(API.Item(Material.MUSHROOM_SOUP, "§b§lKit §6§lResouper", 1, (byte) 0,
					Arrays.asList(new String[] { "§7§lA cada kill ganhe", "§7§l15 sopas§7§l.", "",
							"§a§lVocê possui esse kit", "", "§e§lClique para pegar" })));
		} else {
			kits2.addItem(API.Item(Material.MUSHROOM_SOUP, "§b§lKit §6§lResouper", 1, (byte) 0,
					Arrays.asList(new String[] { "§7§lA cada kill ganhe", "§7§l15 sopas§7§l.", "",
							"§c§lVocê não possui esse kit", "", "§e§lClique para pegar" })));
		}
		for (int i = 41; i < 44; i++) {
			kits2.setItem(i, iron);
		}

		p.openInventory(kits2);
	}
}
