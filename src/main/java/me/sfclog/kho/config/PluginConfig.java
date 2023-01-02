package me.sfclog.kho.config;

import me.sfclog.kho.Main;
import me.sfclog.kho.utils.Color;
import me.sfclog.kho.utils.Send;
import org.bukkit.Material;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PluginConfig {

    public static File locate = new File("plugins/Kho/", "config.yml");
    public static FileConfiguration DataFile = (FileConfiguration) YamlConfiguration.loadConfiguration(locate);


    public static void loadconfig() {
        addlang("Plugin.Prefix","&8[&eKho&8] ");

        addlang("Plugin.Reload","&aĐã tải lại plugin !");
        addlang("Plugin.ReloadFail","&cCó lỗi khi tải lại plugin !");



        addlang("Kho.MaxAmount",100000);

        addlang("Kho.Msg.FailLoadData"," &cLỗi: &fKhông thể tải dữ liệu của bạn! &c✘");
        addlang("Kho.Msg.IsEmpty"," &cLỗi: &fBạn không có đủ khoáng sản để rút! &c✘");
        addlang("Kho.Msg.IsEmptyIn"," &cLỗi: &fBạn không có khoáng sản để cất vô kho! &c✘");

        addlang("Kho.Msg.ItemInPut","&fĐã cất &ax<amount> <name> &fvào kho khoáng sản &a✔");
        addlang("Kho.Msg.ItemOutPut","&fĐã rút &ax<out_amount> <out_name> &f, bạn còn lại &ax<amount> <name> &a✔");
        addlang("Kho.Msg.ItemOutPutAll","&fĐã rút hết khoáng sản từ kho, nhận được &ax<amount> <name> &a✔");
        addlang("Kho.Msg.ItemInPutAll","&fĐã cất &ax<out_amount> <out_name> &fvào kho khoáng sản, bạn đang có &ax<amount> <name> &a✔");

        addlang("Gui.Size",18);
        addlang("Gui.Title","&fKho khoáng sản &8[&2<player_name>&8]");

        addlang("Gui.Item.COAL.Name","&8[&eKho&8] &3| &8Than");
        addlang("Gui.Item.COAL.Slot",0);
        addlang("Gui.Item.COAL.Material","COAL");

        addlang("Gui.Item.LAPIS_LAZULI.Name","&8[&eKho&8] &3| &1Ngọc lưu ly");
        addlang("Gui.Item.LAPIS_LAZULI.Slot",1);
        addlang("Gui.Item.LAPIS_LAZULI.Material","LAPIS_LAZULI");

        addlang("Gui.Item.REDSTONE.Name","&8[&eKho&8] &3| &4Đá đỏ");
        addlang("Gui.Item.REDSTONE.Slot",2);
        addlang("Gui.Item.REDSTONE.Material","REDSTONE");


        addlang("Gui.Item.IRON_INGOT.Name","&8[&eKho&8] &3| &fSắt");
        addlang("Gui.Item.IRON_INGOT.Slot",3);
        addlang("Gui.Item.IRON_INGOT.Material","IRON_INGOT");

        addlang("Gui.Item.GOLD_INGOT.Name","&8[&eKho&8] &3| &eVàng");
        addlang("Gui.Item.GOLD_INGOT.Slot",4);
        addlang("Gui.Item.GOLD_INGOT.Material","GOLD_INGOT");


        addlang("Gui.Item.DIAMOND.Name","&8[&eKho&8] &3| &bKim cương");
        addlang("Gui.Item.DIAMOND.Slot",5);
        addlang("Gui.Item.DIAMOND.Material","DIAMOND");

        addlang("Gui.Item.EMERALD.Name","&8[&eKho&8] &3| &aLục bảo");
        addlang("Gui.Item.EMERALD.Slot",6);
        addlang("Gui.Item.EMERALD.Material","EMERALD");


        addlang("Gui.Item.STONE.Name","&8[&eKho&8] &3| &7Khối đá");
        addlang("Gui.Item.STONE.Slot",7);
        addlang("Gui.Item.STONE.Material","STONE");


        addlang("Gui.Item.COAL_BLOCK.Name","&8[&eKho&8] &3| &8Khối than");
        addlang("Gui.Item.COAL_BLOCK.Slot",9);
        addlang("Gui.Item.COAL_BLOCK.Material","COAL_BLOCK");

        addlang("Gui.Item.LAPIS_BLOCK.Name","&8[&eKho&8] &3| &1Khối lưu ly");
        addlang("Gui.Item.LAPIS_BLOCK.Slot",10);
        addlang("Gui.Item.LAPIS_BLOCK.Material","LAPIS_BLOCK");


        addlang("Gui.Item.REDSTONE_BLOCK.Name","&8[&eKho&8] &3| &4Khối đá đỏ");
        addlang("Gui.Item.REDSTONE_BLOCK.Slot",11);
        addlang("Gui.Item.REDSTONE_BLOCK.Material","REDSTONE_BLOCK");


        addlang("Gui.Item.IRON_BLOCK.Name","&8[&eKho&8] &3| &fKhối sắt");
        addlang("Gui.Item.IRON_BLOCK.Slot",12);
        addlang("Gui.Item.IRON_BLOCK.Material","IRON_BLOCK");


        addlang("Gui.Item.GOLD_BLOCK.Name","&8[&eKho&8] &3| &eKhối vàng");
        addlang("Gui.Item.GOLD_BLOCK.Slot",12);
        addlang("Gui.Item.GOLD_BLOCK.Material","GOLD_BLOCK");

        addlang("Gui.Item.DIAMOND_BLOCK.Name","&8[&eKho&8] &3| &bKhối kim cương");
        addlang("Gui.Item.DIAMOND_BLOCK.Slot",13);
        addlang("Gui.Item.DIAMOND_BLOCK.Material","DIAMOND_BLOCK");

        addlang("Gui.Item.EMERALD_BLOCK.Name","&8[&eKho&8] &3| &aKhối lục bảo");
        addlang("Gui.Item.EMERALD_BLOCK.Slot",14);
        addlang("Gui.Item.EMERALD_BLOCK.Material","EMERALD_BLOCK");


        addlang("Gui.QuitItem.Name","&8[&eKho&8] &cThoát");
        addlang("Gui.QuitItem.Material","BARRIER");
        addlang("Gui.QuitItem.Slot",17);

        List<String> quit = new ArrayList<>();
        quit.add(" ");
        quit.add(" &fDùng để thoát khỏi kho khoáng sản.");
        quit.add(" ");
        addlang("Gui.QuitItem.Lore",quit);


        List<String> list = new ArrayList<>();
        list.add("&6Số lượng: &e<amount>&8/&f<maxamount>");
        list.add(" ");
        list.add("&8[&eChuột Trái&8] &aNhập số lượng muốn rút");
        list.add("&8[&eChuột Phải&8] &aRút rất cả khỏi kho");
        list.add("&8[&eShift + Chuột Trái&8] &aCất tất cả vào kho");
        list.add(" ");
        addlang("Gui.Lore",list);

        try {
            DataFile.save(locate);
            Main.sendlog("§e[Config] §2Load file config !");
        } catch (IOException e) {
            Main.sendlog("§e[Config] §4Fail to load file config !");
            e.printStackTrace();
        }

    }
    public static void save() {
        try {
            DataFile.save(locate);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static List<String> getarray(String s) {
        if(DataFile.contains(s)) {
            List<String> ss = new ArrayList<String>();
            for(String ok : DataFile.getStringList(s)) {
                ss.add(Color.tran(ok));
            }
            return ss;
        }
        return null;
    }
    public static int getint(String s) {
        if(DataFile.contains(s)) {
            return DataFile.getInt(s);
        }
        return 0;
    }
    public static double getdoubl(String s) {
        if(DataFile.contains(s)) {
            return DataFile.getDouble(s);
        }
        return 0;
    }
    public static boolean getb(String s) {
        if(DataFile.contains(s)) {
            return DataFile.getBoolean(s);
        }
        return false;
    }
    public static String getlang(String s) {
        if(DataFile.contains(s)) {
            return Color.tran(DataFile.getString(s));
        }
        return s;
    }

    public static String getlang_nocolor(String s) {
        if(DataFile.contains(s)) {
            return DataFile.getString(s);
        }
        return null;
    }

    public static void addlang(String s , double s2) {
        if(!DataFile.contains(s)) {
            DataFile.set(s, s2);
        }
    }
    public static void addlang(String s , Boolean s2) {
        if(!DataFile.contains(s)) {
            DataFile.set(s, s2);
        }
    }
    public static void reload(Player p) {
        try {
            Send.send("Plugin.Reload", p);
            DataFile.load(locate);
        } catch (IOException | InvalidConfigurationException e) {
            Send.send("Plugin.ReloadFail", p);
            e.printStackTrace();
        }
    }
    public static void addlang(String s , List<String> s2) {
        if(!DataFile.contains(s)) {
            DataFile.set(s, s2);
        }
    }
    public static void setforcelang(String s , String s2) {
        DataFile.set(s, s2);
    }
    public static void setforcelang(String s, double x) {
        DataFile.set(s, x);
    }
    public static void addlang(String s , String s2) {
        if(!DataFile.contains(s)) {
            DataFile.set(s, s2);
        }
    }
    public static void addlang(String s , int s2) {
        if(!DataFile.contains(s)) {
            DataFile.set(s, s2);
        }
    }


}
