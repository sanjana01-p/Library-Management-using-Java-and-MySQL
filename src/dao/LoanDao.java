package dao;

import model.Loan;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class LoanDao {
    public void issueLoan(Loan loan) {
        String sql = "INSERT INTO loans (loanId, bookId, memberId, loanDate, dueDate, returnDate) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, loan.getLoanId());
            pstmt.setInt(2, loan.getBookId());
            pstmt.setInt(3, loan.getMemberId());
            pstmt.setDate(4, Date.valueOf(loan.getLoanDate()));
            pstmt.setDate(5, Date.valueOf(loan.getDueDate()));
            pstmt.setDate(6, loan.getReturnDate() != null ? Date.valueOf(loan.getReturnDate()) : null);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void returnLoan(int loanId) {
        String sql = "UPDATE loans SET returnDate = ? WHERE loanId = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setDate(1, Date.valueOf(LocalDate.now()));
            pstmt.setInt(2, loanId);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Loan getLoan(int loanId) {
        String sql = "SELECT * FROM loans WHERE loanId = ?";
        Loan loan = null;
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, loanId);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                loan = new Loan();
                loan.setLoanId(rs.getInt("loanId"));
                loan.setBookId(rs.getInt("bookId"));
                loan.setMemberId(rs.getInt("memberId"));
                loan.setLoanDate(rs.getDate("loanDate").toLocalDate());
                loan.setDueDate(rs.getDate("dueDate").toLocalDate());
                loan.setReturnDate(rs.getDate("returnDate") != null ? rs.getDate("returnDate").toLocalDate() : null);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return loan;
    }

    public List<Loan> getAllLoans() {
        String sql = "SELECT * FROM loans";
        List<Loan> loans = new ArrayList<>();
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                Loan loan = new Loan();
                loan.setLoanId(rs.getInt("loanId"));
                loan.setBookId(rs.getInt("bookId"));
                loan.setMemberId(rs.getInt("memberId"));
                loan.setLoanDate(rs.getDate("loanDate").toLocalDate());
                loan.setDueDate(rs.getDate("dueDate").toLocalDate());
                loan.setReturnDate(rs.getDate("returnDate") != null ? rs.getDate("returnDate").toLocalDate() : null);
                loans.add(loan);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return loans;
    }
}
