package org.rbg.npcpixelmon.commands;

import net.citizensnpcs.api.CitizensAPI;
import net.citizensnpcs.api.npc.NPC;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.plugin.java.JavaPlugin;

import static org.rbg.npcpixelmon.inventory.UpperInventory.*;

public class CreateNPC implements CommandExecutor, Listener {


    public CreateNPC(JavaPlugin plugin) {
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player player)) {
            sender.sendMessage("Este comando só pode ser executado por jogadores.");
            return true;
        }
        if (args.length == 1) {
            String npcName = String.join(" ", args);
            Location npcLocation = player.getLocation();

            NPC npc = CitizensAPI.getNPCRegistry().createNPC(EntityType.PLAYER, npcName);
            npc.spawn(npcLocation);

            player.sendMessage("NPC " + npcName + " criado com sucesso!");

            return true;
        }
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