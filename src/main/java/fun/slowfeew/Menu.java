package fun.slowfeew;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

import fun.slowfeew.Utils.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.event.inventory.InventoryMoveItemEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

public class Menu implements Listener {
  private Main main;
  
  public Menu(Main main) {
    this.main = main;
  }
  
  public void openGuiNavigator(Player player, String str) {

    if (str == "ComboFFA") {
      Inventory openGuiNavigator = Bukkit.createInventory(null, 54, "§6Navigateur §8§l↪ §6ComboFFA");
      openGuiNavigator.setItem(49, (new ItemBuilder(Material.BARRIER, 1)).setInfinityDurability().setDisplayName("§cRetour §8↪ §7Menu Principal").flag(ItemFlag.HIDE_UNBREAKABLE).flag(ItemFlag.HIDE_ATTRIBUTES).build());
      openGuiNavigator.setItem(4, (new ItemBuilder(Material.RAW_FISH, 1, (short)3)).setInfinityDurability().setDisplayName("§bComboFFA §8(§bBêta§8)").lore(new String[] { "§8Développeur: iShynss", "§8Version: 1.8.8+", "§b ", "§e§nOjectif:", "§7Apparaissez sur une \u00EEle au dessus", "§7du vide pour terasser vos adversaire gr\u00E2ce", "§7\u00E0 vos talent pour ComboFly, il faudra MLG", "§7pour survivre.", "§b", "§b§nRejoindre le serveur." }).flag(ItemFlag.HIDE_UNBREAKABLE).flag(ItemFlag.HIDE_ATTRIBUTES).build());
      openGuiNavigator.setItem(51, (new ItemBuilder(Material.REDSTONE, 0)).setInfinityDurability().setDisplayName("§dParticules").lore(new String[] { "§7" }).flag(ItemFlag.HIDE_UNBREAKABLE).flag(ItemFlag.HIDE_ATTRIBUTES).build());
      openGuiNavigator.setItem(47, (new ItemBuilder(Material.INK_SACK, 1, (short)10)).setInfinityDurability().setDisplayName("§aChanger de Lobby").flag(ItemFlag.HIDE_UNBREAKABLE).flag(ItemFlag.HIDE_ATTRIBUTES).build());
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



      String list = "";
      byte b;
      int j;
      int i = 1;

      String[] arrayOfString;

      for (j = (arrayOfString = list.split(", ")).length, b = 0; b < j; ) {

        String Srvs = arrayOfString[b];


        //if (Srvs.contains("ComboFFA_u")) {
            //openGuiNavigator.setItem(i.intValue(), (new ItemBuilder(Material.STAINED_CLAY, 1, (short)5)).setInfinityDurability().setDisplayName(Srvs).lore(new String[] { "§7Mode: §bUnranked", "§7Joueurs: §b" + ON, "§b", "§b§nRejoindre le serveur." }).flag(ItemFlag.HIDE_UNBREAKABLE).flag(ItemFlag.HIDE_ATTRIBUTES).build());
          //i = Integer.valueOf(i.intValue() + 1);

        //if (Srvs.contains("ComboFFA_r")) {

        //openGuiNavigator.setItem(i.intValue(), (new ItemBuilder(Material.STAINED_CLAY, 1, (short)5)).setInfinityDurability().addEnchant(Enchantment.DAMAGE_ALL, 10).setDisplayName(Srvs).lore(new String[] { "§7Mode: §bRanked", "§7Joueurs: §b" + ON, "§b", "§b§nRejoindre le serveur." }).flag(ItemFlag.HIDE_UNBREAKABLE).flag(ItemFlag.HIDE_ATTRIBUTES).build());
          // = Integer.valueOf(i.intValue() + 1);
        b++;
      player.openInventory(openGuiNavigator);
      }
    } 
    if (str == "CC") {
      Inventory openGuiNavigator = Bukkit.createInventory(null, 54, "§6Navigateur §8§l↪ §6Menu principal");
      int ComboFFA = 0;
      for (Map.Entry<String, Integer> set : Main.Onlines.entrySet()) {
        if (((String)set.getKey()).contains("Combo"))
          ComboFFA += ((Integer)set.getValue()).intValue(); 
      } 
      int KnockbackFFA = 0;
      for (Map.Entry<String, Integer> set : Main.Onlines.entrySet()) {
        if (((String)set.getKey()).contains("KnockbackFFA"))
          KnockbackFFA += ((Integer)set.getValue()).intValue(); 
      } 
      openGuiNavigator.setItem(21, (new ItemBuilder(Material.STICK, 0)).setInfinityDurability().setDisplayName("§bKnockbackFFA §8(§bBêta§8)").lore(new String[] { 
              "§8Développeur: iShynss", "§8Version: 1.8.8+", "§b ", "§e§nOjectif:", "§7Dans ce mode de jeu fun et engoissant,", "§7votre mission sera de faire voler vos", "§7adversaire dans l'espace", "§7juste avec un Arc et un baton enchantée.", "§b ", "§7Joueurs: §b" + KnockbackFFA, 
              "§b", "§b§nAfficher les serveurs." }).flag(ItemFlag.HIDE_UNBREAKABLE).flag(ItemFlag.HIDE_ATTRIBUTES).build());
      openGuiNavigator.setItem(23, (new ItemBuilder(Material.SANDSTONE, 0)).setInfinityDurability().setDisplayName("§bBrainFFA").lore(new String[] { "§7" }).flag(ItemFlag.HIDE_UNBREAKABLE).flag(ItemFlag.HIDE_ATTRIBUTES).build());
      openGuiNavigator.setItem(24, (new ItemBuilder(Material.WOOL, 0, (short)14)).setInfinityDurability().setDisplayName("§bBlitzFFA").lore(new String[] { "§7" }).flag(ItemFlag.HIDE_UNBREAKABLE).flag(ItemFlag.HIDE_ATTRIBUTES).build());
      openGuiNavigator.setItem(32, (new ItemBuilder(Material.DIAMOND_SWORD, 0)).setInfinityDurability().setDisplayName("§bPvPBox").lore(new String[] { "§7" }).flag(ItemFlag.HIDE_UNBREAKABLE).flag(ItemFlag.HIDE_ATTRIBUTES).build());
      openGuiNavigator.setItem(20, (new ItemBuilder(Material.RAW_FISH, 1, (short)3)).setInfinityDurability().setDisplayName("§bComboFFA §8(§bBêta§8)").lore(new String[] { 
              "§8Développeur: iShynss", "§8Version: 1.8.8+", "§b ", "§e§nOjectif:", "§7Apparaissez sur une \u00EEle au dessus", "§7du vide pour terasser vos adversaire gr\u00E2ce", "§7\u00E0 vos talent pour ComboFly, il faudra MLG", "§7pour survivre.", "§b ", "§7Joueurs: §b" + ComboFFA, 
              "§b", "§b§nAfficher les serveurs." }).flag(ItemFlag.HIDE_UNBREAKABLE).flag(ItemFlag.HIDE_ATTRIBUTES).build());
      openGuiNavigator.setItem(30, (new ItemBuilder(Material.ELYTRA, 0)).setInfinityDurability().setDisplayName("§bElytraFFA").lore(new String[] { "§7" }).flag(ItemFlag.HIDE_UNBREAKABLE).flag(ItemFlag.HIDE_ATTRIBUTES).build());
      openGuiNavigator.setItem(51, (new ItemBuilder(Material.REDSTONE, 0)).setInfinityDurability().setDisplayName("§dParticules").lore(new String[] { "§7" }).flag(ItemFlag.HIDE_UNBREAKABLE).flag(ItemFlag.HIDE_ATTRIBUTES).build());
      openGuiNavigator.setItem(4, (new ItemBuilder(Material.INK_SACK, 1, (short)10)).setInfinityDurability().setDisplayName("§aChanger de Lobby").flag(ItemFlag.HIDE_UNBREAKABLE).flag(ItemFlag.HIDE_ATTRIBUTES).build());
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
      openGuiNavigator.setItem(47, (new ItemBuilder(Material.EXP_BOTTLE, 0)).setInfinityDurability().setDisplayName("§6Boosters §7(§cProchainement§7)").lore(new String[] { "" }).flag(ItemFlag.HIDE_UNBREAKABLE).flag(ItemFlag.HIDE_ATTRIBUTES).build());
      player.openInventory(openGuiNavigator);
    } 
    if (str == "Lobby") {
      Inventory openGuiNavigator = Bukkit.createInventory(null, 54, "§6Navigateur §8§l↪ §aLobby's");
      openGuiNavigator.setItem(49, (new ItemBuilder(Material.BARRIER, 1)).setInfinityDurability().setDisplayName("§cRetour §8↪ §7Menu Principal").flag(ItemFlag.HIDE_UNBREAKABLE).flag(ItemFlag.HIDE_ATTRIBUTES).build());
      openGuiNavigator.setItem(4, (new ItemBuilder(Material.INK_SACK, 1, (short)10)).setInfinityDurability().setDisplayName("§aChanger de Lobby").flag(ItemFlag.HIDE_UNBREAKABLE).flag(ItemFlag.HIDE_ATTRIBUTES).build());
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
      byte b;
      int j;
      String[] arrayOfString;
      for (j = (arrayOfString = list.split(", ")).length, b = 0; b < j; ) {
        String Srvs = arrayOfString[b];
        if (Srvs.contains("Lobby-")) {
          FileConfiguration configserv = null;
          File filesrv = new File("../SkyCubeYAML/ServerList.yml");
          YamlConfiguration yamlConfiguration2 = YamlConfiguration.loadConfiguration(filesrv);
          Integer ON = Integer.valueOf(yamlConfiguration2.getInt("Server." + Srvs + ".Joueurs"));
          if (yamlConfiguration2.getBoolean("Server." + Srvs + ".Enable")) {
            openGuiNavigator.setItem(i.intValue(), (new ItemBuilder(Material.STAINED_CLAY, 1, (short)5)).setInfinityDurability().setDisplayName(Srvs).lore(new String[] { "§7Status: §aDisponible", "§7Joueurs: §b" + ON, "§b", "§b§nRejoindre le serveur." }).flag(ItemFlag.HIDE_UNBREAKABLE).flag(ItemFlag.HIDE_ATTRIBUTES).build());
          } else {
            openGuiNavigator.setItem(i.intValue(), (new ItemBuilder(Material.STAINED_CLAY, 1, (short)14)).setInfinityDurability().setDisplayName("§c" + Srvs).lore(new String[] { "§7Status: §cIndisponible" }).flag(ItemFlag.HIDE_UNBREAKABLE).flag(ItemFlag.HIDE_ATTRIBUTES).build());
          } 
          i = Integer.valueOf(i.intValue() + 1);
        } 
        b++;
      } 
      player.openInventory(openGuiNavigator);
    } 
  }
  
  @EventHandler
  public void onInteract(PlayerInteractEvent e) throws SQLException {

    ItemStack it = e.getItem();


    if (it == null)
      return;


    Player p = e.getPlayer();
    if (it.hasItemMeta() && it.getItemMeta().hasDisplayName()) {
      String NAME = it.getItemMeta().getDisplayName();
      switch (NAME) {
        case "§cMes Paramètres §8(§7Clic-Droit§8)":
          p.performCommand("/opt");
          break;
        case "§aMes Amis §8(§7Clic-Droit§8)":
          Friends.gui(e.getPlayer());
          break;
        case "§dTéléporteur Céleste §8(§7Clic-Droit§8)":
          break;
        case "§eBoutique §8(§7Clic-Droit§8)":
          Boutique.openGuiBoutique(p, "Main");
          break;
        case "§bNavigateur §8(§7Clic-Droit§8)":
          openGuiNavigator(p, "CC");
          break;
      } 
    } 
  }
  
  @EventHandler
  public void onInventoryDrag(InventoryDragEvent event) {
    event.setCancelled(true);
  }

  @EventHandler
  public void onInv(InventoryMoveItemEvent event) {
    event.setCancelled(true);
  }

  @EventHandler(priority = EventPriority.HIGHEST)
  public void onClickInv(InventoryClickEvent e) {


    Player player = (Player) e.getWhoClicked();

    if (e.getWhoClicked().getGameMode() == GameMode.CREATIVE)
      return;

    e.setCancelled(true);

    String NAME = null;

    if (e.getCurrentItem().getItemMeta() != null) {
      NAME = e.getCurrentItem().getItemMeta().getDisplayName();


      switch (NAME) {
        case "§bGrades":
          Boutique.openGuiBoutique(player, "Grades");
          break;
        case "§dParticules":
          Boutique.openGuiBoutique(player, "Particules");
          break;
        case "§cRetour §8↪ §7Menu Principal":
          openGuiNavigator(player, "CC");
          break;
        case "§aChanger de Lobby":
          openGuiNavigator(player, "Lobby");
          break;
        case "§bComboFFA §8(§bBêta§8)":
          openGuiNavigator(player, "ComboFFA");
          break;
      }


      if (e.getCurrentItem().getType().equals(Material.STAINED_CLAY)) {
        ByteArrayOutputStream b = new ByteArrayOutputStream();
        DataOutputStream out = new DataOutputStream(b);
        String ez = e.getCurrentItem().getItemMeta().getDisplayName();
        try {
          out.writeUTF("Connect");
          out.writeUTF(ez);
          player.sendPluginMessage((Plugin) Main.getInstance(), "BungeeCord", b.toByteArray());
        } catch (IOException e1) {
          e1.printStackTrace();
        }
      }
    }
  }

}
