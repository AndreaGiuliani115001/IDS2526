package it.unicam.cs.hackhub.core.state;

import it.unicam.cs.hackhub.common.HackathonState;
import it.unicam.cs.hackhub.model.entity.Evaluation;
import it.unicam.cs.hackhub.model.entity.Hackathon;
import it.unicam.cs.hackhub.model.entity.Submission;
import it.unicam.cs.hackhub.model.entity.Team;

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

    @Override
    public void submitEvaluation(Hackathon hackathon, Evaluation evaluation) {
        // Allowed during evaluation phase; persistence is handled by EvaluationService
    }
}
