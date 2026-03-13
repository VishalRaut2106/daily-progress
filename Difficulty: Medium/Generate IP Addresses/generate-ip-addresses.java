import java.util.*;

class Solution {

    public ArrayList<String> generateIp(String s) {
        ArrayList<String> ans = new ArrayList<>();
        solve(s, 0, 0, "", ans);
        return ans;
    }

    void solve(String s, int i, int p, String cur, ArrayList<String> ans) {

        if (p == 4 && i == s.length()) {
            ans.add(cur.substring(0, cur.length() - 1));
            return;
        }

        if (p == 4 || i == s.length()) return;

        for (int l = 1; l <= 3 && i + l <= s.length(); l++) {

            String t = s.substring(i, i + l);

            if (t.length() > 1 && t.charAt(0) == '0') continue;

            int n = Integer.parseInt(t);
            if (n > 255) continue;

            solve(s, i + l, p + 1, cur + t + ".", ans);
        }
    }
}