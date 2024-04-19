package com.Legend.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;

import com.Legend.kits.manager.Base;
import com.Legend.warps.WarpAPI;

public class PlayerRespawn implements Listener {

	@EventHandler
	public void respawn(PlayerRespawnEvent e) {
		Player p = e.getPlayer();
		p.setFireTicks(0);
		Base.tirarKit(p);
		p.teleport(WarpAPI.getLocation("Spawn"));
		p.getInventory().setArmorContents(null);
		p.getInventory().clear();
		p.setFireTicks(0);
	}
}
