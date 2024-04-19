package com.Legend.warps;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import com.Legend.Main;
import com.Legend.events.Combatlog;
import com.Legend.guis.Title;
import com.Legend.kits.manager.Base;

public class Lava implements Listener, CommandExecutor {
	public static Main plugin;

	public Lava(Main main) {
		plugin = main;
	}

	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if (cmd.getName().equalsIgnoreCase("lava")) {
			final Player p = (Player) sender;
			if (Combatlog.inCombat(p)) {
				p.sendMessage(Base.prefix + "§cEm combate nao!");
			} else {
				Title.sendActionBar(p, "§6Você sera teleportado em 3 segundos");
				plugin.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
					public void run() {
						if (!Combatlog.inCombat(p)) {
							Base.tirarKit(p);
							Base.setarKit(p, "Lava");
							p.getInventory().clear();
							p.updateInventory();
							p.teleport(WarpAPI.getLocation("Lava"));
							p.sendMessage(Base.prefix + "§bVocê foi teleportado para a §cWarp Lava Challenge§b!");
							p.sendMessage(Base.prefix + "§cDigite /Spawn se quiser voltar para o spawn.");
						} else {
							p.sendMessage(Base.prefix + "§cTP para o Spawn cancelado, você entrou em combate.");
						}
						return;
					}
				}, 3 * 20);
			}
		}
		return false;
	}

}