package com.Legend.Comandos;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import com.Legend.Main;
import com.Legend.kits.manager.Base;

public class Mute implements CommandExecutor{

	public static List<String> mutas = new ArrayList<>();
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if(sender.hasPermission("legend.mute")) {
			if(cmd.getName().equalsIgnoreCase("mute")) {
				if(args.length == 0) {
					sender.sendMessage(Base.prefix + "§bUse §f/mute <player>§b.");
					return true;
				}
				if(args.length == 1) {
					if(tamutado(args[0])) {
						sender.sendMessage(Base.prefix + "§bO Jogador já está mutado.");
						return true;
					}
					sender.sendMessage(Base.prefix + "§bVocê mutou o jogador §c" + args[0] + "§b.");
					for(Player p :Bukkit.getOnlinePlayers()) {
						if(args[0].equalsIgnoreCase(p.getName())) {
							p.sendMessage(Base.prefix + "§c§lVocê foi mutado permanentemente pelo Staff " + sender.getName());
						}
					}
					mutar(args[0]);
					return true;
				}
			} else if(cmd.getName().equalsIgnoreCase("desmute")) {
				if(args.length == 0) {
					sender.sendMessage(Base.prefix + "§bUse §f/desmute <player>§b.");
					return true;
				}
				if(args.length == 1) {
					if(!(tamutado(args[0]))) {
						sender.sendMessage(Base.prefix + "§bO Jogador não está mutado.");
						return true;
					}
					sender.sendMessage(Base.prefix + "§bVocê desmutou o jogador §c" + args[0] + "§b.");
					for(Player p :Bukkit.getOnlinePlayers()) {
						if(args[0].equalsIgnoreCase(p.getName())) {
							p.sendMessage(Base.prefix + "§c§lVocê foi desmutado pelo Staff " + sender.getName());
						}
					}
					desmutar(args[0]);
					return true;
				}
			} else if(cmd.getName().equalsIgnoreCase("tempmute")) {
				if(args.length == 0) {
					sender.sendMessage(Base.prefix + "§bUse §f/tempmute <player> <minutos>§b.");
					return true;
				}
				if(args.length == 1) {
					sender.sendMessage(Base.prefix + "§bUse §f/tempmute <player> <minutos>§b.");
					return true;
				}
				if(args.length == 2) {
					if(tamutado(args[0])) {
						sender.sendMessage(Base.prefix + "§bO Jogador está mutado em definitivo.");
						return true;
					}
					if(mutas.contains(args[0])) {
						sender.sendMessage(Base.prefix + "§bO Jogador está mutado temporariamente.");
						return true;
					}
					if(!(isInt(args[1]))) {
						sender.sendMessage(Base.prefix + "§bMinutos precisa ser em numero");
						return true;
					}
					mutas.add(args[0]);
					int tempo = Integer.valueOf(args[1]);
					for(Player p :Bukkit.getOnlinePlayers()) {
						if(args[0].equalsIgnoreCase(p.getName())) {
							p.sendMessage(Base.prefix + "§c§lVocê foi mutado temporariamente pelo Staff " + sender.getName() + " por " + tempo + " minuto(s).");
						}
					}
					sender.sendMessage(Base.prefix + "§c§lVocê mutou temporariamente " + args[0] + " por " + tempo + " minuto(s).");
					new BukkitRunnable() {
						
						@Override
						public void run() {

							mutas.remove(args[0]);
							
						}
					}.runTaskLater(Main.plugin, tempo * 1200);
					
					
					return true;
				}
			}
		}
		return false;
	}

	
	public void mutar(String name) {
		Main.mutes.getConfig().set(String.valueOf(name), Boolean.valueOf(true));
		Main.mutes.save();
	}
	public void desmutar(String name) {
		Main.mutes.getConfig().set(String.valueOf(name), Boolean.valueOf(false));
		Main.mutes.save();
	}
	public static boolean tamutado(String name) {
		return Main.mutes.getConfig().getBoolean(String.valueOf(name));
	}
	public boolean isInt(String str) {
	    try {
	        Integer.parseInt(str);
	        return true;
	    } catch (NumberFormatException e) {
	        return false;
	    }
	}
}
