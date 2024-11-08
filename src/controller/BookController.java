package controller;

import dao.BookDao;
import model.Book;
import view.BookView;

import java.util.List;

public class BookController {
    private BookDao bookDAO;
    private BookView bookView;

    public BookController(BookDao bookDAO, BookView bookView) {
        this.bookDAO = bookDAO;
        this.bookView = bookView;
    }

    public void addBook(Book book) {
        bookDAO.addBook(book);
    }

    public void updateBook(Book book) {
        bookDAO.updateBook(book);
    }

    public void deleteBook(int bookId) {
        bookDAO.deleteBook(bookId);
    }

    public void viewBook(int bookId) {
        Book book = bookDAO.getBook(bookId);
        bookView.displayBookDetails(book);
    }

    public void listAllBooks() {
        List<Book> books = bookDAO.getAllBooks();
        bookView.displayAllBooks(books);
    }
}
