class Solution {
    public int countIncreasing(int[] arr) {
        int n = arr.length;
        int len = 1;
        int count = 0;
        
        for (int i = 1; i < n; i++) {
            if (arr[i] > arr[i - 1]) {
                len++;
            } else {
                count += (len * (len - 1)) / 2;
                len = 1;
            }
        }
        
        // last segment add
        count += (len * (len - 1)) / 2;
        
        return count;
    }
}