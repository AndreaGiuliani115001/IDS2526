package it.unicam.cs.hackhub.model.entity;

import it.unicam.cs.hackhub.common.Document;

public class Evaluation extends Document {
    private final Submission submission;
    private final User judge;
    private final Integer score;
    private final String description;

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
