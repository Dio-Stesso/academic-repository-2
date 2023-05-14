import java.util.List;
import model.Book;
import model.User;
import pattern.singleton.Library;
import pattern.factory.BookFactory;
import pattern.strategy.SearchStrategy;
import pattern.strategy.TitleSearchStrategy;
import pattern.strategy.TypeStrategySearch;
import pattern.template.OverdueReport;
import pattern.template.Report;

public class LibraryApplication {
    public static void main(String[] args) {
        // Singleton pattern: only one instance of the pattern.singleton.Library class is created
        Library library = Library.getInstance();

        // Factory Method pattern: create different types of books using a factory
        BookFactory bookFactory = new BookFactory();
        Book book1 = bookFactory.createBook("novel", "book 1");
        Book book2 = bookFactory.createBook("textbook", "book 2");

        library.addBook(book1);
        library.addBook(book2);
        library.addBook(new Book("The Great Gatsby"));

        // Observer pattern: notify users when a book is returned
        User user1 = new User();
        User user2 = new User();
        library.addObserver(user1);
        library.addObserver(user2);
        user1.update(Library.getInstance(), book1);

        // Strategy pattern: different search strategies can be used to find books
        SearchStrategy searchStrategy = new TitleSearchStrategy();
        library.setSearchStrategy(searchStrategy);
        List<Book> results = library.search("The Great Gatsby");
        // Output: Book: The Great Gatsby. Type: null
        results.forEach(Book::display);

        SearchStrategy searchStrategy2 = new TypeStrategySearch();
        library.setSearchStrategy(searchStrategy2);
        List<Book> novels = library.search("Novel");
        // Output: Book: book 1. Type: Novel
        novels.forEach(Book::display);

        // Template Method pattern: different types of reports can be generated
        Report report = new OverdueReport();
        report.generate(library);
    }
}
