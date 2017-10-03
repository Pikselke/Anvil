package pl.pikselke.anvil.listeners;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import pl.pikselke.anvil.inv.Inventory;

public class PlayerInteractListener implements Listener {

	
	@EventHandler
	public void onInteract(PlayerInteractEvent e){
		Player p = e.getPlayer();
		if(e.getAction() == Action.RIGHT_CLICK_BLOCK){
			if(e.getClickedBlock().getType() == Material.ANVIL){
				e.setCancelled(true);
				Inventory.openInv(p);
			}
		}
	}
}
