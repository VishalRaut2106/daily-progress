class Solution {
    public int maximumLength(int[] nums) {

        int [][] dp = new int[2][2];
        int ans = 0;
        for (int num : nums){
            int x = num % 2;

            for ( int j = 0 ; j < 2; ++j){
                int y = j;
                dp[x][y]= dp [y][x] + 1;
                ans  = Math.max(ans , dp[x] [y]);
            }
        }
        return ans ; 
        
    }
}