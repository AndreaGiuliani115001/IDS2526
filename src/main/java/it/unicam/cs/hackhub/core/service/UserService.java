package it.unicam.cs.hackhub.core.service;

import it.unicam.cs.hackhub.common.ErrorCode;
import it.unicam.cs.hackhub.common.Service;
import it.unicam.cs.hackhub.common.ServiceException;
import it.unicam.cs.hackhub.model.dto.UserInput;
import it.unicam.cs.hackhub.model.dto.UserOutput;
import it.unicam.cs.hackhub.model.entity.User;
import it.unicam.cs.hackhub.model.mapper.UserMapper;
import it.unicam.cs.hackhub.core.repository.UserRepository;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class UserService implements Service<User, UserInput, UserOutput> {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    // --- AUTHENTICATION & REGISTRATION ---

    /**
     * Registers a new user. Throws INVALID_INPUT if username or email already
     * exists.
     */
    public UserOutput register(UserInput input) throws ServiceException {
        if (userRepository.findByUsername(input.getUsername()).isPresent()) {
            throw new ServiceException(ErrorCode.INVALID_INPUT, "Username already exists");
        }
        if (userRepository.findByEmail(input.getEmail()).isPresent()) {
            throw new ServiceException(ErrorCode.INVALID_INPUT, "Email already exists");
        }
        String id = UUID.randomUUID().toString();
        String passwordHash = hashPassword(input.getPassword());
        User user = userMapper.toEntity(input, id, passwordHash);
        userRepository.save(user);
        return userMapper.toOutDto(user);
    }

    /**
     * Authenticates user by username and password.
     * If user not found → USER_NOT_FOUND; if password mismatch →
     * INVALID_CREDENTIALS.
     */
    public UserOutput login(String username, String password) throws ServiceException {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new ServiceException(ErrorCode.USER_NOT_FOUND, "User not found"));
        if (!verifyPassword(password, user.getPasswordHash())) {
            throw new ServiceException(ErrorCode.INVALID_CREDENTIALS, "Invalid password");
        }
        return userMapper.toOutDto(user);
    }

    // --- MILESTONE CRUD BASE COMPLETO ---

    @Override
    public UserOutput create(UserInput input) throws ServiceException {
        return register(input);
    }

    @Override
    public UserOutput getById(String id) throws ServiceException {
        User entity = userRepository.findById(id)
                .orElseThrow(() -> new ServiceException(ErrorCode.NOT_FOUND, "User not found: " + id));
        return userMapper.toOutDto(entity);
    }

    @Override
    public List<UserOutput> getAll() throws ServiceException {
        return userRepository.findAll().stream()
                .map(userMapper::toOutDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserOutput update(String id, UserInput input) throws ServiceException {
        User existing = userRepository.findById(id)
                .orElseThrow(() -> new ServiceException(ErrorCode.NOT_FOUND, "User not found: " + id));
        userMapper.updateEntity(input, existing);
        userRepository.update(id, existing);
        return userMapper.toOutDto(existing);
    }

    @Override
    public void delete(String id) throws ServiceException {
        userRepository.delete(id);
    }

    private static String hashPassword(String password) {
        if (password == null)
            return "";
        return java.util.Base64.getEncoder().encodeToString(password.getBytes(java.nio.charset.StandardCharsets.UTF_8));
    }

    private static boolean verifyPassword(String raw, String hashed) {
        if (raw == null && hashed == null)
            return true;
        if (raw == null || hashed == null)
            return false;
        return hashed.equals(hashPassword(raw));
    }
}