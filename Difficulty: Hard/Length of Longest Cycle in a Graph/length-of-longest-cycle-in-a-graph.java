class Solution {
    public int longestCycle(int V, int[][] edges) {
        int[] next = new int[V];
        
        // Convert edges[][] to next[]
        for (int i = 0; i < V; i++) next[i] = -1;
        for (int[] e : edges) {
            next[e[0]] = e[1];
        }
        
        boolean[] visited = new boolean[V];
        int[] time = new int[V];
        
        int maxCycle = -1;
        
        for (int i = 0; i < V; i++) {
            if (visited[i]) continue;
            
            int node = i;
            int currTime = 0;
            
            HashMap<Integer, Integer> map = new HashMap<>();
            
            while (node != -1) {
                if (visited[node]) {
                    // If visited in current path → cycle
                    if (map.containsKey(node)) {
                        int cycleLength = currTime - map.get(node);
                        maxCycle = Math.max(maxCycle, cycleLength);
                    }
                    break;
                }
                
                visited[node] = true;
                map.put(node, currTime++);
                
                node = next[node];
            }
        }
        
        return maxCycle;
    }
}