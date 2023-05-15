package fun.slowfeew;

import java.io.File;

import fun.slowfeew.Utils.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;

public class Armor implements CommandExecutor {
  private Main main;
  
  public Armor(Main main) {
    this.main = main;
  }
  
  public boolean onCommand(CommandSender sender, Command cmd, String arg, String[] args) {
    if (cmd.getName().equalsIgnoreCase("opengui") && 
      sender instanceof Player) {
      Player p = ((Player)sender).getPlayer();
      if (args.length == 1) {
        if (args[0].contains("ComboFFA")) {
          Inventory openGuiNavigator = Bukkit.createInventory(null, 54, "\u00A76Navigateur \u00A78\u00A7l\u21AA \u00A76ComboFFA");
          openGuiNavigator.setItem(49, (new ItemBuilder(Material.BARRIER, 1)).setInfinityDurability().setDisplayName("\u00A7cRetour \u00A78\u21AA \u00A77Menu Principal").flag(ItemFlag.HIDE_UNBREAKABLE).flag(ItemFlag.HIDE_ATTRIBUTES).build());
          openGuiNavigator.setItem(4, (new ItemBuilder(Material.RAW_FISH, 1, (short)3)).setInfinityDurability().setDisplayName("\u00A7bComboFFA \u00A78(\u00A7bB\u00EAta\u00A78)").lore(new String[] { "\u00A78D\u00E9veloppeur: iShynss", "\u00A78Version: 1.8.8+", "\u00A7b ", "\u00A7e\u00A7nOjectif:", "\u00A77Apparaissez sur une \u00EEle au dessus", "\u00A77du vide pour terasser vos adversaire gr\u00E2ce", "\u00A77\u00E0 vos talent pour ComboFly, il faudra MLG", "\u00A77pour survivre.", "\u00A7b", "\u00A7b\u00A7nRejoindre le serveur." }).flag(ItemFlag.HIDE_UNBREAKABLE).flag(ItemFlag.HIDE_ATTRIBUTES).build());
          openGuiNavigator.setItem(51, (new ItemBuilder(Material.REDSTONE, 0)).setInfinityDurability().setDisplayName("\u00A7dParticules").lore(new String[] { "\u00A77" }).flag(ItemFlag.HIDE_UNBREAKABLE).flag(ItemFlag.HIDE_ATTRIBUTES).build());
          openGuiNavigator.setItem(47, (new ItemBuilder(Material.INK_SACK, 1, (short)10)).setInfinityDurability().setDisplayName("\u00A7aChanger de Lobby").flag(ItemFlag.HIDE_UNBREAKABLE).flag(ItemFlag.HIDE_ATTRIBUTES).build());
          openGuiNavigator.setItem(0, (new ItemBuilder(Material.STAINED_GLASS_PANE, 1)).setInfinityDurability().setDisplayName(" ").flag(ItemFlag.HIDE_UNBREAKABLE).flag(ItemFlag.HIDE_ATTRIBUTES).build());
          openGuiNavigator.setItem(1, (new ItemBuilder(Material.STAINED_GLASS_PANE, 1)).setInfinityDurability().setDisplayName(" ").flag(ItemFlag.HIDE_UNBREAKABLE).flag(ItemFlag.HIDE_ATTRIBUTES).build());
          openGuiNavigator.setItem(7, (new ItemBuilder(Material.STAINED_GLASS_PANE, 1)).setInfinityDurability().setDisplayName(" ").flag(ItemFlag.HIDE_UNBREAKABLE).flag(ItemFlag.HIDE_ATTRIBUTES).build());
          openGuiNavigator.setItem(8, (new ItemBuilder(Material.STAINED_GLASS_PANE, 1)).setInfinityDurability().setDisplayName(" ").flag(ItemFlag.HIDE_UNBREAKABLE).flag(ItemFlag.HIDE_ATTRIBUTES).build());
          openGuiNavigator.setItem(9, (new ItemBuilder(Material.STAINED_GLASS_PANE, 1)).setInfinityDurability().setDisplayName(" ").flag(ItemFlag.HIDE_UNBREAKABLE).flag(ItemFlag.HIDE_ATTRIBUTES).build());
          openGuiNavigator.setItem(17, (new ItemBuilder(Material.STAINED_GLASS_PANE, 1)).setInfinityDurability().setDisplayName(" ").flag(ItemFlag.HIDE_UNBREAKABLE).flag(ItemFlag.HIDE_ATTRIBUTES).build());
          openGuiNavigator.setItem(53, (new ItemBuilder(Material.STAINED_GLASS_PANE, 1)).setInfinityDurability().setDisplayName(" ").flag(ItemFlag.HIDE_UNBREAKABLE).flag(ItemFlag.HIDE_ATTRIBUTES).build());
          openGuiNavigator.setItem(52, (new ItemBuilder(Material.STAINED_GLASS_PANE, 1)).setInfinityDurability().setDisplayName(" ").flag(ItemFlag.HIDE_UNBREAKABLE).flag(ItemFlag.HIDE_ATTRIBUTES).build());
          openGuiNavigator.setItem(45, (new ItemBuilder(Material.STAINED_GLASS_PANE, 1)).setInfinityDurability().setDisplayName(" ").flag(ItemFlag.HIDE_UNBREAKABLE).flag(ItemFlag.HIDE_ATTRIBUTES).build());
          openGuiNavigator.setItem(46, (new ItemBuilder(Material.STAINED_GLASS_PANE, 1)).setInfinityDurability().setDisplayName(" ").flag(ItemFlag.HIDE_UNBREAKABLE).flag(ItemFlag.HIDE_ATTRIBUTES).build());
          openGuiNavigator.setItem(44, (new ItemBuilder(Material.STAINED_GLASS_PANE, 1)).setInfinityDurability().setDisplayName(" ").flag(ItemFlag.HIDE_UNBREAKABLE).flag(ItemFlag.HIDE_ATTRIBUTES).build());
          openGuiNavigator.setItem(36, (new ItemBuilder(Material.STAINED_GLASS_PANE, 1)).setInfinityDurability().setDisplayName(" ").flag(ItemFlag.HIDE_UNBREAKABLE).flag(ItemFlag.HIDE_ATTRIBUTES).build());
          FileConfiguration configsss = null;
          File filesss = new File("../SkyCubeYAML/PlayersOnline.yml");
          YamlConfiguration yamlConfiguration1 = YamlConfiguration.loadConfiguration(filesss);
          String list = yamlConfiguration1.getString("Servers");
          Integer i = Integer.valueOf(20);
          FileConfiguration configserv = null;
          File filesrv = new File("../SkyCubeYAML/ServerList.yml");
          YamlConfiguration yamlConfiguration2 = YamlConfiguration.loadConfiguration(filesrv);
          byte b;
          int j;
          String[] arrayOfString;
          for (j = (arrayOfString = list.split(", ")).length, b = 0; b < j; ) {
            String Srvs = arrayOfString[b];
            if (Srvs.contains("ComboFFA_u")) {
              Integer ON = Integer.valueOf(yamlConfiguration2.getInt("Server." + Srvs + ".Joueurs"));
              if (yamlConfiguration2.getBoolean("Server." + Srvs + ".Enable"))
                openGuiNavigator.setItem(i.intValue(), (new ItemBuilder(Material.STAINED_CLAY, 1, (short)5)).setInfinityDurability().setDisplayName(Srvs).lore(new String[] { "\u00A77Mode: \u00A7bUnranked", "\u00A77Joueurs: \u00A7b" + ON, "\u00A7b", "\u00A7b\u00A7nRejoindre le serveur." }).flag(ItemFlag.HIDE_UNBREAKABLE).flag(ItemFlag.HIDE_ATTRIBUTES).build()); 
              i = Integer.valueOf(i.intValue() + 1);
            } 
            if (Srvs.contains("ComboFFA_r")) {
              Integer ON = Integer.valueOf(yamlConfiguration2.getInt("Server." + Srvs + ".Joueurs"));
              if (yamlConfiguration2.getBoolean("Server." + Srvs + ".Enable"))
                openGuiNavigator.setItem(i.intValue(), (new ItemBuilder(Material.STAINED_CLAY, 1, (short)5)).setInfinityDurability().addEnchant(Enchantment.DAMAGE_ALL, 10).setDisplayName(Srvs).lore(new String[] { "\u00A77Mode: \u00A7bRanked", "\u00A77Joueurs: \u00A7b" + ON, "\u00A7b", "\u00A7b\u00A7nRejoindre le serveur." }).flag(ItemFlag.HIDE_UNBREAKABLE).flag(ItemFlag.HIDE_ATTRIBUTES).build()); 
              i = Integer.valueOf(i.intValue() + 1);
            } 
            b++;
          } 
          p.openInventory(openGuiNavigator);
        } 
        if (args[0].contains("KnockbackFFA")) {
          Inventory openGuiNavigator = Bukkit.createInventory(null, 27, "\u00A76QuickTP \u00A78\u00A7l\u21AA \u00A76KnockbackFFA");
          openGuiNavigator.setItem(4, (new ItemBuilder(Material.STICK, 1)).setInfinityDurability().setDisplayName("\u00A7bKnockbackFFA \u00A78(\u00A7bB\u00EAta\u00A78)").lore(new String[] { "\u00A78D\u00E9veloppeur: iShynss", "\u00A78Version: 1.8.8+", "\u00A7b ", "\u00A7e\u00A7nOjectif:", "\u00A77Dans ce mode de jeu fun et engoissant,", "\u00A77votre mission sera de faire voler vos", "\u00A77adversaire dans l'espace", "\u00A77juste avec un Arc et un baton enchant\u00E9e.", "\u00A7b ", "\u00A7b\u00A7nRejoindre le serveur." }).flag(ItemFlag.HIDE_UNBREAKABLE).flag(ItemFlag.HIDE_ATTRIBUTES).build());
          openGuiNavigator.setItem(0, (new ItemBuilder(Material.STAINED_GLASS_PANE, 1)).setInfinityDurability().setDisplayName(" ").flag(ItemFlag.HIDE_UNBREAKABLE).flag(ItemFlag.HIDE_ATTRIBUTES).build());
          openGuiNavigator.setItem(1, (new ItemBuilder(Material.STAINED_GLASS_PANE, 1)).setInfinityDurability().setDisplayName(" ").flag(ItemFlag.HIDE_UNBREAKABLE).flag(ItemFlag.HIDE_ATTRIBUTES).build());
          openGuiNavigator.setItem(7, (new ItemBuilder(Material.STAINED_GLASS_PANE, 1)).setInfinityDurability().setDisplayName(" ").flag(ItemFlag.HIDE_UNBREAKABLE).flag(ItemFlag.HIDE_ATTRIBUTES).build());
          openGuiNavigator.setItem(8, (new ItemBuilder(Material.STAINED_GLASS_PANE, 1)).setInfinityDurability().setDisplayName(" ").flag(ItemFlag.HIDE_UNBREAKABLE).flag(ItemFlag.HIDE_ATTRIBUTES).build());
          openGuiNavigator.setItem(9, (new ItemBuilder(Material.STAINED_GLASS_PANE, 1)).setInfinityDurability().setDisplayName(" ").flag(ItemFlag.HIDE_UNBREAKABLE).flag(ItemFlag.HIDE_ATTRIBUTES).build());
          openGuiNavigator.setItem(17, (new ItemBuilder(Material.STAINED_GLASS_PANE, 1)).setInfinityDurability().setDisplayName(" ").flag(ItemFlag.HIDE_UNBREAKABLE).flag(ItemFlag.HIDE_ATTRIBUTES).build());
          openGuiNavigator.setItem(18, (new ItemBuilder(Material.STAINED_GLASS_PANE, 1)).setInfinityDurability().setDisplayName(" ").flag(ItemFlag.HIDE_UNBREAKABLE).flag(ItemFlag.HIDE_ATTRIBUTES).build());
          openGuiNavigator.setItem(19, (new ItemBuilder(Material.STAINED_GLASS_PANE, 1)).setInfinityDurability().setDisplayName(" ").flag(ItemFlag.HIDE_UNBREAKABLE).flag(ItemFlag.HIDE_ATTRIBUTES).build());
          openGuiNavigator.setItem(25, (new ItemBuilder(Material.STAINED_GLASS_PANE, 1)).setInfinityDurability().setDisplayName(" ").flag(ItemFlag.HIDE_UNBREAKABLE).flag(ItemFlag.HIDE_ATTRIBUTES).build());
          openGuiNavigator.setItem(26, (new ItemBuilder(Material.STAINED_GLASS_PANE, 1)).setInfinityDurability().setDisplayName(" ").flag(ItemFlag.HIDE_UNBREAKABLE).flag(ItemFlag.HIDE_ATTRIBUTES).build());
          FileConfiguration configsss = null;
          File filesss = new File("../SkyCubeYAML/PlayersOnline.yml");
          YamlConfiguration yamlConfiguration = YamlConfiguration.loadConfiguration(filesss);
          String list = yamlConfiguration.getString("Servers");
          Integer i = Integer.valueOf(10);
          byte b;
          int j;
          String[] arrayOfString;
          for (j = (arrayOfString = list.split(", ")).length, b = 0; b < j; ) {
            String Srvs = arrayOfString[b];
            if (Srvs.contains("KnockbackFFA_u")) {
              Integer ON = Main.Onlines.get(Srvs);
              if (Main.ServerIsOnline.containsKey(Srvs))
                openGuiNavigator.setItem(i.intValue(), (new ItemBuilder(Material.STAINED_CLAY, 1, (short)5)).setInfinityDurability().setDisplayName(Srvs).lore(new String[] { "\u00A77Mode: \u00A7bUnranked", "\u00A77Joueurs: \u00A7b" + ON, "\u00A7b", "\u00A7b\u00A7nRejoindre le serveur." }).flag(ItemFlag.HIDE_UNBREAKABLE).flag(ItemFlag.HIDE_ATTRIBUTES).build()); 
              i = Integer.valueOf(i.intValue() + 1);
            } 
            if (Srvs.contains("KnockbackFFA_r")) {
              Integer ON = Main.Onlines.get(Srvs);
              if (Main.ServerIsOnline.containsKey(Srvs))
                openGuiNavigator.setItem(i.intValue(), (new ItemBuilder(Material.STAINED_CLAY, 1, (short)5)).setInfinityDurability().addEnchant(Enchantment.DAMAGE_ALL, 10).setDisplayName(Srvs).lore(new String[] { "\u00A77Mode: \u00A7bRanked", "\u00A77Joueurs: \u00A7b" + ON, "\u00A7b", "\u00A7b\u00A7nRejoindre le serveur." }).flag(ItemFlag.HIDE_UNBREAKABLE).flag(ItemFlag.HIDE_ATTRIBUTES).build()); 
              i = Integer.valueOf(i.intValue() + 1);
            } 
            b++;
          } 
          ((Player)sender).getPlayer().openInventory(openGuiNavigator);
        } 
        if (args[0].contains("BlitzFFA")) {
          Inventory openGuiNavigator = Bukkit.createInventory(null, 27, "\u00A76QuickTP \u00A78\u00A7l\u21AA \u00A76BlitzFFA");
          openGuiNavigator.setItem(4, (new ItemBuilder(Material.WOOL, 0, (short)14)).setInfinityDurability().setDisplayName("\u00A7bBlitzFFA \u00A78(\u00A7bB\u00EAta\u00A78)").lore(new String[0]).flag(ItemFlag.HIDE_UNBREAKABLE).flag(ItemFlag.HIDE_ATTRIBUTES).build());
          openGuiNavigator.setItem(0, (new ItemBuilder(Material.STAINED_GLASS_PANE, 1)).setInfinityDurability().setDisplayName(" ").flag(ItemFlag.HIDE_UNBREAKABLE).flag(ItemFlag.HIDE_ATTRIBUTES).build());
          openGuiNavigator.setItem(1, (new ItemBuilder(Material.STAINED_GLASS_PANE, 1)).setInfinityDurability().setDisplayName(" ").flag(ItemFlag.HIDE_UNBREAKABLE).flag(ItemFlag.HIDE_ATTRIBUTES).build());
          openGuiNavigator.setItem(7, (new ItemBuilder(Material.STAINED_GLASS_PANE, 1)).setInfinityDurability().setDisplayName(" ").flag(ItemFlag.HIDE_UNBREAKABLE).flag(ItemFlag.HIDE_ATTRIBUTES).build());
          openGuiNavigator.setItem(8, (new ItemBuilder(Material.STAINED_GLASS_PANE, 1)).setInfinityDurability().setDisplayName(" ").flag(ItemFlag.HIDE_UNBREAKABLE).flag(ItemFlag.HIDE_ATTRIBUTES).build());
          openGuiNavigator.setItem(9, (new ItemBuilder(Material.STAINED_GLASS_PANE, 1)).setInfinityDurability().setDisplayName(" ").flag(ItemFlag.HIDE_UNBREAKABLE).flag(ItemFlag.HIDE_ATTRIBUTES).build());
          openGuiNavigator.setItem(17, (new ItemBuilder(Material.STAINED_GLASS_PANE, 1)).setInfinityDurability().setDisplayName(" ").flag(ItemFlag.HIDE_UNBREAKABLE).flag(ItemFlag.HIDE_ATTRIBUTES).build());
          openGuiNavigator.setItem(18, (new ItemBuilder(Material.STAINED_GLASS_PANE, 1)).setInfinityDurability().setDisplayName(" ").flag(ItemFlag.HIDE_UNBREAKABLE).flag(ItemFlag.HIDE_ATTRIBUTES).build());
          openGuiNavigator.setItem(19, (new ItemBuilder(Material.STAINED_GLASS_PANE, 1)).setInfinityDurability().setDisplayName(" ").flag(ItemFlag.HIDE_UNBREAKABLE).flag(ItemFlag.HIDE_ATTRIBUTES).build());
          openGuiNavigator.setItem(25, (new ItemBuilder(Material.STAINED_GLASS_PANE, 1)).setInfinityDurability().setDisplayName(" ").flag(ItemFlag.HIDE_UNBREAKABLE).flag(ItemFlag.HIDE_ATTRIBUTES).build());
          openGuiNavigator.setItem(26, (new ItemBuilder(Material.STAINED_GLASS_PANE, 1)).setInfinityDurability().setDisplayName(" ").flag(ItemFlag.HIDE_UNBREAKABLE).flag(ItemFlag.HIDE_ATTRIBUTES).build());
          FileConfiguration configsss = null;
          File filesss = new File("../SkyCubeYAML/PlayersOnline.yml");
          YamlConfiguration yamlConfiguration = YamlConfiguration.loadConfiguration(filesss);
          String list = yamlConfiguration.getString("Servers");
          Integer i = Integer.valueOf(10);
          byte b;
          int j;
          String[] arrayOfString;
          for (j = (arrayOfString = list.split(", ")).length, b = 0; b < j; ) {
            String Srvs = arrayOfString[b];
            if (Srvs.contains("BlitzFFA_u")) {
              Integer ON = Main.Onlines.get(Srvs);
              if (Main.ServerIsOnline.containsKey(Srvs))
                openGuiNavigator.setItem(i.intValue(), (new ItemBuilder(Material.STAINED_CLAY, 1, (short)5)).setInfinityDurability().setDisplayName(Srvs).lore(new String[] { "\u00A77Mode: \u00A7bUnranked", "\u00A77Joueurs: \u00A7b" + ON, "\u00A7b", "\u00A7b\u00A7nRejoindre le serveur." }).flag(ItemFlag.HIDE_UNBREAKABLE).flag(ItemFlag.HIDE_ATTRIBUTES).build()); 
              i = Integer.valueOf(i.intValue() + 1);
            } 
            if (Srvs.contains("BlitzFFA_r")) {
              Integer ON = Main.Onlines.get(Srvs);
              if (Main.ServerIsOnline.containsKey(Srvs))
                openGuiNavigator.setItem(i.intValue(), (new ItemBuilder(Material.STAINED_CLAY, 1, (short)5)).setInfinityDurability().addEnchant(Enchantment.DAMAGE_ALL, 10).setDisplayName(Srvs).lore(new String[] { "\u00A77Mode: \u00A7bRanked", "\u00A77Joueurs: \u00A7b" + ON, "\u00A7b", "\u00A7b\u00A7nRejoindre le serveur." }).flag(ItemFlag.HIDE_UNBREAKABLE).flag(ItemFlag.HIDE_ATTRIBUTES).build()); 
              i = Integer.valueOf(i.intValue() + 1);
            } 
            b++;
          } 
          ((Player)sender).getPlayer().openInventory(openGuiNavigator);
        } 
      } 
    } 
    return false;
  }
}
