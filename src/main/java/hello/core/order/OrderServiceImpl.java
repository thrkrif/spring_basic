package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    // DIP 위반 : 구체 클래스에도 의존하고 있음.

    //private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    // 할인 정책이 바뀌니까 클라이언트 코드를 변경해야 한다.
//    private final DiscountPolicy discountRatePolicy = new RateDiscountPolicy();

    // 해결책 : AppConfig를 만듦 : 구체 클래스를 만드는 역할 부여.
    // 이로서 OrderServiceImpl 클래스에서는 인터페이스에만 의존하게 되었음.

    private final MemberRepository memberRepository;

    private final DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }



    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = this.discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    public MemberRepository getMemberRepository() {
        return memberRepository;
    }

}
