package com.leskms.slin.betterWorkStations.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.ItemType;

import java.util.Arrays;

import static com.leskms.slin.betterWorkStations.Tools.InvTools.HasItem;

public class BasicWorkStationCommand implements CommandExecutor {

    private final ItemType[] itemTypes;
    private final InventoryType invType;
    private final String id;
    private final String itemName;
    public BasicWorkStationCommand(InventoryType inventory, String id,String itemName, ItemType... items) {
        this.invType = inventory;
        this.itemTypes = items;
        this.id = id;
        this.itemName = itemName;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String command_used, String[] args) {
        if (!(sender instanceof Player player)){
            sender.sendMessage("You are not a player, you must be a player to use this command");
            return true;
        }
        if (args.length >= 1 ) {
            return false;
        }

        if (sender.hasPermission("betterworkstations."+ this.id +".bypass-workbench") || Arrays.stream(this.itemTypes).anyMatch(x -> HasItem(player,x)) ){
            player.openInventory(Bukkit.createInventory(player, this.invType));
        } else {
            player.sendMessage("You need "+ this.itemName +" in your inventory to use this command");
        }
        return true;

    }
}
