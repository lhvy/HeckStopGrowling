package dev.lhvy.heckstopgrowling;

import org.bukkit.plugin.java.JavaPlugin;

public class HeckStopGrowling extends JavaPlugin {
    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new HeckListener(), this);
    }
}
