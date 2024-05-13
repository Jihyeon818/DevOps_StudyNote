package Jihyeon.core.member;

public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository; //추상화에만 의존

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
        //생성자를 통해 구현체에 뭐가 들어갈지 선택
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
