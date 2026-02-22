package it.unicam.cs.hackhub.core.repository;

import it.unicam.cs.hackhub.model.entity.Evaluation;
import org.springframework.stereotype.Repository;

@Repository
public class EvaluationRepositoryImpl extends InMemoryRepository<Evaluation, String> implements EvaluationRepository {

    @Override
    protected String getId(Evaluation entity) {
        return entity.getId();
    }
}
