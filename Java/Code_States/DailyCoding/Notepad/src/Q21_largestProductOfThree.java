import java.util.*;

public class Q21_largestProductOfThree {
    public static void main(String[] args) {

        int output = largestProductOfThree(new int[]{2, 1, 3, 7});
        System.out.println(output); // --> 42 (= 2 * 3 * 7)

        output = largestProductOfThree(new int[]{-1, 2, -5, 7});
        System.out.println(output); // --> 35 (= -1 * -5 * 7)

        output = largestProductOfThree(new int[]{-5, -4, -3, -2, -1});
        System.out.println(output); // --> -6 (= -1 * -2 * -3)

        output = largestProductOfThree(new int[]{2, 3, -11, 7, 5, -13});
        System.out.println(output); // --> 1001 (= -11 * -13 * 7)



        output = largestProductOfThree2(new int[]{2, 1, 3, 7});
        System.out.println(output); // --> 42 (= 2 * 3 * 7)

        output = largestProductOfThree2(new int[]{-1, 2, -5, 7});
        System.out.println(output); // --> 35 (= -1 * -5 * 7)

        output = largestProductOfThree2(new int[]{-5, -4, -3, -2, -1});
        System.out.println(output); // --> -6 (= -1 * -2 * -3)

        output = largestProductOfThree2(new int[]{2, 3, -11, 7, 5, -13});
        System.out.println(output); // --> 1001 (= -11 * -13 * 7)



        output = largestProductOfThree3(new int[]{2, 1, 3, 7});
        System.out.println(output); // --> 42 (= 2 * 3 * 7)

        output = largestProductOfThree3(new int[]{-1, 2, -5, 7});
        System.out.println(output); // --> 35 (= -1 * -5 * 7)

        output = largestProductOfThree3(new int[]{-5, -4, -3, -2, -1});
        System.out.println(output); // --> -6 (= -1 * -2 * -3)

        output = largestProductOfThree3(new int[]{2, 3, -11, 7, 5, -13});
        System.out.println(output); // --> 1001 (= -11 * -13 * 7)

        output = largestProductOfThree3(new int[]{-5, -1, 1, 2, 9});
        System.out.println(output); // --> 45 (= -5 * -1 * 9)

        output = largestProductOfThree3(new int[]{-5, -2, -1, 0});
        System.out.println(output); // --> 0 (= 0)

        output = largestProductOfThree3(new int[]{-5, 0, 1, 2});
        System.out.println(output); // --> 0 (= 0)
    }


    public static int largestProductOfThree(int[] arr) {
        // TODO:
        Arrays.sort(arr);
        int cntMinus = 0;
        int cntZero = 0;
        int transCnt = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] < 0) {
                cntMinus++;
                transCnt = i;
            }
            else if(arr[i] == 0) cntZero++;
        }

        int result = -1;
        if(arr.length - cntMinus - cntZero >= 3) result = arr[arr.length-1] * arr[arr.length-2] * arr[arr.length-3];
        else if(arr.length - cntMinus - cntZero == 2) {
            if(cntMinus >= 2) result = arr[0] * arr[1] * arr[arr.length-1];
            else if(cntZero >= 1 ) result = 0;
            else result = arr[transCnt] * arr[transCnt+1] * arr[transCnt+2];
        } else if (arr.length - cntMinus - cntZero == 1) {
            if(cntMinus >= 2) result = arr[arr.length-1] * arr[0] * arr[1];
            else result = 0;
        } else if (arr.length - cntMinus - cntZero == 0) {
            if(cntZero >= 1) result = 0;
            else result = arr[transCnt-2] * arr[transCnt-1] * arr[transCnt];
        }
        if((arr.length - cntMinus - cntZero >= 3) && (cntMinus >= 3)) {
            result = (arr[arr.length-1] * arr[arr.length-2] * arr[arr.length-3]) >= (arr[transCnt-2] * arr[transCnt-1] * arr[transCnt]) ? arr[arr.length-1] * arr[arr.length-2] * arr[arr.length-3] : arr[transCnt-2] * arr[transCnt-1] * arr[transCnt];
        }
        return result;
    }



    public static int largestProductOfThree2(int[] arr) {
        // TODO:
        Arrays.sort(arr);
        int cntMinus = 0;
        int cntZero = 0;
        int transCnt = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                cntMinus++;
                transCnt = i;
            } else if (arr[i] == 0) cntZero++;
        }
        int cntPlus = arr.length - cntMinus - cntZero;

        HashSet<Integer> set = new HashSet<Integer>();
        if(cntPlus >= 3) set.add(arr[arr.length-1] * arr[arr.length-2] * arr[arr.length-3]);
        if(cntPlus >= 2 && cntMinus >= 1) set.add(arr[transCnt] * arr[transCnt+1] * arr[transCnt+2]);
        if(cntPlus >= 1 && cntMinus >= 2) set.add(arr[arr.length-1] * arr[0] * arr[1]);
        if(cntMinus >= 3) set.add(arr[transCnt-2] * arr[transCnt-1] * arr[transCnt]);
        if(cntZero >= 1) set.add(0);

        int result = Collections.max(set);
        return result;
    }


    public static int largestProductOfThree3(int[] arr) {

        Arrays.sort(arr);
        int arrLength = arr.length;
        //가장 큰 양수 3가지를 곱한 값
        int candidate1 = arr[arrLength - 1] * arr[arrLength - 2] * arr[arrLength - 3];
        //가장 작은 음수 2가지와, 가장 큰 양수를 곱한 값
        int candidate2 = arr[arrLength - 1] * arr[0] * arr[1];
        return Math.max(candidate1, candidate2);

    }
}

