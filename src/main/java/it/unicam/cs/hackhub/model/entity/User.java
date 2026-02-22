package it.unicam.cs.hackhub.model.entity;

import it.unicam.cs.hackhub.common.Document;
import it.unicam.cs.hackhub.common.Role;
import jakarta.persistence.*;

@Entity
@Table(name = "app_users")
public class User extends Document {
    private String name;
    private String surname;
    private String username;
    private String email;
    private String passwordHash;

    @Enumerated(EnumType.STRING)
    private Role role;

    public User() {
        super();
    }

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

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}