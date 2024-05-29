package org.rbg.npcpixelmon.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import static org.rbg.npcpixelmon.commands.CreateNPC.CreateNPCCommand;
import static org.rbg.npcpixelmon.commands.OpenInventory.CreateOpenCommand;

public class CommandMain implements CommandExecutor, Listener {

    public CommandMain(JavaPlugin plugin) {
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player player)) {
            sender.sendMessage("§f§cEste comando só pode ser executado por jogadores.");
            return true;
        }

        if (!player.hasPermission("NpcPixelmon.admin")) {
            sender.sendMessage("§f§cVocê não tem permissão para usar comandos de administrador.");
            return true;
        }

        if (args.length < 1 || args.length > 3) {
            sender.sendMessage("§f§aUse: /pnpc <SubComando>");
            return true;
        }

        if (args[0].equalsIgnoreCase("criar")) {
            return CreateNPCCommand(sender, player, args);
        }

        if (args[0].equalsIgnoreCase("abrir")) {
            return CreateOpenCommand(sender, player, args);
        }

        sender.sendMessage("§f§aUse: /pNPC [Criar, Abrir]");
        return false;
    }

}