package com.Legend.warps;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.Legend.Main;
import com.Legend.kits.manager.Base;

public class Arena implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if (cmd.getName().equalsIgnoreCase("setarena")) {
			Player p = (Player) sender;
			if (p.hasPermission("legend.setarena")) {
				if (args.length == 0) {
					p.sendMessage(Base.prefix + "§bUse §f/setarena <pos>§b.");
					return true;
				}
				if (args.length == 1) {
					int a = Integer.valueOf(args[0]);
					if (a == 1) {
						WarpAPI.setLocation(p.getLocation(), "Arena.1");
						p.sendMessage(Base.prefix + "Você setou a posicao 1 da Arena");
						return true;
					} else if (a == 2) {
						WarpAPI.setLocation(p.getLocation(), "Arena.2");
						p.sendMessage(Base.prefix + "Você setou a posicao 2 da Arena");
						return true;
					} else if (a == 3) {
						WarpAPI.setLocation(p.getLocation(), "Arena.3");
						p.sendMessage(Base.prefix + "Você setou a posicao 3 da Arena");
						return true;
					} else if (a == 4) {
						WarpAPI.setLocation(p.getLocation(), "Arena.4");
						p.sendMessage(Base.prefix + "Você setou a posicao 4 da Arena");
						return true;
					} else if (a == 5) {
						WarpAPI.setLocation(p.getLocation(), "Arena.5");
						p.sendMessage(Base.prefix + "Você setou a posicao 5 da Arena");
						return true;
					} else if (a == 6) {
						WarpAPI.setLocation(p.getLocation(), "Arena.6");
						p.sendMessage(Base.prefix + "Você setou a posicao 6 da Arena");
						return true;
					} else if (a == 7) {
						WarpAPI.setLocation(p.getLocation(), "Arena.7");
						p.sendMessage(Base.prefix + "Você setou a posicao 7 da Arena");
						return true;
					} else if (a == 8) {
						WarpAPI.setLocation(p.getLocation(), "Arena.8");
						p.sendMessage(Base.prefix + "Você setou a posicao 8 da Arena");
						return true;
					}
				}
			}
		}
		return false;
	}

	public static void randomArena(Player p) {
		List<Integer> a = new ArrayList<>();
		a.add(1);
		a.add(2);
		a.add(3);
		a.add(4);
		a.add(5);
		a.add(6);
		a.add(7);
		a.add(8);
		int b = a.get(new Random().nextInt(a.size()));
		p.teleport(WarpAPI.getLocation("Arena." + b));
	}

	public static boolean getArena(Player p) {
		return Main.file.getConfig().getBoolean(String.valueOf(p.getName()) + ".Arena");
	}

	public static void setArena(Player p, boolean a) {
		Main.file.getConfig().set(String.valueOf(p.getName()) + ".Arena", Boolean.valueOf(a));
		Main.file.save();
	}
}
