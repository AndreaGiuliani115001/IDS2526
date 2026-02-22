package it.unicam.cs.hackhub.core.state;

import it.unicam.cs.hackhub.common.ServiceException;
import it.unicam.cs.hackhub.model.entity.Evaluation;
import it.unicam.cs.hackhub.model.entity.Hackathon;
import it.unicam.cs.hackhub.model.entity.Submission;
import it.unicam.cs.hackhub.model.entity.Team;

public interface HackathonStateHandler {
    void registerTeam(Hackathon hackathon, Team team) throws ServiceException;

    void submit(Hackathon hackathon, Submission submission) throws ServiceException;

    void startEvaluation(Hackathon hackathon) throws ServiceException;

    void close(Hackathon hackathon) throws ServiceException;

    void submitEvaluation(Hackathon hackathon, Evaluation evaluation) throws ServiceException;
}
