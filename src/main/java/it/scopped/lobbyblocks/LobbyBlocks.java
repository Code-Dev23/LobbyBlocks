package it.scopped.lobbyblocks;

import it.scopped.lobbyblocks.listeners.BlockListeners;
import it.scopped.lobbyblocks.workload.WorkloadThread;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

@Getter
public final class LobbyBlocks extends JavaPlugin {

    private static LobbyBlocks instance;
    private WorkloadThread workloadThread;

    @Override
    public void onEnable() {
        instance = this;
        saveDefaultConfig();

        this.workloadThread = new WorkloadThread();
        Bukkit.getScheduler().runTaskTimer(this, this.workloadThread, 0L, 1L);

        getServer().getPluginManager().registerEvents(new BlockListeners(this), this);
    }

    public static LobbyBlocks get() {
        return instance;
    }
}