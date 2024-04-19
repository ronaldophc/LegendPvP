package com.Legend.Comandos;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.Legend.kits.manager.Base;

public class Fly implements CommandExecutor {
	public boolean onCommand(CommandSender sender, Command cmd, String cmdLabel, String[] args) {
		if (!(sender instanceof Player)) {
			return true;
		}
		if (cmd.getName().equalsIgnoreCase("fly")) {
			Player player = (Player) sender;
			if (args.length == 0 && sender.hasPermission("legend.fly"))
				if (!player.getAllowFlight()) {
					player.sendMessage(Base.prefix + "§bFly Habilitado.");
					player.setAllowFlight(true);
				} else {
					player.sendMessage(Base.prefix + "§bFly Desabilitado.");
					player.setAllowFlight(false);
				}
			if (args.length == 1 && sender.hasPermission("legend.fly")) {
				Player player2 = Bukkit.getPlayer(args[0]);
				if (player2 == null) {
					sender.sendMessage(Base.prefix + "§bJogador §cOffline§b.");
					return true;
				}
				if (!player.getAllowFlight()) {
					sender.sendMessage(Base.prefix + "§bFly Habilitado para §c" + player2.getName() + "§b.");
					player2.setAllowFlight(true);
					player2.sendMessage(Base.prefix + "§bFly Habilitado por §c" + player.getName() + "§b.");
				} else {
					sender.sendMessage(Base.prefix + "§bFly Desabilitado para §c" + player2.getName() + "§b.");
					player.setAllowFlight(false);
					player2.sendMessage(Base.prefix + "§bFly Desabilitado por §c" + player.getName() + "§b.");
				}
			}
		}
		return false;
	}
}