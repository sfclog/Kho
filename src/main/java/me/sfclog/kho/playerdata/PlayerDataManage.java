package me.sfclog.kho.playerdata;

import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.HashSet;

public class PlayerDataManage {

    public static HashMap<Player , PlayerData> datamanage = new HashMap<>();
    public static void add(Player p , PlayerData data) {
        if(!datamanage.containsKey(p)) {
            datamanage.put(p,data);
        }
    }

    public static void remove(Player p) {
        if(datamanage.containsKey(p)) {
            PlayerData data = datamanage.get(p);
            if(data != null) {
                PlayerDataLoad.saveData(data);
            }
            datamanage.remove(p);
        }
    }


    public static PlayerData getData(Player p) {
        if(datamanage.containsKey(p)) {
            return datamanage.get(p);
        }
        return null;
    }
}
