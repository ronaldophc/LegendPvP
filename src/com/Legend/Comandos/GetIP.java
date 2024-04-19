package com.Legend.Comandos;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.Legend.KD.API;
import com.Legend.kits.manager.Base;

public class GetIP implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if (!(sender instanceof Player)) {
			return true;
		}
		if (cmd.getName().equalsIgnoreCase("getip")) {
			Player p = (Player) sender;
			if (p.hasPermission("legend.ban.ip")) {
				if (args.length == 0) {
					p.sendMessage(Base.prefix + "§bUse §f/getIp <player>§b.");
				} else if (args.length == 1) {
					String t = args[0];
					if (API.getip(t) == null) {
						p.sendMessage(Base.prefix + "§bO jogador nunca entrou!");
						return true;
					}
					p.sendMessage(Base.prefix + "§7O ultimo IP desse jogador foi §a" + API.getip(t));
				}
			}
		}

		return false;
	}

}
