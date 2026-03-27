import java.util.*;

class Solution {
    int[][][] dp;
    int n, m;

    public int solve(int i, int j1, int j2, int[][] grid) {
        if (j1 < 0 || j2 < 0 || j1 >= m || j2 >= m) return (int)-1e9;

        if (i == n - 1) {
            if (j1 == j2) return grid[i][j1];
            else return grid[i][j1] + grid[i][j2];
        }

        if (dp[i][j1][j2] != -1) return dp[i][j1][j2];

        int max = Integer.MIN_VALUE;

        for (int dj1 = -1; dj1 <= 1; dj1++) {
            for (int dj2 = -1; dj2 <= 1; dj2++) {

                int value;
                if (j1 == j2)
                    value = grid[i][j1];
                else
                    value = grid[i][j1] + grid[i][j2];

                value += solve(i + 1, j1 + dj1, j2 + dj2, grid);
                max = Math.max(max, value);
            }
        }

        return dp[i][j1][j2] = max;
    }

    public int maxChocolate(int[][] grid) {
        n = grid.length;
        m = grid[0].length;

        dp = new int[n][m][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                Arrays.fill(dp[i][j], -1);

        return solve(0, 0, m - 1, grid);
    }
}