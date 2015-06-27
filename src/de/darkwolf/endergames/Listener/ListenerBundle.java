package de.darkwolf.endergames.Listener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;

public class ListenerBundle {

	private static Map<String, ListenerBundle> bundles;
	
	static {
		bundles = new HashMap<String, ListenerBundle>();
	}
	
	public static void register(Plugin plugin, String name, ListenerBundle bundle) {
		bundles.put(name, bundle);
		for (Listener l : bundle.listeners) {
			Bukkit.getPluginManager().registerEvents(l, plugin);
		}
	}
	
	public static void unregister(String name) {
		if (bundles.containsKey(name)) {
			ListenerBundle bundle = bundles.get(name);
			for (Listener l : bundle.listeners) {
				HandlerList.unregisterAll(l);
			}
			bundles.remove(name);
		}
	}
	
	public static boolean isRegistered(String name) {
		return bundles.containsKey(name);
	}
	
	
	// -------------------------------- //
	// ----- Object-oriented part ----- //
	// -------------------------------- //
	
	private List<Listener> listeners;
	
	public ListenerBundle() {
		this.listeners = new ArrayList<Listener>();
	}
	
	public void add(Listener l) {
		this.listeners.add(l);
	}
	
}
