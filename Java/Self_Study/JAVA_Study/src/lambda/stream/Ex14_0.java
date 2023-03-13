package lambda.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Ex14_0 {
    public static void main(String[] args){
//        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
//        Stream<Integer> intStream = list.stream(); // list로 Stream 생성
//        intStream.forEach(System.out::print);
//
//        intStream = list.stream();
//        intStream.forEach(System.out::print);


//        String[] strArr = new String[] {"a", "b", "c"};
//        Stream<String> strStream = Stream.of(strArr);
//        Stream<String> strStream = Stream.of("a", "b", "c");
        Stream<String> strStream = Stream.of(new String[] {"a", "b", "c"});
        strStream.forEach(System.out::println);

//        int[] intArr = {1, 2, 3, 4, 5};
//        IntStream intStream = Arrays.stream(intArr);
//        intStream.forEach(System.out::println);

        Integer[] intArr = {1, 2, 3, 4, 5};   // 1, 2, 3, 4, 5각각 오토박싱이 일어남!!!
        Stream<Integer> intStream = Arrays.stream(intArr);
        intStream.forEach(System.out::println);
    }
}
