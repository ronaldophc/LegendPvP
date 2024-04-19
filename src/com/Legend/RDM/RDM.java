package com.Legend.RDM;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.Legend.Main;
import com.Legend.guis.Title;
import com.Legend.kits.manager.Base;
import com.Legend.warps.WarpAPI;

public class RDM implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if (!(sender instanceof Player)) {
			return true;
		}
		Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("rdm")) {
			if (args.length == 0) {
				p.sendMessage(Base.prefix + "§bUse §f/rdm <entrar,spec,info,status,premios>§b.");
			} else if (args.length == 1) {
				if (args[0].equalsIgnoreCase("info")) {
					if (RDMApi.emduel == true) {
						p.sendMessage(RDMApi.prefix + "§2§lEstá acontecendo agora.");
					} else if (RDMApi.iniciado == true) {
						p.sendMessage(RDMApi.prefix + "§2§lEstá iniciando agora.");
					} else {
						p.sendMessage(RDMApi.prefix + "§c§lNão está acontecendo agora.");
					}
					p.sendMessage(
							RDMApi.prefix + "Evento TOTALMENTE automatico, caso encontre um bug, contate um §cADM§f!");
					p.sendMessage(RDMApi.prefix + "Para entrar digite §c/RDM entrar §fou para assistir §c/RDM spec§f.");
					p.sendMessage(RDMApi.prefix + "São duelos §c1x1§f, até sobrar apenas §c1 Jogador§f.");
					p.sendMessage(RDMApi.prefix + "Premios: §c/RDM premios§f.");
					p.sendMessage(RDMApi.prefix + "Status: §c/RDM status§f.");
				}
				if (args[0].equalsIgnoreCase("premios")) {
					p.sendMessage(RDMApi.prefix + "§b1º Lugar: §aR$500.");
					p.sendMessage(RDMApi.prefix + "§b2º Lugar: §aR$250.");
					p.sendMessage(RDMApi.prefix + "§b3º Lugar: §aR$150.");
					p.sendMessage(RDMApi.prefix + "§bA cada duelo: §aR$50.");
				}
				if (args[0].equalsIgnoreCase("status")) {
					p.sendMessage("§f--------§bSTATUS RDM§f---------");
					p.sendMessage("§f| §bKills: §c" + RDMStatus.getkills(p));
					p.sendMessage("§f| §bPerdeu: §c" + RDMStatus.getperdeu(p));
					p.sendMessage("§f| §bWins: §c" + RDMStatus.getwins(p));
					p.sendMessage("§f-------§bLegendPvP§f-------");
				}
				if (args[0].equalsIgnoreCase("entrar")) {
					if (RDMApi.iniciado == false) {
						p.sendMessage(Base.prefix + "§7O Evento §aRDM §7não está acontecendo!");
						return true;
					}
					if (RDMApi.emduel == true) {
						p.sendMessage(Base.prefix + "§7O Evento §aRDM §7já iniciou!");
						return true;
					}
					if (RDMApi.inRDM.size() >= RDMApi.max) {
						p.sendMessage(Base.prefix + "§7O Evento §aRDM §7já está lotado!");
						return true;
					}
					if (RDMApi.inRDM.contains(p)) {
						p.sendMessage(Base.prefix + "§7Você já esta no Evento §aRDM§7!");
						return true;
					}
					if (Base.temKit(p)) {
						p.sendMessage(Base.prefix + "§7Você não pode entrar no Evento com um §bKit§7!");
						p.sendMessage(Base.prefix + "§7Use §b/Spawn §7antes de entrar no Evento!");
						return true;
					}
					if (Main.rdm.getConfig().getString(String.valueOf(p.getName()) + ".UUID") == null) {
						Main.rdm.getConfig().set(String.valueOf(p.getName()) + ".UUID", p.getUniqueId().toString());
						Main.rdm.getConfig().set(String.valueOf(p.getName()) + ".Kills", Integer.valueOf(0));
						Main.rdm.getConfig().set(String.valueOf(p.getName()) + ".Perdeu", Integer.valueOf(0));
						Main.rdm.getConfig().set(String.valueOf(p.getName()) + ".Wins", Integer.valueOf(0));
						Main.rdm.save();
					}
					if (!(RDMApi.inRDM.contains(p))) {
						RDMApi.inRDM.add(p);
						RDMApi.inFila.add(p);
						RDMApi.sairdoEvento(p);
						for (Player f : Bukkit.getOnlinePlayers()) {
							if (RDMApi.inRDM.contains(f)) {
								f.sendMessage(RDMApi.prefix + "§c" + p.getName() + " §fentrou no §cEvento "
										+ RDMApi.inRDM.size() + "/" + RDMApi.max + "§f.");
							}
						}
						p.teleport(WarpAPI.getLocation("rdm.lobby"));
						Base.setarKit(p, "RDM");
						p.sendMessage(Base.prefix + "§7Você entrou no Evento §aRDM, §7espere o inicio!");

					}
				} else if (args[0].equalsIgnoreCase("sair")) {
					if (RDMApi.inSpec.contains(p)) {
						Base.tirarKit(p);
						RDMApi.inSpec.remove(p);
						Title.sendActionBar(p, "§6Você esta indo para o Spawn");
						p.chat("/spawn");
						return true;
					}
					if (!(RDMApi.inRDM.contains(p))) {
						p.sendMessage(Base.prefix + "§7Você não esta no Evento §aRDM§7!");
						return true;
					}
					if (RDMApi.inRDM.contains(p)) {
						if (RDMApi.emduel == true) {
							p.sendMessage(RDMApi.prefix + "Você não pode sair durante o Evento");
							return true;
						}
						RDMApi.inRDM.remove(p);
						RDMApi.inFila.remove(p);
						RDMApi.inSpec.remove(p);
						p.chat("/spawn");
						Title.sendActionBar(p, "§6Você esta indo para o Spawn");
						p.sendMessage(Base.prefix + "§bVocê saiu do Evento §aRDM§7!");

					}
				} else if (args[0].equalsIgnoreCase("spec")) {
					if (RDMApi.inRDM.contains(p)) {
						p.sendMessage(Base.prefix + "§bVocê está participando do Evento §aRDM§7!");
						return true;
					}
					if (Base.temKit(p) == false || Base.qualKit(p) == "Nenhum") {
						p.teleport(WarpAPI.getLocation("rdm.lobby"));
						p.sendMessage(Base.prefix + "§7Você está spectando o Evento §cRDM§7!");
						Base.setarKit(p, "SpecRDM");
						RDMApi.sairdoEvento(p);
						RDMApi.inSpec.add(p);
					} else {
						p.sendMessage(Base.prefix + "§bVocê não pode entrar assistir um Evento com §cKit§7!");
						return true;
					}
				} else if (args[0].equalsIgnoreCase("iniciar")) {
					if (p.hasPermission("legend.rdm")) {
						if (RDMApi.emduel == true) {
							p.sendMessage(Base.prefix + "§bO Evento ja iniciou!");
							return true;
						}
						if (RDMApi.iniciado == false) {
							RDMApi.iniciarRDM();
						} else if (RDMApi.iniciado == true) {
							p.sendMessage(Base.prefix + "§7O Evento §aRDM §7já esta acontecendo!");
							return true;
						}
					}
				} else if (args[0].equalsIgnoreCase("force")) {
					if (p.hasPermission("legend.rdm.force")) {
						if (RDMApi.iniciado == true) {
							RDMApi.tempo = 15;
							Bukkit.broadcastMessage(RDMApi.prefix + "§fTempo do evento §cRDM §fmodificado para §c"
									+ RDMApi.tempo + " §fpor um §cADM§f!");
							Bukkit.broadcastMessage(RDMApi.prefix + "§fPara entrar digite §c/RDM §fentrar.");
							Bukkit.broadcastMessage(RDMApi.prefix + "§fNo momento: §c" + RDMApi.inRDM.size() + "/"
									+ RDMApi.max + "§f. §fInicia em: §c" + RDMApi.tempo + "s§f.");
							return true;
						} else if (RDMApi.iniciado == false) {
							p.sendMessage(Base.prefix + "§7O Evento §aRDM §7não está iniciando!");
							return true;
						}
					}
				} else if (args[0].equalsIgnoreCase("clear")) {
					if (p.hasPermission("legend.rdm.clear")) {
						RDMApi.tempo = 305;
						RDMApi.inDuelo.clear();
						RDMApi.inRDM.clear();
						RDMApi.inFila.clear();
						RDMApi.duel1.clear();
						RDMApi.duel2.clear();
						RDMApi.duel3.clear();
						RDMApi.duel4.clear();
						RDMApi.duel5.clear();
						RDMApi.cd1 = 65;
						RDMApi.cd2 = 65;
						RDMApi.cd3 = 65;
						RDMApi.cd4 = 65;
						RDMApi.cd5 = 65;
						RDMApi.cda = 65;
						RDMApi.iniciado = false;
						RDMApi.emduel = false;
						RDMApi.tentativas = 0;
						RDMApi.freeze1 = 6;
						RDMApi.freeze2 = 6;
						RDMApi.freeze3 = 6;
						RDMApi.freeze4 = 6;
						RDMApi.freeze5 = 6;
						p.sendMessage(RDMApi.prefix + "Evento RDM resetado totalmente.");

					}
				}
			} else if (args.length == 2) {
				if (args[0].equalsIgnoreCase("status")) {
					String t = args[1];
					if (Main.rdm.getConfig().get(String.valueOf(t)) == null) {
						p.sendMessage(RDMApi.prefix + "Esse jogador nunca participou do §cEvento RDM§f.");
						return true;
					}
					Player a = Bukkit.getPlayer(t);
					p.sendMessage("§f--------§bSTATUS RDM§f---------");
					p.sendMessage("§f| §bKills: §c" + RDMStatus.getkills(a));
					p.sendMessage("§f| §bPerdeu: §c" + RDMStatus.getperdeu(a));
					p.sendMessage("§f| §bWins: §c" + RDMStatus.getwins(a));
					p.sendMessage("§f-------§bLegendPvP§f-------");
				}
			}
		} else if (cmd.getName().equalsIgnoreCase("setrdm")) {
			if (args.length == 0) {
				p.sendMessage(Base.prefix + "§bUse §f/setrdm <lobby,arena1,2,3,4,5> <pos1,pos2>§b.");
			} else if (args.length == 1) {
				if (p.hasPermission("legend.rdm")) {
					if (args[0].equalsIgnoreCase("lobby")) {
						WarpAPI.setLocation(p.getLocation(), "rdm.lobby");
						p.sendMessage(Base.prefix + "§7A §alobby §7da §aRDM §7foi setada com sucesso!");
					}
				}
			} else if (args.length == 2) {
				if (args[0].equalsIgnoreCase("arena1")) {
					if (args[1].equalsIgnoreCase("pos1")) {
						WarpAPI.setLocation(p.getLocation(), "rdm.arena1.pos1");
						p.sendMessage(Base.prefix + "§7A §apos1 §7da §aArena1 §aRDM §7foi setada com sucesso!");
					} else if (args[1].equalsIgnoreCase("pos2")) {
						WarpAPI.setLocation(p.getLocation(), "rdm.arena1.pos2");
						p.sendMessage(Base.prefix + "§7A §apos2 §7da §aArena1 RDM §7foi setada com sucesso!");
					}
				} else if (args[0].equalsIgnoreCase("arena2")) {
					if (args[1].equalsIgnoreCase("pos1")) {
						WarpAPI.setLocation(p.getLocation(), "rdm.arena2.pos1");
						p.sendMessage(Base.prefix + "§7A §apos1 §7da §aArena2 §aRDM §7foi setada com sucesso!");
					} else if (args[1].equalsIgnoreCase("pos2")) {
						WarpAPI.setLocation(p.getLocation(), "rdm.arena2.pos2");
						p.sendMessage(Base.prefix + "§7A §apos2 §7da §aArena2 RDM §7foi setada com sucesso!");
					}
				} else if (args[0].equalsIgnoreCase("arena3")) {
					if (args[1].equalsIgnoreCase("pos1")) {
						WarpAPI.setLocation(p.getLocation(), "rdm.arena3.pos1");
						p.sendMessage(Base.prefix + "§7A §apos1 §7da §aArena3 §aRDM §7foi setada com sucesso!");
					} else if (args[1].equalsIgnoreCase("pos2")) {
						WarpAPI.setLocation(p.getLocation(), "rdm.arena3.pos2");
						p.sendMessage(Base.prefix + "§7A §apos2 §7da §aArena3 RDM §7foi setada com sucesso!");
					}
				} else if (args[0].equalsIgnoreCase("arena4")) {
					if (args[1].equalsIgnoreCase("pos1")) {
						WarpAPI.setLocation(p.getLocation(), "rdm.arena4.pos1");
						p.sendMessage(Base.prefix + "§7A §apos1 §7da §aArena4 §aRDM §7foi setada com sucesso!");
					} else if (args[1].equalsIgnoreCase("pos2")) {
						WarpAPI.setLocation(p.getLocation(), "rdm.arena4.pos2");
						p.sendMessage(Base.prefix + "§7A §apos2 §7da §aArena4 RDM §7foi setada com sucesso!");
					}
				} else if (args[0].equalsIgnoreCase("arena5")) {
					if (args[1].equalsIgnoreCase("pos1")) {
						WarpAPI.setLocation(p.getLocation(), "rdm.arena5.pos1");
						p.sendMessage(Base.prefix + "§7A §apos1 §7da §aArena5 §aRDM §7foi setada com sucesso!");
					} else if (args[1].equalsIgnoreCase("pos2")) {
						WarpAPI.setLocation(p.getLocation(), "rdm.arena5.pos2");
						p.sendMessage(Base.prefix + "§7A §apos2 §7da §aArena5 RDM §7foi setada com sucesso!");
					}
				}
			}

		}

		return false;
	}

}
