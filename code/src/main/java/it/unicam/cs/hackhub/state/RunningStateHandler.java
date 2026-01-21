package main.java.it.unicam.cs.hackhub.state;

import main.java.it.unicam.cs.hackhub.common.HackathonState;
import main.java.it.unicam.cs.hackhub.entity.Hackathon;
import main.java.it.unicam.cs.hackhub.entity.Submission;
import main.java.it.unicam.cs.hackhub.entity.Team;

public class RunningStateHandler implements HackathonStateHandler {

    @Override
    public void registerTeam(Hackathon hackathon, Team team) {
        throw new IllegalStateException("Cannot register team during running phase");
    }

    @Override
    public void submit(Hackathon hackathon, Submission submission) {
        hackathon.getSubmissions().add(submission);
    }

    @Override
    public void startEvaluation(Hackathon hackathon) {
        hackathon.setState(HackathonState.EVALUATION);
    }

    @Override
    public void close(Hackathon hackathon) {
        hackathon.setState(HackathonState.CLOSED);
    }
}
