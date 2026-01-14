package main.java.it.unicam.cs.hackhub.entity;

import main.java.it.unicam.cs.hackhub.common.HackathonState;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class Hackathon {
    private final String name;
    private final String description;
    private final String rules;
    private final Instant registrationDeadline;
    private final Instant startDate;
    private final Instant endDate;
    private final String location;
    private final double prize;
    private final int maxTeamSize;
    private HackathonState state;
    private final User organizer;
    private final User judge;
    private final List<User> mentors;
    private final List<Team> teams;
    private final List<Submission> submissions;

    public Hackathon(String name, String description, String rules, Instant registrationDeadline,
            Instant startDate, Instant endDate, String location, double prize,
            int maxTeamSize, HackathonState state, User organizer, User judge) {
        this.name = name;
        this.description = description;
        this.rules = rules;
        this.registrationDeadline = registrationDeadline;
        this.startDate = startDate;
        this.endDate = endDate;
        this.location = location;
        this.prize = prize;
        this.maxTeamSize = maxTeamSize;
        this.state = state;
        this.organizer = organizer;
        this.judge = judge;
        this.mentors = new ArrayList<>();
        this.teams = new ArrayList<>();
        this.submissions = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getRules() {
        return rules;
    }

    public Instant getRegistrationDeadline() {
        return registrationDeadline;
    }

    public Instant getStartDate() {
        return startDate;
    }

    public Instant getEndDate() {
        return endDate;
    }

    public String getLocation() {
        return location;
    }

    public double getPrize() {
        return prize;
    }

    public int getMaxTeamSize() {
        return maxTeamSize;
    }

    public HackathonState getState() {
        return state;
    }

    public void setState(HackathonState state) {
        this.state = state;
    }

    public User getOrganizer() {
        return organizer;
    }

    public User getJudge() {
        return judge;
    }

    public List<User> getMentors() {
        return mentors;
    }

    public List<Team> getTeams() {
        return teams;
    }

    public List<Submission> getSubmissions() {
        return submissions;
    }
}
