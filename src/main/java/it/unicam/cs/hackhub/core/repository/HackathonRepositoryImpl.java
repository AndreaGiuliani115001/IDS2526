package it.unicam.cs.hackhub.core.repository;

import it.unicam.cs.hackhub.model.entity.Hackathon;
import org.springframework.stereotype.Repository;

@Repository
public class HackathonRepositoryImpl extends InMemoryRepository<Hackathon, String> implements HackathonRepository {

    @Override
    protected String getId(Hackathon entity) {
        return entity.getId();
    }
}
