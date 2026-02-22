package it.unicam.cs.hackhub.core.adapter;

import java.time.Instant;

/**
 * Contract for external calendar (e.g. scheduling mentor calls).
 */
public interface CalendarAdapter {

    String scheduleCall(String teamId, String mentorId, Instant time);
}
