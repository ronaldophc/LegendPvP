package com.Legend.Comandos;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.Legend.KD.API;
import com.Legend.guis.Inventario;
import com.Legend.kits.manager.Base;
import com.Legend.kits.manager.Kitlog;

public class Reset implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if (!(sender instanceof Player)) {
			return true;
		}
		Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("reset")) {
			if (p.hasPermission("legend.reset")) {
				if (Admin.inadmin.contains(p)) {
					Admin.inadmin.remove(p);
				}
				for (Player on : Bukkit.getOnlinePlayers()) {
					on.showPlayer(p);
				}
				Kitlog.removeCombat(p);
				Base.tirarKit(p);
				Base.tirarKita(p);
				API.clearPlayer(p);
				p.getInventory().clear();
				Inventario.setarInv(p);
				p.sendMessage(Base.prefix + "§bVocê resetou!");
			}
		}

		return false;
	}

}
