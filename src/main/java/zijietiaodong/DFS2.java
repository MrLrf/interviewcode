package zijietiaodong;

/**
 * 类的描述
 *
 * @Author lirf
 * @Date 2018/9/9 10:56
 */
public class DFS2 {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[][] g = new int[][]
                {
                        {0, 1, 0, 0},
                        {1, 0, 0, 0},
                        {0, 0, 0, 0},
                        {0, 0, 0, 0}
                };
        System.out.println(DFS(g));
    }

    public static int DFS(int[][] grid) {
        boolean[] visited = new boolean[grid.length];
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            if (!visited[i]) {
                dfs(i, grid, visited);
                count++;
            }
        }
        return count;
    }

    public static void dfs(int i, int[][] grid, boolean[] visited) {
        visited[i] = true;
        for (int j = 0; j < grid.length; j++) {
            if (!visited[j] && grid[i][j] == 1) {
                dfs(j, grid, visited);
            }
        }
    }
}
