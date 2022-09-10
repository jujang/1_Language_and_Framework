package Algorithm;

public class Permutation_Imple_VisitedArray_Trainning {
    public static void main(String[] args){
        int n = 3;
        int[] arr = {1, 2, 3};
        int[] output = new int[n];
        boolean[] visited = new boolean[n];
        perm(arr, output, visited, 0, n, 3);
    }

    static void perm(int[] arr, int[] output, boolean[] visited, int depth, int n, int r) {

        if(depth == n){
            print(output);
            return;
        }
        for(int i = 0; i < arr.length; i++){
            if(visited[i] != true){
                visited[i] = true;
                output[depth] = arr[i];
                perm(arr, output, visited, depth + 1, n, r);
                visited[i] = false;
            }
        }
    }

    static void print(int[] output){
        for(int i = 0; i < output.length; i++){
            System.out.print(output[i] + " ");
        }
        System.out.println();
    }
}
