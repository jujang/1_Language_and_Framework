import java.util.ArrayList;
import java.util.Arrays;

public class Q46_coinChange {

    public static void main(String[] args){
        int total = 10;
        int[] coins = new int[]{1, 5};
        int output = coinChange(total, coins);
        System.out.println(output); // --> 3

        total = 4;
        coins = new int[]{1, 2, 3};
        output = coinChange(total, coins);
        System.out.println(output); // --> 4 ([1, 1, 1, 1], [1, 1, 2], [2, 2], [1, 3])
    }

    public static int coinChange(int total, int[] coins){
        // memo.get(i)[j]는 i만큼의 금액을 coins[j]부터 ~ coins[coins.length - 1]까지 사용하여 만들 수 있는 경우의 수를 저장
        ArrayList<Integer[]> memo = new ArrayList<>();
        for(int i = 0; i < total + 1; i++) {
            Integer[] arr = new Integer[coins.length];
            Arrays.fill(arr, -1);
            memo.add(arr);
        }
        return makeChageFrom(total, 0, coins, memo);
    }
    public static int makeChageFrom(int left, int idx, int[] coins, ArrayList<Integer[]> memo) {
        // 0을 만드는 방법은 1가지이다. 아니면 목표 금액을 만들었다고 생각해도 된다.
        if (left == 0) return 1;
        // 금액이 마이너스가 되는 경우는 불가능하므로 0을 리턴
        if (left < 0) return 0;
        // 동전을 전부 검토해서, 남아있는 새로운 동전은 없는데 목표 금액을 만들지 못한 경우 (실패)
        if (idx >= coins.length && left > 0) return 0;
        // 이미 해결한 적이 있는 문제는 다시 풀지 않는다.
        if (memo.get(left)[idx] != -1) return memo.get(left)[idx];

        // left만큼의 금액을 coins[idx]부터 사용하여 만들 수 있는 경우의 수는
        //  1) coins[idx]는 그만 사용하고, 다음 동전으로 넘어가거나 (목표 금액은 그대로이고, idx가 증가한다.)
        //  2)) coins[idx]를 한번 더 사용한다. coins[idx]를 또 사용할 수 있으므로, idx는 그대로이고, 목표 금액은 coins[i]만큼 줄어든다.
        memo.get(left)[idx] = makeChageFrom(left, idx + 1, coins, memo) + makeChageFrom(left - coins[idx], idx, coins, memo);
        return memo.get(left)[idx];
    }

}
