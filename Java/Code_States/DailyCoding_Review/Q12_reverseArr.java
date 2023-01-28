import java.util.*;

public class Q12_reverseArr {
    public static void main(String[] args){
        int[] output = reverseArr(new int[] {1, 2, 3, 4});
        System.out.println(Arrays.toString(output)); // --> [4, 3, 2, 1]

        System.out.println("--------------------------------------------------");

        int[] output1 = reverseArr(new int[] {});
        System.out.println(Arrays.toString(output1)); // --> []

        System.out.println("--------------------------------------------------");

        int[] output2 = reverseArr(new int[] {5, 4, 3, 2, 1, 0, -1, -2});
        System.out.println(Arrays.toString(output2)); // --> [5, 4, 3, 2, 1, 0, -1, -2]

        System.out.println("--------------------------------------------------");
    }

    public static int[] reverseArr(int[] arr){

        if(arr.length == 0) {
            return arr;
        }
        int[] newArr = new int[arr.length];
        reverse(arr, newArr, 0);

        return newArr;
    }
    public static void reverse(int[] originArr, int[] newArr, int i){
        if(i == originArr.length) return;
        newArr[i] = originArr[originArr.length-1-i];
        reverse(originArr, newArr, i+1);
        System.out.println("!!!");
    }

}
