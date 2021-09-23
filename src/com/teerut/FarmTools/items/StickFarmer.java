package com.teerut.FarmTools.items;

import java.util.ArrayList;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class StickFarmer {
    public ItemStack item;
    public StickFarmer() {
        ItemStack itemStack = new ItemStack(Material.STICK, 1);
        ItemMeta meta = itemStack.getItemMeta();

        meta.setDisplayName(ChatColor.AQUA + "Farmer Tools");
        ArrayList<String> lore = new ArrayList<String>();
        lore.add(ChatColor.BOLD + "Tools to help you plant seeds fast");
        meta.setLore(lore);
        meta.addEnchant(Enchantment.LUCK, 1, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        itemStack.setItemMeta(meta);
        item = itemStack;
    }
}
