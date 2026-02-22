package it.unicam.cs.hackhub.core.state;

import it.unicam.cs.hackhub.common.ServiceException;
import it.unicam.cs.hackhub.core.repository.HackathonRepository;
import it.unicam.cs.hackhub.model.entity.Evaluation;
import it.unicam.cs.hackhub.model.entity.Hackathon;
import it.unicam.cs.hackhub.model.entity.Submission;
import it.unicam.cs.hackhub.model.entity.Team;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ClosedStateHandler implements HackathonStateHandler {

    private final HackathonRepository hackathonRepository;

    @Override
    public void registerTeam(Hackathon hackathon, Team team) throws ServiceException {
        throw new IllegalStateException("Cannot register team when hackathon is closed");
    }

    @Override
    public void submit(Hackathon hackathon, Submission submission) throws ServiceException {
        throw new IllegalStateException("Cannot submit when hackathon is closed");
    }

    @Override
    public void startEvaluation(Hackathon hackathon) throws ServiceException {
        throw new IllegalStateException("Cannot start evaluation when hackathon is closed");
    }

    @Override
    public void close(Hackathon hackathon) throws ServiceException {
        throw new IllegalStateException("Hackathon is already closed");
    }

    @Override
    public void submitEvaluation(Hackathon hackathon, Evaluation evaluation) throws ServiceException {
        throw new IllegalStateException("Cannot submit evaluation when hackathon is closed");
    }
}
