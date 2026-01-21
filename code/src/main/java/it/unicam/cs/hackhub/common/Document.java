package main.java.it.unicam.cs.hackhub.common;

import java.time.Instant;

public abstract class Document {
    private final Instant createdAt;
    private final Instant updatedAt;
    private final Instant deletedAt;
    private final Boolean active;

    protected Document(Instant createdAt, Instant updatedAt, Instant deletedAt, Boolean active) {
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.deletedAt = deletedAt;
        this.active = active;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public Instant getDeletedAt() {
        return deletedAt;
    }

    public Boolean getActive() {
        return active;
    }
}
