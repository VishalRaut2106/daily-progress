class Solution {
    public int maxCircularSum(int arr[]) {

        int totalSum = 0;

        int maxKadane = arr[0];
        int currMax = arr[0];

        int minKadane = arr[0];
        int currMin = arr[0];

        totalSum = arr[0];

        for (int i = 1; i < arr.length; i++) {

            int x = arr[i];
            totalSum += x;

            // Max subarray (Kadane)
            currMax = Math.max(x, currMax + x);
            maxKadane = Math.max(maxKadane, currMax);

            // Min subarray (Kadane)
            currMin = Math.min(x, currMin + x);
            minKadane = Math.min(minKadane, currMin);
        }

        // All negative case
        if (maxKadane < 0) return maxKadane;

        // Wrapping case
        int wrapSum = totalSum - minKadane;

        return Math.max(maxKadane, wrapSum);
    }
}