package org.rbg.npcpixelmon.commands;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.rbg.npcpixelmon.commands.Messages.CommandError;
import org.rbg.npcpixelmon.commands.Messages.CommandHelp;
import org.rbg.npcpixelmon.inventory.PokeInventory;
import org.rbg.npcpixelmon.inventory.UpperInventory;

public class OpenInventory {
    public OpenInventory() {
    }

    public static boolean createOpenCommand(CommandSender sender, Player p, String[] args) {
        if (args.length == 2) {
            if (args[1].equalsIgnoreCase("Poke")) {
                return PokeInventory.pokeInventory(p);
            } else {
                return CommandError.errorMenu(sender, args[1]);
            }
        }

        return CommandHelp.helpOpen(sender);
    }
}