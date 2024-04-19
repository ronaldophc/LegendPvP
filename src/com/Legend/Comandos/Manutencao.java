package com.Legend.Comandos;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.Legend.Main;
import com.Legend.kits.manager.Base;

public class Manutencao implements CommandExecutor {

	public static List<String> nalista = new ArrayList<>();
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if (cmd.getName().equalsIgnoreCase("manutencao")) {
			if (sender.hasPermission("legend.manutencao")) {
				if (args.length == 0) {
					sender.sendMessage(Base.prefix + "�bUse �f/Manutencao <on,off>�b.");
				} else if (args.length == 1) {
					if(args[0].equalsIgnoreCase("on")) {
						nalista.add("RonaldoPHC");
						nalista.add("SKnockT");
						nalista.add("Reset");
						nalista.add("DeusMeLivre");
						setManu(true);
						for(Player p : Bukkit.getOnlinePlayers()) {
							if(!(p.hasPermission("legend.manutencao"))) {
								p.kickPlayer("�bLegendPvP\n" + "�cServidor est� em manuten��o \n�aPara acompanhar entre em nosso Discord! \n�fdiscord.gg/WPEh5UGSh2");
							}
						}
						Bukkit.broadcastMessage(Base.prefix + "�c�lO SERVER ENTROU EM MANUTEN��O");
					} else if(args[0].equalsIgnoreCase("off")) {
						setManu(false);
						Bukkit.broadcastMessage(Base.prefix + "�c�lO SERVER SAIU DA MANUTEN��O");
					}
				}
			}
		}

		return false;
	}

	public static boolean getManu() {
		 if (Main.server.getConfig().getBoolean(String.valueOf("Manuten��o")) == true) {
			return true;
		}
		 return false;
	}

	public static void setManu(boolean a) {
		Main.server.getConfig().set(String.valueOf("Manuten��o"), a);
		Main.server.save();
	}
}
