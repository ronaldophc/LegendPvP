package com.Legend.Comandos;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import com.Legend.kits.manager.Base;
import com.Legend.screenshare.ScreenShareAPI;
import com.Legend.warps.WarpAPI;

public class ScreenShare implements Listener, CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!(sender instanceof Player)) {
			return true;
		}
		Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("ss")) {
			if (p.hasPermission("legend.ss")) {
				if (args.length == 0) {
					p.sendMessage(Base.prefix + "�bUse �f/ss <list, verificar, terminar>�b.");
				}
				if (args.length == 1) {
					if (args[0].equalsIgnoreCase("set")) {
						WarpAPI.setLocation(p.getLocation(), "ss");
						p.sendMessage(Base.prefix + "�aJaula �7definida com sucesso.");
					}
					if (args[0].equalsIgnoreCase("verificar")) {
						p.sendMessage(Base.prefix + "�bUse �f/ss <verificar> <player>�b.");
					}
					if (args[0].equalsIgnoreCase("terminar")) {
						WarpAPI.setLocation(p.getLocation(), "ss");
						p.sendMessage(Base.prefix + "�bUse �f/ss <terminar> <player>�b.");
					}
					if (args[0].equalsIgnoreCase("list")) {
						String telando = "";
						p.sendMessage(" ");
						p.sendMessage("�f�l----------------------");
						if (!ScreenShareAPI.getList().isEmpty()) {
							for (ScreenShareAPI ss : ScreenShareAPI.getList()) {
								if (telando.isEmpty()) {
									telando += "�bTelando: �cStaff: �f" + ss.getAdmin().getName()
											+ " �a- �bSuspeito: �f" + ss.getTelado().getName();
								} else {
									telando += "\n�bTelando: �cStaff: �f " + ss.getAdmin().getName()
											+ " �a- �bSuspeito: �f" + ss.getTelado().getName();
								}
							}
						} else {
							telando = "�cN�o h� ningu�m sendo telado.";
						}
						p.sendMessage(telando);
						p.sendMessage("�f�l----------------------");
						p.sendMessage(" ");
					}
				}
				if (args.length == 2) {
					if (args[0].equalsIgnoreCase("terminar")) {
						Player t = Bukkit.getPlayer(args[1]);
						if (ScreenShareAPI.inTela(p)) {
							if (ScreenShareAPI.inTela(t)) {
								if (!ScreenShareAPI.getList().isEmpty()) {
									for (ScreenShareAPI ss : ScreenShareAPI.getList()) {
										if (ss.getAdmin().equals(p)) {
											if (ss.getTelado().equals(t)) {
												ss.removeSS();
												return true;
											} else {
												p.sendMessage(Base.prefix + "�f" + t.getName()
														+ " �7n�o est� sendo verificado por voc�.");
												return true;
											}
										} else {
											p.sendMessage(Base.prefix + "�7Voc� n�o est� verificando ningu�m.");
										}
									}
								}
							} else {
								p.sendMessage(Base.prefix + "�7Este jogador �cn�o �7est� sendo verificado.");
							}
						} else {
							p.sendMessage(Base.prefix + "�7Voc� �cn�o �7est� telando ningu�m.");
						}
					}
					if (args[0].equalsIgnoreCase("verificar")) {
						Player t = Bukkit.getPlayer(args[1]);
						if (t == null) {
							p.sendMessage(Base.prefix + "�7O jogador est� offline!");
							return true;
						}
						if (t.getName().equals(p.getName())) {
							p.sendMessage(Base.prefix + "�7Voc� n�o pode verificar voc� mesmo.");
							return true;
						}
						if (!ScreenShareAPI.inTela(p)) {
							if (!ScreenShareAPI.inTela(t)) {
								ScreenShareAPI ss = new ScreenShareAPI(p, t);
								if (!ScreenShareAPI.getList().contains(ss)) {
									ss.sendSS();
								} else {
									p.sendMessage(Base.prefix + "�7Este ScreenShare j� foi criado.");
									return true;
								}
							} else {
								p.sendMessage(Base.prefix + "�7Este jogador ja est� sendo verificado.");
							}
						} else {
							p.sendMessage(Base.prefix + "�7Voc� j� est� telando algu�m.");
						}
					}
				}
			}
		}
		return false;
	}

	@EventHandler
	public void Quit(PlayerQuitEvent e) {
		Player p = e.getPlayer();
		for (ScreenShareAPI screen : ScreenShareAPI.getList()) {
			if (screen.getTelado().equals(p)) {
				Player admin = screen.getAdmin();
				screen.removeSS();
				admin.sendMessage(Base.prefix + "�c�l" + p.getName() + " deslogou durante an�lise do ScreenShare.");
				return;
			}
			if (screen.getAdmin().equals(p)) {
				Player telado = screen.getTelado();
				screen.removeSS();
				telado.sendMessage(
						Base.prefix + "�c�lO staff " + p.getName() + " deslogou durante an�lise e voc� foi liberado.");
				return;
			}
		}
	}

	@EventHandler
	public void CMD(PlayerCommandPreprocessEvent e) {
		Player p = e.getPlayer();
		if (ScreenShareAPI.inTela(p)) {
			if (!ScreenShareAPI.getList().isEmpty()) {
				for (ScreenShareAPI screen : ScreenShareAPI.getList()) {
					if (screen.getTelado().equals(p) && ScreenShareAPI.inTela(p)) {
						e.setCancelled(true);
						p.sendMessage(Base.prefix + "�7Voc� n�o pode executar comandos durante o ScreenShare.");
						return;
					}
					if (ScreenShareAPI.inTela(p) && screen.getAdmin().equals(p)) {
						if (e.getMessage().startsWith("/ban") || e.getMessage().startsWith("/ss")) {
							e.setCancelled(false);
						} else {
							p.sendMessage(Base.prefix
									+ "�7Voc� s� pode executar comandos no ScreenShare como: �f/ban e /ss�7.");
							e.setCancelled(true);
						}
					}
				}
			}
		}
	}

	@EventHandler
	public void CheckKillAura(EntityDamageByEntityEvent e) {
		if (e.getEntity() instanceof Player && e.getDamager() instanceof Player) {
			Player t = (Player) e.getDamager();
			for (ScreenShareAPI screen : ScreenShareAPI.getList()) {
				if (screen.getTelado().equals(t) && ScreenShareAPI.inTela(t)
						|| screen.getAdmin().equals(t) && ScreenShareAPI.inTela(t)) {
					e.setDamage(0);
				}
			}
		}
	}
}
