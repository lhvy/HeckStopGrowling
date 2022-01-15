package dev.lhvy.heckstopgrowling;

import org.bstats.bukkit.Metrics;
import org.bukkit.plugin.java.JavaPlugin;

public class HeckStopGrowling extends JavaPlugin {
    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new HeckListener(), this);

        @SuppressWarnings("unused")
        Metrics metrics = new Metrics(this, 13960);
    }
}
