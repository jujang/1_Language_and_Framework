public class this_Method {
    public static void main(String[] args) {
        Example example = new Example();
        Example example2 = new Example(5);
    }
}

class Example  {
    public Example() {
//        this();
        System.out.println("Example의 기본 생성자 호출!");
    };

    public Example(int x) {
        this();
        System.out.println("Example의 두 번째 생성자 호출!");
    }
}