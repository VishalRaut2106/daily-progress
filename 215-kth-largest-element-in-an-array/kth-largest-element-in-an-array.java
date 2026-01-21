class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (int n : nums) {
            maxHeap.add(n);

        }
        int result = 0;
        for (int i = 0; i < k; i++) {
            result = maxHeap.poll();
        }
        return result;

    }
}