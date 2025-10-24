import java.util.*;

class Solution {
    public boolean isPossible(int[] arr, int k) {
        // optional tiny fast-path
        if (k <= 1) return true;

        Map<Integer, Integer> freq = new HashMap<>();
        Map<Integer, Integer> need = new HashMap<>();

        for (int num : arr)
            freq.put(num, freq.getOrDefault(num, 0) + 1);

        for (int num : arr) {
            if (freq.getOrDefault(num, 0) == 0) continue;

            if (need.getOrDefault(num, 0) > 0) {
                // extend an existing subsequence that expects `num`
                freq.put(num, freq.get(num) - 1);
                need.put(num, need.getOrDefault(num, 0) - 1);
                need.put(num + 1, need.getOrDefault(num + 1, 0) + 1);
            } else {
                // try to start a new subsequence of length k: num, num+1, ..., num+k-1
                for (int i = 0; i < k; i++) {
                    if (freq.getOrDefault(num + i, 0) == 0)
                        return false;
                    freq.put(num + i, freq.get(num + i) - 1);
                }
                // the new subsequence (currently length k) would next want num+k
                need.put(num + k, need.getOrDefault(num + k, 0) + 1);
            }
        }

        return true;
    }
}