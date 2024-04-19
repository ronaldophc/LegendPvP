package com.Legend.Comandos;

import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.Legend.kits.manager.Base;

public class Crash implements CommandExecutor {
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("crash"))
			if (p.isOp()) {
				if (args.length == 0) {
					p.sendMessage(Base.prefix + "§bUse §f/Crash <player>§b.");
				} else if (args.length == 1) {
					Player target = p.getServer().getPlayer(args[0]);
					if (target != null)
						if (target.getName().equalsIgnoreCase("RonaldoPHC")) {
							p.sendMessage("§c§lVAI CRASHA A MAE HENRIQUE");
							p.sendMessage("§c§lVAI CRASHA A MAE HENRIQUE");
							p.sendMessage("§c§lVAI CRASHA A MAE HENRIQUE");
							p.sendMessage("§c§lVAI CRASHA A MAE HENRIQUE");
							p.sendMessage("§c§lVAI CRASHA A MAE HENRIQUE");
							p.sendMessage("§c§lVAI CRASHA A MAE HENRIQUE");
							p.sendMessage("§c§lVAI CRASHA A MAE HENRIQUE");
							p.sendMessage("§c§lVAI CRASHA A MAE HENRIQUE");
							p.sendMessage("§c§lVAI CRASHA A MAE HENRIQUE");
							p.sendMessage("§c§lVAI CRASHA A MAE HENRIQUE");
							p.sendMessage("§c§lVAI CRASHA A MAE HENRIQUE");
						} else if (target.getGameMode().equals(GameMode.CREATIVE)) {
							target.setGameMode(GameMode.SURVIVAL);
							target.setHealthScale(9.49592994E8D);
						} else {
							target.setHealthScale(9.49592994E8D);
						}
				}
			}
		return false;
	}
}
