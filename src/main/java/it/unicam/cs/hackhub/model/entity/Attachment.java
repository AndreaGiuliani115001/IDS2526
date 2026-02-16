package it.unicam.cs.hackhub.model.entity;

import it.unicam.cs.hackhub.common.Document;

public class Attachment extends Document {
    private final String name;
    private final String url;

    public Attachment(String name, String url) {
        super();
        this.name = name;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }
}
