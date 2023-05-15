package fun.slowfeew;

import java.util.HashMap;
import java.util.Map;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.BlockFace;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.potion.PotionEffectType;

public class Jump implements Listener, CommandExecutor {
  public static Map<Player, Boolean> isJump = new HashMap<>();
  
  @EventHandler
  public void onPlayerMove(PlayerMoveEvent event) {
    Player p = event.getPlayer();
    //if (Main.getMod3.containsKey(p))
      //return;
    if (event.getTo().getBlock().getRelative(BlockFace.DOWN).getType() == Material.REDSTONE_BLOCK)
      if (!isJump.containsKey(p)) {
        isJump.put(p, Boolean.valueOf(true));
        p.getPlayer().removePotionEffect(PotionEffectType.SPEED);
        p.sendTitle("§aBonne chance !", "§7Vous avez rejoint le §bJump des Dieux§7.");
      }  
    if (event.getTo().getBlock().getRelative(BlockFace.DOWN).getType() == Material.EMERALD_BLOCK)
      if (!isJump.containsKey(p)) {
        isJump.remove(p);
        p.getPlayer().removePotionEffect(PotionEffectType.SPEED);
        p.sendTitle("§6Bravo !!", "§7Vous avez réussi le §bJump des Dieux§7.");
        Location loc = new Location(p.getWorld(), -232.5D, 92.0D, -523.5D, -90.0F, -4.0F);
        p.teleport(loc);
      }  
  }
  
  public boolean onCommand(CommandSender sender, Command cmd, String arg, String[] args) {
    if (!(sender instanceof Player))
      return false; 
    if (cmd.getName().equalsIgnoreCase("jump")) {
      //if (Main.getMod3.containsKey(sender))
        //return false;
      if (args.length < 1) {
        sender.sendMessage("§cSyntaxe: /jump <spawn|leave|join>");
      } else if (args.length == 1) {
        if (args[0].contains("leave"))
          if (isJump.containsKey(sender)) {
            isJump.remove(sender);
            ((Player)sender).sendTitle("§cUn RageQuit ?", "§7Reviens quand tu veux !");
            Location loc = new Location(((Player)sender).getWorld(), -232.5D, 92.0D, -523.5D, -90.0F, -4.0F);
            ((Player)sender).teleport(loc);
          } else {
            sender.sendMessage("§cErreur: Vous devez avoir rejoint le jump pour faire cela.");
          }  
        if (args[0].contains("join"))
          if (!isJump.containsKey(sender)) {
            isJump.put((Player)sender, Boolean.valueOf(true));
            ((Player)sender).sendTitle("§aBonne chance !", "§7Vous avez rejoint le §bJump des Dieux§7.");
            Location loc = new Location(((Player)sender).getWorld(), -106.5D, 69.0D, -523.5D, 90.0F, -6.0F);
            ((Player)sender).teleport(loc);
          } else {
            sender.sendMessage("§cErreur: Vous avez déjà rejoint le jump.");
          }  
        if (args[0].contains("spawn"))
          if (isJump.containsKey(sender)) {
            ((Player)sender).sendTitle("§cDommage...", "§7Retente ta chance..");
            Location loc = new Location(((Player)sender).getWorld(), -106.5D, 69.0D, -523.5D, 90.0F, -6.0F);
            ((Player)sender).teleport(loc);
          } else {
            sender.sendMessage("§cErreur: Vous devez avoir rejoint le jump pour faire cela.");
          }  
      } 
    } 
    return false;
  }
}
