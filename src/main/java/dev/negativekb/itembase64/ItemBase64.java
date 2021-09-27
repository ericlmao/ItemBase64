package dev.negativekb.itembase64;

import dev.negativekb.itembase64.commands.CommandToBase64;
import org.bukkit.plugin.java.JavaPlugin;

public final class ItemBase64 extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic

        getCommand("tobase64").setExecutor(new CommandToBase64());


    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
