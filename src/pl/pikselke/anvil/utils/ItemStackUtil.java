package pl.pikselke.anvil.utils;

import java.util.List;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import net.md_5.bungee.api.ChatColor;
import pl.pikselke.anvil.Main;

public class ItemStackUtil {

	
	public static ItemStack getIs(){
		ItemStack is = new ItemStack(Material.getMaterial(Main.getInst().getConfig().getInt("ITEMSTACK_1_ID")));
		ItemMeta im = is.getItemMeta();
		im.setDisplayName(Util.fixColor(Main.getInst().getConfig().getString("ITEMSTACK_1_NAME")));
		List<String> lore = Main.getInst().getConfig().getStringList("ITEMSTACK_1_LORE");
		im.setLore(lore);
		is.setItemMeta(im);
		return is;
	}
	
	public static ItemStack getIs1(){
		ItemStack is = new ItemStack(Material.getMaterial(Main.getInst().getConfig().getInt("ITEMSTACK_2_ID")));
		ItemMeta im = is.getItemMeta();
		im.setDisplayName(Util.fixColor(Main.getInst().getConfig().getString("ITEMSTACK_2_NAME")));
		List<String> lore = Main.getInst().getConfig().getStringList("ITEMSTACK_2_LORE");
		im.setLore(lore);
		is.setItemMeta(im);
		return is;
	}
	
	public static ItemStack getIs2(){
		ItemStack is = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 1);
		ItemMeta im = is.getItemMeta();
		im.setDisplayName(" ");
		is.setItemMeta(im);
		return is;
	}
}
