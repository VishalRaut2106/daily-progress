class Solution {
    public int tsp(int[][] cost) {
        int n = cost.length;
        int FULL_MASK = (1 << n) - 1;

        int[][] dp = new int[1 << n][n];

        // Initialize dp with a large value
        for (int i = 0; i < (1 << n); i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = Integer.MAX_VALUE / 2;
            }
        }

        // Start from city 0
        dp[1][0] = 0;

        for (int mask = 1; mask < (1 << n); mask++) {
            for (int u = 0; u < n; u++) {
                if ((mask & (1 << u)) != 0) { // city u is in visited mask
                    for (int v = 0; v < n; v++) {
                        if ((mask & (1 << v)) == 0) { // city v not visited
                            int nextMask = mask | (1 << v);
                            dp[nextMask][v] = Math.min(dp[nextMask][v], dp[mask][u] + cost[u][v]);
                        }
                    }
                }
            }
        }

        // Return to city 0
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            ans = Math.min(ans, dp[FULL_MASK][i] + cost[i][0]);
        }

        return ans;
    }
}