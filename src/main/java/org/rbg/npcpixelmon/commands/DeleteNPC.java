package org.rbg.npcpixelmon.commands;

import net.citizensnpcs.api.CitizensAPI;
import net.citizensnpcs.api.npc.NPC;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.rbg.npcpixelmon.commands.Messages.CommandError;
import org.rbg.npcpixelmon.commands.Messages.CommandHelp;
import org.rbg.npcpixelmon.commands.Messages.CommandSuccess;

public class DeleteNPC implements Listener {
    private static JavaPlugin plugin;

    public DeleteNPC(JavaPlugin p) {
        plugin = p;
    }

    public static boolean deleteNPCCommand(CommandSender sender, Player p, String[] args){

        if (args.length == 2) {
            String idString = args[1];
            int id;

            try {
                id = Integer.parseInt(idString);
            } catch (NumberFormatException e) {
                return CommandError.errorDelete(sender);
            }

            NPC npc = CitizensAPI.getNPCRegistry().getById(id);
            if (npc == null) {
                return CommandError.errorDeleteTwo(sender, id);
            }

            FileConfiguration config = plugin.getConfig();
            config.set("NPCs." + id, null);
            npc.despawn();
            npc.destroy();


            return CommandSuccess.sucesssDelete(sender, id);
        }
        return CommandHelp.helpDelete(sender);

    }
}