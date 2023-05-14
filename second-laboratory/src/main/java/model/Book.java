package model;

import pattern.composite.LibraryItem;

public class Book extends LibraryItem {
    private final String title;
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public Book(String title) {
        this.title = title;
    }

    @Override
    public void display() {
        System.out.println("Book: " + title + ". Type: " + type);
    }
}
