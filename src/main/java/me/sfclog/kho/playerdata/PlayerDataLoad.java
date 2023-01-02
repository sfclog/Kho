package me.sfclog.kho.playerdata;

import com.cryptomorin.xseries.XMaterial;
import me.sfclog.kho.Main;
import me.sfclog.kho.config.PluginConfig;
import me.sfclog.kho.data.Data;
import org.bukkit.entity.Player;

import java.util.HashMap;

public class PlayerDataLoad {

    public static HashMap<XMaterial,Integer> getData(Player p) {
        HashMap<XMaterial, Integer> map = new HashMap<>();
        if (Data.DataFile.getConfigurationSection("Data." + p.getName()) != null) {
            for (String str : Data.DataFile.getConfigurationSection("Data." + p.getName()).getKeys(false)) {
                if(str != null && !str.contains("Toggle")) {
                    XMaterial m = XMaterial.valueOf(str);
                    int amount = Data.getint("Data." + p.getName() + "." + str);
                    map.put(m,amount);
                }
            }
        }
        return map;
    }

    public static boolean getToggle(Player p) {
        return Data.gettoggle("Data." + p.getName() + ".Toggle");
    }


    public static void saveData(PlayerData data) {
        if(data.data != null && !data.data.isEmpty()) {
            for(XMaterial m : data.data.keySet()) {
                if(m != null) {
                    int amount = data.data.get(m);
                    Data.setforcelang("Data." + data.getPlayer() + "." + m.parseMaterial().name(),amount);
                    Data.setforceb("Data." + data.getPlayer() + ".Toggle",data.gettoggle());
                }
            }
        }
        Data.save();
    }

    public static void load(Player p) {
        HashMap<XMaterial,Integer> map = PlayerDataLoad.getData(p);
        boolean toggle = PlayerDataLoad.getToggle(p);
        PlayerData data = new PlayerData(p,toggle,map);
        if(data != null) {
            PlayerDataManage.add(p,data);
        }
    }
}
