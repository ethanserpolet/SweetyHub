package fun.slowfeew;

import fun.slowfeew.Utils.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.bukkit.projectiles.ProjectileSource;

import java.util.HashMap;

public class Launcher implements Listener {


    private Main main;

    public Launcher(Main main) {
        this.main = main;
    }
    @EventHandler
    public void onProjectileLaunch(ProjectileLaunchEvent event) {
        Projectile projectile = event.getEntity();
        if (projectile instanceof Snowball) {
            Snowball snowball = (Snowball) projectile;
            ProjectileSource shooter = snowball.getShooter();
            if (shooter instanceof Player) {
                Player player = (Player) shooter;
                ItemStack originalItem = player.getInventory().getItemInMainHand();
                projectile.setPassenger(player);

                Bukkit.getScheduler().runTaskLaterAsynchronously(Main.getInstance(), () -> {
                    // Restaurer la boule de neige avec le même nom après 5 secondes
                    player.getPlayer().getInventory().setItem(1, (new ItemBuilder(Material.SLIME_BALL, 1)).setInfinityDurability().setDisplayName("§cTéléporteur Céleste §8(§7Cooldown§8)").flag(ItemFlag.HIDE_UNBREAKABLE).flag(ItemFlag.HIDE_ATTRIBUTES).build());
                }, 5L);
                // Remplacer la boule de neige par une slimeball pendant 5 secondes


                Bukkit.getScheduler().runTaskLaterAsynchronously(Main.getInstance(), () -> {
                    // Restaurer la boule de neige avec le même nom après 5 secondes
                    player.getPlayer().getInventory().setItem(1, (new ItemBuilder(Material.SNOW_BALL, 1)).setInfinityDurability().setDisplayName("§dTéléporteur Céleste §8(§7Clic-Droit§8)").flag(ItemFlag.HIDE_UNBREAKABLE).flag(ItemFlag.HIDE_ATTRIBUTES).build());
                }, 75L);
            }
        }
    }

}
