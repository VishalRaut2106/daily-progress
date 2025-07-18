import java.util.PriorityQueue;

class Solution {
    public long minimumDifference(int[] nums) {
        int n = nums.length;
        int k = n / 3;

        // Step-1: Build right_maxsum array (stores the max sum of k elements from index i to n-1)
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        long rightSum = 0;
        long[] rightMaxSum = new long[n];
        
        for (int i = n - 1; i >= k; i--) {
            minHeap.offer(nums[i]);
            rightSum += nums[i];
            if (minHeap.size() > k) {
                rightSum -= minHeap.poll();
            }
            if (minHeap.size() == k) {
                rightMaxSum[i] = rightSum;
            }
        }

        // Step-2: Compute min-diff by traversing left part (0 to 2k-1)
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        long leftSum = 0;
        long minDiff = Long.MAX_VALUE;

        for (int i = 0; i < 2 * k; i++) {
            maxHeap.offer(nums[i]);
            leftSum += nums[i];
            if (maxHeap.size() > k) {
                leftSum -= maxHeap.poll();
            }
            if (maxHeap.size() == k && i + 1 < n) {
                minDiff = Math.min(minDiff, leftSum - rightMaxSum[i + 1]);
            }
        }
        return minDiff;
    }
}