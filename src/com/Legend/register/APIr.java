package com.Legend.register;

import java.util.ArrayList;
import java.util.List;

import com.Legend.Main;

public class APIr {

	public static List<String> logado = new ArrayList<>();

	public static boolean jaregistrou(String name) {
		if (Main.infos.getConfig().getString(String.valueOf(name)) == null) {
			return false;
		} else {
			return true;
		}
	}

	public static void registrar(String name, String senha) {
		Main.infos.getConfig().set(String.valueOf(name), String.valueOf(senha));
		Main.infos.save();
	}

	public static String getSenha(String name) {
		return Main.infos.getConfig().getString(String.valueOf(name));
	}
}
