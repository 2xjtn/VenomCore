package org.jacob.spigot.plugins.VenomCore.utils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.jacob.spigot.plugins.VenomCore.listeners.PlayerPunishmentReasonChatEvent;
import org.jacob.spigot.plugins.VenomCore.listeners.PunishInventoryClickListener;

import java.util.HashMap;

public class PunishmentAPI {

    public static HashMap<Player, Boolean> isChatReason = new HashMap<Player, Boolean>();

    public static HashMap<Player, String> punishType = new HashMap<Player, String>();

    public static void setPlayerTypeReason(Player target, Player executor) {

        executor.closeInventory();
        isChatReason.put(executor, true);

        executor.sendMessage(ChatColor.YELLOW + "Please type a custom reason in chat.");

    }

    public static void setPlayerOutOutTypeReason(Player target, Player executor, String reason, String type) {

        if(type.equalsIgnoreCase("BAN")) {
            isChatReason.remove(executor);
            PunishInventoryClickListener.reasons.put(executor, reason);
            executor.sendMessage(ChatColor.YELLOW + "Your custom reason is now: " + ChatColor.DARK_GREEN + PlayerPunishmentReasonChatEvent.custom_reason);
            PunishmentInventories.openPunishBanDurationInventory(target, executor);
            return;
        }

        if(type.equalsIgnoreCase("WARN")) {
            isChatReason.remove(executor);
            PunishInventoryClickListener.reasons.put(executor, reason);
            executor.sendMessage(ChatColor.YELLOW + "Your custom reason is now: " + ChatColor.DARK_GREEN + PlayerPunishmentReasonChatEvent.custom_reason);
            Bukkit.dispatchCommand(executor, "warn " + target.getName() + " " + PlayerPunishmentReasonChatEvent.custom_reason);
            return;
        }

        if(type.equalsIgnoreCase("MUTE")) {
            isChatReason.remove(executor);
            PunishInventoryClickListener.reasons.put(executor, reason);
            executor.sendMessage(ChatColor.YELLOW + "Your custom reason is now: " + ChatColor.DARK_GREEN + PlayerPunishmentReasonChatEvent.custom_reason);
            PunishmentInventories.openPunishMutesDurationInventory(target, executor);
            return;
        }

    }

}
