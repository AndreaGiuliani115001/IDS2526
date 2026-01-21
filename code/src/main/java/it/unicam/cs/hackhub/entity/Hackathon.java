package main.java.it.unicam.cs.hackhub.entity;

import main.java.it.unicam.cs.hackhub.common.HackathonState;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class Hackathon {
    private final String id;
    private final String name;
    private final String description;
    private final String rules;
    private final Instant registrationDeadline;
    private final Instant startDate;
    private final Instant endDate;
    private final String location;
    private final Double prize;
    private final Integer maxTeamSize;
    private HackathonState state;
    private final User organizer;
    private final User judge;
    private final List<User> mentors;
    private final List<Submission> submissions;
    private final List<Team> teams;

    public Hackathon(String id, String name, String description, String rules, Instant registrationDeadline,
            Instant startDate, Instant endDate, String location, Double prize,
            Integer maxTeamSize, HackathonState state, User organizer, User judge) {
        this.id = id;
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
        this.submissions = new ArrayList<>();
        this.teams = new ArrayList<>();
    }

    public String getId() {
        return id;
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

    public Double getPrize() {
        return prize;
    }

    public Integer getMaxTeamSize() {
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

    public List<Submission> getSubmissions() {
        return submissions;
    }

    public List<Team> getTeams() {
        return teams;
    }
}
