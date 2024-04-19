package com.Legend.Comandos;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import com.Legend.kits.manager.Base;

public class Site implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if(cmd.getName().equalsIgnoreCase("site")) {
			sender.sendMessage(Base.prefix + "§bSite do servidor: §awww.legendpvp.com.br");
		}
		return false;
	}

}
