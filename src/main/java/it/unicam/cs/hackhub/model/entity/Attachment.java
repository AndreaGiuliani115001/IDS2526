package it.unicam.cs.hackhub.model.entity;

import it.unicam.cs.hackhub.common.Document;
import jakarta.persistence.*;

@Entity
@Table(name = "attachments")
public class Attachment extends Document {
    private String name;
    private String url;

    public Attachment() {
        super();
    }

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
