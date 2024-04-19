package com.Legend.Comandos;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.scheduler.BukkitRunnable;

import com.Legend.Main;
import com.Legend.KD.API;
import com.Legend.kits.manager.Base;
import com.Legend.register.APIr;

public class Chat implements CommandExecutor, Listener {

	public static List<Player> cd = new ArrayList<>();

	public boolean onCommand(CommandSender Sender, Command Cmd, String Label, String[] Args) {
		if (Label.equalsIgnoreCase("discord")) {
			Sender.sendMessage(Base.prefix + "§a§lLink do §c§lDiscord: §fdiscord.gg/WPEh5UGSh2");
		}
		if (Label.equalsIgnoreCase("cc")) {
			if (!Sender.hasPermission("legend.cc")) {
				Sender.sendMessage(Base.prefix + "§bVocê não tem permissão para excutar este comando!");
				return true;
			}
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("§b-----------------------------");
			Bukkit.broadcastMessage("§b  Chat Limpo por um ADM");
			Bukkit.broadcastMessage("§b-----------------------------");
		}
		return false;
	}

	@EventHandler
	public void ChatFormat(AsyncPlayerChatEvent e) {
		Player p = e.getPlayer();
		if (e.getMessage().contains("com br") || e.getMessage().contains("com,br") || e.getMessage().contains(",com")
				|| e.getMessage().contains("novo kitpvp") || e.getMessage().contains("novo kit pvp")) {
			if (!(p.hasPermission("legend.chat"))) {
				e.setCancelled(true);
			}
		}
		if (!e.getMessage().contains("legend.pvp.host") && !e.getMessage().contains("legendpvp.com.br")) {
			if (e.getMessage().contains(".")) {
				if (!(p.hasPermission("legend.chat"))) {
					e.setCancelled(true);
				}
			}
		}
		if (!(APIr.logado.contains(p.getName()))) {
			e.setCancelled(true);
		}
		if (Mute.tamutado(p.getName())) {
			p.sendMessage(Base.prefix + "§c§lVocê está mutado!");
			e.setCancelled(true);
		}
		if (Mute.mutas.contains(p.getName())) {
			p.sendMessage(Base.prefix + "§c§lVocê está mutado temporariamente!");
			e.setCancelled(true);
		}
		if (cd.contains(p)) {
			p.sendMessage(Base.prefix + "§cEspere um pouco para mandar outra mensagem!");
			e.setCancelled(true);
			return;
		}
		if (!(p.hasPermission("legend.flood"))) {
			cd.add(p);
			new BukkitRunnable() {

				@Override
				public void run() {
					cd.remove(p);

				}
			}.runTaskLater(Main.plugin, 2 * 20);
		}
		List<String> blo = new ArrayList<String>();
		blo.add("chato do krl".toLowerCase());
		blo.add("burro do krl".toLowerCase());
		blo.add("arrombado".toLowerCase());
		blo.add("filha da puta".toLowerCase());
		blo.add("puta que pariu".toLowerCase());
		blo.add("muleke do caralho".toLowerCase());
		blo.add("muleke do karalho".toLowerCase());
		blo.add("mongoloide".toLowerCase());
		blo.add("obeso".toLowerCase());
		blo.add("comi tua mae".toLowerCase());
		blo.add("Xota".toLowerCase());
		blo.add("Xochota".toLowerCase());
		blo.add("Xoxota".toLowerCase());
		blo.add("Xana".toLowerCase());
		blo.add("Xaninha".toLowerCase());
		blo.add("ANUS".toLowerCase());
		blo.add("Punheta".toLowerCase());
		blo.add("Puto".toLowerCase());
		blo.add("Rabao".toLowerCase());
		blo.add("Rabuda".toLowerCase());
		blo.add("Rabudao".toLowerCase());
		blo.add("Rabudo".toLowerCase());
		blo.add("Retardado".toLowerCase());
		blo.add("Retardada".toLowerCase());
		blo.add("Ridícula".toLowerCase());
		blo.add("Rola".toLowerCase());
		blo.add("Sapatao".toLowerCase());
		blo.add("Siririca".toLowerCase());
		blo.add("Tezao".toLowerCase());
		blo.add("Tesao".toLowerCase());
		blo.add("Tezudo".toLowerCase());
		blo.add("Tezuda".toLowerCase());
		blo.add("Trouxa".toLowerCase());
		blo.add("Troxa".toLowerCase());
		blo.add("Vaca".toLowerCase());
		blo.add("Vagabunda".toLowerCase());
		blo.add("Vagabundo".toLowerCase());
		blo.add("Vagina".toLowerCase());
		blo.add("Viada".toLowerCase());
		blo.add("Víado".toLowerCase());
		blo.add("Veado".toLowerCase());
		blo.add("Veadao".toLowerCase());
		blo.add("Xerereca".toLowerCase());
		blo.add("Xexeca".toLowerCase());
		blo.add("Iscroto".toLowerCase());
		blo.add("Iscrota".toLowerCase());
		blo.add("Leprosa".toLowerCase());
		blo.add("Corna".toLowerCase());
		blo.add("Corno".toLowerCase());
		blo.add("Cornuda".toLowerCase());
		blo.add("Cornudo".toLowerCase());
		blo.add("Cuzao".toLowerCase());
		blo.add("Debil".toLowerCase());
		blo.add("Debiloide".toLowerCase());
		blo.add("Leproso".toLowerCase());
		blo.add("Macaca".toLowerCase());
		blo.add("Macaco".toLowerCase());
		blo.add("Masturba".toLowerCase());
		blo.add("Masturbar".toLowerCase());
		blo.add("Mocrea".toLowerCase());
		blo.add("Mocreia".toLowerCase());
		blo.add("Otaria".toLowerCase());
		blo.add("Otario".toLowerCase());
		blo.add("Pau".toLowerCase());
		blo.add("Pênis".toLowerCase());
		blo.add("Penis".toLowerCase());
		blo.add("Perereca".toLowerCase());
		blo.add("Pica".toLowerCase());
		blo.add("Picao".toLowerCase());
		blo.add("Piroca".toLowerCase());
		blo.add("Bronha".toLowerCase());
		blo.add("Buceta".toLowerCase());
		blo.add("Bunduda".toLowerCase());
		blo.add("Burra".toLowerCase());
		blo.add("Burro".toLowerCase());
		blo.add("Busseta".toLowerCase());
		blo.add("Cadela".toLowerCase());
		blo.add("Cachorra".toLowerCase());
		blo.add("Cachorro".toLowerCase());
		blo.add("Canalha".toLowerCase());
		blo.add("Canalho".toLowerCase());
		blo.add("Checheca".toLowerCase());
		blo.add("Chereca".toLowerCase());
		blo.add("Chota".toLowerCase());
		blo.add("Cocaina".toLowerCase());
		blo.add("Corno".toLowerCase());
		blo.add("Escrota".toLowerCase());
		blo.add("Escroto".toLowerCase());
		blo.add("Estupida".toLowerCase());
		blo.add("Estupido".toLowerCase());
		blo.add("Gay".toLowerCase());
		blo.add("Idiota".toLowerCase());
		blo.add("Imbecil".toLowerCase());
		blo.add("Bicha".toLowerCase());
		blo.add("Buceta".toLowerCase());
		blo.add("Bosta".toLowerCase());
		blo.add("Foder".toLowerCase());
		blo.add("Puta".toLowerCase());
		blo.add("Merda".toLowerCase());
		blo.add("Viado".toLowerCase());
		blo.add("Babaca".toLowerCase());
		blo.add("Baitola".toLowerCase());
		blo.add("Bicha".toLowerCase());
		blo.add("Bixa".toLowerCase());
		blo.add("Boceta".toLowerCase());
		blo.add("Boquete".toLowerCase());
		blo.add("Bolcat".toLowerCase());
		blo.add("Bosseta".toLowerCase());
		for (String bloq : blo) {
			e.setMessage(e.getMessage().replaceAll(bloq, "*****"));
		}
		if (Tag.getTag(p).equals("Dono")) {
			p.setDisplayName("§f§4§lDono§f " + p.getName());
		} else if (Tag.getTag(p).equals("Dev")) {
			p.setDisplayName("§f§b§lDev§f " + p.getName());
		} else if (Tag.getTag(p).equals("Admin")) {
			p.setDisplayName("§f§c§lAdmin§f " + p.getName());
		} else if (Tag.getTag(p).equalsIgnoreCase("Mod")) {
			p.setDisplayName("§f§5§lMod§f " + p.getName());
		} else if (Tag.getTag(p).equalsIgnoreCase("Beta")) {
			p.setDisplayName("§f§2§lBeta§f " + p.getName());
		} else if (Tag.getTag(p).equalsIgnoreCase("Helper")) {
			p.setDisplayName("§f§d§lHelper§f " + p.getName());
		} else if (Tag.getTag(p).equalsIgnoreCase("Builder")) {
			p.setDisplayName("§f§9§lBuilder§f " + p.getName());
		} else if (Tag.getTag(p).equalsIgnoreCase("Streamer")) {
			p.setDisplayName("§f§3§lStreamer§f " + p.getName());
		} else if (Tag.getTag(p).equalsIgnoreCase("Yt")) {
			p.setDisplayName("§f§a§lYT§f " + p.getName());
		} else if (Tag.getTag(p).equalsIgnoreCase("Vip")) {
			p.setDisplayName("§f§6§lVip§f " + p.getName());
		} else {
			p.setDisplayName("§7" + p.getName());
		}
		if (p.hasPermission("legend.color")) {
			if (p.hasPermission("legend.lowercase")) {
				e.setFormat(String.valueOf("§f(" + API.getRankSymbol(p) + "§f) " + p.getDisplayName() + "§b" + " >> "
						+ "§f" + e.getMessage().replaceAll("&", "§").replaceAll("%", "%%")));
			} else {
				e.setFormat(String.valueOf("§f(" + API.getRankSymbol(p) + "§f) " + p.getDisplayName() + "§b" + " >> "
						+ "§f" + e.getMessage().toLowerCase().replaceAll("&", "§").replaceAll("%", "%%")));
			}
		} else {
			if (p.hasPermission("legend.lowercase")) {
				e.setFormat(String.valueOf("§f(" + API.getRankSymbol(p) + "§f) " + p.getDisplayName() + "§b" + " >> "
						+ "§f" + e.getMessage().replaceAll("%", "%%")));
			} else {
				e.setFormat(String.valueOf("§f(" + API.getRankSymbol(p) + "§f) " + p.getDisplayName() + "§b" + " >> "
						+ "§f" + e.getMessage().toLowerCase().replaceAll("%", "%%")));
			}
		}
	}
}