package it.unicam.cs.hackhub.core.state;

import it.unicam.cs.hackhub.common.HackathonState;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Resolves the correct state handler for a given hackathon state using
 * Map-based lookup (beans provided by {@link HackathonStateConfig}).
 */
@Service
@RequiredArgsConstructor
public class HackathonStateService {

    private final Map<HackathonState, HackathonStateHandler> stateHandlerMap;

    /**
     * Returns the handler for the given state (dynamic lookup).
     */
    public HackathonStateHandler getHandler(HackathonState state) {
        return stateHandlerMap.get(state);
    }

    /** Alias for {@link #getHandler(HackathonState)}. */
    public HackathonStateHandler resolve(HackathonState state) {
        return getHandler(state);
    }
}
