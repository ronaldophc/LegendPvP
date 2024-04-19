package com.Legend.kits.manager;

import java.util.HashMap;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.scheduler.BukkitRunnable;

import com.Legend.Main;
import com.Legend.guis.Title;

public class Kitlog implements Listener {

	public static HashMap<Player, Player> combat = new HashMap<Player, Player>();
	public static HashMap<Player, Long> tick = new HashMap<Player, Long>();

	public static void checkCombatLog(Player p, Player t) {
		if (!tick.containsKey(p)) {
			tick.put(p, Long.valueOf(7));
			combat.put(p, t);
			new BukkitRunnable() {
				public void run() {
					if (p != null) {
						if (tick.containsKey(p)) {
							tick.put(p, tick.get(p) - 1);
							if (tick.get(p) <= 0) {
								removeCombat(p);
								cancel();
							}
						}
					} else {
						cancel();
					}
				}
			}.runTaskTimer(Main.getPlugin(), 20, 20);
		}
	}

	public static boolean inCombat(Player p) {
		if (combat.containsKey(p)) {
			return true;
		}
		return false;
	}

	public static void removeCombat(Player p) {
		combat.remove(p);
		tick.remove(p);
	}

	@EventHandler
	public void Combat(EntityDamageByEntityEvent e) {
		if (e.getEntity() instanceof Player && e.getDamager() instanceof Player) {
			Player p = (Player) e.getEntity();
			Player t = (Player) e.getDamager();
			Title.sendActionBar(t, "§b" + p.getName() + " §f- §c" + Base.qualKit(p));
			if ((Base.temKit(p)) && (Base.temKit(t)) && (!(Base.qualKit(t) == "RDM"))) {
				if (!inCombat(p)) {
					checkCombatLog(p, t);
				} else {
					tick.put(p, Long.valueOf(7));
				}
			}
		}
	}

	@EventHandler
	public void Deslogar(PlayerQuitEvent e) {
		Player p = e.getPlayer();
		if (inCombat(p)) {
			removeCombat(p);
		}
	}
}
