import java.util.ArrayList;

public class Q29_tiling_otherVer {
    public static void main(String[] args){
        int output = tiling(2);
        System.out.println(output); // --> 2

        output = tiling(4);
        System.out.println(output); // --> 5
        // 2 x 4 보드에 타일을 놓는 방법은 5가지
    }

    public static int tiling(int num){

        int[] arr = new int[9999];
        arr[0] = 0;
        arr[1] = 1;
        arr[2] = 2;

        int result = func(num, arr);
        return result;
    }

    public static int func(int number, int[] arr) {

        if(arr[number] == 0) {
            arr[number] = func(number-1, arr) + func(number-2, arr);
        }

        return arr[number];
    }

}
