package org.rbg.npcpixelmon.inventory.store;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

public class PokeUpperInventory implements Listener {

    private static Inventory inventory;

    public static void createPokeUpperInventory() {
        if (inventory == null) {
            inventory = Bukkit.createInventory(null, 9 * 3, "Upador de Ev e Level");

            CreateItems();
        }
    }

    public static Inventory getPokeUpperInventory() {
        return inventory;
    }

    private static void CreateItems() {
        CreateItem("PIXELMON_PIXELMON_SPRITE", 1, "", 10);
        CreateItem("PIXELMON_PIXELMON_SPRITE", 1, "", 11);
        CreateItem("PIXELMON_PIXELMON_SPRITE", 1, "", 12);
        CreateItem("PIXELMON_POKE_BALL", 1, "ESCOLHA APORRA DO POKEFODASE", 13);
        CreateItem("PIXELMON_PIXELMON_SPRITE", 1, "", 14);
        CreateItem("PIXELMON_PIXELMON_SPRITE", 1, "", 15);
        CreateItem("PIXELMON_PIXELMON_SPRITE", 1, "", 16);

        for (int i = 0; i < 10; i++) {
            CreateItem("WHITE_STAINED_GLASS_PANE", 1, "", i);
        }
        for (int i = 17; i < 27; i++) {
            CreateItem("WHITE_STAINED_GLASS_PANE", 1, "", i);
        }
    }

    private static void CreateItem(String item, int amount, String displayName, int slot) {
        Material material = Material.valueOf(item);

        ItemStack itemStack = new ItemStack(material, amount);
        ItemMeta meta = itemStack.getItemMeta();
        assert meta != null;
        meta.setDisplayName(displayName);
        itemStack.setItemMeta(meta);
        getPokeUpperInventory().setItem(slot, itemStack);
    }

}


