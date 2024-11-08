package controller;

import dao.LoanDao;
import model.Loan;
import view.LoanView;

import java.util.List;

public class LoanController {
    private LoanDao loanDAO;
    private LoanView loanView;

    public LoanController(LoanDao loanDAO, LoanView loanView) {
        this.loanDAO = loanDAO;
        this.loanView = loanView;
    }

    public void issueLoan(Loan loan) {
        loanDAO.issueLoan(loan);
    }

    public void returnLoan(int loanId) {
        loanDAO.returnLoan(loanId);
    }

    public void viewLoan(int loanId) {
        Loan loan = loanDAO.getLoan(loanId);
        loanView.displayLoanDetails(loan);
    }

    public void listAllLoans() {
        List<Loan> loans = loanDAO.getAllLoans();
        loanView.displayAllLoanDetails(loans);
    }
}
