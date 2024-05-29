package org.rbg.npcpixelmon.commands;

import net.citizensnpcs.api.CitizensAPI;
import net.citizensnpcs.api.npc.NPC;
import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;

import static org.rbg.npcpixelmon.inventory.UpperInventory.*;

public class CreateNPC implements Listener {

    public static boolean CreateNPCCommand(CommandSender sender, Player p, String[] args) {
        if (!p.hasPermission("NpcPixelmon.admin.create")) {
            p.sendMessage("Você não tem permissão para criar NPCs.");
            return true;
        }

        if (args.length == 2) {
            String npcName = args[1];
            Location npcLocation = p.getLocation();

            NPC npc = CitizensAPI.getNPCRegistry().createNPC(EntityType.PLAYER, npcName);
            npc.spawn(npcLocation);

            p.sendMessage("NPC " + npcName + " criado com sucesso!");

            return true;
        }

        sender.sendMessage("Use: /pnpc create <nome>");
        return false;
    }

    @EventHandler
    public void onPlayerInteractEntity(PlayerInteractEntityEvent event) {
        if (event.getRightClicked().hasMetadata("NPC")) {
            NPC npc = CitizensAPI.getNPCRegistry().getNPC(event.getRightClicked());
            if (npc != null) {
                Player player = event.getPlayer();

                createUpperInventory();
                player.openInventory(getUpperInventory());
            }
        }
    }
}
