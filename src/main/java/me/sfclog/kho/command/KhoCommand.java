package me.sfclog.kho.command;

import com.cryptomorin.xseries.XMaterial;
import me.sfclog.kho.gui.KhoGui;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class KhoCommand implements TabExecutor, CommandExecutor {

    @Override
    public boolean onCommand(CommandSender arg0, Command arg1, String arg2, String[] arg3) {
        if (arg0 instanceof Player) {
            Player p = (Player) arg0;

            if (arg3.length < 1) {
                KhoGui.open(p);
            } else if (arg3[0].equalsIgnoreCase("toggle")) {


            }


        }
        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender arg0, org.bukkit.command.Command arg1, String arg2, String[] arg3) {
        ArrayList<String> s = new ArrayList<String>();
        s.add("toggle");
        return s;
    }
}
