class Solution {
    public int maxSubarraySum(int[] arr, int k) {
        int n = arr.length;

        // Step 1: calculate sum of first window
        int windowSum = 0;
        for (int i = 0; i < k; i++) {
            windowSum += arr[i];
        }

        int maxSum = windowSum;

        // Step 2: slide the window
        for (int i = k; i < n; i++) {
            windowSum += arr[i];       // add next element
            windowSum -= arr[i - k];   // remove outgoing element
            maxSum = Math.max(maxSum, windowSum);
        }

        return maxSum;
    }
}