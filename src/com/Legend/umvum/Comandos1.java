package com.Legend.umvum;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.Legend.Main;
import com.Legend.kits.manager.Base;
import com.Legend.warps.WarpAPI;

public class Comandos1 extends API1 implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if (!(sender instanceof Player)) {
			return true;
		}
		Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("1v1")) {
			if (Base.temKit(p) == true) {
				p.sendMessage(Base.prefix + "§dVocê não pode entrar na §51v1 §fcom §cKit§f! Use §a/Spawn§d.");
				return true;
			}
			if (Main.x1.getConfig().getString(String.valueOf(p.getName()) + ".UUID") == null) {
				Main.x1.getConfig().set(String.valueOf(p.getName()) + ".UUID", p.getUniqueId().toString());
				Main.x1.getConfig().set(String.valueOf(p.getName()) + ".Kills", Integer.valueOf(0));
				Main.x1.getConfig().set(String.valueOf(p.getName()) + ".Mortes", Integer.valueOf(0));
				Main.x1.save();
			}
			p.sendMessage(Base.prefix + "§dVocê entrou na §51v1§d.");
			API1.setarItens(p);
			Base.setarKit(p, "1v1");
		//	Score2.createScoreboard(p);
			p.teleport(WarpAPI.getLocation("1v1.lobby"));
		}
		if (cmd.getName().equalsIgnoreCase("set1v1")) {
			if (p.hasPermission("legend.1v1")) {
				if (args.length == 0) {
					p.sendMessage(Base.prefix + "§dUse §5/set1v1 <lobby,pos1,pos2>§d.");
					return true;
				}
				if (args.length == 1) {
					if (args[0].equalsIgnoreCase("lobby")) {
						WarpAPI.setLocation(p.getLocation(), "1v1.lobby");
						p.sendMessage(Base.prefix + "§dVocê setou o §5Lobby §dda §51v1§d.");
					}
					if (args[0].equalsIgnoreCase("pos1")) {
						WarpAPI.setLocation(p.getLocation(), "1v1.pos1");
						p.sendMessage(Base.prefix + "§dVocê setou a §5Pos1 §dda §51v1§d.");
					}
					if (args[0].equalsIgnoreCase("pos2")) {
						WarpAPI.setLocation(p.getLocation(), "1v1.pos2");
						p.sendMessage(Base.prefix + "§dVocê setou a §5Pos2 §dda §51v1§d.");
					}
				}
			}
		}
		return false;
	}

}
