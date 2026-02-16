package it.unicam.cs.hackhub.core.adapter;

import java.time.Instant;

/**
 * Port for scheduling mentoring calls (Use Case: Proporre Call / Prenotare
 * Slot).
 */
public interface CalendarAdapter {

    /**
     * Schedules a video call between a mentor and a team.
     *
     * @param teamId   id of the team
     * @param mentorId id of the mentor
     * @param time     time of the scheduled call
     * @return a mock meeting link or ID
     */
    String scheduleCall(String teamId, String mentorId, Instant time);
}