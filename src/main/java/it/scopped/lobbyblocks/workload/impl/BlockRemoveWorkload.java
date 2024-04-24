package it.scopped.lobbyblocks.workload.impl;

import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.wrappers.BlockPosition;
import it.scopped.lobbyblocks.LobbyBlocks;
import it.scopped.lobbyblocks.workload.Workload;
import lombok.RequiredArgsConstructor;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadLocalRandom;

@RequiredArgsConstructor
public class BlockRemoveWorkload implements Workload {
    private final Location location;

    @Override
    public void compute() {
        Block block = location.getBlock();
        Bukkit.getScheduler().runTaskLater(LobbyBlocks.get(), () -> {
            if(block.getType().equals(Material.RED_WOOL)) block.setType(Material.valueOf(LobbyBlocks.get().getConfig().getString("block-type")));
        }, 3*20L);
    }
}