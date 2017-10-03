package pl.pikselke.anvil.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import net.md_5.bungee.api.ChatColor;

public class Util {

    public static void repair(Player p) {
    	ItemStack item = p.getInventory().getItemInHand();
    	if(item == null || item.getType().isBlock() || item.getDurability() == 0){
    		return;
    	}
    	String name = item.getType().toString().toLowerCase(Locale.ENGLISH);
    	repairItem(p, item);
    	p.updateInventory();
    }
    
    public static void repairItem(Player p, ItemStack item){
    	Material material = Material.getMaterial(item.getTypeId());
    	if(material.isBlock() || material.getMaxDurability() < 1){
    		return;
    	}
    	if(item.getDurability() == 0){
    		return;
    	}
    	item.setDurability((short)0);
    }
    
    public static void repairItems(Player p, ItemStack[] items, List<String> repaired){
    	for(ItemStack item : items){
    		if(item == null || item.getType().isBlock() || item.getDurability() == 0){
    			continue;
    		}
    		String name = item.getType().toString().toLowerCase(Locale.ENGLISH);
    		try{
    			repairItem(p, item);
    		}catch(Exception e){
    			continue;
    		}
    		repaired.add(name.replace('_', ' '));
    	}
    }
    
    public static void repairAll(Player p){
    	List<String> repaired = new ArrayList<String>();
    	repairItems(p, p.getInventory().getContents(), repaired);
    	repairItems(p, p.getInventory().getArmorContents(), repaired);
    	p.updateInventory();
    }
    
    
    public static String fixColor(String msg){
    	return ChatColor.translateAlternateColorCodes('&', msg);
    }
}
