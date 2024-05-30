package org.rbg.npcpixelmon;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;
import org.rbg.npcpixelmon.commands.CommandMain;
import org.rbg.npcpixelmon.commands.CreateNPC;
import org.rbg.npcpixelmon.commands.DeleteNPC;
import org.rbg.npcpixelmon.listener.InventoryListener;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public final class NpcPixelmon extends JavaPlugin {
    public NpcPixelmon() {
    }

    public void onEnable() {
        this.saveDefaultConfig();
        Objects.requireNonNull(this.getCommand("np")).setExecutor(new CommandMain(this));
        Objects.requireNonNull(this.getCommand("np")).setTabCompleter(this);
        this.getServer().getPluginManager().registerEvents(new CreateNPC(this), this);
        this.getServer().getPluginManager().registerEvents(new DeleteNPC(this), this);
        this.getServer().getPluginManager().registerEvents(new InventoryListener(this), this);
    }

    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        if (args.length == 1) {
            return Arrays.asList("criar", "deletar", "abrir");
        } else if (args.length == 3 && args[0].equalsIgnoreCase("criar")) {
            return Arrays.asList("Upper", "Poke");
        } else {
            return args.length == 2 && args[0].equalsIgnoreCase("abrir") ? Arrays.asList("Upper", "Poke") : Collections.emptyList();
        }
    }

    public void onDisable() {
        saveConfig();
    }
}
