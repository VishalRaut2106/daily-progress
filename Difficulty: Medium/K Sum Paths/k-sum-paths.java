class Solution {

    public int countAllPaths(Node root, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        return dfs(root, 0, k, map);
    }

    private int dfs(Node node, int currSum, int k, HashMap<Integer, Integer> map) {
        if (node == null) return 0;

        currSum += node.data;

        int count = map.getOrDefault(currSum - k, 0);

        map.put(currSum, map.getOrDefault(currSum, 0) + 1);

        count += dfs(node.left, currSum, k, map);
        count += dfs(node.right, currSum, k, map);

        map.put(currSum, map.get(currSum) - 1);

        return count;
    }
}