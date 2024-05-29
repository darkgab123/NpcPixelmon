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

import static org.rbg.npcpixelmon.inventory.store.StoreUpperInventory.*;

public class InventoryListener implements Listener {

    private static JavaPlugin plugin;

    public InventoryListener(JavaPlugin p) {
        plugin = p;
    }

    @EventHandler
    public void onClick(InventoryClickEvent event) {

        Player player = (Player) event.getWhoClicked();

        if (event.getView().getTitle().equals("Upador de Ev e Level")) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onNPCRightClick(NPCRightClickEvent event) {
        NPC npc = event.getNPC();
        Player player = event.getClicker();

        if (npc.getId() == 3) {
            createStoreUpperInventory();
            player.openInventory(getStoreUpperInventory());
            plugin.getLogger().info(getAllConfigValues());
        }
    }

    public String getAllConfigValues() {
        Map<String, Object> configValues = new HashMap<>();
        String values = "";

        FileConfiguration config = plugin.getConfig();

        for (String key : config.getKeys(true)) {
            Object value = config.get(key);
            configValues.put(key, value);
        }

        for (Map.Entry<String, Object> entry : configValues.entrySet()) {
            values = "Key: " + entry.getKey() + ", Value: " + entry.getValue();
        }

        return values;
    }

}