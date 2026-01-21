package main.java.it.unicam.cs.hackhub.entity;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class Submission {
    private final String id;
    private final String name;
    private final String description;
    private final Instant date;
    private final List<Attachment> attachments;
    private final Team team;
    private final Hackathon hackathon;

    public Submission(String id, String name, String description, Instant date, Team team, Hackathon hackathon) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.date = date;
        this.attachments = new ArrayList<>();
        this.team = team;
        this.hackathon = hackathon;
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

    public Instant getDate() {
        return date;
    }

    public List<Attachment> getAttachments() {
        return attachments;
    }

    public Team getTeam() {
        return team;
    }

    public Hackathon getHackathon() {
        return hackathon;
    }
}
