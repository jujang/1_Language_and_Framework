package Algorithm.BeakJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q2178_BFS {

    static int n, m;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        for(int i = 0; i < n; i++){
//            st = new StringTokenizer(br.readLine());
//            for(int j = 0; j < m; j++){
//                map[i][j] = Integer.parseInt(st.nextToken());
//            }
            String line = br.readLine();
            String[] arr = line.split("");
            for(int j = 0; j < m; j++){
                map[i][j] = Integer.parseInt(arr[j]);
            }
        }

        visited = new boolean[n][m];
        visited[0][0] = true;
        bfs(0, 0);
        System.out.println(map[n-1][m-1]);
    }

    public static void bfs(int x, int y){

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});

        while(!queue.isEmpty()){
            int[] curDir = queue.poll();
            int curX = curDir[0];
            int curY = curDir[1];
            for(int i = 0; i < 4; i++){
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];
                if(nextX < 0 || nextX >= n || nextY < 0 || nextY >= m) continue;
                if(map[nextX][nextY] != 0 && !visited[nextX][nextY]) {
                    map[nextX][nextY] = map[curX][curY] + 1;
                    visited[nextX][nextY] = true;
                    queue.add(new int[] {nextX, nextY});
                }
            }
        }

    }
}
