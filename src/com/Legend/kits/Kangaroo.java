package com.Legend.kits;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.util.Vector;

import com.Legend.kits.manager.Base;
import com.Legend.kits.manager.CdAPI;
import com.Legend.kits.manager.CooldownAPI;

public class Kangaroo implements Listener {
	ArrayList<Player> kanga = new ArrayList<>();

	@SuppressWarnings("deprecation")
	@EventHandler
	public void onClick(PlayerInteractEvent event) {
		Player p = event.getPlayer();
		if (p.getItemInHand().getType() == Material.FIREWORK) {
			if (event.getAction() == Action.LEFT_CLICK_AIR || event.getAction() == Action.LEFT_CLICK_BLOCK
					|| event.getAction() == Action.RIGHT_CLICK_BLOCK || event.getAction() == Action.RIGHT_CLICK_AIR)
				event.setCancelled(true);
			if (Base.temKit(event.getPlayer()) && Base.qualKit(event.getPlayer()) == "Kangaroo") {
				if (p.getLocation().getY() >= 63) {
					if (!Gladiator.lutando.containsKey(p) && !Gladiator.lutando.containsValue(p)) {
						return;
					}
				}
				if (!(CooldownAPI.SemCooldown(p))) {
					return;
				}
				if (!this.kanga.contains(p)) {
					p.setLastDamageCause(new EntityDamageEvent(p, EntityDamageEvent.DamageCause.FALL, 0.0D));
					if (!p.isSneaking()) {
						Vector vector = p.getEyeLocation().getDirection();
						vector.multiply(0.6F);
						vector.setY(1.0F);
						p.setVelocity(vector);
					} else {
						p.setVelocity(p.getLocation().getDirection().multiply(1.5D));
						p.setVelocity(new Vector(p.getVelocity().getX(), 0.5D, p.getVelocity().getZ()));
					}
					this.kanga.add(p);
				}
			}
		}
	}

	@EventHandler
	public void onMover(PlayerMoveEvent event) {
		Player p = event.getPlayer();
		if (this.kanga.contains(p)) {
			Block b = p.getLocation().getBlock();
			if (b.getType() != Material.AIR || b.getRelative(BlockFace.DOWN).getType() != Material.AIR)
				this.kanga.remove(p);
		}
	}

	@EventHandler
	public void onDamage(EntityDamageEvent event) {
		Entity e = event.getEntity();
		if ((e instanceof Player)) {
			Player p = (Player) e;
			if (Base.qualKit(p) == "Kangaroo" && ((event.getEntity() instanceof Player))) {
				if (event.getCause() == EntityDamageEvent.DamageCause.FALL) {
					if (event.getDamage() > 7.0D) {
						event.setDamage(7.0D);
					}
				}
			}
		}
	}

	@EventHandler
	public void pvp(EntityDamageByEntityEvent e) {
		if (e.getEntity() instanceof Player && e.getDamager() instanceof Player) {
			Player p = (Player) e.getEntity();
			if (Base.qualKit(p) == "Kangaroo") {
				CooldownAPI.mCooldown(p, "Kangaroo");
			}
			if (Base.qualKit(p) == "Phantom") {
				CdAPI.mCooldown(p, "Phantom");
			}
		}
	}
}
