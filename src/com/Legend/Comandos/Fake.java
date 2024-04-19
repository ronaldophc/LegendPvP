package com.Legend.Comandos;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import com.Legend.kits.manager.Base;
import com.mojang.authlib.GameProfile;

public class Fake implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if (!(sender instanceof Player)) {
			return true;
		}
		Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("fake")) {
			if (p.hasPermission("Legend.fake")) {
				if (args.length == 0) {
					p.sendMessage(Base.prefix + "§bUse §f/fake <nome>.");
					return true;
				} else if (args.length == 1) {
					if (args[0].equalsIgnoreCase("reset")) {

						return true;
					}
					Player t = Bukkit.getServer().getPlayer(args[0]);
					if (t != null) {
						sender.sendMessage(Base.prefix + "§bO jogador está online!");
						return true;
					}
					Bukkit.broadcastMessage("§f[§c-§f] §c>> §f" + p.getName() + "§b.");
					String nome = args[0];
					p.sendMessage(Base.prefix + "§bVocê mudou seu nick para: §f" + p.getName() + "§b.");
					changeName(nome, p);
					Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "skin update " + nome);
				}
			}

		}
		return false;

	}

	public static void changeName(String name, Player player) {
		try {
			Method getHandle = player.getClass().getMethod("getHandle", (Class<?>[]) null);
			Object entityPlayer = getHandle.invoke(player);
			Class<?> entityHuman = entityPlayer.getClass().getSuperclass();
			Field bH = entityHuman.getDeclaredField("bH");
			bH.setAccessible(true);
			bH.set(entityPlayer, new GameProfile(player.getUniqueId(), name));
			for (Player players : Bukkit.getOnlinePlayers()) {
				players.hidePlayer(player);
				players.showPlayer(player);
			}
		} catch (NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		}
	}
}
