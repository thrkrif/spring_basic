package hello.core.member;

import java.util.HashMap;
import java.util.Map;

public class MemoryMemberRepository implements MemberRepository{

    // store : 회원들의 정보를 담고 있음
    private static Map<Long, Member> store = new HashMap<>();

    // 회원 정보를 받으면 저장해둘 거임
    @Override
    public void save(Member member) {
        store.put(member.getId(), member);
    }

    // id를 입력하면 회원의 id를 가져옴
    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }
}
