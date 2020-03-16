package org.jacob.spigot.plugins.VenomCore.listeners;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.jacob.spigot.plugins.VenomCore.VenomCore;

public class PlayerJoinQuitListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {

        Player p = e.getPlayer();
        FileConfiguration data = VenomCore.getInstance().getPlayerData();

        if(!data.contains("players." + p.getUniqueId().toString())) {
            data.set("players." + p.getUniqueId().toString() + ".name", p.getName());
            data.set("players." + p.getUniqueId().toString() + ".operator", p.isOp());
            VenomCore.getInstance().savePlayerData();

        }
    }
}
