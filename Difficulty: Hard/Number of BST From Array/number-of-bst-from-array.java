import java.util.*;

class Solution {
    public ArrayList<Integer> countBSTs(int[] arr) {
        int n = arr.length;
        
        // Step 1: Precompute Catalan numbers up to n
        int[] catalan = new int[n + 1];
        catalan[0] = catalan[1] = 1;

        for (int i = 2; i <= n; i++) {
            catalan[i] = 0;
            for (int j = 0; j < i; j++) {
                catalan[i] += catalan[j] * catalan[i - j - 1];
            }
        }

        // Step 2: Compute result
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int left = 0, right = 0;

            for (int j = 0; j < n; j++) {
                if (arr[j] < arr[i]) left++;
                else if (arr[j] > arr[i]) right++;
            }

            result.add(catalan[left] * catalan[right]);
        }

        return result;
    }
}