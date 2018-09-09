package zijietiaodong;

import java.util.Scanner;

public class DFS {
    private static int m, n;
    private static int[][] direction = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static int numIslands(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        m = grid.length;
        n = grid[0].length;
        int islandsNum = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != 0) {
                    dfs(grid, i, j);
                    islandsNum++;
                }
            }
        }
        return islandsNum;
    }

    private static void dfs(int[][] grid, int i, int j) {
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == 0) {
            return;
        }
        grid[i][j] = 0;
        for (int[] d : direction) {
            dfs(grid, i + d[0], j + d[1]);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int[][] grid = new int[m][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = in.nextInt();
            }
        }
        System.out.println(numIslands(grid));
    }
}