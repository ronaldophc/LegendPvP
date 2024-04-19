package com.Legend.warps;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import com.Legend.Main;
import com.Legend.kits.manager.Base;

public class setLava implements Listener, CommandExecutor {
	  public static Main plugin;
	  
	  public setLava(Main main) {
	    plugin = main;
	  }
	  
	  public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
	    if (cmd.getName().equalsIgnoreCase("setlava") && 
	      sender instanceof Player) { 
	      if (!sender.hasPermission("legendpvp.setwarp")) {
	      } 
	      if (sender.hasPermission("legendpvp.setwarp")) {
	        Player p = (Player)sender;
	        WarpAPI.setLocation(p.getLocation(), "Lava");
	        p.sendMessage(Base.prefix + "§bLava Challenge setada com sucesso");
	      } 
	      return true;
	    } 
	    return false;
	  }
	}
