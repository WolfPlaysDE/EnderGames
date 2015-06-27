package de.darkwolf.endergames.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HelpCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(!(sender instanceof Player)) {
			sender.sendMessage("§cDu darfst diesen Befehl nur Ingame nutzen!");
			return true;
		}
		
		Player p = (Player) sender;
		
		this.sendHelp(p);
		
		return true;
	}
	
	private void sendHelp(CommandSender sender) {
		sender.sendMessage("§8[]=====[ §5EnderGames §8┃ §6Hilfe §8]=====[]");
		sender.sendMessage("§5Hilfe: §c/help");
		sender.sendMessage("§5Stats: §c/stats <Name>");
		sender.sendMessage("§8[]=====[ §5EnderGames §8┃ §6Hilfe §8]=====[]");
	}

}
