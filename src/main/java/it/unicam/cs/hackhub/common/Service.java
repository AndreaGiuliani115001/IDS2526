package it.unicam.cs.hackhub.common;

import java.util.List;

/**
 * Base service for CRUD operations. All methods may throw
 * {@link ServiceException}.
 *
 * @param <E>   entity type
 * @param <IN>  input DTO type
 * @param <OUT> output DTO type
 */
public interface Service<E, IN, OUT> {

    OUT create(IN input) throws ServiceException;

    OUT getById(String id) throws ServiceException;

    List<OUT> getAll() throws ServiceException;

    OUT update(String id, IN input) throws ServiceException;

    void delete(String id) throws ServiceException;
}
