package it.unicam.cs.hackhub.model.dto;

public class UserInput extends InputDTO {
    private final String name;
    private final String surname;
    private final String username;
    private final String email;
    private final String password;
    private final String role;

    public UserInput(String name, String surname, String username, String email, String password, String role) {
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.email = email;
        this.password = password;
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

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }
}
