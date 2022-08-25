package Collection;

import java.util.*;
import java.util.stream.Collectors;


public class CollectionFramework {
    public static void main(String[] args){

        String[] arr = {"apple", "banana", "carrot", "banana"};
        HashSet<String> set = new HashSet<String>(Arrays.asList(arr));
        System.out.println(set);

        int[] arr2 = {1, 2, 3, 2};
        List<Integer> arrList = Arrays.stream(arr2)
                                    .boxed()
                                    .collect(Collectors.toList());
        HashSet <Integer> set2 = new HashSet<Integer>(arrList);
        System.out.println(set2);
    }

}
