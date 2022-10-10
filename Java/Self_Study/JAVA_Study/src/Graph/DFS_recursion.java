package Graph;

public class DFS_recursion {
    public static void main(String[] args) {

        int[][] graph = {
                {},
                {2,3,8},
                {1,6,8},
                {1,5},
                {5,7},
                {3,4,7},
                {2},
                {4,5},
                {1,2}
        };

        boolean[] visited = new boolean[graph.length];

        System.out.println(dfs(graph, 1, visited));

    }

    public static int dfs(int[][] graph, int node, boolean[] visited) {

        visited[node] = true;

        System.out.print(node  + " -> ");

        for(int i : graph[node]) {
            if(!visited[i]) {
                dfs(graph, i, visited);
            }
        }

        return 0;
    }
}
