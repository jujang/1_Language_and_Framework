
abstract class A{
    public static void a(){
        System.out.println("print!");
    }
    public abstract int b();
//    public abstract int c();

    public void d(){
        System.out.println("world");
    }
}

class B extends A{
    public int b() {
        System.out.println("heyhey");
        return 1;
    }
}

public class AbstractDemo {
    public static void main(String[] args){
//        A obj = new A();
        A.a();


        B obj = new B();
//        B.b(); // error
        obj.b();
        obj.a();



    }
}
