import java.util.*;

class Solution {
    public String findLargest(int[] arr) {
        String[] s = new String[arr.length];
        for (int i = 0; i < arr.length; i++) {
            s[i] = String.valueOf(arr[i]);
        }

        Arrays.sort(s, (a, b) -> (b + a).compareTo(a + b));

        
        if (s[0].equals("0")) return "0";

        StringBuilder ans = new StringBuilder();
        for (String x : s) ans.append(x);

        return ans.toString();
    }
}