class Solution {
    public String firstNonRepeating(String s) {
        
        int[] freq = new int[26];          // frequency count
        Queue<Character> q = new LinkedList<>();
        
        StringBuilder ans = new StringBuilder();
        
        for (char ch : s.toCharArray()) {
            
            // step 1: update frequency
            freq[ch - 'a']++;
            
            // step 2: push into queue
            q.offer(ch);
            
            // step 3: remove repeating characters from front
            while (!q.isEmpty() && freq[q.peek() - 'a'] > 1) {
                q.poll();
            }
            
            // step 4: append answer
            if (q.isEmpty()) {
                ans.append('#');
            } else {
                ans.append(q.peek());
            }
        }
        
        return ans.toString();
    }
}