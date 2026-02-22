package it.unicam.cs.hackhub.core.repository;

import it.unicam.cs.hackhub.model.entity.Team;
import org.springframework.stereotype.Repository;

@Repository
public class TeamRepositoryImpl extends InMemoryRepository<Team, String> implements TeamRepository {

    @Override
    protected String getId(Team entity) {
        return entity.getId();
    }
}
