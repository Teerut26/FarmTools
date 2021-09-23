package com.teerut.FarmTools.handle;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;

import com.teerut.FarmTools.items.StickFarmer;

public class CustomItemHandle {
    public CustomItemHandle() {
        ItemStack stickFarmer = new StickFarmer().item;
        ShapedRecipe r = new ShapedRecipe(stickFarmer);
        r.shape("SSS",
                "SsS",
                "SSS");
        r.setIngredient('S', Material.WHEAT_SEEDS);
        r.setIngredient('s', Material.STICK);
        Bukkit.getServer().addRecipe(r);
    }
}