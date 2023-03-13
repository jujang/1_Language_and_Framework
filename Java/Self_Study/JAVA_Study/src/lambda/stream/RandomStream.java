package lambda.stream;

import java.util.Random;
import java.util.stream.IntStream;

public class RandomStream {
    public static void main(String[] args){
        IntStream intStream = new Random().ints();
        intStream.limit(5).forEach(System.out::println);

        IntStream intStream2 = new Random().ints(5);
        intStream2.forEach(System.out::println);

        IntStream intStream3 = new Random().ints(5, 1, 10);
        intStream3.forEach(System.out::println);
    }
}
