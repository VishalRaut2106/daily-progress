import java.util.*;

class Solution {
    public static ArrayList<Integer> topKFreq(int[] arr, int k) {
        // Step 1: Count frequencies
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : arr) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        // Step 2: Use a max heap (PriorityQueue)
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (b[1] == a[1]) return b[0] - a[0]; // higher number first if freq same
            return b[1] - a[1]; // higher frequency first
        });

        // Step 3: Push all into heap
        for (Map.Entry<Integer, Integer> e : freq.entrySet()) {
            pq.add(new int[]{e.getKey(), e.getValue()});
        }

        // Step 4: Extract top k elements
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < k && !pq.isEmpty(); i++) {
            res.add(pq.poll()[0]);
        }

        return res;
    }
}