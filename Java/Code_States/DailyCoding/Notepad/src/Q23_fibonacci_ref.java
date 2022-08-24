import java.util.ArrayList;

public class Q23_fibonacci_ref {
    public static void main(String[] args) {

        int output = fibonacci(0);
        System.out.println(output); // --> 0

        output = fibonacci(1);
        System.out.println(output); // --> 1

        output = fibonacci(5);
        System.out.println(output); // --> 5

        output = fibonacci(9);
        System.out.println(output); // --> 34

    }

    public static int fibonacci(int num) {
        // TODO:

        ArrayList<Integer> memo = new ArrayList<>();

        memo.add(0);
        memo.add(1);

        return aux(memo, num);
    }

    public static int aux(ArrayList<Integer> memo, int num){

        if(memo.size() <= num){
            memo.add(aux(memo, num-2) + aux(memo, num-1));
        }
        return memo.get(num);
    }
}
