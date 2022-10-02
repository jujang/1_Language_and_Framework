package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS_Training {
    public static void main(String[] args) {

//        int[][] room = new int[][]{
//                {0, 0, 0, 0, 0, 0},
//                {0, 1, 1, 0, 1, 0},
//                {0, 1, 0, 0, 0, 0},
//                {0, 0, 1, 1, 1, 0},
//                {1, 0, 0, 0, 0, 0}
//        };

//        int[] src = new int[]{4, 2};
//        int[] dst = new int[]{2, 2};
//        int output = bfs(room, src, dst);
//        System.out.println(output); // --> 8

        int[][] graph = {
                {},
                {2, 3, 8},
                {1, 6, 8},
                {1, 5},
                {5, 7},
                {3, 4, 7},
                {2},
                {4, 5},
                {1, 2}
        };

        boolean[] visited = new boolean[graph.length];

        System.out.println(bfs(graph, 1, visited));

    }

    public static String bfs(int[][] graph, int start, boolean[] visited) {

        String result = "";

        Queue<Integer> queue = new LinkedList<>();

        queue.offer(start);
        visited[start] = true;

        while(!queue.isEmpty()) {
            int from = queue.poll();
            result += from;
            for(int i = 0; i < graph[from].length; i++){
                int temp = graph[from][i];
                if(!visited[temp]) {
                    queue.offer(temp);
                    visited[temp] = true;
                }
            }
        }

        return result;
    }

}