package hello.core.autowired;

import hello.core.member.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.lang.Nullable;
import java.util.Optional;

public class AutoWiredTest {
    @Test
    void AutoWiredOption() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);
    }

    static class TestBean {
        @Autowired(required = false) // default는 true. 이 때 noBean1은 스프링 빈이 아니기 때문에 에러 발생!
        public void setNoBean1(Member noBean1) {
            System.out.println("noBean1 = " + noBean1);
            // 해당 메서드 자체가 호출이 안되므로 출력x
        }

        @Autowired
        public void setNoBean2(@Nullable Member noBean2) {
            System.out.println("noBean2 = " + noBean2);
            // noBean2 = null 출력
        }

        @Autowired
        public void setNoBean3(Optional<Member> noBean3) {
            System.out.println("noBean3 = " + noBean3);
            // noBean3 = Optional.empty 출력
        }
    }
}