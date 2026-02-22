package it.unicam.cs.hackhub.model.entity;

import it.unicam.cs.hackhub.common.Document;
import jakarta.persistence.*;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "submissions")
public class Submission extends Document {
    private String name;
    private String description;
    private Instant date;

    @OneToMany
    private List<Attachment> attachments;

    @ManyToOne
    private Team team;

    @ManyToOne
    private Hackathon hackathon;

    @OneToOne(mappedBy = "submission", cascade = CascadeType.ALL)
    private Evaluation evaluation;

    public Submission() {
        super();
        this.attachments = new ArrayList<>();
    }

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
