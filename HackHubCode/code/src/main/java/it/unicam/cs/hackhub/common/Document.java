package main.java.it.unicam.cs.hackhub.common;

import java.time.Instant;
import java.util.UUID;

public abstract class Document {
    private final UUID id;
    private final Instant createdAt;

    protected Document() {
        this.id = UUID.randomUUID();
        this.createdAt = Instant.now();
    }

    public UUID getId() {
        return id;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }
}
