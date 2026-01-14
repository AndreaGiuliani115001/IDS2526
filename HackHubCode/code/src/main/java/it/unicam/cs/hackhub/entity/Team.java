package main.java.it.unicam.cs.hackhub.entity;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private final String name;
    private final List<User> members;

    public Team(String name) {
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
