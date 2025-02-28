package hello.core.member;


// 인터페이스의 구현체가 하나만 있는 경우 클래스 뒤에 Impl이라고 많이 사용한다.
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();


    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
