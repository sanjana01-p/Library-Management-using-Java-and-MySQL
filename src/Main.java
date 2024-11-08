import controller.BookController;
import controller.MemberController;
import controller.LoanController;
import dao.BookDao;
import dao.MemberDao;
import dao.LoanDao;
import model.Book;
import model.Member;
import model.Loan;
import view.BookView;
import view.MemberView;
import view.LoanView;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BookDao bookDAO = new BookDao();
        MemberDao memberDAO = new MemberDao();
        LoanDao loanDAO = new LoanDao();

        BookView bookView = new BookView();
        MemberView memberView = new MemberView();
        LoanView loanView = new LoanView();

        BookController bookController = new BookController(bookDAO, bookView);
        MemberController memberController = new MemberController(memberDAO, memberView);
        LoanController loanController = new LoanController(loanDAO, loanView);

        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nLibrary Management System:");
            System.out.println("1. Add Book");
            System.out.println("2. Update Book");
            System.out.println("3. Delete Book");
            System.out.println("4. View Book");
            System.out.println("5. List All Books");
            System.out.println("6. Add Member");
            System.out.println("7. Update Member");
            System.out.println("8. Delete Member");
            System.out.println("9. View Member");
            System.out.println("10. List All Members");
            System.out.println("11. Issue Loan");
            System.out.println("12. Return Loan");
            System.out.println("13. View Loan");
            System.out.println("14. List All Loans");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Book ID: ");
                    int bookId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Book Title: ");
                    String bookTitle = scanner.nextLine();
                    System.out.print("Enter Book Author: ");
                    String bookAuthor = scanner.nextLine();
                    Book book = new Book(bookId, bookTitle, bookAuthor, true);
                    bookController.addBook(book);
                    break;

                case 2:
                    System.out.print("Enter Book ID to Update: ");
                    int updateBookId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter New Book Title: ");
                    String updateBookTitle = scanner.nextLine();
                    System.out.print("Enter New Book Author: ");
                    String updateBookAuthor = scanner.nextLine();
                    Book updatedBook = new Book(updateBookId, updateBookTitle, updateBookAuthor,true);
                    bookController.updateBook(updatedBook);
                    break;

                case 3:
                    System.out.print("Enter Book ID to Delete: ");
                    int deleteBookId = scanner.nextInt();
                    bookController.deleteBook(deleteBookId);
                    break;

                case 4:
                    System.out.print("Enter Book ID to View: ");
                    int viewBookId = scanner.nextInt();
                    bookController.viewBook(viewBookId);
                    break;

                case 5:
                    bookController.listAllBooks();
                    break;

                case 6:
                    System.out.print("Enter Member ID: ");
                    int memberId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Member Name: ");
                    String memberName = scanner.nextLine();
                    System.out.print("Enter Member Phone Number: ");
                    String memberPhoneNumber = scanner.nextLine();
                    Member member = new Member(memberId, memberName, memberPhoneNumber);
                    memberController.addMember(member);
                    break;

                case 7:
                    System.out.print("Enter Member ID to Update: ");
                    int updateMemberId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter New Member Name: ");
                    String updateMemberName = scanner.nextLine();
                    System.out.print("Enter New Member Email: ");
                    String updateMemberPhoneNumber = scanner.nextLine();
                    Member updatedMember = new Member(updateMemberId, updateMemberName, updateMemberPhoneNumber);
                    memberController.updateMember(updatedMember);
                    break;

                case 8:
                    System.out.print("Enter Member ID to Delete: ");
                    int deleteMemberId = scanner.nextInt();
                    memberController.deleteMember(deleteMemberId);
                    break;

                case 9:
                    System.out.print("Enter Member ID to View: ");
                    int viewMemberId = scanner.nextInt();
                    memberController.viewMember(viewMemberId);
                    break;

                case 10:
                    memberController.listAllMembers();
                    break;

                case 11:
                    System.out.print("Enter Loan ID: ");
                    int loanId = scanner.nextInt();
                    System.out.print("Enter Book ID: ");
                    int loanBookId = scanner.nextInt();
                    System.out.print("Enter Member ID: ");
                    int loanMemberId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Loan Date (YYYY-MM-DD): ");
                    String loanDateStr = scanner.nextLine();
                    System.out.print("Enter Due Date (YYYY-MM-DD): ");
                    String dueDateStr = scanner.nextLine();
                    Loan loan = new Loan(loanId, loanBookId, loanMemberId, LocalDate.parse(loanDateStr), LocalDate.parse(dueDateStr), null);
                    loanController.issueLoan(loan);
                    break;

                case 12:
                    System.out.print("Enter Loan ID to Return: ");
                    int returnLoanId = scanner.nextInt();
                    loanController.returnLoan(returnLoanId);
                    break;

                case 13:
                    System.out.print("Enter Loan ID to View: ");
                    int viewLoanId = scanner.nextInt();
                    loanController.viewLoan(viewLoanId);
                    break;

                case 14:
                    loanController.listAllLoans();
                    break;

                case 0:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 0);

        scanner.close();
    }
}
