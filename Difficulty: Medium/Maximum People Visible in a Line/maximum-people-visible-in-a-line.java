class Solution {
    public int maxPeople(int[] arr) {
        // code here
        int n = arr.length;
        int [] leftGE = new int [n];
        int[] rightGE = new int [n];
        
        // nearest greater or equal on the left
        
        java.util.Stack<Integer> st = new java.util.Stack<>();
        for (int i =0; i< n ; i++){
            while(!st.isEmpty() && arr[st.peek()]< arr[i]){
                st.pop();
            }
            leftGE[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        // clear stcak
        st.clear();
        
        // Nearest G and E on right
        for (int i = n - 1 ; i >= 0 ;i--){
            while(!st.isEmpty() && arr[st.peek()] <arr[i]){
                st.pop();
            }  rightGE[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        // calculate visible people
        
        int max  = 0 ;
        for (int i =0; i < n ; i++){
            int leftVisible = i - leftGE[i] -1;
            int rightVisible = rightGE[i] - i -1;
            
            max = Math.max(max,leftVisible + rightVisible +1);
        }
        return max ;
        
    }
}
