package com.Legend.Comandos;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.Legend.kits.manager.Base;

public class Tell implements CommandExecutor {

	public String Mensagem(String[] args) {
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < args.length; i++) {
			sb.append(args[i]).append(" ");
		}
		return sb.toString();
	}

	public static HashMap<Player, Boolean> st = new HashMap<>();

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if (cmd.getName().equalsIgnoreCase("tell")) {
			if (sender instanceof Player) {
				Player p = (Player) sender;
				if (args.length == 0) {
					p.sendMessage(Base.prefix + "§bUse §f/tell <player,off,on> <msg>§b.");
					return true;
				}
				if (args.length == 1) {
					if (args[0].equals("off")) {
						st.put(p, false);
						p.sendMessage(Base.prefix + "Você não está mais recebendo tell.");
					} else if (args[0].equals("on")) {
						st.put(p, true);
						p.sendMessage(Base.prefix + "Você  está recebendo tell.");
					} else {
						p.sendMessage(Base.prefix + "§bUse §f/tell <player> <msg>§b.");
						return true;
					}
				}
				if (args.length >= 2) {
					Player t = Bukkit.getPlayer(args[0]);
					if (t == null) {
						p.sendMessage(Base.prefix + "§7O jogador está offline!");
						return true;
					}
					if (Mute.tamutado(p.getName())) {
						p.sendMessage(Base.prefix + "§c§lVocê está mutado!");
						return true;
					}
					if (Mute.mutas.contains(p.getName())) {
						p.sendMessage(Base.prefix + "§c§lVocê está mutado temporariamente!");
						return true;
					}
					if (st.containsKey(t)) {
						if (st.get(t) == false) {
							p.sendMessage(Base.prefix + "Esse jogador nao está recebendo tell.");
							return true;
						}
					}
					String mensagem = Mensagem(args);
					if (mensagem.contains("com br")) {
						return true;
					}
					if (mensagem.contains(".")) {
						if (!mensagem.contains("legend.pvp.host") && !mensagem.contains("legendpvp.com.br")) {
							if (!(p.hasPermission("legend.chat"))) {
								return true;
							}
						}
					}
					t.sendMessage("§8[§f" + p.getName() + " §c> §fVocê§8] §c-> §7" + mensagem);
					p.sendMessage("§8[§fVocê §c> §f" + t.getName() + "§8] §c-> §7" + mensagem);
				}
			}
		}

		return false;
	}

}
