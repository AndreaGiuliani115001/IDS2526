package it.unicam.cs.hackhub.core.state;

import it.unicam.cs.hackhub.common.HackathonState;
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
public class RunningStateHandler implements HackathonStateHandler {

    private final HackathonRepository hackathonRepository;

    @Override
    public void registerTeam(Hackathon hackathon, Team team) throws ServiceException {
        throw new IllegalStateException("Cannot register team during running phase");
    }

    @Override
    public void submit(Hackathon hackathon, Submission submission) throws ServiceException {
        hackathon.getSubmissions().add(submission);
    }

    @Override
    public void startEvaluation(Hackathon hackathon) throws ServiceException {
        hackathon.setState(HackathonState.EVALUATION);
        hackathonRepository.update(hackathon.getId(), hackathon);
    }

    @Override
    public void close(Hackathon hackathon) throws ServiceException {
        hackathon.setState(HackathonState.CLOSED);
        hackathonRepository.update(hackathon.getId(), hackathon);
    }

    @Override
    public void submitEvaluation(Hackathon hackathon, Evaluation evaluation) throws ServiceException {
        throw new IllegalStateException("Cannot submit evaluation during running phase");
    }
}
