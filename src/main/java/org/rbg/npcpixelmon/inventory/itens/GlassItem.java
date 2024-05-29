package org.rbg.npcpixelmon.inventory.itens;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import static org.rbg.npcpixelmon.inventory.UpperInventory.getUpperInventory;

public class GlassItem {

    public static void CreateGlassItem() {

        ItemStack itemStack = new ItemStack(Material.WHITE_STAINED_GLASS_PANE, 1);
        ItemMeta meta = itemStack.getItemMeta();
        assert meta != null;
        meta.setDisplayName("");
        itemStack.setItemMeta(meta);

        for (int i = 0; i < 10; i++) {
            getUpperInventory().setItem(i, itemStack);
        }
        for (int i = 17; i < 27; i++) {
            getUpperInventory().setItem(i, itemStack);
        }
    }
}
