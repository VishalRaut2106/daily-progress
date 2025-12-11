import java.util.ArrayList;

class Solution {
    public ArrayList<Integer> constructArr(int[] arr) {
        ArrayList<Integer> res = new ArrayList<>();
        int m = arr.length;
        if (m == 0) return res;

        // find n such that n*(n-1)/2 == m
        int n = 2;
        while (n * (n - 1) / 2 < m) n++;
        if (n * (n - 1) / 2 != m) return res; // invalid size (shouldn't happen per problem)

        if (n == 2) {
            // any two numbers that sum to arr[0] are valid; choose (arr[0]-1,1) safely (positive if arr[0]>1)
            int a = Math.max(1, arr[0] - 1);
            int b = arr[0] - a;
            res.add(a);
            res.add(b);
            return res;
        }

        // use long to avoid overflow
        long A0 = arr[0];
        long A1 = arr[1];
        long An_1 = arr[n - 1]; // this is sum of res[1] + res[2]

        long r0long = (A0 + A1 - An_1);
        if (r0long % 2 != 0) {
            // no integer solution (shouldn't happen for valid input)
            return res;
        }
        r0long /= 2;

        long r0 = r0long;
        long r1 = A0 - r0;
        long r2 = A1 - r0;

        res.add((int) r0);
        res.add((int) r1);
        res.add((int) r2);

        // For k >= 3, index of pair (0,k) is (k - 1)
        for (int k = 3; k < n; k++) {
            int idx = k - 1;
            long rk = (long) arr[idx] - r0;
            res.add((int) rk);
        }

        return res;
    }
}