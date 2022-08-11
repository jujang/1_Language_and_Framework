import java.util.*;
//import java.util.Arrays;

public class ArrayOrder {
    public static void main(String args[]) {

        int[] arr = new int[]{2, 4, 6, 8, 1, 3, 5, 7, 9};
        Arrays.sort(arr);

//        Integer[] arr2 = (Integer[])(arr.clone());

        Integer[] arr2 = new Integer[]{2, 4, 6, 8, 1, 3, 5, 7, 9};
        Arrays.sort(arr2,Collections.reverseOrder());
//        System.out.println(Arrays.sort(arr));
    }
}
