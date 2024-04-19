package com.Legend.MySql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import com.Legend.Main;
import com.Legend.kits.manager.Base;

public class MYSQLManager {

	private static String bancodedados = Main.server.getConfig().getString(String.valueOf("MySQL.database"));;
	private static String host = Main.server.getConfig().getString(String.valueOf("MySQL.host"));;
	private static String porta = Main.server.getConfig().getString(String.valueOf("MySQL.port"));;
	private static String senha = Main.server.getConfig().getString(String.valueOf("MySQL.password"));;
	private static String usuario = Main.server.getConfig().getString(String.valueOf("MySQL.username"));;

	public static Connection abrirConec() {
		try {
			return DriverManager.getConnection("jdbc:mysql://" + host + ":" + porta + "/" + bancodedados, usuario,
					senha);
		} catch (Exception e) {
			Bukkit.getConsoleSender().sendMessage(Base.prefix + "§cErro ao conectar no MySQL");
			return null;
		}
	}

	public static void criarTabela() {
		try {
			Connection con = abrirConec();
			PreparedStatement st = con.prepareStatement(
					"CREATE TABLE if not exists players(id VARCHAR(40),nome VARCHAR(16),dinheiro DECIMAL(6)UNSIGNED,kills DECIMAL(4)UNSIGNED,mortes DECIMAL(4)UNSIGNED, pontos DECIMAL(4)UNSIGNED,topks DECIMAL(3)UNSIGNED,ip VARCHAR(25),tag VARCHAR(10)DEFAULT 'Normal',arena BOOLEAN DEFAULT false,PRIMARY KEY (id));");
			st.executeUpdate();
			con.close();
		} catch (SQLException e) {
			Bukkit.getConsoleSender().sendMessage(Base.prefix + "§cErro ao criar tabela no MySQL");
			e.printStackTrace();
		}
	}

	public static void addJogador(Player p) {
		if (hasJogador(p) == false) {
			try {
				Connection con = abrirConec();
				PreparedStatement st = con.prepareStatement("INSERT INTO `players` VALUES (?,?,?,?,?,?,?,?,?,?);");
				st.setString(1, p.getUniqueId().toString());
				st.setString(2, p.getName());
				st.setInt(3, 0);
				st.setInt(4, 0);
				st.setInt(5, 0);
				st.setInt(6, 0);
				st.setInt(7, 0);
				st.setInt(8, 0);
				st.setString(9, p.getAddress().toString());
				st.setString(10, "DEFAULT");
				st.execute();
				con.close();
			} catch (SQLException e) {
				Bukkit.getConsoleSender().sendMessage(Base.prefix + "§cErro ao criar jogador no MySQL");
				e.printStackTrace();
			}
		}
	}

	public static boolean hasJogador(Player p) {
		try {
			Connection con = abrirConec();
			PreparedStatement st = con.prepareStatement("SELECT id FROM `players` WHERE id = ?;");
			st.setString(1, p.getUniqueId().toString());
			ResultSet rst = st.executeQuery();
			boolean rs = rst.next();
			con.close();
			return rs;
		} catch (SQLException e) {
			Bukkit.getConsoleSender().sendMessage(Base.prefix + "§cErro no getInt do MySQL");
			e.printStackTrace();
		}
		return false;
	}

	public static void updateDinheiro(Player p, int valor) {
		try {
			Connection con = abrirConec();
			PreparedStatement st = con.prepareStatement("UPDATE `players` SET dinheiro = ? WHERE id = ? LIMIT 1;");
			st.setInt(1, valor);
			st.setString(2, p.getUniqueId().toString());
			st.execute();
			con.close();
		} catch (SQLException e) {
			Bukkit.getConsoleSender().sendMessage(Base.prefix + "§cErro no update do MySQL");
			e.printStackTrace();
		}
	}
	public static int getDinheiro(Player p) {
		try {
			Connection con = abrirConec();
			PreparedStatement st = con.prepareStatement("SELECT dinheiro FROM `players` WHERE id = ?;");
			st.setString(1, p.getUniqueId().toString());
			ResultSet rst = st.executeQuery();
			int value = 0;
			if (rst.next()) {
				value = rst.getInt("dinheiro");
			}
			con.close();
			return value;
		} catch (SQLException e) {
			Bukkit.getConsoleSender().sendMessage(Base.prefix + "§cErro no getInt do MySQL");
			e.printStackTrace();
		}
		return 0;
	}
}
