package hello.core;

import hello.core.member.*;

public class MemberApp {
    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl(new MemoryMemberRepository());

        Member member = new Member(1L, "java", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);

        System.out.println("new member = " + member.getName()); // 등록하려는 회원
        System.out.println("find member " + findMember.getName()); // 회원 가입 되었는지 확인


    }
}
