class Solution {
  public int majorityElement(int[] nums) {
    if (nums == null || nums.length == 0) return -1;

    int candidate = 0;
    int count = 0;
    for (int num : nums) {
      if (count == 0) candidate = num;
      count += (num == candidate) ? 1 : -1;
    }

    // verify candidate
    int freq = 0;
    for (int num : nums) if (num == candidate) freq++;
    return (freq > nums.length / 2) ? candidate : -1;
  }
}