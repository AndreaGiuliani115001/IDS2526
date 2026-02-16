package it.unicam.cs.hackhub.common;

import java.util.List;
import java.util.Optional;

/**
 * Base repository with standard CRUD. All methods may throw
 * {@link ServiceException}.
 *
 * @param <E>  entity type
 * @param <ID> id type
 */
public interface Repository<E, ID> {

    E save(E entity) throws ServiceException;

    Optional<E> findById(ID id) throws ServiceException;

    List<E> findAll() throws ServiceException;

    void delete(ID id) throws ServiceException;

    E update(ID id, E entity) throws ServiceException;
}
