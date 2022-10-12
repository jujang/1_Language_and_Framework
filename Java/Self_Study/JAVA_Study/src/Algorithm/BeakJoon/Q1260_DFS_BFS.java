package Algorithm.BeakJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q1260_DFS_BFS {

    static int N, M, V;

//    static boolean[][] check;
    static int[][] arr;

    static Queue<Integer> queue = new LinkedList<>();
    static boolean[] visitedDFS;
    static boolean[] visitedBFS;

    static int edge1;
    static int edge2;


    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        arr = new int[N+1][N+1];
        visitedDFS = new boolean[N+1];
        visitedBFS = new boolean[N+1];

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            edge1 = Integer.parseInt(st.nextToken());
            edge2 = Integer.parseInt(st.nextToken());
            arr[edge1][edge2] = arr[edge2][edge1] = 1;
        }

        dfs(V);
        System.out.println("");
        bfs(V);
    }

    public static void dfs(int node) {

        visitedDFS[node] = true;
        System.out.print(node + " ");

        for(int i = 1; i <= N; i++){
            if(arr[node][i] == 1 && !visitedDFS[i]) dfs(i);
        }

    }

    public static void bfs(int node) {

        queue.add(node);
        visitedBFS[node] = true;
        System.out.print(node + " ");

        while(!queue.isEmpty()){
            node = queue.poll();

            for(int i = 1; i <=N; i++) {
                if(arr[node][i] == 1 && !visitedBFS[i]) {
                    System.out.print(i + " ");
                    queue.add(i);
                    visitedBFS[i] = true;
                }
            }

        }
    }

}
