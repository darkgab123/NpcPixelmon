package org.rbg.npcpixelmon.inventory.itens;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import static org.rbg.npcpixelmon.inventory.UpperInventory.getUpperInventory;

public class EvDefItem {

    public static void CreateEvDefItem() {
        Material material = Material.valueOf("PIXELMON_POWER_BELT");

        ItemStack itemStack = new ItemStack(material, 1);
        ItemMeta meta = itemStack.getItemMeta();
        assert meta != null;
        meta.setDisplayName("Ev de Defesa");
        itemStack.setItemMeta(meta);
        getUpperInventory().setItem(12, itemStack);
    }
}
