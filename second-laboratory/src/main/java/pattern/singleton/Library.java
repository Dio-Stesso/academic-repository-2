package pattern.singleton;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import model.Book;
import pattern.strategy.SearchStrategy;

public class Library extends Observable {
    private static Library instance;
    private final List<Book> books;
    private SearchStrategy searchStrategy;

    private Library() {
        books = new ArrayList<>();
    }

    public static Library getInstance() {
        if (instance == null) {
            instance = new Library();
        }
        return instance;
    }

    public void addBook(Book book) {
        books.add(book);
        setChanged();
        notifyObservers(book);
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setSearchStrategy(SearchStrategy searchStrategy) {
        this.searchStrategy = searchStrategy;
    }

    public List<Book> search(String query) {
        return searchStrategy.search(books, query);
    }
}
