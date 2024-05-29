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
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import static org.rbg.npcpixelmon.commands.CreateNPC.CreateNPCCommand;

public class CommandMain implements CommandExecutor, Listener {

    public CommandMain(JavaPlugin plugin) {
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player player)) {
            sender.sendMessage("Este comando só pode ser executado por jogadores.");
            return true;
        }

        if (!player.hasPermission("NpcPixelmon.admin")) {
            player.sendMessage("Você não tem permissão para usar comandos de administrador.");
            return true;
        }

        if (args.length < 1 || args.length > 2) {
            sender.sendMessage("Use: /pnpc <SubComando> <Name>");
            return true;
        }

        if (args[0].equalsIgnoreCase("create")) {
            return CreateNPCCommand(sender, player, args);
        }
        return false;
    }

}
