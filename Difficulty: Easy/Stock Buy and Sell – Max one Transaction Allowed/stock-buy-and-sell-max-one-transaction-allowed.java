class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price : prices) {
            minPrice = Math.min(minPrice, price);          // best buying price 
            maxProfit = Math.max(maxProfit, price - minPrice); // best profit so far
        }

        return maxProfit;
    }
}