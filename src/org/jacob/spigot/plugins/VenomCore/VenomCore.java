package org.jacob.spigot.plugins.VenomCore;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;

public class VenomCore extends JavaPlugin {

    private static VenomCore instance;

    public static VenomCore getInstance() {
        return instance;
    }

    private File playerDataFile;
    private FileConfiguration playerData;

    @Override
    public void onEnable() {

        instance = this;

        getConfig().options().copyDefaults(true);
        saveConfig();

        Registry.registerCommands();
        Registry.registerListeners();

        createPlayerData();

    }

    private void createPlayerData() {
        playerDataFile = new File(getDataFolder(), "data.yml");
        if (!playerDataFile.exists()) {
            playerDataFile.getParentFile().mkdirs();
            saveResource("data.yml", false);
        }

        playerData = new YamlConfiguration();
        try {
            playerData.load(playerDataFile);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }

    }

    public FileConfiguration getPlayerData() {
        return this.playerData;
    }

    public void savePlayerData() {
        try {
            playerData.save(playerDataFile);
        } catch (Exception e) {
            e.printStackTrace();

        }
    }
}
