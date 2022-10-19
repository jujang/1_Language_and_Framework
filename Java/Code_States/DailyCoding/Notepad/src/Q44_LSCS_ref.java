public class Q44_LSCS_ref {
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

        int subArrSum = 0; // 연속 배열의 합
        int max = Integer.MIN_VALUE; // 정답의 후보를 저장, 음수를 포함하기 때문에 사용 가능한 최저 음수를 할당
        for(int i = 0; i < arr.length; i++) {
            subArrSum = subArrSum + arr[i];
            if(subArrSum > max) max = subArrSum;

            // 연속된 구간의 합이 음수인 경우,
            // 해당 부분은 버리고 다시 시작해도 된다.
            if (subArrSum < 0) {
                subArrSum = 0;
            }
        }
        return max;
    }

}
