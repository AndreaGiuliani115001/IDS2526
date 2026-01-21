package main.java.it.unicam.cs.hackhub.entity;

public class Username {
    private final String id;
    private final String value;

    public Username(String id, String value) {
        this.id = id;
        this.value = value;
    }

    public String getId() {
        return id;
    }

    public String getValue() {
        return value;
    }
}
