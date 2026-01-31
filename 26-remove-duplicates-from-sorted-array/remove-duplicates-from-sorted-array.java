class Solution {
    public int removeDuplicates(int[] nums) {
        // If the array is empty, return 0.
        if (nums.length == 0) return 0;

        // writePos marks where the next unique element should be placed.
        int writePos = 0;

        // readPos scans through the array to find unique elements.
        for (int readPos = 1; readPos < nums.length; readPos++) {
            // When a new unique element is found
            if (nums[readPos] != nums[writePos]) {
                writePos++;               // Move writePos forward
                nums[writePos] = nums[readPos]; // Place the unique element
            }
        }

        // Number of unique elements is writePos + 1
        return writePos + 1;
    }
}