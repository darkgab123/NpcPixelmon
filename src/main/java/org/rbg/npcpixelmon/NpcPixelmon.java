package org.rbg.npcpixelmon;

import org.bukkit.plugin.java.JavaPlugin;
import org.rbg.npcpixelmon.commands.CommandMain;
import org.rbg.npcpixelmon.commands.CreateNPC;
import org.rbg.npcpixelmon.listener.InventoryListener;

import java.util.Objects;

public final class NpcPixelmon extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("§f§aPlugin CustomNPC ativado!");
        saveDefaultConfig();


        Objects.requireNonNull(getCommand("pnpc")).setExecutor(new CommandMain(this));
        getServer().getPluginManager().registerEvents(new CreateNPC(this), this);
        getServer().getPluginManager().registerEvents(new InventoryListener(this), this);
    }

    @Override
    public void onDisable() {

    }
}