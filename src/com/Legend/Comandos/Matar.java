package com.Legend.Comandos;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.Legend.kits.manager.Base;

public class Matar implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if (cmd.getName().equalsIgnoreCase("matar")) {
			if(!(sender.hasPermission("legend.matar"))) {
				return true;
			} else {
				if (args.length == 0) {
					sender.sendMessage(Base.prefix + "�bUse �f/matar <player> �bpara matar um player.");
					return true;
				}
				if (args.length == 1) {
					Player target = Bukkit.getPlayerExact(args[0]);
					if (target == null || !(target instanceof Player)) {
						sender.sendMessage(Base.prefix + "�bJogador n�o encontrado!");
						return true;
					}
					target.damage(20D);
					target.sendMessage(Base.prefix+ "�bVoc� foi morto por um �cADM�b.");
					sender.sendMessage(Base.prefix + "�bVoc� matou �f" + target.getName() + "�b.");
					return true;
				}
				if (args.length > 1) {
					sender.sendMessage(Base.prefix + "�bUse �f/matar <player> �bpara matar um player.");
					return true;
				}
			}
		}

		return false;
	}

}
