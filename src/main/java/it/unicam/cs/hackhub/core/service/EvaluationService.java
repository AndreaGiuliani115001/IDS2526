package it.unicam.cs.hackhub.core.service;

import it.unicam.cs.hackhub.common.ErrorCode;
import it.unicam.cs.hackhub.common.Service;
import it.unicam.cs.hackhub.common.ServiceException;
import it.unicam.cs.hackhub.model.dto.EvaluationInput;
import it.unicam.cs.hackhub.model.dto.EvaluationOutput;
import it.unicam.cs.hackhub.model.entity.Evaluation;
import it.unicam.cs.hackhub.model.entity.Hackathon;
import it.unicam.cs.hackhub.model.entity.Submission;
import it.unicam.cs.hackhub.model.entity.User;
import it.unicam.cs.hackhub.model.mapper.EvaluationMapper;
import it.unicam.cs.hackhub.core.repository.EvaluationRepository;
import it.unicam.cs.hackhub.core.repository.UserRepository;
import it.unicam.cs.hackhub.core.state.HackathonStateService;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class EvaluationService implements Service<Evaluation, EvaluationInput, EvaluationOutput> {

    private final EvaluationRepository evaluationRepository;
    private final UserRepository userRepository;
    private final SubmissionService submissionService;
    private final HackathonStateService stateService;
    private final EvaluationMapper evaluationMapper;

    public EvaluationService(EvaluationRepository evaluationRepository, UserRepository userRepository,
                             SubmissionService submissionService, HackathonStateService stateService,
                             EvaluationMapper evaluationMapper) {
        this.evaluationRepository = evaluationRepository;
        this.userRepository = userRepository;
        this.submissionService = submissionService;
        this.stateService = stateService;
        this.evaluationMapper = evaluationMapper;
    }

    @Override
    public EvaluationOutput create(EvaluationInput input) throws ServiceException {
        Submission submission = submissionService.getEntityById(input.getSubmissionId());
        User judge = userRepository.findById(input.getJudgeId()).orElseThrow(() -> new ServiceException(ErrorCode.NOT_FOUND, "Judge not found"));
        Hackathon hackathon = submission.getHackathon();
        String id = UUID.randomUUID().toString();
        Evaluation evaluation = evaluationMapper.toEntity(input, id, submission, judge);
        stateService.getHandler(hackathon.getState()).submitEvaluation(hackathon, evaluation);
        evaluationRepository.save(evaluation);
        submission.setEvaluation(evaluation);
        return evaluationMapper.toOutDto(evaluation);
    }

    @Override
    public EvaluationOutput getById(String id) throws ServiceException {
        Evaluation entity = evaluationRepository.findById(id).orElseThrow(() -> new ServiceException(ErrorCode.NOT_FOUND, "Evaluation not found: " + id));
        return evaluationMapper.toOutDto(entity);
    }

    @Override
    public List<EvaluationOutput> getAll() throws ServiceException {
        return evaluationRepository.findAll().stream().map(evaluationMapper::toOutDto).collect(Collectors.toList());
    }

    @Override
    public EvaluationOutput update(String id, EvaluationInput input) throws ServiceException {
        Evaluation existing = evaluationRepository.findById(id).orElseThrow(() -> new ServiceException(ErrorCode.NOT_FOUND, "Evaluation not found: " + id));
        evaluationMapper.updateEntity(input, existing);
        evaluationRepository.update(id, existing);
        return evaluationMapper.toOutDto(existing);
    }

    @Override
    public void delete(String id) throws ServiceException {
        evaluationRepository.delete(id);
    }
}
