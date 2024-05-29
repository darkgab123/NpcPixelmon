package org.rbg.npcpixelmon.commands;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static org.rbg.npcpixelmon.inventory.store.StoreUpperInventory.createStoreUpperInventory;
import static org.rbg.npcpixelmon.inventory.store.StoreUpperInventory.getStoreUpperInventory;


public class OpenInventory {

    public static boolean CreateOpenCommand(CommandSender sender, Player p, String[] args) {
        if (!p.hasPermission("NpcPixelmon.admin.open")) {
            sender.sendMessage("§f§cVocê não tem permissão para abrir o menu.");
            return true;
        }

        if (args.length == 2) {
            if (args[1].equalsIgnoreCase("Upper")) {
                createStoreUpperInventory();
                p.openInventory(getStoreUpperInventory());
                return true;
            } else if (args[1].equalsIgnoreCase("Select")) {
                sender.sendMessage("§f§cO menu não está pronto, tente abrir outro.");
                return true;
            }
        }

        sender.sendMessage("§f§aUse: /pNPC abrir [Upper, Select]");
        return false;
    }
}
