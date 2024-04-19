package com.Legend.Comandos;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import com.Legend.Main;
import com.Legend.kits.manager.Base;

public class Itens implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if (cmd.getName().equalsIgnoreCase("setitens")) {
			if (sender.hasPermission("legend.setitens")) {
				if (args.length == 0) {
					sender.sendMessage(Base.prefix + "§bUse §f/setitens <player>§b.");
					return true;
				}
				if (args.length == 1) {
					String pl = args[0];
					if (Main.itens.getConfig().get(pl) == null) {
						Main.itens.getConfig().set(String.valueOf(pl + ".Quantos"), Integer.valueOf(100));
						Main.itens.getConfig().set(String.valueOf(pl + ".Ativo"), Boolean.valueOf(true));
					} else {
						Main.itens.getConfig().set(String.valueOf(pl + ".Quantos"),
								Integer.valueOf(getItens(pl) + 100));
					}
					Main.itens.save();
					sender.sendMessage(Base.prefix + "§bVocê setou 100 itens extras para o jogador " + pl);
				}
			}
		}

		return false;
	}

	public static int getItens(String name) {
		return Main.itens.getConfig().getInt(String.valueOf(name + ".Quantos"));
	}

	public static boolean temItens(String name) {
		if (getItens(name) >= 1) {
			return true;
		} else {
			return false;
		}

	}

	public static void ativoItens(String name, boolean ativo) {
		Main.itens.getConfig().set(String.valueOf(name + ".Ativo"), Boolean.valueOf(ativo));
		Main.itens.save();
	}

	public static boolean getativoItens(String name) {
		return Main.itens.getConfig().getBoolean(String.valueOf(name + ".Ativo"));
	}

	public static void usouItens(String name) {
		Main.itens.getConfig().set(String.valueOf(name + ".Quantos"), Integer.valueOf(getItens(name) - 1));
		Main.itens.save();
	}
}
