package taewookim;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class INVMaker extends JavaPlugin {

    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(new Event(), this);
    }

    public void onDisable() {

    }

}
