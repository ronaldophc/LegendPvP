package com.Legend.events;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.scheduler.BukkitRunnable;

import com.Legend.Main;
import com.Legend.Comandos.Builder;
import com.Legend.KD.API;
import com.Legend.kits.manager.Base;

public class BlockBreak implements Listener {

	@EventHandler
	public void quebrar(BlockBreakEvent e) {
		Player p = e.getPlayer();
		if (Builder.pode.contains(p.getName())) {
		} else if (Base.qualKit(p) != "Nenhum" && (Base.qualKit(p) != null)) {
			
			Block bl = e.getBlock();
			Location locb = bl.getLocation();
			Location loc = new Location(e.getBlock().getWorld(), Integer.valueOf(824), Integer.valueOf(23),
					Integer.valueOf(-1280));
			if (((locb.getX() == (loc.getX())) && (locb.getZ() == (loc.getZ())) && (locb.getY() == (loc.getY())))
					|| ((locb.getX() == (loc.getX())) && (locb.getZ() == (loc.getZ() - 1))
							&& (locb.getY() == (loc.getY())))
					|| ((locb.getX() == (loc.getX())) && (locb.getZ() == (loc.getZ() + 1))
							&& (locb.getY() == (loc.getY())))
					|| ((locb.getX() == (loc.getX())) && (locb.getZ() == (loc.getZ() + 2))
							&& (locb.getY() == (loc.getY())))
					|| ((locb.getX() == (loc.getX() - 1)) && (locb.getZ() == (loc.getZ()))
							&& (locb.getY() == (loc.getY() + 1)))
					|| ((locb.getX() == (loc.getX() - 1)) && (locb.getZ() == (loc.getZ() + 1))
							&& (locb.getY() == (loc.getY() + 1)))) {
				e.getBlock().setType(Material.AIR);
				e.getPlayer().getInventory().addItem(API.Item(Material.BOWL, "§cPotinhos", 16, (byte) 0));
				Location a = new Location(e.getBlock().getWorld(), e.getBlock().getX(), e.getBlock().getY(),
						e.getBlock().getZ());
				new BukkitRunnable() {

					@SuppressWarnings("deprecation")
					@Override
					public void run() {
						a.getBlock().setType(Material.LOG);
						a.getBlock().setData((byte) 12);
					}
				}.runTaskLater(Main.plugin, 10 * 20);
			}
			Location loc1 = new Location(e.getBlock().getWorld(), Integer.valueOf(879), Integer.valueOf(22),
					Integer.valueOf(-1257));
			if (((locb.getX() == (loc1.getX())) && (locb.getZ() == (loc1.getZ())) && (locb.getY() == (loc1.getY())))
					|| ((locb.getX() == (loc1.getX())) && (locb.getZ() == (loc1.getZ() + 1))
							&& (locb.getY() == (loc1.getY())))
					|| ((locb.getX() == (loc1.getX())) && (locb.getZ() == (loc1.getZ() - 1))
							&& (locb.getY() == (loc1.getY())))
					|| ((locb.getX() == (loc1.getX())) && (locb.getZ() == (loc1.getZ() - 2))
							&& (locb.getY() == (loc1.getY())))
					|| ((locb.getX() == (loc1.getX() - 1)) && (locb.getZ() == (loc1.getZ()))
							&& (locb.getY() == (loc1.getY() + 1)))
					|| ((locb.getX() == (loc1.getX() - 1)) && (locb.getZ() == (loc1.getZ() - 1))
							&& (locb.getY() == (loc1.getY() + 1)))) {
				e.getBlock().setType(Material.AIR);
				e.getPlayer().getInventory().addItem(API.Item(Material.BOWL, "§cPotinhos", 16, (byte) 0));
				Location a = new Location(e.getBlock().getWorld(), e.getBlock().getX(), e.getBlock().getY(),
						e.getBlock().getZ());
				new BukkitRunnable() {

					@SuppressWarnings("deprecation")
					@Override
					public void run() {
						a.getBlock().setType(Material.LOG);
						a.getBlock().setData((byte) 13);
					}
				}.runTaskLater(Main.plugin, 10 * 20);
			}
			Location loc2 = new Location(e.getBlock().getWorld(), Integer.valueOf(885), Integer.valueOf(23),
					Integer.valueOf(-1231));
			if (((locb.getX() == (loc2.getX())) && (locb.getZ() == (loc2.getZ())) && (locb.getY() == (loc2.getY())))
					|| ((locb.getX() == (loc2.getX())) && (locb.getZ() == (loc2.getZ() - 1))
							&& (locb.getY() == (loc2.getY())))
					|| ((locb.getX() == (loc2.getX())) && (locb.getZ() == (loc2.getZ() + 1))
							&& (locb.getY() == (loc2.getY())))
					|| ((locb.getX() == (loc2.getX())) && (locb.getZ() == (loc2.getZ() + 2))
							&& (locb.getY() == (loc2.getY())))
					|| ((locb.getX() == (loc2.getX() - 1)) && (locb.getZ() == (loc2.getZ()))
							&& (locb.getY() == (loc2.getY() + 1)))
					|| ((locb.getX() == (loc2.getX() - 1)) && (locb.getZ() == (loc2.getZ() + 1))
							&& (locb.getY() == (loc2.getY() + 1)))) {
				e.getBlock().setType(Material.AIR);
				e.getPlayer().getInventory().addItem(API.Item(Material.BOWL, "§cPotinhos", 16, (byte) 0));
				Location a = new Location(e.getBlock().getWorld(), e.getBlock().getX(), e.getBlock().getY(),
						e.getBlock().getZ());
				new BukkitRunnable() {

					@SuppressWarnings("deprecation")
					@Override
					public void run() {
						a.getBlock().setType(Material.LOG);
						a.getBlock().setData((byte) 13);
					}
				}.runTaskLater(Main.plugin, 10 * 20);
			}
			Location loc3 = new Location(e.getBlock().getWorld(), Integer.valueOf(911), Integer.valueOf(24),
					Integer.valueOf(-1211));
			if (((locb.getX() == (loc3.getX())) && (locb.getZ() == (loc3.getZ())) && (locb.getY() == (loc3.getY())))
					|| ((locb.getX() == (loc3.getX())) && (locb.getZ() == (loc3.getZ() + 1))
							&& (locb.getY() == (loc3.getY())))
					|| ((locb.getX() == (loc3.getX())) && (locb.getZ() == (loc3.getZ() - 1))
							&& (locb.getY() == (loc3.getY())))
					|| ((locb.getX() == (loc3.getX())) && (locb.getZ() == (loc3.getZ() - 2))
							&& (locb.getY() == (loc3.getY())))
					|| ((locb.getX() == (loc3.getX() - 1)) && (locb.getZ() == (loc3.getZ()))
							&& (locb.getY() == (loc3.getY() + 1)))
					|| ((locb.getX() == (loc3.getX() - 1)) && (locb.getZ() == (loc3.getZ() - 1))
							&& (locb.getY() == (loc3.getY() + 1)))) {
				e.getBlock().setType(Material.AIR);
				e.getPlayer().getInventory().addItem(API.Item(Material.BOWL, "§cPotinhos", 16, (byte) 0));
				Location a = new Location(e.getBlock().getWorld(), e.getBlock().getX(), e.getBlock().getY(),
						e.getBlock().getZ());
				new BukkitRunnable() {

					@SuppressWarnings("deprecation")
					@Override
					public void run() {
						a.getBlock().setType(Material.LOG);
						a.getBlock().setData((byte) 12);
					}
				}.runTaskLater(Main.plugin, 10 * 20);
			}
			Location loc4 = new Location(e.getBlock().getWorld(), Integer.valueOf(884), Integer.valueOf(24),
					Integer.valueOf(-1193));
			if (((locb.getX() == (loc4.getX())) && (locb.getZ() == (loc4.getZ())) && (locb.getY() == (loc4.getY())))
					|| ((locb.getX() == (loc4.getX())) && (locb.getZ() == (loc4.getZ() + 1))
							&& (locb.getY() == (loc4.getY())))
					|| ((locb.getX() == (loc4.getX())) && (locb.getZ() == (loc4.getZ() - 1))
							&& (locb.getY() == (loc4.getY())))
					|| ((locb.getX() == (loc4.getX())) && (locb.getZ() == (loc4.getZ() - 2))
							&& (locb.getY() == (loc4.getY())))
					|| ((locb.getX() == (loc4.getX() - 1)) && (locb.getZ() == (loc4.getZ()))
							&& (locb.getY() == (loc4.getY() + 1)))
					|| ((locb.getX() == (loc4.getX() - 1)) && (locb.getZ() == (loc4.getZ() - 1))
							&& (locb.getY() == (loc4.getY() + 1)))) {
				e.getBlock().setType(Material.AIR);
				e.getPlayer().getInventory().addItem(API.Item(Material.BOWL, "§cPotinhos", 16, (byte) 0));
				Location a = new Location(e.getBlock().getWorld(), e.getBlock().getX(), e.getBlock().getY(),
						e.getBlock().getZ());
				new BukkitRunnable() {

					@SuppressWarnings("deprecation")
					@Override
					public void run() {
						a.getBlock().setType(Material.LOG);
						a.getBlock().setData((byte) 12);
					}
				}.runTaskLater(Main.plugin, 10 * 20);
			}
			Location loc5 = new Location(e.getBlock().getWorld(), Integer.valueOf(856), Integer.valueOf(25),
					Integer.valueOf(-1174));
			if (((locb.getX() == (loc5.getX())) && (locb.getZ() == (loc5.getZ())) && (locb.getY() == (loc5.getY())))
					|| ((locb.getX() == (loc5.getX())) && (locb.getZ() == (loc5.getZ() + 1))
							&& (locb.getY() == (loc5.getY())))
					|| ((locb.getX() == (loc5.getX())) && (locb.getZ() == (loc5.getZ() - 1))
							&& (locb.getY() == (loc5.getY())))
					|| ((locb.getX() == (loc5.getX())) && (locb.getZ() == (loc5.getZ() - 2))
							&& (locb.getY() == (loc5.getY())))
					|| ((locb.getX() == (loc5.getX() - 1)) && (locb.getZ() == (loc5.getZ()))
							&& (locb.getY() == (loc5.getY() + 1)))
					|| ((locb.getX() == (loc5.getX() - 1)) && (locb.getZ() == (loc5.getZ() - 1))
							&& (locb.getY() == (loc5.getY() + 1)))) {
				e.getBlock().setType(Material.AIR);
				e.getPlayer().getInventory().addItem(API.Item(Material.BOWL, "§cPotinhos", 16, (byte) 0));
				Location a = new Location(e.getBlock().getWorld(), e.getBlock().getX(), e.getBlock().getY(),
						e.getBlock().getZ());
				new BukkitRunnable() {

					@SuppressWarnings("deprecation")
					@Override
					public void run() {
						a.getBlock().setType(Material.LOG);
						a.getBlock().setData((byte) 12);
					}
				}.runTaskLater(Main.plugin, 10 * 20);
			}
			Location loc6 = new Location(e.getBlock().getWorld(), Integer.valueOf(801), Integer.valueOf(24),
					Integer.valueOf(-1159));
			if (((locb.getX() == (loc6.getX())) && (locb.getZ() == (loc6.getZ())) && (locb.getY() == (loc6.getY())))
					|| ((locb.getX() == (loc6.getX())) && (locb.getZ() == (loc6.getZ() + 1))
							&& (locb.getY() == (loc6.getY())))
					|| ((locb.getX() == (loc6.getX())) && (locb.getZ() == (loc6.getZ() - 1))
							&& (locb.getY() == (loc6.getY())))
					|| ((locb.getX() == (loc6.getX())) && (locb.getZ() == (loc6.getZ() - 2))
							&& (locb.getY() == (loc6.getY())))
					|| ((locb.getX() == (loc6.getX() - 1)) && (locb.getZ() == (loc6.getZ()))
							&& (locb.getY() == (loc6.getY() + 1)))
					|| ((locb.getX() == (loc6.getX() - 1)) && (locb.getZ() == (loc6.getZ() - 1))
							&& (locb.getY() == (loc6.getY() + 1)))) {
				e.getBlock().setType(Material.AIR);
				e.getPlayer().getInventory().addItem(API.Item(Material.BOWL, "§cPotinhos", 16, (byte) 0));
				Location a = new Location(e.getBlock().getWorld(), e.getBlock().getX(), e.getBlock().getY(),
						e.getBlock().getZ());
				new BukkitRunnable() {

					@SuppressWarnings("deprecation")
					@Override
					public void run() {
						a.getBlock().setType(Material.LOG);
						a.getBlock().setData((byte) 12);
					}
				}.runTaskLater(Main.plugin, 10 * 20);
			}
			Location loc7 = new Location(e.getBlock().getWorld(), Integer.valueOf(800), Integer.valueOf(22),
					Integer.valueOf(-1210));
			if (((locb.getX() == (loc7.getX())) && (locb.getZ() == (loc7.getZ())) && (locb.getY() == (loc7.getY())))
					|| ((locb.getX() == (loc7.getX())) && (locb.getZ() == (loc7.getZ() - 1))
							&& (locb.getY() == (loc7.getY())))
					|| ((locb.getX() == (loc7.getX())) && (locb.getZ() == (loc7.getZ() + 1))
							&& (locb.getY() == (loc7.getY())))
					|| ((locb.getX() == (loc7.getX())) && (locb.getZ() == (loc7.getZ() + 2))
							&& (locb.getY() == (loc7.getY())))
					|| ((locb.getX() == (loc7.getX() + 1)) && (locb.getZ() == (loc7.getZ()))
							&& (locb.getY() == (loc7.getY() + 1)))
					|| ((locb.getX() == (loc7.getX() + 1)) && (locb.getZ() == (loc7.getZ() + 1))
							&& (locb.getY() == (loc7.getY() + 1)))) {
				e.getBlock().setType(Material.AIR);
				e.getPlayer().getInventory().addItem(API.Item(Material.BOWL, "§cPotinhos", 16, (byte) 0));
				Location a = new Location(e.getBlock().getWorld(), e.getBlock().getX(), e.getBlock().getY(),
						e.getBlock().getZ());
				new BukkitRunnable() {

					@SuppressWarnings("deprecation")
					@Override
					public void run() {
						a.getBlock().setType(Material.LOG);
						a.getBlock().setData((byte) 15);
					}
				}.runTaskLater(Main.plugin, 10 * 20);
			}
			Location loc8 = new Location(e.getBlock().getWorld(), Integer.valueOf(820), Integer.valueOf(24),
					Integer.valueOf(-1220));
			if (((locb.getX() == (loc8.getX())) && (locb.getZ() == (loc8.getZ())) && (locb.getY() == (loc8.getY())))
					|| ((locb.getX() == (loc8.getX())) && (locb.getZ() == (loc8.getZ() - 1))
							&& (locb.getY() == (loc8.getY())))
					|| ((locb.getX() == (loc8.getX())) && (locb.getZ() == (loc8.getZ() + 1))
							&& (locb.getY() == (loc8.getY())))
					|| ((locb.getX() == (loc8.getX())) && (locb.getZ() == (loc8.getZ() + 2))
							&& (locb.getY() == (loc8.getY())))
					|| ((locb.getX() == (loc8.getX() + 1)) && (locb.getZ() == (loc8.getZ()))
							&& (locb.getY() == (loc8.getY() + 1)))
					|| ((locb.getX() == (loc8.getX() + 1)) && (locb.getZ() == (loc8.getZ() + 1))
							&& (locb.getY() == (loc8.getY() + 1)))) {
				e.getBlock().setType(Material.AIR);
				e.getPlayer().getInventory().addItem(API.Item(Material.BOWL, "§cPotinhos", 16, (byte) 0));
				Location a = new Location(e.getBlock().getWorld(), e.getBlock().getX(), e.getBlock().getY(),
						e.getBlock().getZ());
				new BukkitRunnable() {

					@SuppressWarnings("deprecation")
					@Override
					public void run() {
						a.getBlock().setType(Material.LOG);
						a.getBlock().setData((byte) 15);
					}
				}.runTaskLater(Main.plugin, 10 * 20);
			}
			Location loc9 = new Location(e.getBlock().getWorld(), Integer.valueOf(767), Integer.valueOf(22),
					Integer.valueOf(-1253));
			if (((locb.getX() == (loc9.getX())) && (locb.getZ() == (loc9.getZ())) && (locb.getY() == (loc9.getY())))
					|| ((locb.getX() == (loc9.getX())) && (locb.getZ() == (loc9.getZ() - 1))
							&& (locb.getY() == (loc9.getY())))
					|| ((locb.getX() == (loc9.getX())) && (locb.getZ() == (loc9.getZ() + 1))
							&& (locb.getY() == (loc9.getY())))
					|| ((locb.getX() == (loc9.getX())) && (locb.getZ() == (loc9.getZ() + 2))
							&& (locb.getY() == (loc9.getY())))
					|| ((locb.getX() == (loc9.getX() + 1)) && (locb.getZ() == (loc9.getZ()))
							&& (locb.getY() == (loc9.getY() + 1)))
					|| ((locb.getX() == (loc9.getX() + 1)) && (locb.getZ() == (loc9.getZ() + 1))
							&& (locb.getY() == (loc9.getY() + 1)))) {
				e.getBlock().setType(Material.AIR);
				e.getPlayer().getInventory().addItem(API.Item(Material.BOWL, "§cPotinhos", 16, (byte) 0));
				Location a = new Location(e.getBlock().getWorld(), e.getBlock().getX(), e.getBlock().getY(),
						e.getBlock().getZ());
				new BukkitRunnable() {

					@SuppressWarnings("deprecation")
					@Override
					public void run() {
						a.getBlock().setType(Material.LOG);
						a.getBlock().setData((byte) 12);
					}
				}.runTaskLater(Main.plugin, 10 * 20);
			}
			Location loc10 = new Location(e.getBlock().getWorld(), Integer.valueOf(788), Integer.valueOf(22),
					Integer.valueOf(-1277));
			if (((locb.getX() == (loc10.getX())) && (locb.getZ() == (loc10.getZ())) && (locb.getY() == (loc10.getY())))
					|| ((locb.getX() == (loc10.getX())) && (locb.getZ() == (loc10.getZ() - 1))
							&& (locb.getY() == (loc10.getY())))
					|| ((locb.getX() == (loc10.getX())) && (locb.getZ() == (loc10.getZ() + 1))
							&& (locb.getY() == (loc10.getY())))
					|| ((locb.getX() == (loc10.getX())) && (locb.getZ() == (loc10.getZ() + 2))
							&& (locb.getY() == (loc10.getY())))
					|| ((locb.getX() == (loc10.getX() + 1)) && (locb.getZ() == (loc10.getZ()))
							&& (locb.getY() == (loc10.getY() + 1)))
					|| ((locb.getX() == (loc10.getX() + 1)) && (locb.getZ() == (loc10.getZ() + 1))
							&& (locb.getY() == (loc10.getY() + 1)))) {
				e.getBlock().setType(Material.AIR);
				e.getPlayer().getInventory().addItem(API.Item(Material.BOWL, "§cPotinhos", 16, (byte) 0));
				Location a = new Location(e.getBlock().getWorld(), e.getBlock().getX(), e.getBlock().getY(),
						e.getBlock().getZ());
				new BukkitRunnable() {

					@SuppressWarnings("deprecation")
					@Override
					public void run() {
						a.getBlock().setType(Material.LOG);
						a.getBlock().setData((byte) 12);
					}
				}.runTaskLater(Main.plugin, 10 * 20);
			}

			if (e.getBlock().getType() == Material.RED_MUSHROOM) {
				e.getBlock().setType(Material.AIR);
				List<Integer> c1 = new ArrayList<>();
				c1.add(1);
				c1.add(2);
				int b = c1.get(new Random().nextInt(c1.size()));
				e.getPlayer().getInventory().addItem(API.Item(Material.RED_MUSHROOM, "§cCogu Red", b, (byte) 0));
				Location a = new Location(e.getBlock().getWorld(), e.getBlock().getX(), e.getBlock().getY(),
						e.getBlock().getZ());
				new BukkitRunnable() {

					@Override
					public void run() {
						a.getBlock().setType(Material.RED_MUSHROOM);
						cancel();
					}
				}.runTaskLater(Main.plugin, 30 * 20);
			} else if (e.getBlock().getType() == Material.BROWN_MUSHROOM) {
				e.getBlock().setType(Material.AIR);
				List<Integer> c1 = new ArrayList<>();
				c1.add(1);
				c1.add(2);
				int b = c1.get(new Random().nextInt(c1.size()));
				e.getPlayer().getInventory().addItem(API.Item(Material.BROWN_MUSHROOM, "§cCogu Brown", b, (byte) 0));
				Location a = new Location(e.getBlock().getWorld(), e.getBlock().getX(), e.getBlock().getY(),
						e.getBlock().getZ());
				new BukkitRunnable() {

					@Override
					public void run() {
						a.getBlock().setType(Material.BROWN_MUSHROOM);
						cancel();
					}
				}.runTaskLater(Main.plugin, 30 * 20);
			} else if (e.getBlock().getType() == Material.MELON_BLOCK) {
				e.getBlock().setType(Material.AIR);
				List<Integer> c1 = new ArrayList<>();
				c1.add(4);
				c1.add(5);
				c1.add(6);
				int b = c1.get(new Random().nextInt(c1.size()));
				e.getPlayer().getInventory().addItem(API.Item(Material.MELON_SEEDS, "§cSemente de Melão", b, (byte) 0));
				Location a = new Location(e.getBlock().getWorld(), e.getBlock().getX(), e.getBlock().getY(),
						e.getBlock().getZ());
				new BukkitRunnable() {

					@Override
					public void run() {
						a.getBlock().setType(Material.MELON_BLOCK);
					}
				}.runTaskLater(Main.plugin, 30 * 20);
			} else {
				e.setCancelled(true);
			}
		} else {
			e.setCancelled(true);
		}
	}
}
