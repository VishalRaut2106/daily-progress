class Solution {
    int maxSum(int[] arr) {
        int n = arr.length;
        int sum = 0;
        int curr = 0;

        for (int i = 0; i < n; i++) {
            sum += arr[i];
            curr += i * arr[i];
        }

        int ans = curr;

        for (int i = 1; i < n; i++) {
            curr = curr + sum - n * arr[n - i];
            ans = Math.max(ans, curr);
        }

        return ans;
    }
}