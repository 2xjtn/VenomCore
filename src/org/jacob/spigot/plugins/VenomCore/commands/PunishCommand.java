package org.jacob.spigot.plugins.VenomCore.commands;

import javafx.print.PageLayout;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.ChatColor;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;
import org.jacob.spigot.plugins.VenomCore.VenomCore;
import org.jacob.spigot.plugins.VenomCore.utils.PunishmentInventories;

import java.util.HashMap;

public class PunishCommand implements CommandExecutor {

    public static HashMap<Player, Player> punishes = new HashMap<Player, Player>();

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if(s.equalsIgnoreCase("punish")) {

            if(!(commandSender instanceof Player)) {
                String playeronly = VenomCore.getInstance().getConfig().getString("player-only");

                commandSender.sendMessage(ChatColor.translateAlternateColorCodes('&', playeronly));
                return true;
            }
            Player p = (Player) commandSender;


            if(!p.hasPermission("venompunish.punish")) {
                String perm = VenomCore.getInstance().getConfig().getString("no-permission");

                p.sendMessage(ChatColor.translateAlternateColorCodes('&', perm));
                return true;
            }

            if(strings.length > 1) {
                return true;
            }

            if(strings.length == 0) {
                Inventory playerlist = Bukkit.createInventory(null, 27, "Players");

                for(Player all : Bukkit.getOnlinePlayers()) {
                    ItemStack skull = new ItemStack(Material.SKULL_ITEM, 1, (byte) 3);

                    SkullMeta meta = (SkullMeta) skull.getItemMeta();
                    meta.setOwner(all.getName());
                    meta.setDisplayName(all.getName());

                    skull.setItemMeta(meta);

                    playerlist.addItem(skull);
                }

                p.openInventory(playerlist);

                return true;

            }

            Player t = Bukkit.getPlayerExact(strings[0]);

            if(t == null) {
                String noexist = VenomCore.getInstance().getConfig().getString("player-not-exist");

                p.sendMessage(ChatColor.translateAlternateColorCodes('&', noexist));
                return true;
            }

            PunishmentInventories.openPunishMainInventory(t, p);

            punishes.put(p, t);
        }

        return true;
    }
}
