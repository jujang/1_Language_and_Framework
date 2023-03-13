package lambda.methodreference;

import java.util.function.Function;

public class Ex14_0 {
    public static void main(String[] args){

        Function<Integer, MyClass> f = (i) -> new MyClass(i);

        MyClass mc = f.apply(100);
        System.out.println(mc.iv);

    }
}

class MyClass {
    int iv;

    MyClass(int iv){
        this.iv = iv;
    }
}