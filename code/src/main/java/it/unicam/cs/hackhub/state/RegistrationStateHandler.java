package main.java.it.unicam.cs.hackhub.state;

import main.java.it.unicam.cs.hackhub.common.HackathonState;
import main.java.it.unicam.cs.hackhub.entity.Hackathon;
import main.java.it.unicam.cs.hackhub.entity.Submission;
import main.java.it.unicam.cs.hackhub.entity.Team;

public class RegistrationStateHandler implements HackathonStateHandler {

    @Override
    public void registerTeam(Hackathon hackathon, Team team) {
        hackathon.getTeams().add(team);
    }

    @Override
    public void submit(Hackathon hackathon, Submission submission) {
        throw new IllegalStateException("Cannot submit during registration phase");
    }

    @Override
    public void startEvaluation(Hackathon hackathon) {
        throw new IllegalStateException("Cannot start evaluation during registration phase");
    }

    @Override
    public void close(Hackathon hackathon) {
        hackathon.setState(HackathonState.CLOSED);
    }
}
