package com.Legend.events;

import java.util.ArrayList;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.util.Vector;

public class Jumps implements Listener {
	public static ArrayList<String> jump = new ArrayList<>();

	@EventHandler(priority = EventPriority.MONITOR)
	public void onPlayerJump(PlayerMoveEvent e) {
		Player p = e.getPlayer();
		if (e.getTo().getBlock().getRelative(BlockFace.DOWN).getType() == Material.BEACON) {
			jump.remove(p.getName());
			Vector sponge = p.getLocation().getDirection().multiply(0).setY(1);
			p.setVelocity(sponge);
			jump.add(p.getName());
			return;
		}
	}

	@EventHandler(priority = EventPriority.HIGHEST)
	public void onEntityDamageSponge(EntityDamageEvent event) {
		if (event.getEntity() instanceof Player) {
			Player player = (Player) event.getEntity();
			Location loc = player.getLocation();
			Location below = loc.subtract(0.0D, 1.0D, 0.0D);
			Block blockBelow = below.getBlock();
			if (event.getCause() == EntityDamageEvent.DamageCause.FALL) {
				if (blockBelow.getType() == Material.BEACON) {
					jump.add(player.getName());
					event.setDamage(0.0D);
					return;
				}
				return;
			}
			return;
		}
	}


	@EventHandler(priority = EventPriority.MONITOR)
	public void onPlayerJump4(PlayerMoveEvent e) {
		Player p = e.getPlayer();
		if (e.getTo().getBlock().getRelative(BlockFace.DOWN).getType() == Material.COAL_BLOCK) {
			jump.remove(p.getName());
			Vector sponge = p.getLocation().getDirection().multiply(0).setY(2);
			p.setVelocity(sponge);
			jump.add(p.getName());
			return;
		}
	}

	@EventHandler(priority = EventPriority.HIGHEST)
	public void onEntityDamageSponge2(EntityDamageEvent event) {
		if (event.getEntity() instanceof Player) {
			Player player = (Player) event.getEntity();
			Location loc = player.getLocation();
			Location below = loc.subtract(0.0D, 1.0D, 0.0D);
			Block blockBelow = below.getBlock();
			if (event.getCause() == EntityDamageEvent.DamageCause.FALL) {
				if (blockBelow.getType() == Material.COAL_BLOCK) {
					jump.add(player.getName());
					event.setDamage(0.0D);
					return;
				}
				return;
			}
			return;
		}
	}

	public void onPlayerSpongeDamage1(EntityDamageEvent e) {
		if (!(e.getEntity() instanceof Player))
			return;
		Player p = (Player) e.getEntity();
		if (e.getCause() == EntityDamageEvent.DamageCause.FALL) {
			if (jump.contains(p.getName())) {
				jump.remove(p.getName());
				e.setDamage(0.0D);
				return;
			}
			return;
		}
	}

	@EventHandler(priority = EventPriority.MONITOR)
	public void onPlayerJump6(PlayerMoveEvent e) {
		Player p = e.getPlayer();
		if (e.getTo().getBlock().getRelative(BlockFace.DOWN).getType() == Material.COAL_BLOCK) {
			jump.remove(p.getName());
			Vector sponge = p.getLocation().getDirection().multiply(0).setY(2);
			p.setVelocity(sponge);
			jump.add(p.getName());
			return;
		}
	}


	@EventHandler(priority = EventPriority.HIGHEST)
	public void onEntityDamageSponge8(EntityDamageEvent event) {
		if (event.getEntity() instanceof Player) {
			Player player = (Player) event.getEntity();
			Location loc = player.getLocation();
			Location below = loc.subtract(0.0D, 1.0D, 0.0D);
			Block blockBelow = below.getBlock();
			if (event.getCause() == EntityDamageEvent.DamageCause.FALL) {
				if (blockBelow.getType() == Material.COAL_BLOCK) {
					jump.add(player.getName());
					event.setDamage(0.0D);
					return;
				}
				return;
			}
			return;
		}
	}


	@EventHandler(priority = EventPriority.MONITOR)
	public void onPlayerJumpa(PlayerMoveEvent e) {
		Player p = e.getPlayer();
		if (e.getTo().getBlock().getRelative(BlockFace.DOWN).getType() == Material.DIAMOND_BLOCK) {
			jump.remove(p.getName());
			Vector sponge = p.getLocation().getDirection().multiply(2.5D).setY(0.25D);
			p.setVelocity(sponge);
			jump.add(p.getName());
			return;
		}
	}


	@EventHandler(priority = EventPriority.HIGHEST)
	public void onEntityDamageSpongea(EntityDamageEvent event) {
		if (event.getEntity() instanceof Player) {
			Player player = (Player) event.getEntity();
			Location loc = player.getLocation();
			Location below = loc.subtract(0.0D, 1.0D, 0.0D);
			Block blockBelow = below.getBlock();
			if (event.getCause() == EntityDamageEvent.DamageCause.FALL) {
				if (blockBelow.getType() == Material.DIAMOND_BLOCK) {
					jump.add(player.getName());
					event.setDamage(0.0D);
					return;
				}
				return;
			}
			return;
		}
	}


	@EventHandler(priority = EventPriority.MONITOR)
	public void onPlayerJumpc(PlayerMoveEvent e) {
		Player p = e.getPlayer();
		if (e.getTo().getBlock().getRelative(BlockFace.DOWN).getType() == Material.SPONGE) {
			jump.remove(p.getName());
			Vector sponge = p.getLocation().getDirection().multiply(0).setY(3);
			p.setVelocity(sponge);
			jump.add(p.getName());
			return;
		}
	}

	@EventHandler(priority = EventPriority.HIGHEST)
	public void onEntityDamageSpongec(EntityDamageEvent event) {
		if (event.getEntity() instanceof Player) {
			Player player = (Player) event.getEntity();
			Location loc = player.getLocation();
			Location below = loc.subtract(0.0D, 1.0D, 0.0D);
			Block blockBelow = below.getBlock();
			if (event.getCause() == EntityDamageEvent.DamageCause.FALL) {
				if (blockBelow.getType() == Material.SPONGE) {
					jump.add(player.getName());
					event.setDamage(0.0D);
					return;
				}
				return;
			}
			return;
		}
	}


	@EventHandler(priority = EventPriority.MONITOR)
	public void onPlayerJumpd(PlayerMoveEvent e) {
		Player p = e.getPlayer();
		if (e.getTo().getBlock().getRelative(BlockFace.DOWN).getType() == Material.LAPIS_BLOCK) {
			jump.remove(p.getName());
			Vector sponge = p.getLocation().getDirection().multiply(0).setY(7);
			p.setVelocity(sponge);
			jump.add(p.getName());
			return;
		}
	}

	@EventHandler(priority = EventPriority.HIGHEST)
	public void onEntityDamageSponged(EntityDamageEvent event) {
		if (event.getEntity() instanceof Player) {
			Player player = (Player) event.getEntity();
			Location loc = player.getLocation();
			Location below = loc.subtract(0.0D, 1.0D, 0.0D);
			Block blockBelow = below.getBlock();
			if (event.getCause() == EntityDamageEvent.DamageCause.FALL) {
				if (blockBelow.getType() == Material.LAPIS_BLOCK) {
					jump.add(player.getName());
					event.setDamage(0.0D);
					return;
				}
				return;
			}
			return;
		}
	}


	@EventHandler(priority = EventPriority.MONITOR)
	public void onPlayerJumpe(PlayerMoveEvent e) {
		Player p = e.getPlayer();
		if (e.getTo().getBlock().getRelative(BlockFace.DOWN).getType() == Material.REDSTONE_BLOCK) {
			jump.remove(p.getName());
			Vector sponge = p.getLocation().getDirection().multiply(0).setY(3.25D);
			p.setVelocity(sponge);
			jump.add(p.getName());
			return;
		}
	}

	@EventHandler(priority = EventPriority.HIGHEST)
	public void onEntityDamageSpongee(EntityDamageEvent event) {
		if (event.getEntity() instanceof Player) {
			Player player = (Player) event.getEntity();
			Location loc = player.getLocation();
			Location below = loc.subtract(0.0D, 1.0D, 0.0D);
			Block blockBelow = below.getBlock();
			if (event.getCause() == EntityDamageEvent.DamageCause.FALL) {
				if (blockBelow.getType() == Material.REDSTONE_BLOCK) {
					jump.add(player.getName());
					event.setDamage(0.0D);
					return;
				}
				return;
			}
			return;
		}
	}

}
