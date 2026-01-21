package main.java.it.unicam.cs.hackhub.state;

import main.java.it.unicam.cs.hackhub.common.HackathonState;
import java.util.EnumMap;
import java.util.Map;

public class HackathonStateService {
    private final Map<HackathonState, HackathonStateHandler> handlers;

    public HackathonStateService() {
        this.handlers = new EnumMap<>(HackathonState.class);
        handlers.put(HackathonState.REGISTRATION, new RegistrationStateHandler());
        handlers.put(HackathonState.RUNNING, new RunningStateHandler());
        handlers.put(HackathonState.EVALUATION, new EvaluationStateHandler());
        handlers.put(HackathonState.CLOSED, new ClosedStateHandler());
    }

    public HackathonStateHandler resolve(HackathonState state) {
        return handlers.get(state);
    }
}
