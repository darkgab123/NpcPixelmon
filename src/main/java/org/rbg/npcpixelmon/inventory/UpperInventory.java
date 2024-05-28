package org.rbg.npcpixelmon.inventory;

import com.pixelmonmod.pixelmon.api.registries.PixelmonItems;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.inventory.meta.ItemMeta;

public class UpperInventory extends JavaPlugin implements Listener {

    private static Inventory inventory;

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(this, this);
        createUpperInventory();
    }

    public static void createUpperInventory() {

        if (inventory == null) {
            inventory = Bukkit.createInventory(null, 9 * 3, "Upador de Ev e Level");

            ItemStack Item = new ItemStack(Material.ACACIA_DOOR);
            ItemMeta meta = Item.getItemMeta();
            assert meta != null;
            meta.setDisplayName("Item Fixo");
            Item.setItemMeta(meta);
            inventory.setItem(13, Item);
        }
    }

    public static Inventory getUpperInventory() {
        return inventory;
    }
}
