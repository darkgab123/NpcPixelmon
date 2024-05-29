package org.rbg.npcpixelmon.commands;

import net.citizensnpcs.api.CitizensAPI;
import net.citizensnpcs.api.npc.NPC;
import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class CreateNPC implements Listener {

    private static JavaPlugin plugin;

    public CreateNPC(JavaPlugin p) {
        plugin = p;
    }

    public static boolean CreateNPCCommand(CommandSender sender, Player p, String[] args) {
        if (!p.hasPermission("NpcPixelmon.admin.create")) {
            sender.sendMessage("§f§cVocê não tem permissão para criar NPCs.");
            return true;
        }

        if (args.length == 3) {
            if (args[2].equalsIgnoreCase("Upper")) {
                String npcName = args[1];
                Location npcLocation = p.getLocation();

                NPC npc = CitizensAPI.getNPCRegistry().createNPC(EntityType.PLAYER, npcName);
                FileConfiguration config = plugin.getConfig();
                config.set("NPCs." + npc.getId() + ".Inventory", args[2]);
                plugin.saveConfig();

                npc.spawn(npcLocation);


                sender.sendMessage("§f§aNPC " + npcName + " criado com sucesso!");

                return true;
            }
        }

        sender.sendMessage("§f§aUse: /pNPC criar <Nome do NPC> [Upper, Select]");
        return false;
    }
}