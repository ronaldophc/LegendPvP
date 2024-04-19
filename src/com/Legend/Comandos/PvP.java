package com.Legend.Comandos;


import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import com.Legend.kits.manager.Base;

public class PvP implements Listener, CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage(Base.prefix + "§bSomente jogadores podem executar este comando!");
			return true;
		}
		Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("pvp") && (p.hasPermission("Legend.pvp") || p.isOp())) {
			if (p.getWorld().getPVP() == true) {
				p.getWorld().setPVP(false);
				Bukkit.getServer().broadcastMessage(Base.prefix + "§b-=§cPVP FOI DESATIVADO§b-=");
				return true;
			} 
			p.getWorld().setPVP(true);
			Bukkit.getServer().broadcastMessage(Base.prefix + "§b-=§cPVP FOI ATIVADO§b-=");
			return true;
		}
		return true;
	}
}
