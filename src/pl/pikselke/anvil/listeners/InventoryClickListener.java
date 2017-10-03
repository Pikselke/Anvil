package pl.pikselke.anvil.listeners;

import org.bukkit.event.Listener;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.InventoryClickEvent;

import net.md_5.bungee.api.ChatColor;
import pl.pikselke.anvil.Main;
import pl.pikselke.anvil.utils.Util;

public class InventoryClickListener implements Listener {
	
	@EventHandler
	public void onClick(InventoryClickEvent e){
		Player p = (Player) e.getWhoClicked();
		if(e.getInventory() == null){
			return;
		}
		if(e.getCurrentItem() == null){
			return;
		}
		if(e.getCurrentItem().getType().equals(Material.AIR)){
			return;
		}
		if(!e.getCurrentItem().hasItemMeta()){
			return;
		}
		if(e.getInventory().getTitle().equals(Util.fixColor(Main.getInst().getConfig().getString("INVENTORY_NAME")))){
			e.setCancelled(true);
		}
		if(e.getCurrentItem().getType() == Material.getMaterial(Main.getInst().getConfig().getInt("ITEMSTACK_1_ID"))){
			if(p.hasPermission("pikselke.anvil.repair")){
				Util.repair(p);
				p.sendMessage(Util.fixColor(Main.getInst().getConfig().getString("MESSAGE_REPAIR")));
			}else{
				p.sendMessage(Util.fixColor(Main.getInst().getConfig().getString("MESSAGE_NOPERM_REPAIR")));
			}
		}
		if(e.getCurrentItem().getType() == Material.getMaterial(Main.getInst().getConfig().getInt("ITEMSTACK_2_ID"))){
			if(p.hasPermission("pikselke.anvil.repairall")){
				Util.repairAll(p);
				p.sendMessage(Util.fixColor(Main.getInst().getConfig().getString("MESSAGE_REPAIR_ALL")));
			}else{
				p.sendMessage(Util.fixColor(Main.getInst().getConfig().getString("MESSAGE_NOPERM_REPAIR_ALL")));
			}
		}
	}

}
