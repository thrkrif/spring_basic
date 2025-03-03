package hello.core.discount;

import hello.core.member.Member;

public interface DiscountPolicy {

    /*
    return 값 : 얼마 할인 할건지
     */
    int discount(Member member, int price);

}
