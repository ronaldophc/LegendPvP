package com.Legend.kits;

import java.util.HashMap;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.Legend.Main;
import com.Legend.kits.manager.Base;

public class Viper implements Listener {

	public static HashMap<Player, Player> a = new HashMap<>();
	public static HashMap<Player, Player> b = new HashMap<>();

	@EventHandler
	public void veneno(EntityDamageByEntityEvent e) {
		if (e.getDamager() instanceof Player) {
			Player p = (Player) e.getDamager();
			if (Base.temKit(p) && Base.qualKit(p) == "Viper") {
				if(p.getLocation().getY() >= 63) {
					if (!Gladiator.lutando.containsKey(p) && !Gladiator.lutando.containsValue(p)) {
						return;
					}
				}
				Player pl = (Player) e.getEntity();
				if (new Random().nextInt(100) <= 35)
					pl.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 5 * 20, 0));
			}
			if ((Base.qualKit(p) == "Ajnin") && !(a.containsKey((Player) e.getDamager()))) {
				Player hitado = (Player) e.getEntity();
				a.put(p, hitado);
				Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable() {
					public void run() {
						a.remove(p); 
						a.remove(hitado);
					}
				}, 15 * 20);
			}
			if ((Base.qualKit(p) == "Ninja") && !(b.containsKey((Player) e.getDamager()))) {
				Player hitado = (Player) e.getEntity();
				b.put(p, hitado);
				Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable() {
					public void run() {
						b.remove(p);
						b.remove(hitado);
					}
				}, 15 * 20);
			}
		}
	}
}
