package me.sfclog.kho.playerdata;

import com.cryptomorin.xseries.XMaterial;
import org.bukkit.entity.Player;

import java.util.HashMap;

public class PlayerData {

    public Player p;

    public boolean toggle;

    public HashMap<XMaterial,Integer> data;

    public PlayerData(Player p , boolean toggle , HashMap<XMaterial,Integer> data) {

      this.p = p;
      this.toggle = toggle;
      this.data = data;

    }

    public void settoggle(boolean b) {
        this.toggle = b;
    }
    public boolean gettoggle() {
        return toggle;
    }
    public int getM(XMaterial m) {
        if(data.containsKey(m)) {
            return data.get(m);
        }
        return 0;
    }

    public void addM(XMaterial m , int amount) {
        setM(m,getM(m) + amount);
    }
    public void takeM(XMaterial m , int amount) {
        int i = getM(m) - amount;
        setM(m,i < 0 ? 0 : i);
    }

    public void setM(XMaterial m , int amount) {
        if(data.containsKey(m)) {
            data.replace(m,amount);
        } else {
            data.put(m,amount);
        }
    }


    public String getPlayer() {
        return p.getName();
    }

    public boolean isPlayer(Player p) {
        return this.p == p;
    }
}
