package de.darkwolf.endergames.Main;

import java.util.HashMap;

import org.bukkit.Location;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import de.darkwolf.endergames.Commands.HelpCommand;
import de.darkwolf.endergames.Commands.StatsCommand;
import de.darkwolf.endergames.Listener.ChestListener;
import de.darkwolf.endergames.Listener.Items.Switcher;
import de.darkwolf.endergames.util.FileManager;
import de.darkwolf.endergames.util.MySQL;

public class EnderGames extends JavaPlugin {
	
	public String prefix;
	public String unknow;
	public String noperm;
	static EnderGames instance;
	
	public HashMap<Location, Inventory> chests = new HashMap<Location, Inventory>();
	
	@Override
	public void onLoad() {
		instance = this;
	}

	@Override
	public void onEnable() {
		FileManager.setupConfigs();
		MySQL.connect();
		this.getServer().getConsoleSender().sendMessage(prefix + "Plugin Coded by DarkWolf!");
		this.getServer().getConsoleSender().sendMessage(prefix + "Config Datei: " + (FileManager.getConfigFile().exists() ? "§2erfolgreich geladen!" : "§4nicht gefunden!"));
		this.getServer().getConsoleSender().sendMessage(prefix + "MySQL Datei: " + (FileManager.getMySQLFile().exists() ? "§2erfolgreich geladen!" : "§4nicht gefunden!"));
		this.getServer().getConsoleSender().sendMessage(prefix + " MySQL Verbindungsaufgebau: " + (MySQL.con == null ? "§4ist fehlgeschlagen!" : "§2war erfolgreich!"));
		if (MySQL.con == null) {
	      Plugin plugin = getServer().getPluginManager().getPlugin("EnderGames");
	      getServer().getPluginManager().disablePlugin(plugin);
	      this.getServer().getConsoleSender().sendMessage(prefix + " §4§lDAS PLUGIN WURDE DEAKTIVIRT, WEIL DIE MYSQL VERBINDUNG FEHLGESCHLAGEN IST!");
	    }
		registerListener();
		registerCommands();
	}
	
	@Override
	public void onDisable() {
		MySQL.diconnect();
	}
	
	private void registerListener() {
		//Listener
		getServer().getPluginManager().registerEvents(new ChestListener(this), this);
		
		//Listener Items
		getServer().getPluginManager().registerEvents(new Switcher(), this);
	}
	
	private void registerCommands() {
		getCommand("stats").setExecutor(new StatsCommand());
		getCommand("help").setExecutor(new HelpCommand());
		getCommand("?").setExecutor(new HelpCommand());
	}

	public static EnderGames getInstance() {
		return instance;
	}
	
}
