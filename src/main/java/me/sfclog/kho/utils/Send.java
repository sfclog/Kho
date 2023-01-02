package me.sfclog.kho.utils;


import me.sfclog.kho.config.PluginConfig;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

public class Send {

	public static void send(String s , Player p) {
		p.sendMessage(PluginConfig.getlang("Plugin.Prefix") + PluginConfig.getlang(s));
	}
	public static void send(Player p,String s) {
		p.sendMessage(PluginConfig.getlang("Plugin.Prefix") + Color.tran(s));
	}
	public static void send(String s , Player p,Sound so) {
		p.sendMessage(PluginConfig.getlang("Plugin.Prefix") + PluginConfig.getlang(s));
		p.playSound(p.getLocation(), so, 50, 1);

	}
	public static void send_noprefix(String s , Player p) {
		p.sendMessage(PluginConfig.getlang(s));
	}
	@SuppressWarnings("deprecation")
	public static void sendtitle(String title , String subtitle,Player p) {
		p.sendTitle(title, subtitle);
	}
}
