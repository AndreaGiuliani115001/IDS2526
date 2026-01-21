package main.java.it.unicam.cs.hackhub.dto;

import java.util.List;

public class SubmissionInput {
    private final String name;
    private final String description;
    private final List<String> attachments;

    public SubmissionInput(String name, String description, List<String> attachments) {
        this.name = name;
        this.description = description;
        this.attachments = attachments;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public List<String> getAttachments() {
        return attachments;
    }
}
