package org.rbg.npcpixelmon.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.rbg.npcpixelmon.commands.Messages.CommandHelp;

public class CommandMain implements CommandExecutor, Listener {
    public CommandMain(JavaPlugin plugin) {
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player player) {
            if (args.length == 0) {
                return CommandHelp.helpGeneral(sender);
            } else if (args[0].equalsIgnoreCase("criar") && player.hasPermission("npcpixelmon.create")) {
                return CreateNPC.createNPCCommand(sender, player, args);
            } else if (args[0].equalsIgnoreCase("abrir") && player.hasPermission("npcpixelmon.open")) {
                return OpenInventory.createOpenCommand(sender, player, args);
            } else if (args[0].equalsIgnoreCase("deletar") && player.hasPermission("npcpixelmon.delete")) {
                return DeleteNPC.deleteNPCCommand(sender, player, args);
            } else {
                return CommandHelp.helpGeneral(sender);
            }
        } else {
            return false;
        }
    }
}