package org.rbg.npcpixelmon.inventory.itens;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import static org.rbg.npcpixelmon.inventory.UpperInventory.getUpperInventory;

public class EvSpdItem {

    public static void CreateEvSpeedItem() {
        Material material = Material.valueOf("PIXELMON_POWER_ANKLET");

        ItemStack itemStack = new ItemStack(material, 1);
        ItemMeta meta = itemStack.getItemMeta();
        assert meta != null;
        meta.setDisplayName("Ev de Speed");
        itemStack.setItemMeta(meta);
        getUpperInventory().setItem(16, itemStack);
    }
}
