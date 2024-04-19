package com.Legend.kits;

import java.util.HashMap;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockDamageEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;

import com.Legend.guis.Title;
import com.Legend.kits.manager.Base;
import com.Legend.kits.manager.CooldownAPI;

public class Checkpoint implements Listener {

	public static HashMap<UUID, Location> checkpoints = new HashMap<UUID, Location>();
	public static HashMap<UUID, Long> hit = new HashMap<UUID, Long>();

	@SuppressWarnings("static-access")
	public void colocar(BlockPlaceEvent e) {
		Player p = e.getPlayer();
		if ((e.getItemInHand() != null && e.getItemInHand().getType() == Material.NETHER_FENCE)
				&& (Base.qualKit(p) == "Checkpoint")) {
			if (!(CooldownAPI.SemCooldown(p))) {
				e.setBuild(false);
				e.setCancelled(true);
				return;
			}
			if ((this.hit.containsKey(p.getUniqueId()))
					&& (this.hit.get(p.getUniqueId()) > System.currentTimeMillis())) {
				p.sendMessage(Base.prefix + "§cVocê foi hitado recentemente, espere um pouco para usar o checkpoint!");
				e.setCancelled(true);
				e.setBuild(false);
				p.updateInventory();
				return;
			}
			CooldownAPI.addCooldown(p, 5);
			CooldownAPI.mCooldown(p, "CheckPoint");
			p.setItemInHand(e.getItemInHand());
			p.updateInventory();
			this.checkpoints.put(p.getUniqueId(), e.getBlock().getLocation());
		}
	}

	@SuppressWarnings("static-access")
	@EventHandler
	public void rightClick(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		if ((Base.qualKit(p) == "Checkpoint") && (e.getPlayer().getItemInHand() != null
				&& e.getPlayer().getItemInHand().getType() == Material.NETHER_FENCE) && (e.getAction().name().contains("LEFT"))) {
			e.setCancelled(true);
			if (e.getPlayer().getLocation().getY() > 68) {
				return;
			}
			if (!this.checkpoints.containsKey(p.getUniqueId())) {
				p.sendMessage(Base.prefix + "§cVocê ainda não salvou nenhuma localização!");
			} else if (this.hit.containsKey(p.getUniqueId()) && hit.get(p.getUniqueId()) > System.currentTimeMillis()) {
				p.sendMessage(Base.prefix + "§cVocê foi hitado recentemente, espere um pouco para se teletransportar!");
			} else if (!(CooldownAPI.SemCooldown(p))) {
				return;
			} else {
				p.teleport(this.checkpoints.get(p.getUniqueId()));
				Title.sendActionBar(p, "§cTeletransportado!");
				p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 1.0F, 1.0F);
				CooldownAPI.addCooldown(p, 5);
				CooldownAPI.mCooldown(p, "CheckPoint");
			}
		}
	}

	@SuppressWarnings("static-access")
	@EventHandler
	public void damage(EntityDamageByEntityEvent e) {
		if ((e.isCancelled()) || (!(e.getEntity() instanceof Player && e.getDamager() instanceof Player))) {
			return;
		}
		if (!(Base.qualKit((Player) e.getEntity()) == "Checkpoint")) {
			return;
		}
		this.hit.put(e.getEntity().getUniqueId(), System.currentTimeMillis() + 6000L);
	}

	@SuppressWarnings("static-access")
	@EventHandler
	public void blockDamage(BlockDamageEvent e) {
		if (this.checkpoints.containsValue(e.getBlock().getLocation())
				&& e.getBlock().getType() == Material.NETHER_FENCE) {
			e.setCancelled(true);
			for (UUID p : this.checkpoints.keySet()) {
				if (this.checkpoints.get(p) == e.getBlock().getLocation()) {
					if (Bukkit.getPlayer(p) != null) {
						Bukkit.getPlayer(p).sendMessage(Base.prefix + "Uma de suas localizações foi destruiada!");
					}
					this.checkpoints.remove(p);
				}
			}
			e.getBlock().setType(Material.AIR);
			e.getPlayer().sendMessage(Base.prefix + "Você destruiu um checkpoint.");
			e.getPlayer().playSound(e.getPlayer().getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
		}
	}
}
