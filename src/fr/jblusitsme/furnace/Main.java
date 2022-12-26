package fr.jblusitsme.furnace;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        getCommand("furnace").setExecutor(new FurnaceCommands());
    }
}
