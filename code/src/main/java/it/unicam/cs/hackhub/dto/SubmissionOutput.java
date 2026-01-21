package main.java.it.unicam.cs.hackhub.dto;

import java.time.Instant;
import java.util.List;

public class SubmissionOutput {
    private final String name;
    private final String description;
    private final Instant date;
    private final List<String> attachments;

    public SubmissionOutput(String name, String description, Instant date, List<String> attachments) {
        this.name = name;
        this.description = description;
        this.date = date;
        this.attachments = attachments;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Instant getDate() {
        return date;
    }

    public List<String> getAttachments() {
        return attachments;
    }
}
