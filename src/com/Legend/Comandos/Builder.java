package com.Legend.Comandos;

import java.util.ArrayList;

import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.Legend.kits.manager.Base;

public class Builder implements CommandExecutor {

	public static ArrayList<String> pode = new ArrayList<>();

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if (!(sender instanceof Player)) {
			return true;
		}
		if (cmd.getName().equalsIgnoreCase("Builder")) {
			Player p = (Player) sender;
			if (args.length == 0) {
				if (p.hasPermission("Legend.Builder")) {
					if (!pode.contains(p.getName())) {
						pode.add(p.getName());
						p.setGameMode(GameMode.CREATIVE);
						p.sendMessage(Base.prefix + "§bVocê entrou no modo Builder.");
					} else if (pode.contains(p.getName())) {
						pode.remove(p.getName());
						p.sendMessage(Base.prefix + "§bVocê saiu do modo Builder.");
					}
				} else {
					p.sendMessage(Base.prefix + "§bVocê não tem permissão.");
				}
			}
		}
		return false;
	}
}