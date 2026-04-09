import java.util.*;

class Solution {
    ArrayList<Integer> intersection(int[] a, int[] b) {
        ArrayList<Integer> res = new ArrayList<>();
        
        int i = 0, j = 0;
        int n = a.length, m = b.length;
        
        while (i < n && j < m) {
            if (a[i] == b[j]) {
                // avoid duplicates in result
                if (res.isEmpty() || res.get(res.size() - 1) != a[i]) {
                    res.add(a[i]);
                }
                i++;
                j++;
            } 
            else if (a[i] < b[j]) {
                i++;
            } 
            else {
                j++;
            }
        }
        
        return res;
    }
}