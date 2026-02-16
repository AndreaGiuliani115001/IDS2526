package it.unicam.cs.hackhub.model.entity;

import it.unicam.cs.hackhub.common.Document;

public class Username extends Document {
    private final String value;

    public Username(String value) {
        super();
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
