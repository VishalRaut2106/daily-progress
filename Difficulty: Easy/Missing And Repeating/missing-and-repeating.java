class Solution {
    ArrayList<Integer> findTwoElement(int arr[]) {
        int n = arr.length;
        int repeating = -1, missing = -1;

        // repeating number
        for (int i = 0; i < n; i++) {
            int idx = Math.abs(arr[i]) - 1;

            if (arr[idx] < 0) {
                // Already visited → repeating number found
                repeating = Math.abs(arr[i]);
            } else {
                arr[idx] = -arr[idx];
            }
        }

        
        for (int i = 0; i < n; i++) {
            if (arr[i] > 0) {
                missing = i + 1;
                break;
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(repeating);
        ans.add(missing);
        return ans;
    }
}