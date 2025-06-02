package com.leskms.slin.betterWorkStations.Tools;

import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ItemType;

import java.util.Arrays;

public class InvTools {
    public static boolean HasItem(Player player, ItemType itemType){
        ItemStack[] inv = player.getInventory().getContents();
        return Arrays.stream(inv).anyMatch(x -> x != null && x.getType().asItemType() == itemType);
    }
}
