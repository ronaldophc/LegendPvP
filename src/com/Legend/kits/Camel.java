package com.Legend.kits;

import org.bukkit.Material;
import org.bukkit.block.BlockFace;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.Legend.kits.manager.Base;

public class Camel implements Listener {

	@EventHandler
	public static void efeito(PlayerMoveEvent e) {
		if ((e.getTo().getBlock().getRelative(BlockFace.DOWN).getType() == Material.SAND
				|| e.getTo().getBlock().getRelative(BlockFace.DOWN).getType() == Material.SANDSTONE)) {
			if (Base.qualKit(e.getPlayer()) == "Camel") { 
				e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 120, 0));
			}
		}
	}

}
