package com.Legend.events;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.util.Vector;

import com.Legend.kits.Gladiator;
import com.Legend.kits.manager.Base;

public class BloqSpawn implements Listener {

	public static ArrayList<String> jump = new ArrayList<>();

	@EventHandler
	public void event(PlayerMoveEvent e) {
		Player p = e.getPlayer();
		double x = p.getLocation().getX();
		double y = p.getLocation().getY();
		double z = p.getLocation().getZ();
		World world = p.getWorld();
		float pi = p.getLocation().getPitch();
		float ya = p.getLocation().getYaw();
		if (Base.temKit(p)) {
			if (!Gladiator.lutando.containsKey(p) && !Gladiator.lutando.containsValue(p)) {
				if (p.getGameMode() == GameMode.SURVIVAL) {
					if (Base.qualKit(p) == "Fps" || Base.qualKit(p) == "RDM" || Base.qualKit(p) == "1v1"
							|| Base.qualKit(p) == "SpecRDM" || Base.qualKit(p) == "lava"
							|| Base.qualKit(p) == "Legend Arena") {
						return;
					}
					if (y >= 68 && y <= 70) {
						Location loc = new Location(world, x, 67, z, ya, pi);
						p.teleport(loc);
						p.sendMessage("§cVocê não pode subir mais!");
					}
				}
			}
		} else {
			if (y <= 68 && y >= 60) {
				if (p.getGameMode() == GameMode.SURVIVAL) {
					if (Base.qualKit(p) == "Fps" || Base.qualKit(p) == "RDM" || Base.qualKit(p) == "1v1"
							|| Base.qualKit(p) == "SpecRDM" || Base.qualKit(p) == "Lava"
							|| Base.qualKit(p) == "Legend Arena") {
						return;
					}
					if (Base.qualaKit(p) == null || Base.qualaKit(p) == "Nenhum") {
						Base.setarKit(p, "PvP");
					} else {
						Base.setarKit(p, Base.qualaKit(p));
					}
					Base.darItens(p);
					List<Integer> a = new ArrayList<>();
					a.add(3);
					a.add(4);
					int b = a.get(new Random().nextInt(a.size()));
					Vector sponge = p.getLocation().getDirection().multiply(b).setY(0.25D);
					p.setVelocity(sponge);
					jump.add(p.getName());
				}
			}
		}
	}

	@EventHandler
	public void onPlayerSpongeDamage1(EntityDamageEvent e) {
		if (!(e.getEntity() instanceof Player))
			return;
		Player p = (Player) e.getEntity();
		if (e.getCause() == EntityDamageEvent.DamageCause.FALL) {
			if (jump.contains(p.getName())) {
				jump.remove(p.getName());
				e.setDamage(0.0D);
				return;
			}
			return;
		}
	}
}
