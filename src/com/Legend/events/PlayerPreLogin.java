package com.Legend.events;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerPreLoginEvent;

import com.Legend.Comandos.Manutenção;

@SuppressWarnings("deprecation")
public class PlayerPreLogin implements Listener {
	@EventHandler
	public void SamesNicks(PlayerPreLoginEvent e) {
		String name = e.getName();
		if (Manutenção.getManu() == true) {
			if (!(Manutenção.nalista.contains(name))) {
				e.disallow(org.bukkit.event.player.PlayerPreLoginEvent.Result.KICK_OTHER, "§bLegendPvP\n"
						+ "§cServidor está em manutenção \n§aPara acompanhar entre em nosso Discord! \n§fdiscord.gg/WPEh5UGSh2");
			}
			return;
		}
		for (Player on : Bukkit.getOnlinePlayers()) {
			if (on.getName().equals(name)) {
				e.disallow(org.bukkit.event.player.PlayerPreLoginEvent.Result.KICK_OTHER,
						"§bLegendPvP\n" + "§cJá existe um player logado no servidor com o nick de '§f" + name + "§b'");
				return;
			}
		}
	}
}
