package com.Legend.events;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockExplodeEvent;
import org.bukkit.event.block.BlockIgniteEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.player.PlayerAchievementAwardedEvent;
import org.bukkit.event.player.PlayerBedEnterEvent;
import org.bukkit.event.player.PlayerChatTabCompleteEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerPortalEvent;
import org.bukkit.event.weather.WeatherChangeEvent;

import com.Legend.Main;
import com.Legend.Comandos.Builder;
import com.Legend.Comandos.Change;
import com.Legend.kits.Checkpoint;
import com.Legend.kits.manager.Base;
import com.Legend.kits.manager.CooldownAPI;
import com.Legend.register.APIr;

public class PrincipaisEventos implements Listener {

	@EventHandler(priority = EventPriority.HIGH)
	public void explodir(EntityExplodeEvent e) {
		e.setCancelled(true);
	}

	@EventHandler
	public void explodir2(BlockIgniteEvent e) {
		e.setCancelled(true);
	}

	@EventHandler
	public void exp(BlockExplodeEvent e) {
		e.setCancelled(true);
	}

	@EventHandler
	public void mover(PlayerMoveEvent e) {
		if (!(APIr.logado.contains(e.getPlayer().getName()))) {
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void fome(FoodLevelChangeEvent e) {
		e.setCancelled(true);
	}

	@EventHandler
	public static void dropitem(PlayerDropItemEvent e) {

		if (e.getItemDrop().getItemStack().getType() == Material.BOOK
				|| e.getItemDrop().getItemStack().getType() == Material.STONE_SWORD
				|| e.getItemDrop().getItemStack().getType() == Material.DIAMOND
				|| e.getItemDrop().getItemStack().getType() == Material.VINE
				|| e.getItemDrop().getItemStack().getType() == Material.CHEST
				|| e.getItemDrop().getItemStack().getType() == Material.FIREWORK
				|| e.getItemDrop().getItemStack().getType() == Material.FISHING_ROD
				|| e.getItemDrop().getItemStack().getType() == Material.IRON_AXE
				|| e.getItemDrop().getItemStack().getType() == Material.IRON_FENCE
				|| e.getItemDrop().getItemStack().getType() == Material.BOW
				|| e.getItemDrop().getItemStack().getType() == Material.ARROW
				|| e.getItemDrop().getItemStack().getType() == Material.IRON_HELMET
				|| e.getItemDrop().getItemStack().getType() == Material.LEATHER_CHESTPLATE
				|| e.getItemDrop().getItemStack().getType() == Material.LEATHER_BOOTS
				|| e.getItemDrop().getItemStack().getType() == Material.NETHER_STAR
				|| e.getItemDrop().getItemStack().getType() == Material.WOOD_SWORD
				|| e.getItemDrop().getItemStack().getType() == Material.GOLD_AXE
				|| e.getItemDrop().getItemStack().getType() == Material.FLINT
				|| e.getItemDrop().getItemStack().getType() == Material.ENDER_PORTAL_FRAME
				|| e.getItemDrop().getItemStack().getType() == Material.WOOD_HOE
				|| e.getItemDrop().getItemStack().getType() == Material.STICK
				|| e.getItemDrop().getItemStack().getType() == Material.CHAINMAIL_CHESTPLATE
				|| e.getItemDrop().getItemStack().getType() == Material.GHAST_TEAR
				|| e.getItemDrop().getItemStack().getType() == Material.REDSTONE_BLOCK
				|| e.getItemDrop().getItemStack().getType() == Material.TNT
				|| e.getItemDrop().getItemStack().getType() == Material.STONE_BUTTON
				|| e.getItemDrop().getItemStack().getType() == Material.LAPIS_BLOCK
				|| e.getItemDrop().getItemStack().getType() == Material.FEATHER
				|| e.getItemDrop().getItemStack().getType() == Material.GLASS_BOTTLE
				|| e.getItemDrop().getItemStack().getType() == Material.PACKED_ICE
				|| e.getItemDrop().getItemStack().getType() == Material.ENDER_PORTAL_FRAME
				|| e.getItemDrop().getItemStack().getType() == Material.BLAZE_ROD
				|| e.getItemDrop().getItemStack().getType() == Material.EMERALD
				|| e.getItemDrop().getItemStack().getType() == Material.INK_SACK
				|| e.getItemDrop().getItemStack().getType() == Material.MAGMA_CREAM
				|| e.getItemDrop().getItemStack().getType() == Material.COMPASS
				|| e.getItemDrop().getItemStack().getType() == Material.PAPER
				|| e.getItemDrop().getItemStack().getType() == Material.DIAMOND_SWORD) {
			e.setCancelled(true);
		}
	}

	@EventHandler(priority = EventPriority.HIGH)
	public void weather(WeatherChangeEvent e) {
		e.setCancelled(true);
	}

	@EventHandler
	public void cancel(PlayerCommandPreprocessEvent e) {
		if (e.getMessage().startsWith("//calc")) {
			e.setCancelled(true);
		}
		Player p = e.getPlayer();
		if (!(APIr.logado.contains(p.getName()))) {
			if (e.getMessage().startsWith("/register") || e.getMessage().startsWith("/login")
					|| e.getMessage().startsWith("/registrar") || e.getMessage().startsWith("/cadastrar")
					|| e.getMessage().startsWith("/entrar") || e.getMessage().startsWith("/logar")) {
			} else {
				e.setCancelled(true);
			}
		}
	}

	@EventHandler
	public void por(BlockPlaceEvent e) {
		Player p = e.getPlayer();
		if (Builder.pode.contains(p.getName())) {
		} else if (!(Builder.pode.contains(p.getName()))) {
			if ((e.getItemInHand() != null && e.getItemInHand().getType() == Material.NETHER_FENCE)
					&& (Base.qualKit(p) == "Checkpoint")) {
				if (!(CooldownAPI.SemCooldown(p))) {
					e.setBuild(false);
					e.setCancelled(true);
					return;
				}
				if ((Checkpoint.hit.containsKey(p.getUniqueId()))
						&& (Checkpoint.hit.get(p.getUniqueId()) > System.currentTimeMillis())) {
					p.sendMessage(Base.prefix + "§cVocê foi hitado recentemente, espere um pouco para usar o checkpoint!");
					e.setCancelled(true);
					e.setBuild(false);
					p.updateInventory();
					return;
				}
				CooldownAPI.mCooldown(p, "CheckPoint");
				p.setItemInHand(e.getItemInHand());
				p.updateInventory();
				Checkpoint.checkpoints.put(p.getUniqueId(), e.getBlock().getLocation());
			}
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void Achievement(PlayerAchievementAwardedEvent e) {
		e.setCancelled(true);
	}

	@EventHandler
	public void Cama(PlayerBedEnterEvent e) {
		e.setCancelled(true);
	}

	@EventHandler
	public void Portal(PlayerPortalEvent e) {
		e.setCancelled(true);
	}

	@EventHandler(priority = EventPriority.HIGH)
	public void onCreeperExplosion(EntityExplodeEvent event) {
		event.setCancelled(true);
	}

	@EventHandler
	public void desativarComandos(PlayerCommandPreprocessEvent e) {
		for (String key : Main.server.getConfig().getConfigurationSection("Comandos.").getKeys(false)) {
			if (Change.actC(key) == false) {
				if (e.getMessage().toLowerCase().startsWith("/" + key.toString())) {
					e.getPlayer().sendMessage(key);
					e.getPlayer().sendMessage(Base.prefix + "§bEsse comando está desativado!");
					e.setCancelled(true);
				}
			}
		}
		if (!(e.getPlayer().isOp())) {
			if (((e.getMessage().toLowerCase().startsWith("/pl") || e.getMessage().toLowerCase().startsWith("/plugins")
					|| e.getMessage().toLowerCase().startsWith("/?") || e.getMessage().toLowerCase().startsWith("/rl")
					|| e.getMessage().toLowerCase().startsWith("/achievement")
					|| e.getMessage().toLowerCase().startsWith("/bukkit")
					|| e.getMessage().toLowerCase().startsWith("/ver")
					|| e.getMessage().toLowerCase().startsWith("/bukkit:")
					|| e.getMessage().toLowerCase().startsWith("/bukkit:me")
					|| e.getMessage().toLowerCase().startsWith("/help")
					|| e.getMessage().toLowerCase().startsWith("/me")
					|| e.getMessage().toLowerCase().startsWith("/reload")
					|| e.getMessage().toLowerCase().startsWith("/bukkit:plugins")
					|| e.getMessage().toLowerCase().startsWith("/skin")))
					|| e.getMessage().toLowerCase().startsWith("/stop")
					|| e.getMessage().toLowerCase().startsWith("/op")
					|| e.getMessage().toLowerCase().startsWith("/deop")
					|| e.getMessage().toLowerCase().startsWith("/wg")
					|| e.getMessage().toLowerCase().startsWith("/worldguard")
					|| e.getMessage().toLowerCase().startsWith("/we")
					|| e.getMessage().toLowerCase().startsWith("/worldedit")
					|| e.getMessage().toLowerCase().startsWith("/lp")
					|| e.getMessage().toLowerCase().startsWith("/luckperms")
					|| e.getMessage().toLowerCase().startsWith("/antiop")
					|| e.getMessage().toLowerCase().startsWith("/protocol")
					|| e.getMessage().toLowerCase().startsWith("/gpr")
					|| e.getMessage().toLowerCase().startsWith("/gprotector")
					|| e.getMessage().toLowerCase().startsWith("/god")
					|| e.getMessage().toLowerCase().startsWith("/ungod")
					|| e.getMessage().toLowerCase().startsWith("/about")
					|| e.getMessage().toLowerCase().startsWith("/?")
					|| e.getMessage().toLowerCase().startsWith("/ver")
					|| e.getMessage().toLowerCase().startsWith("/tps")) {
				e.setCancelled(true);
			}
		}
	}

	@EventHandler
	public void disableTab(PlayerChatTabCompleteEvent e) {
		if (!(e.getPlayer().isOp())) {
			if ((e.getChatMessage().toLowerCase().contains("ver") || e.getChatMessage().toLowerCase().contains("about")
					|| e.getChatMessage().toLowerCase().contains("?")
					|| e.getChatMessage().toLowerCase().contains("version")
					|| e.getChatMessage().toLowerCase().contains("skin")
					|| e.getChatMessage().toLowerCase().startsWith("/pl")
					|| e.getChatMessage().toLowerCase().startsWith("/plugins")
					|| e.getChatMessage().toLowerCase().startsWith("/?")
					|| e.getChatMessage().toLowerCase().startsWith("/rl")
					|| e.getChatMessage().toLowerCase().startsWith("/achievement")
					|| e.getChatMessage().toLowerCase().startsWith("/bukkit")
					|| e.getChatMessage().toLowerCase().startsWith("/ver")
					|| e.getChatMessage().toLowerCase().startsWith("/bukkit:")
					|| e.getChatMessage().toLowerCase().startsWith("/bukkit:me")
					|| e.getChatMessage().toLowerCase().startsWith("/help")
					|| e.getChatMessage().toLowerCase().startsWith("/me")
					|| e.getChatMessage().toLowerCase().startsWith("/reload")
					|| e.getChatMessage().toLowerCase().startsWith("/bukkit:plugins")
					|| e.getChatMessage().toLowerCase().startsWith("/skin")
					|| e.getChatMessage().toLowerCase().startsWith("/stop")
					|| e.getChatMessage().toLowerCase().startsWith("/op")
					|| e.getChatMessage().toLowerCase().startsWith("/deop")
					|| e.getChatMessage().toLowerCase().startsWith("/wg")
					|| e.getChatMessage().toLowerCase().startsWith("/worldguard")
					|| e.getChatMessage().toLowerCase().startsWith("/we")
					|| e.getChatMessage().toLowerCase().startsWith("/worldedit")
					|| e.getChatMessage().toLowerCase().startsWith("/lp")
					|| e.getChatMessage().toLowerCase().startsWith("/luckperms")
					|| e.getChatMessage().toLowerCase().startsWith("/antiop")
					|| e.getChatMessage().toLowerCase().startsWith("/protocol")
					|| e.getChatMessage().toLowerCase().startsWith("/gpr")
					|| e.getChatMessage().toLowerCase().startsWith("/gprotector")
					|| e.getChatMessage().toLowerCase().startsWith("/god")
					|| e.getChatMessage().toLowerCase().startsWith("/ungod")
					|| e.getChatMessage().toLowerCase().startsWith("/?")
					|| e.getChatMessage().toLowerCase().startsWith("/ver"))) {
				e.getTabCompletions().clear();
				e.getChatMessage().charAt(0);
			}
		}
	}

}
