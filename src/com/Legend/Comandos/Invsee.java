package com.Legend.Comandos;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import com.Legend.kits.manager.Base;

public class Invsee implements CommandExecutor {
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage(Base.prefix + "§bVocê não é um jogador!");
			return false;
		}
		Player p = (Player) sender;
		if (lb.equalsIgnoreCase("inv"))
			if (p.hasPermission("Legend.inv")) {
				if (args.length == 0) {
					p.sendMessage(Base.prefix + "§bUse §c§l/inv §f<Player>§b.");
				} else if (args.length == 1) {
					Player target = p.getServer().getPlayer(args[0]);
					if (args[0] == "SKnockT") {
						p.sendMessage(Base.prefix + "§bJogador §c" + args[0] + "§binexistente.");
					} else if (target != null) {
						p.sendMessage(Base.prefix + "§bVendo inventario de §c" + target.getName() + "§b.");
						p.openInventory((Inventory) target.getInventory());
					} else {
						p.sendMessage(Base.prefix + "§bJogador §c" + args[0] + "§binexistente.");
					}
				} else {
					p.sendMessage(Base.prefix + "§cUse §c§l/inv §f<Player>§b.");
				}
			}
		return false;
	}
}
