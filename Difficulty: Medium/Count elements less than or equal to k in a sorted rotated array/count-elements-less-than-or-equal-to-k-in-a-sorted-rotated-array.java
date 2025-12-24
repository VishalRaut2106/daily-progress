class Solution {
    
    // Find index of minimum element (pivot)
    private int findPivot(int[] arr) {
        int low = 0, high = arr.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] > arr[high]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    // Count elements <= x in sorted subarray [l..r]
    private int countLE(int[] arr, int l, int r, int x) {
        int low = l, high = r, ans = l - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] <= x) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans - l + 1;
    }

    public int countLessEqual(int[] arr, int x) {
        int n = arr.length;
        int pivot = findPivot(arr);

        int count = 0;

        // left sorted part
        count += countLE(arr, 0, pivot - 1, x);

        // right sorted part
        count += countLE(arr, pivot, n - 1, x);

        return count;
    }
}