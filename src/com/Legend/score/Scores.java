package com.Legend.score;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

import com.Legend.Comandos.Score;
import com.Legend.KD.API;
import com.Legend.RDM.RDMStatus;
import com.Legend.kits.manager.Base;
import com.Legend.umvum.API1;

public class Scores{

	public static void createScoreboard(Player p) {
		if (Base.qualKit(p) == "1v1") {
			ScoreboardManager manager = Bukkit.getScoreboardManager();
			Scoreboard board = manager.getNewScoreboard();
			Objective objective = board.registerNewObjective("Stats", "dummy");
			objective.setDisplayName("§6§l1v1");
			objective.setDisplaySlot(DisplaySlot.SIDEBAR);
			objective.getScore("§alegendpvp.com.br").setScore(6);
			objective.getScore("§b").setScore(5);
			objective.getScore("§fWinStreak:§7 " + API1.getKs(p)).setScore(4);
			objective.getScore("§fKills:§7 " + API1.getkills(p)).setScore(3);
			objective.getScore("§fMortes:§7 " + API1.getmortes(p)).setScore(2);
			objective.getScore("§a").setScore(1);
			p.setScoreboard(board);
		} else if (Base.qualKit(p) == "RDM") {
			ScoreboardManager manager = Bukkit.getScoreboardManager();
			Scoreboard board = manager.getNewScoreboard();
			Objective objective = board.registerNewObjective("Stats", "dummy");
			objective.setDisplayName("§4§lRDM");
			objective.setDisplaySlot(DisplaySlot.SIDEBAR);
			objective.getScore("§alegendpvp.com.br").setScore(6);
			objective.getScore("§b").setScore(5);
			objective.getScore("§fKills:§7 " + RDMStatus.getkills(p)).setScore(4);
			objective.getScore("§fDerrotas:§7 " + RDMStatus.getperdeu(p)).setScore(3);
			objective.getScore("§fWins:§7 " + RDMStatus.getwins(p)).setScore(2);
			objective.getScore("§a").setScore(1);
			p.setScoreboard(board);
		} else {
			if (Score.getvar(p) == true) {
				ScoreboardManager manager = Bukkit.getScoreboardManager();
				Scoreboard board = manager.getNewScoreboard();
				Objective objective = board.registerNewObjective("Stats", "dummy");
				objective.setDisplayName("§clegendpvp.com.br");
				objective.setDisplaySlot(DisplaySlot.SIDEBAR);
				objective.getScore("§f Online: §c" + Bukkit.getOnlinePlayers().size()).setScore(3);
				objective.getScore("§f KillStreak: §c" + API.getKs(p)).setScore(2);
				objective.getScore("§f Kit: §c" + Base.qualKit(p)).setScore(1);
				objective.getScore(" §c/score").setScore(0);
				p.setScoreboard(board);
			} else if (Score.getvar(p) == false) {
				ScoreboardManager manager = Bukkit.getScoreboardManager();
				Scoreboard board = manager.getNewScoreboard();
				Objective objective = board.registerNewObjective("Stats", "dummy");
				objective.setDisplayName("§b§lLegendPvP");
				objective.setDisplaySlot(DisplaySlot.SIDEBAR);
				objective.getScore("§alegendpvp.com.br").setScore(11);
				objective.getScore("§b").setScore(10);
				objective.getScore("§fOnline:§7 " + Bukkit.getOnlinePlayers().size()).setScore(9);
				objective.getScore("§fDinheiro: §aR$ §7" + API.getdinheiro(p)).setScore(8);
				objective.getScore("§fRank:§7 " + API.getRank(p)).setScore(7);
				objective.getScore("§r").setScore(6);
				objective.getScore("§fKills:§7 " + API.getkills(p)).setScore(5);
				objective.getScore("§fMortes:§7 " + API.getmortes(p)).setScore(4);
				objective.getScore("§fKillStreak: §7" + API.getKs(p)).setScore(3);
				objective.getScore("§a").setScore(2);
				objective.getScore("§fKit: §7" + Base.qualKit(p)).setScore(1);
				objective.getScore("§a /score").setScore(0);
				p.setScoreboard(board);
			}
		}

	}

}
