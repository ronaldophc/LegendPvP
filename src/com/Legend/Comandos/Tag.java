package com.Legend.Comandos;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_8_R2.entity.CraftPlayer;
import org.bukkit.entity.Player;

import com.Legend.Main;
import com.Legend.kits.manager.Base;

import net.minecraft.server.v1_8_R2.PacketPlayOutChat;
import net.minecraft.server.v1_8_R2.PlayerConnection;
import net.minecraft.server.v1_8_R2.IChatBaseComponent.ChatSerializer;

public class Tag implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if (cmd.getName().equalsIgnoreCase("tag")) {
			if (!(sender instanceof Player)) {
				sender.sendMessage(Base.prefix + "§bAs tags estão em manutencão!");
				return true;
			}
			Player p = (Player) sender;
			if (args.length == 0) {
				PlayerConnection con = ((CraftPlayer) p).getHandle().playerConnection;
				PacketPlayOutChat normal = new PacketPlayOutChat(ChatSerializer.a(
						"{\"text\":\"Normal\",\"italic\":true,\"color\":\"white\",\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/tag normal\"}}"));
				con.sendPacket(normal);
				PacketPlayOutChat vip = new PacketPlayOutChat(ChatSerializer.a(
						"{\"text\":\"Vip\",\"italic\":true,\"color\":\"gold\",\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/tag vip\"}}"));
				con.sendPacket(vip);
				PacketPlayOutChat dev = new PacketPlayOutChat(ChatSerializer.a(
						"{\"text\":\"Dev\",\"italic\":true,\"color\":\"aqua\",\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/tag dev\"}}"));
				con.sendPacket(dev);
				PacketPlayOutChat yt = new PacketPlayOutChat(ChatSerializer.a(
						"{\"text\":\"Youtuber\",\"italic\":true,\"color\":\"green\",\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/tag youtuber\"}}"));
				con.sendPacket(yt);
				PacketPlayOutChat streamer = new PacketPlayOutChat(ChatSerializer.a(
						"{\"text\":\"Streamer\",\"italic\":true,\"color\":\"dark_aqua\",\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/tag streamer\"}}"));
				con.sendPacket(streamer);
				PacketPlayOutChat builder = new PacketPlayOutChat(ChatSerializer.a(
						"{\"text\":\"Builder\",\"italic\":true,\"color\":\"blue\",\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/tag builder\"}}"));
				con.sendPacket(builder);
				PacketPlayOutChat beta = new PacketPlayOutChat(ChatSerializer.a(
						"{\"text\":\"Beta\",\"italic\":true,\"color\":\"dark_green\",\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/tag beta\"}}"));
				con.sendPacket(beta);
				PacketPlayOutChat ajudante = new PacketPlayOutChat(ChatSerializer.a(
						"{\"text\":\"Helper\",\"italic\":true,\"color\":\"light_purple\",\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/tag helper\"}}"));
				con.sendPacket(ajudante);
				PacketPlayOutChat mod = new PacketPlayOutChat(ChatSerializer.a(
						"{\"text\":\"Mod\",\"italic\":true,\"color\":\"dark_purple\",\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/tag mod\"}}"));
				con.sendPacket(mod);
				PacketPlayOutChat admin = new PacketPlayOutChat(ChatSerializer.a(
						"{\"text\":\"Admin\",\"italic\":true,\"color\":\"red\",\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/tag admin\"}}"));
				con.sendPacket(admin);
				PacketPlayOutChat dono = new PacketPlayOutChat(ChatSerializer.a(
						"{\"text\":\"Dono\",\"italic\":true,\"color\":\"dark_red\",\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/tag dono\"}}"));
				con.sendPacket(dono);
				return false;
			}
			if (args[0].equalsIgnoreCase("normal")) {
				if (p.hasPermission("Legend.tag.normal")) {
					setTag(p, "Normal");
					p.sendMessage(Base.prefix + "§bTag alterada Para: §fNormal");
				} else {
					p.sendMessage(Base.prefix + "§bVocê não possui essa §fTag!");
				}
			} else if (args[0].equalsIgnoreCase("Beta")) {
				if (p.hasPermission("Legend.tag.Beta")) {
					setTag(p, "Beta");
					p.sendMessage(Base.prefix + "§bTag alterada Para: §2Beta");
				} else {
					p.sendMessage(Base.prefix + "§bVocê não possui essa §fTag!");
				}
			} else if (args[0].equalsIgnoreCase("Vip")) {
				if (p.hasPermission("Legend.tag.vip")) {
					setTag(p, "Vip");
					p.sendMessage(Base.prefix + "§bTag alterada Para: §6Vip");
				} else {
					p.sendMessage(Base.prefix + "§bVocê não possui essa §fTag!");
				}
			} else if (args[0].equalsIgnoreCase("youtuber")) {
				if (p.hasPermission("Legend.tag.youtuber")) {
					setTag(p, "Yt");
					p.sendMessage(Base.prefix + "§bTag alterada Para: §aYoutuber");
				} else {
					p.sendMessage(Base.prefix + "§bVocê não possui essa §fTag!");
				}
			} else if (args[0].equalsIgnoreCase("streamer")) {
				if (p.hasPermission("Legend.tag.streamer")) {
					setTag(p, "Streamer");
					p.sendMessage(Base.prefix + "§bTag alterada Para: §3Streamer");
				} else {
					p.sendMessage(Base.prefix + "§bVocê não possui essa §fTag!");
				}
			} else if (args[0].equalsIgnoreCase("helper")) {
				if (p.hasPermission("Legend.tag.helper")) {
					setTag(p, "Helper");
					p.sendMessage(Base.prefix + "§bTag alterada Para: §dHelper");
				} else {
					p.sendMessage(Base.prefix + "§bVocê não possui essa §fTag!");
				}
			} else if (args[0].equalsIgnoreCase("Mod")) {
				if (p.hasPermission("Legend.tag.Mod")) {
					setTag(p, "Mod");
					p.sendMessage(Base.prefix + "§bTag alterada Para: §5Mod");
				} else {
					p.sendMessage(Base.prefix + "§bVocê não possui essa §fTag!");
				}
			} else if (args[0].equalsIgnoreCase("admin")) {
				if (p.hasPermission("Legend.tag.admin")) {
					setTag(p, "Admin");
					p.sendMessage(Base.prefix + "§bTag alterada Para: §cAdmin");
				} else {
					p.sendMessage(Base.prefix + "§bVocê não possui essa §fTag!");
				}
			} else if (args[0].equalsIgnoreCase("dono")) {
				if (p.hasPermission("Legend.tag.dono")) {
					setTag(p, "Dono");
					p.sendMessage(Base.prefix + "§bTag alterada Para: §4§lDono");
				} else {
					p.sendMessage(Base.prefix + "§bVocê não possui essa §fTag!");
				}
			} else if (args[0].equalsIgnoreCase("builder")) {
				if (p.hasPermission("Legend.tag.builder")) {
					setTag(p, "Builder");
					p.sendMessage(Base.prefix + "§bTag alterada Para: §9Builder");
				} else {
					p.sendMessage(Base.prefix + "§bVocê não possui essa §fTag!");
				}
			} else if (args[0].equalsIgnoreCase("dev")) {
				if (p.hasPermission("Legend.tag.dev")) {
					setTag(p, "Dev");
					p.sendMessage(Base.prefix + "§bTag alterada Para: §bDev");
				} else {
					p.sendMessage(Base.prefix + "§bVocê não possui essa §fTag!");
				}
			}
		}
		return false;
	}

	public static void setTag(Player p, String tag) {
		Main.file.getConfig().set(String.valueOf(p.getName()) + ".Tag", tag);
		Main.file.save();
	}

	public static String getTag(Player p) {
		return Main.file.getConfig().getString(String.valueOf(p.getName()) + ".Tag");
	}
}