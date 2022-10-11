import java.util.ArrayList;

public class Q52_uglyNumbers_ref {
    public static void main(String[] args){

        int result = uglyNumbers(15);
        System.out.println(result); // --> 1

        result = uglyNumbers(8);
        System.out.println(result); // --> 3

    }

    public static int uglyNumbers(int n){

        ArrayList<Integer> uglyNumberList = new ArrayList<>();
        uglyNumberList.add(1);
        int idx2 = 0;
        int idx3 = 0;
        int idx5 = 0;

        for(int i = 0; i < n; i++) {
            // 1. 가장 작은 수인 1에 2, 3, 5를 곱한 수 중에 가장 작은 수를 구한다.
            // 2. 2가 선택됨.
            // 3. 2는 가장 작은 수 1에 곱해졌으므로
            //   3.1 이제 2는 그 다음 작은 수인 2에 곱해지고
            //   3.2 3, 5는 여전히 가장 작은 수에 곱해진다.
            // 4. 3에서 가장 작은 수는 3. 3은 이제 다음으로 작은 수인 2에 곱혀진다.
            // 5. 반복
            int nextMultipleOf2 = uglyNumberList.get(idx2) * 2;
            int nextMultipleOf3 = uglyNumberList.get(idx3) * 3;
            int nextMultipleOf5 = uglyNumberList.get(idx5) * 5;
            int nextUglyNumber = Math.min(Math.min(nextMultipleOf2, nextMultipleOf3), nextMultipleOf5);
            uglyNumberList.add(nextUglyNumber);

            // 같은 수를 중복해서 저장할 수 있으므로,
            // 각각 별도의 조건문으로 작성해야 한다.
            //  2 * 3 = 6
            //  3 * 2 = 6
            if (nextUglyNumber == nextMultipleOf2) idx2++;
            if (nextUglyNumber == nextMultipleOf3) idx3++;
            if (nextUglyNumber == nextMultipleOf5) idx5++;
        }
        return uglyNumberList.get(n - 1);

    }
}
