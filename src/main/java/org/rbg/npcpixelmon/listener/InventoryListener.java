package org.rbg.npcpixelmon.listener;

import net.citizensnpcs.api.event.NPCRightClickEvent;
import net.citizensnpcs.api.npc.NPC;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.Map;

import static org.rbg.npcpixelmon.inventory.PokeInventory.*;
import static org.rbg.npcpixelmon.inventory.UpgradesInventory.upgradesInventory;
import static org.rbg.npcpixelmon.inventory.UpperInventory.*;

public class InventoryListener implements Listener {
    private static JavaPlugin plugin;
    private String invAtual;

    public InventoryListener(JavaPlugin p) {
        plugin = p;
    }

    public String getItemName(ItemStack item) {
        if (item != null && item.hasItemMeta() && item.getItemMeta().hasDisplayName()) {
            return item.getItemMeta().getDisplayName();
        }
        return null;
    }

    @EventHandler
    public void onClick(InventoryClickEvent event) {
        ItemStack clickedItem = event.getCurrentItem();
        String nameClicked = getItemName(clickedItem);

        if (event.getView().getTitle().equals("Upador de Ev e Level")) {
            event.setCancelled(true);

            if (clickedItem == null || !clickedItem.hasItemMeta()) {
                return;
            }

            if (clickedItem.hasItemMeta() && clickedItem.getItemMeta().hasDisplayName() &&
                    clickedItem.getItemMeta().getDisplayName().equals("VOLTAR")) {
                Player player = (Player) event.getWhoClicked();

                pokeInventory(player);
            }
            if (nameClicked.equals("Level") || nameClicked.equals("Ev de Attack") || nameClicked.equals("Ev de Defesa") || nameClicked.equals("Ev de HP") || nameClicked.equals("Ev de Special Attack") || nameClicked.equals("Ev de Special Defesa") || nameClicked.equals("Ev de Speed")) {
                Player player = (Player) event.getWhoClicked();

                upgradesInventory(player, nameClicked);
                invAtual = nameClicked;
            }
        }
        else if(event.getView().getTitle().equals("Pokemons")){
            event.setCancelled(true);

            if (clickedItem == null || !clickedItem.hasItemMeta()) {
                return;
            }

            if (clickedItem.hasItemMeta() && clickedItem.getItemMeta().hasDisplayName() &&
                    clickedItem.getItemMeta().getDisplayName().equals("POKEMON999")) {
                Player player = (Player) event.getWhoClicked();

                upperInventory(player);
            }
        }
        else if(event.getView().getTitle().equals(invAtual)){
            if (clickedItem == null || !clickedItem.hasItemMeta()) {
                return;
            }
            event.setCancelled(true);
            if (clickedItem.hasItemMeta() && clickedItem.getItemMeta().hasDisplayName() &&
                    clickedItem.getItemMeta().getDisplayName().equals("VOLTAR")) {
                Player player = (Player) event.getWhoClicked();

                upperInventory(player);
            }
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
                    upperInventory(player);
                } else if (String.valueOf(entry.getValue()).equalsIgnoreCase("Poke")) {
                    pokeInventory(player);
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
