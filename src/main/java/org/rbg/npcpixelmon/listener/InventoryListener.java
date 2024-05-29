package org.rbg.npcpixelmon.listener;

import net.citizensnpcs.api.event.NPCRightClickEvent;
import net.citizensnpcs.api.npc.NPC;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.Map;

import static org.rbg.npcpixelmon.inventory.PokeInventory.createPokeInventory;
import static org.rbg.npcpixelmon.inventory.PokeInventory.getPokeInventory;
import static org.rbg.npcpixelmon.inventory.UpperInventory.createUpperInventory;
import static org.rbg.npcpixelmon.inventory.UpperInventory.getUpperInventory;

public class InventoryListener implements Listener {
    private static JavaPlugin plugin;

    public InventoryListener(JavaPlugin p) {
        plugin = p;
    }

    @EventHandler
    public void onClick(InventoryClickEvent event) {
        if (event.getView().getTitle().equals("Upador de Ev e Level")) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onNPCRightClick(NPCRightClickEvent event) {
        Map<String, Object> configValues = getAllConfigValues();
        NPC npc = event.getNPC();
        Player player = event.getClicker();

        for (Map.Entry<String, Object> entry : configValues.entrySet()) {
            if (entry.getKey().contains(String.valueOf(npc.getId()))) {
                if (String.valueOf(entry.getValue()).equalsIgnoreCase("Upper")) {
                    createUpperInventory();
                    player.openInventory(getUpperInventory());
                } else if (String.valueOf(entry.getValue()).equalsIgnoreCase("Poke")) {
                    createPokeInventory();
                    player.openInventory(getPokeInventory());
                }
            }
        }
    }

    public Map<String, Object> getAllConfigValues() {
        Map<String, Object> configValues = new HashMap<>();

        FileConfiguration config = plugin.getConfig();

        for (String key : config.getKeys(true)) {
            Object value = config.get(key);
            configValues.put(key, value);
        }
        return configValues;
    }
}
