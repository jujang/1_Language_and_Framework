import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Q32_orderOfPresentation {
    public static void main(String[] args){

        int output = orderOfPresentation(3, new int[]{2, 3, 1});
        System.out.println(output); // 3

        output = orderOfPresentation(5, new int[]{1, 3, 2, 4, 5});
        System.out.println(output); // 6

    }


    // 일단 만들어야 하는 것.
    // int형 배열을 가진 arrayList를 만들어야 함.

    public static int orderOfPresentation(int N, int[] K){

        Arrays.sort(K);

        int[][] arrArray = new int[10000][];


//         ArrayList<Integer> intList = Arrays.stream(K).boxed().collect(Collectors.toCollection(ArrayList::new));
//
//        ArrayList<ArrayList<Integer>> abcd = new ArrayList<>();
        ArrayList<Integer> abcde = new ArrayList<>();


        boolean[] visited = new boolean[K.length];
        int[] output = new int[K.length];


//        abcd = arrayT(K, K.length, 0, visited, output, abcd);


//        return arrayT();

        return 0;
    }

    public static int arrayT(int[] K, int maxSize, int depth, boolean[] visited, int[] output, int[][] abcde) {

        if(depth == maxSize) {
//            int[][]
        }

        return 0;
    }

}
