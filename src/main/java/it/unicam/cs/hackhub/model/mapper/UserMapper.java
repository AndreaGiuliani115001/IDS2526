package it.unicam.cs.hackhub.model.mapper;

import it.unicam.cs.hackhub.common.ModelMapper;
import it.unicam.cs.hackhub.common.Role;
import it.unicam.cs.hackhub.model.dto.UserInput;
import it.unicam.cs.hackhub.model.dto.UserOutput;
import it.unicam.cs.hackhub.model.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper implements ModelMapper<User, UserInput, UserOutput> {

    @Override
    public User toEntity(UserInput dto) {
        throw new UnsupportedOperationException("Use toEntity(UserInput, String id, String passwordHash) for User");
    }

    /**
     * Creates a User entity from input and generated id/hash (service
     * responsibility).
     */
    public User toEntity(UserInput dto, String id, String passwordHash) {
        Role role = dto.getRole() == null ? Role.MEMBER : Role.valueOf(dto.getRole().toUpperCase());
        User user = new User(dto.getName(), dto.getSurname(), dto.getUsername(), dto.getEmail(), passwordHash, role);
        user.setId(id);
        return user;
    }

    @Override
    public UserOutput toOutDto(User entity) {
        return new UserOutput(
                entity.getId(),
                entity.getName(),
                entity.getSurname(),
                entity.getUsername(),
                entity.getEmail(),
                entity.getRole().name());
    }

    @Override
    public void updateEntity(UserInput dto, User entity) {
        throw new UnsupportedOperationException("User is immutable; create new entity for updates");
    }
}
