package com.jazzkuh.sdbrestapi;

import com.jazzkuh.sdbrestapi.commands.WebURLCMD;
import lombok.Getter;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    private static @Getter Main instance;
    private static @Getter Economy econ = null;

    @Override
    public void onEnable() {
        instance = this;
        setupEconomy();

        new WebServer(this.getConfig().getInt("webserver.port")).init();
        new WebURLCMD().register(this);

        this.getLogger().info("Plugin has been loaded.");

        this.saveDefaultConfig();
        this.saveConfig();
    }
    private boolean setupEconomy() {
        if (getServer().getPluginManager().getPlugin("Vault") == null) {
            return false;
        }
        RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);
        if (rsp == null) {
            return false;
        }
        econ = rsp.getProvider();
        return econ != null;
    }

}