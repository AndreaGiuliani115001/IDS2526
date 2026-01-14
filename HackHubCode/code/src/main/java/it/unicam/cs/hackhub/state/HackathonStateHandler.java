package main.java.it.unicam.cs.hackhub.state;

import main.java.it.unicam.cs.hackhub.entity.Hackathon;
import main.java.it.unicam.cs.hackhub.entity.Submission;
import main.java.it.unicam.cs.hackhub.entity.Team;

public interface HackathonStateHandler {
    void registerTeam(Hackathon hackathon, Team team);

    void submit(Hackathon hackathon, Submission submission);

    void startEvaluation(Hackathon hackathon);

    void close(Hackathon hackathon);
}
