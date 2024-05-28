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
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.java.JavaPlugin;

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

        if (args.length < 1) {
            player.sendMessage("Digite /criarnpc (Nome).");
            return false;
        } else if (args.length > 1) {
            player.sendMessage("Digits /criarnpc (Nome).");
        }

        String npcName = String.join(" ", args);
        Location npcLocation = player.getLocation();

        NPC npc = CitizensAPI.getNPCRegistry().createNPC(EntityType.PLAYER, npcName);
        npc.spawn(npcLocation);

        player.sendMessage("NPC "+ npcName + " criado com sucesso!");

        return true;
    }

    @EventHandler
    public void onPlayerInteractEntity(PlayerInteractEntityEvent event) {
        if (event.getRightClicked().hasMetadata("NPC")) {
            NPC npc = CitizensAPI.getNPCRegistry().getNPC(event.getRightClicked());
            if (npc != null) {
                Player player = event.getPlayer();
                String npcName = npc.getName();

                Inventory chestInventory = Bukkit.createInventory(null, 27, npcName);
                player.openInventory(chestInventory);
            }
        }
    }
}