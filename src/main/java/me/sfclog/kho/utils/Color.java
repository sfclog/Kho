package me.sfclog.kho.utils;

import net.md_5.bungee.api.ChatColor;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Color {
    private static final Pattern pattern = Pattern.compile("#[a-fA-F0-9]{6}");
    public static String tran(String msg) {
        if(msg != null) {
            return ChatColor.translateAlternateColorCodes('&', msg);
        }
        return ChatColor.RED + msg;
    }
}
