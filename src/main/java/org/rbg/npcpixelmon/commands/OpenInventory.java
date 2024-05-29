package org.rbg.npcpixelmon.commands;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.rbg.npcpixelmon.commands.Messages.CommandHelp;
import org.rbg.npcpixelmon.inventory.PokeInventory;
import org.rbg.npcpixelmon.inventory.UpperInventory;

public class OpenInventory {
    public OpenInventory() {
    }

    public static boolean CreateOpenCommand(CommandSender sender, Player p, String[] args) {
        if (args.length == 2) {
            if (args[1].equalsIgnoreCase("Upper")) {
                UpperInventory.createUpperInventory();
                p.openInventory(UpperInventory.getUpperInventory());
                return true;
            }

            if (args[1].equalsIgnoreCase("Poke")) {
                PokeInventory.createPokeInventory();
                p.openInventory(PokeInventory.getPokeInventory());
                return true;
            }
        }

        return CommandHelp.helpOpen(sender);
    }
}
