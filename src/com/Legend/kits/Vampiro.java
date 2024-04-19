package com.Legend.kits;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Bat;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import com.Legend.Main;
import com.Legend.kits.manager.Base;
import com.Legend.kits.manager.CooldownAPI;

public class Vampiro implements Listener {

	List<LivingEntity> bat = new ArrayList<LivingEntity>();

	@EventHandler
	public void Interact(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		if (Base.qualKit(p) == "Vampiro") {
			if (e.getAction().name().contains("RIGHT")) {
				if (e.getPlayer().getItemInHand().getType() == Material.FLINT) {
					if(p.getLocation().getY() >= 63) {
						if (!Gladiator.lutando.containsKey(p) && !Gladiator.lutando.containsValue(p)) {
							return;
						}
					}
					if (!(CooldownAPI.SemCooldown(p))) {
						return;
					}
					CooldownAPI.addCooldown(p, 10);
					CooldownAPI.mCooldown(p, "Vampiro");
					p.sendMessage(Base.prefix + "§7Você pode voar por 5 segundos.");
					Morcego(p);
					for (Entity redor : p.getWorld().getNearbyEntities(p.getLocation(), 10, 10, 10)) {
						if (redor instanceof Player) {
							Player perto = (Player) redor;
							if (perto != p) {
								perto.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 40, 5));
								perto.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 40, 5));
								perto.damage(4.0D);
							}
						}
					}
				}
			}
		}
	}

	public void Morcego(Player p) {
		for (Player on : Bukkit.getOnlinePlayers()) {
			on.hidePlayer(p);
		}
		p.setAllowFlight(true);
		Bat morcego = (Bat) p.getWorld().spawnEntity(p.getLocation(), EntityType.BAT);
		bat.add(morcego);
		new BukkitRunnable() {
			public void run() {
				if (morcego != null) {
					morcego.teleport(p);
				} else {
					cancel();
				}
			}
		}.runTaskTimer(Main.getPlugin(), 0, 5);
		new BukkitRunnable() {
			int delay = 0;

			public void run() {
				delay++;
				if (delay == 4) {
					bat.remove(morcego);
					morcego.remove();
					for (Player on : Bukkit.getOnlinePlayers()) {
						on.showPlayer(p);
					}
					p.setGameMode(GameMode.SURVIVAL);
					p.setAllowFlight(false);
					cancel();
				}
			}
		}.runTaskTimer(Main.plugin, 0, 20);
	}

	@EventHandler
	public void MatarMorcego(EntityDamageByEntityEvent e) {
		Entity en = e.getEntity();
		if (bat.contains(en)) {
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void DanoMorcego(EntityDamageEvent e) {
		Entity en = e.getEntity();
		if (bat.contains(en)) {
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void Fraqueza(EntityDamageByEntityEvent e) {
		if (e.getDamager() instanceof Player && e.getEntity() instanceof Player) {
			Player vitima = (Player) e.getEntity();
			Player p = (Player) e.getDamager();
			if (Base.qualKit(p) == "Vampiro") {
				int rand = new Random().nextInt(100);
				if (rand <= 3) {
					vitima.damage(2.0);
				}
			}
		}
	}

}
