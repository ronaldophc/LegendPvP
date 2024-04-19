package com.Legend.warps;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import com.Legend.Main;
import com.Legend.kits.manager.Base;

public class setSpawn implements Listener, CommandExecutor {
	  public static Main plugin;
	  
	  public setSpawn(Main main) {
	    plugin = main;
	  }
	  
	  public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
	    if (cmd.getName().equalsIgnoreCase("setspawn") && 
	      sender instanceof Player) { 
	      if (!sender.hasPermission("legendpvp.setwarp")) {
	      } 
	      if (sender.hasPermission("legendpvp.setwarp")) {
	        Player p = (Player)sender;
	        WarpAPI.setLocation(p.getLocation(), "Spawn");
	        p.sendMessage(Base.prefix + "§bSpawn setado com sucesso");
	      } 
	      return true;
	    } 
	    return false;
	  }
	}
