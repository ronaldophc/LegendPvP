package com.Legend.events;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import com.Legend.Main;
import com.Legend.guis.Title;
import com.Legend.kits.manager.Base;

public class DamageManager implements Listener {

	public static List<Player> cd = new ArrayList<>();

	@SuppressWarnings("deprecation")
	@EventHandler(priority = EventPriority.HIGHEST)
	public void NerfsDano(EntityDamageByEntityEvent e) {
		if ((e.getEntity() instanceof Player)) {
			if ((e.getDamager() instanceof Player)) {
				Player d = (Player) e.getDamager();
				Player p = (Player) e.getEntity();
				if (cd.contains(d)) {
					e.setDamage(0);
					return;
				}
				cd.add(d);
				new BukkitRunnable() {

					@Override
					public void run() {
						for (Player p : Bukkit.getOnlinePlayers()) {
							cd.remove(p);
							cancel();
						}
					}
				}.runTaskLater(Main.getInstance(), 10);
				if (p.isOnGround() && d.isOnGround()) {
					if (d.hasPotionEffect(PotionEffectType.INCREASE_DAMAGE)) {
						if (d.getItemInHand().getType() == Material.WOOD_SWORD) {
							e.setDamage(3.5D);
						}
						if (d.getItemInHand().getType() == Material.STONE_SWORD) {
							e.setDamage(4.5D);
						}
						if (d.getItemInHand().getType() == Material.IRON_SWORD) {
							e.setDamage(5.5D);
						}
						if (d.getItemInHand().getType() == Material.DIAMOND_SWORD) {
							e.setDamage(6.5D);
						}
						if (d.getItemInHand().getType() == Material.STICK) {
							e.setDamage(1.0D);
						}
						if (d.getItemInHand().getType() == Material.WOOD_AXE) {
							e.setDamage(3.5D);
						}
						if (d.getItemInHand().getType() == Material.STONE_AXE) {
							e.setDamage(5.0D);
						}
						if (d.getItemInHand().getType() == Material.IRON_AXE) {
							e.setDamage(6.0D);
						}
						if (d.getItemInHand().getType() == Material.DIAMOND_AXE) {
							e.setDamage(7.0D);
						}
						if (d.getItemInHand().containsEnchantment(Enchantment.DAMAGE_ALL)) {
							e.setDamage(e.getDamage() + 1.0D);
						}
						return;
					} else {
						if (d.getItemInHand().getType() == Material.WOOD_SWORD) {
							e.setDamage(3.0D);
						}
						if (d.getItemInHand().getType() == Material.STONE_SWORD) {
							e.setDamage(4.0D);
						}
						if (d.getItemInHand().getType() == Material.IRON_SWORD) {
							e.setDamage(5.0D);
						}
						if (d.getItemInHand().getType() == Material.DIAMOND_SWORD) {
							e.setDamage(6.0D);
						}
						if (d.getItemInHand().getType() == Material.STICK) {
							e.setDamage(1.0D);
						}
						if (d.getItemInHand().getType() == Material.WOOD_AXE) {
							e.setDamage(3.0D);
						}
						if (d.getItemInHand().getType() == Material.STONE_AXE) {
							e.setDamage(4.5D);
						}
						if (d.getItemInHand().getType() == Material.IRON_AXE) {
							e.setDamage(5.5D);
						}
						if (d.getItemInHand().getType() == Material.DIAMOND_AXE) {
							e.setDamage(6.5D);
						}
						if (d.getItemInHand().containsEnchantment(Enchantment.DAMAGE_ALL)) {
							e.setDamage(e.getDamage() + 1.0D);
						}
						return;
					}
				} else if (!(p.isOnGround()) || !(d.isOnGround())) {
					if (d.hasPotionEffect(PotionEffectType.INCREASE_DAMAGE)) {
						if (d.getItemInHand().getType() == Material.WOOD_SWORD) {
							e.setDamage(4.0D);
						}
						if (d.getItemInHand().getType() == Material.STONE_SWORD) {
							e.setDamage(5.0D);
						}
						if (d.getItemInHand().getType() == Material.IRON_SWORD) {
							e.setDamage(6.0D);
						}
						if (d.getItemInHand().getType() == Material.DIAMOND_SWORD) {
							e.setDamage(7.0D);
						}
						if (d.getItemInHand().getType() == Material.STICK) {
							e.setDamage(1.0D);
						}
						if (d.getItemInHand().getType() == Material.WOOD_AXE) {
							e.setDamage(4.0D);
						}
						if (d.getItemInHand().getType() == Material.STONE_AXE) {
							e.setDamage(5.5D);
						}
						if (d.getItemInHand().getType() == Material.IRON_AXE) {
							e.setDamage(6.5D);
						}
						if (d.getItemInHand().getType() == Material.DIAMOND_AXE) {
							e.setDamage(7.5D);
						}
						if (d.getItemInHand().containsEnchantment(Enchantment.DAMAGE_ALL)) {
							e.setDamage(e.getDamage() + 1.0D);
						}
						return;
					} else {
						if (d.getItemInHand().getType() == Material.WOOD_SWORD) {
							e.setDamage(3.5D);
						}
						if (d.getItemInHand().getType() == Material.STONE_SWORD) {
							e.setDamage(4.5D);
						}
						if (d.getItemInHand().getType() == Material.IRON_SWORD) {
							e.setDamage(5.5D);
						}
						if (d.getItemInHand().getType() == Material.DIAMOND_SWORD) {
							e.setDamage(6.5D);
						}
						if (d.getItemInHand().getType() == Material.STICK) {
							e.setDamage(1.0D);
						}
						if (d.getItemInHand().getType() == Material.WOOD_AXE) {
							e.setDamage(3.5D);
						}
						if (d.getItemInHand().getType() == Material.STONE_AXE) {
							e.setDamage(5.0D);
						}
						if (d.getItemInHand().getType() == Material.IRON_AXE) {
							e.setDamage(6.0D);
						}
						if (d.getItemInHand().getType() == Material.DIAMOND_AXE) {
							e.setDamage(7.0D);
						}
						if (d.getItemInHand().containsEnchantment(Enchantment.DAMAGE_ALL)) {
							e.setDamage(e.getDamage() + 1.0D);
						}
						return;
					}
				}
				if (d.getItemInHand().getType() == Material.WOOD_SWORD) {
					e.setDamage(3.5D);
				}
				if (d.getItemInHand().getType() == Material.STONE_SWORD) {
					e.setDamage(4.5D);
				}
				if (d.getItemInHand().getType() == Material.IRON_SWORD) {
					e.setDamage(5.5D);
				}
				if (d.getItemInHand().getType() == Material.DIAMOND_SWORD) {
					e.setDamage(6.5D);
				}
				if (d.getItemInHand().getType() == Material.STICK) {
					e.setDamage(1.0D);
				}
				if (d.getItemInHand().getType() == Material.WOOD_AXE) {
					e.setDamage(3.5D);
				}
				if (d.getItemInHand().getType() == Material.STONE_AXE) {
					e.setDamage(5.0D);
				}
				if (d.getItemInHand().getType() == Material.IRON_AXE) {
					e.setDamage(6.0D);
				}
				if (d.getItemInHand().getType() == Material.DIAMOND_AXE) {
					e.setDamage(7.0D);
				}
				if (d.getItemInHand().containsEnchantment(Enchantment.DAMAGE_ALL)) {
					e.setDamage(e.getDamage() + 1.0D);
				}
				return;
			}
		}
	}

	@EventHandler
	public void event(EntityDamageByEntityEvent e) {
		if ((e.getEntity() instanceof Player)) {
			if ((e.getDamager() instanceof Player)) {
				Player d = (Player) e.getDamager();
				Player p = (Player) e.getEntity();
				if (Base.qualKit(d) == "Critical") {
					if (p.getLocation().getY() >= 63) {
						return;
					}
					Random r = new Random();
					int c = r.nextInt(100);
					if (c <= 30) {
						e.setDamage(e.getDamage() + 1.5D);
						p.getWorld().playEffect(p.getLocation(), Effect.STEP_SOUND, Material.REDSTONE_BLOCK, 10);
					}
				}
				if (Base.qualKit(p) == "Achilles") {
					ItemStack i = d.getItemInHand();
					Title.sendActionBar(d, "O jogador hitado é um §aAchilles§f!");
					if (i != null && i.getType().name().contains("WOOD_")) {
						double damage = e.getDamage() + 2.0D;
						e.setDamage(damage);
					} else if (i != null && !i.getType().name().contains("WOOD_")) {
						if (d.getItemInHand().getType() == Material.AIR) {
							e.setDamage(2.0D);
						}
						e.setDamage(e.getDamage() - 2.0D);
					}
				}
				if (Base.qualKit((Player) e.getDamager()) == "Boxer") {
					e.setDamage(e.getDamage() + 0.5D);
				}
				if (e.getEntity() instanceof Player && (Base.qualKit((Player) e.getEntity()) == "Boxer")) {
					e.setDamage(e.getDamage() - 0.5D);
				}
				if (Base.qualKit(p) == "Lava") {
					e.setCancelled(true);
				}
			}
		}
	}

}
