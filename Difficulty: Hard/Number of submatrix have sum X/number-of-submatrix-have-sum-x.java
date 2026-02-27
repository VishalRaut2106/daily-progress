class Solution {
    public int countSquare(int[][] mat, int x) {
        int n = mat.length;
        int m = mat[0].length;

        
        long[][] pre = new long[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                pre[i][j] = mat[i - 1][j - 1]
                        + pre[i - 1][j]
                        + pre[i][j - 1]
                        - pre[i - 1][j - 1];
            }
        }

        int count = 0;
        int maxSize = Math.min(n, m);
        
        for (int size = 1; size <= maxSize; size++) {
            for (int i = size; i <= n; i++) {
                for (int j = size; j <= m; j++) {
                    long sum = pre[i][j]
                            - pre[i - size][j]
                            - pre[i][j - size]
                            + pre[i - size][j - size];

                    if (sum == x) count++;
                }
            }
        }

        return count;
    }
}