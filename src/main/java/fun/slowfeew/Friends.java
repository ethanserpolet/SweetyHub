package fun.slowfeew;

import fun.slowfeew.Utils.ItemBuilder;
import fun.slowfeew.Utils.SQL;
import fun.slowfeew.sql.DatabaseManager;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemFlag;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class Friends {

    public static void gui(Player p) {


        List<String> all = new ArrayList<String>();

        all = new ArrayList<String>(Objects.requireNonNull(SQL.getFriends(p.getName(), null)));

        if(all.isEmpty()) {
            p.sendMessage(" ");
            p.sendMessage("§dSatsuki §8| §8Vous n'avez aucun ami");
            p.sendMessage("§7§n(Faites '/f' pour ajouter un ami)");
            p.sendMessage(" ");
            return;
        }




        final Inventory friend = Bukkit.createInventory((InventoryHolder)null, 54, "§dSatsuki §8| §7Vos Amis.");



        List<String> online = new ArrayList<>();
        List<String> offline = new ArrayList<>();
        Map<String, String> lastlog = new HashMap<>();
        Map<String, String> server = new HashMap<>();

        for (String pl : all) {

            try {
            Connection connection = DatabaseManager.Osaka2.getDatabaseAccess().getConnection();
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM `General` WHERE `Player` = ?");

            ps.setString(1, String.valueOf(pl));

            ResultSet rs = ps.executeQuery();



                while (rs.next()) {

                    int okk = rs.getInt("ONLINE");
                    String bzz = rs.getString("LASTLOGIN");
                    String bzz2 = rs.getString("SERVER");


                    if (okk == 1) {
                        online.add(pl);
                        server.put(pl, bzz2);

                    } else {
                        offline.add(pl);
                        lastlog.put(pl, bzz);
                    }

                }
                rs.close();
                ps.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();

            }


        }
        int i = 0;


        if(online.size() != 0) {
            for (String p5 : online) {

                List<String> lore = new ArrayList<>();

                lore.add("§8[§a✔§8] §7Serveur: §d" + server.get(p5));
                lore.add("§d");
                lore.add("§7➥ Clic droit pour rejoindre");
                lore.add("§7➥ Clic gauche pour inviter au groupe");

                friend.setItem(i, new ItemBuilder(Material.SKULL_ITEM, 1, (short) 3).setSkullOwner(p5).setLoreWithList(lore).setInfinityDurability().setDisplayName("§8➟ §d " + p5).flag(ItemFlag.HIDE_UNBREAKABLE).flag(ItemFlag.HIDE_ATTRIBUTES).build());


                i++;
            }


        }

        int i2 = 0;
        if(online.size() != 0) {
            int i3 = online.size() / 8;

            if (i3 <= 1) {
                i2 = 9;
            }

            if (i3 <= 2) {
                if (i3 > 1) {
                    i2 = 18;
                }
            }

            if (i3 <= 3) {
                if (i3 > 2) {
                    i2 = 27;
                }
            }

            if (i3 <= 4) {
                if (i3 > 3) {
                    i2 = 36;
                }
            }


            if (i3 <= 5) {
                if (i3 > 4) {
                    i2 = 45;
                }
            }

        }

        for (String p6 : offline) {

            friend.setItem(i2, new ItemBuilder(Material.SKULL_ITEM, 1, (short) 3).setSkullOwner(p6).setInfinityDurability().lore("§8[§c✕§8] §7Dernière Connexion: §d" + lastlog.get(p6)).setDisplayName("§8➟ §d " + p6).flag(ItemFlag.HIDE_UNBREAKABLE).flag(ItemFlag.HIDE_ATTRIBUTES).build());


            i2++;
        }



        p.openInventory(friend);

    }
}
