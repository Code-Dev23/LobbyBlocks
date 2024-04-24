package it.scopped.lobbyblocks.listeners;

import it.scopped.lobbyblocks.LobbyBlocks;
import it.scopped.lobbyblocks.workload.impl.BlockRemoveWorkload;
import lombok.RequiredArgsConstructor;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

@RequiredArgsConstructor
public class BlockListeners implements Listener {
    private final LobbyBlocks main;

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event) {
        if (event.getBlockPlaced().getType().equals(Material.valueOf(LobbyBlocks.get().getConfig().getString("block-type"))))
            main.getWorkloadThread().addWorkload(new BlockRemoveWorkload(event.getBlockPlaced().getLocation()));
    }
}