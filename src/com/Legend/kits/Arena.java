package com.Legend.kits;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

public class Arena {
	
	public static List<Arena> arenas = new ArrayList<Arena>();
	
	public HashMap<Integer, ArrayList<Location>> blocks;
	public HashMap<Location, Block> bloco;
	public Location loc; 
	public Location spawn1;
	public Location spawn2;
	public boolean generateGLASS = true;
	List<Location> cuboid;
	public Material material;
	
	 public Arena() {
		blocks = new HashMap<>();
		bloco = new HashMap<>();
	}
	
	public Location getLoc() {
		return loc;
	}
	public void setLoc(Location loc) {
		this.loc = loc;
	}
	public Location getSpawn1() {
		return spawn1;
	}
	public void setSpawn1(Location spawn1) {
		this.spawn1 = spawn1;
	}
	public Location getSpawn2() {
		return spawn2;
	}
	public void setSpawn2(Location spawn2) {
		this.spawn2 = spawn2;
	}
	public List<Location> getCuboid() {
		return cuboid;
	}
	public void setCuboid(List<Location> cuboid) {
		this.cuboid = cuboid;
	}

	public void createArena(Location l, Player p, Material bloco) {
		  this.loc = new Location(l.getWorld(), l.getBlockX(), (l.getBlockY() + 70), l.getBlockZ());
		  this.spawn1 = new Location(l.getWorld(), l.getBlockX() - 5, (l.getBlockY() + 70), l.getBlockZ() - 5);
		  this.spawn2 = new Location(l.getWorld(), l.getBlockX() + 5, (l.getBlockY() + 70), l.getBlockZ() + 5);
		  this.material = bloco;
		  if (this.generateGLASS) {
			  cuboid = new ArrayList<>();
	          cuboid.clear();
		  }
		  for (int bX = -8; bX <= 8; bX++) {
			  for (int bZ = -8; bZ <= 8; bZ++) {
				  for (int bY = -1; bY <= 4; bY++) {
		               if (bY == 4) {
		                   cuboid.add(loc.clone().add(bX, bY, bZ));
		                } else if (bY == -1) {
		                   cuboid.add(loc.clone().add(bX, bY, bZ));
		                } else if (bX == -8 || bZ == -8 || bX == 8 || bZ == 8) {
		                   cuboid.add(loc.clone().add(bX, bY, bZ));
		              } 
				  }
			  }
		  }
		  for (Location loc4 : cuboid) {
			  loc4.getBlock().setType(this.material);
	          this.bloco.put(loc4, loc4.getBlock());
		  }
		  spawn1.setYaw(-75.0F);
		  spawn2.setYaw(+75.0F);
		  arenas.add(this);
	}
	
	public void delArena() {
		for (Location l : this.cuboid) {
			l.getBlock().setType(Material.AIR);
			bloco.get(l).setType(Material.AIR);
		}
		arenas.remove(this);
	}
}
