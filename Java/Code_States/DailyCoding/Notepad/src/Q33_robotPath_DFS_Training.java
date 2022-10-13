public class Q33_robotPath_DFS_Training {
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

        boolean[][] checked = new boolean[room.length][room[0].length];

        checked[src[0]][src[1]] = true;
        room[src[0]][src[1]] = 1;

        int[] minDis = new int[1];
        minDis[0] = room.length*room[0].length;

        dfs(room, checked, src, dst, minDis);

        return minDis[0]-1;
    }

    public static void dfs(int[][] room, boolean[][] checked, int[] from, int[] dst, int[] minDis) {

        int[] dx = new int[]{1, -1, 0, 0};
        int[] dy = new int[]{0, 0, 1, -1};

        if(from[0] == dst[0] && from[1] == dst[1]) {
            minDis[0] = Math.min(minDis[0], room[dst[0]][dst[1]]);
            return;
        }

        for(int i = 0; i < 4; i++){
            int nextX = from[0] + dx[i];
            int nextY = from[1] + dy[i];

            if(nextX < 0 || nextX >= room.length || nextY < 0 || nextY >= room[0].length) continue;
            if(room[nextX][nextY] == 0 && !checked[nextX][nextY]) {
                room[nextX][nextY] = room[from[0]][from[1]] + 1;
                checked[nextX][nextY] = true;
                dfs(room, checked, new int[]{nextX, nextY}, dst, minDis);
                room[nextX][nextY] = 0;
                checked[nextX][nextY] = false;
            }

        }

    }
}
