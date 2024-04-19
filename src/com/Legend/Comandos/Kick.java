package com.Legend.Comandos;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.Legend.kits.manager.Base;

public class Kick implements CommandExecutor {
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if (cmd.getName().equalsIgnoreCase("kick")) {
			if (sender.hasPermission("Legend.kick") || sender.isOp()) {
				if (args.length == 0) {
					sender.sendMessage(Base.prefix + "§bUse §f/kick <player> <motivo>§b.");
				} else if (args.length == 1) {
					Player targetPlayer = Bukkit.getServer().getPlayer(args[0]);
					if (targetPlayer == null) {
						sender.sendMessage(Base.prefix + "§bO jogador está offline!");
					} else {
						Bukkit.broadcastMessage(Base.prefix + targetPlayer.getDisplayName() + " §b§lfoi kickado por "
								+ sender.getName() + "§b.");
						targetPlayer.kickPlayer(Base.prefix + targetPlayer.getName() + " §bfoi kickado por "
								+ sender.getName() + "§b.");
					}
				} else if (args.length > 1) {
					Player targetPlayer = Bukkit.getServer().getPlayer(args[0]);
					if (targetPlayer == null) {
						sender.sendMessage(Base.prefix + "§bO jogador está offline!");
					} else {
						String message = "";
						for (int i = 1; i < args.length; i++)
							message = String.valueOf(message) + "§f" + args[i] + " ";
						targetPlayer.kickPlayer(Base.prefix + targetPlayer.getName() + " §bfoi kickado por "
								+ sender.getName() + " §bpelo motivo §f'" + message + "'§b.");
						Bukkit.broadcastMessage(Base.prefix + targetPlayer.getDisplayName() + " §bkickado por "
								+ sender.getName() + " §bpelo motivo §f'" + message + "'§b.");
					}
				}
			}
		}
		return false;
	}
}
