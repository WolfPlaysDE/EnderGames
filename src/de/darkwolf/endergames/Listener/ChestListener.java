package de.darkwolf.endergames.Listener;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import de.darkwolf.endergames.Main.EnderGames;

public class ChestListener implements Listener{

	private EnderGames plugin;
	private List<ItemStack> items;

	public ChestListener(EnderGames EnderGames) {
		this.plugin = EnderGames;
		this.items = new ArrayList<ItemStack>();
		setChestItems();
	}
	
	@EventHandler
	public void onChestInteract(PlayerInteractEvent e) {
		
		Player p = e.getPlayer();
		if(e.getAction() == Action.RIGHT_CLICK_BLOCK) {
			if(e.getClickedBlock().getType() == Material.ENDER_CHEST) {
				
				if(plugin.chests.containsKey(e.getClickedBlock().getLocation())) {
					p.openInventory(plugin.chests.get(e.getClickedBlock().getLocation()));
					return;
				}
				
				Inventory inv = Bukkit.createInventory(null, 27, "§8Chest");
				
				Random rnd = new Random();
				
				int itemCount = rnd.nextInt(5) + 2;
				
				while(itemCount > 0) {
					itemCount--;
					ItemStack item = items.get(rnd.nextInt(items.size()));
					int slot = rnd.nextInt(27);
					inv.setItem(slot, item);
				}
				plugin.chests.put(e.getClickedBlock().getLocation(), inv);
				p.openInventory(inv);
				
				return;
			}
		}
		
	}
	
	private void setChestItems() {
		items.add(new ItemStack(Material.WOOD_SWORD));
		items.add(new ItemStack(Material.WOOD_SWORD));
		items.add(new ItemStack(Material.WOOD_SWORD));
		items.add(new ItemStack(Material.WOOD_SWORD));
		items.add(new ItemStack(Material.GOLD_SWORD));
		items.add(new ItemStack(Material.GOLD_SWORD));
		items.add(new ItemStack(Material.GOLD_SWORD));
		items.add(new ItemStack(Material.STONE_SWORD));
		items.add(new ItemStack(Material.STONE_SWORD));
		items.add(new ItemStack(Material.IRON_SWORD));
		items.add(new ItemStack(Material.BOW));
		items.add(new ItemStack(Material.BOW));
		items.add(new ItemStack(Material.BOW));
		items.add(new ItemStack(Material.ARROW, 3));
		items.add(new ItemStack(Material.ARROW, 2));
		items.add(new ItemStack(Material.ARROW));
		items.add(new ItemStack(Material.FISHING_ROD));
		items.add(new ItemStack(Material.FISHING_ROD));
		items.add(new ItemStack(Material.FISHING_ROD));
		items.add(new ItemStack(Material.APPLE, 3));
		items.add(new ItemStack(Material.APPLE, 2));
		items.add(new ItemStack(Material.APPLE));
		items.add(new ItemStack(Material.COOKED_BEEF, 2));
		items.add(new ItemStack(Material.COOKED_BEEF));
		items.add(new ItemStack(Material.RAW_BEEF, 4));
		items.add(new ItemStack(Material.RAW_BEEF, 3));
		items.add(new ItemStack(Material.RAW_BEEF, 2));
		items.add(new ItemStack(Material.RAW_BEEF));
		items.add(new ItemStack(Material.RAW_CHICKEN, 4)); 
		items.add(new ItemStack(Material.RAW_CHICKEN, 3));
		items.add(new ItemStack(Material.RAW_CHICKEN, 2));
		items.add(new ItemStack(Material.RAW_CHICKEN));
		items.add(new ItemStack(Material.LEATHER_BOOTS));
		items.add(new ItemStack(Material.LEATHER_BOOTS));
		items.add(new ItemStack(Material.LEATHER_BOOTS));
		items.add(new ItemStack(Material.LEATHER_BOOTS));
		items.add(new ItemStack(Material.LEATHER_LEGGINGS));
		items.add(new ItemStack(Material.LEATHER_LEGGINGS));
		items.add(new ItemStack(Material.LEATHER_LEGGINGS));
		items.add(new ItemStack(Material.LEATHER_LEGGINGS));
		items.add(new ItemStack(Material.LEATHER_CHESTPLATE));
		items.add(new ItemStack(Material.LEATHER_CHESTPLATE));
		items.add(new ItemStack(Material.LEATHER_CHESTPLATE));
		items.add(new ItemStack(Material.LEATHER_CHESTPLATE));
		items.add(new ItemStack(Material.LEATHER_HELMET));
		items.add(new ItemStack(Material.LEATHER_HELMET));
		items.add(new ItemStack(Material.LEATHER_HELMET));
		items.add(new ItemStack(Material.LEATHER_HELMET));
		items.add(new ItemStack(Material.GOLD_HELMET));
		items.add(new ItemStack(Material.GOLD_HELMET));
		items.add(new ItemStack(Material.GOLD_HELMET));
		items.add(new ItemStack(Material.GOLD_CHESTPLATE));
		items.add(new ItemStack(Material.GOLD_CHESTPLATE));
		items.add(new ItemStack(Material.GOLD_CHESTPLATE));
		items.add(new ItemStack(Material.GOLD_BOOTS));
		items.add(new ItemStack(Material.GOLD_BOOTS));
		items.add(new ItemStack(Material.GOLD_BOOTS));
		items.add(new ItemStack(Material.IRON_HELMET));
		items.add(new ItemStack(Material.IRON_HELMET));
		items.add(new ItemStack(Material.IRON_CHESTPLATE));
		items.add(new ItemStack(Material.IRON_CHESTPLATE));
		items.add(new ItemStack(Material.IRON_LEGGINGS));
		items.add(new ItemStack(Material.IRON_LEGGINGS));
		items.add(new ItemStack(Material.IRON_BOOTS));
		items.add(new ItemStack(Material.IRON_BOOTS));
		items.add(new ItemStack(Material.IRON_INGOT));
		items.add(new ItemStack(Material.DIAMOND));
	}
	
}
