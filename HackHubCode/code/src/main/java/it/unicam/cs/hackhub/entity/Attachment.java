package main.java.it.unicam.cs.hackhub.entity;

public class Attachment {
    private final String name;
    private final String url;

    public Attachment(String name, String url) {
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
