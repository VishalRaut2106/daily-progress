class Solution {
    public String removeKdig(String s, int k) {
        int n = s.length();
        StringBuilder stack = new StringBuilder();

        for (int i = 0; i < n; i++) {
            char curr = s.charAt(i);

            while (k > 0 && stack.length() > 0 &&
                   stack.charAt(stack.length() - 1) > curr) {
                stack.deleteCharAt(stack.length() - 1);
                k--;
            }

            stack.append(curr);
        }

        while (k > 0 && stack.length() > 0) {
            stack.deleteCharAt(stack.length() - 1);
            k--;
        }

        
        int idx = 0;
        while (idx < stack.length() && stack.charAt(idx) == '0') {
            idx++;
        }

        String ans = stack.substring(idx);
        return ans.length() == 0 ? "0" : ans;
    }
}