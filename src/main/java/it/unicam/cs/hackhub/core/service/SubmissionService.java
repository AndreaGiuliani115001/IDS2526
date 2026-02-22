package it.unicam.cs.hackhub.core.service;

import it.unicam.cs.hackhub.common.ErrorCode;
import it.unicam.cs.hackhub.common.Service;
import it.unicam.cs.hackhub.common.ServiceException;
import it.unicam.cs.hackhub.model.dto.SubmissionInput;
import it.unicam.cs.hackhub.model.dto.SubmissionOutput;
import it.unicam.cs.hackhub.model.entity.Hackathon;
import it.unicam.cs.hackhub.model.entity.Submission;
import it.unicam.cs.hackhub.model.entity.Team;
import it.unicam.cs.hackhub.model.mapper.SubmissionMapper;
import it.unicam.cs.hackhub.core.repository.SubmissionRepository;
import it.unicam.cs.hackhub.core.state.HackathonStateService;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@org.springframework.stereotype.Service
@RequiredArgsConstructor
public class SubmissionService implements Service<Submission, SubmissionInput, SubmissionOutput> {

    private final SubmissionRepository submissionRepository;
    private final TeamService teamService;
    private final HackathonService hackathonService;
    private final HackathonStateService stateService;
    private final SubmissionMapper submissionMapper;

    @Override
    public SubmissionOutput create(SubmissionInput input) throws ServiceException {
        throw new ServiceException(ErrorCode.INVALID_INPUT, "Use submitToHackathon(teamId, hackathonId, input) to create a submission");
    }

    /**
     * Submits a project to a hackathon. Uses state handler; only allowed in RUNNING state.
     */
    public SubmissionOutput submitToHackathon(String teamId, String hackathonId, SubmissionInput input) throws ServiceException {
        Team team = teamService.getEntityById(teamId);
        Hackathon hackathon = hackathonService.getEntityById(hackathonId);
        String id = UUID.randomUUID().toString();
        Submission submission = submissionMapper.toEntity(input, id, team, hackathon);
        stateService.getHandler(hackathon.getState()).submit(hackathon, submission);
        submissionRepository.save(submission);
        return submissionMapper.toOutDto(submission);
    }

    @Override
    public SubmissionOutput getById(String id) throws ServiceException {
        Submission entity = submissionRepository.findById(id).orElseThrow(() -> new ServiceException(ErrorCode.NOT_FOUND, "Submission not found: " + id));
        return submissionMapper.toOutDto(entity);
    }

    @Override
    public List<SubmissionOutput> getAll() throws ServiceException {
        return submissionRepository.findAll().stream().map(submissionMapper::toOutDto).collect(Collectors.toList());
    }

    @Override
    public SubmissionOutput update(String id, SubmissionInput input) throws ServiceException {
        Submission existing = submissionRepository.findById(id).orElseThrow(() -> new ServiceException(ErrorCode.NOT_FOUND, "Submission not found: " + id));
        submissionMapper.updateEntity(input, existing);
        submissionRepository.update(id, existing);
        return submissionMapper.toOutDto(existing);
    }

    @Override
    public void delete(String id) throws ServiceException {
        submissionRepository.delete(id);
    }

    public Submission getEntityById(String id) throws ServiceException {
        return submissionRepository.findById(id).orElseThrow(() -> new ServiceException(ErrorCode.NOT_FOUND, "Submission not found: " + id));
    }
}
