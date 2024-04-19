package com.Legend.kits;

import org.bukkit.plugin.*;
import org.bukkit.block.*;
import org.bukkit.entity.*;
import org.bukkit.potion.*;

import com.Legend.Main;
import com.Legend.kits.manager.Base;
import com.Legend.kits.manager.CooldownAPI;

import java.util.*;
import org.bukkit.event.*;
import org.bukkit.event.block.*;
import org.bukkit.*;
import org.bukkit.event.entity.*;
import org.bukkit.event.player.*;

public class Gladiator implements Listener {
	public Plugin plugin;
	private List<Block> gladiatorbloco;
	private HashMap<Block, Player> gladblock;
	public static HashMap<Player, Player> lutando;
	private HashMap<Player, Location> lugar;
	private int glad1;
	private int glad2;

	@SuppressWarnings("static-access")
	public Gladiator(final Main plugin) {
		this.gladiatorbloco = new ArrayList<Block>();
		this.gladblock = new HashMap<Block, Player>();
		this.lutando = new HashMap<Player, Player>();
		this.lugar = new HashMap<Player, Location>();
		this.plugin = (Plugin) plugin;
	}
 
	
	@SuppressWarnings("static-access")
	@EventHandler
	void KitGladiator(final PlayerInteractEntityEvent e) {
		if (e.getRightClicked() instanceof Player) {
			final Player p = e.getPlayer();
			final Player r = (Player) e.getRightClicked();
			if (p.getItemInHand().getType() == Material.IRON_FENCE && (Base.qualKit(p) == "Gladiator")) {
				final Location loc = new Location(p.getWorld(), p.getLocation().getX(), p.getLocation().getY() + 80.0,
						p.getLocation().getZ());
				final Location loc2 = new Location(p.getWorld(), (double) (p.getLocation().getBlockX() + 8),
						(double) (p.getLocation().getBlockY() + 82), (double) (p.getLocation().getBlockZ() + 8));
				final Location loc3 = new Location(p.getWorld(), (double) (p.getLocation().getBlockX() - 8),
						(double) (p.getLocation().getBlockY() + 82), (double) (p.getLocation().getBlockZ() - 8));
				if (this.lutando.containsKey(p) || Gladiator.lutando.containsKey(r)) {
					p.sendMessage(Base.prefix + "§7Você já está em uma batalha no §cGladiator§b.");
					return;
				}
				if(Base.qualKit(r) == "Nenhum" || Base.qualKit(r) == null) {
					return;
				}
				if(r.getLocation().getY() >= 63) {
					return;
				}
				if(r.isDead()) {
					return;
				}
				final List<Location> cuboid = new ArrayList<Location>();
				for (int bX = -10; bX <= 10; ++bX) {
					for (int bZ = -10; bZ <= 10; ++bZ) {
						for (int bY = -1; bY <= 10; ++bY) {
							final Block b = loc.clone().add((double) bX, (double) bY, (double) bZ).getBlock();
							if (!b.isEmpty()) {
								p.sendMessage(Base.prefix + "§7Não é possível criar uma arena neste local!");
								return;
							}
							if (bY == 10) {
								cuboid.add(loc.clone().add((double) bX, (double) bY, (double) bZ));
							} else if (bY == -1) {
								cuboid.add(loc.clone().add((double) bX, (double) bY, (double) bZ));
							} else if (bX == -10 || bZ == -10 || bX == 10 || bZ == 10) {
								cuboid.add(loc.clone().add((double) bX, (double) bY, (double) bZ));
							}
						}
					}
				}
				for (final Location loc4 : cuboid) {
					loc4.getBlock().setType(Material.GLASS);
					this.gladiatorbloco.add(loc4.getBlock());
					this.gladblock.put(loc4.getBlock(), p);
					this.gladblock.put(loc4.getBlock(), r);
				}
				this.lugar.put(p, p.getLocation());
				this.lugar.put(r, r.getLocation());
				p.teleport(loc2);
				r.teleport(loc3);
				p.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 110, 5));
				r.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 110, 5));
				this.lutando.put(p, r);
				this.lutando.put(r, p);
				this.glad2 = Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, (Runnable) new Runnable() {
					@SuppressWarnings("unlikely-arg-type")
					@Override
					public void run() {
						if (Gladiator.this.lutando.containsKey(p) && Gladiator.this.lutando.containsKey(r)) {
							Gladiator.this.lutando.remove(p);
							Gladiator.this.lutando.remove(r);
							p.teleport((Location) Gladiator.this.lugar.get(p));
							r.teleport((Location) Gladiator.this.lugar.get(r));
							for (final Block glad : Gladiator.this.gladiatorbloco) {
								if ((Gladiator.this.gladblock.get(glad) == r || Gladiator.this.gladblock.get(glad) == p)
										&& glad.getType() == Material.GLASS) {
									glad.setType(Material.AIR);
								}
							}
							Gladiator.this.lugar.remove(p);
							Gladiator.this.lugar.remove(r);
							Gladiator.this.gladblock.remove(p);
							Gladiator.this.gladblock.remove(r);
						}
					}
				}, 6000L);
			}
		}
	}
	
	@SuppressWarnings("unlikely-arg-type")
	@EventHandler
	void KitGladiatorInteragir(final BlockBreakEvent e) {
		final Player p = e.getPlayer();
		if (this.gladiatorbloco.contains(p) && p.getGameMode() != GameMode.CREATIVE) {
			e.setCancelled(true);
		}
	}

	@SuppressWarnings({ "unlikely-arg-type", "static-access" })
	@EventHandler
	void KitGladiatorSair(final PlayerQuitEvent e) {
		final Player p = e.getPlayer();
		if (this.lutando.containsKey(p)) {
			final String nome = this.lutando.get(p).getName();
			final Player q = Bukkit.getPlayer(nome);
			this.lutando.remove(p);
			this.lutando.remove(q);
			q.sendMessage(String.valueOf(Base.prefix + "§c" + p.getName() + " §7deslogou e você venceu!"));
			q.teleport((Location) this.lugar.get(q));
			Bukkit.getScheduler().cancelTask(this.glad1);
			Bukkit.getScheduler().cancelTask(this.glad2);
			for (final Block glad : this.gladiatorbloco) {
				if ((this.gladblock.get(glad) == q || this.gladblock.get(glad) == p)
						&& glad.getType() == Material.GLASS) {
					glad.setType(Material.AIR);
				}
			}
			this.gladblock.remove(p);
			this.gladblock.remove(q);
		}
	}

	@SuppressWarnings({ "unlikely-arg-type", "static-access" })
	@EventHandler
	void KitGladiatorMorrer(final PlayerDeathEvent e) {
		final Player p = e.getEntity();
		if (this.lutando.containsKey(p)) {
			final String nome = this.lutando.get(p).getName();
			final Player m = Bukkit.getPlayer(nome);
			m.sendMessage(Base.prefix + "§7Você venceu a batalha contra §f" + p.getName() + "§7.");
			p.sendMessage(Base.prefix + "§7Você perdeu a batalha contra §f" + m.getName() + "§7.");
			this.lutando.remove(p);
			this.lutando.remove(m);
			m.teleport((Location) this.lugar.get(m));
			m.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 100, 10));
			Bukkit.getScheduler().cancelTask(this.glad1);
			Bukkit.getScheduler().cancelTask(this.glad2);
			for (final Block glad : this.gladiatorbloco) {
				if ((this.gladblock.get(glad) == m || this.gladblock.get(glad) == p)
						&& glad.getType() == Material.GLASS) {
					glad.setType(Material.AIR);
				}
			}
			this.gladblock.remove(p);
			this.gladblock.remove(m);
			if(Base.qualKit(m) == "Gladiator") {
				CooldownAPI.addCooldown(m, 5);
				CooldownAPI.mCooldown(p, "Gladiator");
			}
		}
	}

	@SuppressWarnings("static-access")
	@EventHandler
	void KitGladiatorComando(final PlayerCommandPreprocessEvent e) {
		final Player p = e.getPlayer();
		if (this.lutando.containsKey(p)) {
			e.setCancelled(true);
			p.sendMessage(Base.prefix + "§7Você não pode usar comandos no §cGladiator§7.");
		}
	}
}
