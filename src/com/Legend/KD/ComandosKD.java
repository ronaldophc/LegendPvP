package com.Legend.KD;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import com.Legend.Main;
import com.Legend.RDM.RDMStatus;
import com.Legend.kits.manager.Base;
import com.Legend.umvum.API1;

public class ComandosKD implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if (!(sender instanceof Player)) {

		} else {
			Player p = (Player) sender;
			if (cmd.getName().equalsIgnoreCase("top")) {
				if (args.length == 0) {
					p.sendMessage(Base.prefix + "§bUse §f/Top <kill, rank, dinheiro, ks>§b.");
					return true;
				} else if (args.length == 1) {
					if (args[0].equalsIgnoreCase("kill")) {
						API.topk(p);
					} else if (args[0].equalsIgnoreCase("rank")) {
						API.topp(p);
					} else if (args[0].equalsIgnoreCase("dinheiro")) {
						API.topd(p);
					} else if (args[0].equalsIgnoreCase("ks")) {
						API.topks(p);
					}
				}
			} else if (cmd.getName().equalsIgnoreCase("status")) {
				if (args.length == 0) {
					gui(p, p.getName());
				} else if (args.length == 1) {
					String a = args[0];
					if (Main.file.getConfig().get(a) == null) {
						p.sendMessage(Base.prefix + "§7Esse jogador nunca entrou no servidor.");
						return true;
					}
					if (a.equalsIgnoreCase("mysql")) {

					}
					gui(p, a);
				}
			} else if (cmd.getName().equalsIgnoreCase("setdin")) {
				if (p.hasPermission("legend.din")) {
					if (args.length == 0) {
						p.sendMessage(Base.prefix + "§bUse §f/setdin <player> <quantia>§b.");
						return true;
					} else if (args.length == 1) {
						p.sendMessage(Base.prefix + "§bUse §f/setdin <player> <quantia>§b.");
						return true;
					} else if (args.length == 2) {
						Player target = Bukkit.getServer().getPlayer(args[0]);
						int quantia = Integer.valueOf(args[1]);
						API.addDinheiro(target, quantia);
						p.sendMessage(Base.prefix + "§bVocê setou o §aDinheiro §bdo jogador §c" + target.getName()
								+ " para §c" + quantia + "§b.");
						target.sendMessage(Base.prefix + "§bSeu §aDinheiro §bfoi setado para §c" + quantia + "§b.");
						Main.file.save();
					}
				}
			} else if (cmd.getName().equalsIgnoreCase("ranks")) {
				if (args.length == 0) {
					p.sendMessage("§f------§bRanks Atuais§f------");
					p.sendMessage(Base.prefix + "§bKill §f= + 3 pontos. §bMorte §f= - 1 ponto.");
					p.sendMessage("§e§lεⅠ §e§lBronze I  §b0§f-§b100 §fpontos");
					p.sendMessage("§e§lεⅡ §e§lBronze II  §b100§f-§b199 §fpontos");
					p.sendMessage("§8§lρⅠ §8§lPrata I  §b200§f-§b299 §fpontos");
					p.sendMessage("§8§lρⅡ §8§lPrata II  §b300§f-§b399 §fpontos");
					p.sendMessage("§6§lϑⅠ §lGold I  §b400§f-§b499 §fpontos");
					p.sendMessage("§6§lϑⅡ §6§lGold II  §b500§f-§b599 §fpontos");
					p.sendMessage("§9§lξⅠ §9§lPlatina I  §b600§f-§b699 §fpontos");
					p.sendMessage("§9§lξⅡ §9§lPlatina II  §b700§f-§b799 §fpontos");
					p.sendMessage("§b§lζⅠ §b§lDiamante I  §b800§f-§b899 §fpontos");
					p.sendMessage("§b§lζⅡ §b§lDiamante II  §b900§f-§b999 §fpontos");
					p.sendMessage("§4§lΦ §4§lDuelista  §b1000+ §fpontos");
					p.sendMessage("§7Unranked");
				}
			}
		}
		return false;
	}

	public void gui(Player p, String a) {
		Inventory st = Bukkit.createInventory(p, 27, "§bStatus §c" + a);
		st.setItem(11,
				API.Item(Material.BOOK_AND_QUILL, "§cArena", 1, (byte) 0,
						Arrays.asList(new String[] { "", "§fKills: §b" + (API.getkills(a)),
								"§fMortes: §b" + API.getmortes(a), "§fDinheiro: §b" + API.getdinheiro(a),
								"§fRank: §b" + API.getRank(a) + " §f- §b" + API.getpontos(a) + " §fpontos.",
								"§fTop KS: §b" + Main.file.getConfig().getInt(String.valueOf(a) + ".TopKS") })));
		st.setItem(13, API.Item(Material.BOOK_AND_QUILL, "§c1v1", 1, (byte) 0, Arrays.asList(
				new String[] { " ", "§fKills: §b" + API1.getkills(a), "§fMortes: §b" + API1.getmortes(a), " " })));
		st.setItem(15,
				API.Item(Material.BOOK_AND_QUILL, "§cRDM", 1, (byte) 0,
						Arrays.asList(new String[] { "§fKills: §b" + RDMStatus.getkills(a),
								"§fDerrotas: §b" + RDMStatus.getperdeu(a), "§fWins: §b" + RDMStatus.getwins(a) })));
		p.openInventory(st);
	}
}
