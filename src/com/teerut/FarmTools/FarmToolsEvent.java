package com.teerut.FarmTools;

import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import com.teerut.FarmTools.items.StickFarmer;

public class FarmToolsEvent implements Listener{
	Funtion funtion = new Funtion();

    @EventHandler
    public void onUseItem(PlayerInteractEvent e) {
        ItemStack stickFarmer = new StickFarmer().item;
        List<String> stickFarmerLore = stickFarmer.getItemMeta().getLore();
        Player p = e.getPlayer();

        Action a = e.getAction();
        if ((a == Action.PHYSICAL) || (e.getItem() == null))
            return;
        if (e.getItem().getItemMeta().getLore() == null)
            return;
        if (!e.getItem().getItemMeta().getLore().equals(stickFarmerLore))
            return;
        if (!(e.getClickedBlock().getType().equals(Material.FARMLAND)))
            return;

        if (!funtion.CheckWheat(e.getClickedBlock()) && a == Action.RIGHT_CLICK_BLOCK) {

            int start = -5;
            int end = 5;
            if (this.getSeedsInInventory(p) != 0) {
                this.setPlant(e.getClickedBlock());
                for (int x = start; x < end; x++) {
                    for (int z = start; z < end; z++) {
                        if (!funtion.CheckWheat(e.getClickedBlock().getRelative(x, 0, z))) {
                            if (funtion.CheckFarmland(e.getClickedBlock().getRelative(x, 0, z))) {
                                if (funtion.checkAir(e.getClickedBlock().getRelative(x, 0, z))) {
                                    if (this.getSeedsInInventory(p) >= 1) {
                                        e.getClickedBlock().getRelative(x, 0, z).getRelative(0, 1, 0)
                                                .setType(Material.WHEAT);
                                        this.setSeedsInInventory(p);
                                        
                                    }else{
                                        continue;
                                    }
                                    
                                }
                            }

                        }

                    }
                }

            } else {
                p.sendMessage(ChatColor.RED + "Not enough seeds");
            }
        }

    }

    public int setSeedsInInventory(Player p) {
        for (int i = 0; i < p.getInventory().getSize(); i++) {
            ItemStack itm = p.getInventory().getItem(i);
            if (itm != null && itm.getType().equals(Material.WHEAT_SEEDS)) {
                int amt = itm.getAmount() - 1;
                itm.setAmount(amt);
                p.getInventory().setItem(i, amt > 0 ? itm : null);
                break;
            }
        }
        return 0;
    }

    public int getSeedsInInventory(Player p) {
        for (int i = 0; i < p.getInventory().getSize(); i++) {
            ItemStack itm = p.getInventory().getItem(i);
            if (itm != null && itm.getType().equals(Material.WHEAT_SEEDS)) {
                return itm.getAmount();
            }
        }
        return 0;
    }

    public void setPlant(Block block) {
        block.getRelative(0, 1, 0).setType(Material.WHEAT);
    }
}
