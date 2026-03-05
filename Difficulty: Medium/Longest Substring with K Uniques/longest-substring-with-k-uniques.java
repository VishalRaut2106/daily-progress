class Solution {
    public int longestKSubstr(String s, int k) {
        
        int[] f = new int[26];
        int l = 0, d = 0, ans = -1;
        
        for (int r = 0; r < s.length(); r++) {
            
            int idx = s.charAt(r) - 'a';
            
            if (f[idx] == 0) d++;
           
            f[idx]++;
            
            while (d > k) {
                int leftIdx = s.charAt(l) - 'a';
                f[leftIdx]--;
                if (f[leftIdx] == 0) d--;
                l++;
            }
            
            if (d == k) {
                ans = Math.max(ans, r - l + 1);
            }
        }
        
        return ans;
    }
}