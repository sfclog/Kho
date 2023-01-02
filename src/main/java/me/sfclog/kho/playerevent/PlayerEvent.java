package me.sfclog.kho.playerevent;

import com.cryptomorin.xseries.XMaterial;
import me.sfclog.kho.config.PluginConfig;
import me.sfclog.kho.khomanage.KhoManage;
import me.sfclog.kho.playerdata.PlayerData;
import me.sfclog.kho.playerdata.PlayerDataLoad;
import me.sfclog.kho.playerdata.PlayerDataManage;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;

public class PlayerEvent implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        if(p != null) {
           PlayerDataLoad.load(p);
        }
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent e) {
        Player p = e.getPlayer();
        e.setDropItems(false);
        Block b = e.getBlock();
        if(b != null) {
            PlayerData data = PlayerDataManage.getData(p);
            if(data != null) {
                for(ItemStack drop : b.getDrops()) {
                    if(drop != null && drop.getType() != null) {
                        Material type = drop.getType();
                        if(type != null && KhoManage.isSupport(type)) {
                            int i = drop.getAmount();
                            p.spigot().sendMessage(ChatMessageType.ACTION_BAR,
                                    TextComponent.fromLegacyText(PluginConfig.getlang("Kho.Msg.ItemInPut")
                                            .replace("<amount>",String.valueOf(i))
                                            .replace("<name>",type.name())
                             ));
                            data.addM(XMaterial.valueOf(type.name()),i);
                        }
                    }
                }
            }
        }
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        Player p = e.getPlayer();
        if(p != null) {
            PlayerDataManage.remove(p);
        }
    }
}
