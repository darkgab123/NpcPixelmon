package org.rbg.npcpixelmon.commands;

import net.citizensnpcs.api.CitizensAPI;
import net.citizensnpcs.api.npc.NPC;
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

        String idString = args[1];
        int id;

        try {
            id = Integer.parseInt(idString);
        } catch (NumberFormatException e) {
            sender.sendMessage("§cID inválido. Deve ser um número.");
            return false;
        }

        NPC npc = CitizensAPI.getNPCRegistry().getById(id);
        if (npc == null) {
            sender.sendMessage("§cNPC com ID " + id + " não encontrado.");
            return false;
        }

        FileConfiguration config = plugin.getConfig();
        config.set("NPCs."  + id, null);
        npc.despawn();
        npc.destroy();

        sender.sendMessage("§f§eO npc de id: " + id + " §afoi deletado com sucesso.");

        return true;
    }
}