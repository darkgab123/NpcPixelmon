package org.rbg.npcpixelmon.inventory;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class PokeInventory implements Listener {
    private static Inventory inventory;

    public static void createPokeInventory() {
        if (inventory == null) {
            inventory = Bukkit.createInventory(null, 27, "Upador de Ev e Level");
            createItems();
        }
    }

    public static Inventory getPokeInventory() {
        return inventory;
    }

    private static void createItems() {
        createItem("PIXELMON_PIXELMON_SPRITE", 1, "", 10);
        createItem("PIXELMON_PIXELMON_SPRITE", 1, "", 11);
        createItem("PIXELMON_PIXELMON_SPRITE", 1, "", 12);
        createItem("PIXELMON_POKE_BALL", 2, "ESCOLHA APORRA DO POKEFODASE", 13);
        createItem("PIXELMON_PIXELMON_SPRITE", 1, "", 14);
        createItem("PIXELMON_PIXELMON_SPRITE", 1, "", 15);
        createItem("PIXELMON_PIXELMON_SPRITE", 1, "", 16);

        int i;
        for(i = 0; i < 10; ++i) {
            createItem("WHITE_STAINED_GLASS_PANE", 1, "", i);
        }

        for(i = 17; i < 27; ++i) {
            createItem("WHITE_STAINED_GLASS_PANE", 1, "", i);
        }

    }

    private static void createItem(String item, int amount, String displayName, int slot) {
        Material material = Material.valueOf(item);
        ItemStack itemStack = new ItemStack(material, amount);
        ItemMeta meta = itemStack.getItemMeta();

        assert meta != null;

        meta.setDisplayName(displayName);
        itemStack.setItemMeta(meta);
        getPokeInventory().setItem(slot, itemStack);
    }
}
