package fun.slowfeew;

import java.io.File;

import fun.slowfeew.Utils.ItemBuilder;
import fun.slowfeew.scoreboard.ScoreboardManager;
import org.bukkit.*;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.*;
import org.bukkit.event.weather.WeatherChangeEvent;
import org.bukkit.inventory.ItemFlag;
import sun.security.action.GetPropertyAction;

public class Events implements Listener {

  private final Main main;

  public Events(Main main) {
    this.main = main;
  }
  @EventHandler
  public void onQuit(PlayerQuitEvent c) {
    c.setQuitMessage("");
    Main.getInstance().getScoreboardManager().onLogout(c.getPlayer());
  }

  @EventHandler
  public void onJoin(PlayerJoinEvent c) {


    Player e = c.getPlayer();

    c.setJoinMessage(null);
    Main.getInstance().getScoreboardManager().onLogin(e);
    e.getInventory().clear();

    Boolean Mod = false;
    if (Mod.booleanValue()) {
      return;
      }

      this.main.getScoreboardManager().onLogin(e);
      e.playNote(e.getLocation(), Instrument.PIANO, Note.flat(1, Note.Tone.F));
      e.setGameMode(GameMode.ADVENTURE);

      String prefix = GetPrefix.getPrefix(e);
      if (!c.getPlayer().hasPlayedBefore()) {
        Bukkit.broadcastMessage("§6➠ §7Nous souhaitons la bienvenue à §r" + prefix.replaceAll("&", "§") + c.getPlayer().getName() + "§7 qui fait son entrée au §eParadis §7!");
      } else if (e.hasPermission("ANNOUNCE_JOIN")) {
        Bukkit.broadcastMessage("§8• §r" + prefix.replaceAll("&", "§") + e.getName() + " §fa rejoint le §6Lobby §f!");
      }


      Location loc = new Location(e.getWorld(), -1473.5D, 32.0D, 196.5D, 50.0F, 0.0F);

      e.getPlayer().teleport(loc);

      e.sendTitle("§bSky§fCube", "§7Bienvenue à toi, jeune voyageur.");

      e.getInventory().clear();
      e.getInventory().setItem(0, (new ItemBuilder(Material.ENDER_CHEST, 1)).setInfinityDurability().setDisplayName("§eBoutique §8(§7Clic-Droit§8)").flag(ItemFlag.HIDE_UNBREAKABLE).flag(ItemFlag.HIDE_ATTRIBUTES).build());
      e.getInventory().setItem(1, (new ItemBuilder(Material.SNOW_BALL, 1)).setInfinityDurability().setDisplayName("§dTéléporteur Céleste §8(§7Clic-Droit§8)").flag(ItemFlag.HIDE_UNBREAKABLE).flag(ItemFlag.HIDE_ATTRIBUTES).build());
      e.getInventory().setItem(4, (new ItemBuilder(Material.ARROW, 1)).setInfinityDurability().setDisplayName("§bNavigateur §8(§7Clic-Droit§8)").flag(ItemFlag.HIDE_UNBREAKABLE).flag(ItemFlag.HIDE_ATTRIBUTES).build());
      e.getInventory().setItem(7, (new ItemBuilder(Material.RAW_FISH, 1, (short) 2)).setInfinityDurability().setDisplayName("§aMes Amis §8(§7Clic-Droit§8)").flag(ItemFlag.HIDE_UNBREAKABLE).flag(ItemFlag.HIDE_ATTRIBUTES).build());
      e.getInventory().setItem(8, (new ItemBuilder(Material.REDSTONE_COMPARATOR, 1)).setInfinityDurability().setDisplayName("§cMes Paramètres §8(§7Clic-Droit§8)").flag(ItemFlag.HIDE_UNBREAKABLE).flag(ItemFlag.HIDE_ATTRIBUTES).build());

  }

  @EventHandler
  public void OnBreak(BlockBreakEvent e) {
    if (e.getPlayer().getGameMode() == GameMode.CREATIVE)
      return;
    e.setCancelled(true);
  }

  @EventHandler
  public void OnPlace(BlockPlaceEvent e) {
    if (e.getPlayer().getGameMode() == GameMode.CREATIVE)
      return;
    e.setCancelled(true);
  }

  @EventHandler(priority = EventPriority.HIGH, ignoreCancelled = false)
  public void onDrop(PlayerDropItemEvent e) {
    Player p = e.getPlayer();
    if (e.getPlayer().getGameMode() == GameMode.CREATIVE)
      return;
    e.setCancelled(true);
  }

  @EventHandler
  public void OnDamage(EntityDamageEvent e) {
    e.setCancelled(true);
  }

  @EventHandler
  public void OnSwitch(PlayerSwapHandItemsEvent e) {
    if (e.getPlayer().getGameMode() == GameMode.CREATIVE)
      return;
    e.setCancelled(true);
  }

  @EventHandler
  public void onFoodLevelChange(FoodLevelChangeEvent event) {
    if (event.getEntity() instanceof Player) {
      Player player = (Player) event.getEntity();
      event.setCancelled(true); // Annuler le changement de niveau de nourriture
      player.setFoodLevel(20); // Maintenir le niveau de nourriture constant
    }
  }

  @EventHandler(priority = EventPriority.HIGHEST)
  public void DisableWeather(WeatherChangeEvent event) {
    event.setCancelled(event.toWeatherState());
  }

  @EventHandler
  public void onPickup(PlayerPickupItemEvent e) {
    if (e.getPlayer().getGameMode() == GameMode.CREATIVE)
      return;
    e.setCancelled(true);
  }

}
