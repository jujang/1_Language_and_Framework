package Algorithm.BeakJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q1260_DFS_BFS_Training {

    static int N, M, V;
    static int[][] arr;
    static boolean[] visitedDFS;
    static boolean[] visitedBFS;
    static int edge1, edge2;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        arr = new int[N + 1][N + 1];
        visitedDFS = new boolean[N + 1];
        visitedBFS = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            edge1 = Integer.parseInt(st.nextToken());
            edge2 = Integer.parseInt(st.nextToken());
            arr[edge1][edge2] = arr[edge2][edge1] = 1;
        }

//        for(int i = 1; i < arr.length; i++) {
//            for(int j = 1; j < arr[i].length; j++){
//                System.out.print(arr[i][j]+ " ");
//            }
//            System.out.println(" ");
//        }

        DFS(V);
        System.out.println("");
        BFS(V);

    }

    public static void DFS(int V) {

        visitedDFS[V] = true;
        System.out.print(V + " ");

        for(int i = 1; i < arr[V].length; i++){
            if( arr[V][i] == 1 && !visitedDFS[i] ){
                DFS(i);
            }
        }

    }

    public static void BFS(int V) {

        Queue<Integer> queue = new LinkedList<>();
        queue.add(V);
        visitedBFS[V] = true;

        while(!queue.isEmpty()){
            int node = queue.poll();
            System.out.print(node + " ");
            for(int i = 1; i < arr[node].length; i++){
                if( arr[node][i] == 1 && !visitedBFS[i] ){
                    queue.add(i);
                    visitedBFS[i] = true;
                }
            }
        }

    }

}
