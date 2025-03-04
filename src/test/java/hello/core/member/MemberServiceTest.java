package hello.core.member;

import hello.core.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {
    MemberService memberService;

    // Test를 실행하기 전에 실행된다.
    // @Test가 두 개가 있다면 각각 두 번 돌아간다.
    @BeforeEach
    public void beforeEach(){
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
    }

    @Test
    void join(){
        //given
        Member member = new Member(1L, "memberA", Grade.VIP);

        //when
        memberService.join(member); // 회원 가입을 시킴
        Member findMember = memberService.findMember(member.getId());

        //then 검증 로직
        // 등록하려는 회원 : member, 회원 가입된 회원 : findMember 둘이 일치하면 회원가입이 제대로 작동한 것임.
        Assertions.assertThat(member).isEqualTo(findMember);
    }
}
