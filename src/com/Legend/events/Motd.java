package com.Legend.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;

import com.Legend.Comandos.Manuten��o;

public class Motd implements Listener {

	@EventHandler
	public void onMotd(ServerListPingEvent e) {
		 if (Manuten��o.getManu() == true) {
			e.setMaxPlayers(60);
			e.setMotd("    �b�lLegendPvP �f�l >> �c�lSITE ON\n       �a�lLegendPvP.com.br");
		} else {
			e.setMaxPlayers(60);
			e.setMotd("    �b�lLegendPvP �f�l >> �c�lSITE ON\n       �a�lLegendPvP.com.br");
		}
	}
}
