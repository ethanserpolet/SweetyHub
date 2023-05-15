package fun.slowfeew;

import fun.slowfeew.Utils.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;

public class Boutique implements Listener {
  public static void openGuiBoutique(Player p, String str) {
    if (str == "Main") {
      Inventory openGuiBoutique = Bukkit.createInventory(null, 54, "§6Boutique §8§l↪ §6Menu principal");
      openGuiBoutique.setItem(32, (new ItemBuilder(Material.EXP_BOTTLE, 1)).setInfinityDurability().setDisplayName("§6Boosters §7(§cProchainement§7)").lore(new String[] { "§7Clic gauche pour ouvrir." }).flag(ItemFlag.HIDE_UNBREAKABLE).flag(ItemFlag.HIDE_ATTRIBUTES).build());
      openGuiBoutique.setItem(30, (new ItemBuilder(Material.BOOK, 1)).setInfinityDurability().setDisplayName("§3Abonnements §(§cProchainement§7").lore(new String[] { "§7Clic gauche pour ouvrir." }).flag(ItemFlag.HIDE_UNBREAKABLE).flag(ItemFlag.HIDE_ATTRIBUTES).build());
      openGuiBoutique.setItem(22, (new ItemBuilder(Material.DIAMOND_BLOCK, 1)).setInfinityDurability().setDisplayName("§bGrades").flag(ItemFlag.HIDE_UNBREAKABLE).lore(new String[] { "§7Clic gauche pour ouvrir." }).flag(ItemFlag.HIDE_ATTRIBUTES).build());
      openGuiBoutique.setItem(31, (new ItemBuilder(Material.ENDER_CHEST, 1)).setInfinityDurability().setDisplayName("§dParticules").flag(ItemFlag.HIDE_UNBREAKABLE).lore(new String[] { "§7Clic gauche pour ouvrir." }).flag(ItemFlag.HIDE_ATTRIBUTES).build());
      p.openInventory(openGuiBoutique);
    } 
    if (str == "Boosters") {
      Inventory openGuiBooster = Bukkit.createInventory(null, 54, "Boosters");
      openGuiBooster.setItem(1, (new ItemBuilder(Material.PORTAL, 1)).setInfinityDurability().setDisplayName("&§Global").lore(new String[] { "§3", "", "§d" }).flag(ItemFlag.HIDE_UNBREAKABLE).flag(ItemFlag.HIDE_ATTRIBUTES).build());
      openGuiBooster.setItem(1, (new ItemBuilder(Material.DIAMOND_SWORD, 1)).setInfinityDurability().setDisplayName("&§Mini-jeux").lore(new String[] { "§3", "", "§d" }).flag(ItemFlag.HIDE_UNBREAKABLE).flag(ItemFlag.HIDE_ATTRIBUTES).build());
      openGuiBooster.setItem(1, (new ItemBuilder(Material.REDSTONE_COMPARATOR, 1)).setInfinityDurability().setDisplayName("§cRetour").lore(new String[] { "§3", "", "§d" }).flag(ItemFlag.HIDE_UNBREAKABLE).flag(ItemFlag.HIDE_ATTRIBUTES).build());
      p.openInventory(openGuiBooster);
    } 
    if (str == "Grades") {
      Inventory openGuiRanks = Bukkit.createInventory(null, 54, "§6Boutique §8\u21AA §6Grades");
      openGuiRanks.setItem(28, (new ItemBuilder(Material.IRON_BARDING, 1)).setInfinityDurability().setDisplayName("§bGardien").lore(new String[] { 
              "§7Annonces de connexion au Hub: §cNon", "§7Cacher son préfix (/tag): §cNon", "§7Serveurs à la demande: §cNon", "§7Slot d'Amis Supplémentaires: §a+3", "§7Inviter les joueurs a vous rejoindre (/fc): §cNon", "§7Réinitialiser ses statistiques: §cNon", "§7Acc\u00E8s b\u00EAta: §cNon", "§7Particules Supplémentaires (Aléatoire): §a+2", "§7Nuages Supplémentaires: §a+350", "§7Booster Personnel de nuages: §a+25%", 
              "§7Boosters Supplémentaires (/boost): §cNon", "§7Voir les staffs connectés (/staff): §cNon", "§7Renommer son épée en jeu: §aOui", "§7Prix: §65 EUR" }).flag(ItemFlag.HIDE_UNBREAKABLE).flag(ItemFlag.HIDE_ATTRIBUTES).build());
      openGuiRanks.setItem(30, (new ItemBuilder(Material.YELLOW_FLOWER, 1)).setInfinityDurability().setDisplayName("§aCeleste").lore(new String[] { 
              "§7Annonces de connexion au Hub: §aOui", "§7Cacher son préfix (/tag): §cNon", "§7Serveurs à la demande: §cNon", "§7Slot d'Amis Supplémentaires: §a+5", "§7Inviter les joueurs a vous rejoindre (/fc): §cNon", "§7Réinitialiser ses statistiques: §aOui", "§7Acc\u00E8s b\u00EAta: §cNon", "§7Particules Supplémentaires (Aléatoire): §a+5", "§7Nuages Supplémentaires: §a+500", "§7Booster Personnel de nuages: §a+35%", 
              "§7Boosters Supplémentaires (/boost): §a+1", "§7Voir les staffs connectés (/staff): §cNon", "§7Renommer son épée en jeu: §aOui", "§7Prix: §69 EUR" }).flag(ItemFlag.HIDE_UNBREAKABLE).flag(ItemFlag.HIDE_ATTRIBUTES).build());
      openGuiRanks.setItem(32, (new ItemBuilder(Material.ELYTRA, 1)).setInfinityDurability().setDisplayName("§6Ange").flag(ItemFlag.HIDE_UNBREAKABLE).lore(new String[] { 
              "§7Annonces de connexion au Hub: §cNon", "§7Cacher son préfix (/tag): §cNon", "§7Serveurs à la demande: §cNon", "§7Slot d'Amis Supplémentaires: §a+3", "§7Inviter les joueurs a vous rejoindre (/fc): §cNon", "§7Réinitialiser ses statistiques: §cNon", "§7Acc\u00E8s b\u00EAta: §cNon", "§7Particules Supplémentaires (Aléatoire): §ax2", "§7Nuages Supplémentaires: §a+350", "§7Booster Personnel de nuages: §a+25%", 
              "§7Boosters Supplémentaires (/boost): §cNon", "§7Voir les staffs connectés (/staff): §cNon", "§7Renommer son épée en jeu: §aOui", "§7Prix: §630 EUR" }).flag(ItemFlag.HIDE_ATTRIBUTES).build());
      openGuiRanks.setItem(34, (new ItemBuilder(Material.QUARTZ_BLOCK, 1)).setInfinityDurability().setDisplayName("§eDieu").flag(ItemFlag.HIDE_UNBREAKABLE).lore(new String[] { 
              "§7Annonces de connexion au Hub: §aOui", "§7Cacher son préfix (/tag): §aOui", "§7Serveurs à la demande: §a(Reduction de 30%%)", "§7Slot d'Amis Supplémentaires: §a+10", "§7Inviter les joueurs a vous rejoindre (/fc): §aOui", "§7Réinitialiser ses statistiques: §aOui", "§7Acc\u00E8s b\u00EAta: §aOui", "§7Particules Supplémentaires (Aléatoire): §a+3", "§7Nuages Supplémentaires: §a+1000", "§7Booster Personnel de nuages: §a+75%", 
              "§7Boosters Supplémentaires (/boost): §cx3", "§7Voir les staffs connectés (/staff): §aOui", "§7Renommer son épée en jeu: §aOui", "§7Prix: §650 EUR" }).flag(ItemFlag.HIDE_ATTRIBUTES).build());
      p.openInventory(openGuiRanks);
    } 
  }
}
