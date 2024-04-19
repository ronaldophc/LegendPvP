package com.Legend;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;
import org.bukkit.scoreboard.Team;

import com.Legend.Comandos.Admin;
import com.Legend.Comandos.Builder;
import com.Legend.Comandos.Change;
import com.Legend.Comandos.Chat;
import com.Legend.Comandos.Clear;
import com.Legend.Comandos.Crash;
import com.Legend.Comandos.Fake;
import com.Legend.Comandos.Fly;
import com.Legend.Comandos.GetIP;
import com.Legend.Comandos.Gm;
import com.Legend.Comandos.Head;
import com.Legend.Comandos.Invsee;
import com.Legend.Comandos.Itens;
import com.Legend.Comandos.Kick;
import com.Legend.Comandos.Manutenção;
import com.Legend.Comandos.Matar;
import com.Legend.Comandos.Mute;
import com.Legend.Comandos.Ping;
import com.Legend.Comandos.PvP;
import com.Legend.Comandos.Reload;
import com.Legend.Comandos.Report;
import com.Legend.Comandos.Reset;
import com.Legend.Comandos.Say;
import com.Legend.Comandos.Score;
import com.Legend.Comandos.ScreenShare;
import com.Legend.Comandos.Site;
import com.Legend.Comandos.Skins;
import com.Legend.Comandos.StaffChat;
import com.Legend.Comandos.Tag;
import com.Legend.Comandos.Tell;
import com.Legend.Comandos.Tp;
import com.Legend.Comandos.Youtuber;
import com.Legend.Comandos.cKit;
import com.Legend.Comandos.sKit;
import com.Legend.KD.API;
import com.Legend.KD.ComandosKD;
import com.Legend.KD.Config;
import com.Legend.LegendArena.ComandosL;
import com.Legend.RDM.RDM;
import com.Legend.RDM.RDMEvent;
import com.Legend.events.BlockBreak;
import com.Legend.events.BloqSpawn;
import com.Legend.events.Bussola;
import com.Legend.events.Combatlog;
import com.Legend.events.DamageManager;
import com.Legend.events.DropItem;
import com.Legend.events.EntityDamage;
import com.Legend.events.Jumps;
import com.Legend.events.Motd;
import com.Legend.events.MsgAuto;
import com.Legend.events.Placas;
import com.Legend.events.PlayerDeath;
import com.Legend.events.PlayerJoin;
import com.Legend.events.PlayerLogin;
import com.Legend.events.PlayerPreLogin;
import com.Legend.events.PlayerQuit;
import com.Legend.events.PlayerRespawn;
import com.Legend.events.PrincipaisEventos;
import com.Legend.events.Recipe;
import com.Legend.events.Repair;
import com.Legend.events.Sopa;
import com.Legend.events.Tab;
import com.Legend.guis.Configs2;
import com.Legend.guis.Inv2;
import com.Legend.guis.Inventario;
import com.Legend.guis.Warps;
import com.Legend.kits.Achilles;
import com.Legend.kits.Ajnin;
import com.Legend.kits.Anchor;
import com.Legend.kits.Avatar;
import com.Legend.kits.Berserker;
import com.Legend.kits.Boxer;
import com.Legend.kits.C4;
import com.Legend.kits.Camel;
import com.Legend.kits.Checkpoint;
import com.Legend.kits.Corona;
import com.Legend.kits.Critical;
import com.Legend.kits.Deshfire;
import com.Legend.kits.Endermage2;
import com.Legend.kits.Fireman;
import com.Legend.kits.Fisherman;
import com.Legend.kits.Frozen;
import com.Legend.kits.Ghost;
import com.Legend.kits.Gladiator;
import com.Legend.kits.Goku;
import com.Legend.kits.Hulk;
import com.Legend.kits.Kangaroo;
import com.Legend.kits.Lifestealer;
import com.Legend.kits.Monk;
import com.Legend.kits.Naruto;
import com.Legend.kits.Neo;
import com.Legend.kits.Ninja;
import com.Legend.kits.Phantom;
import com.Legend.kits.Pyro;
import com.Legend.kits.Rain;
import com.Legend.kits.Reaper;
import com.Legend.kits.Resouper;
import com.Legend.kits.Scout;
import com.Legend.kits.Snail;
import com.Legend.kits.Stomper;
import com.Legend.kits.Switcher;
import com.Legend.kits.TankUp;
import com.Legend.kits.Thor;
import com.Legend.kits.Upgrader;
import com.Legend.kits.Vampiro;
import com.Legend.kits.Viper;
import com.Legend.kits.manager.Comando;
import com.Legend.kits.manager.Kitlog;
import com.Legend.register.RegisterLogin;
import com.Legend.score.newScore3;
import com.Legend.umvum.Comandos1;
import com.Legend.umvum.Events1;
import com.Legend.warps.Arena;
import com.Legend.warps.FPS;
import com.Legend.warps.Lava;
import com.Legend.warps.PlacasLava;
import com.Legend.warps.Spawn;
import com.Legend.warps.setFps;
import com.Legend.warps.setLava;
import com.Legend.warps.setSpawn;

public class Main extends JavaPlugin {

	public static ScoreboardManager man;
	public static Scoreboard sb;

	public static Team OP;
	public static Team ADMIN;
	public static Team SRMOD;

	private static Main main;

	public static Main getInstance() {
		return main;
	}

	public static Plugin plugin;

	public static Plugin getPlugin() {
		return plugin;
	}

	public static Config server;
	public static Config file;
	public static Config Warps;
	public static Config rdm;
	public static Config infos;
	public static Config x1;
	public static Config itens;
	public static Config mutes;

	public void onEnable() {
		plugin = (Plugin) this;
		main = this;
		MsgAuto.msgautoo();
		new BukkitRunnable() {

			@Override
			public void run() {
				API.atualizadork();
				for (World w : Bukkit.getServer().getWorlds()) {
					w.setTime(18000);
				}
			}
		}.runTaskTimer(this, 100, 100);
		Tab.Taba();
		registroConfigs();
		Registro();
		RegistroComandos();
		newScore3.starScheduler();
		//Change.createMySQL();
		//MYSQLManager.criarTabela();
		Change.addKits();
		Change.newKits();
		Bukkit.getConsoleSender().sendMessage("§b---------------------------------");
		Bukkit.getConsoleSender().sendMessage("§b| LegendPvP Iniciou com sucesso |");
		Bukkit.getConsoleSender().sendMessage("§b---------------------------------");
	}

	public void onDisable() {
		Bukkit.getConsoleSender().sendMessage("§b---------------------------------");
		Bukkit.getConsoleSender().sendMessage("§b| LegendPvP desligou com sucesso |");
		Bukkit.getConsoleSender().sendMessage("§b---------------------------------");
	}

	public void Registro() {
		PluginManager pm = Bukkit.getPluginManager();
		pm.registerEvents(new Motd(), this);
		pm.registerEvents(new Spawn(this), this);
		pm.registerEvents(new PlayerDeath(), this);
		pm.registerEvents(new PlayerJoin(), this);
		pm.registerEvents(new PlayerQuit(), this);
		pm.registerEvents(new PlayerRespawn(), this);
		pm.registerEvents(new PlayerPreLogin(), this);
		pm.registerEvents(new PlayerLogin(), this);
		pm.registerEvents(new PrincipaisEventos(), this);
		pm.registerEvents(new EntityDamage(), this);
		pm.registerEvents(new Inventario(), this);
		pm.registerEvents(new Sopa(), this);
		pm.registerEvents(new DropItem(this), this);
		pm.registerEvents(new DamageManager(), this);
		pm.registerEvents(new Chat(), this);
		pm.registerEvents(new Jumps(), this);
		pm.registerEvents(new Inv2(), this);
		pm.registerEvents(new Combatlog(), this);
		pm.registerEvents(new Placas(), this);
		pm.registerEvents(new Admin(), this);
		pm.registerEvents(new ScreenShare(), this);
		pm.registerEvents(new RDMEvent(), this);
		pm.registerEvents(new Warps(), this);
		pm.registerEvents(new Events1(), this);
		pm.registerEvents(new Bussola(), this);
		pm.registerEvents(new Kitlog(), this);
		pm.registerEvents(new BlockBreak(), this);
		pm.registerEvents(new Configs2(), this);
		pm.registerEvents(new BloqSpawn(), this);
		pm.registerEvents(new Report(), this);
		pm.registerEvents(new Repair(), this);
		pm.registerEvents(new PlacasLava(), this);
		pm.registerEvents(new Skins(), this);
		Recipe.recipes();
		rkits();
	}

	public void rkits() {
		PluginManager pm = Bukkit.getPluginManager();
		pm.registerEvents(new Snail(), this);
		pm.registerEvents(new Kangaroo(), this);
		pm.registerEvents(new Fisherman(), this);
		pm.registerEvents(new Viper(), this);
		pm.registerEvents(new Fireman(), this);
		pm.registerEvents(new Camel(), this);
		pm.registerEvents(new Gladiator(this), this);
		pm.registerEvents(new Stomper(), this);
		pm.registerEvents(new Thor(), this);
		pm.registerEvents(new Hulk(), this);
		pm.registerEvents(new Ajnin(), this);
		pm.registerEvents(new Corona(), this);
		pm.registerEvents(new Ninja(), this);
		pm.registerEvents(new Anchor(), this);
		pm.registerEvents(new Boxer(), this);
		pm.registerEvents(new Critical(), this);
		pm.registerEvents(new Vampiro(), this);
		pm.registerEvents(new Deshfire(), this);
		pm.registerEvents(new Rain(), this);
		pm.registerEvents(new Neo(), this);
		pm.registerEvents(new Reaper(), this);
		pm.registerEvents(new Lifestealer(), this);
		pm.registerEvents(new Naruto(), this);
		pm.registerEvents(new Goku(), this);
		pm.registerEvents(new C4(), this);
		pm.registerEvents(new Phantom(), this);
		pm.registerEvents(new Ghost(), this);
		pm.registerEvents(new Avatar(), this);
		pm.registerEvents(new Frozen(), this);
		pm.registerEvents(new Endermage2(), this);
		pm.registerEvents(new Achilles(), this);
		pm.registerEvents(new Monk(), this);
		pm.registerEvents(new TankUp(), this);
		pm.registerEvents(new Upgrader(), this);
		pm.registerEvents(new Berserker(), this);
		pm.registerEvents(new Switcher(), this);
		pm.registerEvents(new Scout(), this);
		pm.registerEvents(new Pyro(), this);
		pm.registerEvents(new Resouper(), this);
		pm.registerEvents(new Checkpoint(), this);
	}

	public void RegistroComandos() {
		this.getCommand("getip").setExecutor(new GetIP());
		this.getCommand("Kit").setExecutor(new Comando());
		this.getCommand("Builder").setExecutor(new Builder());
		this.getCommand("cc").setExecutor(new Chat());
		this.getCommand("change").setExecutor(new Change());
		this.getCommand("discord").setExecutor(new Chat());
		this.getCommand("inv").setExecutor(new Invsee());
		this.getCommand("lava").setExecutor(new Lava(this));
		this.getCommand("setlava").setExecutor(new setLava(this));
		this.getCommand("tag").setExecutor(new Tag());
		this.getCommand("Gm").setExecutor(new Gm());
		this.getCommand("Fly").setExecutor(new Fly());
		this.getCommand("Kick").setExecutor(new Kick());
		this.getCommand("report").setExecutor(new Report());
		this.getCommand("responder").setExecutor(new Report());
		this.getCommand("say").setExecutor(new Say());
		this.getCommand("pvp").setExecutor(new PvP());
		this.getCommand("tp").setExecutor(new Tp());
		this.getCommand("s").setExecutor(new Tp());
		this.getCommand("1v1").setExecutor(new Comandos1());
		this.getCommand("set1v1").setExecutor(new Comandos1());
		this.getCommand("spawn").setExecutor(new Spawn(this));
		this.getCommand("setspawn").setExecutor(new setSpawn(this));
		this.getCommand("fps").setExecutor(new FPS(this));
		this.getCommand("setfps").setExecutor(new setFps(this));
		this.getCommand("matar").setExecutor(new Matar());
		this.getCommand("fake").setExecutor(new Fake());
		this.getCommand("status").setExecutor(new ComandosKD());
		this.getCommand("setdin").setExecutor(new ComandosKD());
		this.getCommand("reset").setExecutor(new Reset());
		this.getCommand("sc").setExecutor(new StaffChat());
		this.getCommand("admin").setExecutor(new Admin());
		this.getCommand("ss").setExecutor(new ScreenShare());
		this.getCommand("rdm").setExecutor(new RDM());
		this.getCommand("mute").setExecutor(new Mute());
		this.getCommand("desmute").setExecutor(new Mute());
		this.getCommand("tempmute").setExecutor(new Mute());
		this.getCommand("setrdm").setExecutor(new RDM());
		this.getCommand("tell").setExecutor(new Tell());
		this.getCommand("reloade").setExecutor(new Reload());
		this.getCommand("ranks").setExecutor(new ComandosKD());
		this.getCommand("top").setExecutor(new ComandosKD());
		this.getCommand("head").setExecutor(new Head(this));
		this.getCommand("crash").setExecutor(new Crash());
		this.getCommand("setitens").setExecutor(new Itens());
		this.getCommand("setarena").setExecutor(new Arena());
		this.getCommand("manutencao").setExecutor(new Manutenção());
		this.getCommand("login").setExecutor(new RegisterLogin());
		this.getCommand("register").setExecutor(new RegisterLogin());
		this.getCommand("trocarsenha").setExecutor(new RegisterLogin());
		this.getCommand("ckit").setExecutor(new cKit());
		this.getCommand("site").setExecutor(new Site());
		this.getCommand("score").setExecutor(new Score());
		this.getCommand("skit").setExecutor(new sKit());
		this.getCommand("clear").setExecutor(new Clear());
		this.getCommand("ping").setExecutor(new Ping());
		this.getCommand("youtuber").setExecutor(new Youtuber());
		this.getCommand("streamer").setExecutor(new Youtuber());
		this.getCommand("guihack").setExecutor(new Report());
		this.getCommand("guichat").setExecutor(new Report());
		this.getCommand("guifreekill").setExecutor(new Report());
		this.getCommand("guibugs").setExecutor(new Report());
		this.getCommand("reports").setExecutor(new Report());
		this.getCommand("la").setExecutor(new ComandosL());
		this.getCommand("tskins").setExecutor(new Skins());
	}

	public static void registroConfigs() {
		server = new Config(null, "configs.yml", true);
		server.save();
		server.reload();
		file = new Config(null, "infos.yml", true);
		file.save();
		file.reload();
		mutes = new Config(null, "mutes.yml", true);
		mutes.save();
		mutes.reload();
		itens = new Config(null, "itens.yml", true);
		itens.save();
		itens.reload();
		x1 = new Config(null, "1v1.yml", true);
		x1.save();
		x1.reload();
		infos = new Config(null, "register.yml", true);
		infos.save();
		infos.reload();
		Warps = new Config(null, "Warps.yml", true);
		Warps.save();
		Warps.reload();
		rdm = new Config(null, "rdm.yml", true);
		rdm.save();
		rdm.reload();
	}
	
	public static Main getMain() {
		return null;
	}

}
