package com.Legend.Comandos;


import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import com.Legend.Main;
import com.Legend.kits.manager.Base;

public class Change implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if (cmd.getName().equalsIgnoreCase("change")) {
			if (sender.hasPermission("legend.change")) {
				if (args.length == 0) {
					sender.sendMessage(Base.prefix + "§bUse §f/change <comando|kit> <nomedocomando/kit> <on/off>§b.");
					return true;
				}
				if (args.length == 1) {
					if (args[0].equalsIgnoreCase("command")) {
						sender.sendMessage(Base.prefix + "§bUse §f/change comando <nomedocomando> <on/off>§b.");
					} else if (args[0].equalsIgnoreCase("kit")) {
						sender.sendMessage(Base.prefix + "§bUse §f/change kit <nomedokit> <on/off>§b.");
					} else
						sender.sendMessage(Base.prefix + "§bUse §f/change comando <nomedocomando> <on/off>§b.");
				}
			}
			if (args.length == 2) {
				if (args[0].equalsIgnoreCase("kit")) {
					sender.sendMessage(Base.prefix + "§bUse §f/change kit <nomedokit> <on/off>§b.");
				} else if (args[0].equalsIgnoreCase("comando")) {
					sender.sendMessage(Base.prefix + "§bUse §f/change comando <nomedocomando> <on/off>§b.");
				} else {
					sender.sendMessage(Base.prefix + "§bUse §f/change comando <nomedocomando> <on/off>§b.");
				}
			}
			if (args.length == 3) {
				if (args[0].equalsIgnoreCase("kit")) {
					String comando = args[1];
					if (hasKit(comando.toLowerCase()) == false) {
						sender.sendMessage(Base.prefix + "§bEsse Kit não existe§b.");
						sender.sendMessage(Base.prefix + "§bUse §f/change kit <nomedokit> <on/off>§b.");
					} else {
						if (args[2].equalsIgnoreCase("on")) {
							setKit(comando.toLowerCase(), true);
							sender.sendMessage(Base.prefix + "§cVocê ativou o Kit: " + comando + ".");
						} else if (args[2].equalsIgnoreCase("off")) {
							setKit(comando.toLowerCase(), false);
							sender.sendMessage(Base.prefix + "§cVocê desativou o Kit: " + comando + ".");
						}
					}
				} else if (args[0].equalsIgnoreCase("comando")) {
					String comando = args[1];
					Command command = Bukkit.getServer().getPluginCommand(comando);
					if (command == null) {
						sender.sendMessage(Base.prefix + "§bEsse comando não existe§b.");
						sender.sendMessage(Base.prefix + "§bUse §f/change comando <nomedocomando> <on/off>§b.");
					} else {
						if (args[2].equalsIgnoreCase("on")) {
							setC(comando, true);
							sender.sendMessage(Base.prefix + "§cVocê ativou o comando: " + comando + ".");
						} else if (args[2].equalsIgnoreCase("off")) {
							setC(comando, false);
							sender.sendMessage(Base.prefix + "§cVocê desativou o comando: " + comando + ".");
						}
					}
				}
			}
		}

		return false;
	}

	public static void setC(String Comando, boolean ativo) {
		Main.server.getConfig().set(String.valueOf("Comandos." + Comando), Boolean.valueOf(ativo));
		Main.server.save();
	}
	public static boolean actC(String Comando) {
		if(Main.server.getConfig().getBoolean(String.valueOf("Comandos." + Comando)) == true) {
			return true;
		}
		return false;
	}
	public static void setKit(String Kit, boolean ativo) {
		Main.server.getConfig().set(String.valueOf("Kits." + Kit), Boolean.valueOf(ativo));
		Main.server.save();
	}
	public static boolean hasKit(String Kit) {
		if(Main.server.getConfig().get(String.valueOf("Kits." + Kit)) == null) {
			return false;
		}
		return true;
	}
	public static boolean actKit(String Kit) {
		if(Main.server.getConfig().getBoolean(String.valueOf("Kits." + Kit)) == true) {
			return true;
		}
		return false;
	}
	public static void newKits() {
		if (Main.server.getConfig().get(String.valueOf("Kits.checkpoint")) == null) {
			Main.server.getConfig().set(String.valueOf("Kits.checkpoint"), Boolean.valueOf(true));
			Main.server.save();
		}
	}
	public static void createMySQL() {
		if (Main.server.getConfig().get(String.valueOf("MySQL.host")) == null) {
			Main.server.getConfig().set(String.valueOf("MySQL.host"), String.valueOf("localhost"));
			Main.server.getConfig().set(String.valueOf("MySQL.port"), String.valueOf("3305"));
			Main.server.getConfig().set(String.valueOf("MySQL.database"), String.valueOf("database"));
			Main.server.getConfig().set(String.valueOf("MySQL.username"), String.valueOf("username"));
			Main.server.getConfig().set(String.valueOf("MySQL.password"), String.valueOf("password"));
			Main.server.save();
		}
	}
	public static void addKits() {
		if (Main.server.getConfig().get(String.valueOf("Kits")) == null) {
			Main.server.getConfig().set(String.valueOf("Kits.pvp"), Boolean.valueOf(true));
			Main.server.getConfig().set(String.valueOf("Kits.archer"), Boolean.valueOf(true));
			Main.server.getConfig().set(String.valueOf("Kits.tank"), Boolean.valueOf(true));
			Main.server.getConfig().set(String.valueOf("Kits.boxer"), Boolean.valueOf(true));
			Main.server.getConfig().set(String.valueOf("Kits.camel"), Boolean.valueOf(true));
			Main.server.getConfig().set(String.valueOf("Kits.viper"), Boolean.valueOf(true));
			Main.server.getConfig().set(String.valueOf("Kits.snail"), Boolean.valueOf(true));
			Main.server.getConfig().set(String.valueOf("Kits.naruto"), Boolean.valueOf(true));
			Main.server.getConfig().set(String.valueOf("Kits.fireman"), Boolean.valueOf(true));
			Main.server.getConfig().set(String.valueOf("Kits.kangaroo"), Boolean.valueOf(true));
			Main.server.getConfig().set(String.valueOf("Kits.reaper"), Boolean.valueOf(true));
			Main.server.getConfig().set(String.valueOf("Kits.fisherman"), Boolean.valueOf(true));
			Main.server.getConfig().set(String.valueOf("Kits.viking"), Boolean.valueOf(true));
			Main.server.getConfig().set(String.valueOf("Kits.upgrader"), Boolean.valueOf(true));
			Main.server.getConfig().set(String.valueOf("Kits.critical"), Boolean.valueOf(true));
			Main.server.getConfig().set(String.valueOf("Kits.anticorona"), Boolean.valueOf(true));
			Main.server.getConfig().set(String.valueOf("Kits.ironhead"), Boolean.valueOf(true));
			Main.server.getConfig().set(String.valueOf("Kits.grandpa"), Boolean.valueOf(true));
			Main.server.getConfig().set(String.valueOf("Kits.achilles"), Boolean.valueOf(true));
			Main.server.getConfig().set(String.valueOf("Kits.monk"), Boolean.valueOf(true));
			Main.server.getConfig().set(String.valueOf("Kits.scout"), Boolean.valueOf(true));
			Main.server.getConfig().set(String.valueOf("Kits.switcher"), Boolean.valueOf(true));
			Main.server.getConfig().set(String.valueOf("Kits.stomper"), Boolean.valueOf(true));
			Main.server.getConfig().set(String.valueOf("Kits.tankup"), Boolean.valueOf(true));
			Main.server.getConfig().set(String.valueOf("Kits.thor"), Boolean.valueOf(true));
			Main.server.getConfig().set(String.valueOf("Kits.berserker"), Boolean.valueOf(true));
			Main.server.getConfig().set(String.valueOf("Kits.vampiro"), Boolean.valueOf(true));
			Main.server.getConfig().set(String.valueOf("Kits.arrow"), Boolean.valueOf(true));
			Main.server.getConfig().set(String.valueOf("Kits.quickdroper"), Boolean.valueOf(true));
			Main.server.getConfig().set(String.valueOf("Kits.lifeStealer"), Boolean.valueOf(true));
			Main.server.getConfig().set(String.valueOf("Kits.ninja"), Boolean.valueOf(true));
			Main.server.getConfig().set(String.valueOf("Kits.ajnin"), Boolean.valueOf(true));
			Main.server.getConfig().set(String.valueOf("Kits.hulk"), Boolean.valueOf(true));
			Main.server.getConfig().set(String.valueOf("Kits.deshfire"), Boolean.valueOf(true));
			Main.server.getConfig().set(String.valueOf("Kits.neo"), Boolean.valueOf(true));
			Main.server.getConfig().set(String.valueOf("Kits.c4"), Boolean.valueOf(true));
			Main.server.getConfig().set(String.valueOf("Kits.goku"), Boolean.valueOf(true));
			Main.server.getConfig().set(String.valueOf("Kits.gladiator"), Boolean.valueOf(true));
			Main.server.getConfig().set(String.valueOf("Kits.corona"), Boolean.valueOf(true));
			Main.server.getConfig().set(String.valueOf("Kits.anchor"), Boolean.valueOf(true));
			Main.server.getConfig().set(String.valueOf("Kits.phantom"), Boolean.valueOf(true));
			Main.server.getConfig().set(String.valueOf("Kits.ghost"), Boolean.valueOf(true));
			Main.server.getConfig().set(String.valueOf("Kits.avatar"), Boolean.valueOf(true));
			Main.server.getConfig().set(String.valueOf("Kits.frozen"), Boolean.valueOf(true));
			Main.server.getConfig().set(String.valueOf("Kits.endermage"), Boolean.valueOf(true));
			Main.server.getConfig().set(String.valueOf("Kits.pyro"), Boolean.valueOf(true));
			Main.server.save();
		}
	}
}
