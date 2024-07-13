import data.Book;

import java.util.ArrayList;
import java.util.List;

public class HomeModel {
    List<Book> books;

    HomeModel() {
         books = new ArrayList<>();
         books.add(new Book("How to lick?", "xxx123", 10, "Sanjana"));
         books.add(new Book("My life with a cat", "xxx124", 10, "Deepak"));
         books.add(new Book("Meow my wife", "xxx125", 2, "Deepak"));
    }


    List<Book> getBooks() {
        return books;
    }
}
