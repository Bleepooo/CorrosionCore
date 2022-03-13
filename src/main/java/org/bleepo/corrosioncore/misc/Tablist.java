package org.bleepo.corrosioncore.misc;

import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bleepo.corrosioncore.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;

import static org.bleepo.corrosioncore.utils.ConfigManager.config;

public class Tablist extends BukkitRunnable {
    @Override
    public void run() {
        if (Bukkit.getOnlinePlayers().size() > 0) {
            Bukkit.getOnlinePlayers().forEach(player -> {
                String header = String.join("\n", config.getStringList("Tablist.Header"));
                String footer = String.join("\n", config.getStringList("Tablist.Footer"));
                BaseComponent h = new TextComponent(Utils.formatTab(player, header));
                BaseComponent f = new TextComponent(Utils.formatTab(player, footer));
                player.setPlayerListHeaderFooter(h, f);
            });
        }
    }
}
