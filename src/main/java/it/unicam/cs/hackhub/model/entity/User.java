package it.unicam.cs.hackhub.model.entity;

import it.unicam.cs.hackhub.common.Document;
import it.unicam.cs.hackhub.common.Role;

public class User extends Document {
    private final String name;
    private final String surname;
    private final String username;
    private final String email;
    private final String passwordHash;
    private final Role role;

    public User(String name, String surname, String username, String email, String passwordHash, Role role) {
        super();
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.email = email;
        this.passwordHash = passwordHash;
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public Role getRole() {
        return role;
    }
}
