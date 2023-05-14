package model;

import java.util.ArrayList;
import java.util.List;
import pattern.composite.LibraryItem;

public class LibrarySection extends LibraryItem {
    private final List<LibraryItem> items;

    public LibrarySection() {
        items = new ArrayList<>();
    }

    public void addItem(LibraryItem item) {
        items.add(item);
    }

    @Override
    public void display() {
        for (LibraryItem item : items) {
            item.display();
        }
    }
}
