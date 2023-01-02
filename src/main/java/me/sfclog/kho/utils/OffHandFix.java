package me.sfclog.kho.utils;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class OffHandFix {

	
	public static void clear_off_hand(Player p,Material m) {
	      ItemStack itm = p.getInventory().getItemInOffHand();
	      if(itm != null && Util.check_custome_item(itm) && itm.getType() == m) {
	    	  p.getInventory().setItemInOffHand(null);
	    	  Util.giveitem(p, itm.getType(), itm.getAmount());
	    	  p.updateInventory();
	      }
	}
}
