package de.darkwolf.endergames.util;

import java.io.File;
import java.io.IOException;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import de.darkwolf.endergames.Main.EnderGames;

public class FileManager {
	
	// Config File
	public static File getConfigFile() {
		return new File(EnderGames.getInstance().getDataFolder(), "config.yml");
	}
	public static FileConfiguration getConfigFileConfiguration() {
		return YamlConfiguration.loadConfiguration(getConfigFile());
	}
	
	// MySQL File
	public static File getMySQLFile() {
		return new File(EnderGames.getInstance().getDataFolder(), "mysql.yml");
	}
	public static FileConfiguration getMySQLFileConfiguration() {
		return YamlConfiguration.loadConfiguration(getMySQLFile());
	}
	
	// Config File setup
	public static void setDefaultConfig() {
		FileConfiguration cfg = getConfigFileConfiguration();
		cfg.options().copyDefaults(true);
		cfg.addDefault("prefix", "&8[&5EnderGames&8]");
		cfg.addDefault("Unbekannter_Befehl", "§cUnbekannter Befehl!");
		cfg.addDefault("Keine_Permissions", "§cDu hast keine Berechtigung!");
		try {
			cfg.save(getConfigFile());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void readConfig() {
		FileConfiguration cfg = getConfigFileConfiguration();
		EnderGames.getInstance().prefix = ChatColor.translateAlternateColorCodes('&', cfg.getString("prefix") + "§r ");
		EnderGames.getInstance().unknow = ChatColor.translateAlternateColorCodes('&', cfg.getString("Unbekannter_Befehl") + "§r ");
		EnderGames.getInstance().noperm = ChatColor.translateAlternateColorCodes('&', cfg.getString("Keine_Permissions") + "§r ");
	}
	
	//MySQL File setup
	public static void setDefaultMySQL() {
		FileConfiguration cfg = getMySQLFileConfiguration();
		cfg.options().copyDefaults(true);
		cfg.addDefault("username", "root");
		cfg.addDefault("passwort", "");
		cfg.addDefault("host", "localhost");
		cfg.addDefault("port", "3306");
		cfg.addDefault("database",  "minecraft_endergames");
		try {
			cfg.save(getMySQLFile());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void readMySQL() {
		FileConfiguration cfg = getMySQLFileConfiguration();
		MySQL.username = cfg.getString("username");
		MySQL.passwort = cfg.getString("passwort");
		MySQL.host = cfg.getString("host");
		MySQL.port = cfg.getString("port");
		MySQL.database = cfg.getString("database");
	}
	
	// Setup all Configs
	public static void setupConfigs() {
		FileManager.setDefaultConfig();
		FileManager.readConfig();
		FileManager.setDefaultMySQL();
		FileManager.readMySQL();
	}
	
}
