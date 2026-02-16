package it.unicam.cs.hackhub.model.dto;

public class UserOutput extends OutputDTO {
    private final String name;
    private final String surname;
    private final String username;
    private final String email;
    private final String role;

    public UserOutput(String name, String surname, String username, String email, String role) {
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.email = email;
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

    public String getRole() {
        return role;
    }
}
