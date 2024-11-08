package controller;

import dao.MemberDao;
import model.Member;
import view.MemberView;

import java.util.List;

public class MemberController {
    private MemberDao memberDAO;
    private MemberView memberView;

    public MemberController(MemberDao memberDAO, MemberView memberView) {
        this.memberDAO = memberDAO;
        this.memberView = memberView;
    }

    public void addMember(Member member) {
        memberDAO.addMember(member);
    }

    public void updateMember(Member member) {
        memberDAO.updateMember(member);
    }

    public void deleteMember(int memberId) {
        memberDAO.deleteMember(memberId);
    }

    public void viewMember(int memberId) {
        Member member = memberDAO.getMember(memberId);
        memberView.displayMemberDetails(member);
    }

    public void listAllMembers() {
        List<Member> members = memberDAO.getAllMembers();
        memberView.displayAllMemberDetails(members);
    }
}
