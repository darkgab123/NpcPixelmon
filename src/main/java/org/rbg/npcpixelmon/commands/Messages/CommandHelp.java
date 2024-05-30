package org.rbg.npcpixelmon.commands.Messages;

import org.bukkit.command.CommandSender;

public class CommandHelp {

    public static boolean helpGeneral(CommandSender s) {
        s.sendMessage("");
        s.sendMessage("§f§6Uso(s): ");
        s.sendMessage("§f/np criar §e<Nome do NPC> §e[Poke] §6- Cria um NPC baseado em Citizens, porém configuramente diferente");
        s.sendMessage("§f/np deletar §e<Nome do NPC> §6- Deleta completamente o NPC, mas não o menu");
        s.sendMessage("§f/np open §e[Poke, Upper] §6- Abre um menu desejado");
        s.sendMessage("");
        return true;
    }

    public static boolean helpCreate(CommandSender s) {
        s.sendMessage("");
        s.sendMessage("§f§cErro: §4/np criar <Nome do NPC> [Poke]");
        s.sendMessage("");
        return false;
    }

    public static boolean helpOpen(CommandSender s) {
        s.sendMessage("");
        s.sendMessage("§f§cErro: §4/np abrir [Poke]");
        s.sendMessage("");
        return false;
    }

    public static boolean helpDelete(CommandSender s) {
        s.sendMessage("");
        s.sendMessage("§f§cErro: §4/np deletar <Nome do NPC>");
        s.sendMessage("");
        return false;
    }
}