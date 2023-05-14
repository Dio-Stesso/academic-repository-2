package pattern.factory;

import model.Book;
import model.Novel;
import model.Textbook;

public class BookFactory {
    public Book createBook(String type, String title) {
        if (type.equals("novel")) {
            return new Novel(title);
        } else if (type.equals("textbook")) {
            return new Textbook(title);
        } else {
            return null;
        }
    }
}
