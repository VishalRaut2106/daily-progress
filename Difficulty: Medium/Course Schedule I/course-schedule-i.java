import java.util.*;

class Solution {
    public boolean canFinish(int n, int[][] prerequisites) {
        
        // Step 1: Graph + indegree
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < n; i++) graph.add(new ArrayList<>());
        
        int[] indegree = new int[n];
        
        for(int[] p : prerequisites) {
            int course = p[0];
            int pre = p[1];
            
            graph.get(pre).add(course);
            indegree[course]++;
        }
        
        // Step 2: Queue for 0 indegree
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            if(indegree[i] == 0) q.add(i);
        }
        
        // Step 3: Process
        int count = 0;
        
        while(!q.isEmpty()) {
            int node = q.poll();
            count++;
            
            for(int nei : graph.get(node)) {
                indegree[nei]--;
                if(indegree[nei] == 0) {
                    q.add(nei);
                }
            }
        }
        
        // Step 4: Check
        return count == n;
    }
}