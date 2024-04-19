package com.Legend.kits;

import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import com.Legend.Main;
import com.Legend.guis.Title;
import com.Legend.kits.manager.Base;
import com.Legend.kits.manager.CooldownAPI;

public class Hulk implements Listener {

	int cd;

	@EventHandler
	public void hulk(PlayerInteractEntityEvent event) {
		if (!(event.getRightClicked() instanceof Player))
			return;
		Player p = event.getPlayer();
		Player r = (Player) event.getRightClicked();
		if ((p.getItemInHand().getType() == Material.AIR) && (Base.qualKit(p) == "Hulk") && (p.getPassenger() == null)
				&& (r.getPassenger() == null)) {
			if(p.getLocation().getY() >= 63) {
				if (!Gladiator.lutando.containsKey(p) && !Gladiator.lutando.containsValue(p)) {
					return;
				}
			}
			if (!(CooldownAPI.SemCooldown(p))) {
				return;
			}
			p.setPassenger((Entity) r);
			CooldownAPI.addCooldown(p, 7);
			cd = 7;
			new BukkitRunnable() {

				@Override
				public void run() {
					cd -= 1;
					Title.sendActionBar(p, "§6Hulk Cooldown: §c" + cd + "s");
					if (cd == 0) {
						cancel();
					}
				}
			}.runTaskTimer(Main.getPlugin(), 20, 20);
			return;
		}
		if ((p.getItemInHand().getType() == Material.AIR) && (Base.qualKit(p) == "Hulk")
				&& (CooldownAPI.Cooldown.containsKey(p.getName())) && (p.getPassenger() == null)
				&& (r.getPassenger() == null))
			p.sendMessage(Base.prefix + "§7Espere §f" + CooldownAPI.Cooldown(p) + "s §7para usar novamente.");
	}

	@EventHandler
	public static void playerInteract(PlayerInteractEvent event) {
		if (!event.getAction().equals(Action.LEFT_CLICK_AIR))
			return;
		Player player = event.getPlayer();
		if (player.getPassenger() == null || !(player.getPassenger() instanceof Player))
			return;
		Player pass = (Player) player.getPassenger();
		player.eject();
		pass.damage(0.0D, (Entity) player);
		pass.setVelocity(new Vector(pass.getVelocity().getX(), 1.0D, pass.getVelocity().getZ()));
	}
}