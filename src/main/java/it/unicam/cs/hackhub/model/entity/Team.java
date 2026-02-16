package it.unicam.cs.hackhub.model.entity;

import it.unicam.cs.hackhub.common.Document;

import java.util.ArrayList;
import java.util.List;

public class Team extends Document {
    private final String name;
    private final List<User> members;

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
