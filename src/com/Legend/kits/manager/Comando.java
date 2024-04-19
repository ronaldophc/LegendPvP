package com.Legend.kits.manager;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.Legend.Comandos.Change;
import com.Legend.guis.Inventario;

public class Comando implements CommandExecutor {

	public static List<Player> Arena = new ArrayList<>();

	public static void remove(Player p) {
		Comando.Arena.remove(p);
	}

	public static void add(Player p) {
		if (Comando.Arena.contains(p)) {
		} else {
			Comando.Arena.add(p);
		}
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if (!(sender instanceof Player)) {
			return true;
		}
		if (cmd.getName().equalsIgnoreCase("Kit")) {
			Player p = (Player) sender;
			if (args.length == 0) {
				Inventario.seletorKits(p);
			}
			if (args.length == 1) {
				String kit = args[0];
				if(Change.actKit(kit) == false) {
					p.sendMessage(Base.prefix + "§bEsse kit está desativado!");
					return true;
				}
				if (args[0].equalsIgnoreCase("Viper")) {
					if (p.hasPermission("Legend.Kit.Viper")) {
						if (Base.temKit(p) == false) {
							Base.setaraKit(p, "Viper");
							Base.darItens(p);
							p.sendMessage(Base.prefix + "§bVocê selecionou o §fKit §6Viper§b!");
						} else {
							p.sendMessage(Base.prefix + "§bVocê não pode pegar §fKit§b!");
						}
					} else {
						p.sendMessage(Base.prefix + "§bVocê não tem permissão para pegar esse §fKit§b!");
					}
				} else if (args[0].equalsIgnoreCase("pvp")) {
					if (p.hasPermission("Legend.Kit.sharpness")) {
						if (Base.temKit(p) == false) {
							Base.setaraKit(p, "PvP");
							Base.darItens(p);
							p.sendMessage(Base.prefix + "§bVocê selecionou o §fKit §6PvP§b!");
						} else {
							p.sendMessage(Base.prefix + "§bVocê não pode pegar §fKit§b!");
						}
					} else {
						p.sendMessage(Base.prefix + "§bVocê não tem permissão para pegar esse §fKit§b!");
					}
				} else if (args[0].equalsIgnoreCase("resouper")) {
					if (p.hasPermission("Legend.Kit.resouper")) {
						if (Base.temKit(p) == false) {
							Base.setaraKit(p, "Resouper");
							Base.darItens(p);
							p.sendMessage(Base.prefix + "§bVocê selecionou o §fKit §6Resouper§b!");
						} else {
							p.sendMessage(Base.prefix + "§bVocê não pode pegar §fKit§b!");
						}
					} else {
						p.sendMessage(Base.prefix + "§bVocê não tem permissão para pegar esse §fKit§b!");
					}
				} else if (args[0].equalsIgnoreCase("checkpoint")) {
					if (p.hasPermission("Legend.Kit.checkpoint")) {
						if (Base.temKit(p) == false) {
							Base.setaraKit(p, "Checkpoint");
							Base.darItens(p);
							p.sendMessage(Base.prefix + "§bVocê selecionou o §fKit §6CheckPoint§b!");
						} else {
							p.sendMessage(Base.prefix + "§bVocê não pode pegar §fKit§b!");
						}
					} else {
						p.sendMessage(Base.prefix + "§bVocê não tem permissão para pegar esse §fKit§b!");
					}
				} else if (args[0].equalsIgnoreCase("Switcher")) {
					if (p.hasPermission("Legend.Kit.Switcher")) {
						if (Base.temKit(p) == false) {
							Base.setaraKit(p, "Switcher");
							Base.darItens(p);
							p.sendMessage(Base.prefix + "§bVocê selecionou o §fKit §6Switcher§b!");
						} else {
							p.sendMessage(Base.prefix + "§bVocê não pode pegar §fKit§b!");
						}
					} else {
						p.sendMessage(Base.prefix + "§bVocê não tem permissão para pegar esse §fKit§b!");
					}
				} else if (args[0].equalsIgnoreCase("Scout")) {
					if (p.hasPermission("Legend.Kit.Scout")) {
						if (Base.temKit(p) == false) {
							Base.setaraKit(p, "Scout");
							Base.darItens(p);
							p.sendMessage(Base.prefix + "§bVocê selecionou o §fKit §6Scout§b!");
						} else {
							p.sendMessage(Base.prefix + "§bVocê não pode pegar §fKit§b!");
						}
					} else {
						p.sendMessage(Base.prefix + "§bVocê não tem permissão para pegar esse §fKit§b!");
					}
				} else if (args[0].equalsIgnoreCase("Pyro")) {
					if (p.hasPermission("Legend.Kit.Pyro")) {
						if (Base.temKit(p) == false) {
							Base.setaraKit(p, "Pyro");
							Base.darItens(p);
							p.sendMessage(Base.prefix + "§bVocê selecionou o §fKit §6Pyro§b!");
						} else {
							p.sendMessage(Base.prefix + "§bVocê não pode pegar §fKit§b!");
						}
					} else {
						p.sendMessage(Base.prefix + "§bVocê não tem permissão para pegar esse §fKit§b!");
					}
				} else if (args[0].equalsIgnoreCase("Goku")) {
					if (p.hasPermission("Legend.Kit.Goku")) {
						if (Base.temKit(p) == false) {
							Base.setaraKit(p, "Goku");
							Base.darItens(p);
							p.sendMessage(Base.prefix + "§bVocê selecionou o §fKit §6Goku§b!");
						} else {
							p.sendMessage(Base.prefix + "§bVocê não pode pegar §fKit§b!");
						}
					} else {
						p.sendMessage(Base.prefix + "§bVocê não tem permissão para pegar esse §fKit§b!");
					}
				} else if (args[0].equalsIgnoreCase("Achilles")) {
					if (p.hasPermission("Legend.Kit.Achilles")) {
						if (Base.temKit(p) == false) {
							Base.setaraKit(p, "Achilles");
							Base.darItens(p);
							p.sendMessage(Base.prefix + "§bVocê selecionou o §fKit §6Achilles§b!");
						} else {
							p.sendMessage(Base.prefix + "§bVocê não pode pegar §fKit§b!");
						}
					} else {
						p.sendMessage(Base.prefix + "§bVocê não tem permissão para pegar esse §fKit§b!");
					}
				} else if (args[0].equalsIgnoreCase("Phantom")) {
					if (p.hasPermission("Legend.Kit.Phantom")) {
						if (Base.temKit(p) == false) {
							Base.setaraKit(p, "Phantom");
							Base.darItens(p);
							p.sendMessage(Base.prefix + "§bVocê selecionou o §fKit §6Phantom§b!");
						} else {
							p.sendMessage(Base.prefix + "§bVocê não pode pegar §fKit§b!");
						}
					} else {
						p.sendMessage(Base.prefix + "§bVocê não tem permissão para pegar esse §fKit§b!");
					}
				} else if (args[0].equalsIgnoreCase("Ghost")) {
					if (p.hasPermission("Legend.Kit.Ghost")) {
						if (Base.temKit(p) == false) {
							Base.setaraKit(p, "Ghost");
							Base.darItens(p);
							p.sendMessage(Base.prefix + "§bVocê selecionou o §fKit §6Ghost§b!");
						} else {
							p.sendMessage(Base.prefix + "§bVocê não pode pegar §fKit§b!");
						}
					} else {
						p.sendMessage(Base.prefix + "§bVocê não tem permissão para pegar esse §fKit§b!");
					}
				} else if (args[0].equalsIgnoreCase("c4")) {
					if (p.hasPermission("Legend.Kit.c4")) {
						if (Base.temKit(p) == false) {
							Base.setaraKit(p, "C4");
							Base.darItens(p);
							p.sendMessage(Base.prefix + "§bVocê selecionou o §fKit §6C4§b!");
						} else {
							p.sendMessage(Base.prefix + "§bVocê não pode pegar §fKit§b!");
						}
					} else {
						p.sendMessage(Base.prefix + "§bVocê não tem permissão para pegar esse §fKit§b!");
					}
				} else if (args[0].equalsIgnoreCase("reaper")) {
					if (p.hasPermission("Legend.Kit.reaper")) {
						if (Base.temKit(p) == false) {
							Base.setaraKit(p, "Reaper");
							Base.darItens(p);
							p.sendMessage(Base.prefix + "§bVocê selecionou o §fKit §6Reaper§b!");
						} else {
							p.sendMessage(Base.prefix + "§bVocê não pode pegar §fKit§b!");
						}
					} else {
						p.sendMessage(Base.prefix + "§bVocê não tem permissão para pegar esse §fKit§b!");
					}
				} else if (args[0].equalsIgnoreCase("LifeStealer")) {
					if (p.hasPermission("Legend.Kit.LifeStealer")) {
						if (Base.temKit(p) == false) {
							Base.setaraKit(p, "LifeStealer");
							Base.darItens(p);
							p.sendMessage(Base.prefix + "§bVocê selecionou o §fKit §6LifeStealer§b!");
						} else {
							p.sendMessage(Base.prefix + "§bVocê não pode pegar §fKit§b!");
						}
					} else {
						p.sendMessage(Base.prefix + "§bVocê não tem permissão para pegar esse §fKit§b!");
					}
				} else if (args[0].equalsIgnoreCase("Naruto")) {
					if (p.hasPermission("Legend.Kit.Naruto")) {
						if (Base.temKit(p) == false) {
							Base.setaraKit(p, "Naruto");
							Base.darItens(p);
							p.sendMessage(Base.prefix + "§bVocê selecionou o §fKit §6Naruto§b!");
						} else {
							p.sendMessage(Base.prefix + "§bVocê não pode pegar §fKit§b!");
						}
					} else {
						p.sendMessage(Base.prefix + "§bVocê não tem permissão para pegar esse §fKit§b!");
					}
				} else if (args[0].equalsIgnoreCase("snail")) {
					if (p.hasPermission("Legend.Kit.snail")) {
						if (Base.temKit(p) == false) {
							Base.setaraKit(p, "Snail");
							Base.darItens(p);
							p.sendMessage(Base.prefix + "§bVocê selecionou o §fKit §6Snail§b!");
						} else {
							p.sendMessage(Base.prefix + "§bVocê não pode pegar §fKit§b!");
						}
					} else {
						p.sendMessage(Base.prefix + "§bVocê não tem permissão para pegar esse §fKit§b!");
					}
				} else if (args[0].equalsIgnoreCase("AntiCorona")) {
					if (p.hasPermission("Legend.Kit.AntiCorona")) {
						if (Base.temKit(p) == false) {
							Base.setaraKit(p, "AntiCorona");
							Base.darItens(p);
							p.sendMessage(Base.prefix + "§bVocê selecionou o §fKit §6AntiCorona§b!");
						} else {
							p.sendMessage(Base.prefix + "§bVocê não pode pegar §fKit§b!");
						}
					} else {
						p.sendMessage(Base.prefix + "§bVocê não tem permissão para pegar esse §fKit§b!");
					}
				} else if (args[0].equalsIgnoreCase("quickdroper")) {
					if (p.hasPermission("Legend.Kit.quickdroper")) {
						if (Base.temKit(p) == false) {
							Base.setaraKit(p, "QuickDroper");
							Base.darItens(p);
							p.sendMessage(Base.prefix + "§bVocê selecionou o §fKit §6Quick Droper§b!");
						} else {
							p.sendMessage(Base.prefix + "§bVocê não pode pegar §fKit§b!");
						}
					} else {
						p.sendMessage(Base.prefix + "§bVocê não tem permissão para pegar esse §fKit§b!");
					}
				} else if (args[0].equalsIgnoreCase("archer")) {
					if (p.hasPermission("Legend.Kit.archer")) {
						if (Base.temKit(p) == false) {
							Base.setaraKit(p, "Archer");
							Base.darItens(p);
							p.sendMessage(Base.prefix + "§bVocê selecionou o §fKit §6Archer§b!");
						} else {
							p.sendMessage(Base.prefix + "§bVocê não pode pegar §fKit§b!");
						}
					} else {
						p.sendMessage(Base.prefix + "§bVocê não tem permissão para pegar esse §fKit§b!");
					}
				} else if (args[0].equalsIgnoreCase("kangaroo")) {
					if (p.hasPermission("Legend.Kit.kangaroo")) {
						if (Base.temKit(p) == false) {
							Base.setaraKit(p, "Kangaroo");
							Base.darItens(p);
							p.sendMessage(Base.prefix + "§bVocê selecionou o §fKit §6Kangaroo§b!");
						} else {
							p.sendMessage(Base.prefix + "§bVocê não pode pegar §fKit§b!");
						}
					} else {
						p.sendMessage(Base.prefix + "§bVocê não tem permissão para pegar esse §fKit§b!");
					}
				} else if (args[0].equalsIgnoreCase("fisherman")) {
					if (p.hasPermission("Legend.Kit.fisherman")) {
						if (Base.temKit(p) == false) {
							Base.setaraKit(p, "Fisherman");
							Base.darItens(p);
							p.sendMessage(Base.prefix + "§bVocê selecionou o §fKit §6Fisherman§b!");
						} else {
							p.sendMessage(Base.prefix + "§bVocê não pode pegar §fKit§b!");
						}
					} else {
						p.sendMessage(Base.prefix + "§bVocê não tem permissão para pegar esse §fKit§b!");
					}
				} else if (args[0].equalsIgnoreCase("Viking")) {
					if (p.hasPermission("Legend.Kit.viking")) {
						if (Base.temKit(p) == false) {
							Base.setaraKit(p, "Viking");
							Base.darItens(p);
							p.sendMessage(Base.prefix + "§bVocê selecionou o §fKit §6Viking§b!");
						} else {
							p.sendMessage(Base.prefix + "§bVocê não pode pegar §fKit§b!");
						}
					} else {
						p.sendMessage(Base.prefix + "§bVocê não tem permissão para pegar esse §fKit§b!");
					}
				} else if (args[0].equalsIgnoreCase("Fireman")) {
					if (p.hasPermission("Legend.Kit.fireman")) {
						if (Base.temKit(p) == false) {
							Base.setaraKit(p, "Fireman");
							Base.darItens(p);
							p.sendMessage(Base.prefix + "§bVocê selecionou o §fKit §6Fireman§b!");
						} else {
							p.sendMessage(Base.prefix + "§bVocê não pode pegar §fKit§b!");
						}
					} else {
						p.sendMessage(Base.prefix + "§bVocê não tem permissão para pegar esse §fKit§b!");
					}
				} else if (args[0].equalsIgnoreCase("Camel")) {
					if (p.hasPermission("Legend.Kit.camel")) {
						if (Base.temKit(p) == false) {
							Base.setaraKit(p, "Camel");
							Base.darItens(p);
							p.sendMessage(Base.prefix + "§bVocê selecionou o §fKit §6Camel§b!");
						} else {
							p.sendMessage(Base.prefix + "§bVocê não pode pegar §fKit§b!");
						}
					} else {
						p.sendMessage(Base.prefix + "§bVocê não tem permissão para pegar esse §fKit§b!");
					}
				} else if (args[0].equalsIgnoreCase("tank")) {
					if (p.hasPermission("Legend.Kit.tank")) {
						if (Base.temKit(p) == false) {
							Base.setaraKit(p, "Tank");
							Base.darItens(p);
							p.sendMessage(Base.prefix + "§bVocê selecionou o §fKit §6Tank§b!");
						} else {
							p.sendMessage(Base.prefix + "§bVocê não pode pegar §fKit§b!");
						}
					} else {
						p.sendMessage(Base.prefix + "§bVocê não tem permissão para pegar esse §fKit§b!");
					}
				} else if (args[0].equalsIgnoreCase("gladiator")) {
					if (p.hasPermission("Legend.Kit.gladiator")) {
						if (Base.temKit(p) == false) {
							Base.setaraKit(p, "Gladiator");
							Base.darItens(p);
							p.sendMessage(Base.prefix + "§bVocê selecionou o §fKit §6Gladiator§b!");
						} else {
							p.sendMessage(Base.prefix + "§bVocê não pode pegar §fKit§b!");
						}
					} else {
						p.sendMessage(Base.prefix + "§bVocê não tem permissão para pegar esse §fKit§b!");
					}
				} else if (args[0].equalsIgnoreCase("boxer")) {
					if (p.hasPermission("Legend.Kit.boxer")) {
						if (Base.temKit(p) == false) {
							Base.setaraKit(p, "Boxer");
							Base.darItens(p);
							p.sendMessage(Base.prefix + "§bVocê selecionou o §fKit §6Boxer§b!");
						} else {
							p.sendMessage(Base.prefix + "§bVocê não pode pegar §fKit§b!");
						}
					} else {
						p.sendMessage(Base.prefix + "§bVocê não tem permissão para pegar esse §fKit§b!");
					}
				} else if (args[0].equalsIgnoreCase("upgrader")) {
					if (p.hasPermission("Legend.Kit.upgrader")) {
						if (Base.temKit(p) == false) {
							Base.setaraKit(p, "Upgrader");
							Base.darItens(p);
							p.sendMessage(Base.prefix + "§bVocê selecionou o §fKit §6Upgrader§b!");
						} else {
							p.sendMessage(Base.prefix + "§bVocê não pode pegar §fKit§b!");
						}
					} else {
						p.sendMessage(Base.prefix + "§bVocê não tem permissão para pegar esse §fKit§b!");
					}
				} else if (args[0].equalsIgnoreCase("stomper")) {
					if (p.hasPermission("Legend.Kit.stomper")) {
						if (Base.temKit(p) == false) {
							Base.setaraKit(p, "Stomper");
							Base.darItens(p);
							p.sendMessage(Base.prefix + "§bVocê selecionou o §fKit §6Stomper§b!");
						} else {
							p.sendMessage(Base.prefix + "§bVocê não pode pegar §fKit§b!");
						}
					} else {
						p.sendMessage(Base.prefix + "§bVocê não tem permissão para pegar esse §fKit§b!");
					}
				} else if (args[0].equalsIgnoreCase("corona")) {
					if (p.hasPermission("Legend.Kit.corona")) {
						if (Base.temKit(p) == false) {
							Base.setaraKit(p, "Corona");
							Base.darItens(p);
							p.sendMessage(Base.prefix + "§bVocê selecionou o §fKit §6Corona§b!");
						} else {
							p.sendMessage(Base.prefix + "§bVocê não pode pegar §fKit§b!");
						}
					} else {
						p.sendMessage(Base.prefix + "§bVocê não tem permissão para pegar esse §fKit§b!");
					}
				} else if (args[0].equalsIgnoreCase("thor")) {
					if (p.hasPermission("Legend.Kit.thor")) {
						if (Base.temKit(p) == false) {
							Base.setaraKit(p, "Thor");
							Base.darItens(p);
							p.sendMessage(Base.prefix + "§bVocê selecionou o §fKit §6Thor§b!");
						} else {
							p.sendMessage(Base.prefix + "§bVocê não pode pegar §fKit§b!");
						}
					} else {
						p.sendMessage(Base.prefix + "§bVocê não tem permissão para pegar esse §fKit§b!");
					}
				} else if (args[0].equalsIgnoreCase("Grandpa")) {
					if (p.hasPermission("Legend.Kit.Grandpa")) {
						if (Base.temKit(p) == false) {
							Base.setaraKit(p, "Grandpa");
							Base.darItens(p);
							p.sendMessage(Base.prefix + "§bVocê selecionou o §fKit §6Grandpa§b!");
						} else {
							p.sendMessage(Base.prefix + "§bVocê não pode pegar §fKit§b!");
						}
					} else {
						p.sendMessage(Base.prefix + "§bVocê não tem permissão para pegar esse §fKit§b!");
					}
				} else if (args[0].equalsIgnoreCase("Avatar")) {
					if (p.hasPermission("Legend.Kit.Avatar")) {
						if (Base.temKit(p) == false) {
							Base.setaraKit(p, "Avatar");
							Base.darItens(p);
							p.sendMessage(Base.prefix + "§bVocê selecionou o §fKit §6Avatar§b!");
						} else {
							p.sendMessage(Base.prefix + "§bVocê não pode pegar §fKit§b!");
						}
					} else {
						p.sendMessage(Base.prefix + "§bVocê não tem permissão para pegar esse §fKit§b!");
					}
				} else if (args[0].equalsIgnoreCase("Frozen")) {
					if (p.hasPermission("Legend.Kit.Frozen")) {
						if (Base.temKit(p) == false) {
							Base.setaraKit(p, "Frozen");
							Base.darItens(p);
							p.sendMessage(Base.prefix + "§bVocê selecionou o §fKit §6Frozen§b!");
						} else {
							p.sendMessage(Base.prefix + "§bVocê não pode pegar §fKit§b!");
						}
					} else {
						p.sendMessage(Base.prefix + "§bVocê não tem permissão para pegar esse §fKit§b!");
					}
				} else if (args[0].equalsIgnoreCase("Endermage")) {
					if (p.hasPermission("Legend.Kit.Endermage")) {
						if (Base.temKit(p) == false) {
							Base.setaraKit(p, "Endermage");
							Base.darItens(p);
							p.sendMessage(Base.prefix + "§bVocê selecionou o §fKit §6Endermage§b!");
						} else {
							p.sendMessage(Base.prefix + "§bVocê não pode pegar §fKit§b!");
						}
					} else {
						p.sendMessage(Base.prefix + "§bVocê não tem permissão para pegar esse §fKit§b!");
					}
				} else if (args[0].equalsIgnoreCase("hulk")) {
					if (p.hasPermission("Legend.Kit.hulk")) {
						if (Base.temKit(p) == false) {
							Base.setaraKit(p, "Hulk");
							Base.darItens(p);
							p.sendMessage(Base.prefix + "§bVocê selecionou o §fKit §6Hulk§b!");
						} else {
							p.sendMessage(Base.prefix + "§bVocê não pode pegar §fKit§b!");
						}
					} else {
						p.sendMessage(Base.prefix + "§bVocê não tem permissão para pegar esse §fKit§b!");
					}
				} else if (args[0].equalsIgnoreCase("ajnin")) {
					if (p.hasPermission("Legend.Kit.ajnin")) {
						if (Base.temKit(p) == false) {
							Base.setaraKit(p, "Ajnin");
							Base.darItens(p);
							p.sendMessage(Base.prefix + "§bVocê selecionou o §fKit §6Ajnin§b!");
						} else {
							p.sendMessage(Base.prefix + "§bVocê não pode pegar §fKit§b!");
						}
					} else {
						p.sendMessage(Base.prefix + "§bVocê não tem permissão para pegar esse §fKit§b!");
					}
				} else if (args[0].equalsIgnoreCase("ninja")) {
					if (p.hasPermission("Legend.Kit.ninja")) {
						if (Base.temKit(p) == false) {
							Base.setaraKit(p, "Ninja");
							Base.darItens(p);
							p.sendMessage(Base.prefix + "§bVocê selecionou o §fKit §6Ninja§b!");
						} else {
							p.sendMessage(Base.prefix + "§bVocê não pode pegar §fKit§b!");
						}
					} else {
						p.sendMessage(Base.prefix + "§bVocê não tem permissão para pegar esse §fKit§b!");
					}
				} else if (args[0].equalsIgnoreCase("tankup")) {
					if (p.hasPermission("Legend.Kit.tankup")) {
						if (Base.temKit(p) == false) {
							Base.setaraKit(p, "TankUp");
							Base.darItens(p);
							p.sendMessage(Base.prefix + "§bVocê selecionou o §fKit §6TankUp§b!");
						} else {
							p.sendMessage(Base.prefix + "§bVocê não pode pegar §fKit§b!");
						}
					} else {
						p.sendMessage(Base.prefix + "§bVocê não tem permissão para pegar esse §fKit§b!");
					}
				} else if (args[0].equalsIgnoreCase("berserker")) {
					if (p.hasPermission("Legend.Kit.berserker")) {
						if (Base.temKit(p) == false) {
							Base.setaraKit(p, "Berserker");
							Base.darItens(p);
							p.sendMessage(Base.prefix + "§bVocê selecionou o §fKit §6Berserker§b!");
						} else {
							p.sendMessage(Base.prefix + "§bVocê não pode pegar §fKit§b!");
						}
					} else {
						p.sendMessage(Base.prefix + "§bVocê não tem permissão para pegar esse §fKit§b!");
					}
				} else if (args[0].equalsIgnoreCase("anchor")) {
					if (p.hasPermission("Legend.Kit.anchor")) {
						if (Base.temKit(p) == false) {
							Base.setaraKit(p, "Anchor");
							Base.darItens(p);
							p.sendMessage(Base.prefix + "§bVocê selecionou o §fKit §6Anchor§b!");
						} else {
							p.sendMessage(Base.prefix + "§bVocê não pode pegar §fKit§b!");
						}
					} else {
						p.sendMessage(Base.prefix + "§bVocê não tem permissão para pegar esse §fKit§b!");
					}
				} else if (args[0].equalsIgnoreCase("Critical")) {
					if (p.hasPermission("Legend.Kit.Critical")) {
						if (Base.temKit(p) == false) {
							Base.setaraKit(p, "Critical");
							Base.darItens(p);
							p.sendMessage(Base.prefix + "§bVocê selecionou o §fKit §6Critical§b!");
						} else {
							p.sendMessage(Base.prefix + "§bVocê não pode pegar §fKit§b!");
						}
					} else {
						p.sendMessage(Base.prefix + "§bVocê não tem permissão para pegar esse §fKit§b!");
					}
				} else if (args[0].equalsIgnoreCase("Vampiro")) {
					if (p.hasPermission("Legend.Kit.Vampiro")) {
						if (Base.temKit(p) == false) {
							Base.setaraKit(p, "Vampiro");
							Base.darItens(p);
							p.sendMessage(Base.prefix + "§bVocê selecionou o §fKit §6Vampiro§b!");
						} else {
							p.sendMessage(Base.prefix + "§bVocê não pode pegar §fKit§b!");
						}
					} else {
						p.sendMessage(Base.prefix + "§bVocê não tem permissão para pegar esse §fKit§b!");
					}
				} else if (args[0].equalsIgnoreCase("Deshfire")) {
					if (p.hasPermission("Legend.Kit.Deshfire")) {
						if (Base.temKit(p) == false) {
							Base.setaraKit(p, "Deshfire");
							Base.darItens(p);
							p.sendMessage(Base.prefix + "§bVocê selecionou o §fKit §6Deshfire§b!");
						} else {
							p.sendMessage(Base.prefix + "§bVocê não pode pegar §fKit§b!");
						}
					} else {
						p.sendMessage(Base.prefix + "§bVocê não tem permissão para pegar esse §fKit§b!");
					}
				} else if (args[0].equalsIgnoreCase("Monk")) {
					if (p.hasPermission("Legend.Kit.Monk")) {
						if (Base.temKit(p) == false) {
							Base.setaraKit(p, "Monk");
							Base.darItens(p);
							p.sendMessage(Base.prefix + "§bVocê selecionou o §fKit §6Monk§b!");
						} else {
							p.sendMessage(Base.prefix + "§bVocê não pode pegar §fKit§b!");
						}
					} else {
						p.sendMessage(Base.prefix + "§bVocê não tem permissão para pegar esse §fKit§b!");
					}
				} else if (args[0].equalsIgnoreCase("Arrow")) {
					if (p.hasPermission("Legend.Kit.Arrow")) {
						if (Base.temKit(p) == false) {
							Base.setaraKit(p, "Arrow");
							Base.darItens(p);
							p.sendMessage(Base.prefix + "§bVocê selecionou o §fKit §6Arrow§b!");
						} else {
							p.sendMessage(Base.prefix + "§bVocê não pode pegar §fKit§b!");
						}
					} else {
						p.sendMessage(Base.prefix + "§bVocê não tem permissão para pegar esse §fKit§b!");
					}
				} else if (args[0].equalsIgnoreCase("IronHead")) {
					if (p.hasPermission("Legend.Kit.IronHead")) {
						if (Base.temKit(p) == false) {
							Base.setaraKit(p, "IronHead");
							Base.darItens(p);
							p.sendMessage(Base.prefix + "§bVocê selecionou o §fKit §6IronHead§b!");
						} else {
							p.sendMessage(Base.prefix + "§bVocê não pode pegar §fKit§b!");
						}
					} else {
						p.sendMessage(Base.prefix + "§bVocê não tem permissão para pegar esse §fKit§b!");
					}
				} else if (args[0].equalsIgnoreCase("Neo")) {
					if (p.hasPermission("Legend.Kit.Neo")) {
						if (Base.temKit(p) == false) {
							Base.setaraKit(p, "Neo");
							Base.darItens(p);
							p.sendMessage(Base.prefix + "§bVocê selecionou o §fKit §6Neo§b!");
						} else {
							p.sendMessage(Base.prefix + "§bVocê não pode pegar §fKit§b!");
						}
					} else {
						p.sendMessage(Base.prefix + "§bVocê não tem permissão para pegar esse §fKit§b!");
					}
				} else {
					p.sendMessage(Base.prefix + "§bEsse §fKit §bnão existe!");
				}
			}

		}
		return false;
	}
}