package main.java.it.unicam.cs.hackhub.state;

import main.java.it.unicam.cs.hackhub.common.HackathonState;
import main.java.it.unicam.cs.hackhub.entity.Hackathon;
import main.java.it.unicam.cs.hackhub.entity.Submission;
import main.java.it.unicam.cs.hackhub.entity.Team;

public class EvaluationStateHandler implements HackathonStateHandler {

    @Override
    public void registerTeam(Hackathon hackathon, Team team) {
        throw new IllegalStateException("Cannot register team during evaluation phase");
    }

    @Override
    public void submit(Hackathon hackathon, Submission submission) {
        throw new IllegalStateException("Cannot submit during evaluation phase");
    }

    @Override
    public void startEvaluation(Hackathon hackathon) {
        throw new IllegalStateException("Evaluation already started");
    }

    @Override
    public void close(Hackathon hackathon) {
        hackathon.setState(HackathonState.CLOSED);
    }
}
