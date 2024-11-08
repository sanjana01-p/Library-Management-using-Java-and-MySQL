package view;

import model.Book;

import java.util.List;

public class BookView {
    public void displayBookDetails(Book book) {
        System.out.println("Id: " + book.getId());
        System.out.println("Name: " + book.getName());
        System.out.println("Author: " + book.getAuthor());
    }

    public void displayAllBooks(List<Book> books) {
        for(Book book: books) {
            displayBookDetails(book);
            System.out.println();
        }
    }
}
