package org.rbg.npcpixelmon.inventory.itens;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import static org.rbg.npcpixelmon.inventory.UpperInventory.getUpperInventory;

public class EvAtkItem extends JavaPlugin {

    public static void CreateEvAtkItem() {
        Material material = Material.valueOf("PIXELMON_POWER_BRACER");

        ItemStack itemStack = new ItemStack(material, 1);
        ItemMeta meta = itemStack.getItemMeta();
        assert meta != null;
        meta.setDisplayName("Ev de Attack");
        itemStack.setItemMeta(meta);
        getUpperInventory().setItem(11, itemStack);
    }

}
