package fun.slowfeew;

import fun.slowfeew.sql.DatabaseManager;
import org.bukkit.plugin.java.JavaPlugin;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main extends JavaPlugin {


    @Override
    public void onEnable() {
        super.onEnable();
        saveDefaultConfig();
        DatabaseManager.initAllDatabaseConnections();

    }

    @Override
    public void onDisable() {
        super.onDisable();
        DatabaseManager.closeAllDatabaseConnections();

    }
}