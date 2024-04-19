package com.Legend.Comandos;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

import com.Legend.kits.manager.Base;

public class Tp implements CommandExecutor {
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage("jogadores podem executar esse comando!");
			return true;
		}
		Player player = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("tp")) {
			if (!player.hasPermission("legend.tp")) {
				return true;
			}
			if (args.length == 0) {
				player.sendMessage(Base.prefix + "§f/tp <player> §bpara ir até um player.");
				player.sendMessage(Base.prefix + "§f/s <player> §bpara puxar um player até você.");
				return true;
			}
			if (args.length == 1) {
				Player target = Bukkit.getPlayerExact(args[0]);
				if (target == null || !(target instanceof Player)) {
					player.sendMessage(Base.prefix + "§bJogador não encontrado!");
					return true;
				}
				player.teleport((Entity) target);
				player.sendMessage(Base.prefix + "§bTeleportado para §f" + target.getName() + "§b.");
				return true;
			}
			if (args.length > 1) {
				player.sendMessage(Base.prefix + "§f/tp <player> §bpara ir até um player.");
				player.sendMessage(Base.prefix + "§f/s <player> §bpara puxar um player até você.");
				return true;
			}
		} else if (cmd.getName().equalsIgnoreCase("s")) {
			if (!player.hasPermission("legend.s")) {
				return true;
			}
			if (args.length == 0) {
				player.sendMessage(Base.prefix + "§f/tp <player> §bpara ir até um player.");
				player.sendMessage(Base.prefix + "§f/s <player> §bpara puxar um player até você.");
				return true;
			}
			if (args.length == 1) {
				Player target = Bukkit.getPlayerExact(args[0]);
				if (target == null || !(target instanceof Player)) {
					player.sendMessage(Base.prefix + "§bJogador não encontrado!");
					return true;
				}
				target.teleport((Entity) player);
				player.sendMessage(Base.prefix + "§bVocê puxou §f" + target.getName() + "§b.");
				return true;
			}
			if (args.length > 1) {
				player.sendMessage(Base.prefix + "§f/tp <player> §bpara ir até um player.");
				player.sendMessage(Base.prefix + "§f/s <player> §bpara puxar um player até você.");
				return true;
			}
		}
		return false;
	}
}