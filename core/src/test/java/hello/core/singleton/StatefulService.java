package hello.core.singleton;

public class StatefulService {
    private int price; // 상태를 유지하는 필드, 스프링 빈은 항상 무상태(stateless)로 설계할 것.

    public void order(String name, int price) {
        System.out.println("name = " + name + " price = " + price);
        this.price = price; // 여기서 문제 발생
    }

    public int getPrice() {
        return price;
    }
}