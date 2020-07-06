package xyz.elevated.frequency;

import lombok.Getter;
import org.bukkit.Bukkit;
import xyz.elevated.frequency.data.type.PlayerDataManager;
import xyz.elevated.frequency.listener.PlayerListener;
import xyz.elevated.frequency.processor.ProcessorManager;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

@Getter
public enum FrequencyAPI {
    INSTANCE;

    private FrequencyPlugin plugin;

    private final ProcessorManager processorManager = new ProcessorManager();
    private final PlayerDataManager playerDataManager = new PlayerDataManager();

    private final Executor executorPacket = Executors.newSingleThreadExecutor();

    public void start(final FrequencyPlugin plugin) {
        this.plugin = plugin;

        assert plugin != null : "Something went wrong! The plugin was null. (Startup)";

        Bukkit.getPluginManager().registerEvents(new PlayerListener(), plugin);
    }

    public void stop(final FrequencyPlugin plugin) {
        this.plugin = plugin;

        assert plugin != null : "Something went wrong! The plugin was null. (Shutdown)";
    }
}