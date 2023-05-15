package fun.slowfeew;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
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
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

public class SaveMenu implements Listener, CommandExecutor {
  private Main main;
  
  public SaveMenu(Main main) {
    this.main = main;
  }
  
  public void openGuiNavigator(Player player, String str) {
    FileConfiguration configssss = null;
    File filessss = new File("../SkyCubeYAML/PlayersOnline.yml");
    YamlConfiguration yamlConfiguration = YamlConfiguration.loadConfiguration(filessss);
    String lists = yamlConfiguration.getString("Servers");
    byte b;
    int i;
    String[] arrayOfString;
    for (i = (arrayOfString = lists.split(", ")).length, b = 0; b < i; ) {
      String Srvss = arrayOfString[b];
      GetServerOnline(Srvss, player);
      b++;
    } 
    if (str == "ComboFFA") {
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
      Integer integer = Integer.valueOf(20);
      byte b1;
      int j;
      String[] arrayOfString1;
      for (j = (arrayOfString1 = list.split(", ")).length, b1 = 0; b1 < j; ) {
        String Srvs = arrayOfString1[b1];
        if (Srvs.contains("ComboFFA_u")) {
          CheckOnline(Srvs);
          Integer ON = Main.Onlines.get(Srvs);
          if (Main.ServerIsOnline.containsKey(Srvs))
            openGuiNavigator.setItem(integer.intValue(), (new ItemBuilder(Material.STAINED_CLAY, 1, (short)5)).setInfinityDurability().setDisplayName(Srvs).lore(new String[] { "\u00A77Mode: \u00A7bUnranked", "\u00A77Joueurs: \u00A7b" + ON, "\u00A7b", "\u00A7b\u00A7nRejoindre le serveur." }).flag(ItemFlag.HIDE_UNBREAKABLE).flag(ItemFlag.HIDE_ATTRIBUTES).build()); 
          integer = Integer.valueOf(integer.intValue() + 1);
        } 
        if (Srvs.contains("ComboFFA_r")) {
          CheckOnline(Srvs);
          Integer ON = Main.Onlines.get(Srvs);
          if (Main.ServerIsOnline.containsKey(Srvs))
            openGuiNavigator.setItem(integer.intValue(), (new ItemBuilder(Material.STAINED_CLAY, 1, (short)5)).setInfinityDurability().addEnchant(Enchantment.DAMAGE_ALL, 10).setDisplayName(Srvs).lore(new String[] { "\u00A77Mode: \u00A7bRanked", "\u00A77Joueurs: \u00A7b" + ON, "\u00A7b", "\u00A7b\u00A7nRejoindre le serveur." }).flag(ItemFlag.HIDE_UNBREAKABLE).flag(ItemFlag.HIDE_ATTRIBUTES).build()); 
          integer = Integer.valueOf(integer.intValue() + 1);
        } 
        b1++;
      } 
      player.openInventory(openGuiNavigator);
    } 
    if (str == "CC") {
      Inventory openGuiNavigator = Bukkit.createInventory(null, 54, "\u00A76Navigateur \u00A78\u00A7l\u21AA \u00A76Menu principal");
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
      openGuiNavigator.setItem(21, (new ItemBuilder(Material.STICK, 0)).setInfinityDurability().setDisplayName("\u00A7bKnockbackFFA \u00A78(\u00A7bB\u00EAta\u00A78)").lore(new String[] { 
              "\u00A78D\u00E9veloppeur: iShynss", "\u00A78Version: 1.8.8+", "\u00A7b ", "\u00A7e\u00A7nOjectif:", "\u00A77Dans ce mode de jeu fun et engoissant,", "\u00A77votre mission sera de faire voler vos", "\u00A77adversaire dans l'espace", "\u00A77juste avec un Arc et un baton enchant\u00E9e.", "\u00A7b ", "\u00A77Joueurs: \u00A7b" + KnockbackFFA, 
              "\u00A7b", "\u00A7b\u00A7nAfficher les serveurs." }).flag(ItemFlag.HIDE_UNBREAKABLE).flag(ItemFlag.HIDE_ATTRIBUTES).build());
      openGuiNavigator.setItem(23, (new ItemBuilder(Material.SANDSTONE, 0)).setInfinityDurability().setDisplayName("\u00A7bBrainFFA").lore(new String[] { "\u00A77" }).flag(ItemFlag.HIDE_UNBREAKABLE).flag(ItemFlag.HIDE_ATTRIBUTES).build());
      openGuiNavigator.setItem(24, (new ItemBuilder(Material.WOOL, 0, (short)14)).setInfinityDurability().setDisplayName("\u00A7bBlitzFFA").lore(new String[] { "\u00A77" }).flag(ItemFlag.HIDE_UNBREAKABLE).flag(ItemFlag.HIDE_ATTRIBUTES).build());
      openGuiNavigator.setItem(32, (new ItemBuilder(Material.DIAMOND_SWORD, 0)).setInfinityDurability().setDisplayName("\u00A7bPvPBox").lore(new String[] { "\u00A77" }).flag(ItemFlag.HIDE_UNBREAKABLE).flag(ItemFlag.HIDE_ATTRIBUTES).build());
      openGuiNavigator.setItem(20, (new ItemBuilder(Material.RAW_FISH, 1, (short)3)).setInfinityDurability().setDisplayName("\u00A7bComboFFA \u00A78(\u00A7bB\u00EAta\u00A78)").lore(new String[] { 
              "\u00A78D\u00E9veloppeur: iShynss", "\u00A78Version: 1.8.8+", "\u00A7b ", "\u00A7e\u00A7nOjectif:", "\u00A77Apparaissez sur une \u00EEle au dessus", "\u00A77du vide pour terasser vos adversaire gr\u00E2ce", "\u00A77\u00E0 vos talent pour ComboFly, il faudra MLG", "\u00A77pour survivre.", "\u00A7b ", "\u00A77Joueurs: \u00A7b" + ComboFFA, 
              "\u00A7b", "\u00A7b\u00A7nAfficher les serveurs." }).flag(ItemFlag.HIDE_UNBREAKABLE).flag(ItemFlag.HIDE_ATTRIBUTES).build());
      openGuiNavigator.setItem(30, (new ItemBuilder(Material.ELYTRA, 0)).setInfinityDurability().setDisplayName("\u00A7bElytraFFA").lore(new String[] { "\u00A77" }).flag(ItemFlag.HIDE_UNBREAKABLE).flag(ItemFlag.HIDE_ATTRIBUTES).build());
      openGuiNavigator.setItem(51, (new ItemBuilder(Material.REDSTONE, 0)).setInfinityDurability().setDisplayName("\u00A7dParticules").lore(new String[] { "\u00A77" }).flag(ItemFlag.HIDE_UNBREAKABLE).flag(ItemFlag.HIDE_ATTRIBUTES).build());
      openGuiNavigator.setItem(4, (new ItemBuilder(Material.INK_SACK, 1, (short)10)).setInfinityDurability().setDisplayName("\u00A7aChanger de Lobby").flag(ItemFlag.HIDE_UNBREAKABLE).flag(ItemFlag.HIDE_ATTRIBUTES).build());
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
      openGuiNavigator.setItem(47, (new ItemBuilder(Material.EXP_BOTTLE, 0)).setInfinityDurability().setDisplayName("\u00A76Boosters \u00A77(\u00A7cProchainement\u00A77)").lore(new String[] { "" }).flag(ItemFlag.HIDE_UNBREAKABLE).flag(ItemFlag.HIDE_ATTRIBUTES).build());
      player.openInventory(openGuiNavigator);
    } 
    if (str == "Lobby") {
      Inventory openGuiNavigator = Bukkit.createInventory(null, 54, "\u00A76Navigateur \u00A78\u00A7l\u21AA \u00A7aLobby's");
      openGuiNavigator.setItem(49, (new ItemBuilder(Material.BARRIER, 1)).setInfinityDurability().setDisplayName("\u00A7cRetour \u00A78\u21AA \u00A77Menu Principal").flag(ItemFlag.HIDE_UNBREAKABLE).flag(ItemFlag.HIDE_ATTRIBUTES).build());
      openGuiNavigator.setItem(4, (new ItemBuilder(Material.INK_SACK, 1, (short)10)).setInfinityDurability().setDisplayName("\u00A7aChanger de Lobby").flag(ItemFlag.HIDE_UNBREAKABLE).flag(ItemFlag.HIDE_ATTRIBUTES).build());
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
      Integer integer = Integer.valueOf(20);
      byte b1;
      int j;
      String[] arrayOfString1;
      for (j = (arrayOfString1 = list.split(", ")).length, b1 = 0; b1 < j; ) {
        String Srvs = arrayOfString1[b1];
        if (Srvs.contains("Lobby-")) {
          CheckOnline(Srvs);
          Integer ON = Main.Onlines.get(Srvs);
          if (Main.ServerIsOnline.containsKey(Srvs)) {
            openGuiNavigator.setItem(integer.intValue(), (new ItemBuilder(Material.STAINED_CLAY, 1, (short)5)).setInfinityDurability().setDisplayName(Srvs).lore(new String[] { "\u00A77Status: \u00A7aDisponible", "\u00A77Joueurs: \u00A7b" + ON, "\u00A7b", "\u00A7b\u00A7nRejoindre le serveur." }).flag(ItemFlag.HIDE_UNBREAKABLE).flag(ItemFlag.HIDE_ATTRIBUTES).build());
          } else {
            openGuiNavigator.setItem(integer.intValue(), (new ItemBuilder(Material.STAINED_CLAY, 1, (short)14)).setInfinityDurability().setDisplayName("\u00A7c" + Srvs).lore(new String[] { "\u00A77Status: \u00A7cIndisponible" }).flag(ItemFlag.HIDE_UNBREAKABLE).flag(ItemFlag.HIDE_ATTRIBUTES).build());
          } 
          integer = Integer.valueOf(integer.intValue() + 1);
        } 
        b1++;
      } 
      player.openInventory(openGuiNavigator);
    } 
  }
  
  public void GetServerOnline(final String srv, Player p) {
    if (Main.ServerIsOnline.containsKey(srv))
      Main.ServerIsOnline.remove(srv); 
    ByteArrayDataOutput out = ByteStreams.newDataOutput();
    out.writeUTF("ServerIP");
    out.writeUTF(srv);
    p.sendPluginMessage((Plugin)Main.getInstance(), "BungeeCord", out.toByteArray());
    Bukkit.getScheduler().runTaskLater((Plugin)this.main, new Runnable() {
          public void run() {
            SaveMenu.this.CheckOnline(srv);
          }
        },  9L);
  }
  
  protected void CheckOnline(String srv) {
    try {
      String ip = Main.ServerIP.get(srv);
      Integer port = Main.IPtoPort.get(srv);
      Socket s = new Socket(ip, port.intValue());
      s.close();
      Main.ServerIsOnline.put(srv, Boolean.valueOf(true));
    } catch (UnknownHostException ignored) {
      Main.ServerIsOnline.remove(srv);
    } catch (IOException ignored) {
      Main.ServerIsOnline.remove(srv);
    } 
  }
  
  @EventHandler
  public void onInteract(PlayerInteractEvent e) {
    ItemStack it = e.getItem();
    if (it == null)
      return; 
    Player p = e.getPlayer();
    if (it.hasItemMeta() && it.getItemMeta().hasDisplayName()) {
      String NAME = it.getItemMeta().getDisplayName();
      String str1;
      switch ((str1 = NAME).hashCode()) {
        case -1982468697:
          if (!str1.equals("\u00A7cMes Param\u00E8tres \u00A78(\u00A77Clic-Droit\u00A78)"))
            break; 
          p.performCommand("/opt");
          break;
        case -1967638630:
          if (!str1.equals("\u00A7aMes Amis \u00A78(\u00A77Clic-Droit\u00A78)"))
            break; 
          break;
        case -592584392:
          if (!str1.equals("\u00A7dT\u00E9l\u00E9porteur C\u00E9leste \u00A78(\u00A77Clic-Droit\u00A78)"))
            break; 
          e.getPlayer().getInventory().setItem(1, (new ItemBuilder(Material.SNOW_BALL, 1)).setInfinityDurability().setDisplayName("\u00A7dT\u00E9l\u00E9porteur C\u00E9leste \u00A78(\u00A77Clic-Droit\u00A78)").flag(ItemFlag.HIDE_UNBREAKABLE).flag(ItemFlag.HIDE_ATTRIBUTES).build());
          break;
        case 1091173549:
          if (!str1.equals("\u00A7eBoutique \u00A78(\u00A77Clic-Droit\u00A78)"))
            break; 
          Boutique.openGuiBoutique(p, "Main");
          break;
        case 1453727910:
          if (!str1.equals("\u00A7bNavigateur \u00A78(\u00A77Clic-Droit\u00A78)"))
            break; 
          openGuiNavigator(p, "CC");
          break;
      } 
    } 
  }
  
  @EventHandler
  public void onClickInv(InventoryClickEvent e) {
    Player player = (Player)e.getWhoClicked();
    if (e.getCurrentItem() == null)
      return; 
    if (!player.getGameMode().equals(GameMode.CREATIVE))
      e.setCancelled(true); 
    if (e.getCurrentItem() == null)
      return; 
    String NAME = e.getCurrentItem().getItemMeta().getDisplayName();
    String str1;
    switch ((str1 = NAME).hashCode()) {
      case -2086462473:
        if (!str1.equals("\u00A7bGrades"))
          break; 
        Boutique.openGuiBoutique(player, "Grades");
        break;
      case -1500924977:
        if (!str1.equals("\u00A7dParticules"))
          break; 
        Boutique.openGuiBoutique(player, "Particules");
        break;
      case -1445585731:
        if (!str1.equals("\u00A7cRetour \u00A78\u21AA \u00A77Menu Principal"))
          break; 
        openGuiNavigator(player, "CC");
        break;
      case 1022182319:
        if (!str1.equals("\u00A7aChanger de Lobby"))
          break; 
        openGuiNavigator(player, "Lobby");
        break;
      case 1305774435:
        if (!str1.equals("\u00A7bComboFFA \u00A78(\u00A7bB\u00EAta\u00A78)"))
          break; 
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
        player.sendPluginMessage((Plugin)Main.getInstance(), "BungeeCord", b.toByteArray());
      } catch (IOException e1) {
        e1.printStackTrace();
      } 
    } 
  }
  
  public boolean onCommand(CommandSender sender, Command cmd, String arg, String[] args) {
    if (cmd.getName().equalsIgnoreCase("opengui") && 
      args.length == 1)
      openGuiNavigator((Player)sender, args[0]); 
    return false;
  }
}
