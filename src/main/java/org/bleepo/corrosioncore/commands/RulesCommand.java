package org.bleepo.corrosioncore.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static org.bleepo.corrosioncore.utils.ConfigManager.plugin;

public class RulesCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("rules")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7-----------------------"));
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&b1. No Niggers"));
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7-----------------------"));
            } else {
                plugin.getLogger().warning("Error: Sender not instanceof Player!");
            }
        }
        return true;
    }
}
