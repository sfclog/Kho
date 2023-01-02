package me.sfclog.kho.khomanage;

import com.cryptomorin.xseries.XMaterial;
import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.inventory.ItemStack;

public class KhoItem {


    public String name;
    public XMaterial material;

    public int slot;

    public KhoItem(String name , XMaterial material , int slot) {
        this.name = name;
        this.material = material;
        this.slot = slot;
    }

    public ItemStack getType() {
        return this.material.parseItem();
    }

    public int getSlot() {
        return this.slot;
    }
    public String getName() {
        return this.name;
    }

    public XMaterial getXM() {
        return this.material;
    }
}
