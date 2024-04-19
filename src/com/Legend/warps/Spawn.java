package com.Legend.warps;


import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.potion.PotionEffect;

import com.Legend.Main;
import com.Legend.KD.API;
import com.Legend.events.Combatlog;
import com.Legend.guis.Inventario;
import com.Legend.guis.Title;
import com.Legend.kits.manager.Base;

public class Spawn implements Listener, CommandExecutor {
	public static Main plugin;

	public Spawn(Main main) {
		plugin = main;
	}

	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if (cmd.getName().equalsIgnoreCase("spawn")) {
			final Player p = (Player) sender;
			if (Combatlog.inCombat(p)) {
				p.sendMessage(Base.prefix + "§cEm combate nao!");
			} else {
				tpSpawn(p);
			}
		}
		return false;
	}

	public static void tpSpawn(Player p) {
		Title.sendActionBar(p, "§6Você sera teleportado em 3 segundos");
		plugin.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
			public void run() {
				if (!Combatlog.inCombat(p)) {
					p.getOpenInventory().close();
					API.clearPlayer(p);
					Base.tirarKit(p);
					p.teleport(WarpAPI.getLocation("Spawn"));
					for (PotionEffect effect : p.getActivePotionEffects())
						p.removePotionEffect(effect.getType());
					p.sendMessage(Base.prefix + "§bVocê foi teleportado para o §cSpawn§b!");
					p.getInventory().clear();
					Inventario.setarInv(p);
				} else {
					p.sendMessage(Base.prefix + "§cTP para o Spawn cancelado, você entrou em combate.");
				}
				return;
			}
		}, 3 * 20);
	}

	public static void tpinstaSpawn(Player p) {
		p.getOpenInventory().close();
		API.clearPlayer(p);
		Base.tirarKit(p);
		p.teleport(WarpAPI.getLocation("Spawn"));
		for (PotionEffect effect : p.getActivePotionEffects())
			p.removePotionEffect(effect.getType());
		p.getInventory().clear();
		Inventario.setarInv(p);
	}

}
