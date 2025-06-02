package com.leskms.slin.betterWorkStations.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemType;

import static com.leskms.slin.betterWorkStations.Tools.InvTools.HasItem;

public class EChestCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String command_used, String[] args) {
        if (!(sender instanceof Player player)){
            sender.sendMessage("You are not a player, you must be a player to use this command");
            return true;
        }
        if (args.length > 1 ) {
            sender.sendMessage(command.getUsage().replace("<command>", command_used) +
                    (sender.hasPermission("betterworkstations.echest.access-other") ? "[username]": "")
            );
            return true;
        } else if (args.length == 1){
            if (!sender.hasPermission("betterworkstations.echest.access-other")){
                sender.sendMessage("You do not have permission to access other peoples enderchest");
                return true;
            }
            Player target = Bukkit.getPlayerExact(args[0]);
            if (!(target == player)){
                sender.sendMessage(String.format("Player %s does not exist or isn't online", (player.getDisplayName())));
                return true;
            }
            sender.sendMessage(String.valueOf(sender.hasPermission("betterworkstations.echest.access-other")));
            player.openInventory(target.getEnderChest());
            return true;
        } else {
            if (sender.hasPermission("betterworkstations.echest.bypass-workbench") || HasItem(player, ItemType.ENDER_CHEST)){
                player.openInventory(player.getEnderChest());
            } else {
                player.sendMessage("You have to have an ender chest in your inventory to use this command");
            }
            return true;
        }
    }
}
