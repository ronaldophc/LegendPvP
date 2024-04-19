package com.Legend.Comandos;

import java.util.Arrays;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_8_R2.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import com.Legend.Main;
import com.Legend.KD.API;
import com.Legend.guis.Title;
import com.Legend.kits.manager.Base;

import net.minecraft.server.v1_8_R2.PacketPlayOutChat;
import net.minecraft.server.v1_8_R2.PlayerConnection;
import net.minecraft.server.v1_8_R2.IChatBaseComponent.ChatSerializer;

public class Report implements Listener, CommandExecutor {

	public static HashMap<String, String> save = new HashMap<>();

	public String Mensagem(String[] args) {
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < args.length; i++) {
			sb.append(args[i]).append(" ");
		}
		return sb.toString();
	}

	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if (!(sender instanceof Player)) {
			return true;
		}
		Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("guihack")) {
			guiHack(p);
		} else if (cmd.getName().equalsIgnoreCase("guichat")) {
			guichat(p);
		} else if (cmd.getName().equalsIgnoreCase("guifreekill")) {
			guiFreeKill(p);
		} else if (cmd.getName().equalsIgnoreCase("guibugs")) {
			guiAbuse(p);
		} else if (cmd.getName().equalsIgnoreCase("reports")) {
			if (p.hasPermission("legend.report")) {
				guireports(p);
			}
		}
		if (cmd.getName().equalsIgnoreCase("report")) {
			if (args.length >= 1) {
				p.sendMessage(Base.prefix + "§bUse: §f/report§b.");
			} else if (args.length == 0) {
				p.sendMessage(Base.prefix + "§bLista de motivos para Reportar: §a(Clique no motivo)");
				PlayerConnection con = ((CraftPlayer) p).getHandle().playerConnection;
				PacketPlayOutChat packet = new PacketPlayOutChat(ChatSerializer.a(
						"{\"text\":\"Hack\",\"italic\":true,\"color\":\"aqua\",\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/guihack\"},\"hoverEvent\":{\"action\":\"show_text\",\"value\":[{\"text\":\"Denuncie um Hack!\",\"bold\":true,\"color\":\"dark_red\"}]}}"));
				con.sendPacket(packet);
				PacketPlayOutChat packet1 = new PacketPlayOutChat(ChatSerializer.a(
						"{\"text\":\"Chat Abuse\",\"italic\":true,\"color\":\"aqua\",\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/guichat\"},\"hoverEvent\":{\"action\":\"show_text\",\"value\":[{\"text\":\"Denuncie um jogador por Chat abuse(Ofensa, ameaça, envio de links etc..)!\",\"bold\":true,\"color\":\"dark_red\"}]}}"));
				con.sendPacket(packet1);
				PacketPlayOutChat packet2 = new PacketPlayOutChat(ChatSerializer.a(
						"{\"text\":\"Free Kill\",\"italic\":true,\"color\":\"aqua\",\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/guifreekill\"},\"hoverEvent\":{\"action\":\"show_text\",\"value\":[{\"text\":\"Denuncie um jogador por FreeKill!\",\"bold\":true,\"color\":\"dark_red\"}]}}"));
				con.sendPacket(packet2);
				PacketPlayOutChat packet3 = new PacketPlayOutChat(ChatSerializer.a(
						"{\"text\":\"Abuso de Bugs\",\"italic\":true,\"color\":\"aqua\",\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/guibugs\"},\"hoverEvent\":{\"action\":\"show_text\",\"value\":[{\"text\":\"Denuncie um jogador por Abusar de Bugs!\",\"bold\":true,\"color\":\"dark_red\"}]}}"));
				con.sendPacket(packet3);
				p.sendMessage("§cSe achar que esteja faltando algum motivo contate um Staff!");
				return true;
			}
		}
		if (cmd.getName().equalsIgnoreCase("responder")) {
			if (p.hasPermission("legend.responder")) {
				if (args.length == 0) {
					p.sendMessage(Base.prefix + "§bUse: §f/responder <player> <resposta>§b.");
					return true;
				} else if (args.length > 0) {
					String reportado = new String(args[0]);
					String mensagem = Mensagem(args);
					Player players = Bukkit.getPlayer(reportado);
					players.sendMessage("---------------§b§LMensagem recebida§f---------------");
					players.sendMessage("\n      §b Você recebeu uma mensagem de um §cADM§b.");
					players.sendMessage("  §f>>  §b" + mensagem);
					players.sendMessage("\n---------------§b§LMensagem recebida§f---------------");

					p.sendMessage(Base.prefix + "§bVocê respondeu §f" + players.getName() + "§b!");
				}
			}
		}
		return true;
	}

	private void guireports(Player p) {
		Inventory gui = Bukkit.createInventory(p, 54, "§bReports recebidos");
		for (Player on : Bukkit.getOnlinePlayers()) {
			if (save.containsKey(on.getName()) || save.containsValue(on.getName())) {
				ItemStack item = new ItemStack(Material.SKULL_ITEM, 1, (byte) 3);
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName(on.getName());
				meta.setLore(Arrays.asList(
						new String[] { "§c" + save.get(on.getName()) + "", "", "§fKills: §b" + (API.getkills(on)),
								"§fMortes: §b" + API.getmortes(on), "§fDinheiro: §b" + API.getdinheiro(on),
								"§fRank: §b" + API.getRank(on) + " §f- §b" + API.getpontos(on) + " §fpontos.",
								"§fTop KS: §b" + Main.file.getConfig().getInt(String.valueOf(on) + ".TopKS") }));
				item.setItemMeta(meta);

				ItemStack item2 = item;
				SkullMeta meta2 = (SkullMeta) item.getItemMeta();
				meta2.setOwner(on.getName());
				item2.setItemMeta(meta2);

				gui.addItem(item2);
			}
		}
		gui.setItem(49, API.Item(Material.BARRIER, "§cApagar Report", 1, (byte) 0));
		p.openInventory(gui);
	}

	private void guiHack(Player p) {
		Inventory gui = Bukkit.createInventory(p, 54, "§bSelecione o jogador: §c(Hack)");
		for (Player on : Bukkit.getOnlinePlayers()) {
			if (!(Admin.inadmin.contains(on)) && on.getGameMode() == GameMode.SURVIVAL) {
				ItemStack item = new ItemStack(Material.SKULL_ITEM, 1, (byte) 3);
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName(on.getName());
				item.setItemMeta(meta);

				ItemStack item2 = item;
				SkullMeta meta2 = (SkullMeta) item.getItemMeta();
				meta2.setOwner(on.getName());
				item2.setItemMeta(meta2);

				gui.addItem(item2);
			}
		}
		p.openInventory(gui);
	}

	private void guiFreeKill(Player p) {
		Inventory gui = Bukkit.createInventory(p, 54, "§bSelecione o jogador: §c(FK)");
		for (Player on : Bukkit.getOnlinePlayers()) {
			if (!(Admin.inadmin.contains(on)) && on.getGameMode() == GameMode.SURVIVAL) {
				ItemStack item = new ItemStack(Material.SKULL_ITEM, 1, (byte) 3);
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName(on.getName());
				item.setItemMeta(meta);

				ItemStack item2 = item;
				SkullMeta meta2 = (SkullMeta) item.getItemMeta();
				meta2.setOwner(on.getName());
				item2.setItemMeta(meta2);

				gui.addItem(item2);
			}
		}
		p.openInventory(gui);
	}

	private void guiAbuse(Player p) {
		Inventory gui = Bukkit.createInventory(p, 54, "§bSelecione o jogador: §c(Bugs)");
		for (Player on : Bukkit.getOnlinePlayers()) {
			if (!(Admin.inadmin.contains(on)) && on.getGameMode() == GameMode.SURVIVAL) {
				ItemStack item = new ItemStack(Material.SKULL_ITEM, 1, (byte) 3);
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName(on.getName());
				item.setItemMeta(meta);

				ItemStack item2 = item;
				SkullMeta meta2 = (SkullMeta) item.getItemMeta();
				meta2.setOwner(on.getName());
				item2.setItemMeta(meta2);

				gui.addItem(item2);
			}
		}
		p.openInventory(gui);
	}

	private void guichat(Player p) {
		Inventory gui = Bukkit.createInventory(p, 54, "§bSelecione o jogador: §c(Chat)");
		for (Player on : Bukkit.getOnlinePlayers()) {
			if (!(Admin.inadmin.contains(on)) && on.getGameMode() == GameMode.SURVIVAL) {
				ItemStack item = new ItemStack(Material.SKULL_ITEM, 1, (byte) 3);
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName(on.getName());
				item.setItemMeta(meta);

				ItemStack item2 = item;
				SkullMeta meta2 = (SkullMeta) item.getItemMeta();
				meta2.setOwner(on.getName());
				item2.setItemMeta(meta2);

				gui.addItem(item2);
			}
		}
		p.openInventory(gui);
	}

	@EventHandler
	public void clickInv(InventoryClickEvent e) {
		if (e.getInventory().getName().startsWith("§bReports recebidos")) {
			if (e.getWhoClicked() instanceof Player) {
				e.setCancelled(true);
				if (e.getCurrentItem() == null)
					return;
				if (!(e.getCurrentItem().hasItemMeta())) {
					return;
				}
				if (e.getCurrentItem().getType() == null) {
					return;
				}
				if (e.getCurrentItem() != null && !e.getCurrentItem().getType().equals(Material.AIR)) {
					e.setCancelled(true);
				}
				if (e.getInventory().getItem(0) == null) {
					return;
				}
				if (!e.getInventory().getItem(0).hasItemMeta()) {
					return;
				}
				if (e.getInventory().getItem(0).getType() != Material.SKULL) {
					return;
				}
				if (e.getCurrentItem().getType() == Material.BARRIER) {
					String name = e.getInventory().getItem(0).getItemMeta().getDisplayName().strip();
					save.remove(name);
					save.remove(name, name);
					e.getInventory().setItem(0, new ItemStack(Material.AIR));
				}
			}
		}
		if (e.getInventory().getName().startsWith("§bSelecione o jogador: §c(Chat)")) {
			if (e.getWhoClicked() instanceof Player) {
				Player p = (Player) e.getWhoClicked();
				e.setCancelled(true);
				if (e.getCurrentItem() == null)
					return;
				if (!(e.getCurrentItem().hasItemMeta())) {
					return;
				}
				if (e.getCurrentItem().getType() == null) {
					return;
				}
				if (e.getCurrentItem() != null && !e.getCurrentItem().getType().equals(Material.AIR)) {
					e.setCancelled(true);
				}
				if (e.getCurrentItem().getType() == Material.SKULL_ITEM) {
					p.closeInventory();
					String name = e.getCurrentItem().getItemMeta().getDisplayName();
					if (save.containsKey(name) && save.get(name).contains("Chat")) {
						p.sendMessage(Base.prefix + "§c" + name + " já foi reportado por este motivo!");
						p.closeInventory();
						return;
					}
					p.sendMessage(Base.prefix + "§bReport de " + name + " enviado por Infração no Chat.");
					if (save.containsKey(name) || save.containsValue(name)) {
						save.put(name, "Chat(" + p.getName() + "), " + save.get(name));
					} else {
						save.put(name, "Chat(" + p.getName() + ")");
					}
					for (Player s : Bukkit.getOnlinePlayers()) {
						if (s.hasPermission("legend.report")) {
							s.sendMessage(Base.prefix + "§c§lREPORT RECEBIDO, Use /Reports para ver.");
							Title.sendActionBar(p, "§c§lREPORT RECEBIDO, Use /Reports para ver.");
						}
					}
				}
				e.setCancelled(true);
			}
		}
		if (e.getInventory().getName().startsWith("§bSelecione o jogador: §c(Bugs)")) {
			if (e.getWhoClicked() instanceof Player) {
				Player p = (Player) e.getWhoClicked();
				e.setCancelled(true);
				if (e.getCurrentItem() == null)
					return;
				if (!(e.getCurrentItem().hasItemMeta())) {
					return;
				}
				if (e.getCurrentItem().getType() == null) {
					return;
				}
				if (e.getCurrentItem() != null && !e.getCurrentItem().getType().equals(Material.AIR)) {
					e.setCancelled(true);
				}
				if (e.getCurrentItem().getType() == Material.SKULL_ITEM) {
					p.closeInventory();
					String name = e.getCurrentItem().getItemMeta().getDisplayName();
					if (save.containsKey(name) && save.get(name).contains("Bug")) {
						p.sendMessage(Base.prefix + "§c" + name + " já foi reportado por este motivo!");
						p.closeInventory();
						return;
					}
					p.sendMessage(Base.prefix + "§bReport de " + name + " enviado por Bug Abuse.");
					if (save.containsKey(name) || save.containsValue(name)) {
						save.put(name, "Bug(" + p.getName() + "), " + save.get(name));
					} else {
						save.put(name, "Bug(" + p.getName() + ")");
					}
					for (Player s : Bukkit.getOnlinePlayers()) {
						if (s.hasPermission("legend.report")) {
							s.sendMessage(Base.prefix + "§c§lREPORT RECEBIDO, Use /Reports para ver.");
							Title.sendActionBar(p, "§c§lREPORT RECEBIDO, Use /Reports para ver.");
						}
					}
				}
				e.setCancelled(true);
			}
		}
		if (e.getInventory().getName().startsWith("§bSelecione o jogador: §c(FK)")) {
			if (e.getWhoClicked() instanceof Player) {
				Player p = (Player) e.getWhoClicked();
				e.setCancelled(true);
				if (e.getCurrentItem() == null)
					return;
				if (!(e.getCurrentItem().hasItemMeta())) {
					return;
				}
				if (e.getCurrentItem().getType() == null) {
					return;
				}
				if (e.getCurrentItem() != null && !e.getCurrentItem().getType().equals(Material.AIR)) {
					e.setCancelled(true);
				}

				if (e.getCurrentItem().getType() == Material.SKULL_ITEM) {
					p.closeInventory();
					String name = e.getCurrentItem().getItemMeta().getDisplayName();
					if (save.containsKey(name) && save.get(name).contains("FK")) {
						p.sendMessage(Base.prefix + "§c" + name + " já foi reportado por este motivo!");
						p.closeInventory();
						return;
					}
					p.sendMessage(Base.prefix + "§bReport de " + name + " enviado por Free kill.");
					if (save.containsKey(name) || save.containsValue(name)) {
						save.put(name, "FK(" + p.getName() + "), " + save.get(name));
					} else {
						save.put(name, "FK(" + p.getName() + ")");
					}
					for (Player s : Bukkit.getOnlinePlayers()) {
						if (s.hasPermission("legend.report")) {
							s.sendMessage(Base.prefix + "§c§lREPORT RECEBIDO, Use /Reports para ver.");
							Title.sendActionBar(p, "§c§lREPORT RECEBIDO, Use /Reports para ver.");
						}
					}
				}
				e.setCancelled(true);
			}
		}
		if (e.getInventory().getName().startsWith("§bSelecione o jogador: §c(Hack)")) {
			if (e.getWhoClicked() instanceof Player) {
				Player p = (Player) e.getWhoClicked();
				e.setCancelled(true);
				if (e.getCurrentItem() == null)
					return;
				if (!(e.getCurrentItem().hasItemMeta())) {
					return;
				}
				if (e.getCurrentItem().getType() == null) {
					return;
				}
				if (e.getCurrentItem() != null && !e.getCurrentItem().getType().equals(Material.AIR)) {
					e.setCancelled(true);
				}
				if (e.getCurrentItem().getType() == Material.SKULL_ITEM) {
					p.closeInventory();
					String name = e.getCurrentItem().getItemMeta().getDisplayName();
					if (save.containsKey(name) && save.get(name).contains("Hack")) {
						p.sendMessage(Base.prefix + "§c" + name + " já foi reportado por este motivo!");
						p.closeInventory();
						return;
					}
					p.sendMessage(Base.prefix + "§bReport de " + name + " enviado por Hack.");
					if (save.containsKey(name) || save.containsValue(name)) {
						save.put(name, "Hack(" + p.getName() + "), " + save.get(name));
					} else {
						save.put(name, "Hack(" + p.getName() + ")");
					}
					for (Player s : Bukkit.getOnlinePlayers()) {
						if (s.hasPermission("legend.report")) {
							s.sendMessage(Base.prefix + "§c§lREPORT RECEBIDO, Use /Reports para ver.");
							Title.sendActionBar(p, "§c§lREPORT RECEBIDO, Use /Reports para ver.");
						}
					}
				}
				e.setCancelled(true);
			}
		}
	}
}
