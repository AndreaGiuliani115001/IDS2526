package it.unicam.cs.hackhub.model.dto;

public class EvaluationInput extends InputDTO {
    private final String submissionId;
    private final String judgeId;
    private final Double score;
    private final String comment;

    public EvaluationInput(String submissionId, String judgeId, Double score, String comment) {
        this.submissionId = submissionId;
        this.judgeId = judgeId;
        this.score = score;
        this.comment = comment;
    }

    public String getSubmissionId() {
        return submissionId;
    }

    public String getJudgeId() {
        return judgeId;
    }

    public Double getScore() {
        return score;
    }

    public String getComment() {
        return comment;
    }
}
