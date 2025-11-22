class Solution {
    
    public int minConnect(int V, int[][] edges) {
        int[] parent = new int[V];
        int[] rank = new int[V];
        
        for(int i = 0; i < V; i++)
            parent[i] = i;

        int extraEdges = 0;

        // Count redundant edges using DSU
        for(int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            if(find(u, parent) == find(v, parent)) {
                extraEdges++; // redundant edge
            } else {
                union(u, v, parent, rank);
            }
        }

        // Count connected components
        int components = 0;
        for(int i = 0; i < V; i++) {
            if(parent[i] == i) components++;
        }

        int required = components - 1;

        // If we have enough extra edges to connect components
        return extraEdges >= required ? required : -1;
    }

    // DSU find with path compression
    private int find(int x, int[] parent) {
        if(parent[x] != x)
            parent[x] = find(parent[x], parent);
        return parent[x];
    }

    // DSU union by rank
    private void union(int x, int y, int[] parent, int[] rank) {
        int rootX = find(x, parent);
        int rootY = find(y, parent);

        if(rootX == rootY) return;

        if(rank[rootX] < rank[rootY]) {
            parent[rootX] = rootY;
        } else if(rank[rootX] > rank[rootY]) {
            parent[rootY] = rootX;
        } else {
            parent[rootY] = rootX;
            rank[rootX]++;
        }}
    }