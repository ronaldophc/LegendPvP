package com.Legend.Comandos;

import java.util.HashMap;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;

import com.Legend.kits.manager.Base;

public class sKit implements Listener, CommandExecutor {
	public HashMap<String, ItemStack[]> kits = new HashMap<>();

	public HashMap<String, ItemStack[]> armor = new HashMap<>();

	public boolean isInt(String s) {
		try {
			Integer.parseInt(s);
			return true;
		} catch (NumberFormatException numberFormatException) {
			return false;
		}
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage(Base.prefix + "Somente jogadores podem executar este comando!");
			return true;
		}
		Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("skit") && (p.hasPermission("legend.skit") || p.isOp())) {
			if (args.length == 0) {
				sender.sendMessage(Base.prefix + "§bUse §f/sKit <criar|aplicar> <nome>§b.");
				return true;
			}
			if (args[0].equalsIgnoreCase("criar")) {
				if (args.length == 1) {
					sender.sendMessage(Base.prefix + "§bUse §f/sKit <criar> <nome>§b.");
					return true;
				}
				String name = args[1];
				this.kits.put(name, p.getInventory().getContents());
				this.armor.put(name, p.getInventory().getArmorContents());
				p.sendMessage(Base.prefix + "§fKit §c" + args[1] + " §fcriado com sucesso!");
				return true;
			}
			if (args[0].equalsIgnoreCase("aplicar")) {
				if (args.length <= 2) {
					sender.sendMessage(Base.prefix + "§bUse §f/sKit <aplicar> <nome> <range>§b.");
					return true;
				}
				String name = args[1];
				if (!this.kits.containsKey(name) && !this.armor.containsKey(name)) {
					p.sendMessage(Base.prefix + "§fKit §c" + name + " §fnao encontrado!");
					return true;
				}
				if (isInt(args[2])) {
					int numero = Integer.parseInt(args[2]);
					for (Entity ent : p.getNearbyEntities(numero, numero, numero)) {
						if (ent instanceof Player) {
							Player plr = (Player) ent;
							plr.getInventory().setArmorContents(this.armor.get(name));
							plr.getInventory().setContents(this.kits.get(name));
							Base.setarKit(plr, name);
						}
					}
					p.sendMessage(Base.prefix + "§fKit §c" + name + " §faplicado para jogadores em um raio de §c" + numero
							+ " §fblocos.");
					return true;
				}
				return true;
			}
		}
		return false;
	}
}
