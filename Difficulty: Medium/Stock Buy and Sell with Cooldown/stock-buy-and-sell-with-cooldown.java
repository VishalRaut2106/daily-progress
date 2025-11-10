class Solution {
    public int maxProfit(int prices[]) {
        // Code here
        if(prices.length == 0) return 0 ;
        
        int n = prices.length;
        
        int hold = -prices[0];//when we buy the first stock
        int sold = 0;  //profit after sell
        int rest = 0 ; // profit when resting
        
        
        for (int i = 1 ; i < n ; i++){
            int prevSold = sold;
            sold = hold + prices[i]; //sell today
            hold = Math.max(hold , rest - prices[i]);  //buy today
            rest = Math.max(rest , prevSold);  //cooldown
        }
        return Math.max(sold ,rest);
    }
}
