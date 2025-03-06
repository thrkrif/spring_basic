package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.*;

public class SingletonTest {

    @Test
    @DisplayName("싱글톤 패턴을 적용(Eager Initialization)")
    void singletonServiceTest(){
        // 두 변수의 참조값이 같은지 확인
        SingletonService instance1 = SingletonService.getInstance();
        SingletonService instance2 = SingletonService.getInstance();

        // assertThat(instance1).isInstanceOf(instance2.getClass()); // 같은 클래스인지 비교
        assertThat(instance1).isSameAs(instance2); // ==, 객체 주소가 같은지 비교
        // assertThat(instance1).isEqualTo(instance2); // equals, 내용이 동일한지 비교
    }

    @Test
    @DisplayName("스프링 컨테이너와 싱글톤")
    void SpringContainer(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberService memberService1 = ac.getBean("memberService", MemberService.class);
        MemberService memberService2 = ac.getBean("memberService", MemberService.class);


    }
}
