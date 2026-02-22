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
public class RegistrationStateHandler implements HackathonStateHandler {

    private final HackathonRepository hackathonRepository;

    @Override
    public void registerTeam(Hackathon hackathon, Team team) throws ServiceException {
        hackathon.getTeams().add(team);
    }

    @Override
    public void submit(Hackathon hackathon, Submission submission) throws ServiceException {
        throw new IllegalStateException("Cannot submit during registration phase");
    }

    @Override
    public void startEvaluation(Hackathon hackathon) throws ServiceException {
        throw new IllegalStateException("Cannot start evaluation during registration phase");
    }

    @Override
    public void close(Hackathon hackathon) throws ServiceException {
        hackathon.setState(HackathonState.CLOSED);
        hackathonRepository.update(hackathon.getId(), hackathon);
    }

    @Override
    public void submitEvaluation(Hackathon hackathon, Evaluation evaluation) throws ServiceException {
        throw new IllegalStateException("Cannot submit evaluation during registration phase");
    }
}
