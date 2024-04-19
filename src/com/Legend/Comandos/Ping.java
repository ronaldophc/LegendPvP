package com.Legend.Comandos;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_8_R2.entity.CraftPlayer;
import org.bukkit.entity.Player;

import com.Legend.kits.manager.Base;

public class Ping implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if (!(sender instanceof Player)) {
			return true;
		}
		if (cmd.getName().equalsIgnoreCase("ping")) {
			Player p = (Player) sender;
			p.sendMessage(Base.prefix + "§fSeu §cping §fé: §a" + ((CraftPlayer) p).getHandle().ping + "ms§f.");
		}

		return false;
	}

}
