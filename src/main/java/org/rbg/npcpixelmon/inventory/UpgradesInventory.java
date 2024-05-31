package org.rbg.npcpixelmon.inventory;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.rbg.npcpixelmon.inventory.variables.VariablesInventory;

public class UpgradesInventory {
    public static VariablesInventory invVariables = new VariablesInventory();
    public static String invName;

    public static Boolean upgradesInventory(Player p, String varInvName) {
        invName = varInvName;

        invVariables.setInvName(varInvName);
        invVariables.setInventory(Bukkit.createInventory(null, 27, invVariables.getInvName()));
        createItems();

        p.openInventory(invVariables.getInventory());
        return true;
    }

    private static void createItems() {
        invVariables.createItem("RED_STAINED_GLASS_PANE", 1, "VOLTAR", 0, invVariables.getInventory());

        String item = switchItens(invName);
        for(int i = 10; i < 17; i++){
            switch (i){
                case 10:
                    invVariables.createItem(item, 10, invName + " 10", i, invVariables.getInventory());
                    break;
                case 11:
                    invVariables.createItem(item, 20, invName + " 20", i, invVariables.getInventory());
                    break;
                case 12:
                    invVariables.createItem(item, 30, invName + " 30", i, invVariables.getInventory());
                    break;
                case 13:
                    invVariables.createItem(item, 40, invName + " 40", i, invVariables.getInventory());
                    break;
                case 14:
                    invVariables.createItem(item, 50, invName + " 50", i, invVariables.getInventory());
                    break;
                case 15:
                    invVariables.createItem(item, 64, invName + " 64", i, invVariables.getInventory());
                    break;
                case 16:
                    invVariables.createItem(item, 1, invName + " FULL", i, invVariables.getInventory());
                    break;
            }

        }

        int i;
        for(i = 1; i < 10; ++i) {
            invVariables.createItem("WHITE_STAINED_GLASS_PANE", 1, "", i, invVariables.getInventory());
        }

        for(i = 17; i < 27; ++i) {
            invVariables.createItem("WHITE_STAINED_GLASS_PANE", 1, "", i, invVariables.getInventory());
        }
    }

    private static String switchItens(String item) {
        switch (item) {
            case "Level":
                return "PIXELMON_RARE_CANDY";
            case "Ev de Attack":
                return "PIXELMON_POWER_BRACER";
            case "Ev de Defesa":
                return "PIXELMON_POWER_BELT";
            case "Ev de HP":
                return "PIXELMON_POWER_WEIGHT";
            case "Ev de Special Attack":
                return "PIXELMON_POWER_LENS";
            case "Ev de Special Defesa":
                return "PIXELMON_POWER_BAND";
            case "Ev de Speed":
                return "PIXELMON_POWER_ANKLET";
            default:
                return "MINECRAFT_BARRIER";
        }
    }
}
