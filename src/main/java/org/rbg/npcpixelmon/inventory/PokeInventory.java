package org.rbg.npcpixelmon.inventory;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.rbg.npcpixelmon.inventory.variables.VariablesInventory;

public class PokeInventory implements Listener {
    public static VariablesInventory invVariables = new VariablesInventory();

    public static Boolean pokeInventory(Player p) {
        if (invVariables.getInventory() == null) {
            invVariables.setInvName("Pokemons");
            invVariables.setInventory(Bukkit.createInventory(null, 27, invVariables.getInvName()));
            createItems();
        }
        p.openInventory(invVariables.getInventory());
        return true;
    }

    private static void createItems() {
        invVariables.createItem("PIXELMON_PIXELMON_SPRITE", 1, "POKEMON999", 10, invVariables.getInventory());
        invVariables.createItem("PIXELMON_PIXELMON_SPRITE", 1, "", 11, invVariables.getInventory());
        invVariables.createItem("PIXELMON_PIXELMON_SPRITE", 1, "", 12, invVariables.getInventory());
        invVariables.createItem("PIXELMON_POKE_BALL", 2, "POKEBOLA", 13, invVariables.getInventory());
        invVariables.createItem("PIXELMON_PIXELMON_SPRITE", 1, "", 14, invVariables.getInventory());
        invVariables.createItem("PIXELMON_PIXELMON_SPRITE", 1, "", 15, invVariables.getInventory());
        invVariables.createItem("PIXELMON_PIXELMON_SPRITE", 1, "", 16, invVariables.getInventory());

        int i;
        for(i = 0; i < 10; ++i) {
            invVariables.createItem("WHITE_STAINED_GLASS_PANE", 1, "", i, invVariables.getInventory());
        }

        for(i = 17; i < 27; ++i) {
            invVariables.createItem("WHITE_STAINED_GLASS_PANE", 1, "", i, invVariables.getInventory());
        }

    }

}
