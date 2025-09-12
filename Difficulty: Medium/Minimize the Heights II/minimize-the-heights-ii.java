class Solution {
    public int getMinDiff(int[] arr, int k) {
        // code here
        Arrays.sort(arr);
        
        int  n = arr.length , ans = arr[n - 1] -arr[0];
        
        for(int  i  = 1 ; i < n ; i++){
            if (arr[i] >= k){
                int min  = Math.min(arr[0] + k , arr[i] - k);
                int max  = Math.max(arr[n - 1] - k , arr[i - 1] + k);
                ans = Math.min(ans , max - min);
            }
        }
        return ans;
    }
}
