class Solution {
    public ArrayList<Integer> missingRange(int[] arr, int low, int high) {
        HashSet<Integer> set = new HashSet<>();
        for (int x : arr) set.add(x);

        ArrayList<Integer> res = new ArrayList<>();

        for (int i = low; i <= high; i++) {
            if (!set.contains(i)) {
                res.add(i);
            }
        }

        return res;
    }
}
