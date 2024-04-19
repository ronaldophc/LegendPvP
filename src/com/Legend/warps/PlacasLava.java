package com.Legend.warps;

import org.bukkit.Material;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.player.PlayerInteractEvent;

import com.Legend.KD.API;
import com.Legend.kits.manager.Base;

public class PlacasLava implements Listener {

	@EventHandler
	public void onSignChange(SignChangeEvent e) {
		if (e.getLine(0).equalsIgnoreCase("Facil")) {
			e.setLine(0, "�b�lLegendPvP");
			e.setLine(1, "�c�lRecompensa");
			e.setLine(2, "�c�lF�cil");
			e.setLine(3, "�c�lClique aqui");
		}
		if (e.getLine(0).equalsIgnoreCase("Medio")) {
			e.setLine(0, "�b�lLegendPvP");
			e.setLine(1, "�c�lRecompensa");
			e.setLine(2, "�c�lM�dio");
			e.setLine(3, "�c�lClique aqui");
		}
		if (e.getLine(0).equalsIgnoreCase("Dificil")) {
			e.setLine(0, "�b�lLegendPvP");
			e.setLine(1, "�c�lRecompensa");
			e.setLine(2, "�c�lDif�cil");
			e.setLine(3, "�c�lClique aqui");
		}
		if (e.getLine(0).equalsIgnoreCase("Extremo")) {
			e.setLine(0, "�b�lLegendPvP");
			e.setLine(1, "�c�lRecompensa");
			e.setLine(2, "�c�lExtremo");
			e.setLine(3, "�c�lClique aqui");
		}
	}

	@EventHandler
	public void inv(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		if ((e.getAction() == Action.RIGHT_CLICK_BLOCK) && (e.getClickedBlock() != null)
				&& ((e.getClickedBlock().getType() == Material.WALL_SIGN)
						|| (e.getClickedBlock().getType() == Material.SIGN_POST))) {
			Sign s = (Sign) e.getClickedBlock().getState();
			String[] lines = s.getLines();
			if ((lines.length > 0) && (lines[0].equals("�b�lLegendPvP"))
			 && (lines.length > 1) && (lines[1].equals("�c�lRecompensa"))
			 && (lines.length > 2) && (lines[2].equals("�c�lF�cil"))
			 && (lines.length > 3) && (lines[3].equals("�c�lClique aqui"))) {
				
				p.sendMessage(Base.prefix + "�cVoce ganhou 150 coins por passar o F�cil.");
				p.sendMessage(Base.prefix + "�cDigite /Spawn se quiser voltar para o spawn.");
				API.setDinheiro(p, 150);
				p.teleport(WarpAPI.getLocation("Lava"));
				
			}
			if ((lines.length > 0) && (lines[0].equals("�b�lLegendPvP"))
			 && (lines.length > 1) && (lines[1].equals("�c�lRecompensa"))
		     && (lines.length > 2) && (lines[2].equals("�c�lM�dio"))
			 && (lines.length > 3) && (lines[3].equals("�c�lClique aqui"))) {
						
				p.sendMessage(Base.prefix + "�cVoce ganhou 300 coins por passar o M�dio.");
				p.sendMessage(Base.prefix + "�cDigite /Spawn se quiser voltar para o spawn.");
				API.setDinheiro(p, 300);
				p.teleport(WarpAPI.getLocation("Lava"));
						
			}
			if ((lines.length > 0) && (lines[0].equals("�b�lLegendPvP"))
					 && (lines.length > 1) && (lines[1].equals("�c�lRecompensa"))
				     && (lines.length > 2) && (lines[2].equals("�c�lDif�cil"))
					 && (lines.length > 3) && (lines[3].equals("�c�lClique aqui"))) {
								
						p.sendMessage(Base.prefix + "�cVoce ganhou 500 coins por passar o Dif�cil.");
						p.sendMessage(Base.prefix + "�cDigite /Spawn se quiser voltar para o spawn.");
						API.setDinheiro(p, 500);
						p.teleport(WarpAPI.getLocation("Lava"));
								
					}
			if ((lines.length > 0) && (lines[0].equals("�b�lLegendPvP"))
					 && (lines.length > 1) && (lines[1].equals("�c�lRecompensa"))
				     && (lines.length > 2) && (lines[2].equals("�c�lExtremo"))
					 && (lines.length > 3) && (lines[3].equals("�c�lClique aqui"))) {
								
						p.sendMessage(Base.prefix + "�cVoce ganhou 800 coins por passar o Extremo.");
						p.sendMessage(Base.prefix + "�cDigite /Spawn se quiser voltar para o spawn.");
						API.setDinheiro(p, 800);
						p.teleport(WarpAPI.getLocation("Lava"));
								
					}
		}
	}
}
