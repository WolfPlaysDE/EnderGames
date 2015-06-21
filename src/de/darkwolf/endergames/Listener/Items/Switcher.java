package de.darkwolf.endergames.Listener.Items;

import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import de.darkwolf.endergames.Main.EnderGames;

public class Switcher implements Listener {
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onSwitcher(EntityDamageByEntityEvent e){
		Snowball snow = (Snowball) e.getDamager();
		final Player shooter = (Player) snow.getShooter();
		final Player damaged = (Player) e.getEntity();
		if(e.getEntity() instanceof Player && e.getDamager() instanceof Snowball){
			Location shooterLoc = shooter.getLocation();
			Location damagedLoc = damaged.getLocation();
			shooter.teleport(damagedLoc);
			damaged.teleport(shooterLoc);
			
			shooter.sendMessage(EnderGames.getInstance().prefix + "§6Du wurdest mit§7§o " + damaged.getName() + " §6getauscht");
            shooter.playSound(shooter.getLocation(), Sound.ENDERMAN_TELEPORT, 10F, 10F);
            shooter.playEffect(shooter.getLocation(), Effect.ENDER_SIGNAL, 1);
			damaged.sendMessage(EnderGames.getInstance().prefix + "§6Du wurdest mit§7§o " + shooter.getName() + " §6getauscht");
            damaged.playSound(damaged.getLocation(), Sound.ENDERMAN_TELEPORT, 10F, 10F);
            damaged.playEffect(damaged.getLocation(), Effect.ENDER_SIGNAL, 1);
		}
	}

}
