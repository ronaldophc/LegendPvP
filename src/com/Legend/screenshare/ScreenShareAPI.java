package com.Legend.screenshare;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;

import com.Legend.Comandos.Admin;
import com.Legend.kits.manager.Base;
import com.Legend.warps.Spawn;
import com.Legend.warps.WarpAPI;

public class ScreenShareAPI {
	
	Player admin;
	Player telado;
	static List<ScreenShareAPI> ss = new ArrayList<ScreenShareAPI>();
	static HashMap<Player, Player> telando = new HashMap<Player, Player>();
	
	public ScreenShareAPI(Player admin, Player telado) {
		this.admin = admin; 
		this.telado = telado;
	}
	public void sendSS() {
		if (!ss.contains(this)) {
			ss.add(this);
		}
		if (Admin.inadmin.contains(admin)) {
			Admin.inadmin.remove(admin);
		}
		Base.tirarKit(admin);
		Base.tirarKit(telado);
		admin.setGameMode(GameMode.CREATIVE);
		telado.teleport(WarpAPI.getLocation("ss"));
		admin.teleport(telado);
		telando.put(telado, admin);
		telando.put(admin, telado);
		for (Player on : Bukkit.getOnlinePlayers()) {
			on.hidePlayer(admin);
			on.hidePlayer(telado);
			admin.hidePlayer(on);
			telado.hidePlayer(on);
		}
		admin.showPlayer(telado);
		telado.showPlayer(admin);
		telado.sendMessage(" ");
		telado.sendMessage(Base.prefix + "§bVocê foi puxado para análise no ScreenShare.");
		telado.sendMessage(Base.prefix + "§7ScreenShare é apenas feito por §cAdmins §7e §4Donos§7.");
		telado.sendMessage(Base.prefix + "§7Se possivel grave para contestar a decisão.");
		telado.sendMessage(" ");
		admin.sendMessage(" ");
		admin.sendMessage(Base.prefix + "§bPara terminar análise utilize §f/ss terminar§b.");
		admin.sendMessage(Base.prefix + "§7Se possivel grave para evitar problemas.");
		admin.sendMessage(" ");
	}
	public void removeSS() {
		telando.remove(telado);
		telando.remove(admin);
		Admin.Atma(admin);
		Admin.Atma(telado);
		for (Player on : Bukkit.getOnlinePlayers()) {
			telado.showPlayer(on);
			admin.showPlayer(on);
		}
		if (telado != null) {
			Spawn.tpinstaSpawn(telado);
			telado.sendMessage(Base.prefix + "§aVocê foi liberado do ScreenShare.");
		}
		if (admin != null) {
			Spawn.tpinstaSpawn(admin);
		}
		ScreenShareAPI screen = this;
		if (ss.contains(screen)) {
			ss.remove(screen);
		}
		screen = null;
	}
	
	public static List<ScreenShareAPI> getList() {
		return ss;
	}
	public Player getTelado() {
		return this.telado;
	}
	public Player getAdmin() {
		return this.admin;
	}
	public static boolean inTela(Player p) {
		return telando.containsKey(p);
	}
 }
