package view;

import model.Member;

import java.util.List;

public class MemberView {
    public void displayMemberDetails(Member member) {
        System.out.println("Name: "+member.getName());
        System.out.println("Member-ID: "+member.getId());
        System.out.println("Phone Number: "+member.getPhoneNumber());
    }

    public void displayAllMemberDetails(List<Member> members) {
        for(Member member : members) {
            displayMemberDetails(member);
        }
    }
}
