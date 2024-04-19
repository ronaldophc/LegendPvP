package com.Legend.kits;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;

import com.Legend.Main;
import com.Legend.kits.manager.Base;
import com.Legend.kits.manager.CooldownAPI;

public class Endermage2 implements Listener{

	public void onKitEndermage(Location portal, Player p1, Player p2) {
		p1.teleport(portal.clone().add(0.0D, 1.0D, 0.0D));
		p2.teleport(portal.clone().add(0.0D, 1.0D, 0.0D));
		
		p1.setNoDamageTicks(100);
		p2.setNoDamageTicks(100);
		
		p2.getWorld().playEffect(p2.getLocation(), Effect.ENDER_SIGNAL, 9);
		p1.getWorld().playEffect(portal, Effect.ENDER_SIGNAL, 9);
		
		p2.playSound(p2.getLocation(), Sound.ENDERMAN_TELEPORT, 1.0F, 1.2F);
		p1.playSound(portal, Sound.ENDERMAN_TELEPORT, 1.0F, 1.2F);
	}

	private boolean isEnderable(Location portal, Location player) {
		return (Math.abs(portal.getX() - player.getX()) < 2.5D) && (Math.abs(portal.getZ() - player.getZ()) < 2.5D)
				&& (Math.abs(portal.getY() - player.getY()) > 3.0D);
	}
	
	@EventHandler
	public void onKitEndermage(PlayerInteractEvent e) {
		final Player mage = e.getPlayer();
		
		if (!(Base.qualKit(mage) == "Endermage"))
			return;
		
		if (e.getAction() != Action.RIGHT_CLICK_BLOCK)
			return;
		
		if (mage.getItemInHand() == null)
			return;
		
		if (mage.getItemInHand().getType() != Material.ENDER_PORTAL_FRAME)
			return;
		
		e.setCancelled(true);
			
		mage.setItemInHand(new ItemStack(Material.AIR));
		mage.updateInventory();
		
		final Block b = e.getClickedBlock();
		final Location bLoc = b.getLocation();
		final Material material = b.getType();
		@SuppressWarnings("deprecation")
		final int data = b.getData();
		
		b.setType(Material.ENDER_STONE);
		
		new BukkitRunnable() {
			
			int time = 5;
			
			@SuppressWarnings("deprecation")
			@Override
			public void run() {
				time--;
				
				for (final Player target : Bukkit.getOnlinePlayers()) {
					if (target != mage && !target.isDead() && !target.getInventory().contains(Material.ENDER_PORTAL_FRAME) && isEnderable(bLoc, target.getLocation())) {
						if (time != 0)
							time--;
						
						b.setType(material);
						b.setData((byte)data);
						

						onKitEndermage(bLoc, mage, target);
						CooldownAPI.addCooldown(mage, 4);
						CooldownAPI.mCooldown(mage, "Endermage");
						if (!mage.getInventory().contains(Material.ENDER_PORTAL_FRAME) && Base.qualKit(mage) == "Endermage") {
							ItemStack item = new ItemStack(Material.ENDER_PORTAL_FRAME);
							ItemMeta item2 = item.getItemMeta();
							item2.setDisplayName("§bEndermage");
							item.setItemMeta(item2);
							mage.getInventory().addItem(item);
						}
						cancel();

					}
				}
				
				if (time == 0) {
					cancel();
					
					b.setType(material);
					b.setData((byte)data);

					if (!mage.getInventory().contains(Material.ENDER_PORTAL_FRAME) && Base.qualKit(mage) == "Endermage") {
						ItemStack item = new ItemStack(Material.ENDER_PORTAL_FRAME);
						ItemMeta item2 = item.getItemMeta();
						item2.setDisplayName("§bEndermage");
						item.setItemMeta(item2);
						mage.getInventory().addItem(item);
					}
				} else if(time <=0) {
					cancel();
				}
				
			}
		}.runTaskTimer(Main.plugin, 20, 20);
	}

}
