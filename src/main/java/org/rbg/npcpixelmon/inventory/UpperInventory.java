package org.rbg.npcpixelmon.inventory;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.rbg.npcpixelmon.inventory.variables.VariablesInventory;


public class UpperInventory implements Listener {
    public static VariablesInventory invVariables = new VariablesInventory();

    public static Boolean upperInventory(Player p) {
        if (invVariables.getInventory() == null) {
            invVariables.setInvName("Upador de Ev e Level");
            invVariables.setInventory(Bukkit.createInventory(null, 27, invVariables.getInvName()));
            createItems();
        }
        p.openInventory(invVariables.getInventory());
        return true;
    }

    private static void createItems() {
        invVariables.createItem("RED_STAINED_GLASS_PANE", 1, "VOLTAR", 0, invVariables.getInventory());

        invVariables.createItem("PIXELMON_RARE_CANDY", 1, "Level", 10, invVariables.getInventory());
        invVariables.createItem("PIXELMON_POWER_BRACER", 1, "Ev de Attack", 11, invVariables.getInventory());
        invVariables.createItem("PIXELMON_POWER_BELT", 1, "Ev de Defesa", 12, invVariables.getInventory());
        invVariables.createItem("PIXELMON_POWER_WEIGHT", 2, "Ev de HP", 13, invVariables.getInventory());
        invVariables.createItem("PIXELMON_POWER_LENS", 1, "Ev de Special Attack", 14, invVariables.getInventory());
        invVariables.createItem("PIXELMON_POWER_BAND", 1, "Ev de Special Defesa", 15, invVariables.getInventory());
        invVariables.createItem("PIXELMON_POWER_ANKLET", 1, "Ev de Speed", 16, invVariables.getInventory());

        int i;
        for(i = 1; i < 10; ++i) {
            invVariables.createItem("WHITE_STAINED_GLASS_PANE", 1, "", i, invVariables.getInventory());
        }

        for(i = 17; i < 27; ++i) {
            invVariables.createItem("WHITE_STAINED_GLASS_PANE", 1, "", i, invVariables.getInventory());
        }

    }

}