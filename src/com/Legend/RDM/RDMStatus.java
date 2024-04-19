package com.Legend.RDM;

import org.bukkit.entity.Player;

import com.Legend.Main;

public class RDMStatus {

	public static int getkills(Player p) {
		return Main.rdm.getConfig().getInt(String.valueOf(p.getName()) + ".Kills");
	}
	
	public static int getkills(String p) {
		return Main.rdm.getConfig().getInt(String.valueOf(p) + ".Kills");
	}

	public static void setkills(Player p) {
		Main.rdm.getConfig().set(String.valueOf(p.getName()) + ".Kills", Integer.valueOf(getkills(p) + 1));
		Main.rdm.save();
	}

	public static int getperdeu(Player p) {
		return Main.rdm.getConfig().getInt(String.valueOf(p.getName()) + ".Perdeu");
	}
	
	public static int getperdeu(String p) {
		return Main.rdm.getConfig().getInt(String.valueOf(p) + ".Perdeu");
	}

	public static void setperdeu(Player p) {
		Main.rdm.getConfig().set(String.valueOf(p.getName()) + ".Perdeu", Integer.valueOf(getperdeu(p) + 1));
		Main.rdm.save();
	}

	public static void setwins(Player p) {
		Main.rdm.getConfig().set(String.valueOf(p.getName()) + ".Wins", Integer.valueOf(getwins(p) + 1));
		Main.rdm.save();
	}

	public static int getwins(Player p) {
		return Main.rdm.getConfig().getInt(String.valueOf(p.getName()) + ".Wins");
	}
	public static int getwins(String p) {
		return Main.rdm.getConfig().getInt(String.valueOf(p) + ".Wins");
	}

}
