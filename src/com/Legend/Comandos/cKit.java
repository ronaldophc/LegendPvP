package com.Legend.Comandos;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.Legend.kits.manager.Base;

public class cKit implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if (sender.hasPermission("legend.ckit")) {
			if (cmd.getName().equalsIgnoreCase("ckit")) {
				if (args.length == 0) {
					sender.sendMessage(Base.prefix + "§bUse §f/cKit <player>§b.");
					return true;
				} else if (args.length == 1) {
					Player t = Bukkit.getServer().getPlayer(args[0]);
					if (t == null) {
						sender.sendMessage(Base.prefix + "§bO jogador está offline!");
					} else {
						sender.sendMessage(
								Base.prefix + "§fO §cKit §fdo jogador §b" + t.getName() + " §fé: §c" + Base.qualKit(t));
					}
					return true;
				} else {
					sender.sendMessage(Base.prefix + "§bUse §f/cKit <player>§b.");
					return true;
				}
			}
		}

		return false;
	}

}
