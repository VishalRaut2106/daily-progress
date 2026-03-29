class Solution {
    public int countPartitions(int[] arr, int diff) {
        int sum = 0;
        for (int num : arr) sum += num;

        // Edge cases
        if ((sum + diff) % 2 != 0 || sum < diff) return 0;

        int target = (sum + diff) / 2;

        return countSubsets(arr, target);
    }

    private int countSubsets(int[] arr, int target) {
        int n = arr.length;
        int[][] dp = new int[n + 1][target + 1];

        // Base case
        dp[0][0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= target; j++) {
                // Not take
                dp[i][j] = dp[i - 1][j];

                // Take
                if (arr[i - 1] <= j) {
                    dp[i][j] += dp[i - 1][j - arr[i - 1]];
                }
            }
        }

        return dp[n][target];
    }
}