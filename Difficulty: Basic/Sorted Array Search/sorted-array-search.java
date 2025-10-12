class Solution {
    static boolean searchInSorted(int arr[], int k) {
        // Your code here
        for ( int  i = 0 ; i < arr.length ; i ++){
            if(arr[i] == k ){
                return true;
            }
        }
        return false;
    }
}