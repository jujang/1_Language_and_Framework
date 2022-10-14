import java.util.LinkedList;
import java.util.Queue;

public class Q55_gossipProtocol {
    public static void main(String[] args){

        String[] village = new String[]{
                "0101", // 첫 번째 줄
                "0111",
                "0110",
                "0100",
        };
        int row = 1;
        int col = 2;
        int output = gossipProtocol(village, row, col);
        System.out.println(output); // --> 3

    }

    public static int gossipProtocol(String[] village, int row, int col) {
        // TODO :

        int[] dir = new int[] {row, col};

        int[][] graph = new int[village.length][village[0].length()];
        for(int i = 0; i < village.length; i++){
            for(int j = 0; j < village[0].length(); j++){
                graph[i][j] = village[i].charAt(j) - '0';
            }
        }

        boolean[][] checked = new boolean[village.length][village[0].length()];

        int[] dis = new int[]{0};

        bfs(graph, checked, dir, dis);


        return dis[0]-1;
    }

    public static void bfs(int[][] graph, boolean[][] checked, int[] dir, int dis[]) {

        int[] dx = new int[]{1, -1, 0, 0};
        int[] dy = new int[]{0, 0, 1, -1};

        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[]{dir[0], dir[1]});
        dis[0] = 1;
        checked[dir[0]][dir[1]] = true;

        while(!queue.isEmpty()){
            int[] curDir = queue.poll();
            int curX = curDir[0];
            int curY = curDir[1];

            for(int i = 0; i < 4; i++){
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];

                if(nextX < 0 || nextX >= graph.length || nextY < 0 || nextY >= graph[0].length) continue;
                if(graph[nextX][nextY] != 0 && !checked[nextX][nextY]) {
                    queue.add(new int[]{nextX, nextY});
                    graph[nextX][nextY] = graph[curX][curY] + 1;
                    dis[0] = graph[nextX][nextY];
                    checked[nextX][nextY] = true;
                }
            }
        }

    }

}
