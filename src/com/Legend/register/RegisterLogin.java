package com.Legend.register;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.Legend.guis.Title;
import com.Legend.kits.manager.Base;

public class RegisterLogin implements CommandExecutor {

	public static List<String> vezes = new ArrayList<>();

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if (!(sender instanceof Player)) {
			return true;
		}
		Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("login")) {
			if (APIr.logado.contains(p.getName())) {
				p.sendMessage(Base.prefix + "§fVocê já esta logado.");
			} else if (!(APIr.jaregistrou(p.getName()))) {
				p.sendMessage(Base.prefix + "§fVocê precisa se registrar antes.");
			} else if (args.length == 0) {
				p.sendMessage(Base.prefix + "§fUse §a/Login <senha>§f.");
			} else if (args.length == 1) {
				String senha = args[0];
				if (APIr.getSenha(p.getName()).equals(senha)) {
					APIr.logado.add(p.getName());
					Bukkit.broadcastMessage("§f[§c+§f] §c>> §f" + p.getName() + "§b.");
					p.sendMessage(Base.prefix + "§fVocê logou com sucesso!");
					Title.sendActionBar(p, "§6Seja Bem-Vindo ao §bLegendPvP§6!");
				} else {
					if (vezes.contains(p.getName())) {
						p.kickPlayer("§b§lLegendPvP\n §fVocê excedeu o maximo de tentativas e foi kickado");
						vezes.remove(p.getName());
					} else {
						p.sendMessage(Base.prefix + "§fVocê errou a senha e tem mais 1 tentativa.");
						vezes.add(p.getName());
					}
				}
			}
		}
		if (cmd.getName().equalsIgnoreCase("register")) {
			if (APIr.jaregistrou(p.getName())) {
				p.sendMessage(Base.prefix + "§fVocê já se registrou antes.");
				return true;
			} else if (args.length == 0) {
				p.sendMessage(Base.prefix + "§fUse §a/Register <senha> <senha>§f.");
				return true;
			} else if (args.length == 1) {
				p.sendMessage(Base.prefix + "§fUse §a/Register <senha> <senha>§f.");
				return true;
			} else if (args.length == 2) {
				String senha1 = args[0];
				String senha2 = args[1];
				if (senha1.equals(senha2)) {
					APIr.registrar(p.getName(), senha2);
					APIr.logado.add(p.getName());
					p.sendMessage(Base.prefix + "§fVocê se registrou com sucesso!");
					Bukkit.broadcastMessage("§f[§c+§f] §c>> §b§l" + p.getName() + "§b.");
				} else {
					p.sendMessage(Base.prefix + "§fSuas senhas não coincidem.");
				}

			}
		}
		if (cmd.getName().equalsIgnoreCase("trocarsenha")) {
			if (!(APIr.logado.contains(p.getName()))) {
				p.sendMessage(Base.prefix + "§fVocê precisa logar antes.");
			} else if (!(APIr.jaregistrou(p.getName()))) {
				p.sendMessage(Base.prefix + "§fVocê precisa se registrar antes.");
			} else if (args.length == 0) {
				p.sendMessage(Base.prefix + "§fUse §a/trocarsenha <senhaatual> <senhanova>§f.");
			} else if (args.length == 1) {
				p.sendMessage(Base.prefix + "§fUse §a/trocarsenha <senhaatual> <senhanova>§f.");
			} else if (args.length == 2) {
				String senha1 = args[0];
				String senha2 = args[1];
				if (!(senha1.equals(APIr.getSenha(p.getName())))) {
					p.sendMessage(Base.prefix + "§fSua Senha atual está errada!");
					return true;
				}
				APIr.registrar(p.getName(), senha2);
				p.sendMessage(Base.prefix + "§fSua Senha foi alterada!");
				return true;
			}
		}
		return false;
	}

}
