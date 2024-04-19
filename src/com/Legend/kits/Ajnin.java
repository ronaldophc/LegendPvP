package com.Legend.kits;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerToggleSneakEvent;

import com.Legend.kits.manager.Base;
import com.Legend.kits.manager.CooldownAPI;

public class Ajnin implements Listener {

	@EventHandler
	public void a(PlayerToggleSneakEvent e) {
		Player p = e.getPlayer();
		if (Base.qualKit(p) == "Ajnin") {
			if (!(CooldownAPI.SemCooldown(p))) {
				return;
			}
			if (p.getLocation().getY() >= 63) {
				return;
			}
			Player b = Viper.a.get(p);
			if (Viper.a.containsValue(b)) {
				if (Gladiator.lutando.containsKey(b) || Gladiator.lutando.containsValue(b)) {
					p.sendMessage(Base.prefix + "§7Não pode ser usado em uma pessoa dentro do Gladiator!");
					return;
				}
				if (Gladiator.lutando.containsKey(p) || Gladiator.lutando.containsValue(p)) {
					if (!Gladiator.lutando.containsKey(b) && !Gladiator.lutando.containsValue(b)) {
						p.sendMessage(Base.prefix + "§7Não pode ser usado dentro do Gladiator!");
						return;
					}
				}
				b.teleport(p);
				CooldownAPI.addCooldown(p, 5);
				CooldownAPI.mCooldown(p, "Ajnin");
			} else {

			}
		}
	}
}
