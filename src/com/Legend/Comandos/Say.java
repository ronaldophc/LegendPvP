package com.Legend.Comandos;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import com.Legend.kits.manager.Base;

public class Say implements CommandExecutor {
	public boolean onCommand(CommandSender Sender, Command command, String commandLabel, String[] args) {
		if (command.getName().equalsIgnoreCase("say") && Sender.hasPermission("legend.say")) {
			if (args.length > 0) {
				StringBuffer me = new StringBuffer();
				for (int i = 0; i < args.length; i++)
					me.append(String.valueOf(args[i]) + " ");
				Bukkit.broadcastMessage(Base.prefix + me);
			} else {
				Sender.sendMessage(Base.prefix + "§bUse: §f/Say <MSG>§b.");
			}
		}
		return false;
	}
}
