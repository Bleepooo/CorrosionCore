package org.bleepo.corrosioncore.utils;

import org.bleepo.corrosioncore.CorrosionCore;
import org.bukkit.configuration.file.FileConfiguration;

public interface ConfigManager {
    CorrosionCore plugin = CorrosionCore.getPlugin();
    FileConfiguration config = plugin.getConfig();
}
