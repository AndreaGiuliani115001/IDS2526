package it.unicam.cs.hackhub.core.repository;

import it.unicam.cs.hackhub.model.entity.Evaluation;

public class EvaluationRepositoryImpl extends InMemoryRepository<Evaluation, String> implements EvaluationRepository {

    @Override
    protected String getId(Evaluation entity) {
        return entity.getId();
    }
}
