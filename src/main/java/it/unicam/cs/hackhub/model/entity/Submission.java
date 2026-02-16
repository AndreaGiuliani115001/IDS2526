package it.unicam.cs.hackhub.model.entity;

import it.unicam.cs.hackhub.common.Document;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class Submission extends Document {
    private final String name;
    private final String description;
    private final Instant date;
    private final List<Attachment> attachments;
    private final Team team;
    private final Hackathon hackathon;
    private Evaluation evaluation;

    public Submission(String name, String description, Instant date, Team team, Hackathon hackathon) {
        super();
        this.name = name;
        this.description = description;
        this.date = date;
        this.attachments = new ArrayList<>();
        this.team = team;
        this.hackathon = hackathon;
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

    public Evaluation getEvaluation() {
        return evaluation;
    }

    public void setEvaluation(Evaluation evaluation) {
        this.evaluation = evaluation;
    }
}
