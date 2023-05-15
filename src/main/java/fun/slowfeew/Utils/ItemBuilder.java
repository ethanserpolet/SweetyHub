package fun.slowfeew.Utils;

import java.util.Arrays;
import java.util.List;
import org.bukkit.Color;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.inventory.meta.SkullMeta;

public class ItemBuilder {
  private ItemStack is;
  
  public ItemBuilder(Material m) {
    this(m, 1);
  }
  
  public ItemBuilder(ItemStack is) {
    this.is = is;
  }
  
  public ItemBuilder(Material m, int amount) {
    this.is = new ItemStack(m, amount);
  }
  
  public ItemBuilder(Material m, int amount, short meta) {
    this.is = new ItemStack(m, amount, meta);
  }
  
  public ItemBuilder clone() {
    return new ItemBuilder(this.is);
  }
  
  public ItemBuilder setDurability(short dur) {
    this.is.setDurability(dur);
    return this;
  }
  
  public ItemBuilder setDisplayName(String name) {
    ItemMeta im = this.is.getItemMeta();
    im.setDisplayName(name);
    this.is.setItemMeta(im);
    return this;
  }
  
  public ItemBuilder addUnsafeEnchantment(Enchantment ench, int level) {
    this.is.addUnsafeEnchantment(ench, level);
    return this;
  }
  
  public ItemBuilder removeEnchantment(Enchantment ench) {
    this.is.removeEnchantment(ench);
    return this;
  }
  
  public ItemBuilder setSkullOwner(String owner) {
    try {
      SkullMeta im = (SkullMeta)this.is.getItemMeta();
      im.setOwner(owner);
      this.is.setItemMeta((ItemMeta)im);
    } catch (ClassCastException classCastException) {}
    return this;
  }
  
  public ItemBuilder addEnchant(Enchantment ench, int level) {
    ItemMeta im = this.is.getItemMeta();
    im.addEnchant(ench, level, true);
    this.is.setItemMeta(im);
    return this;
  }
  
  public ItemBuilder setInfinityDurability() {
    this.is.getItemMeta().spigot().setUnbreakable(true);
    return this;
  }
  
  public ItemBuilder flag(ItemFlag itemFlag) {
    ItemMeta im = this.is.getItemMeta();
    im.addItemFlags(new ItemFlag[] { itemFlag });
    this.is.setItemMeta(im);
    return this;
  }
  
  public ItemBuilder lore(String... lore) {
    ItemMeta im = this.is.getItemMeta();
    im.setLore(Arrays.asList(lore));
    this.is.setItemMeta(im);
    return this;
  }
  
  public ItemBuilder setLoreWithList(List<String> lore) {
    ItemMeta im = this.is.getItemMeta();
    im.setLore(lore);
    this.is.setItemMeta(im);
    return this;
  }
  
  public ItemBuilder setWoolColor(DyeColor color) {
    if (!this.is.getType().equals(Material.WOOL))
      return this; 
    this.is.setDurability(color.getData());
    return this;
  }
  
  public ItemBuilder setLeatherArmorColor(Color color) {
    try {
      LeatherArmorMeta im = (LeatherArmorMeta)this.is.getItemMeta();
      im.setColor(color);
      this.is.setItemMeta((ItemMeta)im);
    } catch (ClassCastException classCastException) {}
    return this;
  }
  
  public ItemStack build() {
    return this.is;
  }
}
