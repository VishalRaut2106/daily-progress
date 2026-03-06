class Solution {
    public String minWindow(String s, String p) {

        int n = s.length();
        int m = p.length();

        if (m > n) return "";

        int[] freq = new int[26];

        for (char c : p.toCharArray()) {
            freq[c - 'a']++;
        }

        int left = 0, count = 0;
        int minLen = Integer.MAX_VALUE;
        int start = 0;

        for (int right = 0; right < n; right++) {

            char c = s.charAt(right);
            freq[c - 'a']--;

            if (freq[c - 'a'] >= 0) {
                count++;
            }

            while (count == m) {

                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    start = left;
                }

                char leftChar = s.charAt(left);
                freq[leftChar - 'a']++;

                if (freq[leftChar - 'a'] > 0) {
                    count--;
                }

                left++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
}