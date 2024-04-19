package com.Legend.RDM;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.SkullType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.scheduler.BukkitRunnable;

import com.Legend.Main;
import com.Legend.Comandos.Admin;
import com.Legend.KD.API;
import com.Legend.guis.Title;
import com.Legend.warps.Spawn;
import com.Legend.warps.WarpAPI;

public class RDMApi {

	public static String prefix = "§cRDM -> §f";
	public static List<Player> inRDM = new ArrayList<>();
	public static List<Player> inFila = new ArrayList<>();
	public static List<Player> inDuelo = new ArrayList<>();
	public static List<Player> inFreeze = new ArrayList<>();
	public static List<Player> inSpec = new ArrayList<>();
	public static HashMap<Player, Player> duel1 = new HashMap<>();
	public static HashMap<Player, Player> duel2 = new HashMap<>();
	public static HashMap<Player, Player> duel3 = new HashMap<>();
	public static HashMap<Player, Player> duel4 = new HashMap<>();
	public static HashMap<Player, Player> duel5 = new HashMap<>();
	public static boolean iniciado = false;
	public static boolean emduel = false;
	public static int tentativas = 0;
	public static int necessario = 1;
	public static int freeze1, freeze2, freeze3, freeze4, freeze5 = 6;
	public static int tempo = 300;
	static int cd1, cd2, cd3, cd4, cd5 = 60;
	static int cda = 60;
	static int max = 10;

	public static boolean emRDM(Player p) {
		if (inRDM.contains(p)) {
			return true;
		} else {
			return false;
		}
	}

	public static void iniciarRDM() {
		iniciado = true;
		new BukkitRunnable() {

			@Override
			public void run() {
				if (iniciado == false) {
					cancel();
				}
				tempo -= 1;
				for (Player n : Bukkit.getOnlinePlayers()) {
					if (inRDM.contains(n) || inSpec.contains(n)) {
						Title.sendActionBar(n,
								"§6" + tempo + "s §fpara iniciar. §6" + inRDM.size() + "/" + max + "§f.");
					}
				}
				if (tempo == 299) {
					anuncioRDM();
				} else if (tempo == 180) {
					anuncioRDM();
				} else if (tempo == 60) {
					anuncioRDM2();
				} else if (tempo == 30) {
					anuncioRDM2();
				} else if (tempo == 10) {
					anuncioRDM2();
				} else if (tempo == 0) {
					if (inRDM.size() <= necessario) {
						if (tentativas == 0) {
							tempo = 200;
							anuncioRDMreset();
							tentativas = 1;
						} else if (tentativas == 1) {
							Bukkit.broadcastMessage(prefix + "§fEvento cancelado automaticamente por falta de §cPlayers§f!");
							tempo = 0;
							for (Player n : Bukkit.getOnlinePlayers()) {
								if (inRDM.contains(n)) {
									RDMApi.tempo = 300;
									RDMApi.inDuelo.clear();
									RDMApi.inRDM.clear();
									RDMApi.inFila.clear();
									RDMApi.duel1.clear();
									RDMApi.duel2.clear();
									RDMApi.duel3.clear();
									RDMApi.duel4.clear();
									RDMApi.duel5.clear();
									RDMApi.iniciado = false;
									RDMApi.emduel = false;
									RDMApi.tentativas = 0;
									RDMApi.freeze1 = 6;
									RDMApi.freeze2 = 6;
									RDMApi.freeze3 = 6;
									RDMApi.freeze4 = 6;
									RDMApi.freeze5 = 6;
									RDMApi.cd1 = 65;
									RDMApi.cd2 = 65;
									RDMApi.cd3 = 65;
									RDMApi.cd4 = 65;
									RDMApi.cd5 = 65;
									RDMApi.cda = 65;
								}
							}
							cancel();
						}
					} else {
						Bukkit.broadcastMessage("§fEvento §cRDM §finiciou, para assistir digite §c/RDM spec§f!");
						iniciarDuels();
						cancel();
					}
				}

			}
		}.runTaskTimer(Main.getPlugin(), 20, 20);
	}

	public static void iniciarDuels() {
		if (emduel == false) {
			emduel = true;
		}
		if (inRDM.size() == 0) {
			return;
		}
		for (Player spec : Bukkit.getOnlinePlayers()) {
			if (inSpec.contains(spec) || inRDM.contains(spec)) {
				spec.sendMessage(prefix + "§f---------§cEvento RDM§f---------");
				spec.sendMessage(prefix + "Round começando.");
				spec.sendMessage(prefix + "Há §c" + inRDM.size() + " §fjogadores ainda.");
			}
		}
		if (inFila.size() >= 10) {
			Player p10 = inFila.get(new Random().nextInt(inFila.size()));
			inFila.remove(p10);
			Player p9 = inFila.get(new Random().nextInt(inFila.size()));
			inFila.remove(p9);
			for (Player spec : Bukkit.getOnlinePlayers()) {
				if (inSpec.contains(spec) || inRDM.contains(spec)) {
					spec.sendMessage(
							prefix + "§c" + p10.getName() + " §fenfrentara §c " + p9.getName() + "§f, em 1 Minuto!");
				}
			}
			p10.sendMessage(prefix + "Wins do seu adversario: §c" + RDMStatus.getwins(p9));
			p10.sendMessage(prefix + "Derrotas do seu adversario: §c" + RDMStatus.getperdeu(p9));
			p9.sendMessage(prefix + "Wins do seu adversario: §c" + RDMStatus.getwins(p10));
			p9.sendMessage(prefix + "Derrotas do seu adversario: §c" + RDMStatus.getperdeu(p10));
			duel5.put(p10, p9);
			cd5 = 60;
			freeze5 = 6;
			new BukkitRunnable() {

				@Override
				public void run() {
					if (cd5 == 65) {
						cancel();
					}
					cd5 -= 1;
					if (!(p10.isOnline()) || !(p9.isOnline())) {
						cancel();
					}
					if (cd5 == 30) {
						if (!(p10.isOnline()) || !(p9.isOnline())) {
							cancel();
						}
						p10.sendMessage(
								prefix + "Seu Duelo contra §c" + p9.getName() + "§f, vai começar em §c30 segundos§f!");
						p9.sendMessage(
								prefix + "Seu Duelo contra §c" + p10.getName() + "§f, vai começar em §c30 segundos§f!");
					} else if (cd5 == 10) {
						if (!(p10.isOnline()) || !(p9.isOnline())) {
							cancel();
						}
						p10.sendMessage(
								prefix + "Seu Duelo contra §c" + p9.getName() + "§f, vai começar em §c10 segundos§f!");
						p9.sendMessage(
								prefix + "Seu Duelo contra §c" + p10.getName() + "§f, vai começar em §c10 segundos§f!");
					} else if (cd5 == 0) {
						if (!(p10.isOnline()) || !(p9.isOnline())) {
							cancel();
						}
						inDuelo.add(p10);
						inDuelo.add(p9);
						inFreeze.add(p10);
						inFreeze.add(p9);
						p10.teleport(WarpAPI.getLocation("rdm.arena5.pos1"));
						p9.teleport(WarpAPI.getLocation("rdm.arena5.pos2"));
						API.setDinheiro(p10, 50);
						API.setDinheiro(p9, 50);
						Admin.Atma(p10);
						Admin.Atma(p9);
						for (Player on : Bukkit.getOnlinePlayers()) {
							p10.hidePlayer(on);
							p9.hidePlayer(on);
						}
						for (Player duel : Bukkit.getOnlinePlayers()) {
							if (inDuelo.contains(duel)) {
								duel.hidePlayer(p10);
								duel.hidePlayer(p9);
							}
						}
						p9.showPlayer(p10);
						p10.showPlayer(p9);
						darItens(p10);
						darItens(p9);
						new BukkitRunnable() {

							@Override
							public void run() {
								freeze5 -= 1;
								if (freeze5 == 5) {
									if (!(p10.isOnline()) || !(p9.isOnline())) {
										cancel();
									}
									p10.sendMessage(prefix + "§c5...");
									p9.sendMessage(prefix + "§c5...");
								} else if (freeze5 == 4) {
									p10.sendMessage(prefix + "§c4...");
									p9.sendMessage(prefix + "§c4...");
								} else if (freeze5 == 3) {
									p10.sendMessage(prefix + "§c3...");
									p9.sendMessage(prefix + "§c3...");
								} else if (freeze5 == 2) {
									p10.sendMessage(prefix + "§c2...");
									p9.sendMessage(prefix + "§c2...");
								} else if (freeze5 == 1) {
									p10.sendMessage(prefix + "§c1...");
									p9.sendMessage(prefix + "§c1...");
								} else if (freeze5 == 0) {
									p10.sendMessage(prefix + "§c0...");
									p9.sendMessage(prefix + "§c0...");
									p10.sendMessage(prefix + "§cComeçou...");
									p9.sendMessage(prefix + "§cComeçou...");
									inFreeze.remove(p10);
									inFreeze.remove(p9);
									freeze5 = 6;
									cancel();
								}

							}
						}.runTaskTimer(Main.getPlugin(), 20, 20);
						cancel();
					}
				}
			}.runTaskTimer(Main.getPlugin(), 20, 20);
		}
		if (inFila.size() >= 8) {
			Player p1 = inFila.get(new Random().nextInt(inFila.size()));
			inFila.remove(p1);
			Player p2 = inFila.get(new Random().nextInt(inFila.size()));
			inFila.remove(p2);
			for (Player spec : Bukkit.getOnlinePlayers()) {
				if (inSpec.contains(spec) || inRDM.contains(spec)) {
					spec.sendMessage(
							prefix + "§c" + p1.getName() + " §fenfrentara §c " + p2.getName() + "§f, em 1 Minuto!");
				}
			}
			p1.sendMessage(prefix + "Wins do seu adversario: §c" + RDMStatus.getwins(p2));
			p1.sendMessage(prefix + "Derrotas do seu adversario: §c" + RDMStatus.getperdeu(p2));
			p2.sendMessage(prefix + "Wins do seu adversario: §c" + RDMStatus.getwins(p1));
			p2.sendMessage(prefix + "Derrotas do seu adversario: §c" + RDMStatus.getperdeu(p1));
			duel1.put(p1, p2);
			cd1 = 60;
			freeze1 = 6;
			new BukkitRunnable() {

				@Override
				public void run() {
					if (cd1 == 65) {
						cancel();
					}
					cd1 -= 1;
					if (!(p1.isOnline()) || !(p2.isOnline())) {
						cancel();
					}
					if (cd1 == 30) {
						if (!(p1.isOnline()) || !(p2.isOnline())) {
							cancel();
						}
						p1.sendMessage(
								prefix + "Seu Duelo contra §c" + p2.getName() + "§f, vai começar em §c30 segundos§f!");
						p2.sendMessage(
								prefix + "Seu Duelo contra §c" + p1.getName() + "§f, vai começar em §c30 segundos§f!");
					} else if (cd1 == 10) {
						if (!(p1.isOnline()) || !(p2.isOnline())) {
							cancel();
						}
						p1.sendMessage(
								prefix + "Seu Duelo contra §c" + p2.getName() + "§f, vai começar em §c10 segundos§f!");
						p2.sendMessage(
								prefix + "Seu Duelo contra §c" + p1.getName() + "§f, vai começar em §c10 segundos§f!");
					} else if (cd1 == 0) {
						if (!(p1.isOnline()) || !(p2.isOnline())) {
							cancel();
						}
						inDuelo.add(p1);
						inDuelo.add(p2);
						inFreeze.add(p1);
						inFreeze.add(p2);
						p1.teleport(WarpAPI.getLocation("rdm.arena2.pos2"));
						p2.teleport(WarpAPI.getLocation("rdm.arena2.pos1"));
						API.setDinheiro(p1, 50);
						API.setDinheiro(p2, 50);
						Admin.Atma(p1);
						Admin.Atma(p2);
						for (Player on : Bukkit.getOnlinePlayers()) {
							p1.hidePlayer(on);
							p2.hidePlayer(on);
						}
						for (Player duel : Bukkit.getOnlinePlayers()) {
							if (inDuelo.contains(duel)) {
								duel.hidePlayer(p1);
								duel.hidePlayer(p2);
							}
						}
						p2.showPlayer(p1);
						p1.showPlayer(p2);
						darItens(p1);
						darItens(p2);
						new BukkitRunnable() {

							@Override
							public void run() {
								freeze1 -= 1;
								if (freeze1 == 5) {
									if (!(p1.isOnline()) || !(p2.isOnline())) {
										cancel();
									}
									p1.sendMessage(prefix + "§c5...");
									p2.sendMessage(prefix + "§c5...");
								} else if (freeze1 == 4) {
									p1.sendMessage(prefix + "§c4...");
									p2.sendMessage(prefix + "§c4...");
								} else if (freeze1 == 3) {
									p1.sendMessage(prefix + "§c3...");
									p2.sendMessage(prefix + "§c3...");
								} else if (freeze1 == 2) {
									p1.sendMessage(prefix + "§c2...");
									p2.sendMessage(prefix + "§c2...");
								} else if (freeze1 == 1) {
									p1.sendMessage(prefix + "§c1...");
									p2.sendMessage(prefix + "§c1...");
								} else if (freeze1 == 0) {
									p1.sendMessage(prefix + "§c0...");
									p2.sendMessage(prefix + "§c0...");
									p1.sendMessage(prefix + "§cComeçou...");
									p2.sendMessage(prefix + "§cComeçou...");
									inFreeze.remove(p1);
									inFreeze.remove(p2);
									freeze1 = 6;
									cancel();
								}

							}
						}.runTaskTimer(Main.getPlugin(), 20, 20);
						cancel();
					}
				}
			}.runTaskTimer(Main.getPlugin(), 20, 20);
		}
		if (inFila.size() >= 6) {
			Player p3 = inFila.get(new Random().nextInt(inFila.size()));
			inFila.remove(p3);
			Player p4 = inFila.get(new Random().nextInt(inFila.size()));
			inFila.remove(p4);
			for (Player spec : Bukkit.getOnlinePlayers()) {
				if (inSpec.contains(spec) || inRDM.contains(spec)) {
					spec.sendMessage(
							prefix + "§c" + p3.getName() + " §fenfrentara §c " + p4.getName() + "§f, em 1 Minuto!");
				}
			}
			p3.sendMessage(prefix + "Wins do seu adversario: §c" + RDMStatus.getwins(p4));
			p3.sendMessage(prefix + "Derrotas do seu adversario: §c" + RDMStatus.getperdeu(p4));
			p4.sendMessage(prefix + "Wins do seu adversario: §c" + RDMStatus.getwins(p3));
			p4.sendMessage(prefix + "Derrotas do seu adversario: §c" + RDMStatus.getperdeu(p3));
			duel2.put(p3, p4);
			cd2 = 60;
			freeze2 = 6;
			new BukkitRunnable() {

				@Override
				public void run() {
					if (cd2 == 65) {
						cancel();
					}
					cd2 -= 1;
					if (!(p3.isOnline()) || !(p4.isOnline())) {
						cancel();
					}
					if (cd2 == 30) {
						if (!(p3.isOnline()) || !(p4.isOnline())) {
							cancel();
						}
						p3.sendMessage(
								prefix + "Seu Duelo contra §c" + p4.getName() + "§f, vai começar em §c30 segundos§f!");
						p4.sendMessage(
								prefix + "Seu Duelo contra §c" + p3.getName() + "§f, vai começar em §c30 segundos§f!");
					} else if (cd2 == 10) {
						if (!(p3.isOnline()) || !(p4.isOnline())) {
							cancel();
						}
						p3.sendMessage(
								prefix + "Seu Duelo contra §c" + p4.getName() + "§f, vai começar em §c10 segundos§f!");
						p4.sendMessage(
								prefix + "Seu Duelo contra §c" + p3.getName() + "§f, vai começar em §c10 segundos§f!");
					} else if (cd2 == 0) {
						if (!(p3.isOnline()) || !(p4.isOnline())) {
							cancel();
						}
						inDuelo.add(p3);
						inDuelo.add(p4);
						inFreeze.add(p3);
						inFreeze.add(p4);
						p3.teleport(WarpAPI.getLocation("rdm.arena3.pos1"));
						p4.teleport(WarpAPI.getLocation("rdm.arena3.pos2"));
						API.setDinheiro(p3, 50);
						API.setDinheiro(p4, 50);
						Admin.Atma(p3);
						Admin.Atma(p4);
						for (Player on : Bukkit.getOnlinePlayers()) {
							p3.hidePlayer(on);
							p4.hidePlayer(on);
						}
						for (Player duel : Bukkit.getOnlinePlayers()) {
							if (inDuelo.contains(duel)) {
								duel.hidePlayer(p3);
								duel.hidePlayer(p4);
							}
						}
						p4.showPlayer(p3);
						p3.showPlayer(p4);
						darItens(p3);
						darItens(p4);
						new BukkitRunnable() {

							@Override
							public void run() {
								freeze2 -= 1;
								if (freeze2 == 5) {
									if (!(p3.isOnline()) || !(p4.isOnline())) {
										cancel();
									}
									p3.sendMessage(prefix + "§c5...");
									p4.sendMessage(prefix + "§c5...");
								} else if (freeze2 == 4) {
									p3.sendMessage(prefix + "§c4...");
									p4.sendMessage(prefix + "§c4...");
								} else if (freeze2 == 3) {
									p3.sendMessage(prefix + "§c3...");
									p4.sendMessage(prefix + "§c3...");
								} else if (freeze2 == 2) {
									p3.sendMessage(prefix + "§c2...");
									p4.sendMessage(prefix + "§c2...");
								} else if (freeze2 == 1) {
									p3.sendMessage(prefix + "§c1...");
									p4.sendMessage(prefix + "§c1...");
								} else if (freeze2 == 0) {
									p3.sendMessage(prefix + "§c0...");
									p4.sendMessage(prefix + "§c0...");
									p3.sendMessage(prefix + "§cComeçou...");
									p4.sendMessage(prefix + "§cComeçou...");
									inFreeze.remove(p3);
									inFreeze.remove(p4);
									freeze2 = 6;
									cancel();
								}

							}
						}.runTaskTimer(Main.getPlugin(), 20, 20);
						cancel();
					}
				}
			}.runTaskTimer(Main.getPlugin(), 20, 20);
		}
		if (inFila.size() >= 4) {
			Player p5 = inFila.get(new Random().nextInt(inFila.size()));
			inFila.remove(p5);
			Player p6 = inFila.get(new Random().nextInt(inFila.size()));
			inFila.remove(p6);
			for (Player spec : Bukkit.getOnlinePlayers()) {
				if (inSpec.contains(spec) || inRDM.contains(spec)) {
					spec.sendMessage(
							prefix + "§c" + p5.getName() + " §fenfrentara §c " + p6.getName() + "§f, em 1 Minuto!");
				}
			}
			p5.sendMessage(prefix + "Wins do seu adversario: §c" + RDMStatus.getwins(p6));
			p5.sendMessage(prefix + "Derrotas do seu adversario: §c" + RDMStatus.getperdeu(p6));
			p6.sendMessage(prefix + "Wins do seu adversario: §c" + RDMStatus.getwins(p5));
			p6.sendMessage(prefix + "Derrotas do seu adversario: §c" + RDMStatus.getperdeu(p5));
			duel3.put(p5, p6);
			cd3 = 60;
			freeze3 = 6;
			new BukkitRunnable() {

				@Override
				public void run() {
					if (cd3 == 65) {
						cancel();
					}
					cd3 -= 1;
					if (!(p5.isOnline()) || !(p6.isOnline())) {
						cancel();
					}
					if (cd3 == 30) {
						if (!(p5.isOnline()) || !(p6.isOnline())) {
							cancel();
						}
						p5.sendMessage(
								prefix + "Seu Duelo contra §c" + p6.getName() + "§f, vai começar em §c30 segundos§f!");
						p6.sendMessage(
								prefix + "Seu Duelo contra §c" + p5.getName() + "§f, vai começar em §c30 segundos§f!");
					} else if (cd3 == 10) {
						if (!(p5.isOnline()) || !(p6.isOnline())) {
							cancel();
						}
						p5.sendMessage(
								prefix + "Seu Duelo contra §c" + p6.getName() + "§f, vai começar em §c10 segundos§f!");
						p6.sendMessage(
								prefix + "Seu Duelo contra §c" + p5.getName() + "§f, vai começar em §c10 segundos§f!");
					} else if (cd3 == 0) {
						if (!(p5.isOnline()) || !(p6.isOnline())) {
							cancel();
						}
						inDuelo.add(p5);
						inDuelo.add(p6);
						inFreeze.add(p5);
						inFreeze.add(p6);
						p5.teleport(WarpAPI.getLocation("rdm.arena4.pos1"));
						p6.teleport(WarpAPI.getLocation("rdm.arena4.pos2"));
						API.setDinheiro(p5, 50);
						API.setDinheiro(p6, 50);
						Admin.Atma(p5);
						Admin.Atma(p6);
						for (Player on : Bukkit.getOnlinePlayers()) {
							p5.hidePlayer(on);
							p6.hidePlayer(on);
						}
						for (Player duel : Bukkit.getOnlinePlayers()) {
							if (inDuelo.contains(duel)) {
								duel.hidePlayer(p5);
								duel.hidePlayer(p6);
							}
						}
						p6.showPlayer(p5);
						p5.showPlayer(p6);
						darItens(p5);
						darItens(p6);
						new BukkitRunnable() {

							@Override
							public void run() {
								freeze3 -= 1;
								if (freeze3 == 5) {
									if (!(p5.isOnline()) || !(p6.isOnline())) {
										cancel();
									}
									p5.sendMessage(prefix + "§c5...");
									p6.sendMessage(prefix + "§c5...");
								} else if (freeze3 == 4) {
									p5.sendMessage(prefix + "§c4...");
									p6.sendMessage(prefix + "§c4...");
								} else if (freeze3 == 3) {
									p5.sendMessage(prefix + "§c3...");
									p6.sendMessage(prefix + "§c3...");
								} else if (freeze3 == 2) {
									p5.sendMessage(prefix + "§c2...");
									p6.sendMessage(prefix + "§c2...");
								} else if (freeze3 == 1) {
									p5.sendMessage(prefix + "§c1...");
									p6.sendMessage(prefix + "§c1...");
								} else if (freeze3 == 0) {
									p5.sendMessage(prefix + "§c0...");
									p6.sendMessage(prefix + "§c0...");
									p5.sendMessage(prefix + "§cComeçou...");
									p6.sendMessage(prefix + "§cComeçou...");
									inFreeze.remove(p5);
									inFreeze.remove(p6);
									freeze3 = 6;
									cancel();
								}

							}
						}.runTaskTimer(Main.getPlugin(), 20, 20);
						cancel();
					}
				}
			}.runTaskTimer(Main.getPlugin(), 20, 20);
		}
		if (inFila.size() >= 2) {
			Player p7 = inFila.get(new Random().nextInt(inFila.size()));
			inFila.remove(p7);
			Player p8 = inFila.get(new Random().nextInt(inFila.size()));
			inFila.remove(p8);
			for (Player spec : Bukkit.getOnlinePlayers()) {
				if (inSpec.contains(spec) || inRDM.contains(spec)) {
					if ((spec == p7) || (spec == p8)) {

					} else {
						spec.sendMessage(
								prefix + "§c" + p7.getName() + " §fenfrentara §c " + p8.getName() + "§f, em 1 Minuto!");
					}
				}
			}
			p7.sendMessage(prefix + "Wins do seu adversario: §c" + RDMStatus.getwins(p8));
			p7.sendMessage(prefix + "Derrotas do seu adversario: §c" + RDMStatus.getperdeu(p8));
			p8.sendMessage(prefix + "Wins do seu adversario: §c" + RDMStatus.getwins(p7));
			p8.sendMessage(prefix + "Derrotas do seu adversario: §c" + RDMStatus.getperdeu(p7));
			duel4.put(p7, p8);
			cd4 = 60;
			freeze4 = 6;
			new BukkitRunnable() {

				@Override
				public void run() {
					if (cd4 == 65) {
						cancel();
					}
					cd4 -= 1;
					if (!(p7.isOnline()) || !(p8.isOnline())) {
						cancel();
					}
					Title.sendActionBar(p8, "§fPróx Duel: §6" + p7.getName() + " §fem §6" + cd4 + "s§f.");
					Title.sendActionBar(p7, "§fPróx Duel: §6" + p8.getName() + " §fem §6" + cd4 + "s§f.");
					if (cd4 == 0) {
						if (!(p7.isOnline()) || !(p8.isOnline())) {
							cancel();
						}
						inDuelo.add(p7);
						inDuelo.add(p8);
						inFreeze.add(p7);
						inFreeze.add(p8);
						p7.teleport(WarpAPI.getLocation("rdm.arena1.pos1"));
						p8.teleport(WarpAPI.getLocation("rdm.arena1.pos2"));
						API.setDinheiro(p8, 50);
						API.setDinheiro(p7, 50);
						Admin.Atma(p7);
						Admin.Atma(p8);
						for (Player on : Bukkit.getOnlinePlayers()) {
							p7.hidePlayer(on);
							p8.hidePlayer(on);
						}
						for (Player duel : Bukkit.getOnlinePlayers()) {
							if (inDuelo.contains(duel)) {
								duel.hidePlayer(p7);
								duel.hidePlayer(p8);
							}
						}
						p8.showPlayer(p7);
						p7.showPlayer(p8);
						darItens(p7);
						darItens(p8);
						new BukkitRunnable() {

							@Override
							public void run() {
								freeze4 -= 1;
								if (freeze4 == 5) {
									if (!(p7.isOnline()) || !(p8.isOnline())) {
										cancel();
									}
									Title.sendActionBar(p8, "§c5...");
									Title.sendActionBar(p7, "§c5...");
								} else if (freeze4 == 4) {
									Title.sendActionBar(p8, "§c4...");
									Title.sendActionBar(p7, "§c4...");
								} else if (freeze4 == 3) {
									Title.sendActionBar(p8, "§c3...");
									Title.sendActionBar(p7, "§c3...");
								} else if (freeze4 == 2) {
									Title.sendActionBar(p8, "§c2...");
									Title.sendActionBar(p7, "§c2...");
								} else if (freeze4 == 1) {
									Title.sendActionBar(p8, "§c1...");
									Title.sendActionBar(p7, "§c1...");
								} else if (freeze4 == 0) {
									Title.sendActionBar(p8, "§c0...");
									Title.sendActionBar(p7, "§c0...");
									Title.sendActionBar(p8, "§cComeçou...");
									Title.sendActionBar(p7, "§cComeçou...");
									inFreeze.remove(p7);
									inFreeze.remove(p8);
									freeze4 = 6;
									cancel();
								}

							}
						}.runTaskTimer(Main.getPlugin(), 20, 20);
						cancel();
					}
				}
			}.runTaskTimer(Main.getPlugin(), 20, 20);

		}
		if (inFila.size() == 1) {
			if (inRDM.size() == 1) {

			} else {
				Player pa = inFila.get(new Random().nextInt(inFila.size()));
				pa.sendMessage("§cRDM -> §fVocê passou de etapa sem duelar por ter Players impares!");
				for (Player spec : Bukkit.getOnlinePlayers()) {
					if (inSpec.contains(spec) || inRDM.contains(spec)) {
						spec.sendMessage(prefix + "§c" + pa.getName()
								+ " §fpassou para a próxima etapa sem duelar por ter Jogadores impares!");
					}
				}
			}
		}
		cda = 60;
		new BukkitRunnable() {

			@Override
			public void run() {
				if (cda == 65) {
					cancel();
				}
				cda -= 1;
				if (inRDM.size() == 0) {
					cancel();
				}
				if (cda == 30) {
					for (Player spec : Bukkit.getOnlinePlayers()) {
						if (inSpec.contains(spec)) {
							if (inRDM.size() == 0) {
								cancel();
							}
							spec.sendMessage(prefix + "Os Duelos irão começar em §c30 segundos§f!");
						}
					}

				} else if (cda == 10) {
					for (Player spec : Bukkit.getOnlinePlayers()) {
						if (inSpec.contains(spec)) {
							if (inRDM.size() == 0) {
								cancel();
							}
							spec.sendMessage(prefix + "Os Duelos irão começar em §c10 segundos§f!");
						}
					}
				} else if (cda == 0) {
					for (Player spec : Bukkit.getOnlinePlayers()) {
						if (inSpec.contains(spec)) {
							if (inRDM.size() == 0) {
								cancel();
							}
							spec.sendMessage(prefix + "Os Duelos começaram!");
						}
					}
				}
			}
		}.runTaskTimer(Main.getPlugin(), 20, 20);
	}

	public static void verifyWin() {
		if (iniciado == true) {
			if ((duel1.isEmpty()) && (duel2.isEmpty()) && (duel3.isEmpty()) && duel4.isEmpty()) {
				if (inRDM.size() == 1) {
					Player p = inRDM.get(0);
					p.sendMessage(prefix + "Parabens, voce ganhou o Evento!");
					p.sendMessage(prefix + "Você ficou em 1ºLugar e ganhou §aR$500§f!");
					RDMApi.tempo = 305;
					RDMApi.inDuelo.clear();
					RDMApi.inRDM.clear();
					RDMApi.inFila.clear();
					RDMApi.duel1.clear();
					RDMApi.duel2.clear();
					RDMApi.duel3.clear();
					RDMApi.duel4.clear();
					RDMApi.iniciado = false;
					RDMApi.emduel = false;
					RDMApi.tentativas = 0;
					RDMApi.freeze1 = 6;
					RDMApi.freeze2 = 6;
					RDMApi.freeze3 = 6;
					RDMApi.freeze4 = 6;
					Spawn.tpSpawn(p);
					return;
				}
			}
		}
	}

	public static boolean ganhou() {
		if (iniciado == true) {
			if ((duel1.isEmpty()) && (duel2.isEmpty()) && (duel3.isEmpty()) && duel4.isEmpty()) {
				if (inRDM.size() == 1) {
					return true;
				}
			}
		}
		return false;
	}

	public static void anuncioRDM() {
		Bukkit.broadcastMessage(prefix + "§fEvento §cRDM §finiciando, caso encontre um bug, contate um §cADM§f!");
		Bukkit.broadcastMessage(prefix + "§fPara entrar digite §c/RDM §fentrar. Infos: §c/RDM info§f.");
		Bukkit.broadcastMessage(prefix + "§fNo momento: §c" + inRDM.size() + "/" + max + "§f.");
		Bukkit.broadcastMessage(
				prefix + "§fNecessario §c" + Integer.valueOf(necessario + 1) + " §fPlayers para iniciar!");
		Bukkit.broadcastMessage(prefix + "§fTempo para iniciar: §c" + tempo + " segundos§f.");
	}

	public static void anuncioRDM2() {
		Bukkit.broadcastMessage(prefix + "§fEvento §cRDM §finiciando, caso encontre um bug, contate um §cADM§f!");
		Bukkit.broadcastMessage(prefix + "§fPara entrar digite §c/RDM §fentrar. Infos: §c/RDM info§f.");
		Bukkit.broadcastMessage(
				prefix + "§fo momento: §c" + inRDM.size() + "/" + max + "§f. §fInicia em: §c" + tempo + "s§f.");
	}

	public static void anuncioRDM3() {
		Bukkit.broadcastMessage(
				prefix + "§fEvento §cRDM §fira iniciar em §c" + tempo + "s§f. §c" + inRDM.size() + "/" + max + "§f.");
	}

	public static void anuncioRDMreset() {
		Bukkit.broadcastMessage(prefix + "§fEvento §cRDM §fresetado para §c200s §fpor §cPlayers insuficientes§f!");
	}

	public static void darItens(Player p) {
		p.getInventory().clear();
		p.getInventory().setArmorContents(null);
		p.setHealth(20);
		p.setGameMode(GameMode.SURVIVAL);
		ItemStack sopa = new ItemStack(Material.MUSHROOM_SOUP);
		ItemMeta sopa2 = sopa.getItemMeta();
		sopa2.setDisplayName("Sopa");
		sopa.setItemMeta(sopa2);
		p.getInventory().setHelmet(new ItemStack(Material.IRON_HELMET));
		p.getInventory().setBoots(new ItemStack(Material.LEATHER_BOOTS));

		ItemStack espada = new ItemStack(Material.STONE_SWORD);
		ItemMeta espada2 = espada.getItemMeta();
		espada2.setDisplayName("§bEspada");
		espada.setItemMeta(espada2);
		p.getInventory().setItem(0, espada);
		//Score2.createScoreboard(p);
		for (int i = 1; i < 36; i++) {
			p.getInventory().setItem(i, sopa);
		}

	}

	public static void sairdoEvento(Player p) {
		API.clearPlayer(p);
		p.getInventory().clear();
		
		ItemStack espada = new ItemStack(Material.MAGMA_CREAM);
		ItemMeta espada2 = espada.getItemMeta();
		espada2.setDisplayName("§bSair do Evento");
		espada.setItemMeta(espada2);

		ItemStack item = new ItemStack(Material.SKULL_ITEM, 1, (byte) SkullType.PLAYER.ordinal());
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName("§aInfos §cRDM");
		item.setItemMeta(meta);

		ItemStack item2 = item;
		SkullMeta meta2 = (SkullMeta) item.getItemMeta();
		meta2.setOwner(p.getName());
		item2.setItemMeta(meta2);
		
		p.getInventory().setItem(4, item2);
		p.getInventory().setItem(8, espada);

	}
	
	public static void InfosRDM(Player p) {
		API.clearPlayer(p);
		p.getInventory().clear();
		
		ItemStack espada = new ItemStack(Material.MAGMA_CREAM);
		ItemMeta espada2 = espada.getItemMeta();
		espada2.setDisplayName("§bSair do Evento");
		espada.setItemMeta(espada2);

		ItemStack item = new ItemStack(Material.SKULL_ITEM, 1, (byte) SkullType.PLAYER.ordinal());
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName("§aInfos §cRDM");
		item.setItemMeta(meta);

		ItemStack item2 = item;
		SkullMeta meta2 = (SkullMeta) item.getItemMeta();
		meta2.setOwner(p.getName());
		item2.setItemMeta(meta2);
		
		p.getInventory().setItem(4, item2);
		p.getInventory().setItem(8, espada);

	}
}
