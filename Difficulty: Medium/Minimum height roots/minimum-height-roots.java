import java.util.*;

class Solution {
    public ArrayList<Integer> minHeightRoot(int V, int[][] edges) {
        ArrayList<Integer> result = new ArrayList<>();

        if (V == 1) {
            result.add(0);
            return result;
        }

        // Graph
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        int[] degree = new int[V];

        for (int[] e : edges) {
            int u = e[0], v = e[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
            degree[u]++;
            degree[v]++;
        }

        // Leaves
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (degree[i] == 1) {
                q.offer(i);
            }
        }

        int remaining = V;

        // Trim leaves
        while (remaining > 2) {
            int size = q.size();
            remaining -= size;

            for (int i = 0; i < size; i++) {
                int leaf = q.poll();

                for (int nei : adj.get(leaf)) {
                    degree[nei]--;

                    if (degree[nei] == 1) {
                        q.offer(nei);
                    }
                }
            }
        }

        while (!q.isEmpty()) {
            result.add(q.poll());
        }

        return result;
    }
}