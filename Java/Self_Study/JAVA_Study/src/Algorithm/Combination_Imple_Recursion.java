package Algorithm;

public class Combination_Imple_Recursion {
    public static void main(String[] args) {

        int[] arr = {1, 2, 3}; //조합을 만들 배열
        boolean[] visited = new boolean[arr.length];

//        for(int r = 1; r <= arr.length; r++) {
//            System.out.println("\n" + arr.length + "개 중에 " + r  + "개 뽑음");
//            comb1(arr, visited, 0, r);
//        }

        System.out.println("\n" + arr.length + "개 중에 " + 2  + "개 뽑음");
        comb2(arr, visited, 0, 2);
    }

    public static void comb2(int[] arr, boolean[] visited, int depth, int r){
        if(r == 0){
            print(arr, visited);
            return;
        }
        if(depth == arr.length) {
            return;
        } else {
            visited[depth] = true;
            comb2(arr, visited, depth+1, r-1);

            visited[depth] = false;
            comb2(arr, visited, depth+1, r);
        }
    }

    static void print(int[] arr, boolean[] visited) {
        for(int i = 0; i < arr.length; i++) {
            if(visited[i] == true)
                System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

}
