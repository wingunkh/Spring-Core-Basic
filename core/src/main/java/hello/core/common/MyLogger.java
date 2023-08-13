package hello.core.common;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.UUID;

@Component
@Scope(value = "request")
// 웹 스코프는 웹 환경에서만 동작하며, 프로토타입과 다르게 스프링이 해당 스코프의 종료 시점까지 관리한다. 따라서 종료 메서드 역시 호출된다.
// 웹 스코프 종류 중 하나인 request의 경우 HTTP 요청 하나가 들어오고 나갈 때까지 유지되는 스코프이다.
// 각각의 HTTP 요청마다 별도의 빈 인스턴스가 생성 및 관리된다.
public class MyLogger {
    private String uuid;
    private String requestURL;

    public void setRequestURL(String requestURL) {
        this.requestURL = requestURL;
    }

    public void log(String message) {
        System.out.println("[" + uuid + "]" + "[" + requestURL + "] " + message);
    }

    @PostConstruct
    public void init() {
        uuid = UUID.randomUUID().toString();
        System.out.println("[" + uuid + "] request scope bean create:" + this);
    }

    @PreDestroy
    public void close() {
        System.out.println("[" + uuid + "] request scope bean close:" + this);
    }
}