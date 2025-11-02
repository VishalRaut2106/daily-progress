class Solution {
  public:
    int maxEdgesToAdd(int V, vector<vector<int>>& edges) {
        vector<int> adj[V];
        vector<int> indeg(V, 0);
        
        // Build adjacency list
        for (auto &e : edges) {
            adj[e[0]].push_back(e[1]);
            indeg[e[1]]++;
        }
        
        // Kahn's Algorithm for Topological Sort
        queue<int> q;
        for (int i = 0; i < V; i++) 
            if (indeg[i] == 0) q.push(i);
        
        vector<int> topo;
        while (!q.empty()) {
            int u = q.front(); q.pop();
            topo.push_back(u);
            for (int v : adj[u]) {
                if (--indeg[v] == 0)
                    q.push(v);
            }
        }
        
        // Mark existing edges
        vector<vector<bool>> connected(V, vector<bool>(V, false));
        for (auto &e : edges)
            connected[e[0]][e[1]] = true;
        
        int count = 0;
        // Count possible edges (u before v in topo order)
        for (int i = 0; i < V; i++) {
            for (int j = i + 1; j < V; j++) {
                int u = topo[i];
                int v = topo[j];
                if (!connected[u][v])
                    count++;
            }
        }
        return count;
    }
};