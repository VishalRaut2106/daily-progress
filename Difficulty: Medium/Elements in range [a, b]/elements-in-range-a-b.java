
class Solution {
    public ArrayList<Integer> cntInRange(int[] arr, int[][] queries) {
        ArrayList<Integer> ans = new ArrayList<>();
        
        // Step 1: Sort the array
        Arrays.sort(arr);
        
        // Step 2: Process each query
        for (int[] q : queries) {
            int a = q[0];
            int b = q[1];
            
            int right = upperBound(arr, b);
            int left = lowerBound(arr, a);
            
            ans.add(right - left);
        }
        return ans;
    }
    
    // First index where value >= target
    private int lowerBound(int[] arr, int target) {
        int l = 0, r = arr.length;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] < target) l = mid + 1;
            else r = mid;
        }
        return l;
    }
    
    // First index where value > target
    private int upperBound(int[] arr, int target) {
        int l = 0, r = arr.length;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] <= target) l = mid + 1;
            else r = mid;
        }
        return l;
    }
}