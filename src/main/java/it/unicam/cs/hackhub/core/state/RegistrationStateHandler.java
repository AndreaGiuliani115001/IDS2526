package it.unicam.cs.hackhub.core.state;

import it.unicam.cs.hackhub.common.HackathonState;
import it.unicam.cs.hackhub.model.entity.Evaluation;
import it.unicam.cs.hackhub.model.entity.Hackathon;
import it.unicam.cs.hackhub.model.entity.Submission;
import it.unicam.cs.hackhub.model.entity.Team;

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

    @Override
    public void submitEvaluation(Hackathon hackathon, Evaluation evaluation) {
        throw new IllegalStateException("Cannot submit evaluation during registration phase");
    }
}
