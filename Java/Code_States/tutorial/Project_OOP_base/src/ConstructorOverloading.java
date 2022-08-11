class Car {
    public String model;
    public String color;

    public Car(){} // 기본생성자. 생성자가 없는 경우 자동 생성

    // 생성자 오버로딩
    public Car(String model, String color) { // 매개변수가 있는 생성자
        this.model = model;
        this.color = color;
    }

    void power() {
        System.out.println("시동을 걸었습니다.");
    }

    void accelerate() {
        System.out.println("더 빠르게!");
    }

    void stop(){
        System.out.println("멈춤");
    }
}

public class ConstructorOverloading {
    public static void main(String[] args){
        Car s = new Car();
        System.out.println(s);
        System.out.println("내 차의 모델은 " + s.model + "이고 " + "색은 " + s.color + "입니다."); // 필드 호출
        s.power();
        s.accelerate();
        s.stop();

        Car car = new Car("medel 3", "빨강");
        System.out.println(car);
        System.out.println("내 차의 모델은 " + car.model + "이고 " + "색은 " + car.color + "입니다."); // 필드 호출
        car.power();
        car.accelerate();
        car.stop();

    }


}
