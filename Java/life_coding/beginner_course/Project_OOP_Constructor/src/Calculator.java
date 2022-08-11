class constructorDemo {
    int a;
    int b;

    public constructorDemo(int a, int b) {
        this.a = a;
        this.b = b;
    }
}

public class Calculator {
    public static void main(String[] args){
        constructorDemo c = new constructorDemo(10, 20);
        System.out.println(c.a);
        System.out.println(c.b);
    }
}
