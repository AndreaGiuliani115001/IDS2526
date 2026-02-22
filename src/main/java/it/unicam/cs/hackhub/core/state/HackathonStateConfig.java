package it.unicam.cs.hackhub.core.state;

import it.unicam.cs.hackhub.common.HackathonState;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.EnumMap;
import java.util.Map;

/**
 * Provides a Map-based lookup from HackathonState to the corresponding
 * state handler bean for dynamic dispatch.
 */
@Configuration
public class HackathonStateConfig {

    @Bean
    public Map<HackathonState, HackathonStateHandler> stateHandlerMap(
            RegistrationStateHandler registrationStateHandler,
            RunningStateHandler runningStateHandler,
            EvaluationStateHandler evaluationStateHandler,
            ClosedStateHandler closedStateHandler) {
        Map<HackathonState, HackathonStateHandler> map = new EnumMap<>(HackathonState.class);
        map.put(HackathonState.REGISTRATION, registrationStateHandler);
        map.put(HackathonState.RUNNING, runningStateHandler);
        map.put(HackathonState.EVALUATION, evaluationStateHandler);
        map.put(HackathonState.CLOSED, closedStateHandler);
        return map;
    }
}
