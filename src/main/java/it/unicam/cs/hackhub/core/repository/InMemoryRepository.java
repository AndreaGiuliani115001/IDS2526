package it.unicam.cs.hackhub.core.repository;

import it.unicam.cs.hackhub.common.Repository;
import it.unicam.cs.hackhub.common.ServiceException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

/**
 * In-memory implementation base for repositories. Subclass and implement
 * {@link #getId(Object)} to provide entity id.
 */
public abstract class InMemoryRepository<E, ID> implements Repository<E, ID> {

    private final java.util.Map<ID, E> store = new ConcurrentHashMap<>();

    protected abstract ID getId(E entity);

    @Override
    public E save(E entity) throws ServiceException {
        ID id = getId(entity);
        if (id != null) {
            store.put(id, entity);
        }
        return entity;
    }

    @Override
    public Optional<E> findById(ID id) throws ServiceException {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public List<E> findAll() throws ServiceException {
        return new ArrayList<>(store.values());
    }

    @Override
    public void delete(ID id) throws ServiceException {
        store.remove(id);
    }

    @Override
    public E update(ID id, E entity) throws ServiceException {
        store.put(id, entity);
        return entity;
    }
}
