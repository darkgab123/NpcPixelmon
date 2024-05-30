package org.rbg.npcpixelmon.commands;

import net.citizensnpcs.api.CitizensAPI;
import net.citizensnpcs.api.npc.NPC;
import net.citizensnpcs.trait.LookClose;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.rbg.npcpixelmon.commands.Messages.CommandHelp;

public class CreateNPC implements Listener {
    private static JavaPlugin plugin;

    public CreateNPC(JavaPlugin p) {
        plugin = p;
    }

    public static boolean createNPCCommand(CommandSender sender, Player p, String[] args) {
        if (args.length != 3 || !args[2].equalsIgnoreCase("Upper") && !args[2].equalsIgnoreCase("Poke")) {
            return CommandHelp.helpCreate(sender);
        } else {
            String npcName = args[1];
            NPC npc = CitizensAPI.getNPCRegistry().createNPC(EntityType.PLAYER, npcName);
            FileConfiguration config = plugin.getConfig();
            config.set("NPCs." + npc.getId() + ".Inventory", args[2]);
            npc.spawn(p.getLocation());
            LookClose lookClose = npc.getOrAddTrait(LookClose.class);
            lookClose.setRange(10.0);
            lookClose.toggle();
            sender.sendMessage("§f§eO npc" + npcName + " §afoi criado com sucesso(ID §e" + npc.getId() + "§a).");
            return true;
        }
    }
}
