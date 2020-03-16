package org.jacob.spigot.plugins.VenomCore.utils;

import org.bukkit.*;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.*;

public class ItemStackBuilder {
    private ItemStack stack;

    public ItemStackBuilder(Material material) {
        stack = new ItemStack(material);
    }

    public ItemStackBuilder amount(int amount) {
        stack.setAmount(amount);
        return this;
    }

    public ItemStackBuilder name(String name) {
        ItemMeta meta = stack.getItemMeta();
        meta.setDisplayName(name);
        stack.setItemMeta(meta);
        return this;
    }

    public ItemStackBuilder lore(List<String> lore) {
        ItemMeta meta = stack.getItemMeta();
        meta.setLore(lore);
        stack.setItemMeta(meta);
        return this;
    }

    public ItemStackBuilder enchant(Enchantment enchantment, int level) {
        stack.addUnsafeEnchantment(enchantment, level);
        return this;
    }

    public ItemStackBuilder enchant(Map<Enchantment, Integer> enchantments) {
        stack.addUnsafeEnchantments(enchantments);
        return this;
    }

    public ItemStack build() {
        return stack;
    }
}

