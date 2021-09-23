package com.teerut.FarmTools;

import com.teerut.FarmTools.handle.CustomItemHandle;
import com.teerut.FarmTools.handle.ItemHandle;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class FarmTools extends JavaPlugin {
    @Override
    public void onEnable() {
        System.out.println(ChatColor.GREEN+"FarmTools : onEnable");
        Bukkit.getServer().getPluginManager().registerEvents(new FarmToolsEvent(), this);
        new ItemHandle();
        new CustomItemHandle();
        super.onEnable();
    }

    @Override
    public void onDisable() {
        System.out.println(ChatColor.GREEN+"FarmTools : onDisable");
        super.onDisable();
    }
}
