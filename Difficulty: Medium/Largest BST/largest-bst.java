class Solution {

    static int maxBST = 0;

    static class Info {
        int min, max, size;
        boolean isBST;

        Info(int min, int max, int size, boolean isBST) {
            this.min = min;
            this.max = max;
            this.size = size;
            this.isBST = isBST;
        }
    }

    static Info solve(Node root) {
        // Base case
        if (root == null) {
            return new Info(Integer.MAX_VALUE, Integer.MIN_VALUE, 0, true);
        }

        Info left = solve(root.left);
        Info right = solve(root.right);

        // Check BST condition
        if (left.isBST && right.isBST && root.data > left.max && root.data < right.min) {

            int size = left.size + right.size + 1;
            maxBST = Math.max(maxBST, size);

            int min = Math.min(root.data, left.min);
            int max = Math.max(root.data, right.max);

            return new Info(min, max, size, true);
        }

        return new Info(Integer.MIN_VALUE, Integer.MAX_VALUE, 0, false);
    }

    static int largestBst(Node root) {
        maxBST = 0;
        solve(root);
        return maxBST;
    }
}