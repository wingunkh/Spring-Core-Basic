package hello.core.singleton;

public class SingletonService {
    // 1. static 영역에 객체를 딱 1개만 생성한다.
    private static final SingletonService instance = new SingletonService();

    // 2. public 메서드 : 객체 인스턴스가 필요하면 이 static 메서드를 통해서만 반환하도록 허용한다.
    public static SingletonService getInstance() {
        return instance;
    }

    // 3. private 생성자 : 외부에서 new 키워드를 통한 객체 생성을 금지한다.
    private SingletonService() {

    }

    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }
}