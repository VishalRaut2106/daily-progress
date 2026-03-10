class Solution {
    public int countSubarrays(int[] arr) {
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        long ans = 0;

        for(int i = n-1; i >= 0; i--){
            
           
           
           while(!st.isEmpty() && arr[st.peek()] >= arr[i]){
                st.pop();
            }

            
            int next = st.isEmpty() ? n : st.peek();
            ans += (next - i);

            st.push(i);
        }

        return (int)ans;
    }
}