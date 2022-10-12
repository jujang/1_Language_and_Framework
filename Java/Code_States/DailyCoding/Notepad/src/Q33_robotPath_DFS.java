import java.util.LinkedList;
import java.util.Queue;

public class Q33_robotPath_DFS {

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

//        int[][] room = new int[][]{
//                {1, 1, 1, 1, 1, 0},
//                {0, 0, 0, 0, 0, 0}
//        };
//        int[] src = new int[]{1, 0};
//        int[] dst = new int[]{0, 5};
//        int output = robotPath(room, src, dst);
//        System.out.println(output); // --> 6

    }

    public static int robotPath(int[][] room, int[] src, int[] dst) {

        boolean[][] checked = new boolean[room.length][room[0].length];
        room[src[0]][src[1]] = 1;
        checked[src[0]][src[1]] = true;

        int[] min = new int[] {room.length * room[0].length};
        dfs(room, checked, src, dst, min);

        return min[0]-1;
    }

    public static void dfs(int[][] room, boolean[][] checked, int[] from, int[] dst, int[] sol) {

//        System.out.println(from[0] + ", " + from[1] + "  " + room[from[0]][from[1]]);

        if(from[0] == dst[0] && from[1] == dst[1]) {
//            System.out.println("!");
            sol[0] = Math.min(sol[0], room[dst[0]][dst[1]]);
            return;
        }

        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};


        int curX = from[0];
        int curY = from[1];

        for(int i = 0; i < 4; i++){
            int nextX = curX + dx[i];
            int nextY = curY + dy[i];

            if(nextX < 0 || nextX >= room.length || nextY < 0 || nextY >= room[0].length) continue;
            if(room[nextX][nextY] != 1 && !checked[nextX][nextY]) {
                room[nextX][nextY] = room[curX][curY]+1;
                checked[nextX][nextY] = true;
                dfs(room, checked, new int[]{nextX, nextY}, dst, sol);
//                System.out.println("-------------------------------------------------");
                checked[nextX][nextY] = false;
                room[nextX][nextY] = 0;
            }

        }
    }

}
