package view;

import model.Loan;

import java.util.List;

public class LoanView {
    public void displayLoanDetails(Loan loan) {
        System.out.println("Loan ID: "+ loan.getLoanId());
        System.out.println("Book ID: "+ loan.getBookId());
        System.out.println("Member ID: "+ loan.getMemberId());
        System.out.println("Loan Date: "+ loan.getLoanDate());
        System.out.println("Due Date: "+ loan.getDueDate());
        System.out.println("Return Date: "+ loan.getReturnDate());
        System.out.println("Overdue: "+ (loan.isOverdue() ? "Yes" : "No"));
    }
    public void displayAllLoanDetails(List<Loan> loans) {
        for (Loan loan : loans) {
            displayLoanDetails(loan);
            System.out.println();
        }
    }
}
