class Solution {
    public boolean areIsomorphic(String s1, String s2) {
        int[] map1 = new int[26];
        int[] map2 = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            int c1 = s1.charAt(i) - 'a';
            int c2 = s2.charAt(i) - 'a';

            if (map1[c1] == 0 && map2[c2] == 0) {
                map1[c1] = c2 + 1;
                map2[c2] = c1 + 1;
            } else {
                if (map1[c1] != c2 + 1 || map2[c2] != c1 + 1) {
                    return false;
                }
            }
        }
        return true;
    }
}