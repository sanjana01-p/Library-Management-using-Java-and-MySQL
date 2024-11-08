package model;

public class Book {
    private String name;
    private int id;
    private String author;
    private boolean isAvailable;

    public Book() {}
    public Book(int id, String name, String author, boolean isAvailable) {
        this.id = id;
        this.name = name;
        this. author = author;
        this.isAvailable = isAvailable;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }


    public String getAuthor() {
        return author;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }


    public void setAuthor(String author) {
        this.author = author;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public void checkOut() {
        isAvailable = false;
    }

    public void returnBook() {
        isAvailable = true;
    }

}
