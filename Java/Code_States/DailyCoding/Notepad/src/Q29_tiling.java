import java.util.ArrayList;

public class Q29_tiling {
    public static void main(String[] args){
        int output = tiling(2);
        System.out.println(output); // --> 2

        output = tiling(4);
        System.out.println(output); // --> 5
        // 2 x 4 보드에 타일을 놓는 방법은 5가지
    }

    public static int tiling(int num){

        ArrayList<Integer> arraylist = new ArrayList<>();
        arraylist.add(0);
        arraylist.add(1);
        arraylist.add(2);

        int result = func(num, arraylist);
        return result;
    }

    public static int func(int number, ArrayList<Integer> arraylist) {

        if(arraylist.size() < number+1 || arraylist.get(number) == 0) {
            arraylist.add(func(number-1, arraylist) + func(number-2, arraylist));
        }

        return arraylist.get(number);
    }
}
