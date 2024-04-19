package com.Legend.kits.manager;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import com.Legend.Main;
import com.Legend.guis.Title;

public class CooldownAPI {
	public static HashMap<String, Long> Cooldown = new HashMap<>();

	public static void addCooldown(final Player jogador, int Tempo) {
		Cooldown.put(jogador.getName(), Long.valueOf(System.currentTimeMillis() + TimeUnit.SECONDS.toMillis(Tempo)));
		Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable() {
			public void run() {
				CooldownAPI.tirarCooldown(jogador);
			}
		}, (Tempo * 20));
	}

	public static void tirarCooldown(Player p) {
		if (CooldownAPI.SemCooldown(p)) {
			Cooldown.remove(p.getName());
		}
	}

	public static boolean SemCooldown(Player p) {
		if (!Cooldown.containsKey(p.getName())
				|| ((Long) Cooldown.get(p.getName())).longValue() <= System.currentTimeMillis())
			return true;
		return false;
	}

	public static long Cooldown(Player p) {
		long tempo = TimeUnit.MILLISECONDS
				.toSeconds(((Long) Cooldown.get(p.getName())).longValue() - System.currentTimeMillis());
		if (Cooldown.containsKey(p.getName())
				|| ((Long) Cooldown.get(p.getName())).longValue() > System.currentTimeMillis())
			return tempo;
		return 0L;
	}

	public static void mCooldown(Player p, String Kit) {
		if (!SemCooldown(p)) {
			if(Cooldown(p) >= 6) {
				x10(p, Kit);
			} else if(Cooldown(p) <= 5) {
				x5(p, Kit);
			}
		}
		if (Base.qualKit(p) == "Kangaroo") {
			addCooldown(p, 7);
		}
	}
	public static void x10(Player p, String Kit) {
		new BukkitRunnable() {

			@Override
			public void run() {
				if(SemCooldown(p)) {
					cancel();
				}
				if (Cooldown(p) <= 0) {
					Title.sendActionBar(p,
							"§f" + Kit + " §a:::::::::::::::::::: " + CooldownAPI.Cooldown(p) + " segundos");
					cancel();
					CooldownAPI.tirarCooldown(p);
				} else if (Cooldown(p) == 1) {
					Title.sendActionBar(p,
							"§f" + Kit + " §c::§a:::::::::::::::::: " + CooldownAPI.Cooldown(p) + " segundos");
				} else if (Cooldown(p) == 2) {
					Title.sendActionBar(p,
							"§f" + Kit + " §c::::§a:::::::::::::::: " + CooldownAPI.Cooldown(p) + " segundos");
				} else if (Cooldown(p) == 3) {
					Title.sendActionBar(p,
							"§f" + Kit + " §c::::::§a:::::::::::::: " + CooldownAPI.Cooldown(p) + " segundos");
				} else if (Cooldown(p) == 4) {
					Title.sendActionBar(p,
							"§f" + Kit + " §c::::::::§a:::::::::::: " + CooldownAPI.Cooldown(p) + " segundos");
				} else if (Cooldown(p) == 5) {
					Title.sendActionBar(p,
							"§f" + Kit + " §c::::::::::§a:::::::::: " + CooldownAPI.Cooldown(p) + " segundos");
				} else if (Cooldown(p) == 6) {
					Title.sendActionBar(p,
							"§f" + Kit + " §c::::::::::::§a:::::::: " + CooldownAPI.Cooldown(p) + " segundos");
				} else if (Cooldown(p) == 7) {
					Title.sendActionBar(p,
							"§f" + Kit + " §c::::::::::::::§a:::::: " + CooldownAPI.Cooldown(p) + " segundos");
				} else if (Cooldown(p) == 8) {
					Title.sendActionBar(p,
							"§f" + Kit + " §c::::::::::::::::§a:::: " + CooldownAPI.Cooldown(p) + " segundos");
				} else if (Cooldown(p) == 9) {
					Title.sendActionBar(p,
							"§f" + Kit + " §c::::::::::::::::::§a:: " + CooldownAPI.Cooldown(p) + " segundos");
				} else if (Cooldown(p) == 10) {
					Title.sendActionBar(p,
							"§f" + Kit + " §c:::::::::::::::::::: " + CooldownAPI.Cooldown(p) + " segundos");
				}
			}
		}.runTaskTimer(Main.plugin, 2, 2);
	}
	public static void x5(Player p, String Kit) {
		new BukkitRunnable() {

			@Override
			public void run() {
				if(SemCooldown(p)) {
					cancel();
				}
				if (Cooldown(p) <= 0) {
					Title.sendActionBar(p,
							"§f" + Kit + " §a:::::::::::: " + CooldownAPI.Cooldown(p) + " segundos");
					cancel();
					CooldownAPI.tirarCooldown(p);
				} else if (Cooldown(p) == 1) {
					Title.sendActionBar(p,
							"§f" + Kit + " §c::§a:::::::: " + CooldownAPI.Cooldown(p) + " segundos");
				} else if (Cooldown(p) == 2) {
					Title.sendActionBar(p,
							"§f" + Kit + " §c::::§a:::::: " + CooldownAPI.Cooldown(p) + " segundos");
				} else if (Cooldown(p) == 3) {
					Title.sendActionBar(p,
							"§f" + Kit + " §c::::::§a:::: " + CooldownAPI.Cooldown(p) + " segundos");
				} else if (Cooldown(p) == 4) {
					Title.sendActionBar(p,
							"§f" + Kit + " §c::::::::§a:: " + CooldownAPI.Cooldown(p) + " segundos");
				} else if (Cooldown(p) == 5) {
					Title.sendActionBar(p,
							"§f" + Kit + " §c:::::::::: " + CooldownAPI.Cooldown(p) + " segundos");
				}
			}
		}.runTaskTimer(Main.plugin, 2, 2);
	}
}
