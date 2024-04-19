package com.Legend.guis;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Inv3 implements Listener {

	@EventHandler
	public void clickInv(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		if (e.getInventory().getName().equalsIgnoreCase("§bKits §6Vips §f2/2")) {
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
			} else if (e.getCurrentItem().getType() == Material.IRON_FENCE) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit gladiator");
			} else if (e.getCurrentItem().getType() == Material.ARROW) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit arrow");
			} else if (e.getCurrentItem().getType() == Material.REDSTONE_BLOCK) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit deshfire");
			} else if (e.getCurrentItem().getType() == Material.DROPPER) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit neo");
			} else if (e.getCurrentItem().getType() == Material.CARPET) {
				e.setCancelled(true);
				p.closeInventory();
				Inv2.seletorKits2(p);
			} else if (e.getCurrentItem().getType() == Material.STAINED_GLASS_PANE) {
				e.setCancelled(true);
			} else if (e.getCurrentItem().getType() == Material.FLINT) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit vampiro");
			} else if (e.getCurrentItem().getType() == Material.IRON_HELMET) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit ironhead");
			}
		}
	}

	@SuppressWarnings("deprecation")
	public static void seletorKits3(Player p) {
		Inventory kits2 = Bukkit.createInventory(p, 54, "§bKits §6Vips §f2/2");

		ItemStack loja = new ItemStack(Material.VINE);
		ItemMeta loja2 = loja.getItemMeta();
		loja2.setDisplayName("§b-=-");
		loja.setItemMeta(loja2);

		ItemStack iron = new ItemStack(Material.STAINED_GLASS_PANE);
		ItemMeta iron2 = iron.getItemMeta();
		iron2.setDisplayName("§b-=-");
		iron.setItemMeta(iron2);

		ItemStack tocha = new ItemStack(Material.TORCH);
		ItemMeta tocha2 = tocha.getItemMeta();
		tocha2.setDisplayName("§bPagina de §bKits §6Vips 2/2");
		tocha.setItemMeta(tocha2);

		ItemStack sharp = new ItemStack(Material.IRON_BOOTS);
		ItemMeta sharp2 = sharp.getItemMeta();
		sharp2.setDisplayName("§bKit §6Stomper");
		ArrayList<String> lore = new ArrayList<>();
		lore.add("§bStompe seus inimigos!");
		sharp2.setLore(lore);
		sharp.setItemMeta(sharp2);

		ItemStack desh = new ItemStack(Material.REDSTONE_BLOCK);
		ItemMeta desh2 = desh.getItemMeta();
		desh2.setDisplayName("§bKit §6Deshfire");
		ArrayList<String> lore2 = new ArrayList<>();
		lore2.add("§bDe dano com seu desh!");
		desh2.setLore(lore2);
		desh.setItemMeta(desh2);

		ItemStack ironh = new ItemStack(Material.IRON_HELMET);
		ItemMeta ironh2 = ironh.getItemMeta();
		ironh2.setDisplayName("§bKit §6IronHead");
		ArrayList<String> lore3 = new ArrayList<>();
		lore3.add("§bSeja imune a stompers!");
		ironh2.setLore(lore3);
		ironh.setItemMeta(ironh2);

		ItemStack thor = new ItemStack(Material.GOLD_AXE);
		ItemMeta thor2 = thor.getItemMeta();
		thor2.setDisplayName("§bKit §6Thor");
		ArrayList<String> lore1 = new ArrayList<>();
		lore1.add("§bSolte raios como o Thor.");
		thor2.setLore(lore1);
		thor.setItemMeta(thor2);

		ItemStack ninja = new ItemStack(Material.COAL_BLOCK);
		ItemMeta ninja2 = ninja.getItemMeta();
		ninja2.setDisplayName("§bKit §6Ninja");
		ArrayList<String> a2 = new ArrayList<>();
		a2.add("§bVoe até os inimigos!");
		ninja2.setLore(a2);
		ninja.setItemMeta(ninja2);

		ItemStack Ajnin = new ItemStack(Material.COAL);
		ItemMeta Ajnin2 = Ajnin.getItemMeta();
		Ajnin2.setDisplayName("§bKit §6Ajnin");
		ArrayList<String> a = new ArrayList<>();
		a.add("§bPuxe seus adversarios até você!");
		Ajnin2.setLore(a);
		Ajnin.setItemMeta(Ajnin2);

		ItemStack gladiator = new ItemStack(Material.IRON_FENCE);
		ItemMeta gladiator2 = gladiator.getItemMeta();
		gladiator2.setDisplayName("§bKit §6Gladiator");
		ArrayList<String> a1 = new ArrayList<>();
		a1.add("§bTire 1x1 em uma arena!");
		gladiator2.setLore(a1);
		gladiator.setItemMeta(gladiator2);

		ItemStack hulk = new ItemStack(Material.SLIME_BLOCK);
		ItemMeta hulk2 = hulk.getItemMeta();
		hulk2.setDisplayName("§bKit §6Hulk");
		ArrayList<String> b = new ArrayList<>();
		b.add("§bArremesse seus inimigos!");
		hulk2.setLore(b);
		hulk.setItemMeta(hulk2);

		ItemStack tankup = new ItemStack(Material.CHAINMAIL_CHESTPLATE);
		ItemMeta tankup2 = tankup.getItemMeta();
		tankup2.setDisplayName("§bKit §6TankUp");
		ArrayList<String> c = new ArrayList<>();
		c.add("§bDeixe seus adversarios lentos!");
		tankup2.setLore(c);
		tankup.setItemMeta(tankup2);

		ItemStack berserker = new ItemStack(Material.REDSTONE);
		ItemMeta berserker2 = berserker.getItemMeta();
		berserker2.setDisplayName("§bKit §6Berserker");
		ArrayList<String> d = new ArrayList<>();
		d.add("§bGanhe força após eliminar outro jogador!");
		berserker2.setLore(d);
		berserker.setItemMeta(berserker2);

		ItemStack anchor = new ItemStack(Material.ANVIL);
		ItemMeta anchor2 = anchor.getItemMeta();
		anchor2.setDisplayName("§bKit §6Anchor");
		ArrayList<String> e = new ArrayList<>();
		e.add("§bNão leve Knockback.");
		anchor2.setLore(e);
		anchor.setItemMeta(anchor2);

		ItemStack archer = new ItemStack(Material.BOW);
		ItemMeta archer2 = archer.getItemMeta();
		archer2.setDisplayName("§bKit §6Archer");
		ArrayList<String> f = new ArrayList<>();
		f.add("§bGanhe um arco e uma felcha.");
		sharp2.setLore(f);
		archer.setItemMeta(archer2);

		ItemStack viking = new ItemStack(Material.IRON_AXE);
		ItemMeta viking2 = viking.getItemMeta();
		viking2.setDisplayName("§bKit §6Viking");
		ArrayList<String> g = new ArrayList<>();
		g.add("§bSeja um Viking!");
		sharp2.setLore(g);
		viking.setItemMeta(viking2);

		ItemStack tank = new ItemStack(Material.LEATHER_CHESTPLATE);
		ItemMeta tank2 = tank.getItemMeta();
		tank2.setDisplayName("§bKit §6Tank");
		ArrayList<String> h = new ArrayList<>();
		h.add("§bMais defesa e menos ataque!");
		sharp2.setLore(h);
		tank.setItemMeta(tank2);

		ItemStack corona = new ItemStack(397);
		ItemMeta corona2 = corona.getItemMeta();
		corona2.setDisplayName("§bKit §6Corona");
		ArrayList<String> j = new ArrayList<>();
		j.add("§bInfecte seus adversarios com Coronga!");
		sharp2.setLore(j);
		corona.setItemMeta(corona2);

		ItemStack arrow = new ItemStack(Material.ARROW);
		ItemMeta arrow2 = arrow.getItemMeta();
		arrow2.setDisplayName("§bKit §6Arrow");
		ArrayList<String> j2 = new ArrayList<>();
		j2.add("§bFaça chover flechas no seu adversario!");
		arrow2.setLore(j2);
		arrow.setItemMeta(arrow2);

		ItemStack string = new ItemStack(Material.STRING);
		ItemMeta string2 = string.getItemMeta();
		string2.setDisplayName("§bKits §6LegendPvP");
		string.setItemMeta(string2);

		ItemStack upgrader = new ItemStack(Material.WOOD_SWORD);
		ItemMeta upgrader2 = upgrader.getItemMeta();
		upgrader2.setDisplayName("§bKit §6Upgrader");
		ArrayList<String> k = new ArrayList<>();
		k.add("§bSua espada melhora a cada Kill.");
		sharp2.setLore(k);
		upgrader.setItemMeta(upgrader2);

		ItemStack vampiro = new ItemStack(Material.FLINT);
		ItemMeta vampiro2 = vampiro.getItemMeta();
		vampiro2.setDisplayName("§bKit §6Vampiro");
		ArrayList<String> k1 = new ArrayList<>();
		k1.add("§bSe transforme em um Morcego!");
		vampiro2.setLore(k1);
		vampiro.setItemMeta(vampiro2);

		ItemStack neo = new ItemStack(Material.DROPPER);
		ItemMeta neo2 = vampiro.getItemMeta();
		neo2.setDisplayName("§bKit §6Neo");
		ArrayList<String> k12 = new ArrayList<>();
		k12.add("§bSeja imune a projéteis!");
		neo2.setLore(k12);
		neo.setItemMeta(neo2);

		ItemStack kits1 = new ItemStack(Material.CARPET);
		ItemMeta kits12 = kits1.getItemMeta();
		kits12.setDisplayName("§bVoltar página");
		kits1.setItemMeta(kits12);

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

		// kits2.setItem(4, tocha);
		// kits2.setItem(0, kits1);
		// kits2.setItem(49, string);
		// kits2.addItem(sharp);
		// kits2.addItem(thor);
		// kits2.addItem(ninja);
		// kits2.addItem(Ajnin);
		// kits2.addItem(hulk);
		// kits2.addItem(tankup);
		// kits2.addItem(berserker);
		// kits2.addItem(anchor);
		// kits2.addItem(gladiator);
		// kits2.addItem(vampiro);
		// kits2.addItem(arrow);
		// kits2.addItem(desh);
		// kits2.addItem(ironh);
		// kits2.addItem(neo);

		p.openInventory(kits2);
	}
}
