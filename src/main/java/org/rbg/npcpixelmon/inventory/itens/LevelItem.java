package org.rbg.npcpixelmon.inventory.itens;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import static org.rbg.npcpixelmon.inventory.UpperInventory.getUpperInventory;

public class LevelItem {

    public static void CreateEvLevelItem() {
        Material material = Material.valueOf("PIXELMON_RARE_CANDY");

        ItemStack itemStack = new ItemStack(material, 1);
        ItemMeta meta = itemStack.getItemMeta();
        assert meta != null;
        meta.setDisplayName("Level");
        itemStack.setItemMeta(meta);
        getUpperInventory().setItem(10, itemStack);
    }
}
