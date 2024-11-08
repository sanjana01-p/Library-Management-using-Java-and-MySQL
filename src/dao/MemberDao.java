package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Member;
public class MemberDao {
    public void addMember(Member member) {
        String sql = "INSERT INTO members (id, name, phoneNumber) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, member.getId());
            pstmt.setString(2, member.getName());
            pstmt.setString(3, member.getPhoneNumber());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateMember(Member member) {
        String sql = "UPDATE members SET name = ?, phoneNumber = ? WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, member.getName());
            pstmt.setString(2, member.getPhoneNumber());
            pstmt.setInt(3, member.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteMember(int memberId) {
        String sql = "DELETE FROM members WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, memberId);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Member getMember(int memberId) {
        String sql = "SELECT * FROM members WHERE id = ?";
        Member member = null;
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, memberId);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                member = new Member();
                member.setId(rs.getInt("id"));
                member.setName(rs.getString("name"));
                member.setPhoneNumber(rs.getString("phoneNumber"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return member;
    }

    public List<Member> getAllMembers() {
        String sql = "SELECT * FROM members";
        List<Member> members = new ArrayList<>();
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                Member member = new Member();
                member.setId(rs.getInt("id"));
                member.setName(rs.getString("name"));
                member.setPhoneNumber(rs.getString("phoneNumber"));
                members.add(member);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return members;
    }
}
