public class Q33_robotPath_ref {

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

        room = aux(room.length, room[0].length, src, 1, room);

        return room[dst[0]][dst[1]] - 1;
    }

    public static int[][] aux(int M, int N, int[] candi, int step, int[][] room) {

        int row = candi[0];
        int col = candi[1];

        // 배열의 범위를 벗어난 경우
        if (row < 0 || row >= M || col < 0 || col >= N) return room;

        if (room[row][col] == 0 || room[row][col] > step) {
            room[row][col] = step;
        } else {
            // 장애물(1)이거나 이미 최소 시간(1)으로 통과가 가능한 경우
            return room;
        }


        // dfs로 4가지 방향에 대해 탐색을 한다.
        // 완전탐색을 해야하므로 bfs나 dfs가 큰 차이가 없다.
        // bfs의 경우 목적지에 도착하는 경우 탐색을 중단해도 되므로,
        // 약간 더 효율적이다.
        aux(M, N, new int[]{row + 1, col}, step + 1, room); // 상
        aux(M, N, new int[]{row - 1, col}, step + 1, room); // 하
        aux(M, N, new int[]{row, col - 1}, step + 1, room); // 좌
        aux(M, N, new int[]{row, col + 1}, step + 1, room); // 우

        return room;

    }

}
