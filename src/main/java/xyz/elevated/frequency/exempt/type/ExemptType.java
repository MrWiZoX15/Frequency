package xyz.elevated.frequency.exempt.type;

import lombok.Getter;
import xyz.elevated.frequency.data.PlayerData;
import xyz.elevated.frequency.timings.Timings;

import java.util.function.Function;

@Getter
public enum ExemptType {
    /**
     * Returns true if the tps of the server is too low to ensure check stability
     */
    TPS(playerData -> Timings.TPS.getNumber() < 18),

    /**
     * Returns true if the player is inside or close to the void
     */
    VOID(playerData -> playerData.getBukkitPlayer().getLocation().getY() < 4);

    private final Function<PlayerData, Boolean> exception;

    ExemptType(final Function<PlayerData, Boolean> exception) {
        this.exception = exception;
    }
}