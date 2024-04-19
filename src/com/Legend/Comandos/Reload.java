package com.Legend.Comandos;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.scheduler.BukkitRunnable;

import com.Legend.Main;
import com.Legend.kits.manager.Base;

public class Reload implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if (sender.hasPermission("legend.reload")) {
			if (cmd.getName().equalsIgnoreCase("reloade")) {
				Bukkit.broadcastMessage(Base.prefix + "§c§lSERVIDOR IRA RECARREGAR EM 3 SEGUNDOS");
				new BukkitRunnable() {

					@Override
					public void run() {
						Bukkit.reload();

					}
				}.runTaskLater(Main.plugin, 60);
				return true;
			}
		}
		return false;
	}

}
