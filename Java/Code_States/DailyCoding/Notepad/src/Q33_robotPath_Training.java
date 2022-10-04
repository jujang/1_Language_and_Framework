import java.util.LinkedList;
import java.util.Queue;

public class Q33_robotPath_Training {

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

        int m = room.length;
        int n = room[0].length;
        boolean[][] checked = new boolean[room.length][room[0].length];

        bfs(src[0], src[1], room, checked);

//        for(int i = 0; i < m; i++){
//            for(int j = 0; j < n; j++){
//                if(room[i][j] == 0 && checked[i][j] == false) {
//                    minTime = bfs(i, j, room, checked);
//                }
//            }
//        }

        return room[dst[0]][dst[1]]-1;
    }

    public static int bfs(int x, int y, int[][] room, boolean[][] checked) {

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        checked[x][y] = true;
        room[x][y] = 1;


        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int curX = cur[0];
            int curY = cur[1];

            for(int i = 0; i < 4; i++){
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];
                if(nextX < 0 || nextX >= room.length || nextY < 0 || nextY >= room[0].length) continue;
                if(room[nextX][nextY] == 0 && !checked[nextX][nextY]) {
                    queue.add(new int[]{nextX, nextY});
                    checked[nextX][nextY] = true;
                    room[nextX][nextY] = room[curX][curY] + 1;
                }
            }
        }


        return 0;
    }

}

