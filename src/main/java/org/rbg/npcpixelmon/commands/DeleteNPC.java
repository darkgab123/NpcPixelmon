package org.rbg.npcpixelmon.commands;

import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class DeleteNPC implements Listener {
    private static JavaPlugin plugin;

    public DeleteNPC(JavaPlugin p) {
        plugin = p;
    }

    public static boolean deleteNPCCommand(CommandSender sender, Player p, String[] args){
        String id = args[1];
        FileConfiguration config = plugin.getConfig();

        config.set("NPCs."  + id, null);
        sender.sendMessage("§f§eO npc de id: " + id + " §afoi deletado com sucesso.");
        return true;
    }
}