class Solution {
    public ArrayList<Integer> calculateSpan(int[] arr) {
        ArrayList<Integer> span = new ArrayList<>();
        Stack<Integer> st = new Stack<>();
        
        for (int i = 0; i < arr.length; i++) {
       
            while (!st.isEmpty() && arr[st.peek()] <= arr[i]) {
                st.pop();
            }
            
          
            int currSpan = st.isEmpty() ? i + 1 : i - st.peek();
            span.add(currSpan);
            
          
            st.push(i);
        }
        return span;
    }
}