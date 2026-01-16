import java.util.*;

class Solution {
    public int minMen(int arr[]) {
        int n = arr.length;
        List<int[]> intervals = new ArrayList<>();

        //  Build intervals
        for (int i = 0; i < n; i++) {
            if (arr[i] != -1) {
                int left = Math.max(0, i - arr[i]);
                int right = Math.min(n - 1, i + arr[i]);
                intervals.add(new int[]{left, right});
            }
        }

        // Sort intervals
        intervals.sort((a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0];
            return b[1] - a[1];
        });

        int currEnd = 0;
        int idx = 0;
        int count = 0;

        // Greedy cover
        while (currEnd < n) {
            int farthest = currEnd;

            while (idx < intervals.size() && intervals.get(idx)[0] <= currEnd) {
                farthest = Math.max(farthest, intervals.get(idx)[1] + 1);
                idx++;
            }

            if (farthest == currEnd) return -1;

            count++;
            currEnd = farthest;
        }

        return count;
    }
}