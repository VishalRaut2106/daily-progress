class Solution {

    static class TrieNode {
        TrieNode[] bit = new TrieNode[2];
        int count = 0;
    }

    TrieNode root = new TrieNode();
    static final int MAX_BIT = 15; // since arr[i] <= 50000 approx fits in 16 bits

    public void insert(int num) {
        TrieNode node = root;
        for (int i = MAX_BIT; i >= 0; i--) {
            int b = (num >> i) & 1;
            if (node.bit[b] == null) node.bit[b] = new TrieNode();
            node = node.bit[b];
            node.count++;
        }
    }

    public int query(int num, int k) {
        TrieNode node = root;
        int ans = 0;

        for (int i = MAX_BIT; i >= 0; i--) {
            if (node == null) break;

            int nb = (num >> i) & 1; // bit of number
            int kb = (k >> i) & 1;   // bit of k

            if (kb == 1) {
                // if k bit is 1, we can choose same bit nb
                if (node.bit[nb] != null) ans += node.bit[nb].count;
                node = node.bit[nb ^ 1];
            } else {
                // if k bit is 0, we must match bit exactly
                node = node.bit[nb];
            }
        }
        return ans;
    }

    public int cntPairs(int[] arr, int k) {
        int result = 0;

        for (int num : arr) {
            result += query(num, k);
            insert(num);
        }

        return result;
    }
}