package it.unicam.cs.hackhub.core.repository;

import it.unicam.cs.hackhub.model.entity.Team;

public class TeamRepositoryImpl extends InMemoryRepository<Team, String> implements TeamRepository {

    @Override
    protected String getId(Team entity) {
        return entity.getId();
    }
}
