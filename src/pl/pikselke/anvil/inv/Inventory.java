package pl.pikselke.anvil.inv;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.InventoryView;

import pl.pikselke.anvil.Main;
import pl.pikselke.anvil.utils.ItemStackUtil;
import pl.pikselke.anvil.utils.Util;

public class Inventory {

	
	public static InventoryView openInv(Player p){
		org.bukkit.inventory.Inventory inv = Bukkit.createInventory(null, 9, Util.fixColor(Main.getInst().getConfig().getString("INVENTORY_NAME")));
		inv.setItem(0, ItemStackUtil.getIs2());
		inv.setItem(1, ItemStackUtil.getIs2());	
		inv.setItem(2, ItemStackUtil.getIs2());
		inv.setItem(3, ItemStackUtil.getIs());
		inv.setItem(4, ItemStackUtil.getIs2());
		inv.setItem(5, ItemStackUtil.getIs1());
		inv.setItem(6, ItemStackUtil.getIs2());
		inv.setItem(7, ItemStackUtil.getIs2());
		inv.setItem(8, ItemStackUtil.getIs2());
		return p.openInventory(inv);
	}
}
