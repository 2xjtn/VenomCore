package org.jacob.spigot.plugins.VenomCore.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.jacob.spigot.plugins.VenomCore.commands.PunishCommand;
import org.jacob.spigot.plugins.VenomCore.utils.PunishmentAPI;

public class PlayerPunishmentReasonChatEvent implements Listener {

    public static String custom_reason;

    @EventHandler
    public void onChat(AsyncPlayerChatEvent e) {
        Player p = e.getPlayer();

        if(PunishmentAPI.isChatReason.containsKey(p)) {
            e.setCancelled(true);

            Player target = PunishCommand.punishes.get(p);
            custom_reason = e.getMessage();

            if(PunishmentAPI.punishType.get(p).equalsIgnoreCase("BAN")) {
                PunishmentAPI.setPlayerOutOutTypeReason(target, p, custom_reason, "BAN");
            }

            if(PunishmentAPI.punishType.get(p).equalsIgnoreCase("WARN")) {
                PunishmentAPI.setPlayerOutOutTypeReason(target, p, custom_reason, "WARN");
            }

            if(PunishmentAPI.punishType.get(p).equalsIgnoreCase("MUTE")) {
                PunishmentAPI.setPlayerOutOutTypeReason(target, p, custom_reason, "MUTE");
            }

        } else {
            return;
        }
    }
}
