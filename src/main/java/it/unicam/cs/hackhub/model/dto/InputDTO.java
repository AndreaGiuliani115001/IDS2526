package it.unicam.cs.hackhub.model.dto;

import java.time.Instant;

public abstract class InputDTO {
    private Instant time;
    private String operationType;

    public Instant getTime() {
        return time;
    }

    public void setTime(Instant time) {
        this.time = time;
    }

    public String getOperationType() {
        return operationType;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }
}
