import java.util.*;

class Solution {
    static int timer = 0;

    public ArrayList<Integer> articulationPoints(int V, int[][] edges) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

        // build graph
        for (int[] e : edges) {
            int u = e[0], v = e[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int[] tin = new int[V];
        int[] low = new int[V];
        boolean[] visited = new boolean[V];
        boolean[] mark = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfs(i, -1, adj, tin, low, visited, mark);
            }
        }

        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            if (mark[i]) res.add(i);
        }

        if (res.size() == 0) {
            res.add(-1);
        }

        return res;
    }

    private void dfs(int node, int parent, ArrayList<ArrayList<Integer>> adj,
                     int[] tin, int[] low, boolean[] visited, boolean[] mark) {

        visited[node] = true;
        tin[node] = low[node] = timer++;
        int child = 0;

        for (int nei : adj.get(node)) {

            if (nei == parent) continue;

            if (!visited[nei]) {
                dfs(nei, node, adj, tin, low, visited, mark);

                low[node] = Math.min(low[node], low[nei]);

                // articulation condition
                if (low[nei] >= tin[node] && parent != -1) {
                    mark[node] = true;
                }

                child++;
            } else {
                // back edge
                low[node] = Math.min(low[node], tin[nei]);
            }
        }

        // root case
        if (parent == -1 && child > 1) {
            mark[node] = true;
        }
    }
}