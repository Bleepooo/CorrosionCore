package org.bleepo.corrosioncore;

import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bleepo.corrosioncore.commands.RulesCommand;
import org.bleepo.corrosioncore.listeners.JoinMessages;
import org.bleepo.corrosioncore.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import static org.bleepo.corrosioncore.utils.ConfigManager.config;

public final class CorrosionCore extends JavaPlugin {
    public static Long timeEnabled;
    public BukkitRunnable nigger;

    public static CorrosionCore getPlugin() {
        return getPlugin(CorrosionCore.class);
    }

    @Override
    public void onEnable() {
        timeEnabled = System.currentTimeMillis();
        saveDefaultConfig();

        //load shit
        getServer().getPluginManager().registerEvents(new JoinMessages(), this);
        this.getCommand("rules").setExecutor(new RulesCommand());

        // Don't ask why I do this in the main class im a lazy asf
        nigger = new BukkitRunnable() {
            public void run() {
                if (Bukkit.getOnlinePlayers().size() > 0) {
                    Bukkit.getOnlinePlayers().forEach(player -> {
                        String penis = String.join("\n", config.getStringList("Tablist.Header"));
                        String cum = String.join("\n", config.getStringList("Tablist.Footer"));
                        BaseComponent h = new TextComponent(Utils.formatTab(player, penis));
                        BaseComponent f = new TextComponent(Utils.formatTab(player, cum));
                        player.setPlayerListHeaderFooter(h, f);
                    });
                }
            }
        };

        nigger.runTaskTimer(this, 0L, 20L);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
