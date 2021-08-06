package com.jazzkuh.sdbrestapi;

import com.jazzkuh.sdbrestapi.commands.WebURLCMD;
import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    private static @Getter Main instance;

    @Override
    public void onEnable() {
        instance = this;

        new WebServer(this.getConfig().getInt("webserver.port")).init();
        new WebURLCMD().register(this);

        this.getLogger().info("Plugin has been loaded.");

        this.saveDefaultConfig();
        this.saveConfig();
    }
}