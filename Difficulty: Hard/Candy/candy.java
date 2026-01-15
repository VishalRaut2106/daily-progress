class Solution {
    public int minCandy(int arr[]) {
        int n = arr.length;
        int[] candies = new int[n];

        //Everyone gets at least 1 candy
        for (int i = 0; i < n; i++) {
            candies[i] = 1;
        }

        //  Left to Right
        for (int i = 1; i < n; i++) {
            if (arr[i] > arr[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }

        // Right to Left
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] > arr[i + 1]) {
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
        }

        // Sum
        int total = 0;
        for (int c : candies) {
            total += c;
        }

        return total;
    }
}