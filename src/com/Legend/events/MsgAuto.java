package com.Legend.events;

import java.util.ArrayList;
import java.util.Random;

import org.bukkit.Bukkit;

import com.Legend.Main;
import com.Legend.kits.manager.Base;

public class MsgAuto {
	
	public static ArrayList<String> c = new ArrayList<>();

	public static void msgautoo() {
		Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(Main.getPlugin(), new Runnable() {

			@Override
			public void run() {
				c.add(Base.prefix + "§7§lEntre em nosso Discord para saber tudo sobre o servidor! §fdiscord.gg/WPEh5UGSh2");
				c.add(Base.prefix + "§7§lEm nosso site você consegue nos ajudar comprando Kits e Vips! §fLegendpvp.com.br");
				c.add(Base.prefix + "§7§lPara Recraft, pegue cogumelos e madeiras no mapa, tutorial no Spawn!");
				c.add(Base.prefix + "§7§lUse /Report se precisar de um Staffer, ou também nos contacte pelo Discord! §fdiscord.gg/WPEh5UGSh2");
				Random r = new Random();
				int pos = r.nextInt(c.size());

				String random = c.get(pos);
				Bukkit.broadcastMessage(random);
			}
		}, 0L, 7 * 1200);

	}
}
