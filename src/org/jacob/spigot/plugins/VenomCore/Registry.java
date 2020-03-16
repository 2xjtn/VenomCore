package org.jacob.spigot.plugins.VenomCore;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.jacob.spigot.plugins.VenomCore.commands.PunishCommand;
import org.jacob.spigot.plugins.VenomCore.listeners.PlayerJoinQuitListener;
import org.jacob.spigot.plugins.VenomCore.listeners.PlayerPunishmentReasonChatEvent;
import org.jacob.spigot.plugins.VenomCore.listeners.PunishInventoryClickListener;

public class Registry {

    public static void registerCommands() {
        VenomCore.getInstance().getCommand("punish").setExecutor(new PunishCommand());
    }

    public static void registerListeners() {
        PluginManager pm = Bukkit.getPluginManager();

        pm.registerEvents(new PlayerJoinQuitListener(), VenomCore.getInstance());
        pm.registerEvents(new PunishInventoryClickListener(), VenomCore.getInstance());
        pm.registerEvents(new PlayerPunishmentReasonChatEvent(), VenomCore.getInstance());
    }
}
