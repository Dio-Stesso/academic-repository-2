package model;

import java.awt.print.Book;
import java.util.Observable;
import java.util.Observer;
import pattern.singleton.Library;

public class User implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof Library && arg instanceof Book) {
            System.out.println("A new book has been added to the library: " + arg);
        }
    }
}
