package de.darkwolf.endergames.util;

import org.bukkit.Bukkit;
import org.bukkit.Location;

public class LocationCoverter {

	/**
	 * Covert a String to a Location
	 * @param str
	 * @return Location
	 */
	public Location stringToLocation(String str) {
		String locString[] = str.split("\\:");
		Location loc = new Location(Bukkit.getWorld(locString[0]), 0, 0, 0);
		loc.setX(Double.parseDouble(locString[1]));
		loc.setY(Double.parseDouble(locString[2]));
		loc.setZ(Double.parseDouble(locString[3]));
		return loc;
	}

	/**
	 * Covert a Location to a String
	 * @param loc
	 * @return String
	 */
	public String locationToString(Location loc) {
		return loc.getWorld().getName() + ":" + loc.getBlockX() + ":"
				+ loc.getBlockY() + ":" + loc.getBlockZ();
	}

}
