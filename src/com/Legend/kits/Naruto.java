package com.Legend.kits;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.Legend.kits.manager.Base;
import com.Legend.kits.manager.CooldownAPI;

public class Naruto implements Listener {
	@EventHandler
	public void interact(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		if ((e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK)
				&& (Base.qualKit(p) == "Naruto") && (p.getItemInHand().getType() == Material.NETHER_STAR)) {
			if(p.getLocation().getY() >= 63) {
				return;
			}
			if (!(CooldownAPI.SemCooldown(p))) {
				return;
			}
			p.sendMessage(Base.prefix + "§7Sinto meu corpo Mudando....!!!");
			p.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 4 *20, 0));
			p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED,  4 *20, 0));
			CooldownAPI.addCooldown(p, 10);
			CooldownAPI.mCooldown(p, "Naruto");
			return;
		}
	}
}
