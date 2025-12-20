class Solution {
    public int searchInsertK(int arr[], int k) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == k) {
                return mid;          // element found
            } else if (arr[mid] < k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        // element not found, low is the insert position
        return low;
    }
}