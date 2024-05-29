package org.rbg.npcpixelmon.inventory;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.java.JavaPlugin;
import static org.rbg.npcpixelmon.inventory.itens.EvAtkItem.CreateEvAtkItem;
import static org.rbg.npcpixelmon.inventory.itens.EvDefItem.CreateEvDefItem;
import static org.rbg.npcpixelmon.inventory.itens.EvHpItem.CreateEvHPItem;
import static org.rbg.npcpixelmon.inventory.itens.EvSpAtkItem.CreateEvSpAtkItem;
import static org.rbg.npcpixelmon.inventory.itens.EvSpDefItem.CreateEvSpDefItem;
import static org.rbg.npcpixelmon.inventory.itens.EvSpdItem.CreateEvSpeedItem;
import static org.rbg.npcpixelmon.inventory.itens.GlassItem.CreateGlassItem;
import static org.rbg.npcpixelmon.inventory.itens.LevelItem.CreateEvLevelItem;

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
            CreateEvLevelItem();
            CreateEvHPItem();
            CreateEvAtkItem();
            CreateEvDefItem();
            CreateEvSpAtkItem();
            CreateEvSpDefItem();
            CreateEvSpeedItem();
            CreateGlassItem();
        }
    }

    public static Inventory getUpperInventory() {
        return inventory;
    }
}
