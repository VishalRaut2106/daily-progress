class Solution {
    public ArrayList<Integer> nextFreqGreater(int[] arr) {
        int n = arr.length;
        ArrayList<Integer> res = new ArrayList<>();
        
        // Step 1: Frequency map
        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int x : arr) {
            freq.put(x, freq.getOrDefault(x, 0) + 1);
        }
        
        // Step 2: Stack for candidates
        Stack<Integer> st = new Stack<>();
        
        // Prepare result with size n
        for (int i = 0; i < n; i++) res.add(0);
        
        // Step 3: Traverse from right
        for (int i = n - 1; i >= 0; i--) {
            int curr = arr[i];
            
            while (!st.isEmpty() && freq.get(st.peek()) <= freq.get(curr)) {
                st.pop();
            }
            
            res.set(i, st.isEmpty() ? -1 : st.peek());
            
            st.push(curr);
        }
        
        return res;
    }
}