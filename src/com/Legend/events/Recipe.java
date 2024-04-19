package com.Legend.events;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.material.MaterialData;

public class Recipe {

	@SuppressWarnings("deprecation")
	public static void recipes() {
		ItemStack e = new ItemStack(Material.MUSHROOM_SOUP);
		ItemMeta em = e.getItemMeta();
		em.setDisplayName("Sopa");
		e.setItemMeta(em);

		ShapelessRecipe a5 = new ShapelessRecipe(e);
		a5.addIngredient(1, Material.MELON_SEEDS);
		a5.addIngredient(1, Material.BOWL);

		ShapelessRecipe a6 = new ShapelessRecipe(e);
		a6.addIngredient(1, new MaterialData(Material.INK_SACK, (byte) 3));
		a6.addIngredient(1, Material.BOWL);

		Bukkit.getServer().addRecipe(a5);
		Bukkit.getServer().addRecipe(a6);
	}
}
