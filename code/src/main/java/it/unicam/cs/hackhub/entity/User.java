package main.java.it.unicam.cs.hackhub.entity;

import main.java.it.unicam.cs.hackhub.common.Role;

public class User {
    private final String id;
    private final String name;
    private final String surname;
    private final String username;
    private final String email;
    private final String passwordHash;
    private final Role role;
    
    public User(String id, String name, String surname, String username, String email, String passwordHash, Role role) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.email = email;
        this.passwordHash = passwordHash;
        this.role = role;
    }
    
    public String getId() {
        return id;
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
