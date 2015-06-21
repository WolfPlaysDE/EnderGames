package de.darkwolf.endergames.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.darkwolf.endergames.Main.EnderGames;

public class HelpCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(!(sender instanceof Player)) {
			sender.sendMessage("§cDu darfst diesen Befehl nur Ingame nutzen!");
			return true;
		}
		
		Player p = (Player) sender;
		
		if(args.length == 0) {
			p.sendMessage("§8[]=====[ §5EnderGames §8┃ §6Hilfe §8]=====[]");
			p.sendMessage("§5Hilfe: §c/help");
			p.sendMessage("§5Stats: §c/stats <Name>");
			p.sendMessage("§8[]=====[ §5EnderGames §8┃ §6Hilfe §8]=====[]");
		} else if(args.length >= 1) {
			p.sendMessage("§8[]=====[ §5EnderGames §8┃ §6Hilfe §8]=====[]");
			p.sendMessage("§5Hilfe: §c/help");
			p.sendMessage("§5Stats: §c/stats <Name>");
			p.sendMessage("§8[]=====[ §5EnderGames §8┃ §6Hilfe §8]=====[]");
		} else {
			p.sendMessage(EnderGames.getInstance().prefix + EnderGames.getInstance().unknow);
		}
		
		return true;
	}

}
