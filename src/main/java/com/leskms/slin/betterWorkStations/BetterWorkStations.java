package com.leskms.slin.betterWorkStations;

import com.leskms.slin.betterWorkStations.commands.BasicWorkStationCommand;
import com.leskms.slin.betterWorkStations.commands.EChestCommand;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.plugin.java.JavaPlugin;
import static org.bukkit.event.inventory.InventoryType.WORKBENCH;
import static org.bukkit.inventory.ItemType.*;

public final class BetterWorkStations extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        System.out.println("hi from my better workstations");
        getCommand("echest").setExecutor(new EChestCommand());
        getCommand("craft").setExecutor(new BasicWorkStationCommand(WORKBENCH, "crafting", "a crafting table", CRAFTING_TABLE));
        getCommand("anvil").setExecutor(new BasicWorkStationCommand(InventoryType.ANVIL, "anvil", "an anvil", ANVIL, CHIPPED_ANVIL, DAMAGED_ANVIL));}

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
