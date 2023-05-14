package pattern.strategy;

import java.util.List;
import model.Book;

public class TitleSearchStrategy implements SearchStrategy {
    @Override
    public List<Book> search(List<Book> books, String query) {
        return books.stream().filter(book -> book.getTitle().equals(query)).toList();
    }
}
