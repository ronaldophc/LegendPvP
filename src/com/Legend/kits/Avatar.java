package com.Legend.kits;

import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.BlockIterator;
import org.bukkit.util.Vector;

import com.Legend.Main;
import com.Legend.KD.API;
import com.Legend.kits.manager.Base;
import com.Legend.kits.manager.CooldownAPI;


public class Avatar implements Listener {

	public static ItemStack getItem(ItemStack item) {
		if (item.getType() == Material.BEACON) {
			ItemStack a = API.Item(Material.WOOL, "§aAvatar", 1, (byte)0);
			return a;
		}
		if (item.getType() == Material.WOOL) {
			ItemStack a = API.Item(Material.REDSTONE_BLOCK, "§aAvatar", 1, (byte)0);
			return a;
		}
		if (item.getType() == Material.REDSTONE_BLOCK) {
			ItemStack a = API.Item(Material.LAPIS_BLOCK, "§aAvatar", 1, (byte)0);
			return a;
		}
		if (item.getType() == Material.LAPIS_BLOCK) {
			ItemStack a = API.Item(Material.GRASS, "§aAvatar", 1, (byte)0);
			return a;
		}
		if (item.getType() == Material.GRASS) {
			ItemStack a = API.Item(Material.WOOL, "§aAvatar", 1, (byte)0);
			return a;
		}
		return API.Item(Material.BEACON, "§aAvatar", 1, (byte)0);
	}

	@EventHandler
	public void asd(PlayerInteractEvent e) {
		Player player = e.getPlayer();
		if (Base.qualKit(player) == "Avatar") {
			if (player.getItemInHand().getType() == Material.AIR) {
				return;
			}
			if (player.getItemInHand() == null) {
				return;
			}
			if (!(player.getItemInHand().hasItemMeta())) {
				return;
			}
			if (!(player.getItemInHand().getItemMeta().hasDisplayName())) {
				return;
			}
			if (!player.getItemInHand().getItemMeta().getDisplayName().equals("§aAvatar")) {
				return;
			}
			if (e.getAction() == Action.LEFT_CLICK_AIR || e.getAction() == Action.LEFT_CLICK_BLOCK) {
				player.setItemInHand(getItem(player.getItemInHand()));
			} else {
				e.setCancelled(true);
				if (player.getLocation().getY() >= 63) {
					if (!Gladiator.lutando.containsKey(player) && !Gladiator.lutando.containsValue(player)) {
						return;
					}
				}
				if (!(CooldownAPI.SemCooldown(player))) {
					return;
				}
				Material item = player.getItemInHand().getType();
				if (item == Material.BEACON) {
					player.setItemInHand(API.Item(Material.WOOL, "§aAvatar", 1, (byte) 0));
					return;
				}
				CooldownAPI.addCooldown(player, 10);
				CooldownAPI.mCooldown(player, "Avatar");
				if (item == Material.WOOL) {
					Vector Ferro = player.getLocation().getDirection().normalize().multiply(55);
					Snowball FerroH = (Snowball) player.launchProjectile(Snowball.class);
					FerroH.setVelocity(Ferro);
					FerroH.setMetadata("Vento", new FixedMetadataValue(Main.getPlugin(), Boolean.valueOf(true)));

					Location pegou = player.getEyeLocation();

					BlockIterator Ferrao = new BlockIterator(pegou, 0.0D, 40);
					while (Ferrao.hasNext()) {
						Location Ferrao2 = Ferrao.next().getLocation();

						Effect camelo = Effect.STEP_SOUND;
						player.playSound(player.getLocation(), Sound.STEP_WOOL, 5.5F, 5.5F);
						player.playSound(player.getLocation(), Sound.STEP_WOOL, 1.5F, 1.5F);
						player.playSound(player.getLocation(), Sound.STEP_WOOL, 2.5F, 2.5F);
						player.playSound(player.getLocation(), Sound.STEP_WOOL, 3.5F, 3.5F);
						player.playSound(player.getLocation(), Sound.STEP_WOOL, 4.5F, 4.5F);

						player.getWorld().playEffect(Ferrao2, camelo, 35);
					}
				} else if (item == Material.LAPIS_BLOCK) {
					Vector Ferro = player.getLocation().getDirection().normalize().multiply(55);
					Snowball FerroH = (Snowball) player.launchProjectile(Snowball.class);
					FerroH.setVelocity(Ferro);
					FerroH.setMetadata("Agua", new FixedMetadataValue(Main.getPlugin(), Boolean.valueOf(true)));

					Location pegou = player.getEyeLocation();

					BlockIterator Ferrao = new BlockIterator(pegou, 0.0D, 40);
					while (Ferrao.hasNext()) {
						Location Ferrao2 = Ferrao.next().getLocation();

						Effect camelo = Effect.STEP_SOUND;
						player.playSound(player.getLocation(), Sound.STEP_WOOD, 5.5F, 5.5F);
						player.playSound(player.getLocation(), Sound.STEP_WOOD, 1.5F, 1.5F);
						player.playSound(player.getLocation(), Sound.STEP_WOOD, 2.5F, 2.5F);
						player.playSound(player.getLocation(), Sound.STEP_WOOD, 3.5F, 3.5F);
						player.playSound(player.getLocation(), Sound.STEP_WOOD, 4.5F, 4.5F);

						player.getWorld().playEffect(Ferrao2, camelo, 35);
					}
				} else if (item == Material.REDSTONE_BLOCK) {
					Vector Ferro = player.getLocation().getDirection().normalize().multiply(55);
					Snowball FerroH = (Snowball) player.launchProjectile(Snowball.class);
					FerroH.setVelocity(Ferro);
					FerroH.setMetadata("Fogo", new FixedMetadataValue(Main.getPlugin(), Boolean.valueOf(true)));

					Location pegou = player.getEyeLocation();

					BlockIterator Ferrao = new BlockIterator(pegou, 0.0D, 40);
					while (Ferrao.hasNext()) {
						Location Ferrao2 = Ferrao.next().getLocation();

						Effect camelo = Effect.STEP_SOUND;
						player.playSound(player.getLocation(), Sound.FIRE, 5.5F, 5.5F);
						player.playSound(player.getLocation(), Sound.FIRE, 1.5F, 1.5F);
						player.playSound(player.getLocation(), Sound.FIRE, 2.5F, 2.5F);
						player.playSound(player.getLocation(), Sound.FIRE, 3.5F, 3.5F);
						player.playSound(player.getLocation(), Sound.FIRE, 4.5F, 4.5F);

						player.getWorld().playEffect(Ferrao2, camelo, 35);
					}
				} else if (item == Material.GRASS) {
					Vector Ferro = player.getLocation().getDirection().normalize().multiply(55);
					Snowball FerroH = (Snowball) player.launchProjectile(Snowball.class);
					FerroH.setVelocity(Ferro);
					FerroH.setMetadata("Terra", new FixedMetadataValue(Main.getPlugin(), Boolean.valueOf(true)));

					Location pegou = player.getEyeLocation();

					BlockIterator Ferrao = new BlockIterator(pegou, 0.0D, 40);
					while (Ferrao.hasNext()) {
						Location Ferrao2 = Ferrao.next().getLocation();

						Effect camelo = Effect.STEP_SOUND;
						player.playSound(player.getLocation(), Sound.STEP_GRASS, 5.5F, 5.5F);
						player.playSound(player.getLocation(), Sound.STEP_GRASS, 1.5F, 1.5F);
						player.playSound(player.getLocation(), Sound.STEP_GRASS, 2.5F, 2.5F);
						player.playSound(player.getLocation(), Sound.STEP_GRASS, 3.5F, 3.5F);
						player.playSound(player.getLocation(), Sound.STEP_GRASS, 4.5F, 4.5F);

						player.getWorld().playEffect(Ferrao2, camelo, 35);
					}
				}
			}
		}
	}

	@EventHandler
	public void asd(EntityDamageByEntityEvent e) {
		Entity entity = e.getEntity();
		if (e.getDamager() instanceof Snowball) {
			Snowball snow = (Snowball) e.getDamager();
			if (snow.hasMetadata("Terra")) {
				((LivingEntity) entity).damage(4.0D);
				Vector vector = entity.getLocation().getDirection();
				vector.multiply(-3.5F);
				entity.setVelocity(vector);
			} else if (snow.hasMetadata("Fogo")) {
				((LivingEntity) entity).damage(6.0D);
				entity.setFireTicks(200);
			} else if (snow.hasMetadata("Agua")) {
				((LivingEntity) entity).damage(5.0D);
				((LivingEntity) entity).addPotionEffect(new PotionEffect(PotionEffectType.POISON, 20 * 5, 3));
				Vector vector = entity.getLocation().getDirection();
				vector.multiply(-1.0F);
				entity.setVelocity(vector);
			} else if (snow.hasMetadata("Vento")) {
				((LivingEntity) entity).damage(9.0D);
				((LivingEntity) entity).addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 20 * 3, 3));
			}
		}
	}

}
