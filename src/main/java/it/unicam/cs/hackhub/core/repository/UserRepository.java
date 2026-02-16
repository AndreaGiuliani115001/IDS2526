package it.unicam.cs.hackhub.core.repository;

import it.unicam.cs.hackhub.common.Repository;
import it.unicam.cs.hackhub.common.ServiceException;
import it.unicam.cs.hackhub.model.entity.User;

import java.util.Optional;

public interface UserRepository extends Repository<User, String> {

    Optional<User> findByUsername(String username) throws ServiceException;

    Optional<User> findByEmail(String email) throws ServiceException;
}
