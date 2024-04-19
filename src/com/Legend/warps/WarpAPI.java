package com.Legend.warps;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;

import com.Legend.Main;


public class WarpAPI {

	
	public static void setLocation(Location l, String name) {
		Main.Warps.getConfig().set(name + ".X", l.getX());
		Main.Warps.getConfig().set(name + ".Y", l.getY());
		Main.Warps.getConfig().set(name + ".Z", l.getZ());
		Main.Warps.getConfig().set(name + ".Pitch", l.getPitch());
		Main.Warps.getConfig().set(name + ".Yaw", l.getYaw());
		Main.Warps.getConfig().set(name + ".World", l.getWorld().getName());
		Main.Warps.save();
	} 
	public static Location getLocation(String name) {
		World w = Bukkit.getWorld(Main.Warps.getConfig().getString(name + ".World"));
		double x = Main.Warps.getConfig().getDouble(name + ".X");
		double y = Main.Warps.getConfig().getDouble(name + ".Y");
		double z = Main.Warps.getConfig().getDouble(name + ".Z");
		double yaw = Main.Warps.getConfig().getDouble(name + ".Yaw");
		double pitch = Main.Warps.getConfig().getDouble(name + ".Pitch");
		Location l = new Location(w, x, y, z);
		l.setYaw((float)yaw);
		l.setPitch((float)pitch);
		return l;
	}
}
