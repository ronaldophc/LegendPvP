package com.Legend.kits;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import com.Legend.kits.manager.Base;
import com.Legend.kits.manager.CooldownAPI;

public class Ninja implements Listener {
	@EventHandler
	public void a(PlayerToggleSneakEvent e) {
		Player p = e.getPlayer();
		if (Base.qualKit(p) == "Ninja") {
			if (!(CooldownAPI.SemCooldown(p))) {
				return;
			}
			Player b = Viper.b.get(p);
			if (Viper.b.containsValue(b)) {
				if(p.getLocation().getY() >= 63) {
					return;
				}
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
				p.teleport(b);
				CooldownAPI.addCooldown(p, 5);
				CooldownAPI.mCooldown(p, "Ninja");
			} else {

			}
		}
	}
}