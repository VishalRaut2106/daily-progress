class Solution {
    public long subarrayXor(int arr[], int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        long count = 0;
        int xor = 0;

        for (int val : arr) {
            xor ^= val;

            int target = xor ^ k;
            if (map.containsKey(target)) {
                count += map.get(target);
            }

            map.put(xor, map.getOrDefault(xor, 0) + 1);
        }
        return count;
    }
}