import java.util.*;

class Solution {
    public int countPaths(int V, int[][] edges) {
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

        for (int[] e : edges) {
            adj.get(e[0]).add(new int[]{e[1], e[2]});
            adj.get(e[1]).add(new int[]{e[0], e[2]});
        }

        long[] dist = new long[V];
        Arrays.fill(dist, Long.MAX_VALUE);

        int MOD = (int)1e9 + 7;
        int[] ways = new int[V];

        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[1], b[1]));

        dist[0] = 0;
        ways[0] = 1;
        pq.add(new long[]{0, 0}); // {node, distance}

        while (!pq.isEmpty()) {
            long[] curr = pq.poll();
            int u = (int)curr[0];
            long d = curr[1];

            if (d > dist[u]) continue;

            for (int[] nei : adj.get(u)) {
                int v = nei[0];
                long wt = nei[1];

                if (d + wt < dist[v]) {
                    dist[v] = d + wt;
                    ways[v] = ways[u];
                    pq.add(new long[]{v, dist[v]});
                } 
                else if (d + wt == dist[v]) {
                    ways[v] = (ways[v] + ways[u]) % MOD;
                }
            }
        }

        return ways[V - 1];
    }
}