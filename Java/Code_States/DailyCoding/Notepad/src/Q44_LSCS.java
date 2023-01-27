public class Q44_LSCS {
    public static void main(String[] args){

        int output = LSCS(new int[]{1, 2, 3});
        System.out.println(output); // --> 6

        output = LSCS(new int[]{1, 2, 3, -4});
        System.out.println(output); // --> 6 ([1, 2, 3])

        output = LSCS(new int[]{1, 2, 3, -4, 5});
        System.out.println(output); // --> 7 ([1, 2, 3, -4, 5])

        output = LSCS(new int[]{10, -11, 11});
        System.out.println(output); // --> 11 ([11])

    }

    public static int LSCS(int[] arr) {

        int firstSum = 0;
        int secondSum = 0;
        int buffer = 0;
        boolean flag = false; // flag가 true면 firstSum이 아닌 secondSum이 합을 받게됨. 그리고 seconde sum이 더 커진순간 둘을 교체하고 flag는 다시 false로 바꿀 것.

        for(int i = 0; i < arr.length; i++){
            if(buffer > 0) {
                firstSum += buffer;
            }
            if(secondSum > firstSum) {
                firstSum = secondSum;
            }
            if(flag == false && arr[i] > 0 && buffer == 0) {
                firstSum += arr[i];
            } else if(flag == false && arr[i] < 0) {
                buffer += arr[i];
            } else if(flag == false && buffer != 0) {
                buffer += arr[i];
            } else {

            }
        }

        return firstSum;
    }
}
