class Solution {
    public int maxSumIS(int arr[]) {
        // code here
       
        int n = arr.length;
        int dp[] = new int[n];
        
        
        for (int i = 0 ; i < n ; i++){
            dp[i]  = arr[i];
        }
        
        for (int i = 1 ; i< n; i++){
            for (int j = 0; j< i; j++){
                if (arr[j] < arr[i]){
                    dp[i] = Math.max(dp[i] , dp[j] + arr[i]);
                }
            }
        }
        int max = 0;
        for (int val : dp){
            max = Math.max(max , val);
        }
        return max;
    }
}