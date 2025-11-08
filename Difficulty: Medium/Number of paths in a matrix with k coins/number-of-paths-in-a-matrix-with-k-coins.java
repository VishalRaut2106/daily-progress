class Solution {
    public int numberOfPath(int[][] mat, int k) {
        int n = mat.length, m = mat[0].length;
        int[][] dp = new int[m][k + 1];
        if (mat[0][0] <= k) dp[0][mat[0][0]] = 1;
        for (int j = 1; j < m; j++)
            for (int s = mat[0][j]; s <= k; s++)
                dp[j][s] = dp[j - 1][s - mat[0][j]];
        for (int i = 1; i < n; i++) {
            int[][] ndp = new int[m][k + 1];
            if (mat[i][0] <= k)
                for (int s = mat[i][0]; s <= k; s++)
                    ndp[0][s] = dp[0][s - mat[i][0]];
            for (int j = 1; j < m; j++)
                for (int s = mat[i][j]; s <= k; s++)
                    ndp[j][s] = ndp[j - 1][s - mat[i][j]] + dp[j][s - mat[i][j]];
            dp = ndp;
        }
        return dp[m - 1][k];
    }
}