class Solution {
    public int getCount(int n, int d) {
        int lo = 1, hi = n, ans = n + 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (isValid(mid, d)) {
                ans = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        if (ans == n + 1) return 0;
        return n - ans + 1;
    }

    private boolean isValid(int x, int d) {
        return x - digitSum(x) >= d;
    }

    private int digitSum(int x) {
        int sum = 0;
        while (x > 0) {
            sum += x % 10;
            x /= 10;
        }
        return sum;
    }
}