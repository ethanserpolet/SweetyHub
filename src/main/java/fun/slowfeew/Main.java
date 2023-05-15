package fun.slowfeew;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import fun.slowfeew.Utils.ItemBuilder;
import fun.slowfeew.scoreboard.ScoreboardManager;
import net.milkbowl.vault.chat.Chat;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.command.CommandExecutor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.event.weather.WeatherChangeEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.messaging.PluginMessageListener;
import org.bukkit.projectiles.ProjectileSource;
import org.bukkit.scheduler.BukkitRunnable;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.Socket;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

import static org.bukkit.Bukkit.getLogger;

public class Main extends JavaPlugin implements Listener, CommandExecutor, PluginMessageListener {
  private static Main instance;
  
  public static Map<String, Integer> Onlines = new HashMap<>();
  
  public static Map<String, String> ServerIP = new HashMap<>();
  
  public static Map<String, Boolean> ServerIsOnline = new HashMap<>();
  
  public static Map<String, Integer> IPtoPort = new HashMap<>();
  
  private static Plugin plugin;

  public static Integer ONLINE;
  
  public Chat chat;
  
  private ScoreboardManager scoreboardManager;
  
  private ScheduledExecutorService executorMonoThread;
  
  private ScheduledExecutorService scheduledExecutorService;
  
  private boolean setupChat() {
    RegisteredServiceProvider<Chat> rsp = getServer().getServicesManager().getRegistration(Chat.class);
    this.chat = (Chat)rsp.getProvider();
    return (this.chat != null);
  }
  
  public Chat getChat() {
    return this.chat;
  }
  
  public ScoreboardManager getScoreboardManager() {
    return this.scoreboardManager;
  }
  
  public ScheduledExecutorService getExecutorMonoThread() {
    return this.executorMonoThread;
  }
  
  public ScheduledExecutorService getScheduledExecutorService() {
    return this.scheduledExecutorService;
  }
  
  public void onEnable() {
    instance = this;


    getServer().getPluginManager().registerEvents(this, (Plugin)this);
    getServer().getPluginManager().registerEvents(new Events(this), (Plugin)this);
    getServer().getPluginManager().registerEvents(new Menu(this), (Plugin)this);
    getServer().getPluginManager().registerEvents(new Boutique(), (Plugin)this);
    getServer().getPluginManager().registerEvents (new Launcher(this), (Plugin)this);


    this.scheduledExecutorService = Executors.newScheduledThreadPool(16);
    this.executorMonoThread = Executors.newScheduledThreadPool(1);
    this.scoreboardManager = new ScoreboardManager();


    getServer().getWorld("world").setGameRuleValue("doDaylightCycle", "false");
    getServer().getWorld("world").setGameRuleValue("doWeatherCycle", "false");
    getServer().getWorld("world").setGameRuleValue("announceAdvancements", "false");
    getServer().getWorld("world").setGameRuleValue("doEntityDrops", "false");
    getServer().getWorld("world").setGameRuleValue("doMobSpawning", "false");

    setupChat();

    getServer().getMessenger().registerOutgoingPluginChannel((Plugin)this, "BungeeCord");
    getServer().getMessenger().registerIncomingPluginChannel((Plugin)this, "BungeeCord", this);
    plugin = (Plugin)this;

    Bukkit.getServer().getScheduler().runTaskTimerAsynchronously((Plugin)this, new Runnable() {
          public void run() {
            for (World w : Bukkit.getServer().getWorlds())
              w.setTime(0L); 
          }
        },  0L, 10000L);

    Bukkit.getScheduler().runTaskTimerAsynchronously((Plugin) this, new Runnable() {
      public void run() {
        for (Player player : Bukkit.getOnlinePlayers()) {
          if (player.getLocation().getY() < 8.0D) {
            Location loc = new Location(player.getWorld(), -232.5D, 92.0D, -523.5D, -90.0F, -4.0F);
            player.teleport(loc);
          }
        }
      }
    }, 10L, 10L);

    ping();


  }

  public void ping() {
    new BukkitRunnable() {
      @Override
      public void run() {
        String serverAddress = "funcraft.net";
        int port = 25565;

        try {
          Socket socket = new Socket(serverAddress, port);
          DataOutputStream out = new DataOutputStream(socket.getOutputStream());
          DataInputStream in = new DataInputStream(socket.getInputStream());

          out.write(0xFE);

          int b;
          StringBuilder str = new StringBuilder();

          while ((b = in.read()) != -1) {
            if (b != 0 && b > 16 && b != 255 && b != 23 && b != 24) {
              str.append((char) b);
            }
          }

          String[] data = str.toString().split("\u00a7");
          int onlinePlayers = Integer.parseInt(data[1]);
          int maxPlayers = Integer.parseInt(data[2]);


          ONLINE = onlinePlayers;
          out.close();
          in.close();
          socket.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }.runTaskTimerAsynchronously(this, 0L, 80L); // Run every 4 seconds
  }
  
  public static Main getInstance() {
    return instance;
  }
  

  public void onDisable() {
    getScoreboardManager().onDisable();
  }


  public void onPluginMessageReceived(String channel, Player player, byte[] message) {
    if (!channel.equals("BungeeCord"))
      return; 
    ByteArrayDataInput in = ByteStreams.newDataInput(message);
    String subchannel = in.readUTF();
    if (subchannel.equals("ServerIP"))
      try {
        String serverName1 = in.readUTF();
        String ip = in.readUTF();
        Integer port = Integer.valueOf(in.readUnsignedShort());
        if (ServerIP.containsKey(serverName1)) {
          ServerIP.replace(serverName1, ip);
        } else {
          ServerIP.put(serverName1, ip);
        } 
        if (IPtoPort.containsKey(serverName1)) {
          IPtoPort.replace(serverName1, port);
        } else {
          IPtoPort.put(serverName1, port);
        } 
      } catch (Exception exception) {} 
    if (subchannel.equals("PlayerCount"))
      try {
        String server = in.readUTF();
        int playercount = in.readInt();
        if (Onlines.containsKey(server))
          Onlines.remove(server); 
        Onlines.put(server, Integer.valueOf(playercount));
      } catch (Exception exception) {} 
  }
}
