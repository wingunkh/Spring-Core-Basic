package hello.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberServiceImpl implements MemberService {
    private final MemberRepository memberRepository;

    @Autowired
    // 생성자에 @Autowired 어노테이션을 붙히면 스프링 컨테이너가 자동으로 해당 스프링 빈을 찾아서 주입한다.
    // 이 때 기본 조회 전략은 타입이 같은 빈을 찾아서 주입한다.

    // 생성자 주입의 장점
    // 1. 생성자는 객체를 생성할 때 딱 한번만 호출되므로 불변성을 보장한다.
    // 2. 프레임워크 없이 순수한 자바 코드 단위 테스트 중 주입 데이터를 누락했을 시 실행 중 오류가 아닌 컴파일 오류가 발생한다.
    // 3. 필드에 final 키워드를 사용할 수 있다. 그러므로 생성자에서 혹시 값이 설정되지 않았을 경우 컴파일 오류가 발생한다.
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

    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}