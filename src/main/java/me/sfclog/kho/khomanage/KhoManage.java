package me.sfclog.kho.khomanage;

import com.cryptomorin.xseries.XMaterial;
import me.sfclog.kho.Main;
import me.sfclog.kho.config.PluginConfig;
import org.bukkit.Material;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class KhoManage {

    public static HashMap<Integer,KhoItem> khomanage = new HashMap<>();


    public static void load() {
        khomanage.clear();
        if (PluginConfig.DataFile.getConfigurationSection("Gui.Item") != null) {
            for (String str : PluginConfig.DataFile.getConfigurationSection("Gui.Item").getKeys(false)) {
                if (str != null) {
                    String name = PluginConfig.getlang("Gui.Item." + str + ".Name");
                    XMaterial type = XMaterial.valueOf(PluginConfig.getlang("Gui.Item." + str + ".Material"));
                    int slot = PluginConfig.getint("Gui.Item." + str + ".Slot");
                    KhoItem item = new KhoItem(name,type,slot);
                    if(item != null) {
                        khomanage.put(slot,item);
                    }
                }
            }
        }
        Main.sendlog("&8[&eKho&8] &aLoad &f" + khomanage.size() + " &aItem.");
    }

    public static List<KhoItem> getAllItem() {
        return khomanage.values().stream().collect(Collectors.toList());
    }
    public static KhoItem getItemSlot(int i) {
        if(khomanage.containsKey(i)) {
            return khomanage.get(i);
        }
        return null;
    }

    public static boolean isSupport(Material type) {
        if(type != null) {
            XMaterial m = XMaterial.valueOf(type.name());
            if(m != null) {
                for(KhoItem item : khomanage.values()) {
                    if(item != null && item.getXM() == m) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
