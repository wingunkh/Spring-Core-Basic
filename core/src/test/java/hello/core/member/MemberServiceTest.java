package hello.core.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {
    MemberService memberService = new MemberServiceImpl();

    @Test
    void join() {
        // given, 테스트의 초기 상황
        Member member = new Member(1L, "memberA", Grade.VIP);

        // when, 테스트가 적용되는 특정 액션 또는 이벤트
        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        // then, 테스트의 기대 결과
        Assertions.assertThat(member).isEqualTo(findMember);
    }
}