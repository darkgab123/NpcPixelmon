package org.rbg.npcpixelmon.inventory;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class UpperInventory implements Listener {
    private static Inventory inventory;

    public UpperInventory() {
    }

    public static void createUpperInventory() {
        if (inventory == null) {
            inventory = Bukkit.createInventory(null, 27, "Upador de Ev e Level");
            CreateItems();
        }

    }

    public static Inventory getUpperInventory() {
        return inventory;
    }

    private static void CreateItems() {
        CreateItem("PIXELMON_RARE_CANDY", 1, "Level", 10);
        CreateItem("PIXELMON_POWER_BRACER", 1, "Ev de Attack", 11);
        CreateItem("PIXELMON_POWER_BELT", 1, "Ev de Defesa", 12);
        CreateItem("PIXELMON_POWER_WEIGHT", 2, "Ev de HP", 13);
        CreateItem("PIXELMON_POWER_LENS", 1, "Ev de Special Attack", 14);
        CreateItem("PIXELMON_POWER_BAND", 1, "Ev de Special Defesa", 15);
        CreateItem("PIXELMON_POWER_ANKLET", 1, "Ev de Speed", 16);

        int i;
        for(i = 0; i < 10; ++i) {
            CreateItem("WHITE_STAINED_GLASS_PANE", 1, "", i);
        }

        for(i = 17; i < 27; ++i) {
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
        getUpperInventory().setItem(slot, itemStack);
    }
}
