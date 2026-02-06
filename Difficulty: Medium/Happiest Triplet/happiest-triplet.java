class Solution {
    int[] smallestDiff(int a[], int b[], int c[]) {
        Arrays.sort(a);
        Arrays.sort(b);
        Arrays.sort(c);

        int i = 0, j = 0, k = 0;
        int n = a.length;

        int bestDiff = Integer.MAX_VALUE;
        int bestSum = Integer.MAX_VALUE;
        int x = 0, y = 0, z = 0;

        while (i < n && j < n && k < n) {
            int A = a[i], B = b[j], C = c[k];

            int max = Math.max(A, Math.max(B, C));
            int min = Math.min(A, Math.min(B, C));
            int diff = max - min;
            int sum = A + B + C;

            if (diff < bestDiff || (diff == bestDiff && sum < bestSum)) {
                bestDiff = diff;
                bestSum = sum;
                x = A; y = B; z = C;
            }

            if (min == A) i++;
            else if (min == B) j++;
            else k++;
        }

        int[] ans = new int[]{x, y, z};
        Arrays.sort(ans);
        return new int[]{ans[2], ans[1], ans[0]}; // dec order
    }
}
