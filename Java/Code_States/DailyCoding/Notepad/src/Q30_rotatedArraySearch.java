import java.util.*;
import java.util.stream.Collectors;

public class Q30_rotatedArraySearch {
    public static void main(String[] args) {

        int output = rotatedArraySearch(new int[]{4, 5, 6, 0, 1, 2, 3}, 2);
        System.out.println(output); // --> 5

        output = rotatedArraySearch(new int[]{4, 5, 6, 0, 1, 2, 3}, 100);
        System.out.println(output); // --> -1

    }

    public static int rotatedArraySearch(int[] rotated, int target) {

        ArrayList<Integer> arrayList = Arrays.stream(rotated).boxed().collect(Collectors.toCollection(ArrayList::new));
        return arrayList.indexOf(target);

    }
}
