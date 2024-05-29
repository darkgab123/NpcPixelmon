package org.rbg.npcpixelmon.inventory.itens;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import static org.rbg.npcpixelmon.inventory.UpperInventory.getUpperInventory;

public class EvHpItem {

    public static void CreateEvHPItem() {
        Material material = Material.valueOf("PIXELMON_POWER_WEIGHT");

        ItemStack itemStack = new ItemStack(material, 1);
        ItemMeta meta = itemStack.getItemMeta();
        assert meta != null;
        meta.setDisplayName("Ev de HP");
        itemStack.setItemMeta(meta);
        getUpperInventory().setItem(13, itemStack);
    }
}
