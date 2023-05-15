package fun.slowfeew.Utils;

import fun.slowfeew.sql.DatabaseManager;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static fun.slowfeew.GetPrefix.getPrefix;

public class SQL {

    public static boolean hasAccountName(String target, Player sender) {
        try {
            Connection connection = DatabaseManager.Osaka2.getDatabaseAccess().getConnection();

            PreparedStatement ps = connection.prepareStatement("SELECT `Player` FROM `General` WHERE `Player` = '" + target + "'");
            ResultSet rs = ps.executeQuery();

            if(rs.next()) {
                connection.close();
                ps.close();
                rs.close();
                return true;
            }else {
                connection.close();
                ps.close();
                rs.close();
                return false;
            }
        }catch(SQLException e) {
            e.printStackTrace();
            if(sender != null) sender.sendMessage("§dSatsuki §8| Une erreur SQL est survenue.");
            return false;
        }
    }
    public static List<String> getFriends(String target, Player sender) {
        if(hasAccountName(target, sender)) {
            try {

                Connection connection = DatabaseManager.Osaka2.getDatabaseAccess().getConnection();

                PreparedStatement ps = connection.prepareStatement("SELECT `VALUE-NAME` FROM `Friends` WHERE `KEY-NAME` = ?");
                ps.setString(1, target);
                ResultSet rs = ps.executeQuery();

                List<String> IPS = new ArrayList<>();
                String ok = "nothing";

                while(rs.next()) {
                    ok = rs.getString("VALUE-NAME");


                    assert false;
                    IPS.add(ok);

                }

                rs.close();
                ps.close();
                connection.close();

                return IPS;

            } catch (SQLException e) {
                e.printStackTrace();
                if(sender != null) sender.sendMessage("§dSatsuki §8| Une erreur SQL est survenue.");

            }
        } else {
            if(sender != null) sender.sendMessage("§dSatsuki §8| Le joueur n'existe pas.");
        }

        return null;
    }
    public static double getCerise(String target, Player sender) {
        if(hasAccountName(target, sender)) {
            try {

                Connection connection = DatabaseManager.Osaka2.getDatabaseAccess().getConnection();

                PreparedStatement ps = connection.prepareStatement("SELECT `Cerise` FROM `General` WHERE `Player` = '" + target + "'");
                ResultSet rs = ps.executeQuery();

                while(rs.next()) {
                    double ok = rs.getInt("Cerise");

                    rs.close();
                    ps.close();
                    connection.close();

                    return ok;

                }

            } catch (SQLException e) {
                e.printStackTrace();
                if(sender != null);

            }
        }

        return 0;
    }

    public static double getSagesse(String target, Player sender) {
        if(hasAccountName(target, sender)) {
            try {

                Connection connection = DatabaseManager.Osaka2.getDatabaseAccess().getConnection();

                PreparedStatement ps = connection.prepareStatement("SELECT `Sagesse` FROM `General` WHERE `Player` = '" + target + "'");
                ResultSet rs = ps.executeQuery();

                while(rs.next()) {


                    double ok = rs.getInt("Sagesse");

                    rs.close();
                    ps.close();
                    connection.close();

                    return ok;
                }



            } catch (SQLException e) {
                e.printStackTrace();
                if(sender != null) ;

            }
        } else {
            if(sender != null);
        }

        return 0;
    }

    public static double getYen(String target, Player sender) {
        if(hasAccountName(target, sender)) {
            try {

                Connection connection = DatabaseManager.Osaka2.getDatabaseAccess().getConnection();

                PreparedStatement ps = connection.prepareStatement("SELECT `Yen` FROM `General` WHERE `Player` = '" + target + "'");
                ResultSet rs = ps.executeQuery();


                while(rs.next()) {
                    double ok = rs.getInt("Yen");

                    rs.close();
                    ps.close();
                    connection.close();

                    return ok;
                }


            } catch (SQLException e) {
                e.printStackTrace();
                if(sender != null);

            }
        } else {
            if(sender != null);
        }

        return 0;
    }


    public static int getLevel(String target, Player sender) {
        if(hasAccountName(target, sender)) {
            try {

                Connection connection = DatabaseManager.Osaka2.getDatabaseAccess().getConnection();

                PreparedStatement ps = connection.prepareStatement("SELECT `LEVEL` FROM `Levels_Player` WHERE `Player` = '" + target + "'");
                ResultSet rs = ps.executeQuery();


                while(rs.next()) {
                    int ok = rs.getInt("LEVEL");

                    rs.close();
                    ps.close();
                    connection.close();

                    return ok;
                }


            } catch (SQLException e) {
                e.printStackTrace();
                if(sender != null);

            }
        } else {
            if(sender != null);
        }

        return 0;
    }

    public static Double getExp(String target, Player sender) {
        if(hasAccountName(target, sender)) {
            try {

                Connection connection = DatabaseManager.Osaka2.getDatabaseAccess().getConnection();

                PreparedStatement ps = connection.prepareStatement("SELECT `EXP` FROM `Levels_Player` WHERE `Player` = '" + target + "'");
                ResultSet rs = ps.executeQuery();


                while(rs.next()) {
                    Double ok = rs.getDouble("EXP");

                    rs.close();
                    ps.close();
                    connection.close();

                    return ok;
                }


            } catch (SQLException e) {
                e.printStackTrace();
                if(sender != null);

            }
        } else {
            if(sender != null);
        }

        return (double) 0;
    }

    public static void addExp(Player sender, String target, String amount) {
        if(hasAccountName(target, sender)) {


            try {
                Connection connection = DatabaseManager.Osaka2.getDatabaseAccess().getConnection();
                int currentLevel = getLevel(target, null);
                Double xp = getExp(target, null);

                // Calculate the new EXP
                Double xpToAdd = xp + Double.parseDouble(amount);

                // Get the EXP required for the next level
                double xpRequiredNextLevel = 0; //= Double.parseDouble(MainBungee.getINSTANCE().theConfig.getString("levels." + (currentLevel + 1) + ".expRequired"));

                // Check if the player will level up
                if (xpToAdd >= xpRequiredNextLevel) {
                    // Level up the player
                    setLevel(null, target, String.valueOf(currentLevel + 1)); // You need to implement this method
                    newLevel(target, currentLevel + 1); // You need to implement this method
                }

                // Update the player's EXP
                PreparedStatement ps2 = connection.prepareStatement("UPDATE `Levels_Player` SET `EXP` = ? WHERE `Player` = ?");
                ps2.setDouble(1, xpToAdd);
                ps2.setString(2, target);

                ps2.execute();
                ps2.close();


                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private static void newLevel(String target, int level) {
        // Get the ProxiedPlayer for the target
        Player player = Bukkit.getPlayer(target);

        // Check if the player is online
        if (player != null && player.isOnline()) {
            // Create the level up message


            // Send the message to all players on the same server
            for (Player p : Bukkit.getOnlinePlayers()) {
                p.sendMessage("🎉" + getPrefix(player) + target + "§7vient de passer au niveau §a" + level + "🎉");
            }
        }
    }
    public static int calculateLevel(double xp) {
        // Loop through each level, checking if the player's XP is greater than or equal to the XP required for that level
        for (int level = 45; level >= 1; level--) {
           // double xpRequired = Double.parseDouble(MainBungee.getINSTANCE().theConfig.getString("levels." + level + ".expRequired"));



            double xpRequired = 0;



            if (xp >= xpRequired) {
                return level;
            }
        }
        return 1; // Default to level 1 if not enough XP for any level
    }

    public static int getRequired(String target) {
        if(hasAccountName(target, null)) {

            Integer lvl = getLevel(target, null);

            try {

                Connection connection = DatabaseManager.Osaka2.getDatabaseAccess().getConnection();
                int lv = lvl + 1;

                PreparedStatement ps = connection.prepareStatement("SELECT `NEEDEXP` FROM `Levels` WHERE `LEVEL` ='" + lv + "'");

                ResultSet rs = ps.executeQuery();


                    rs.next();
                    int ok = rs.getInt("NEEDEXP");

                    rs.close();
                    ps.close();
                    connection.close();

                    return ok;




            } catch (SQLException e) {
                e.printStackTrace();

            }
        }

        return 0;
    }

        public static String getServer(String target, Player sender) {
        if(hasAccountName(target, sender)) {
            try {

                Connection connection = DatabaseManager.Osaka2.getDatabaseAccess().getConnection();

                PreparedStatement ps = connection.prepareStatement("SELECT `SERVER` FROM `General` WHERE `Player` = '" + target + "'");
                ResultSet rs = ps.executeQuery();

                while(rs.next()) {


                    String ok = rs.getString("SERVER");

                    rs.close();
                    ps.close();
                    connection.close();

                    return ok;
                }



            } catch (SQLException e) {
                e.printStackTrace();
                if(sender != null);

            }
        } else {
            if(sender != null);
        }

        return null;
    }


    public static void setLevel(Player sender, String target, String amount) {
        if(hasAccountName(target, sender)) {
            try {

                Connection connection = DatabaseManager.Osaka2.getDatabaseAccess().getConnection();

                PreparedStatement ps = connection.prepareStatement("UPDATE `Levels_Player` SET `LEVEL` = ? WHERE `Player` = ?");


                ps.setInt(1, calculateLevel(getExp(target, null).intValue()));
                ps.setString(2, target);

                ps.execute();


                connection.close();

            } catch (SQLException e) {
                e.printStackTrace();
                if(sender != null);

            }
        } else {
            if(sender != null);
        }

    }

}
