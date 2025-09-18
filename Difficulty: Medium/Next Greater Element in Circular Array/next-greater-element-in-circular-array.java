class Solution {
    public ArrayList<Integer> nextGreater(int[] arr) {
        // code here
    int  n = arr.length;
    ArrayList<Integer> result = new ArrayList<> (Collections.nCopies(n , -1));
    Stack<Integer> stack = new Stack<>();
    
    for (int i = 0 ; i< 2 * n; i++){
        while (!stack.isEmpty() && arr[stack.peek()] < arr[i % n]){
            result.set(stack.pop() , arr[i % n]);
        }
        if (i < n) stack.push(i);
    }
    return result;
    }
}