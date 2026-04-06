import java.util.*;

class Solution {
    public int[] stableMarriage(int[][] men, int[][] women) {
        
        int n = men.length;

        int[] wife = new int[n];     // woman -> man
        int[] husband = new int[n];  // man -> woman
        int[] next = new int[n];     // next proposal index

        Arrays.fill(wife, -1);
        Arrays.fill(husband, -1);

        // ranking: womanRank[w][m] = preference rank
        int[][] womanRank = new int[n][n];
        for (int w = 0; w < n; w++) {
            for (int i = 0; i < n; i++) {
                womanRank[w][women[w][i]] = i;
            }
        }

        Queue<Integer> freeMen = new LinkedList<>();
        for (int i = 0; i < n; i++) freeMen.add(i);

        while (!freeMen.isEmpty()) {
            int m = freeMen.poll();

            int w = men[m][next[m]];
            next[m]++;

            if (wife[w] == -1) {
                // woman free
                wife[w] = m;
                husband[m] = w;
            } else {
                int m1 = wife[w];

                // check preference
                if (womanRank[w][m] < womanRank[w][m1]) {
                    // she prefers new man
                    wife[w] = m;
                    husband[m] = w;

                    husband[m1] = -1;
                    freeMen.add(m1);
                } else {
                    // she rejects new man
                    freeMen.add(m);
                }
            }
        }

        return husband;
    }
}