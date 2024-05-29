package org.rbg.npcpixelmon.inventory.itens;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import static org.rbg.npcpixelmon.inventory.UpperInventory.getUpperInventory;

public class EvSpAtkItem {

    public static void CreateEvSpAtkItem() {
        Material material = Material.valueOf("PIXELMON_POWER_LENS");

        ItemStack itemStack = new ItemStack(material, 1);
        ItemMeta meta = itemStack.getItemMeta();
        assert meta != null;
        meta.setDisplayName("Ev de Special Attack");
        itemStack.setItemMeta(meta);
        getUpperInventory().setItem(14, itemStack);
    }
}
