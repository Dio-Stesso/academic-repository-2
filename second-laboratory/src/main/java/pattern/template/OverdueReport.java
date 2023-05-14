package pattern.template;

import model.Book;
import pattern.singleton.Library;

public class OverdueReport extends Report {
    @Override
    protected void printHeader() {
        System.out.println("- Library -");
    }

    @Override
    protected void printBody(Library library) {
        library.getBooks().forEach(Book::display);
    }

    @Override
    protected void printFooter() {
        System.out.println("Instance: " + Library.getInstance());
    }
}
