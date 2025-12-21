class Solution {
    
    public ArrayList<Integer> countXInRange(int[] arr, int[][] queries) {
        ArrayList<Integer> result = new ArrayList<>();
        
        for (int[] q : queries) {
            int l = q[0];
            int r = q[1];
            int x = q[2];
            
            int left = lowerBound(arr, x);
            int right = upperBound(arr, x) - 1;
            
            // restrict within range [l, r]
            left = Math.max(left, l);
            right = Math.min(right, r);
            
            if (left <= right) {
                result.add(right - left + 1);
            } else {
                result.add(0);
            }
        }
        return result;
    }
    
    // first idx >= x
    private int lowerBound(int[] arr, int x) {
        int low = 0, high = arr.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] < x)
                low = mid + 1;
            else
                high = mid;
        }
        return low;
    }
    
    // first index > x
    private int upperBound(int[] arr, int x) {
        int low = 0, high = arr.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] <= x)
                low = mid + 1;
            else
                high = mid;
        }
        return low;
    }
}