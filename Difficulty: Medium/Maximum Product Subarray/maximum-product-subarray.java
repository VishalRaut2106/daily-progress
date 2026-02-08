class Solution {
    int maxProduct(int[] arr) {
        int maxEnding = arr[0];
        int minEnding = arr[0];
        int ans = arr[0];

        for (int i = 1; i < arr.length; i++) {
            int curr = arr[i];

            if (curr < 0) {
                int temp = maxEnding;
                maxEnding = minEnding;
                minEnding = temp;
            }
            
            

            maxEnding = Math.max(curr, curr * maxEnding);
            minEnding = Math.min(curr, curr * minEnding);

            ans = Math.max(ans, maxEnding);
        }
        return ans;
    }
}