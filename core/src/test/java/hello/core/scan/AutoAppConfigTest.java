package hello.core.scan;

import hello.core.AutoAppConfig;
import hello.core.member.MemberService;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import static org.assertj.core.api.Assertions.*;

public class AutoAppConfigTest {
    @Test
    void basicScan() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);

        MemberService memberService = ac.getBean(MemberService.class);
        assertThat(memberService).isInstanceOf(MemberService.class);
    }
    // 타입 조회 시 선택된 빈이 2개 이상이기 때문에 NoUniqueBeanDefinitionException 발생
    // 해결 방법
    // 1. @Autowired 파라미터명 매칭
    // 2. @Qualifier 어노테이션 (추가 구분자)
    // 3. @Primary 어노테이션 (우선순위 지정)
}