class Solution {
    public int countHillValley(int[] nums) {

        int  n  = nums.length;
        int count = 0;

        for ( int i = 1; i < n - 1; i++){
            if (nums[i] == nums[i - 1]){
                continue;
            }
            // find left
            int left = i - 1;
            while (left >= 0 && nums[left] ==nums[i]){
                left--;
            }
            // find right
            int right = i + 1;
            while (right < n && nums[right] ==nums[i]){
                right++;
            }

            if (left >= 0 && right <n){
                if ((nums[left] < nums[i] && nums[i] > nums[right]) ||
                 (nums[left]> nums[i] && nums[i]<nums[right])){
                    count++;
                }
            }
        }
    return count;
        
       
    }
}