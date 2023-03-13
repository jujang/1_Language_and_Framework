package lambda.lambdabasic;

public class Ex14_0 {
    public static void main(String[] args){
//        Object obj = (a, b) -> a > b ? a : b;  // 람다식, 익명객체


//        Object obj = new Object() {
        Myfunction2 obj = new Myfunction2() {
            public int max(int a, int b){
                return a > b ? a:b;
            }
        };

//        int value = obj.max(3, 5); // error, 안되기 때문에 함수형 인터페이스가 필요함
    }
}
@FunctionalInterface // 함수형 인터페이스는 단 하나의 추상 메서드만 가져야 함
interface Myfunction2 {
//    public abstract int max(int a, int b);
    int max(int a, int b);

}
