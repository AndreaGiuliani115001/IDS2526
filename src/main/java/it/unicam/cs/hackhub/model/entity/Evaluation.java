package it.unicam.cs.hackhub.model.entity;

import it.unicam.cs.hackhub.common.Document;
import jakarta.persistence.*;

@Entity
@Table(name = "evaluations")
public class Evaluation extends Document {
    @OneToOne
    private Submission submission;

    @ManyToOne
    private User judge;

    private Integer score;
    private String description;

    public Evaluation() {
        super();
    }

    public Evaluation(Submission submission, User judge, Integer score, String description) {
        super();
        this.submission = submission;
        this.judge = judge;
        this.score = score;
        this.description = description;
    }

    public Submission getSubmission() {
        return submission;
    }

    public User getJudge() {
        return judge;
    }

    public Integer getScore() {
        return score;
    }

    public String getDescription() {
        return description;
    }
}
