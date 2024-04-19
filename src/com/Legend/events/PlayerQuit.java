package com.Legend.events;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.scheduler.BukkitRunnable;

import com.Legend.Main;
import com.Legend.Comandos.Admin;
import com.Legend.Comandos.Builder;
import com.Legend.KD.API;
import com.Legend.RDM.RDMApi;
import com.Legend.RDM.RDMStatus;
import com.Legend.kits.manager.Base;
import com.Legend.register.APIr;
import com.Legend.umvum.API1;
import com.Legend.warps.WarpAPI;

public class PlayerQuit implements Listener {

	@EventHandler
	public void admin(PlayerQuitEvent e) {
		PlayerJoin.on.remove(e.getPlayer());
		if (Admin.inadmin.contains(e.getPlayer())) {
			Admin.inadmin.remove(e.getPlayer());
		}
		if (Admin.as.containsKey(e.getPlayer())) {
			Player t = Admin.as.get(e.getPlayer());
			Admin.as.remove(t);
			Admin.as.remove(e.getPlayer());
			if (t.hasPermission("legend.admin")) {
				t.sendMessage("§c" + e.getPlayer().getName() + " deslogou durante análise de autosoup.");
			}
		}
		if (Admin.ff.containsKey(e.getPlayer())) {
			Player t = Admin.ff.get(e.getPlayer());
			Admin.ff.remove(t);
			Admin.ff.remove(e.getPlayer());
			if (t.hasPermission("legend.admin")) {
				t.sendMessage("§c" + e.getPlayer().getName() + " deslogou durante análise de killaura/FF.");
			}
			if (Admin.hits.containsKey(e.getPlayer())) {
				Admin.hits.remove(e.getPlayer());
			}
		}
	}

	@EventHandler
	public void saiu(PlayerQuitEvent e) {
		Player p = e.getPlayer();
		e.setQuitMessage(null);
		if (APIr.logado.contains(p.getName())) {
			Bukkit.broadcastMessage("§f[§c-§f] §c>> §f" + e.getPlayer().getName() + "§b.");
		}
		Base.tirarKit(p);
		Builder.pode.remove(p.getName());
	}

	@EventHandler
	public void RDM(PlayerQuitEvent e) {
		Player p = e.getPlayer();
		if (RDMApi.inRDM.contains(e.getPlayer())) {
			Player k;
			if (RDMApi.emduel == false) {
				RDMApi.inRDM.remove(p);
				RDMApi.inDuelo.remove(p);
				RDMApi.inFila.remove(p);
			} else {
				if (RDMApi.duel1.containsKey(p) || RDMApi.duel1.containsValue(p)) {
					k = RDMApi.duel1.get(p);
					RDMApi.duel1.remove(p);
					RDMApi.duel1.remove(k);
				} else if (RDMApi.duel2.containsKey(p) || RDMApi.duel2.containsValue(p)) {
					k = RDMApi.duel2.get(p);
					RDMApi.duel2.remove(p);
					RDMApi.duel2.remove(k);
				} else if (RDMApi.duel3.containsKey(p) || RDMApi.duel3.containsValue(p)) {
					k = RDMApi.duel3.get(p);
					RDMApi.duel3.remove(p);
					RDMApi.duel3.remove(k);
				} else if (RDMApi.duel4.containsKey(p) || RDMApi.duel4.containsValue(p)) {
					k = RDMApi.duel4.get(p);
					RDMApi.duel4.remove(p);
					RDMApi.duel4.remove(k);
				} else if (RDMApi.duel5.containsKey(p) || RDMApi.duel5.containsValue(p)) {
					k = RDMApi.duel5.get(p);
					RDMApi.duel5.remove(p);
					RDMApi.duel5.remove(k);
				} else {
					k = (Player) p.getLastDamageCause();
				}
				k.sendMessage(RDMApi.prefix + "Seu inimigo deslogou e você passou de fase");
				RDMStatus.setperdeu(p);
				RDMStatus.setkills(k);
				RDMApi.inDuelo.remove(k);
				RDMApi.inRDM.remove(p);
				RDMApi.inDuelo.remove(p);
				if (RDMApi.inDuelo.size() == 0) {
					if (RDMApi.inRDM.size() > 1) {
						k.sendMessage(RDMApi.prefix + "Parabens, você passou de fase, aguarde a próxima fase.");
						for (Player spec : Bukkit.getOnlinePlayers()) {
							if (RDMApi.inSpec.contains(spec) || RDMApi.inRDM.contains(spec)) {
								spec.sendMessage(RDMApi.prefix + "§c" + p.getName() + " §fdeslogou e §c" + k.getName()
										+ " §favançou de Round.");
							}
						}
					} else if (RDMApi.inRDM.size() == 1) {
						k.sendMessage(
								RDMApi.prefix + "§c" + p.getName() + " §fdeslogou e você ganhou o §cTorneio RDM§f.");
						Bukkit.broadcastMessage(RDMApi.prefix + "§c" + p.getName() + " §fdeslogou e §c" + k.getName()
								+ " §fganhou o §cTorneio RDM§f.");
						API.setDinheiro(k, 500);
						RDMStatus.setwins(k);
					}
					new BukkitRunnable() {

						@Override
						public void run() {
							k.teleport(WarpAPI.getLocation("rdm.lobby"));
							k.getInventory().clear();
							API.clearPlayer(k);
							RDMApi.InfosRDM(k);
							Admin.Atma(p);
							Admin.Atma(k);
							RDMApi.inFila.add(k);
							RDMApi.verifyWin();
							if (RDMApi.inDuelo.size() == 0) {
								if (RDMApi.inRDM.size() == 1) {
									RDMApi.inFila.remove(k);
								} else {
									if (RDMApi.ganhou() == true) {

									} else {
										RDMApi.iniciarDuels();
									}
								}
							}
						}
					}.runTaskLater(Main.getPlugin(), 100);

				}
			}
		}
	}

	@EventHandler
	public void x1(PlayerQuitEvent e) {
		Player p = e.getPlayer();
		API1.fila.remove(p);
		API1.convidado.remove(p);
		if (API1.batalhando.containsKey(p)) {
			Player t1 = API1.batalhando.get(p);
			p.sendMessage("§cVocê perdeu a batalha contra " + t1.getName() + ".");
			t1.sendMessage("§aVocê venceu a batalha contra " + p.getName() + ", pois ele deslogou.");
			new BukkitRunnable() {

				@Override
				public void run() {
					API1.resetX1(t1);
					API1.resetX1(p);
					API1.setmortes(p);
					API1.setkills(t1);
					API1.addKs(t1);
					API1.resetKs(p);
				}
			}.runTaskLater(Main.getPlugin(), 20);
		}
	}
}
