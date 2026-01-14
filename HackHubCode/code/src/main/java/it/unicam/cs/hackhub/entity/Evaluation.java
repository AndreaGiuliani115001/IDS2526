package main.java.it.unicam.cs.hackhub.entity;

public class Evaluation {
    private final int score;
    private final String comment;

    public Evaluation(int score, String comment) {
        this.score = score;
        this.comment = comment;
    }

    public int getScore() {
        return score;
    }

    public String getComment() {
        return comment;
    }
}
