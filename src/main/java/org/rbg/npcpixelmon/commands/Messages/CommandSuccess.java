package org.rbg.npcpixelmon.commands.Messages;

import net.citizensnpcs.api.npc.NPC;
import org.bukkit.command.CommandSender;

public class CommandSuccess {

    public static boolean sucesssCreate(CommandSender s, String npcName, NPC npc) {
        s.sendMessage("");
        s.sendMessage("§f§2Sucesso: §aO NPC§e " + npcName + " §afoi criado com sucesso.(ID §e" + npc.getId() + "§a).");
        s.sendMessage("");
        return false;
    }

    public static boolean sucesssDelete(CommandSender s, int id) {
        s.sendMessage("");
        s.sendMessage("§f§2Sucesso: §aO NPC de id: §e" + id + "§afoi deletado com sucesso.");
        s.sendMessage("");
        return false;
    }
}