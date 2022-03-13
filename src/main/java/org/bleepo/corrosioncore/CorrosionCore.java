package org.bleepo.corrosioncore;

import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bleepo.corrosioncore.listeners.JoinMessages;
import org.bleepo.corrosioncore.misc.Tablist;
import org.bleepo.corrosioncore.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import static org.bleepo.corrosioncore.utils.ConfigManager.config;
import static org.bleepo.corrosioncore.utils.ConfigManager.plugin;

public final class CorrosionCore extends JavaPlugin {
    public static Long timeEnabled;
    public BukkitRunnable main;

    public static CorrosionCore getPlugin() {
        return getPlugin(CorrosionCore.class);
    }

    @Override
    public void onEnable() {
        timeEnabled = System.currentTimeMillis();
        saveDefaultConfig();
        getServer().getPluginManager().registerEvents(new JoinMessages(), this);
        // BukkitRunnable.runTaskTimer(this, 0L, 20L);
        main = new BukkitRunnable() {
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
        };

        main.runTaskTimer(this, 0L, 20L);

        // Register Listener
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
