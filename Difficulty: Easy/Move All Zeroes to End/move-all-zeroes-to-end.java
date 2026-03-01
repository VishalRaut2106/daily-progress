class Solution {
    void pushZerosToEnd(int[] arr) {
        int idx = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                arr[idx++] = arr[i];
            }
        }
        while (idx < arr.length) {
            arr[idx++] = 0;
        }
    }
}