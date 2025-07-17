class Solution {
    public int maximumLength(int[] nums, int k) {
        int n = nums.length;
        int[][] dp = new int[n][k];
        int maxLen = 1;

        for (int i = 0; i < n; i++) {
            // Every number can be a starting point
            for (int mod = 0; mod < k; mod++) {
                dp[i][mod] = 1;
            }

            for (int j = 0; j < i; j++) {
                int mod = (nums[j] + nums[i]) % k;
                // Extend the subsequence ending at j with same mod
                dp[i][mod] = Math.max(dp[i][mod], dp[j][mod] + 1);
                maxLen = Math.max(maxLen, dp[i][mod]);
            }
        }

        return maxLen;
    }
}
