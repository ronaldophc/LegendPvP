package com.Legend.Comandos;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import com.Legend.Main;

public class Head implements CommandExecutor {
	public Head(Main main) {
	}

	public boolean onCommand(CommandSender sender, Command command, String cmd, String[] args) {
		Player p = (Player) sender;
		if (cmd.equalsIgnoreCase("head") && p.isOp()) {
			if (args.length == 0) {
				p.getInventory().setHelmet(p.getItemInHand());
				return true;
			}
			ItemStack s = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
			SkullMeta smeta = (SkullMeta) s.getItemMeta();
			smeta.setOwner(args[0]);
			s.setItemMeta((ItemMeta) smeta);
			p.getInventory().addItem(new ItemStack[] { s });
		}
		return false;
	}
}
