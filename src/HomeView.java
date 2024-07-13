import data.Book;

import java.util.List;
import java.util.Scanner;


// static methods can be used using class name
// general methods should be used using object of the class

// HomeController object is created as class variable because
// we need to access it everywhere in the class

public class HomeView {
    Scanner sc;
    HomeController homeController;

    HomeView() {
        sc = new Scanner(System.in);
        homeController = new HomeController();
    }

    public void start() {
        int option = showMenu();
        System.out.println("--------------------");
        if (homeController.validateOption(option)) {
            homeController.executeOption(option);
        } else {
            System.out.println("Invalid option pls select available option.");
            start();
        }
    }

    private int showMenu() {
        System.out.println("Welcome!!!");
        System.out.println("1. Search book");
        System.out.println("2. Borrow book");
        System.out.println("3. Return book");
        System.out.print("Enter your option: ");
        return sc.nextInt();
    }

    void showBooks(List<Book> books) {
        for(Book book: books) {
            book.showBook();
        }
    }
}
