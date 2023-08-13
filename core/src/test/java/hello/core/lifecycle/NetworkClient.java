package hello.core.lifecycle;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class NetworkClient {
    private String url;

    public NetworkClient() {
        System.out.println("생성자 호출: url = " + url);
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void connect() {
        System.out.println("connect: " + url);
    }

    public void call(String message) {
        System.out.println("call: " + url + " message = " + message);
    }

    public void disconnect() {
        System.out.println("disconnect: " + url);
    }

    @PostConstruct
    // 최신 스프링에서 가장 권장하는 방법이다.
    // javax 패키지 기술이다. 즉, 스프링에 종속적인 기술이 아니라 JSR-250이라는 자바 표준이기 때문에 스프링이 아닌 다른 컨테이너에서도 잘 동작한다.
    // 유일한 단점은 외부 라이브러리에는 적용하지 못한다는 것이다. (코드를 변경해야 하므로)
    // 위의 경우 직전의 방법 (초기화 메서드, 소멸 메서드 지정)을 사용한다.
    public void init() throws Exception {
        System.out.println("NetworkClient.init");
        connect();
        call("초기화 연결 메시지");
    }

    @PreDestroy
    public void close() throws Exception {
        System.out.println("NetworkClient.close");
        disconnect();
    }
}