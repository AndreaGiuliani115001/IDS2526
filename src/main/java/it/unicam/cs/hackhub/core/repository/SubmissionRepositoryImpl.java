package it.unicam.cs.hackhub.core.repository;

import it.unicam.cs.hackhub.model.entity.Submission;
import org.springframework.stereotype.Repository;

@Repository
public class SubmissionRepositoryImpl extends InMemoryRepository<Submission, String> implements SubmissionRepository {

    @Override
    protected String getId(Submission entity) {
        return entity.getId();
    }
}
