package data;

public class Book {
    private final String name;
    private String id;
    private int copies;
    private String author;

    public Book(String name, String id, int copies, String author) {
        this.name = name;
        this.id = id;
        this.copies = copies;
        this.author = author;
    }

    public void showBook() {
        System.out.println("Name: " + name);
        System.out.println("Id: " + id);
        System.out.println("Copies available: " + copies);
        System.out.println("Author: " + author);
    }
}
