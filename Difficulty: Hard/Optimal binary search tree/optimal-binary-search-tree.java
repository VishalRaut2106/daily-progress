class Solution {
    public int minCost(int keys[], int freq[]) {
        int n = keys.length;
        
        // prefix sum for frequency
        int[] prefix = new int[n];
        prefix[0] = freq[0];
        for(int i = 1; i < n; i++){
            prefix[i] = prefix[i - 1] + freq[i];
        }
        
        // sum function using prefix (freq[i..j])
        java.util.function.BiFunction<Integer, Integer, Integer> sum = (i, j) -> {
            if(i == 0) return prefix[j];
            return prefix[j] - prefix[i - 1];
        };

        int[][] dp = new int[n][n];
        
        // Gap Based DP
        for(int g = 0; g < n; g++){
            for(int i = 0, j = g; j < n; i++, j++){
                
                if(i == j){
                    dp[i][j] = freq[i];
                } 
                else{
                    int min = Integer.MAX_VALUE;
                    
                    for(int k = i; k <= j; k++){
                        int left = (k > i) ? dp[i][k-1] : 0;
                        int right = (k < j) ? dp[k+1][j] : 0;
                        
                        int cost = left + right + sum.apply(i, j);
                        min = Math.min(min, cost);
                    }
                    
                    dp[i][j] = min;
                }
            }
        }
        
        return dp[0][n - 1];
    }
}