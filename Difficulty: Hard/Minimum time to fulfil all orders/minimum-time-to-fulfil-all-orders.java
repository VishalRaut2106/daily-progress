class Solution {
    public int minTime(int[] ranks, int n) {
        int minRank = Integer.MAX_VALUE;
        for (int r : ranks) minRank = Math.min(minRank, r);

        long low = 0;
        long high = (long) minRank * n * (n + 1) / 2;
        long ans = high;

        while (low <= high) {
            long mid = (low + high) / 2;

            if (canMake(ranks, n, mid)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return (int) ans;
    }

    private boolean canMake(int[] ranks, int n, long time) {
        long total = 0;

        for (int r : ranks) {
            long k = 0;
            long currTime = 0;

            while (true) {
                currTime += r * (k + 1);
                if (currTime > time) break;
                k++;
            }

            total += k;
            if (total >= n) return true;
        }

        return false;
    }
}