package org.rbg.npcpixelmon;

import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class NpcPixelmon extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("Plugin CustomNPC ativado!");
        try {
            Objects.requireNonNull(getCommand("criarnpc")).setExecutor(new CreateNPCCommand(this));
        } catch (NullPointerException e) {
            getLogger().warning("O comando 'criarnpc' não foi encontrado! Verifique se está definido corretamente no plugin.yml.");
        }
    }

    @Override
    public void onDisable() {

    }
}
