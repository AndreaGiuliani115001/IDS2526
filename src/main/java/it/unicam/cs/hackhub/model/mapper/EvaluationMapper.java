package it.unicam.cs.hackhub.model.mapper;

import it.unicam.cs.hackhub.common.ModelMapper;
import it.unicam.cs.hackhub.model.dto.EvaluationInput;
import it.unicam.cs.hackhub.model.dto.EvaluationOutput;
import it.unicam.cs.hackhub.model.entity.Evaluation;
import it.unicam.cs.hackhub.model.entity.Submission;
import it.unicam.cs.hackhub.model.entity.User;

public class EvaluationMapper implements ModelMapper<Evaluation, EvaluationInput, EvaluationOutput> {

    @Override
    public Evaluation toEntity(EvaluationInput dto) {
        throw new UnsupportedOperationException(
                "Use toEntity(EvaluationInput, String id, Submission submission, User judge) for Evaluation");
    }

    /**
     * Creates an Evaluation entity; submission and judge must be resolved by the
     * service.
     */
    public Evaluation toEntity(EvaluationInput dto, String id, Submission submission, User judge) {
        Integer score = dto.getScore() != null ? dto.getScore().intValue() : null;
        Evaluation evaluation = new Evaluation(submission, judge, score, dto.getComment());
        evaluation.setId(id);
        return evaluation;
    }

    @Override
    public EvaluationOutput toOutDto(Evaluation entity) {
        Double score = entity.getScore() != null ? entity.getScore().doubleValue() : null;
        return new EvaluationOutput(
                entity.getSubmission().getId(),
                entity.getJudge().getId(),
                score,
                entity.getDescription());
    }

    @Override
    public void updateEntity(EvaluationInput dto, Evaluation entity) {
        throw new UnsupportedOperationException("Evaluation is immutable");
    }
}
