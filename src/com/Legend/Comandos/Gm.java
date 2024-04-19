package com.Legend.Comandos;

import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.Legend.kits.manager.Base;

public class Gm implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if (!(sender instanceof Player)) {
			return true;
		}
		if (cmd.getName().equalsIgnoreCase("Gm")) {
			Player p = (Player) sender;
			if (p.hasPermission("Legend.gm")) {
				if (args.length == 0) {
					p.sendMessage(Base.prefix + "§bUse §f/Gm 0 ou 1§b.");
				}
				if (args.length == 1) {
					if (args[0].equalsIgnoreCase("0")) {
						p.setGameMode(GameMode.SURVIVAL);
						p.sendMessage(Base.prefix + "§bVocê entrou no modo §fSurvival§b!");
					} else if (args[0].equalsIgnoreCase("1")) {
						p.setGameMode(GameMode.CREATIVE);
						p.sendMessage(Base.prefix + "§bVocê entrou no modo §fCriativo§b!");
					} else {
						p.sendMessage(Base.prefix + "§bUse §f/gm 0 ou 1§b.");
					}
				}
			}
		}

		return false;
	}

}
