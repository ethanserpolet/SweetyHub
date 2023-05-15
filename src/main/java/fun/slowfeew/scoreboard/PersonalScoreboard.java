package fun.slowfeew.scoreboard;

import java.io.File;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

import fun.slowfeew.GetPrefix;
import fun.slowfeew.Main;
import fun.slowfeew.Utils.ProgressBar;
import fun.slowfeew.Utils.SQL;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class PersonalScoreboard {
  private final Player player;
  
  private final ObjectiveSign objectiveSign;
  
  static Map<Player, Integer> KS = new HashMap<>();
  
  private static final DecimalFormat df2 = new DecimalFormat("#.##");
  
  PersonalScoreboard(Player player) {
    this.player = player;
    this.objectiveSign = new ObjectiveSign("sidebar", "DevPlugin");
    reloadData();
    this.objectiveSign.addReceiver((OfflinePlayer)player);
  }
  
  public void reloadData() {}
  
  public void setLines(String ip) {

    Player p = this.player;

    String MySRV = String.valueOf(SQL.getServer(p.getName(), null));

    String input = MySRV;
    String[] parts = input.split("lobby", 2);

    String result = null;

    if (parts.length > 1) {
      result = parts[1];
    } else {
    }
    if(result == null) {
      result = "X";
    }

    String prefix = GetPrefix.getPrefix(this.player);
    String level = String.valueOf(SQL.getLevel(p.getName(), null));
    String cerise = String.valueOf(SQL.getCerise(p.getName(), null));
    String solde = String.valueOf(SQL.getYen(p.getName(), null));
    Double xp = SQL.getExp(p.getName(), null);

    assert prefix != null;


    String bar = ProgressBar.getProgressBar(xp + 1.0, SQL.getRequired(p.getName()), 25, '|', ChatColor.GREEN, ChatColor.GRAY);

    this.objectiveSign.setDisplayName("§7• §dOsakaLand §7•");
    this.objectiveSign.setLine(0, "§8");
    this.objectiveSign.setLine(1, "§d§l" + this.player.getName());
    this.objectiveSign.setLine(2, "§8• §7Rang: " + prefix.replaceAll("&", "§"));
    this.objectiveSign.setLine(3, "§8• §7Solde: §e" + solde + "¥");
    this.objectiveSign.setLine(4, "§8• §7Cerise: §c" + cerise);
    this.objectiveSign.setLine(5, "§d ");
    this.objectiveSign.setLine(6, "§d§lNiveau: §6" + level);
    this.objectiveSign.setLine(7, "§8[" + bar + "§8]");
    this.objectiveSign.setLine(8, "§7");
    this.objectiveSign.setLine(9, "§d§lLobby: §b#" + result);
    this.objectiveSign.setLine(10, "§8• §7Connectés: §a" + Bukkit.getServer().getOnlinePlayers().size() + "§7/" + Main.ONLINE );
    this.objectiveSign.setLine(11, "");
    this.objectiveSign.setLine(12, "§dplay.osaka.land");
    this.objectiveSign.updateLines();
  }
  
  public void onLogout() {
    this.objectiveSign.removeReceiver((OfflinePlayer)Bukkit.getPlayer(this.player.getDisplayName()));
  }
}
