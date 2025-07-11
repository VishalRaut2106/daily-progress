class Solution {
    public int trap(int[] height) {

        int left = 0;
        int right = height.length -1;
        int maxLeft = 0;
        int maxRight = 0;
        int ans= 0 ;

        while (left < right){
             maxLeft = Math.max(height[left] ,maxLeft);
            maxRight = Math.max(maxRight , height[right]);

            if(maxLeft < maxRight){
             ans +=  (maxLeft - height[left]); 
             left++;  
            }else {
                ans += (maxRight - height[right]);
                right--;
            }
        }
        return ans;
  
}}