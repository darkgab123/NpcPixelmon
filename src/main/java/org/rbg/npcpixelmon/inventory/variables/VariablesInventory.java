package org.rbg.npcpixelmon.inventory.variables;

import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class VariablesInventory {
    private String invName;
    private Inventory inventory;

    public VariablesInventory() {
    }

    public VariablesInventory(String invName, Inventory inventory){
        super();
        this.invName = invName;
        this.inventory = inventory;
    }

    public String getInvName() {
        return invName;
    }

    public void setInvName(String invName) {
        this.invName = invName;
    }

    public Inventory getInventory(){
        return inventory;
    }

    public void setInventory(Inventory inventory){
        this.inventory = inventory;
    }

    public void createItem(String item, int amount, String displayName, int slot, Inventory inventory) {
        Material material = Material.valueOf(item);
        ItemStack itemStack = new ItemStack(material, amount);
        ItemMeta meta = itemStack.getItemMeta();

        assert meta != null;

        meta.setDisplayName(displayName);
        itemStack.setItemMeta(meta);
        inventory.setItem(slot, itemStack);
    }
}