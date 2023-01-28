import java.util.*;
import java.util.stream.Collectors;

public class Q21_largestProductOfThree {
    public static void main(String[] args){
        int output = largestProductOfThree(new int[]{2, 1, 3, 7});
        System.out.println(output); // --> 42 (= 2 * 3 * 7)

        output = largestProductOfThree(new int[]{-1, 2, -5, 7});
        System.out.println(output); // --> 35 (= -1 * -5 * 7)
    }
    public static int largestProductOfThree(int[] arr){

//        ArrayList<Integer> arrayList = Arrays.stream(arr).boxed().collect(Collectors.toCollection(ArrayList::new));
//        Collections.sort(arrayList);
//        int product1 = arrayList.get(arrayList.size()-1)*arrayList.get(arrayList.size()-2)*arrayList.get(arrayList.size()-3);
//        int product2 = arrayList.get(0)*arrayList.get(1)*arrayList.get(arrayList.size()-1);
//        return (product1 > product2) ? product1 : product2;

        Arrays.sort(arr);
        int product1 = arr[arr.length-1]*arr[arr.length-2]*arr[arr.length-3];
        int product2 = arr[0]*arr[1]*arr[arr.length-1];
        return (product1 > product2) ? product1 : product2;
    }
}
