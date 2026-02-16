package it.unicam.cs.hackhub.model.dto;

import java.util.List;

public class TeamOutput extends OutputDTO {
    private final String name;
    private final List<String> members;

    public TeamOutput(String name, List<String> members) {
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
