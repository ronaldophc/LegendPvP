package com.Legend.kits;

import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerFishEvent;

import com.Legend.kits.manager.Base;

public class Fisherman implements Listener {

	 @EventHandler
	  public void onPlayerFish(PlayerFishEvent event) {
	    Entity caught = event.getCaught();
	    Block block = event.getHook().getLocation().getBlock();
	    if (caught != null && caught != block && 
	    		Base.temKit(event.getPlayer()) && Base.qualKit(event.getPlayer()) == "Fisherman")
	      caught.teleport(event.getPlayer().getLocation()); 
	  }
}
 