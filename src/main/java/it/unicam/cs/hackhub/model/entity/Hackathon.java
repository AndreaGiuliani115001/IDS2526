package it.unicam.cs.hackhub.model.entity;

import it.unicam.cs.hackhub.common.Document;
import it.unicam.cs.hackhub.common.HackathonState;
import jakarta.persistence.*;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "hackathons")
public class Hackathon extends Document {

    private String name;

    @Column(length = 1000)
    private String description;

    @Column(length = 1000)
    private String rules;

    private Instant registrationDeadline;
    private Instant startDate;
    private Instant endDate;
    private String location;
    private Double prize;
    private Integer maxTeamSize;

    @Enumerated(EnumType.STRING)
    private HackathonState state;

    @ManyToOne
    private User organizer;

    @ManyToOne
    private User judge;

    @ManyToMany
    private List<User> mentors;

    @OneToMany(mappedBy = "hackathon")
    private List<Submission> submissions;

    @OneToMany
    @JoinColumn(name = "hackathon_id")
    private List<Team> teams;

    @OneToOne
    @JoinColumn(name = "winner_id")
    private Team winner;

    public Hackathon() {
        super();
    }

    public Hackathon(String name, String description, String rules, Instant registrationDeadline,
            Instant startDate, Instant endDate, String location, Double prize,
            Integer maxTeamSize, HackathonState state, User organizer, User judge) {
        super();
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRules() {
        return rules;
    }

    public void setRules(String rules) {
        this.rules = rules;
    }

    public Instant getRegistrationDeadline() {
        return registrationDeadline;
    }

    public void setRegistrationDeadline(Instant registrationDeadline) {
        this.registrationDeadline = registrationDeadline;
    }

    public Instant getStartDate() {
        return startDate;
    }

    public void setStartDate(Instant startDate) {
        this.startDate = startDate;
    }

    public Instant getEndDate() {
        return endDate;
    }

    public void setEndDate(Instant endDate) {
        this.endDate = endDate;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Double getPrize() {
        return prize;
    }

    public void setPrize(Double prize) {
        this.prize = prize;
    }

    public Integer getMaxTeamSize() {
        return maxTeamSize;
    }

    public void setMaxTeamSize(Integer maxTeamSize) {
        this.maxTeamSize = maxTeamSize;
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

    public void setSubmissions(List<Submission> submissions) {
        this.submissions = submissions;
    }

    public List<Team> getTeams() {
        return teams;
    }

    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }
}