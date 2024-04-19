package com.Legend.events;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scheduler.BukkitRunnable;
import org.inventivetalent.bossbar.BossBarAPI;

import com.Legend.Main;
import com.Legend.Comandos.Admin;
import com.Legend.Comandos.Builder;
import com.Legend.kits.manager.Base;
import com.Legend.register.APIr;
import com.Legend.register.RegisterLogin;
import com.Legend.score.newScore3;
import com.Legend.warps.Spawn;
import com.yoshiplex.rainbow.RainbowText;

import net.md_5.bungee.api.chat.TextComponent;

public class PlayerJoin implements Listener {

	public static List<Player> a = new ArrayList<>();

	@EventHandler
	public void entrou(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		APIr.logado.remove(p.getName());
		RegisterLogin.vezes.remove(p.getName());
		if (APIr.jaregistrou(p.getName())) {
			p.sendMessage(Base.prefix + "§fUse §a/Login <senha>§f.");
		} else {
			p.sendMessage(Base.prefix + "§fUse §a/Register <senha> <senha>§f.");
		}
		e.setJoinMessage(null);
		Builder.pode.remove(p.getName());
		p.setCustomName(p.getName());
		Base.setarKit(p, "Nenhum");
		Base.setaraKit(p, "PvP");
		Admin.Atma(p);
		Spawn.tpinstaSpawn(p);
		RainbowText text = new RainbowText("IP NOVO! Jogar.LegendPvP.com.br");
		a.add(p);
		new BukkitRunnable() {
			@Override
			public void run() {
				if (a.contains(p)) {
					text.moveRainbowRight();
					BossBarAPI.addBar(p, new TextComponent(text.getText()), BossBarAPI.Color.BLUE,
							BossBarAPI.Style.NOTCHED_12, 1.0F, 20, 2);
				}
			}
		}.runTaskTimer(Main.plugin, 2, 2);
	}

	public static List<Player> on = new ArrayList<>();

	@EventHandler
	public void KD(PlayerJoinEvent e) {
		on.add(e.getPlayer());
		if (Main.file.getConfig().getString(String.valueOf(e.getPlayer().getName()) + ".Nome") == null) {
			Main.file.getConfig().set(String.valueOf(e.getPlayer().getName()) + ".Nome",
					String.valueOf(e.getPlayer().getName().toString()));
			Main.file.getConfig().set(String.valueOf(e.getPlayer().getName()) + ".Kills", Integer.valueOf(0));
			Main.file.getConfig().set(String.valueOf(e.getPlayer().getName()) + ".Pontos", Integer.valueOf(0));
			Main.file.getConfig().set(String.valueOf(e.getPlayer().getName()) + ".Mortes", Integer.valueOf(0));
			Main.file.getConfig().set(String.valueOf(e.getPlayer().getName()) + ".Dinheiro", Integer.valueOf(0));
			Main.file.getConfig().set(String.valueOf(e.getPlayer().getName()) + ".TopKS", Integer.valueOf(0));
			Main.file.getConfig().set(String.valueOf(e.getPlayer().getName()) + ".Arena", Boolean.valueOf(false));
			Main.file.getConfig().set(String.valueOf(e.getPlayer().getName()) + ".Score", Boolean.valueOf(true));
			Main.file.save();
		}
		if (Main.file.getConfig().getString(String.valueOf(e.getPlayer().getName()) + ".Tag") == null) {
			Main.file.getConfig().set(String.valueOf(e.getPlayer().getName()) + ".Tag", String.valueOf("Normal"));
			Main.file.save();
		}
		Main.file.getConfig().set(String.valueOf(e.getPlayer().getName()) + ".IP",
				String.valueOf(e.getPlayer().getAddress()));
		Main.file.save();
		newScore3.setScoreboard(e.getPlayer());
	}
}
