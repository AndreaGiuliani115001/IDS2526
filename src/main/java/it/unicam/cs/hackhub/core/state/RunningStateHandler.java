package it.unicam.cs.hackhub.core.state;

import it.unicam.cs.hackhub.common.HackathonState;
import it.unicam.cs.hackhub.model.entity.Evaluation;
import it.unicam.cs.hackhub.model.entity.Hackathon;
import it.unicam.cs.hackhub.model.entity.Submission;
import it.unicam.cs.hackhub.model.entity.Team;

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

    @Override
    public void submitEvaluation(Hackathon hackathon, Evaluation evaluation) {
        throw new IllegalStateException("Cannot submit evaluation during running phase");
    }
}
