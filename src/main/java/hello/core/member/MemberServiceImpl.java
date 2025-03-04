package hello.core.member;


// 인터페이스의 구현체가 하나만 있는 경우 클래스 뒤에 Impl이라고 많이 사용한다.
public class MemberServiceImpl implements MemberService {

    // 추상화(MemberRepository)에도 의존하고 구체화(MemoryMemberRepository)에도 의존하게 된다. DIP 위반
    private final MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
