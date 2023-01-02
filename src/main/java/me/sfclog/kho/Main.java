package me.sfclog.kho;

import me.sfclog.kho.command.KhoCommand;
import me.sfclog.kho.config.PluginConfig;
import me.sfclog.kho.gui.KhoGui;
import me.sfclog.kho.khomanage.KhoManage;
import me.sfclog.kho.playerdata.PlayerData;
import me.sfclog.kho.playerdata.PlayerDataLoad;
import me.sfclog.kho.playerdata.PlayerDataManage;
import me.sfclog.kho.playerevent.PlayerEvent;
import me.sfclog.kho.utils.Color;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    public static Plugin pl;
    public static void sendlog(String s) {
        Bukkit.getConsoleSender().sendMessage(Color.tran(s));
    }


    @Override
    public void onEnable() {
        pl = this;
        sendlog("&m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m ");
        sendlog(" ");
        sendlog("&8[&eKho&8] &f- Kho Vật Phẩm 0.1");
        sendlog("&fAuthor: &eSFC_Log");
        sendlog(" ");
        sendlog("&aPlugin is Enable");
        sendlog(" ");
        sendlog("&m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m ");

        //load config
        PluginConfig.loadconfig();

        //reg command
        this.getCommand("kho").setExecutor(new KhoCommand());
        this.getCommand("kho").setTabCompleter(new KhoCommand());

        //reg item
        KhoManage.load();

        //reg event
        getServer().getPluginManager().registerEvents(new KhoGui(),this);
        getServer().getPluginManager().registerEvents(new PlayerEvent(),this);

        for(Player p : Bukkit.getOnlinePlayers()) {
            if(p != null) {
                PlayerDataLoad.load(p);
            }
        }
    }

    @Override
    public void onDisable() {
        sendlog("&m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m ");
        sendlog(" ");
        sendlog("&8[&eKho&8] &f- Kho Vật Phẩm 0.1");
        sendlog("&fAuthor: &eSFC_Log");
        sendlog(" ");
        sendlog("&cPlugin is Disable");
        sendlog(" ");
        sendlog("&m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m ");

        for(Player p : Bukkit.getOnlinePlayers()) {
            if(p != null) {
                PlayerData data = PlayerDataManage.getData(p);
                if(data != null) {
                    PlayerDataLoad.saveData(data);
                }
            }
        }

        pl = null;
    }

}
