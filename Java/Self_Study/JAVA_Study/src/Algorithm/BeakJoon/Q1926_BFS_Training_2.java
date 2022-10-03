package Algorithm.BeakJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q1926_BFS_Training_2 {

    static int n, m;
    static int[][] map;
    static boolean[][] checked;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int cnt = 0;
        int size = 0;
        checked = new boolean[n][m];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++) {
                if(map[i][j] == 1 && checked[i][j] == false) {
                    size = Math.max(size, bfs(i, j));
                    cnt++;
                }
            }
        }

        System.out.println(cnt);
        System.out.println(size);
    }

    static int bfs(int x, int y) {

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        int size = 0;

        while(!queue.isEmpty()) {
            int[] nextDir = queue.poll();
            int curX = nextDir[0];
            int curY = nextDir[1];
            for(int i = 0; i < 4; i++){
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];
                if(nextX < 0 || nextX >= n || nextY < 0 || nextY >= m) continue;
                if(map[nextX][nextY] == 0) continue;
                if(!checked[nextX][nextY]) {
                    size++;
                    checked[nextX][nextY] = true;
                    queue.add(new int[]{nextX, nextY});
                }
            }
        }
        return size;
    }
}
