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
import com.Legend.events.PlayerJoin;
import com.Legend.kits.manager.Base;

import net.md_5.bungee.api.ChatColor;

public class newScore {

	public static int a() {
		return Bukkit.getOnlinePlayers().size();
	}

	public static void setScoreboard(Player p) {
		Scoreboard sb = Bukkit.getScoreboardManager().getMainScoreboard();
		Objective obj = sb.getObjective("aaa");
		if (obj == null) {
			obj = sb.registerNewObjective("aaa", "bbb");
		}
		obj.setDisplayName("§c§b§lLegendPvP");
		obj.setDisplaySlot(DisplaySlot.SIDEBAR);
		obj.getScore("§alegendpvp.com.br").setScore(9);
		obj.getScore("§b").setScore(8);
		obj.getScore(updateTeam(sb, "po", "Online: ", "§7" + PlayerJoin.on.size(), ChatColor.RED)).setScore(7);
		// obj.getScore(updateTeam(sb, "Rank", "Rank: ", "§7" + API.getRank(p),
		// ChatColor.YELLOW)).setScore(7);
		obj.getScore("§r").setScore(6);
		obj.getScore(updateTeam(sb, "matou", "Kills: ", "§7" + API.getkills(p), ChatColor.AQUA)).setScore(5);
		obj.getScore(updateTeam(sb, "morreu", "Mortes: ", "§7" + API.getmortes(p), ChatColor.BLACK)).setScore(4);
		obj.getScore(updateTeam(sb, "seq", "KillStreak: ", "§c" + API.getKs(p), ChatColor.BLUE)).setScore(3);
		obj.getScore("§a").setScore(2);
		obj.getScore(updateTeam(sb, "hab", "Kit: ", "§c" + Base.qualaKit(p), ChatColor.DARK_AQUA)).setScore(1);
		obj.getScore("§a /score").setScore(0);
		/*
		 * obj.setDisplayName("§clegendpvp.com.br");
		 * obj.setDisplaySlot(DisplaySlot.SIDEBAR); obj.getScore(updateTeam(sb,
		 * "Online", "● Online: ", "§c" + Score2.on.size(), ChatColor.RED)).setScore(3);
		 * obj.getScore(updateTeam(sb, "KS", "● KillStreak: ", "§c" + API.getKs(p),
		 * ChatColor.YELLOW)).setScore(2); obj.getScore(updateTeam(sb, "Kit", "● Kit: ",
		 * "§c" + Base.qualaKit(p), ChatColor.DARK_AQUA)).setScore(1);
		 * obj.getScore(" §c/score").setScore(0);
		 */
		Team dono = getTeam(sb, "0000Dono", "§4Dono §7| §4", "§0");
		Team dev = getTeam(sb, "0001Dev", "§bDev §7| §b", "§0");
		Team admin = getTeam(sb, "0002Admin", "§cAdmin §7| §c", "§0");
		Team mod = getTeam(sb, "0003Mod", "§5Mod §7| §5", "§0");
		Team helper = getTeam(sb, "0004Helper", "§dHelper §7| §d", "§0");
		Team builder = getTeam(sb, "0005Builder", "§9Builder §7| §9", "§0");
		Team streamer = getTeam(sb, "0006Streamer", "§3Stream §7| §3", "§0");
		Team yt = getTeam(sb, "0007Yt", "§aYT §7| §a", "§0");
		Team vip = getTeam(sb, "0008Vip", "§6Vip §7| §6", "§0");
		Team normal = getTeam(sb, "0009Normal", "§7", "§0");
		for (Player on : Bukkit.getOnlinePlayers()) {
			if (Tag.getTag(on).equalsIgnoreCase("Dono")) {
				dono.addPlayer(on);
			} else if (Tag.getTag(on).equalsIgnoreCase("Dev")) {
				dev.addPlayer(on);
			} else if (Tag.getTag(on).equalsIgnoreCase("Admin")) {
				admin.addPlayer(on);
			} else if (Tag.getTag(on).equalsIgnoreCase("Mod")) {
				mod.addPlayer(on);
			} else if (Tag.getTag(on).equalsIgnoreCase("Helper")) {
				helper.addPlayer(on);
			} else if (Tag.getTag(on).equalsIgnoreCase("Builder")) {
				builder.addPlayer(on);
			} else if (Tag.getTag(on).equalsIgnoreCase("Streamer")) {
				streamer.addPlayer(on);
			} else if (Tag.getTag(on).equalsIgnoreCase("Yt")) {
				yt.addPlayer(on);
			} else if (Tag.getTag(on).equalsIgnoreCase("Vip")) {
				vip.addPlayer(on);
			} else {
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
		/*
		 * obj.getScore(updateTeam(sb, "Online", "● Online: ", "§c" + Score2.on.size(),
		 * ChatColor.RED)).setScore(3); obj.getScore(updateTeam(sb, "KS",
		 * "● KillStreak: ", "§c" + API.getKs(p), ChatColor.YELLOW)).setScore(2);
		 * obj.getScore(updateTeam(sb, "Kit", "● Kit: ", "§c" + Base.qualaKit(p),
		 * ChatColor.DARK_AQUA)).setScore(1);
		 */
		obj.getScore(updateTeam(sb, "po", "Online: ", "§7" + PlayerJoin.on.size(), ChatColor.RED)).setScore(7);
		// obj.getScore(updateTeam(sb, "Rank", "Rank: ", "§7" + API.getRank(p),
		// ChatColor.YELLOW)).setScore(7);
		obj.getScore(updateTeam(sb, "matou", "Kills: ", "§7" + API.getkills(p), ChatColor.AQUA)).setScore(5);
		obj.getScore(updateTeam(sb, "morreu", "Mortes: ", "§7" + API.getmortes(p), ChatColor.BLACK)).setScore(4);
		obj.getScore(updateTeam(sb, "seq", "KillStreak: ", "§c" + API.getKs(p), ChatColor.BLUE)).setScore(3);
		obj.getScore(updateTeam(sb, "hab", "Kit: ", "§c" + Base.qualaKit(p), ChatColor.DARK_AQUA)).setScore(1);
		Team dono = getTeam(sb, "0000Dono", "§4Dono §7| §4", "§0");
		Team dev = getTeam(sb, "0001Dev", "§bDev §7| §b", "§0");
		Team admin = getTeam(sb, "0002Admin", "§cAdmin §7| §c", "§0");
		Team mod = getTeam(sb, "0003Mod", "§5Mod §7| §5", "§0");
		Team helper = getTeam(sb, "0004Helper", "§dHelper §7| §d", "§0");
		Team builder = getTeam(sb, "0005Builder", "§9Builder §7| §9", "§0");
		Team streamer = getTeam(sb, "0006Streamer", "§3Stream §7| §3", "§0");
		Team yt = getTeam(sb, "0007Yt", "§aYT §7| §a", "§0");
		Team vip = getTeam(sb, "0008Vip", "§6Vip §7| §6", "§0");
		Team normal = getTeam(sb, "0009Normal", "§7", "§0");
		for (Player on : Bukkit.getOnlinePlayers()) {
			if (Tag.getTag(on).equalsIgnoreCase("Dono")) {
				dono.addPlayer(on);
			} else if (Tag.getTag(on).equalsIgnoreCase("Dev")) {
				dev.addPlayer(on);
			} else if (Tag.getTag(on).equalsIgnoreCase("Admin")) {
				admin.addPlayer(on);
			} else if (Tag.getTag(on).equalsIgnoreCase("Mod")) {
				mod.addPlayer(on);
			} else if (Tag.getTag(on).equalsIgnoreCase("Helper")) {
				helper.addPlayer(on);
			} else if (Tag.getTag(on).equalsIgnoreCase("Builder")) {
				builder.addPlayer(on);
			} else if (Tag.getTag(on).equalsIgnoreCase("Streamer")) {
				streamer.addPlayer(on);
			} else if (Tag.getTag(on).equalsIgnoreCase("Yt")) {
				yt.addPlayer(on);
			} else if (Tag.getTag(on).equalsIgnoreCase("Vip")) {
				vip.addPlayer(on);
			} else {
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
	public static void removeTeam(Scoreboard sb, String Team) {
		Team team = sb.getTeam(Team);
		if (team == null) {
			return;
		}
		team.setPrefix(null);
		team.setSuffix(null);
		team.unregister();
	}
	public static void starScheduler() {
		new BukkitRunnable() {

			@Override
			public void run() {
				for (Player p : Bukkit.getOnlinePlayers()) {
					updateScoreboard(p);
				}
			}
		}.runTaskTimer(Main.plugin, 20, 20);
	}
}
