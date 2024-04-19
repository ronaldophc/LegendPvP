package com.Legend.events;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.scheduler.BukkitRunnable;

import com.Legend.Main;
import com.Legend.Comandos.Admin;
import com.Legend.KD.API;
import com.Legend.RDM.RDMApi;
import com.Legend.RDM.RDMStatus;
import com.Legend.kits.Viper;
import com.Legend.kits.manager.Base;
import com.Legend.kits.manager.CdAPI;
import com.Legend.kits.manager.Comando;
import com.Legend.kits.manager.CooldownAPI;
import com.Legend.umvum.API1;
import com.Legend.warps.Spawn;
import com.Legend.warps.WarpAPI;

public class PlayerDeath implements Listener {

	@EventHandler
	public void Template(PlayerDeathEvent e) {
		if (e.getEntity() instanceof Player) {
			// Player p = (Player) e.getEntity();
			if (e.getEntity().getKiller() instanceof Player) {
				// Player k = e.getEntity().getKiller();
			}
		}
	}

	@EventHandler
	public void normal(PlayerDeathEvent e) {
		e.setDeathMessage(null);
		Comando.remove(e.getEntity());
		e.setDroppedExp(0);
		if (e.getEntity() instanceof Player) {
			Player p = (Player) e.getEntity();
			e.getEntity().getInventory().clear();
			e.getEntity().getInventory().setArmorContents(null);
			p.getOpenInventory().getTopInventory().clear();
			Combatlog.removeCombat(p);
			Comando.remove(p);
			CooldownAPI.tirarCooldown(p);
			CdAPI.tirarCooldown(p);
			if (e.getEntity().getKiller() instanceof Player) {
				Player k = e.getEntity().getKiller();
				if (Comando.Arena.contains(k)) {
					List<Integer> c1 = new ArrayList<>();
					c1.add(12);
					c1.add(13);
					c1.add(14);
					c1.add(15);
					c1.add(16);
					int b = c1.get(new Random().nextInt(c1.size()));
					k.getInventory().addItem(API.Item(Material.BROWN_MUSHROOM, "§cCogu Brown", b, (byte) 0));
					k.getInventory().addItem(API.Item(Material.BOWL, "§cPotinhos", b, (byte) 0));
					k.getInventory().addItem(API.Item(Material.RED_MUSHROOM, "§cCogu Red", b, (byte) 0));
				}
				if (k != p) {
					API.setkills(k);
					API.removerDinheiro(p, 20);
					API.setDinheiro(k, 50);
					API.setmortes(p);
					API.setpontos(k, 3);
					API.removerpontos(p, 1);
					Main.file.save();
					if (!API1.batalhando.containsKey(p) || !API1.batalhando.containsKey(p)) {
						API.addKs(k);
					}
					if (!(RDMApi.inRDM.contains(k))) {
						k.sendMessage(Base.prefix + "§bVoce Matou: §f" + p.getName() + "§b.");
					}
					p.sendMessage(Base.prefix + "§bVoce foi Morto por: §f" + k.getName() + "§b.");
				}
				API.resetKs(p);
			}
			API.clearPlayer(p);
			new BukkitRunnable() {

				@Override
				public void run() {
					Spawn.tpinstaSpawn(p);
					p.spigot().respawn();
				}
			}.runTaskLater(Main.plugin, 1);
		}
	}

	@EventHandler
	public void RDM(PlayerDeathEvent e) {
		if (e.getEntity() instanceof Player && e.getEntity().getKiller() instanceof Player) {
			Player p = (Player) e.getEntity();
			Player k = e.getEntity().getKiller();
			if (RDMApi.inDuelo.contains(k)) {
				if (RDMApi.duel1.containsKey(k) || RDMApi.duel1.containsValue(k)) {
					RDMApi.duel1.remove(p);
					RDMApi.duel1.remove(k);
				} else if (RDMApi.duel2.containsKey(k) || RDMApi.duel2.containsValue(k)) {
					RDMApi.duel2.remove(p);
					RDMApi.duel2.remove(k);
				} else if (RDMApi.duel3.containsKey(k) || RDMApi.duel3.containsValue(k)) {
					RDMApi.duel3.remove(p);
					RDMApi.duel3.remove(k);
				} else if (RDMApi.duel4.containsKey(k) || RDMApi.duel4.containsValue(k)) {
					RDMApi.duel4.remove(p);
					RDMApi.duel4.remove(k);
				}
				RDMStatus.setperdeu(p);
				RDMStatus.setkills(k);
				RDMApi.inDuelo.remove(k);
				if (RDMApi.inRDM.size() == 3) {
					p.sendMessage(RDMApi.prefix + "Você ficou em 3º lugar e ganhou §aR$150");
					API.setDinheiro(p, 150);
				} else if (RDMApi.inRDM.size() == 2) {
					p.sendMessage(RDMApi.prefix + "Você ficou em 2º lugar e ganhou §aR$250");
					API.setDinheiro(p, 250);
				}
				RDMApi.inRDM.remove(p);
				RDMApi.inDuelo.remove(p);
				if (RDMApi.inDuelo.size() == 0) {
					if (RDMApi.inRDM.size() > 1) {
						k.sendMessage(RDMApi.prefix + "Parabens, você passou de fase, aguarde a próxima fase.");
						for (Player spec : Bukkit.getOnlinePlayers()) {
							if (RDMApi.inSpec.contains(spec) || RDMApi.inRDM.contains(spec)) {
								spec.sendMessage(RDMApi.prefix + "§c" + k.getName() + " §fmatou §c" + p.getName()
										+ " §fe avançou de Round.");
							}
						}
					} else if (RDMApi.inRDM.size() == 1) {
						k.sendMessage(RDMApi.prefix + "Você matou §c" + p.getName() + " §fe ganhou o §cTorneio RDM§f.");
						Bukkit.broadcastMessage(RDMApi.prefix + "§c" + k.getName() + " §fmatou §c" + p.getName()
								+ " §fe ganhou o §cTorneio RDM§f.");
						API.setDinheiro(k, 500);
						RDMStatus.setwins(k);
					}
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

	@EventHandler
	public void x1(PlayerDeathEvent e) {
		if (e.getEntity() instanceof Player && e.getEntity().getKiller() instanceof Player) {
			Player p = (Player) e.getEntity();
			Player k = e.getEntity().getKiller();
			Viper.a.remove(p);
			Viper.b.remove(p);
			Viper.a.remove(k);
			Viper.b.remove(k);
			if (API1.batalhando.containsKey(p) || API1.batalhando.containsKey(p)) {
				Player t1 = API1.batalhando.get(p);
				p.sendMessage("§cVocê perdeu a batalha contra " + k.getName() + ".");
				t1.sendMessage("§aVocê venceu a batalha contra " + p.getName() + ".");
				new BukkitRunnable() {

					@Override
					public void run() {
						if (API1.batalhando.containsKey(p)) {
							Player t1 = API1.batalhando.get(p);
							API1.resetX1(t1);
							API1.resetX1(p);
							API1.convidado.remove(p);
							API1.convidado.remove(t1);
							API1.setkills(t1);
							API1.setmortes(p);
							API1.addKs(k);
							API1.resetKs(p);
						}

					}
				}.runTaskLater(Main.getPlugin(), 05);
			}
		}
	}
}
