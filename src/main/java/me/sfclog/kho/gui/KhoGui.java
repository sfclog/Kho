package me.sfclog.kho.gui;

import com.cryptomorin.xseries.XMaterial;
import me.sfclog.kho.Main;
import me.sfclog.kho.config.PluginConfig;
import me.sfclog.kho.khomanage.KhoItem;
import me.sfclog.kho.khomanage.KhoManage;
import me.sfclog.kho.playerdata.PlayerData;
import me.sfclog.kho.playerdata.PlayerDataManage;
import me.sfclog.kho.utils.Send;
import me.sfclog.kho.utils.Util;
import net.wesjd.anvilgui.AnvilGUI;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.*;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class KhoGui implements Listener {

    @EventHandler
    public void onClick(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();
        if(e.getInventory() != null && e.getInventory().getTitle() != null && e.getInventory().getTitle().contains(PluginConfig.getlang("Gui.Title").replace("<player_name>",p.getName()))) {

            int slot = e.getSlot();
            //close
            ItemStack item = e.getCurrentItem();
            if(item != null) {
                if(item.getItemMeta() != null && item.getItemMeta().getDisplayName() != null) {
                    if(item.getItemMeta().getDisplayName().equals(PluginConfig.getlang("Gui.QuitItem.Name"))){
                        p.closeInventory();
                    }
                }
            }
            //
            PlayerData data = PlayerDataManage.getData(p);
            if(data != null) {
                KhoItem khoi = KhoManage.getItemSlot(slot);
                if(khoi != null) {
                    if (e.getClick() == ClickType.LEFT) {

                        new AnvilGUI.Builder()
                                .onClose(player -> {
                                    open(p);
                                })
                                .onComplete((player, text) -> {
                                    if(text != null && !text.isEmpty()) {
                                        String number = stripNonDigits(text);
                                        int i =  number != null && !number.isEmpty() ? Integer.valueOf(number) : 0;
                                        if(!(i <= 0)) {

                                            int amount = data.getM(khoi.getXM());
                                            if(!(amount <= 0) && amount >= i) {
                                                Material m = khoi.getType().getType();
                                                if (m != null) {
                                                    Util.giveitem(p, m, i);
                                                    Send.send(p, PluginConfig.getlang("Kho.Msg.ItemOutPut")
                                                            .replace("<out_amount>", String.valueOf(i))
                                                            .replace("<out_name>", m.name())
                                                            .replace("<amount>", String.valueOf(amount - i))
                                                            .replace("<name>", m.name()));
                                                    data.takeM(khoi.getXM(), i);
                                                }
                                            } else {
                                                Send.send(p,PluginConfig.getlang("Kho.Msg.IsEmpty"));
                                                p.closeInventory();
                                            }

                                        }
                                    }

                                    return AnvilGUI.Response.close();
                                })
                                .text("128")
                                .itemLeft(new ItemStack(Material.PAPER))
                                .interactableSlots(AnvilGUI.Slot.INPUT_RIGHT)
                                .plugin(Main.pl)
                                .open(p);
                    }

                    if (e.getClick() == ClickType.RIGHT) {

                        int amount = data.getM(khoi.getXM());
                        if(!(amount <= 0)) {
                            Material m = khoi.getType().getType();
                            if(m != null) {
                                Util.giveitem(p, m , amount);
                                Send.send(p, PluginConfig.getlang("Kho.Msg.ItemOutPutAll")
                                        .replace("<amount>", String.valueOf(amount))
                                        .replace("<name>", m.name()));

                                data.setM(khoi.getXM(), 0);
                            }
                         } else {
                            Send.send(p,PluginConfig.getlang("Kho.Msg.IsEmpty"));
                            p.closeInventory();
                        }
                    }

                    if (e.getClick() == ClickType.SHIFT_LEFT) {
                        Material m = khoi.getType().getType();
                        if(m != null) {
                            int i = getAll(p,m);
                            if(!(i <= 0)) {

                                int amount = data.getM(khoi.getXM());
                                Util.removeItems(p,m,i);
                                Send.send(p, PluginConfig.getlang("Kho.Msg.ItemInPutAll")
                                        .replace("<out_amount>", String.valueOf(i))
                                        .replace("<out_name>", m.name())
                                        .replace("<amount>", String.valueOf(amount + i))
                                        .replace("<name>", m.name()));
                                data.addM(khoi.getXM(),i);
                            } else {
                                Send.send(p,PluginConfig.getlang("Kho.Msg.IsEmptyIn"));
                            }

                        }

                    }

                }

            }


            e.setCancelled(true);



        }
    }

    public static int getAll(Player p, Material m) {
        int amount = 0;
        for (int i = 0; i < 36; i++) {
            ItemStack slot = p.getInventory().getItem(i);
            if (slot == null || !slot.isSimilar(new ItemStack(m)))
                continue;
            amount += slot.getAmount();
        }
        return amount;
    }


    public static String stripNonDigits(
            final CharSequence input /* inspired by seh's comment */){
        final StringBuilder sb = new StringBuilder(
                input.length() /* also inspired by seh's comment */);
        for(int i = 0; i < input.length(); i++){
            final char c = input.charAt(i);
            if(c > 47 && c < 58){
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static void open(Player p) {

        PlayerData data = PlayerDataManage.getData(p);
        if(data != null) {
            Inventory inv = Bukkit.createInventory(null, PluginConfig.getint("Gui.Size"), PluginConfig.getlang("Gui.Title").replace("<player_name>", p.getName()));
            //draw item

            for (KhoItem item : KhoManage.getAllItem()) {
                if (item != null) {
                    ItemStack it = item.getType();
                    ItemMeta meta = it.getItemMeta();
                    meta.setDisplayName(item.getName());


                    List<String> lore = PluginConfig.getarray("Gui.Lore");

                    lore.replaceAll(a ->
                            a.replace("<amount>",String.valueOf(data.getM(item.getXM())))
                            .replace("<maxamount>",PluginConfig.getlang("Kho.MaxAmount"))
                    );
                    meta.setLore(lore);

                    meta.addEnchant(Enchantment.DURABILITY,1,true);
                    meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);

                    it.setItemMeta(meta);
                    inv.setItem(item.getSlot(), it);
                }
            }

            ItemStack quit = XMaterial.valueOf(PluginConfig.getlang("Gui.QuitItem.Material")).parseItem();
            ItemMeta meta = quit.getItemMeta();
            meta.setDisplayName(PluginConfig.getlang("Gui.QuitItem.Name"));
            meta.setLore(PluginConfig.getarray("Gui.QuitItem.Lore"));
            meta.addEnchant(Enchantment.DURABILITY,1,true);
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            quit.setItemMeta(meta);
            inv.setItem(PluginConfig.getint("Gui.QuitItem.Slot"),quit);


            p.openInventory(inv);

        } else {
          Send.send(p,PluginConfig.getlang("Kho.Msg.FailLoadData"));
        }
    }
}
