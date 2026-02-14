class Solution {
    public int minTime(int[] arr, int k) {
        int low = 0, high = 0;

        for (int x : arr) {
            low = Math.max(low, x);
            high += x;
        }

        int ans = high;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (isPossible(arr, k, mid)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    private boolean isPossible(int[] arr, int k, int maxTime) {
        int painters = 1;
        int curr = 0;

        for (int x : arr) {
            if (curr + x <= maxTime) {
                curr += x;
            } else {
                painters++;
                curr = x;

                if (painters > k) return false;
            }
        }
        return true;
    }
}