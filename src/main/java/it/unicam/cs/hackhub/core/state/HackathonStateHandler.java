package it.unicam.cs.hackhub.core.state;

import it.unicam.cs.hackhub.model.entity.Evaluation;
import it.unicam.cs.hackhub.model.entity.Hackathon;
import it.unicam.cs.hackhub.model.entity.Submission;
import it.unicam.cs.hackhub.model.entity.Team;

public interface HackathonStateHandler {
    void registerTeam(Hackathon hackathon, Team team);

    void submit(Hackathon hackathon, Submission submission);

    void startEvaluation(Hackathon hackathon);

    void close(Hackathon hackathon);

    void submitEvaluation(Hackathon hackathon, Evaluation evaluation);
}
