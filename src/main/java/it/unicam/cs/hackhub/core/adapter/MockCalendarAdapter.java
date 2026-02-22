package it.unicam.cs.hackhub.core.adapter;

import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.UUID;
import java.util.logging.Logger;

/**
 * In-memory mock implementation of CalendarAdapter for testing Iteration 3.
 */
@Component
public class MockCalendarAdapter implements CalendarAdapter {
    private static final Logger logger = Logger.getLogger(MockCalendarAdapter.class.getName());

    @Override
    public String scheduleCall(String teamId, String mentorId, Instant time) {
        String meetingLink = "https://mock-meet.com/" + UUID.randomUUID().toString().substring(0, 8);
        logger.info("MOCK CALENDAR: Scheduled call for Team " + teamId + " with Mentor " + mentorId + " at " + time);
        return meetingLink;
    }
}