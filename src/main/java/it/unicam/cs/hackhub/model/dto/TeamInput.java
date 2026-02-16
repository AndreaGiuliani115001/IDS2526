package it.unicam.cs.hackhub.model.dto;

import java.util.List;

public class TeamInput extends InputDTO {
    private final String name;
    private final List<String> members;

    public TeamInput(String name, List<String> members) {
        this.name = name;
        this.members = members;
    }

    public String getName() {
        return name;
    }

    public List<String> getMembers() {
        return members;
    }
}
