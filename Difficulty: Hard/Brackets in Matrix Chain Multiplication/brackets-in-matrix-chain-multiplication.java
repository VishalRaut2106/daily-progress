class Solution {
    
    public String matrixChainOrder(int arr[]) {
        int n = arr.length;
        int dp[][] = new int[n][n];
        int bracket[][] = new int[n][n];

        // filling dp table
        for(int len = 2; len < n; len++){
            for(int i = 1; i < n - len + 1; i++){
                int j = i + len - 1;
                dp[i][j] = Integer.MAX_VALUE;

                for(int k = i; k < j; k++){
                    int cost = dp[i][k] + dp[k+1][j] + arr[i-1] * arr[k] * arr[j];
                    
                    if(cost < dp[i][j]){
                        dp[i][j] = cost;
                        bracket[i][j] = k;
                    }
                }
            }
        }
        
        
        nameIndex = 0;  
        return buildOrder(1, n-1, bracket);
    }

    private static int nameIndex; // reset in parent function

    private static String buildOrder(int i, int j, int bracket[][]) {
        if(i == j){
            return Character.toString((char)('A' + nameIndex++));
        }
        return "(" + buildOrder(i, bracket[i][j], bracket) 
                   + buildOrder(bracket[i][j] + 1, j, bracket) + ")";
    }
}