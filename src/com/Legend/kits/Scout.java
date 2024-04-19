package com.Legend.kits;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.Legend.kits.manager.Base;
import com.Legend.kits.manager.CooldownAPI;

public class Scout implements Listener {

	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		if (Base.qualKit(p) == "Scout") {
			if (e.getAction().name().contains("RIGHT")) {
				if ((p.getItemInHand().hasItemMeta() && p.getItemInHand().getItemMeta().hasDisplayName())
						&& (e.getPlayer().getItemInHand().getType() == Material.POTION)) {
					e.setCancelled(true);
					if (!(CooldownAPI.SemCooldown(p))) {
						if (!Gladiator.lutando.containsKey(p) && !Gladiator.lutando.containsValue(p)) {
							return;
						}
					}
					if (e.getPlayer().hasPotionEffect(PotionEffectType.SPEED)) {
						e.getPlayer().sendMessage(Base.prefix + "§cVocê já está sobre efeito de uma poção.");
						return;
					}
					CooldownAPI.addCooldown(p, 12);
					CooldownAPI.mCooldown(p, "Scout");
					e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 20 * 5, 1), true);
				}
			}
		}
	}
}
