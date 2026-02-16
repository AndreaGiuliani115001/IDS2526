package it.unicam.cs.hackhub.core.repository;

import it.unicam.cs.hackhub.model.entity.Submission;

public class SubmissionRepositoryImpl extends InMemoryRepository<Submission, String> implements SubmissionRepository {

    @Override
    protected String getId(Submission entity) {
        return entity.getId();
    }
}
