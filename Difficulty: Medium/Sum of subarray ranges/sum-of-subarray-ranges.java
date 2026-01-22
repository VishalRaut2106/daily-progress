class Solution {
    public int subarrayRanges(int[] arr) {
        int n = arr.length;
        long sumMax = 0, sumMin = 0;

        // ---------- MAX CONTRIBUTION ----------
        Stack<Integer> st = new Stack<>();

        // Previous Greater
        int[] pg = new int[n];
        Arrays.fill(pg, -1);
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] <= arr[i]) st.pop();
            pg[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        st.clear();

        // Next Greater or Equal
        int[] ng = new int[n];
        Arrays.fill(ng, n);
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] < arr[i]) st.pop();
            ng[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }

        for (int i = 0; i < n; i++) {
            long left = i - pg[i];
            long right = ng[i] - i;
            sumMax += arr[i] * left * right;
        }

        // ---------- MIN CONTRIBUTION ----------
        st.clear();

        // Previous Smaller
        int[] ps = new int[n];
        Arrays.fill(ps, -1);
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) st.pop();
            ps[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        st.clear();

        // Next Smaller or Equal
        int[] ns = new int[n];
        Arrays.fill(ns, n);
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] > arr[i]) st.pop();
            ns[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }

        for (int i = 0; i < n; i++) {
            long left = i - ps[i];
            long right = ns[i] - i;
            sumMin += arr[i] * left * right;
        }

        return (int)(sumMax - sumMin);
    }
}