class Solution {
    public int countSubstr(String s, int k) {
        if (k == 0) return 0;
        return atMostK(s, k) - atMostK(s, k - 1);
    }

    private int atMostK(String s, int k) {
        int[] freq = new int[26];
        int left = 0, distinct = 0;
        int count = 0;

        for (int right = 0; right < s.length(); right++) {
            int idx = s.charAt(right) - 'a';
            if (freq[idx] == 0) distinct++;
            freq[idx]++;

            while (distinct > k) {
                int lIdx = s.charAt(left) - 'a';
                freq[lIdx]--;
                if (freq[lIdx] == 0) distinct--;
                left++;
            }

            count += (right - left + 1);
        }
        return count;
    }
}