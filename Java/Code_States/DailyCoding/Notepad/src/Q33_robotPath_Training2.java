import java.util.LinkedList;
import java.util.Queue;

public class Q33_robotPath_Training2 {
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

        bfs(room, src, dst);

        return room[dst[0]][dst[1]]-1;
    }

    public static void bfs(int[][] room, int[] src, int[] dst){

        boolean[][] checked = new boolean[room.length][room[0].length];

        int[] dx = new int[]{1, -1, 0, 0};
        int[] dy = new int[]{0, 0, 1, -1};

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{src[0], src[1]});
        room[src[0]][src[1]] = 1;
        checked[src[0]][src[1]] = true;

        while(!queue.isEmpty()){
            int[] curDir = queue.poll();
            int curX = curDir[0];
            int curY = curDir[1];

            for(int i = 0; i < 4; i++){
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];

                if(nextX < 0 || nextX >= room.length || nextY < 0 || nextY >= room[0].length) continue;
                if(room[nextX][nextY] == 0 && !checked[nextX][nextY]) {
                    queue.add(new int[]{nextX, nextY});
                    room[nextX][nextY] = room[curX][curY] + 1;
                    checked[nextX][nextY] = true;
                }
            }
        }

    }

}
