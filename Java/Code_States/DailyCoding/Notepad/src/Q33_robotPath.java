import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Q33_robotPath {
    public static void main(String[] args){

        int[][] room = new int[][]{
                {0, 0, 0, 0, 0, 0},
                {0, 1, 1, 0, 1, 0},
                {0, 1, 0, 0, 0, 0},
                {0, 0, 1, 1, 1, 0},
                {1, 0, 0, 0, 0, 0}
        };
        int[] src = new int[]{4, 2};
        int[] dst = new int[]{2, 2};
        int output = robotPath(room, src, dst);
        System.out.println(output); // --> 8

    }

    public static int robotPath(int[][] room, int[] src, int[] dst) {

        boolean[][] visited = new boolean[room.length][room[0].length];

        bfs(src[0], src[1], room, visited);

        for(int i = 0; i < room.length; i++) {
            for(int j = 0; j < room[0].length; j++) {
                System.out.print(room[i][j] + " ");
            }
            System.out.println("");
        }

        return room[dst[0]][dst[1]]-1;
    }

    public static void bfs(int x, int y, int[][] room, boolean[][] visited) {

        int[] dx = new int[]{-1, 1, 0, 0};
        int[] dy = new int[]{0, 0, -1, 1};

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {x, y});
        visited[x][y] = true;
        room[x][y] = 1;

        while(!queue.isEmpty()){
            int[] curDir = queue.poll();
            int curX = curDir[0];
            int curY = curDir[1];

            for(int i = 0; i < 4; i++) {
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];
                if(nextX < 0 || nextX >= visited.length || nextY < 0 || nextY >= visited[0].length) continue;
                if(room[nextX][nextY] == 0 && !visited[nextX][nextY]) {
                    room[nextX][nextY] = room[curX][curY] + 1;
                    visited[nextX][nextY] = true;
                    queue.add(new int[]{nextX, nextY});
                }
            }
        }

    }

}
