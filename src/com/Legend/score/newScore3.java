package com.Legend.score;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

import com.Legend.Main;
import com.Legend.Comandos.Tag;
import com.Legend.KD.API;
import com.Legend.RDM.RDMStatus;
import com.Legend.events.PlayerJoin;
import com.Legend.kits.manager.Base;
import com.Legend.umvum.API1;

import net.md_5.bungee.api.ChatColor;

public class newScore3 {

	public static void setScoreboard(Player p) {
		Scoreboard sb = Bukkit.getScoreboardManager().getNewScoreboard();
		Objective obj = sb.getObjective("aaa");
		if (obj == null) {
			obj = sb.registerNewObjective("aaa", "bbb");
		}
		if (Base.qualKit(p) == "1v1") {
			obj.setDisplayName("§clegendpvp.com.br");
			obj.setDisplaySlot(DisplaySlot.SIDEBAR);
			obj.getScore(updateTeam(sb, "3", " ", "       §6§l1v1", ChatColor.RED)).setScore(3);
			obj.getScore(updateTeam(sb, "2", "● WinStreak: ", "§c" + API1.getKs(p), ChatColor.YELLOW)).setScore(2);
			obj.getScore(updateTeam(sb, "1", "● Mortes: ", "§c" + API1.getmortes(p), ChatColor.BLACK)).setScore(1);
			obj.getScore(updateTeam(sb, "0", "● Kills: ", "§c" + API1.getkills(p), ChatColor.AQUA)).setScore(0);
		} else if (Base.qualKit(p) == "RDM") {
			obj.setDisplayName("§clegendpvp.com.br");
			obj.setDisplaySlot(DisplaySlot.SIDEBAR);
			obj.getScore(updateTeam(sb, "3", " ", "       §4§lRDM", ChatColor.RED)).setScore(3);
			obj.getScore(updateTeam(sb, "2", "● Wins: ", "§c" + RDMStatus.getkills(p), ChatColor.YELLOW)).setScore(2);
			obj.getScore(updateTeam(sb, "1", "● Derrotas: ", "§c" + RDMStatus.getperdeu(p), ChatColor.BLACK))
					.setScore(1);
			obj.getScore(updateTeam(sb, "0", "● Kills: ", "§c" + RDMStatus.getkills(p), ChatColor.AQUA)).setScore(0);
		} else {
			obj.setDisplayName("§clegendpvp.com.br");
			obj.setDisplaySlot(DisplaySlot.SIDEBAR);
			obj.getScore(updateTeam(sb, "3", "● Online: ", "§c" + PlayerJoin.on.size(), ChatColor.RED)).setScore(3);
			obj.getScore(updateTeam(sb, "2", "● KillStreak: ", "§c" + API.getKs(p), ChatColor.YELLOW)).setScore(2);
			obj.getScore(updateTeam(sb, "1", "● Kit: ", "§c" + Base.qualaKit(p), ChatColor.BLACK)).setScore(1);
			obj.getScore(updateTeam(sb, "0", " §c/status", "", ChatColor.AQUA)).setScore(0);
		}
		Team dono = getTeam(sb, "0000Dono", "§4Dono §7| §4", "§5");
		Team dev = getTeam(sb, "0001Dev", "§bDev §7| §b", "§5");
		Team admin = getTeam(sb, "0002Admin", "§cAdmin §7| §c", "§5");
		Team mod = getTeam(sb, "0003Mod", "§5Mod §7| §5", "§5");
		Team helper = getTeam(sb, "0004Helper", "§dHelper §7| §d", "§5");
		Team beta = getTeam(sb, "0005Beta", "§2BETA §7| §2", "§5");
		Team builder = getTeam(sb, "0006Builder", "§9Builder §7| §9", "§5");
		Team streamer = getTeam(sb, "0007Streamer", "§3Stream §7| §3", "§5");
		Team yt = getTeam(sb, "0008Yt", "§aYT §7| §a", "§5");
		Team vip = getTeam(sb, "0009Vip", "§6Vip §7| §6", "§5");
		Team normal = getTeam(sb, "0010Normal", "§7", "§5");
		for (Player on : Bukkit.getOnlinePlayers()) {
			if (Tag.getTag(on).equals("Dono")) {
				if (!(dono.hasPlayer(on)))
					dono.addPlayer(on);
			} else if (Tag.getTag(on).equals("Dev")) {
				if (!(dev.hasPlayer(on)))
					dev.addPlayer(on);
			} else if (Tag.getTag(on).equals("Admin")) {
				if (!(admin.hasPlayer(on)))
					admin.addPlayer(on);
			} else if (Tag.getTag(on).equalsIgnoreCase("Mod")) {
				if (!(mod.hasPlayer(on)))
					mod.addPlayer(on);
			} else if (Tag.getTag(on).equalsIgnoreCase("Helper")) {
				if (!(helper.hasPlayer(on)))
					helper.addPlayer(on);
			} else if (Tag.getTag(on).equalsIgnoreCase("Beta")) {
				if (!(beta.hasPlayer(on)))
					beta.addPlayer(on);
			} else if (Tag.getTag(on).equalsIgnoreCase("Builder")) {
				if (!(builder.hasPlayer(on)))
					builder.addPlayer(on);
			} else if (Tag.getTag(on).equalsIgnoreCase("Streamer")) {
				if (!(streamer.hasPlayer(on)))
					streamer.addPlayer(on);
			} else if (Tag.getTag(on).equalsIgnoreCase("Yt")) {
				if (!(yt.hasPlayer(on)))
					yt.addPlayer(on);
			} else if (Tag.getTag(on).equalsIgnoreCase("Vip")) {
				if (!(vip.hasPlayer(on)))
					vip.addPlayer(on);
			} else {
				if (!(normal.hasPlayer(on)))
					normal.addPlayer(on);
			}
		}
		p.setScoreboard(sb);
	}

	public static void updateScoreboard(Player p) {
		if (p.getScoreboard() == null) {
			setScoreboard(p);
		}
		Scoreboard sb = p.getScoreboard();
		Objective obj = sb.getObjective("aaa");
		if (obj == null) {
			obj = sb.registerNewObjective("aaa", "bbb");
		}
		if (Base.qualKit(p) == "1v1") {
			obj.setDisplayName("§clegendpvp.com.br");
			obj.setDisplaySlot(DisplaySlot.SIDEBAR);
			obj.getScore(updateTeam(sb, "3", " ", "       §6§l1v1", ChatColor.RED)).setScore(3);
			obj.getScore(updateTeam(sb, "2", "● WinStreak: ", "§c" + API1.getKs(p), ChatColor.YELLOW)).setScore(2);
			obj.getScore(updateTeam(sb, "1", "● Mortes: ", "§c" + API1.getmortes(p), ChatColor.BLACK)).setScore(1);
			obj.getScore(updateTeam(sb, "0", "● Kills: ", "§c" + API1.getkills(p), ChatColor.AQUA)).setScore(0);
		} else if (Base.qualKit(p) == "RDM") {
			obj.setDisplayName("§clegendpvp.com.br");
			obj.setDisplaySlot(DisplaySlot.SIDEBAR);
			obj.getScore(updateTeam(sb, "3", " ", "       §4§lRDM", ChatColor.RED)).setScore(3);
			obj.getScore(updateTeam(sb, "2", "● Wins: ", "§c" + RDMStatus.getkills(p), ChatColor.YELLOW)).setScore(2);
			obj.getScore(updateTeam(sb, "1", "● Derrotas: ", "§c" + RDMStatus.getperdeu(p), ChatColor.BLACK))
					.setScore(1);
			obj.getScore(updateTeam(sb, "0", "● Kills: ", "§c" + RDMStatus.getkills(p), ChatColor.AQUA)).setScore(0);
		} else {
			obj.setDisplayName("§clegendpvp.com.br");
			obj.setDisplaySlot(DisplaySlot.SIDEBAR);
			obj.getScore(updateTeam(sb, "3", "● Online: ", "§c" + PlayerJoin.on.size(), ChatColor.RED)).setScore(3);
			obj.getScore(updateTeam(sb, "2", "● KillStreak: ", "§c" + API.getKs(p), ChatColor.YELLOW)).setScore(2);
			obj.getScore(updateTeam(sb, "1", "● Kit: ", "§c" + Base.qualaKit(p), ChatColor.BLACK)).setScore(1);
			obj.getScore(updateTeam(sb, "0", " §c/status", "", ChatColor.AQUA)).setScore(0);
		}
		Team dono = getTeam(sb, "0000Dono", "§4Dono §7| §4", "§5");
		Team dev = getTeam(sb, "0001Dev", "§bDev §7| §b", "§5");
		Team admin = getTeam(sb, "0002Admin", "§cAdmin §7| §c", "§5");
		Team mod = getTeam(sb, "0003Mod", "§5Mod §7| §5", "§5");
		Team helper = getTeam(sb, "0004Helper", "§dHelper §7| §d", "§5");
		Team beta = getTeam(sb, "0005Beta", "§2BETA §7| §2", "§5");
		Team builder = getTeam(sb, "0006Builder", "§9Builder §7| §9", "§5");
		Team streamer = getTeam(sb, "0007Streamer", "§3Stream §7| §3", "§5");
		Team yt = getTeam(sb, "0008Yt", "§aYT §7| §a", "§5");
		Team vip = getTeam(sb, "0009Vip", "§6Vip §7| §6", "§5");
		Team normal = getTeam(sb, "0010Normal", "§7", "§5");
		for (Player on : Bukkit.getOnlinePlayers()) {
			if (Tag.getTag(on).equals("Dono")) {
				if (!(dono.hasPlayer(on)))
					dono.addPlayer(on);
			} else if (Tag.getTag(on).equals("Dev")) {
				if (!(dev.hasPlayer(on)))
					dev.addPlayer(on);
			} else if (Tag.getTag(on).equals("Admin")) {
				if (!(admin.hasPlayer(on)))
					admin.addPlayer(on);
			} else if (Tag.getTag(on).equalsIgnoreCase("Mod")) {
				if (!(mod.hasPlayer(on)))
					mod.addPlayer(on);
			} else if (Tag.getTag(on).equalsIgnoreCase("Helper")) {
				if (!(helper.hasPlayer(on)))
					helper.addPlayer(on);
			} else if (Tag.getTag(on).equalsIgnoreCase("Beta")) {
				if (!(beta.hasPlayer(on)))
					beta.addPlayer(on);
			} else if (Tag.getTag(on).equalsIgnoreCase("Builder")) {
				if (!(builder.hasPlayer(on)))
					builder.addPlayer(on);
			} else if (Tag.getTag(on).equalsIgnoreCase("Streamer")) {
				if (!(streamer.hasPlayer(on)))
					streamer.addPlayer(on);
			} else if (Tag.getTag(on).equalsIgnoreCase("Yt")) {
				if (!(yt.hasPlayer(on)))
					yt.addPlayer(on);
			} else if (Tag.getTag(on).equalsIgnoreCase("Vip")) {
				if (!(vip.hasPlayer(on)))
					vip.addPlayer(on);
			} else {
				if (!(normal.hasPlayer(on)))
					normal.addPlayer(on);
			}
		}
	}

	public static Team getTeam(Scoreboard sb, String Team, String prefix, String suffix) {
		Team team = sb.getTeam(Team);
		if (team == null) {
			team = sb.registerNewTeam(Team);
		}
		team.setPrefix(prefix);
		team.setSuffix(suffix);
		team.setAllowFriendlyFire(true);
		team.setCanSeeFriendlyInvisibles(false);
		return team;
	}

	public static String updateTeam(Scoreboard sb, String Team, String prefix, String suffix, ChatColor entry) {
		Team team = sb.getTeam(Team);
		if (team == null) {
			team = sb.registerNewTeam(Team);
		}
		team.setPrefix(prefix);
		team.setSuffix(suffix);
		team.addEntry(entry.toString());
		return entry.toString();
	}

	public static void starScheduler() {
		new BukkitRunnable() {

			@Override
			public void run() {
				for (Player p : Bukkit.getOnlinePlayers())
					updateScoreboard(p);

			}
		}.runTaskTimer(Main.getInstance(), 20, 20);
	}
}
