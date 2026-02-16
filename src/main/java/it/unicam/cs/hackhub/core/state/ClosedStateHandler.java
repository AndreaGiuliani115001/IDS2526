package it.unicam.cs.hackhub.core.state;

import it.unicam.cs.hackhub.model.entity.Evaluation;
import it.unicam.cs.hackhub.model.entity.Hackathon;
import it.unicam.cs.hackhub.model.entity.Submission;
import it.unicam.cs.hackhub.model.entity.Team;

public class ClosedStateHandler implements HackathonStateHandler {

    @Override
    public void registerTeam(Hackathon hackathon, Team team) {
        throw new IllegalStateException("Cannot register team when hackathon is closed");
    }

    @Override
    public void submit(Hackathon hackathon, Submission submission) {
        throw new IllegalStateException("Cannot submit when hackathon is closed");
    }

    @Override
    public void startEvaluation(Hackathon hackathon) {
        throw new IllegalStateException("Cannot start evaluation when hackathon is closed");
    }

    @Override
    public void close(Hackathon hackathon) {
        throw new IllegalStateException("Hackathon is already closed");
    }

    @Override
    public void submitEvaluation(Hackathon hackathon, Evaluation evaluation) {
        throw new IllegalStateException("Cannot submit evaluation when hackathon is closed");
    }
}
