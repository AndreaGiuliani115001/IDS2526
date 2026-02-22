package it.unicam.cs.hackhub.model.entity;

import it.unicam.cs.hackhub.common.Document;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "teams")
public class Team extends Document {
    private String name;

    @ManyToMany
    private List<User> members;

    public Team() {
        super();
        this.members = new ArrayList<>();
    }

    public Team(String name) {
        super();
        this.name = name;
        this.members = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<User> getMembers() {
        return members;
    }
}
