package main.java.it.unicam.cs.hackhub.state;

import main.java.it.unicam.cs.hackhub.entity.Hackathon;
import main.java.it.unicam.cs.hackhub.entity.Submission;
import main.java.it.unicam.cs.hackhub.entity.Team;

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
}
