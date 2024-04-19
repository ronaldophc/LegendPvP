package com.Legend.events;

import net.minecraft.server.v1_8_R2.ChatComponentText;
import net.minecraft.server.v1_8_R2.PacketPlayOutPlayerListHeaderFooter;

import java.lang.reflect.Field;

import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_8_R2.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import com.Legend.Main;

public class Tab {

	public static void Taba() {
		PacketPlayOutPlayerListHeaderFooter packet = new PacketPlayOutPlayerListHeaderFooter();
		new BukkitRunnable() {

			@Override
			public void run() {
				try {
					Field a = packet.getClass().getDeclaredField("a");
					a.setAccessible(true);
					Field b = packet.getClass().getDeclaredField("b");
					b.setAccessible(true);

					Object header1 = new ChatComponentText("§b§lLegendPvP\n"
							+"  §bJogar.LegendPvP.com.br");

					Object footer = new ChatComponentText(
							"§6Discord: §bDiscord.gg/WPEh5UGSh2\n"
							+ "§6Site: §bwww.LegendPvP.com.br");
					a.set(packet, header1);
					b.set(packet, footer);

					if (Bukkit.getOnlinePlayers().size() == 0)
						return;
					for (Player player : Bukkit.getOnlinePlayers()) {
						((CraftPlayer) player).getHandle().playerConnection.sendPacket(packet);
					}

				} catch (NoSuchFieldException | IllegalAccessException e) {
					e.printStackTrace();
				}
			}
		}.runTaskTimer(Main.plugin, 0, 20);
	}
}
