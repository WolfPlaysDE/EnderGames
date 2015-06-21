package de.darkwolf.endergames.Items;

import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import de.darkwolf.endergames.Main.EnderGames;

public class KitChooseItem {
	
	public KitChooseItem(Player p) {
		Inventory inv = EnderGames.getInstance().getServer().createInventory(null, 9*3, "§5Kit-Auswahl");
		
		
		
		p.openInventory(inv);	
	}
	
}
