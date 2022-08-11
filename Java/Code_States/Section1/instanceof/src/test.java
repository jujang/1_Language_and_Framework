class A{}
class B extends A{}

public class test {
    public static void main(String args[]){

        A a = new A();
        B b = new B();

        System.out.println("a instanceof A : " + (a instanceof A));
        System.out.println("b instanceof A : " + (b instanceof A));
        System.out.println("a instanceof B : " + (a instanceof B));
        System.out.println("b instanceof B : " + (b instanceof B));
    }
}