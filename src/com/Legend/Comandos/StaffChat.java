package com.Legend.Comandos;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.Legend.guis.Title;
import com.Legend.kits.manager.Base;

public class StaffChat implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if (!(sender instanceof Player)) {
			if (args.length == 0) {
				sender.sendMessage(Base.prefix + "§bUse §f/sc <msg>§b.");
				return true;
			} else if (args.length >= 1) {
				String message = "";
				for (int i = 0; i < args.length; i++)
					message = String.valueOf(message) + "§f" + args[i] + " ";
				for (Player s : Bukkit.getOnlinePlayers()) {
					if (s.hasPermission("legend.sc")) {
						s.sendMessage("§f[§cStaffChat§f] " + sender.getName() + " §b>> §f" + message);
						Title.sendActionBar(s, "§bNova mensagem no §cStaffChat");
					}
				}
			}
			return true;
		}
		Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("sc")) {
			if (p.hasPermission("legend.sc")) {
				if (args.length == 0) {
					p.sendMessage(Base.prefix + "§bUse §f/sc <msg>§b.");
					return true;
				} else if (args.length >= 1) {
					String message = "";
					for (int i = 0; i < args.length; i++)
						message = String.valueOf(message) + "§f" + args[i] + " ";
					for (Player s : Bukkit.getOnlinePlayers()) {
						if (s.hasPermission("legend.sc")) {
							s.sendMessage("§f[§cStaffChat§f] " + p.getPlayerListName() + " §b>> §f" + message);
							Title.sendActionBar(s, "§bNova mensagem no §cStaffChat");
						}
					}
				}
			}
		}

		return false;
	}

}
