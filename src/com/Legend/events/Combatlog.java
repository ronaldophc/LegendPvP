package com.Legend.events;

import java.util.HashMap;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.scheduler.BukkitRunnable;

import com.Legend.Main;
import com.Legend.KD.API;
import com.Legend.guis.Title;
import com.Legend.kits.manager.Base;

public class Combatlog implements Listener {

	public static HashMap<Player, Player> combat = new HashMap<Player, Player>();
	public static HashMap<Player, Integer> tick = new HashMap<Player, Integer>();

	public static void checkCombatLog(Player p, Player t) {
		if (!tick.containsKey(p)) {
			tick.put(p, 10);
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
		if (p != null) {
			p.sendMessage(Base.prefix + "§aVocê não está mais em combate.");
		}
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
					tick.put(p, 10);
				}
			}
		}
	}

	@EventHandler
	public void Deslogar(PlayerQuitEvent e) {
		Player p = e.getPlayer();
		if (inCombat(p)) {
			Player t = combat.get(p);
			t.sendMessage(Base.prefix + "§f" + p.getName() + " §bdeslogou em combate e você ganhou a kill.");
			API.setkills(t);
			API.removerDinheiro(p, 20);
			API.setDinheiro(t, 50);
			API.setmortes(p);
			Main.file.save();
			API.addKs(t);
			API.resetKs(p);
			removeCombat(p);
		}
	}
}
