package com.Legend.Comandos;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.Legend.Main;
import com.Legend.kits.manager.Base;

public class Score implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if (!(sender instanceof Player)) {
			return true;
		}
		if (cmd.getName().equalsIgnoreCase("score")) {
			Player p = (Player) sender;
			if (getvar(p) == true) {
				setarvar(p, false);
				p.sendMessage(Base.prefix + "§fVocê mudou o estilo da §bScoreBoard§f.");
			} else if (getvar(p) == false) {
				setarvar(p, true);
				p.sendMessage(Base.prefix + "§fVocê mudou o estilo da §bScoreBoard§f.");
			}
		}

		return false;
	}

	public static void setarvar(Player p, Boolean a) {
		Main.file.getConfig().set(String.valueOf(p.getName()) + ".Score", Boolean.valueOf(a));
		Main.file.save();
	}

	public static boolean getvar(Player p) {
		return Main.file.getConfig().getBoolean(String.valueOf(p.getName()) + ".Score");
	}
}
