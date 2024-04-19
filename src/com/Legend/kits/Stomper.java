package com.Legend.kits;

import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;

import com.Legend.events.BloqSpawn;
import com.Legend.kits.manager.Base;

public class Stomper implements Listener {

	public void onPlayerStomp(EntityDamageEvent e) {
		if (!(e.getEntity() instanceof Player)) {
			return;
		}
		Player p = (Player) e.getEntity();
		if (e.getCause() == EntityDamageEvent.DamageCause.FALL) {
			if (Base.qualKit(p) == "Stomper") {
				if (p.getLocation().getY() >= 63) {
					return;
				}
				for (Entity ent : p.getNearbyEntities(3.0D, 3.0D, 3.0D)) {
					if (ent instanceof Player) {
						Player plr = (Player) ent;
						if (!(Base.qualKit(plr).equalsIgnoreCase("ironhead"))) {
							if (!BloqSpawn.jump.contains(p.getName())) {
								if (plr.isSneaking()) {
									plr.damage(6.0D, (Entity) p);
									continue;
								} else {
									plr.damage(e.getDamage() + 3.0D, (Entity) p);
								}
							}
						}
					}
				}
				e.setDamage(4.0);
				return;
			}
			return;
		}
	}

	public boolean hasPlayer(Player p) {
		return true;
	}

	@EventHandler(priority = EventPriority.HIGH)
	private void onPlayerFallStomper(EntityDamageEvent e) {
		if (!(e.getEntity() instanceof Player))
			return;

		Player player = (Player) e.getEntity();

		if (e.getCause() != DamageCause.FALL)
			return;

		if (Base.qualKit(player) == "Stomper") {
			if (!BloqSpawn.jump.contains(player.getName())) {
				if (player.getFallDistance() >= 5) {
					for (Entity et : player.getNearbyEntities(2.0D, 4.0D, 2.0D)) {
						if (et instanceof Player) {
							Player d = (Player) et;
							if (d == player)
								continue;
							if (hasPlayer(d)) {
								if (Base.qualKit(d) == "IronHead") {

								} else if (d.isSneaking()) {
									d.damage(0.1D, player);
									d.damage(3.9D);
									d.damage(0.1D, player);
								} else {
									d.damage(0.1D, player);
									d.damage(player.getFallDistance() - 8.1F);
									d.damage(0.1D, player);
								}
							}
						}
					}

					Location player_location = player.getLocation();

					int radius = 2;

					for (int i = 0; i < 2; i++) {
						for (double x = -radius; x <= radius; x = x + 1.0D) {
							for (double z = -radius; z <= radius; z = z + 1.0D) {
								Location effect_location = new Location(player_location.getWorld(),
										player_location.getX() + x, player_location.getY(), player_location.getZ() + z);

								effect_location.getWorld().playEffect(effect_location, Effect.MOBSPAWNER_FLAMES, 500);
							}
						}
					}
				}
			}
			if (e.getDamage() > 4.0D) {
				e.setDamage(4.0D);
			}
		}
		if (!(e.getEntity() instanceof Player))
			return;

		Player p = (Player) e.getEntity();
		if (e.getCause() == EntityDamageEvent.DamageCause.FALL) {
			if (BloqSpawn.jump.contains(p.getName())) {
				BloqSpawn.jump.remove(p.getName());
				e.setDamage(0.0D);
				return;
			}
			return;
		}
	}
}