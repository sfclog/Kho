package me.sfclog.kho.utils;

import me.sfclog.kho.Main;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Util {


    public static boolean hasItem(Player p, Material m , int size) {
        OffHandFix.clear_off_hand(p, m);
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (ItemStack item : p.getInventory().getContents()) {
            if(item != null) {
                if(item.getType() == m) {
                    if(check_custome_item(item)) {
                        list.add(item.getAmount());
                    }
                }
            }
        }
        if(!list.isEmpty() && summap(list) >= size) {
            return true;
        }

        return false;
    }


    private static int summap(ArrayList<Integer> list) {
        int i = 0;
        for(Integer ok : list) {
            i += ok;
        }
        return i;
    }

    public static boolean check_custome_item(ItemStack item) {
        ItemMeta meta = item.getItemMeta();
        if(meta != null) {
            if(meta.hasDisplayName()) {
                return false;
            }
            if(meta.hasLore()) {
                return false;
            }
            if(meta.hasEnchants()) {
                return false;
            }
        }

        return true;
    }


    public static void giveitem(Player p,Material m,int size) {
        HashMap<Integer, ItemStack> nope = p.getInventory().addItem(new ItemStack(m,size));
        for(Map.Entry<Integer, ItemStack> entry : nope.entrySet()) {
            p.getWorld().dropItemNaturally(p.getLocation().add(0,1,0), entry.getValue());
            p.updateInventory();
        }
    }


    public static boolean check_blackslot(Player p , int size) {
        ArrayList<Integer> blackslot = new ArrayList<Integer>();
        for (int i = 0; i < 36; i++) {
            ItemStack slot = p.getInventory().getItem(i);
            if (slot == null) {
                blackslot.add(i);
            }
        }
        if(!blackslot.isEmpty() && 64 * blackslot.size() >= size) {
            return  true;
        }
        return false;
    }


    public static int removeItems(Player p, Material type, int amount) {
        if(type == null || p.getInventory() == null)
            return -1;
        if (amount <= 0)
            return -1;
        if (amount == Integer.MAX_VALUE) {
            p.getInventory().remove(type);
            p.updateInventory();
            return 0;
        }
        HashMap<Integer,ItemStack> retVal = p.getInventory().removeItem(new ItemStack(type,amount));
        int notRemoved = 0;
        for(ItemStack item: retVal.values()) {
            notRemoved+=item.getAmount();
            p.updateInventory();
        }
        return notRemoved;
    }



}
