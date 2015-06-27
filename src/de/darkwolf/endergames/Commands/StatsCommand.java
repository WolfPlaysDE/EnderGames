package de.darkwolf.endergames.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.darkwolf.endergames.Main.EnderGames;
import de.darkwolf.endergames.util.MySQLEnderGamesManager;
import de.darkwolf.endergames.util.UUIDFetcher;

public class StatsCommand implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage("§cDu darfst diesen Befehl nur Ingame nutzen!");
			return true;
		}
		Player p = (Player) sender;
		
		
		// Stats for yourself
		if (args.length == 0) {
			p.sendMessage("§8[]=====[ §5EnderGames §8┃ §6Stats §8]=====[]");
			p.sendMessage("§5Name: §c" + p.getName());
			p.sendMessage("§5Kills: §c" + MySQLEnderGamesManager.getPlayerKills(p));
			p.sendMessage("§5Tode: §c" + MySQLEnderGamesManager.getPlayerDeaths(p));
			p.sendMessage("§5Punkte: §c" + MySQLEnderGamesManager.getPlayerPoints(p));
			p.sendMessage("§5Gewonnene Spiele: §c" + MySQLEnderGamesManager.getPlayerWins(p));
			p.sendMessage("§5Verlorene Spiele: §c" + (MySQLEnderGamesManager.getPlayerPlayedGames(p) - MySQLEnderGamesManager.getPlayerWins(p)));
			p.sendMessage("§5Gespielte Spiele: §c" + MySQLEnderGamesManager.getPlayerPlayedGames(p));
			p.sendMessage("§8[]=====[ §5EnderGames §8┃ §6Stats §8]=====[]");
			return true;
		}
		
		
		// Stats for another player
		if (args.length == 1) {
			String name = args[1];
			Player pp = null;
			try {
				pp = (Player) Bukkit.getOfflinePlayer(UUIDFetcher.getUUIDOf(name));
			} catch (Exception e) {
				e.printStackTrace();
			}
			p.sendMessage("§8[]=====[ §5EnderGames §8┃ §6Stats §8]=====[]");
			p.sendMessage("§5Name: §c" + name);
			p.sendMessage("§5Kills: §c" + MySQLEnderGamesManager.getPlayerKills(pp));
			p.sendMessage("§5Tode: §c" + MySQLEnderGamesManager.getPlayerDeaths(pp));
			p.sendMessage("§5Punkte: §c" + MySQLEnderGamesManager.getPlayerPoints(pp));
			p.sendMessage("§5Gewonnene Spiele: §c" + MySQLEnderGamesManager.getPlayerWins(pp));
			p.sendMessage("§5Verlorene Spiele: §c" + (MySQLEnderGamesManager.getPlayerPlayedGames(pp) - MySQLEnderGamesManager.getPlayerWins(pp)));
			p.sendMessage("§5Gespielte Spiele: §c" + MySQLEnderGamesManager.getPlayerPlayedGames(pp));
			p.sendMessage("§8[]=====[ §5EnderGames §8┃ §6Stats §8]=====[]");
			return true;
		}

		
		// Unknown
		p.sendMessage(EnderGames.getInstance().prefix + EnderGames.getInstance().unknow);

		return true;
	}
	
	

}
