class Solution {
    public int getLastMoment(int n, int left[], int right[]) {

        int ans = 0;

        // Ants moving left
        for (int p : left) {
            ans = Math.max(ans, p);
        }

        // Ants moving right
        for (int p : right) {
            ans = Math.max(ans, n - p);
        }

        return ans;
    }
}