package com.Legend.Comandos;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.Legend.kits.manager.Base;

public class Youtuber implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if (!(sender instanceof Player)) {
			return true;
		}
		if (cmd.getName().equalsIgnoreCase("Youtuber") || cmd.getName().equalsIgnoreCase("Streamer")) {
			Player p = (Player) sender;
			p.sendMessage(Base.prefix + "§cEntre em nosso §c§lDiscord §cpara ver os Requisitos!");
			p.chat("/discord");
		}

		return false;
	}

}
