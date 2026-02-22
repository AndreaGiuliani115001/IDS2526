package it.unicam.cs.hackhub.core.repository;

import it.unicam.cs.hackhub.common.ServiceException;
import it.unicam.cs.hackhub.model.entity.User;

import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class UserRepositoryImpl extends InMemoryRepository<User, String> implements UserRepository {

    private final java.util.Map<String, User> byUsername = new ConcurrentHashMap<>();
    private final java.util.Map<String, User> byEmail = new ConcurrentHashMap<>();

    @Override
    protected String getId(User entity) {
        return entity.getId();
    }

    @Override
    public User save(User entity) throws ServiceException {
        super.save(entity);
        byUsername.put(entity.getUsername().toLowerCase(), entity);
        byEmail.put(entity.getEmail().toLowerCase(), entity);
        return entity;
    }

    @Override
    public User update(String id, User entity) throws ServiceException {
        findById(id).ifPresent(u -> {
            byUsername.remove(u.getUsername().toLowerCase());
            byEmail.remove(u.getEmail().toLowerCase());
        });
        super.update(id, entity);
        byUsername.put(entity.getUsername().toLowerCase(), entity);
        byEmail.put(entity.getEmail().toLowerCase(), entity);
        return entity;
    }

    @Override
    public void delete(String id) throws ServiceException {
        findById(id).ifPresent(u -> {
            byUsername.remove(u.getUsername().toLowerCase());
            byEmail.remove(u.getEmail().toLowerCase());
        });
        super.delete(id);
    }

    @Override
    public Optional<User> findByUsername(String username) throws ServiceException {
        return Optional.ofNullable(byUsername.get(username != null ? username.toLowerCase() : null));
    }

    @Override
    public Optional<User> findByEmail(String email) throws ServiceException {
        return Optional.ofNullable(byEmail.get(email != null ? email.toLowerCase() : null));
    }
}
