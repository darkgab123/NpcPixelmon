package org.rbg.npcpixelmon.commands.Messages;

import org.bukkit.command.CommandSender;

public class CommandError {

    public static boolean errorMenu(CommandSender s, String menu) {
        s.sendMessage("");
        s.sendMessage("§f§cErro: §4Menu §c" + menu + " §4inválido. §CNão encontrado.");
        s.sendMessage("");
        return false;
    }

    public static boolean errorDelete(CommandSender s) {
        s.sendMessage("");
        s.sendMessage("§f§cErro: §4ID inválido§C. Deve ser um número.");
        s.sendMessage("");
        return false;
    }


    public static boolean errorDeleteTwo(CommandSender s, int id) {
        s.sendMessage("");
        s.sendMessage("§f§cErro: §4ID §c" + id + " §4inválido. §cNão encontrado.");
        s.sendMessage("");
        return false;
    }
}