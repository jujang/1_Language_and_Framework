class Foo {
    public static String classVar = "I class var";
    public String instanceVar = "I instance var";

    public static void classMethod(){
        System.out.println(classVar);  // Ok
//        System.out.println(instanceVar); // Error
    }
    public void instanceMethod(){
        System.out.println(classVar); // Ok
        System.out.println(instanceVar); // Ok
    }
}


public class StaticApp {
    public static void main(String[] args) {
        System.out.println(Foo.classVar);  // Ok
//        System.out.println(Foo.instanceVar);  // Error
        Foo.classMethod();
//        Foo.instanceMethod(); Error

        Foo foofoo = new Foo();
        foofoo.instanceVar = "ddochi";

        System.out.println(foofoo.classVar);
        System.out.println(foofoo.instanceVar);
        foofoo.instanceMethod();
        foofoo.classMethod();

        Foo foo2 = new Foo();
        foo2.classVar = "foo2!!";
        System.out.println(foo2.classVar);
        System.out.println(foofoo.classVar);
    }
}
