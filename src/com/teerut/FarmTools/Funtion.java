package com.teerut.FarmTools;

import org.bukkit.Material;
import org.bukkit.block.Block;

public class Funtion {
	 public boolean CheckWheat(Block block) {
	        if (block.getRelative(0, 1, 0).getType().equals(Material.WHEAT)) {
	            return true;
	        }
	        return false;
	    }
	    public boolean CheckFarmland(Block block) {
	        if (block.getType().equals(Material.FARMLAND)) {
	            return true;
	        }
	        return false;
	    }
	    public boolean checkAir(Block block) {
	        if (block.getRelative(0, 1, 0).getType().equals(Material.AIR)) {
	            return true;
	        }
	        return false;
	    }
}
