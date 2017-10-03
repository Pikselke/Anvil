package pl.pikselke.anvil;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import pl.pikselke.anvil.listeners.InventoryClickListener;
import pl.pikselke.anvil.listeners.PlayerInteractListener;

public class Main extends JavaPlugin implements Listener{
	
	public static Main inst;
	
	public void onEnable(){
		inst = this;
		Bukkit.getPluginManager().registerEvents(new InventoryClickListener(), this);
		Bukkit.getPluginManager().registerEvents(new PlayerInteractListener(), this);
		Bukkit.getLogger().info("Plugin: AnvilRepair, zostal zaladowany pomyslnie!");
		inst.saveDefaultConfig();
	}

	public void onDisable(){
		Bukkit.getLogger().info("Plugin: AnvilRepair, zostal wylaczony pomyslnie!");
	}
	
	public static Main getInst(){
		return inst;
	}
	
}
