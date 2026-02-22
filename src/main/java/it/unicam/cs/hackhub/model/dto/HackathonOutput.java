package it.unicam.cs.hackhub.model.dto;

import java.time.Instant;
import java.util.List;

public class HackathonOutput extends OutputDTO {
    private final String id; // Shtuam kete
    private final String name;
    private final String description;
    private final String rules;
    private final Instant registrationDeadline;
    private final Instant startDate;
    private final Instant endDate;
    private final String location;
    private final Double prize;
    private final Integer maxTeamSize;
    private final String judge;
    private final List<String> mentors;
    private final List<String> submissions;
    private final List<String> team;

    public HackathonOutput(String id, String name, String description, String rules, Instant registrationDeadline,
            Instant startDate, Instant endDate, String location, Double prize,
            Integer maxTeamSize, String judge, List<String> mentors,
            List<String> submissions, List<String> team) {
        this.id = id; // Shtuam kete
        this.name = name;
        this.description = description;
        this.rules = rules;
        this.registrationDeadline = registrationDeadline;
        this.startDate = startDate;
        this.endDate = endDate;
        this.location = location;
        this.prize = prize;
        this.maxTeamSize = maxTeamSize;
        this.judge = judge;
        this.mentors = mentors;
        this.submissions = submissions;
        this.team = team;
    }

    public String getId() { // Shtuam kete
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

    public String getJudge() {
        return judge;
    }

    public List<String> getMentors() {
        return mentors;
    }

    public List<String> getSubmissions() {
        return submissions;
    }

    public List<String> getTeam() {
        return team;
    }
}