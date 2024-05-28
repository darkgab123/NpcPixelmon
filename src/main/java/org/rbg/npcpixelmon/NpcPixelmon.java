package org.rbg.npcpixelmon;

import org.bukkit.plugin.java.JavaPlugin;
import org.rbg.npcpixelmon.commands.CreateNPC;
import org.rbg.npcpixelmon.listener.InventoryListener;

import javax.swing.event.MenuListener;
import java.util.Objects;

public final class NpcPixelmon extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("Plugin CustomNPC ativado!");
        try {
            Objects.requireNonNull(getCommand("criarnpc")).setExecutor(new CreateNPC(this));
            getServer().getPluginManager().registerEvents(new InventoryListener(), this);
        } catch (NullPointerException e) {
            getLogger().warning("O comando 'criarnpc' não foi encontrado! Verifique se está definido corretamente no plugin.yml.");
        }
    }

    @Override
    public void onDisable() {

    }
}