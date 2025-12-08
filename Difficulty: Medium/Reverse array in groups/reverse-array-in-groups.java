class Solution {
    public void reverseInGroups(int[] arr, int k) {
        int n = arr.length;

        for(int i = 0; i < n; i += k) {
            int start = i;
            int end = i + k - 1;

            if(end >= n )end = n - 1;
            
            
            
            for (int  l = start, r= end; l<r; l++, r--){
                int temp = arr[l];
                arr[l]= arr[r];
                arr[r]= temp;
            }
        }
    }}